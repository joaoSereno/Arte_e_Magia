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
        int idFuncionario2 = 0;
        String msg = "";
        int valorDisplay = 0;
        List<Usuario> listaUsuario = null;
        int contador = 0;

        UsuarioSQL usuarioBanco = new UsuarioSQL(); //instanciando classe de comunicação com o banco de dados

        //pega os parametros do form
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String confirmacaoSenha = request.getParameter("confirmacaoSenha");

        String idFuncionario = request.getParameter("idFuncionario");
        if (idFuncionario != null) {

            if (!idFuncionario.equals("")) {

                idFuncionario2 = Integer.parseInt(idFuncionario);

                //para continuar listando os funcionarios 
                valorDisplay = 1;
                request.setAttribute("valorDisplay", valorDisplay);

            }

        }

        //valida se o campo senha é igual ao campo confirmação de senha
        if (!senha.equals(confirmacaoSenha)) {

            msg = "Senha e confirmação de senha não iguais!";

            //para continuar listando os funcionarios caso errar a confirmação de senha
            if (idFuncionario2 != 0) {

                FuncionarioSQL funcionarioBanco = new FuncionarioSQL(); //instancia a classe de comunicação com o banco de dados de funcionario
                List<Funcionario> listaFuncionario; //lista que vai receber os dados do funcionario

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

        try {

            //recebendo lista de usuarios existentes, para validar se o usuario inserido já existe
            listaUsuario = usuarioBanco.getUsuario();

            //laço na lista de usuario existentes
            for (int i = 0; i < listaUsuario.size(); i++) {

                //verifica se já existe o usuario, caso existir não cadastra
                if (listaUsuario.get(i).getUsuario().equals(login)) {
                    i = listaUsuario.size();
                    contador = 1;

                    msg = "O login '" + login + "' já existe! Por favor utilize outro!";

                    request.setAttribute("msg", msg);

                    //dispara os atributos setados para outra página
                    request.getRequestDispatcher("usuarioCadastrar.jsp").forward(request, response);
                }

            }

            if (contador != 1) { //verifica se passou pela validação de usuario iguais

                //verifica se é cadastro de usuario é ADM ou FUNC
                if (idFuncionario2 != 0) {

                } else {

                }

            }

        } catch (Exception ex) {

            Logger.getLogger(ControllerUsuarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
