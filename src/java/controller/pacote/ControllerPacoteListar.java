/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pacote;

import controller.tipoPagamento.ControllerTipoPagamentoListar;
import entidades.Pacote;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PacoteSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDePacote/pacoteListar")
public class ControllerPacoteListar extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PacoteSQL pacoteBanco = new PacoteSQL(); //instancia a classe de comunicação com o banco de dados 

        List<Pacote> listaPacotes; //lista que vai receber os dados do Pacote

        try {
            
            listaPacotes = pacoteBanco.getPacote(); // recebe na lista os listaPacote pelo método de get do banco 
            request.setAttribute("listaPacotes", listaPacotes); // atribui a lista na marcação "listaPacotes"
            request.getRequestDispatcher("pacotePrincipal.jsp").forward(request, response);// dispara para essa página

        } catch (Exception ex) {
            Logger.getLogger(ControllerPacoteListar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
}
