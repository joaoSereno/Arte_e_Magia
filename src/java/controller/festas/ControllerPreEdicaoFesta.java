/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.festas;

import entidades.Cliente;
import entidades.Crianca;
import entidades.DespesaFesta;
import entidades.Enderecos;
import entidades.Festa;
import entidades.FestaCrianca;
import entidades.FormaPagamento;
import entidades.Funcionario;
import entidades.FuncionarioFesta;
import entidades.HorarioFesta;
import entidades.Pacote;
import entidades.PacotesAdicionaisFesta;
import entidades.PagamentoFesta;
import entidades.TipoDeDespesa;
import entidades.TipoDeFesta;
import entidades.TipoPacoteAdicional;
import entidades.ValorAdicionalFesta;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ClienteSQL;
import persistence.CriancaSQL;
import persistence.DespesaFestaSQL;
import persistence.EnderecoSQL;
import persistence.FestaCriancaSQL;
import persistence.FestaSQL;
import persistence.FuncionarioFestaSQL;
import persistence.FuncionarioSQL;
import persistence.HorarioFestaSQL;
import persistence.PacoteAdicionalSQL;
import persistence.PacoteSQL;
import persistence.PacotesAdicionaisFestaSQL;
import persistence.PagamentoFestaSQL;
import persistence.TipoDeFestaSQL;
import persistence.TipoDespesaSQL;
import persistence.TipoPagamentoSQL;
import persistence.ValorAdicionalFestaSQL;

/**
 *
 * @author João Pedro
 * 
 * 
 * 
 * A PARTE DE CADASTRAR Já está PRONTA
 * AQUI SO TEM QUE CONCATENAR AS STRINGS CERTAS E TBM A PARTE DO FRONT DA PÁGINA 
 * NO FRONT TEM QUE FICAR COM OS PARAMETROS IGUAIS AO DO CADASTRO
 * 
 */
