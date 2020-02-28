/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoPagamento;

import java.io.IOException;
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
@WebServlet("/paginasDeCadastro/cadastroTipoPagamento/inativarFormaPagamento")
public class ControllerTipoPagamentoInativar  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idFormaPagamento2 = 0;
        
        //pegando parametros do usuário
        String idFormaPagamento = request.getParameter("idFormaPagamento");
        if (idFormaPagamento != "") { //verifica se tem valor
            idFormaPagamento2 = Integer.parseInt(idFormaPagamento);
        }
        
        TipoPagamentoSQL tipoPagamentoBanco = new TipoPagamentoSQL(); //instanciando classe que faz comunicação com o banco de dados
        
        try {
            
            if (idFormaPagamento2 != 0) { //se existir valor no idFormaPagamento2 
                tipoPagamentoBanco.inativaFormaPagamento(idFormaPagamento2); //chama método da classe de comunicação com o banco que inativa o cadastro
                request.setAttribute("msg", "Forma de pagamento exluida com sucesso!!");  
                request.getRequestDispatcher("tipoPagamentoPrincipal.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("tipoPagamentoPrincipal.jsp").forward(request, response);                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerTipoPagamentoInativar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }        
        
    } 
}
