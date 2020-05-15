/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.usuario;

import entidades.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.UsuarioSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeUsuario/trocarSenhaUsuario")
public class ControllerTrocarSenhaUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario2 = 0;
        int valorDisplay2 = 0;

        //pega os parametros do form
        String idUsuario = request.getParameter("idUsuario");
        if (idUsuario != null) {
            if (!idUsuario.equals("")) {

                idUsuario2 = Integer.parseInt(idUsuario);

            }
        }

        String valorDisplay = request.getParameter("valorDisplay");
        if (valorDisplay != null) { //se for cadastro do tipo FUNC
            if (!valorDisplay.equals("")) {
                valorDisplay2 = Integer.parseInt(valorDisplay);
            }
        }

        if (idUsuario2 != 0) { //se existir usuario

            UsuarioSQL usuarioBanco = new UsuarioSQL(); //instanciando classe que faz comunicação do banco de dados
            Usuario usuario = new Usuario();//instanciando classe do tipo usuario

            try {

                usuario = usuarioBanco.getUsuarioEspecifico(idUsuario2);

            } catch (Exception ex) {

                Logger.getLogger(ControllerTrocarSenhaUsuario.class.getName()).log(Level.SEVERE, null, ex);

            }

            //setando usuário editado que será jogados para outra página
            request.setAttribute("idUsuario", usuario.getIdusuario());
            request.setAttribute("valorDisplay", valorDisplay2);

            request.getRequestDispatcher("usuarioSenha.jsp").forward(request, response);

        } else { //se não existir usuario, só despacha de volta para a página

            request.getRequestDispatcher("usuarioEditar.jsp").forward(request, response);

        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario2 = 0;
        int valorDisplay2 = 0;
        String msg = "";

        //pega os parametros do form
        String idUsuario = request.getParameter("idUsuario");
        if (idUsuario != null) {
            if (!idUsuario.equals("")) {

                idUsuario2 = Integer.parseInt(idUsuario);

            }
        }

        String valorDisplay = request.getParameter("valorDisplay");
        if (valorDisplay != null) { //se for cadastro do tipo FUNC
            if (!valorDisplay.equals("")) {
                valorDisplay2 = Integer.parseInt(valorDisplay);
            }
        }

        String senha = request.getParameter("senha");
        String confirmacaoDeSenha = request.getParameter("confirmacaoDeSenha");

        if (idUsuario2 != 0) { //se existir usuário

            if (!senha.equals("")) { //se a senha for diferente de vazia

                if (senha.equals(confirmacaoDeSenha)) {//se a senha de confirmação e senha forem iguais

                    UsuarioSQL usuarioBanco = new UsuarioSQL();//instanciando classe de comunicação com o banco de dados

                    try {

                        usuarioBanco.novaSenha(idUsuario2, senha); //chama método que realiza a alteração na senha do usuario

                        msg = "Senha alterada com sucesso!";

                        //setando usuário editado que será jogados para outra página
                        request.setAttribute("idUsuario", idUsuario2);
                        request.setAttribute("valorDisplay", valorDisplay2);
                        request.setAttribute("msg", msg);

                        request.getRequestDispatcher("usuarioSenha.jsp").forward(request, response);
                        
                    } catch (Exception ex) {
                        Logger.getLogger(ControllerTrocarSenhaUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else { //se não igual

                    msg = "A senha e a confirmação de senha devem ser iguais!";

                    //setando usuário editado que será jogados para outra página
                    request.setAttribute("idUsuario", idUsuario2);
                    request.setAttribute("valorDisplay", valorDisplay2);
                    request.setAttribute("msg", msg);

                    request.getRequestDispatcher("usuarioSenha.jsp").forward(request, response);
                }

            } else { //se não for diferente de vazia

                msg = "Senha não pode ser em branco";

                //setando usuário editado que será jogados para outra página
                request.setAttribute("idUsuario", idUsuario2);
                request.setAttribute("valorDisplay", valorDisplay2);
                request.setAttribute("msg", msg);

                request.getRequestDispatcher("usuarioSenha.jsp").forward(request, response);
            }

        } else {//se não existir usuario, só despacha de volta para a página

            request.getRequestDispatcher("usuarioEditar.jsp").forward(request, response);

        }
    }

}
