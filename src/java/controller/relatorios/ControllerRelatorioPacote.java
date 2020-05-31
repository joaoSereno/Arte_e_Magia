/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.relatorios;

import entidadesRelatorio.RelatorioPacote;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.RelatoriosSQL;
import util.Conversor;

/**
 *
 * @author João Pedro
 */

@WebServlet("/paginasDeRelatorios/relatorioPacote/relatorioPacote")
public class ControllerRelatorioPacote extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String periodoConvertido = "";
        String periodoConvertido2 = "";
        ArrayList<RelatorioPacote> relatorioPacote = new ArrayList(); //array do relatorio
        RelatoriosSQL relatorioBanco = new RelatoriosSQL(); //classe de comunicação com o banco de dados
        Conversor conversorString = new Conversor();
        
        String periodo = request.getParameter("periodo");
        if (periodo != null) {
            if (!periodo.equals("")) {
                periodoConvertido = conversorString.formatarData(periodo);
            }
        }
        
        String periodo2 = request.getParameter("periodo2");
        if (periodo2 != null) {
            if (!periodo2.equals("")) {
                periodoConvertido2 = conversorString.formatarData(periodo2);
            }
        }
        
        try {
            
            relatorioPacote = relatorioBanco.getRelatorioPacote(periodoConvertido, periodoConvertido2);
            
            if(relatorioPacote.size() < 1){
                
                //seta atributo do response
                request.setAttribute("msgValidacao", "Desculpe, nenhum resultado encontrado para os filtros informado.");

                //dispachando para a página
                request.getRequestDispatcher("pacoteFiltroRel.jsp").forward(request, response);

            }else{
                
                //variavel que vai ser passada como controller
                String listaConcatenadaRelPacote = "";
                
                //recebendo o total registros na variavel 
                int totalResultadoRelPacote = relatorioPacote.size();

                //loop em todos os registros da lista e concatenando tudo em um string que servira de controlador(input) no front
                for (int i = 0; i < totalResultadoRelPacote; i++) {
                    
                    listaConcatenadaRelPacote = listaConcatenadaRelPacote + relatorioPacote.get(i).getNomePacote()
                                                + "," + Integer.toString(relatorioPacote.get(i).getQtdVendida()) + "/";
                    
                }
                
                //seta atributo do response
                request.setAttribute("listaConcatenadaRelPacote", listaConcatenadaRelPacote);
                request.setAttribute("totalResultadoRelPacote", totalResultadoRelPacote);
                request.setAttribute("periodo", periodo);
                request.setAttribute("periodo2", periodo2);

                //dispachando para a página
                request.getRequestDispatcher("pacoteResultadoRel.jsp").forward(request, response);
            
            
            }
            
        } catch (Exception ex) {
            
            Logger.getLogger(ControllerRelatorioPacote.class.getName()).log(Level.SEVERE, null, ex);
            
            //seta atributo do response
            request.setAttribute("msgValidacao", "Desculpe, nenhum resultado encontrado para os filtros informado.");

            //dispachando para a página
            request.getRequestDispatcher("pacoteFiltroRel.jsp").forward(request, response);            
        }
        
    } 
    
}
