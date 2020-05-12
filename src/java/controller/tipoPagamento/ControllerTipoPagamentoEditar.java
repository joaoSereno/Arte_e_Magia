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
@WebServlet("/paginasDeCadastro/cadastroTipoPagamento/tipoPagamentoEditar")
public class ControllerTipoPagamentoEditar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoPagamentoSQL tipoPagamentoBanco = new TipoPagamentoSQL(); //instancia a classe de comunicação com o banco de dados 
        List<FormaPagamento> listaTipoPagamento; //lista que vai receber os dados do tipo de pagamento
        
        //pega o idFormaPagamento da página
        String idFormaPagamento = request.getParameter("idFormaPagamento");
        int idFormaPagamento2 = Integer.parseInt(idFormaPagamento);

        String nomePagamento = request.getParameter("nomePagamento");

        try {
            listaTipoPagamento = tipoPagamentoBanco.getFormaPagamento(); // recebe na lista os listaTipoPagamento pelo método de get do banco 
            
            request.setAttribute("controllerListagemTipoDePagamento", 1);
            request.setAttribute("listaTipoPagamento", listaTipoPagamento);
        } catch (Exception ex) {
            Logger.getLogger(ControllerTipoPagamentoEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
            
              
        //atribui no request para enviar para a página
        request.setAttribute("idFormaPagamentoE", idFormaPagamento2);
        request.setAttribute("nomePagamentoE", nomePagamento);
        request.getRequestDispatcher("tipoPagamentoPrincipal.jsp").forward(request, response); //dispara para a página

    }

}
