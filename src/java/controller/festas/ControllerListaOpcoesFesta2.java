/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.festas;

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
@WebServlet("/paginasDeCadastro/cadastroDeFesta/listarOpcoes2")
public class ControllerListaOpcoesFesta2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int countCliente2 = 0;
        int idCliente2 = 0;
        
        String countCliente = request.getParameter("countCliente");
        if (countCliente != null) {

            if (!countCliente.equals("")) {

                countCliente2 = Integer.parseInt(countCliente);

                request.setAttribute("countCliente", countCliente2);

            }

        }

        String idCliente = request.getParameter("idCliente");
        if (idCliente != null) {

            if (!idCliente.equals("")) {

                idCliente2 = Integer.parseInt(idCliente);

            }

        }  
        
        String nomeCliente = request.getParameter("nomeCliente");
               
        
        if(countCliente2 == 0){ //se é a primeira vez que vai selecionar cliente
            countCliente2 = 1;
            
            request.setAttribute("countCliente", countCliente2);
            request.setAttribute("nomeCliente", nomeCliente);
            request.setAttribute("idCliente", idCliente2);
            
            request.getRequestDispatcher("festaCadastrar.jsp").forward(request, response);
            
        }else{ //se não é
            
            
        }
        
    }
    
}
