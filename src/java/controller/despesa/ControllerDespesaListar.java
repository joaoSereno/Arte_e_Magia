/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.despesa;

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

@WebServlet("/paginasDeCadastro/cadastroDeDespesa/listarDespesas")
public class ControllerDespesaListar extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int origem2 = 0; //1 = cadastro de despesas ----  2 = cadastro de festas
        int exibir2 = 0; // 1 = abertas ---  2 = fechadas  --- 3 = todas
        
        String origem = request.getParameter("origem");
        if (origem != null) {

            if (!origem.equals("")) {
                origem2 = Integer.parseInt(origem);
            }

        }   

        String exibir = request.getParameter("exibir");
        if (exibir != null) {

            if (!exibir.equals("")) {
                exibir2 = Integer.parseInt(exibir);
            }

        }   

        
        
        
    } 
}
