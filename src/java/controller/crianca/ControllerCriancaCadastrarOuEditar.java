/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.crianca;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeClientes/editarORcadastrarCrianca")
public class ControllerCriancaCadastrarOuEditar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCrianca2 = 0;

        //pegando valores do formulario que chamou o controller
        String idCliente = request.getParameter("idClienteCrianca");
        int idCliente2 = Integer.parseInt(idCliente);

        String idCrianca = request.getParameter("idCrianca");
        if (idCrianca != null) {
            idCrianca2 = Integer.parseInt(idCrianca);
        }
        String nomeCrianca = request.getParameter("nomeCrianca");
        String sexo = request.getParameter("sexo");
        String dataNascimento = request.getParameter("dataNascimento");

        //set de atributo para outra página
        request.setAttribute("idClienteE", idCliente2);
        if (idCrianca != null) {
            request.setAttribute("idCriancaE", idCrianca2);
        }
        if (nomeCrianca != null) {
            request.setAttribute("nomeCriancaE", nomeCrianca);
        }
        if (sexo != null) {
            request.setAttribute("sexoE", sexo);           
        }
        if (dataNascimento != null) {
            request.setAttribute("dataNascimentoE", dataNascimento);
        }

        //dispara os atributos setados para outra página
        request.getRequestDispatcher("criancaEditarOuCadastrar.jsp").forward(request, response);
    }
}
