/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.despesa;

import entidades.TipoDeDespesa;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.TipoDespesaSQL;

/**
 *
 * @author João Pedro
 */

@WebServlet("/paginasDeCadastro/cadastroDeDespesa/listarTipoDespesa")
public class ControllerListaTDnaDespesa extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int valorDisplay = 1;
        List<TipoDeDespesa> listaTipoDespesas; //lista que vai receber os dados do tipo de despesas
        
        TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL();
        
        try {
            
            listaTipoDespesas = tipoDespesaBanco.getTipoDeDespesa();
            
            request.setAttribute("valorDisplay", valorDisplay);
            request.setAttribute("listaTipoDespesas", listaTipoDespesas); // atribui a lista na marcação "listaTipoDespesas"
            
            request.getRequestDispatcher("despesaCadastrar.jsp").forward(request, response); // dispara para essa página
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerListaTDnaDespesa.class.getName()).log(Level.SEVERE, null, ex);    
        }
    }
    
}
