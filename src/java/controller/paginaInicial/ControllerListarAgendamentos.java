/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.paginaInicial;

import entidades.AgendamentoFesta;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.AgendamentoFestaSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/listarAgendamentos")
public class ControllerListarAgendamentos extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        AgendamentoFestaSQL agendamentoFestaBanco = new AgendamentoFestaSQL(); //instancia a classe de comunicação com o banco de dados 

        List<AgendamentoFesta> listaAgendamentoFesta; 

        try {
            
            listaAgendamentoFesta = agendamentoFestaBanco.getAgendamentoFesta(0);
            
            if(listaAgendamentoFesta.size() < 1){
                
                String msgValidacaoAgendamento = "Desculpe, no momento não possui nenhum agendamento.";
            
                //define o atributo do response e dispacha para página
                request.setAttribute("msgValidacaoAgendamento", msgValidacaoAgendamento);
                request.getRequestDispatcher("paginaInicial.jsp").forward(request, response); 
                
            }else{
                
                //define o atributo do response e dispacha para página
                request.setAttribute("controllerListagemAgendamento", 1);
                request.setAttribute("listaAgendamentoFesta", listaAgendamentoFesta);
                request.getRequestDispatcher("paginaInicial.jsp").forward(request, response);

            }

        } catch (Exception ex) {
            Logger.getLogger(ControllerListarAgendamentos.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }  
        
    }  
    
}
