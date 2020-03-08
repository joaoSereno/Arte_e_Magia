/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.despesa;

import entidades.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João Pedro
 */

@WebServlet("/paginasDeCadastro/cadastroDeDespesa/teste")
public class teste extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int a = 1;
        
        List<Integer> qtdDespesa = null; //lista que vai receber os dados do cliente
        
        
        
        request.setAttribute("qtdDespesa", qtdDespesa);
        request.getRequestDispatcher("despesaCadastrar.jsp").forward(request, response);
        
    }
    
}
