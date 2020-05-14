/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoDespesa;

import java.io.IOException;
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
@WebServlet("/paginasDeCadastro/cadastroTipoDespesa/inativarTipoDespesa")
public class ControllerTipoDespesaInativar extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTipoDeDespesa2 = 0;
        
        //pegando parametros do usuário
        String idTipoDeDespesa = request.getParameter("idTipoDeDespesa");
        if (idTipoDeDespesa != "") { //verifica se tem valor
            idTipoDeDespesa2 = Integer.parseInt(idTipoDeDespesa);
        }
        
        TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL(); //instanciando classe que faz comunicação com o banco de dados
        
        try {
            
            if (idTipoDeDespesa2 != 0) { //se existir valor no idFormaPagamento2 
                tipoDespesaBanco.inativaTipoDespesa(idTipoDeDespesa2); //chama método da classe de comunicação com o banco que inativa o cadastro
                request.setAttribute("msg", "Cadastro excluído com sucesso!");  
                request.getRequestDispatcher("tipoDespesaPrincipal.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("tipoDespesaPrincipal.jsp").forward(request, response);                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerTipoDespesaInativar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }        
        
    }   
    
}
