/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoDespesa;

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
@WebServlet("/paginasDeCadastro/cadastroTipoDespesa/tipoDespesaListar")
public class ControllerTipoDespesaListar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL(); //instancia a classe de comunicação com o banco de dados 

        List<TipoDeDespesa> listaTipoDeDespesa; //lista que vai receber os dados do tipo de despesa

        try {

            listaTipoDeDespesa = tipoDespesaBanco.getTipoDeDespesa(); // recebe na lista os listaTipoDeDespesa pelo método de get do banco 
            request.setAttribute("listaTipoDespesa", listaTipoDeDespesa); // atribui a lista na marcação "listaTipoDespesa"
            request.getRequestDispatcher("tipoDespesaPrincipal.jsp").forward(request, response);// dispara para essa página

        } catch (Exception ex) {
            Logger.getLogger(ControllerTipoDespesaListar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
}
