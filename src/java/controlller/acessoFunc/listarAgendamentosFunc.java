/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlller.acessoFunc;

import entidades.AgendamentoFesta;
import entidades.Funcionario;
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
import persistence.FuncionarioSQL;

/**
 *
 * @author João Pedro
 */

@WebServlet("/listarAgendamentosFunc")
public class listarAgendamentosFunc extends HttpServlet{

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
            
            String msgValidacaoAgendamento = "Desculpe, no momento você não possui nenhum agendamento de evento.";

            //define o atributo do response e dispacha para página
            request.setAttribute("msgValidacaoAgendamento", msgValidacaoAgendamento);
            request.getRequestDispatcher("paginaInicial.jsp").forward(request, response); 
            
        }        
        
        //COMEÇA O PROCESSO DE LISTAR OS AGENDAMENTOS DO FUNCIONARIO
        //instancia as variaveis necessarias
        AgendamentoFestaSQL agendamentoFestaBanco = new AgendamentoFestaSQL();
        List<AgendamentoFesta> listaAgendamentoFesta; 

        try {
            
            listaAgendamentoFesta = agendamentoFestaBanco.getAgendamentoFesta(funcionario.getIdFuncionario());
            
            if(listaAgendamentoFesta.size() < 1){
                
                String msgValidacaoAgendamento = "Desculpe, no momento você não possui nenhum evento agendado.";
            
                //define o atributo do response e dispacha para página
                request.setAttribute("msgValidacaoAgendamento", msgValidacaoAgendamento);
                request.getRequestDispatcher("funcPaginaInicial.jsp").forward(request, response); 
                
            }else{
                
                //define o atributo do response e dispacha para página
                request.setAttribute("controllerListagemAgendamento", 1);
                request.setAttribute("listaAgendamentoFesta", listaAgendamentoFesta);
                request.getRequestDispatcher("funcPaginaInicial.jsp").forward(request, response);

            }

        } catch (Exception ex) {
            Logger.getLogger(listarAgendamentosFunc.class.getName()).log(Level.SEVERE, null, ex);
            
            String msgValidacaoAgendamento = "Desculpe, ocorreu um erro.";

            //define o atributo do response e dispacha para página
            request.setAttribute("msgValidacaoAgendamento", msgValidacaoAgendamento);
            request.getRequestDispatcher("funcPaginaInicial.jsp").forward(request, response); 
            
        }          
    }   
        
}
