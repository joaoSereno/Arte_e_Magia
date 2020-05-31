/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.despesa;

import entidades.FormaPagamento;
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
import persistence.TipoPagamentoSQL;

/**
 *
 * @author João Pedro
 */

@WebServlet("/paginasDeCadastro/cadastroDeDespesa/preCadastroDespesa")
public class ControllerPreCadastroDespesa extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<TipoDeDespesa> listaTipoDespesas; //lista que vai receber os dados do tipo de despesas
        List<FormaPagamento> listaTipoPagamento; //lista que vai receber os tipos de pagamento
        
        //classes de comunicação com o banco de dados
        TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL();
        TipoPagamentoSQL tipoPagamentoBanco = new TipoPagamentoSQL();
        
        try {
            
            //recebendo os cadastros na lista
            listaTipoDespesas = tipoDespesaBanco.getTipoDeDespesa();
            listaTipoPagamento = tipoPagamentoBanco.getFormaPagamento();
            
            //setando no response as lista
            request.setAttribute("listaTipoPagamento", listaTipoPagamento);
            request.setAttribute("listaTipoDespesas", listaTipoDespesas); 
            
            //disparando para a pagina de cadasto de despesa
            request.getRequestDispatcher("despesaCadastrar.jsp").forward(request, response); // dispara para essa página
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerPreCadastroDespesa.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
    }
    
}
