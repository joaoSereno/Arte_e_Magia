/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pacoteAdd;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PacoteAdicionalSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroPacoteAdicional/inativarPacoteAdicional")
public class ControllerPacoteAddInativar extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTipoPacoteAdicional2 = 0;
        
        //pegando parametros do usuário
        String idTipoPacoteAdicional = request.getParameter("idTipoPacoteAdicional");
        if (idTipoPacoteAdicional != "") { //verifica se tem valor
            idTipoPacoteAdicional2 = Integer.parseInt(idTipoPacoteAdicional);
        }
        
        PacoteAdicionalSQL pacoteAddBanco = new PacoteAdicionalSQL(); //instanciando classe que faz comunicação com o banco de dados
        
        try {
            
            if (idTipoPacoteAdicional2 != 0) { //se existir valor no idTipoPacoteAdicional2 
                pacoteAddBanco.inativaPacoteAdicional(idTipoPacoteAdicional2); //chama método da classe de comunicação com o banco que inativa o cadastro
                request.setAttribute("msg", "Pacote Adicional exluido com sucesso!!");  
                request.getRequestDispatcher("pacoteAdicionalPrincipal.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("pacoteAdicionalPrincipal.jsp").forward(request, response);                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerPacoteAddInativar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }    
}
