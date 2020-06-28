/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.despesa;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.DespesaSQL;
import persistence.PagamentoDespesaDetalheSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeDespesa/excluirDespesa")
public class ControllerExcluirDespesa  extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDespesas2 = 0;
        String msg = "Despesa excluída com sucesso!";

        String idDespesas = request.getParameter("idDespesas"); //recebe o idDespesas
        if (idDespesas != null) { //se existir despesa

            if (!idDespesas.equals("")) {

                idDespesas2 = Integer.parseInt(idDespesas); //converte para inteiro o idDespesas

            }

        }
        
        //instanciando classe de comunicação 
        PagamentoDespesaDetalheSQL pagamentoDespesaDetalheBanco = new PagamentoDespesaDetalheSQL();
        DespesaSQL despesaBanco = new DespesaSQL();
        
        try {
            
            //excluindo a despesa
            pagamentoDespesaDetalheBanco.excluirDespesa(idDespesas2);
            despesaBanco.excluirDespesa(idDespesas2);
            
            //setando msg de confirmação da exclusão e disparando para página
            request.setAttribute("msgValidacaoExclusaoController", 1);
            request.setAttribute("msgValidacaoExclusao", msg);

            request.getRequestDispatcher("despesaPrincipal.jsp").forward(request, response); // dispara para essa página 
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerExcluirDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
