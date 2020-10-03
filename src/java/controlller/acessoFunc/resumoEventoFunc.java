/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlller.acessoFunc;

import entidades.Funcionario;
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
import persistence.FuncionarioSQL;
import persistence.RelatoriosSQL;
import util.Conversor;

/**
 *
 * @author João Pedro
 */
@WebServlet("/resumoEventoFunc")
public class resumoEventoFunc extends HttpServlet{

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
        
        
        //PEGA idFuncionario DO USUARIO
        //cria as variaveis necessiarias
        Funcionario funcionario = new Funcionario();
        FuncionarioSQL funcionarioBanco = new FuncionarioSQL();
        
        try {
            //chama o metodo do banco que retorna o funcionario vinculado ao usuario
            funcionario = funcionarioBanco.getFuncionarioEspecificoUsuario(idUsuario2);
        } catch (Exception ex) {
            Logger.getLogger(resumoEventoFunc.class.getName()).log(Level.SEVERE, null, ex);
            
            //seta atributo do response
            request.setAttribute("msgValidacao", "Desculpe, nenhum resultado encontrado para os filtros informado.");

            //dispachando para a página
            request.getRequestDispatcher("funcResumoEvento.jsp").forward(request, response);            
        }
                
        //COMEÇA O PROCESSO DE GERAR O RESUMO PARA O USUÁRIO
        //cria as variaveis necessarias
        int statusEvento2 = 0;
        String periodoConvertido = "";
        String periodoConvertido2 = "";
        Conversor conversorString = new Conversor();
        ArrayList<RelatorioFuncionario> relatorioFuncionario = new ArrayList();
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
            relatorioFuncionario = relatorioBanco.getRelatorioFuncionario(statusEvento2, periodoConvertido, periodoConvertido2, funcionario.getIdFuncionario());
            
        } catch (Exception ex) {
            Logger.getLogger(resumoEventoFunc.class.getName()).log(Level.SEVERE, null, ex);
            
            //seta atributo do response
            request.setAttribute("msgValidacao", "Desculpe, nenhum resultado encontrado para os filtros informado.");

            //dispachando para a página
            request.getRequestDispatcher("funcResumoEvento.jsp").forward(request, response);
            
        }

        if(relatorioFuncionario.size() < 1){
            //seta atributo do response
            request.setAttribute("msgValidacao", "Desculpe, nenhum resultado encontrado para os filtros informado.");

            //dispachando para a página
            request.getRequestDispatcher("funcResumoEvento.jsp").forward(request, response);
            
        } else{
                
            //seta atributo do response
            request.setAttribute("totalValorPagoFunc", relatorioFuncionario.get(0).getTotalGanho());
            request.setAttribute("totalEventoPeriodo", relatorioFuncionario.get(0).getTotalFesta());
            request.setAttribute("controllerResumoEventoResultado", 1);

            //dispachando para a página
            request.getRequestDispatcher("funcResumoEvento.jsp").forward(request, response);     
                
        }
        
    }   
        
}
