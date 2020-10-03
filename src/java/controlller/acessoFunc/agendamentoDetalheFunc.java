/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlller.acessoFunc;

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
@WebServlet("/agendamentoDetalheFunc")
public class agendamentoDetalheFunc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PEGANDO idUsuario e nomeUsuario E JOGANDO DE VOLTA NO DISPACHE
        int idUsuario2 = 0;
        
        String idUsuario = request.getParameter("idUsuario");
        if (idUsuario != null) {
            
            if (!idUsuario.equals("")) {

                idUsuario2 = Integer.parseInt(idUsuario);
                
            }
            
        }
        
        String nomeUsuario = request.getParameter("nomeUsuario");
            
        request.setAttribute("idUsuario", idUsuario2);
        request.setAttribute("nomeUsuario", nomeUsuario);
        
        //COMEÇA O PROCESSO DE IR PARA O DETALHE DO AGENDAMENTO
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
                request.getRequestDispatcher("funcPaginaDetalheAgendamento.jsp").forward(request, response); 
                
            } catch (Exception ex) {
                Logger.getLogger(agendamentoDetalheFunc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
