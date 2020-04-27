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
@WebServlet("/paginasDeCadastro/cadastroDeUsuario/usuarioEditar2")
public class ControllerUsuarioEditar2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        int idFuncionario2 = 0;
        int idUsuario2 = 0;
        int valorDisplay2 = 0;
        boolean usuarioJaExiste = false; //varivel que vai ser a condição para poder editar o usuário
        List<Usuario> listaUsuario = null; //lista utilizada para verificar se o usuário já existe
        List<Funcionario> listaFuncionario = null; //lista que vai receber os dados do funcionario

        //pegando os valores da recebidos pelo usuario na tela
        String idUsuario = request.getParameter("idusuario");
        if (idUsuario != null) { //se for cadastro do tipo FUNC
            if (!idUsuario.equals("")) {
                idUsuario2 = Integer.parseInt(idUsuario);
            }
        }

        String login = request.getParameter("login");
        String loginAtual = request.getParameter("loginAtual");
        String nomeUsuario = request.getParameter("nomeUsuario");

        String valorDisplay = request.getParameter("valorDisplay");
        if (valorDisplay != null) { //se for cadastro do tipo FUNC
            if (!valorDisplay.equals("")) {
                valorDisplay2 = Integer.parseInt(valorDisplay);
            }
        }

        String idFuncionario = request.getParameter("idFuncionario");
        if (idFuncionario != null) { //se for cadastro do tipo FUNC
            if (!idFuncionario.equals("")) {
                idFuncionario2 = Integer.parseInt(idFuncionario);
            }
        }

        if (idUsuario2 != 0) { //se tiver usuario

            UsuarioSQL usuarioBanco = new UsuarioSQL(); //instanciando classe de comunicação com o banco  de dados

            try {
                if (!loginAtual.equals(login)) {
                    listaUsuario = usuarioBanco.getUsuario(); //recebendo lista de usuarios existentes, para validar se o usuario inserido já existe

                    //laço na lista de usuario existentes recebidas pelo banco 
                    for (int i = 0; i < listaUsuario.size(); i++) {
                        //se encontrar um usuário já existente entra dentro do if
                        if (listaUsuario.get(i).getUsuario().equals(login)) {
                            i = listaUsuario.size(); //seta o i para o tamanho da lista , para não ficar executando o laço
                            usuarioJaExiste = true; //como o usuário já existe, seta o valor de não cadastravel para true

                            msg = "O login '" + login + "' já existe! Por favor utilize outro!";

                        }
                    }
                }

            } catch (Exception ex) {
                Logger.getLogger(ControllerUsuarioEditar2.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (idFuncionario2 != 0) { //se for cadastro tipo FUNC

                FuncionarioSQL funcionarioBanco = new FuncionarioSQL();//classe de comunicação com o banco  de dados para funcionario
                Funcionario funcionarioDoUsuario = new Funcionario();

                Usuario usuario = new Usuario(idUsuario2, login, idFuncionario2, nomeUsuario); //instanciando classe usuario 

                try {
                    
                    funcionarioDoUsuario = funcionarioBanco.getFuncionarioEspecifico(usuario.getIdFuncionario()); //recebe na instancia funcionario, o funcionario do usuario       
                    
                    usuario.setNomeUsuario(funcionarioDoUsuario.getNomeFuncionario()); //setando o nome do funcionario como o nome do usuario
                    
                } catch (Exception ex) {
                    Logger.getLogger(ControllerUsuarioEditar2.class.getName()).log(Level.SEVERE, null, ex);
                }

                //se o usuário colocou login que não existe
                if (usuarioJaExiste == false) {

                    try {
                        usuarioBanco.editarUsuario(usuario); //chama método de update do banco e passa o usuario como parametro
                        listaFuncionario = funcionarioBanco.getFuncionarioNaoTemUsuario(); // recebe na lista os funcionarios pelo método de get do banco

                        request.setAttribute("funcionarioDoUsuario", funcionarioDoUsuario);
                        request.setAttribute("listaFuncionario", listaFuncionario);
                        msg = "Usuário editado com sucesso!";

                    } catch (Exception ex) {
                        Logger.getLogger(ControllerUsuarioEditar2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {

                    try {

                        funcionarioDoUsuario = funcionarioBanco.getFuncionarioEspecifico(usuario.getIdFuncionario()); //recebe na instancia funcionario, o funcionario do usuario
                        listaFuncionario = funcionarioBanco.getFuncionarioNaoTemUsuario(); // recebe na lista os funcionarios pelo método de get do banco

                        request.setAttribute("funcionarioDoUsuario", funcionarioDoUsuario);
                        request.setAttribute("listaFuncionario", listaFuncionario);

                        usuario.setUsuario(loginAtual);

                    } catch (Exception ex) {
                        Logger.getLogger(ControllerUsuarioEditar2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                //setando usuário editado que será jogados para outra página
                request.setAttribute("usuario", usuario);

            } else { //se for tipo ADM

                Usuario usuario = new Usuario(idUsuario2, login, nomeUsuario); //instanciando classe usuario 

                //se o usuário colocou login que não existe
                if (usuarioJaExiste == false) {

                    try {

                        usuarioBanco.editarUsuario(usuario); //chama método de update do banco e passa o usuario como parametro

                        msg = "Usuário editado com sucesso!";

                    } catch (Exception ex) {
                        Logger.getLogger(ControllerUsuarioEditar2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    usuario.setUsuario(loginAtual);
                }

                //setando usuário editado que será jogados para outra página
                request.setAttribute("usuario", usuario);
            }

            //setando atributos que será jogados para outra página
            request.setAttribute("valorDisplay", valorDisplay2); //controle para mostrar listar de funcionario ou não         
            request.setAttribute("msg", msg);

            //dispachando para a página
            request.getRequestDispatcher("usuarioEditar.jsp").forward(request, response);

        } else { //se não tiver usuário

            //setando atributos que será jogados para outra página
            request.setAttribute("valorDisplay2", valorDisplay2);

            //dispachando para a página
            request.getRequestDispatcher("usuarioEditar.jsp").forward(request, response);
        }

    }

}
