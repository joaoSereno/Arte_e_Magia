/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.relatorios;

import entidadesRelatorio.RelatorioFuncionario;
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
@WebServlet("/paginasDeRelatorios/relatorioFuncionario/relatorioFuncionario")
public class ControllerRelatorioFuncionario extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int statusEvento2 = 0;
        String periodoConvertido = "";
        String periodoConvertido2 = "";
        Conversor conversorString = new Conversor();
        ArrayList<RelatorioFuncionario> relatorioFuncionario = new ArrayList(); //array do relatorio
        RelatoriosSQL relatorioBanco = new RelatoriosSQL(); //classe de comunicação com o banco de dados        
        
        //pega os parametro da pesquisa do request
        String statusEvento = request.getParameter("statusEvento");
        if (statusEvento != null) {
            if (!statusEvento.equals("")) {
                statusEvento2 = Integer.parseInt(statusEvento);
            }
        }
        
        String periodo = request.getParameter("periodo");
        if (periodo != null) {
            if (!periodo.equals("")) {
                periodoConvertido = conversorString.formatarData(periodo);
            }
        }
        
        String periodoo2 = request.getParameter("periodoo2");
        if (periodoo2 != null) {
            if (!periodoo2.equals("")) {
                periodoConvertido2 = conversorString.formatarData(periodoo2);
            }
        }
        
        try {
            //recebe resultado do relatorio do banco
            relatorioFuncionario = relatorioBanco.getRelatorioFuncionario(statusEvento2, periodoConvertido, periodoConvertido2, 0);
            
            if(relatorioFuncionario.size() < 1){
                //seta atributo do response
                request.setAttribute("msgValidacao", "Desculpe, nenhum resultado encontrado para os filtros informado.");

                //dispachando para a página
                request.getRequestDispatcher("funcionarioFiltroRel.jsp").forward(request, response);

            }else{
                
                float totalValorPagoFunc = 0;
                int totalEventoPeriodo = 0;
                
                //percorre a lista para somar os valores totais
                for(int i = 0; i < relatorioFuncionario.size(); i++){
                    
                    totalValorPagoFunc = totalValorPagoFunc + relatorioFuncionario.get(i).getTotalGanho();
                    totalEventoPeriodo = totalEventoPeriodo + relatorioFuncionario.get(i).getTotalFesta();
                    
                }
                
                //seta atributo do response
                request.setAttribute("totalValorPagoFunc", totalValorPagoFunc);
                request.setAttribute("totalEventoPeriodo", totalEventoPeriodo);
                request.setAttribute("relatorioFuncionario", relatorioFuncionario);

                //dispachando para a página
                request.getRequestDispatcher("funcionarioResultadoRel.jsp").forward(request, response);                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerRelatorioFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            
            //seta atributo do response
            request.setAttribute("msgValidacao", "Desculpe, nenhum resultado encontrado para os filtros informado.");

            //dispachando para a página
            request.getRequestDispatcher("funcionarioFiltroRel.jsp").forward(request, response);            
        }        
        
    }
    
}
