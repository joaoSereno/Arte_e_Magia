/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pacote;

import entidades.Pacote;
import java.io.IOException;
import java.text.DecimalFormat;
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
@WebServlet("/paginasDeCadastro/cadastroDePacote/pacoteEditar")
public class ControllerPacoteEditar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PacoteSQL pacoteBanco = new PacoteSQL(); //instancia a classe de comunicação com o banco de dados 
        List<Pacote> listaPacotes; //lista que vai receber os dados do Pacote

        //pega o idFormaPagamento da página
        String idPacote = request.getParameter("idPacote");
        int idPacote2 = Integer.parseInt(idPacote);

        String nomePacote = request.getParameter("nomePacote");

        float valorPacoteVenda2 = 0;
        String valorPacoteVenda = request.getParameter("valorPacoteVenda");
        if (valorPacoteVenda != null) {

            if (!valorPacoteVenda.equals("")) {
                valorPacoteVenda2 = Float.parseFloat(valorPacoteVenda);
            }

        }

        DecimalFormat formatter = new DecimalFormat("#.00");
        String valorPacoteVenda3 = formatter.format(valorPacoteVenda2);
        valorPacoteVenda3 = valorPacoteVenda3.replace(',', '.');

        try {
            
            listaPacotes = pacoteBanco.getPacote(); // recebe na lista os listaPacote pelo método de get do banco 

            request.setAttribute("controllerListagemPacote", 1);
            request.setAttribute("listaPacotes", listaPacotes); // atribui a lista na marcação "listaPacotes"
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerPacoteEditar.class.getName()).log(Level.SEVERE, null, ex);
        }

        //atribui no request para enviar para a página
        request.setAttribute("idPacoteE", idPacote2);
        request.setAttribute("nomePacoteE", nomePacote);
        request.setAttribute("valorPacoteVendaE", valorPacoteVenda3);
        request.getRequestDispatcher( "pacotePrincipal.jsp").forward(request, response); //dispara para a página

    }

}
