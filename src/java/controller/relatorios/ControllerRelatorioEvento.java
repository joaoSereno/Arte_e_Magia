/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.relatorios;

import entidadesRelatorio.RelatorioEvento;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.FestaSQL;
import persistence.RelatoriosSQL;
import util.Conversor;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeRelatorios/relatorioEvento/relatorioEvento")
public class ControllerRelatorioEvento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int statusEvento2 = 0;
        String periodoEventoConvertido = "";
        String periodoEventoConvertido2 = "";
        ArrayList<RelatorioEvento> relatorioEvento = new ArrayList(); //array do relatorio
        RelatoriosSQL relatorioBanco = new RelatoriosSQL(); //classe de comunicação com o banco de dados
        Conversor conversorString = new Conversor();
        
        //pega os parametro da pesquisa do request
        String statusEvento = request.getParameter("statusEvento");
        if (statusEvento != null) {
            if (!statusEvento.equals("")) {
                statusEvento2 = Integer.parseInt(statusEvento);
            }
        }
        
        String periodoEvento = request.getParameter("periodoEvento");
        if (periodoEvento != null) {
            if (!periodoEvento.equals("")) {
                periodoEventoConvertido = conversorString.formatarData(periodoEvento);
            }
        }
        
        String periodoEvento2 = request.getParameter("periodoEvento2");
        if (periodoEvento2 != null) {
            if (!periodoEvento2.equals("")) {
                periodoEventoConvertido2 = conversorString.formatarData(periodoEvento2);
            }
        }
        
        try {
            relatorioEvento = relatorioBanco.getRelatorioEvento(statusEvento2, periodoEventoConvertido, periodoEventoConvertido2);
            
            if(relatorioEvento.size() < 1){
                //seta atributo do response
                request.setAttribute("msgValidacao", "Desculpe, nenhum resultado encontrado para os filtros informado.");

                //dispachando para a página
                request.getRequestDispatcher("eventoFiltroRel.jsp").forward(request, response);

            }else{
                
                float somaValorTotalBruto = 0;
                float somaTotalDespesa = 0;
                float somaTotalLucro = 0;
                int totalEventoPeriodo = relatorioEvento.size();
                
                //percorre a lista para somar os valores totais
                for(int i = 0; i < relatorioEvento.size(); i++){
                    
                    somaValorTotalBruto = somaValorTotalBruto + relatorioEvento.get(i).getValorTotalBruto();
                    somaTotalDespesa  = somaTotalDespesa + relatorioEvento.get(i).getValorTotalDespesa();
                    somaTotalLucro = somaTotalLucro + relatorioEvento.get(i).getLucroEvento();
                    
                }
                
                //seta atributo do response
                request.setAttribute("somaValorTotalBruto", somaValorTotalBruto);
                request.setAttribute("somaTotalDespesa", somaTotalDespesa);
                request.setAttribute("somaTotalLucro", somaTotalLucro);
                request.setAttribute("totalEventoPeriodo", totalEventoPeriodo);
                request.setAttribute("relatorioEvento", relatorioEvento);

                //dispachando para a página
                request.getRequestDispatcher("eventoResultadoRel.jsp").forward(request, response);                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerRelatorioEvento.class.getName()).log(Level.SEVERE, null, ex);
            
            //seta atributo do response
            request.setAttribute("msgValidacao", "Desculpe, nenhum resultado encontrado para os filtros informado.");

            //dispachando para a página
            request.getRequestDispatcher("eventoFiltroRel.jsp").forward(request, response);  
            
        }
    }

}