@WebServlet("/paginasDeCadastro/cadastroDeFesta/preEdicaoEvento")
public class ControllerPreEdicaoFesta extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEvento2 = 0;
            
        String idEvento = request.getParameter("idEvento");
        if (idEvento != null) {
            if (!idEvento.equals("")) {

                idEvento2 = Integer.parseInt(idEvento);
                
            }
        }
        
        if(idEvento2 != 0){
            
            //AQUI COMEÇA O PROCESSO DE RECEBER OS DADOS DA LISTAGEM
            //instanciando as classes necessarias
            ClienteSQL clienteBanco = new ClienteSQL();
            List<Cliente> listaClientes;
            
            CriancaSQL criancaBanco = new CriancaSQL();
            List<Crianca> listaCriancas;
            
            FuncionarioSQL funcionarioBanco = new FuncionarioSQL();
            List<Funcionario> listaFuncionario;

            TipoPagamentoSQL tipoPagamentoBanco = new TipoPagamentoSQL();
            List<FormaPagamento> listaFormaPagamento;
           
            PacoteSQL pacoteBanco = new PacoteSQL();
            List<Pacote> listaPacote;
            
            PacoteAdicionalSQL pacoteAdicionalBanco = new PacoteAdicionalSQL();
            List<TipoPacoteAdicional> listaTipoPacoteAdicional; 
            
            TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL();
            List<TipoDeDespesa> listaTipoDeDespesa;

            TipoDeFestaSQL tipoFestaBanco = new TipoDeFestaSQL();
            List<TipoDeFesta> listaTipoDeFesta;
            
            //recebendo os dados do banco e salvando nas lista
            try {
                
                listaClientes = clienteBanco.getClientes();
                listaCriancas = criancaBanco.getTodasCriancasAtivas();
                listaFuncionario = funcionarioBanco.getFuncionario();
                listaFormaPagamento  = tipoPagamentoBanco.getFormaPagamento();
                listaPacote = pacoteBanco.getPacote();
                listaTipoPacoteAdicional = pacoteAdicionalBanco.getTipoPacoteAdicional();
                listaTipoDeDespesa = tipoDespesaBanco.getTipoDeDespesa();
                listaTipoDeFesta = tipoFestaBanco.getTipoDeFesta();
                
                //faz o tratamento dos dados caso necessario
                
            } catch (Exception ex) {
                
                Logger.getLogger(ControllerPreEdicaoFesta.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("controllerEdicaoEvento", 1);
                request.setAttribute("msgEdicaoFestaErro", "Desculpe não foi possível editar o evento! =( ");
                request.getRequestDispatcher("festaPrincipal.jsp").forward(request, response);  
                
            }
            //AQUI TERMINA O PROCESSO DE RECEBER OS DADOS DA LISTAGEM
            
            //AQUI COMEÇA O PROCESSO DE RECEBER OS DADOS DO EVENTO
            //instancia as classes necessarias
            FestaSQL festaBanco = new FestaSQL();
            Festa festa = new Festa();
            
            DespesaFestaSQL despesaFestaBanco = new DespesaFestaSQL();
            List<DespesaFesta> listaDespesaFesta;
            
            FestaCriancaSQL festaCriancaBanco = new FestaCriancaSQL();
            List<FestaCrianca> listaFestaCrianca;
            
            FuncionarioFestaSQL funcionarioFestaBanco = new FuncionarioFestaSQL();
            List<FuncionarioFesta> listaFuncionarioFesta;
            
            HorarioFestaSQL horarioFestaBanco = new HorarioFestaSQL();
            List<HorarioFesta> listaHorarioFesta;
            
            PacotesAdicionaisFestaSQL pacotesAdicionaisFestaBanco = new PacotesAdicionaisFestaSQL();
            List<PacotesAdicionaisFesta> listaPacotesAdicionaisFesta;
            
            PagamentoFestaSQL pagamentoFestaBanco = new PagamentoFestaSQL();
            List<PagamentoFesta> listaPagamentoFesta;
            
            ValorAdicionalFestaSQL valorAdicionalFestaBanco = new ValorAdicionalFestaSQL();
            List<ValorAdicionalFesta> listaValorAdicionalFesta;
            
            EnderecoSQL enderecoBanco = new EnderecoSQL();
            Enderecos enderecoFesta = new Enderecos();
            
            try {
                
                //recebe nas instancias os dados do evento
                festa = festaBanco.getFestaEspecifica(idEvento2);
                listaDespesaFesta = despesaFestaBanco.getDespesaFestaEspecifica(idEvento2);
                listaFestaCrianca = festaCriancaBanco.getFestaCriancaEspecifica(idEvento2);
                listaFuncionarioFesta = funcionarioFestaBanco.getFuncionarioFestaEspecifica(idEvento2);
                listaHorarioFesta = horarioFestaBanco.getHorarioFestaEspecifica(idEvento2);
                listaPacotesAdicionaisFesta = pacotesAdicionaisFestaBanco.getPacotesAdicionaisEspecifica(idEvento2);
                listaPagamentoFesta = pagamentoFestaBanco.getPagamentoFestaEspecifica(idEvento2);
                listaValorAdicionalFesta = valorAdicionalFestaBanco.getValorAdicionalFestaEspecifica(idEvento2);
                enderecoFesta = enderecoBanco.getEnderecoEspecifico(festa.getIdEnderecos());
                
                //faz o tratamento dos dados
                
            } catch (Exception ex) {
                
                Logger.getLogger(ControllerPreEdicaoFesta.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("controllerEdicaoEvento", 1);
                request.setAttribute("msgEdicaoFestaErro", "Desculpe não foi possível editar o evento! =( ");
                request.getRequestDispatcher("festaPrincipal.jsp").forward(request, response);  
                
            }

            
                
            //AQUI TERMINA O PROCESSO DE RECEBER OS DADOS DO EVENTO
            
        }else{
            
            request.setAttribute("controllerEdicaoEvento", 1);
            request.setAttribute("msgEdicaoFestaErro", "Desculpe não foi possível editar o evento! =( ");
            request.getRequestDispatcher("festaPrincipal.jsp").forward(request, response);  
            
        }
        
    }
    
}
