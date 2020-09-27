/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.festas;

import entidades.Festa;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.AgendamentoFestaSQL;
import persistence.DespesaFestaSQL;
import persistence.EnderecoSQL;
import persistence.FestaCriancaSQL;
import persistence.FestaSQL;
import persistence.FuncionarioFestaSQL;
import persistence.HorarioFestaSQL;
import persistence.PacotesAdicionaisFestaSQL;
import persistence.PagamentoFestaSQL;
import persistence.ValorAdicionalFestaSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeFesta/excluirEvento")
public class ControllerFestaExcluir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEvento = 0;
            
        String idEventoExcluir = request.getParameter("idEventoExcluir");
        if (idEventoExcluir != null) {
            if (!idEventoExcluir.equals("")) {

                idEvento = Integer.parseInt(idEventoExcluir);
                
            }
        }
        
        if(idEvento != 0){
            
            //instancia as classes de comunicação com o banco de dados que serão utilizadas
            AgendamentoFestaSQL agendamentoFestaBanco = new AgendamentoFestaSQL();
            DespesaFestaSQL despesaFestaBanco = new DespesaFestaSQL();
            FestaCriancaSQL festaCriancaBanco = new FestaCriancaSQL();
            FestaSQL festaBanco = new FestaSQL();
            FuncionarioFestaSQL funcionarioFestaBanco = new FuncionarioFestaSQL();
            HorarioFestaSQL horarioFestaBanco = new HorarioFestaSQL();
            PacotesAdicionaisFestaSQL pacotesAdicionaisFestaBanco = new PacotesAdicionaisFestaSQL();
            PagamentoFestaSQL pagamentoFestaBanco = new PagamentoFestaSQL();
            ValorAdicionalFestaSQL valorAdicionalFestaBanco = new ValorAdicionalFestaSQL();
            EnderecoSQL enderecoBanco = new EnderecoSQL();

            try {
                //instancia classe que representa a festa
                Festa festa = new Festa();
                
                //recebe os dados do evento 
                festa = festaBanco.getFestaEspecifica(idEvento);
                
                //deleta os dados de todas as tabelas vinculadas a festa
                agendamentoFestaBanco.excluir(idEvento);
                despesaFestaBanco.excluir(idEvento);        
                festaCriancaBanco.excluir(idEvento);
                funcionarioFestaBanco.excluir(idEvento);
                horarioFestaBanco.excluir(idEvento);        
                pacotesAdicionaisFestaBanco.excluir(idEvento);      
                pagamentoFestaBanco.excluir(idEvento);        
                valorAdicionalFestaBanco.excluir(idEvento);
                
                //deleta a festa
                festaBanco.excluir(idEvento);
                
                //deleta o endereço da festa
                enderecoBanco.excluir(festa.getIdEnderecos());
                
                request.setAttribute("controllerExclusaoEvento", 1);
                request.setAttribute("msgExclusaoFesta", "Evento excluído com sucesso!");
                request.getRequestDispatcher("festaPrincipal.jsp").forward(request, response);                
                
                //manda para principal com msg de sucesso
            } catch (Exception ex) {
                
                Logger.getLogger(ControllerFestaExcluir.class.getName()).log(Level.SEVERE, null, ex);
                
                request.setAttribute("controllerExclusaoEvento", 1);
                request.setAttribute("msgExclusaoFestaErro", "Desculpe não foi possível excluir o evento! =( ");
                request.getRequestDispatcher("festaPrincipal.jsp").forward(request, response);  
                
            }
            
        }else{
            
            request.setAttribute("controllerExclusaoEvento", 1);
            request.setAttribute("msgExclusaoFestaErro", "Desculpe não foi possível excluir o evento! =( ");
            request.getRequestDispatcher("festaPrincipal.jsp").forward(request, response); 
               
        }
    }
}
