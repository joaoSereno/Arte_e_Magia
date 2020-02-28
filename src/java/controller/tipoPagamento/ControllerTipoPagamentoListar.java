/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoPagamento;

import entidades.FormaPagamento;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.TipoPagamentoSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroTipoPagamento/tipoPagamentoListar")
public class ControllerTipoPagamentoListar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoPagamentoSQL tipoPagamentoBanco = new TipoPagamentoSQL(); //instancia a classe de comunicação com o banco de dados 

        List<FormaPagamento> listaTipoPagamento; //lista que vai receber os dados do tipo de pagamento

        try {

            listaTipoPagamento = tipoPagamentoBanco.getFormaPagamento(); // recebe na lista os listaTipoPagamento pelo método de get do banco 
            request.setAttribute("listaTipoPagamento", listaTipoPagamento); // atribui a lista na marcação "listaTipoPagamento"
            request.getRequestDispatcher("tipoPagamentoPrincipal.jsp").forward(request, response);// dispara para essa página

        } catch (Exception ex) {
            Logger.getLogger(ControllerTipoPagamentoListar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
    
}
