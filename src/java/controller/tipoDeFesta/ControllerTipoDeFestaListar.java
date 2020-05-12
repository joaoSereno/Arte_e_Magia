/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoDeFesta;

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
@WebServlet("/paginasDeCadastro/cadastroTipoDeFesta/listarTipoDeFesta")
public class ControllerTipoDeFestaListar extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TipoDeFestaSQL tipoDeFestaBanco = new TipoDeFestaSQL(); //instancia a classe de comunicação com o banco de dados 

        List<TipoDeFesta> listaTipoDeFesta; //lista que vai receber os dados do tipo de festa

        try {

            listaTipoDeFesta = tipoDeFestaBanco.getTipoDeFesta();
            request.setAttribute("listaTipoDeFesta", listaTipoDeFesta); 
            request.setAttribute("controllerListagemTipoDeFesta", 1); 
            
            request.getRequestDispatcher("tipoDeFestaPrincipal.jsp").forward(request, response);// dispara para essa página

        } catch (Exception ex) {
            Logger.getLogger(ControllerTipoDeFestaListar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
        
    }
    
}
