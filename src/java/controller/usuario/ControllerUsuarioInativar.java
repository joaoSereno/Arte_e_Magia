/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.usuario;

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
@WebServlet("/paginasDeCadastro/cadastroDeUsuario/inativarUsuario")
public class ControllerUsuarioInativar extends HttpServlet {

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

        if (idUsuario2 != 0) { //se existir usuário

            UsuarioSQL usuarioBanco = new UsuarioSQL();//instanciando classe de comunicação com o banco de dados

            try {

                usuarioBanco.inativaUsuario(idUsuario2);//chamando método que inativa a conta, passando o idUsuario como parametro

                msg = "Cadastro excluído com sucesso!";

                request.setAttribute("msg", msg);
                request.setAttribute("valorDisplay", valorDisplay2);

                request.getRequestDispatcher("usuarioEditar.jsp").forward(request, response);

            } catch (Exception ex) {
                Logger.getLogger(ControllerUsuarioInativar.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {//se não existir usuario, só despacha de volta para a página

            request.getRequestDispatcher("usuarioEditar.jsp").forward(request, response);

        }
    }

}
