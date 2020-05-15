/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.usuario;

import entidades.Funcionario;
import entidades.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.FuncionarioSQL;
import persistence.UsuarioSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeUsuario/cadastrarUsuario")
public class ControllerUsuarioCadastrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //variaveis que serão utilizadas
        int idFuncionario2 = 0; //ifFuncionario (servira para definir se vai ser cadastro do tipo ADM ou FUNC
        int valorDisplay = 0;  //caso o cadastro for do tipo FUNC, vai enviar o valorDisplay = 1 que faz o js entender que o cadastro é do tipo FUNC
        boolean naoDeveCadastrar = false; // caso caia na condição de algum tratamento, servirá para não executar os próximos passos
        String msg = ""; //msg de retorno do cadastro
        List<Usuario> listaUsuario = null; //lista utilizada para verificar se o usuário já existe
        List<Funcionario> listaFuncionario = null; //lista que vai receber os dados do funcionario

        UsuarioSQL usuarioBanco = new UsuarioSQL(); //instanciando classe de comunicação com o banco de dados
        FuncionarioSQL funcionarioBanco = new FuncionarioSQL(); //instancia a classe de comunicação com o banco de dados de funcionario

        //pega os parametros do form
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String confirmacaoSenha = request.getParameter("confirmacaoSenha");

        String idFuncionario = request.getParameter("idFuncionario");
        if (idFuncionario != null) { //caso for cadastro do tipo FUNC

            if (!idFuncionario.equals("")) {

                idFuncionario2 = Integer.parseInt(idFuncionario);

                //para continuar listando os funcionarios 
                valorDisplay = 1;
                request.setAttribute("valorDisplay", valorDisplay);

            }

        }
        
        String nomeUsuario = request.getParameter("nomeUsuario");
        

        //valida se o campo senha é igual ao campo confirmação de senha
        if (!senha.equals(confirmacaoSenha)) {

            naoDeveCadastrar = true; // seta true para não executar proximos passos

            msg = "A senha e a confirmação de senha devem ser iguais!";
            
            

            //para continuar listando os funcionarios caso errar a confirmação de senha
            if (idFuncionario2 != 0) {

                try {

                    listaFuncionario = funcionarioBanco.getFuncionarioNaoTemUsuario(); // recebe na lista os funcionarios pelo método de get do banco
                    request.setAttribute("funcionarios", listaFuncionario);

                } catch (Exception ex) {

                    Logger.getLogger(ControllerUsuarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);

                }

            }

            request.setAttribute("msg", msg);
            request.setAttribute("login", login);

            //dispara os atributos setados para outra página
            request.getRequestDispatcher("usuarioCadastrar.jsp").forward(request, response);
        }

        //caso as senhas sejam compativeis , vai verificar se já existe o usuário
        if (naoDeveCadastrar != true) {

            try {

                listaUsuario = usuarioBanco.getUsuario(); //recebendo lista de usuarios existentes, para validar se o usuario inserido já existe

                //laço na lista de usuario existentes recebidas pelo banho
                for (int i = 0; i < listaUsuario.size(); i++) {

                    //se encontrar um usuário já existente entra dentro do if
                    if (listaUsuario.get(i).getUsuario().equals(login)) {
                        i = listaUsuario.size(); //seta o i para o tamanho da lista , para não ficar executando o laço
                        naoDeveCadastrar = true; //como o usuário já existe, seta o valor de não cadastravel para true

                        if (idFuncionario2 != 0) { //se o cadastro for de funcionario

                            // recebe na lista os funcionarios pelo método de get do banco, para jogar em tela novamente
                            listaFuncionario = funcionarioBanco.getFuncionarioNaoTemUsuario();
                            request.setAttribute("funcionarios", listaFuncionario);

                        }

                        msg = "O login '" + login + "' já está sendo utilizado por outro usuário. Por favor utilize outro login!";
                        

                        request.setAttribute("msg", msg);

                        //dispara os atributos setados para outra página
                        request.getRequestDispatcher("usuarioCadastrar.jsp").forward(request, response);
                    }

                }

            } catch (Exception ex) {

                Logger.getLogger(ControllerUsuarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

        //caso a senha sejam compativeis e não exista o usuário no banco
        if (naoDeveCadastrar != true) {

            Usuario usuario = new Usuario(); //instancia do tipo usuario , para passar de parametro no método de cadastrar do banco

            if (idFuncionario2 != 0) { //se for cadastro de conta tipo FUNC
                
                Funcionario funcionario = new Funcionario(); //instanciando classe do funcionario, para receber os dados do banco do método funcionario especifico
                
                try {
                    funcionario = funcionarioBanco.getFuncionarioEspecifico(idFuncionario2); //recebendo do banco os dados do funcionario que foi selecionado no cadastro
                } catch (Exception ex) {
                    Logger.getLogger(ControllerUsuarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //setando os parametros pegos pelo usuario na instancia do tipo usuario
                usuario.setUsuario(login);
                usuario.setSenha(senha);
                usuario.setIdFuncionario(idFuncionario2);
                usuario.setNomeUsuario(funcionario.getNomeFuncionario());

                try {
                    //chamando método que faz o cadastro no banco, passando como parametro a instancia do tipo usuario
                    usuarioBanco.create(usuario);

                    //para continuar listando os usuários disponiveis em tela, caso o usuário queira continuar cadastrando
                    listaFuncionario = funcionarioBanco.getFuncionarioNaoTemUsuario();
                    request.setAttribute("funcionarios", listaFuncionario);
                    
                    msg = "Cadastro de usuário realizado com sucesso!";

                } catch (Exception ex) {
                    Logger.getLogger(ControllerUsuarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else { //se for cadastro de conta tipo ADM

                //setando os parametros pegos pelo usuario na instancia do tipo usuario
                usuario.setUsuario(login);
                usuario.setSenha(senha);
                usuario.setNomeUsuario(nomeUsuario);
                
                try {
                    //chamando método que faz o cadastro no banco, passando como parametro a instancia do tipo usuario
                    usuarioBanco.create(usuario);
                    msg = "Cadastro de usuário realizado com sucesso!";

                } catch (Exception ex) {
                    Logger.getLogger(ControllerUsuarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            //dispara os atributos setados para outra página
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("usuarioCadastrar.jsp").forward(request, response);

        }

    }

}
