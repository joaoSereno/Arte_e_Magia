/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlller.acessoFunc;

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
@WebServlet("/resumoEventoFunc")
public class resumoEventoFunc extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario2 = 0;
        
        String idUsuario = request.getParameter("idUsuario");
        if (idUsuario != null) {
            
            if (!idUsuario.equals("")) {

                idUsuario2 = Integer.parseInt(idUsuario);
                
            }
            
        }
        
        String nomeUsuario = request.getParameter("nomeUsuario");

        request.setAttribute("idUsuario", idUsuario2);
        request.setAttribute("nomeUsuario", nomeUsuario);
        
    }   
        
}
