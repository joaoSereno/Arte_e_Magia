/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoDespesa;

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
@WebServlet("/paginasDeCadastro/cadastroTipoDespesa/tipoDespesaEditar")
public class ControllerTipoDespesaEditar extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //pega o idTipoDeDespesa da página
        String idTipoDeDespesa = request.getParameter("idTipoDeDespesa");
        int idTipoDeDespesa2 = Integer.parseInt(idTipoDeDespesa);

        String nomeDespesa = request.getParameter("nomeDespesa");

        //atribui no request para enviar para a página
        request.setAttribute("idTipoDeDespesaE", idTipoDeDespesa2);
        request.setAttribute("nomeDespesaE", nomeDespesa);
        request.getRequestDispatcher("tipoDespesaPrincipal.jsp").forward(request, response); //dispara para a página

    }    
    
}
