/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.paginaInicial;

import entidades.AgendamentoFesta;
import java.io.IOException;
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
@WebServlet("/agendamentoDetalhe")
public class ControllerDetalheAgendamento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTabelaAgendamentoFesta2 = 0;
        
        //pega do request o idAgendamentoFesta
        String idTabelaAgendamentoFesta = request.getParameter("idTabelaAgendamentoFesta");
        if (idTabelaAgendamentoFesta != null) {
            if (!idTabelaAgendamentoFesta.equals("")) {
                idTabelaAgendamentoFesta2 = Integer.parseInt(idTabelaAgendamentoFesta);
            }
        }
        
        if(idTabelaAgendamentoFesta2 != 0){
            //instnacia classe de comunicação com o banco de dados e entidade que representa tabela do bd
            AgendamentoFestaSQL agendamentoFestaBanco = new AgendamentoFestaSQL();
            AgendamentoFesta agendamentoFesta = new AgendamentoFesta();
            
            try {
                //recebe  do banco os dados do agendamento
                agendamentoFesta = agendamentoFestaBanco.getAgendamentoFestaEspecifico(idTabelaAgendamentoFesta2);
                
                //define o atributo do response e dispacha para página
                request.setAttribute("agendamentoFesta", agendamentoFesta);
                request.getRequestDispatcher("paginaDetalheAgendamento.jsp").forward(request, response); 
                
            } catch (Exception ex) {
                Logger.getLogger(ControllerDetalheAgendamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
