/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cliente;

import entidades.TipoDeFesta;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.TipoDeFestaSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeClientes/listarTipoDeFestaNoCadastroCliente")
public class ControllerListaTFnoCliente extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<TipoDeFesta> listaTipoDeFesta; //lista que vai receber os dados do tipo de festa
        
        TipoDeFestaSQL tipoDeFestaBanco = new TipoDeFestaSQL();

        try {
            
            listaTipoDeFesta = tipoDeFestaBanco.getTipoDeFesta();
            
            request.setAttribute("listaTipoDeFesta", listaTipoDeFesta); // atribui a lista na marcação "listaTipoDeFesta"
            
            request.getRequestDispatcher("clienteCadastrar.jsp").forward(request, response); // dispara para essa página
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerListaTFnoCliente.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
    }
    
}
