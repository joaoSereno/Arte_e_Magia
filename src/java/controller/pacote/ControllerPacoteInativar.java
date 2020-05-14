/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pacote;

import java.io.IOException;
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

@WebServlet("/paginasDeCadastro/cadastroDePacote/inativarPacote")
public class ControllerPacoteInativar   extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPacote2 = 0;
        
        //pegando parametros do usuário
        String idPacote = request.getParameter("idPacoteE");
        if (idPacote != "") { //verifica se tem valor
            idPacote2 = Integer.parseInt(idPacote);
        }
        
        PacoteSQL pacoteBanco = new PacoteSQL(); //instanciando classe que faz comunicação com o banco de dados
        
        try {
            
            if (idPacote2 != 0) { //se existir valor no idFormaPagamento2 
                pacoteBanco.inativaPacote(idPacote2); //chama método da classe de comunicação com o banco que inativa o cadastro
                request.setAttribute("msg", "Cadastro excluído com sucesso!");  
                request.getRequestDispatcher("pacotePrincipal.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("pacotePrincipal.jsp").forward(request, response);                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerPacoteInativar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }        
        
    }
    
}
