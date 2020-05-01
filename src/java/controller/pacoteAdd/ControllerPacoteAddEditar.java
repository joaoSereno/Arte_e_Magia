/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pacoteAdd;

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
@WebServlet("/paginasDeCadastro/cadastroPacoteAdicional/editarPacoteAdicional")
public class ControllerPacoteAddEditar extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //pega o idTipoPacoteAdicional da página
        String idTipoPacoteAdicional = request.getParameter("idTipoPacoteAdicional");
        int idTipoPacoteAdicional2 = Integer.parseInt(idTipoPacoteAdicional);
        
        //pega descricao do pacote add
        String descricaoPacoteAdd = request.getParameter("descricaoPacoteAdd");

        //atribui no request para enviar para a página
        request.setAttribute("idTipoPacoteAdicionalE", idTipoPacoteAdicional2);
        request.setAttribute("descricaoPacoteAddE", descricaoPacoteAdd);
        request.getRequestDispatcher("pacoteAdicionalPrincipal.jsp").forward(request, response); //dispara para a página
        
    }    
    
}
