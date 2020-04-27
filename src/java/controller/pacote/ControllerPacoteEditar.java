/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pacote;

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
@WebServlet("/paginasDeCadastro/cadastroDePacote/pacoteEditar")
public class ControllerPacoteEditar extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //pega o idFormaPagamento da página
        String idPacote = request.getParameter("idPacote");
        int idPacote2 = Integer.parseInt(idPacote);

        String nomePacote = request.getParameter("nomePacote"); 
        String valorPacoteVenda = request.getParameter("valorPacoteVenda");        
                
        //atribui no request para enviar para a página
        request.setAttribute("idPacoteE", idPacote2);
        request.setAttribute("nomePacoteE", nomePacote);
        request.setAttribute("valorPacoteVendaE", valorPacoteVenda);
        request.getRequestDispatcher("pacotePrincipal.jsp").forward(request, response); //dispara para a página

    }    
    
}
