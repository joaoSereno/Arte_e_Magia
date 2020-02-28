/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoPagamento;

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
@WebServlet("/paginasDeCadastro/cadastroTipoPagamento/tipoPagamentoEditar")
public class ControllerTipoPagamentoEditar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //pega o idFormaPagamento da página
        String idFormaPagamento = request.getParameter("idFormaPagamento");
        int idFormaPagamento2 = Integer.parseInt(idFormaPagamento);

        String nomePagamento = request.getParameter("nomePagamento");

        //atribui no request para enviar para a página
        request.setAttribute("idFormaPagamentoE", idFormaPagamento2);
        request.setAttribute("nomePagamentoE", nomePagamento);
        request.getRequestDispatcher("tipoPagamentoPrincipal.jsp").forward(request, response); //dispara para a página

    }

}
