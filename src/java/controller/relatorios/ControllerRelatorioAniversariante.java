/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.relatorios;

import entidadesRelatorio.RelatorioAniversariante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.CriancaSQL;
import persistence.RelatoriosSQL;

/**
 *
 * @author João Pedro
 */

@WebServlet("/paginasDeRelatorios/relatorioAniversariante/relatorioAniversariante")
public class ControllerRelatorioAniversariante extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int mesInicial2 = 0;
        int mesFinal2 = 0;
        
        //pega o periodo informado do request
        String mesInicial = request.getParameter("mesInicial");
        if (mesInicial != null) {
            if (!mesInicial.equals("")) {
                mesInicial2 = Integer.parseInt(mesInicial);
            }
        }
        
        String mesFinal = request.getParameter("mesFinal");
        if (mesFinal != null) {
            if (!mesFinal.equals("")) {
                mesFinal2 = Integer.parseInt(mesFinal);
            }
        }
        
        if(mesInicial2 > mesFinal2){
            //setando os atributos que será enviando para o front
            request.setAttribute("msgValidacao", "Por favor informe o período corretamente!");    
            
            //dispachando para a página
            request.getRequestDispatcher("aniversarianteFiltroRel.jsp").forward(request, response);
            
        }else{
            //instancia classe necessarias para comunicação com o bando de dados
            RelatoriosSQL relatorioBanco = new RelatoriosSQL();
            ArrayList<RelatorioAniversariante> relatorioAniversariante = new ArrayList();

            try {
                //recebe o relatorio na array
                relatorioAniversariante = relatorioBanco.getRelatorioAniversariante(mesInicial2, mesFinal2);
                
                //verifica se existe resultado para os filtros utilizados
                if(relatorioAniversariante.size() < 1){
                    
                    //setando os atributos que será enviando para o front
                    request.setAttribute("msgValidacao", "Desculpe, nenhum resultado encontrado para o período informado.");    
                    //dispachando para a página
                    request.getRequestDispatcher("aniversarianteFiltroRel.jsp").forward(request, response);     
                    
                }else{
                    //setando os atributos que será enviando para o front
                    request.setAttribute("relatorioAniversariante", relatorioAniversariante);    

                    //dispachando para a página
                    request.getRequestDispatcher("aniversarianteResultadoRel.jsp").forward(request, response);   
                }
                
            } catch (Exception ex) {
                Logger.getLogger(ControllerRelatorioAniversariante.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }


    }    

}
