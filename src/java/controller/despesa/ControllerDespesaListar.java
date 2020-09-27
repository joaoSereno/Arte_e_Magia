/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.despesa;

import entidadesRelatorio.ListagemDeDespesa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.DespesaFestaSQL;
import persistence.DespesaSQL;
import persistence.PagamentoDespesasDetalheSQL;
import util.Conversor;

/**
 *
 * @author João Pedro
 */

@WebServlet("/paginasDeCadastro/cadastroDeDespesa/listarDespesas")
public class ControllerDespesaListar extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int origem2 = 0; //1 = cadastro de despesas ----  2 = cadastro de evento --- 3 ambas
        int exibir2 = 0; // 1 = nao pagas ---  2 = pagas  --- 3 = ambas
        String periodoDespesaConvertido = "";
        String periodoDespesaConvertido2 = "";
        String msgValidacao = "Desculpe, no momento não foi encontrado nenhum resultado para o filtro informado!";
        
        //valores da origem despesa
        float valorTotalDespesa = 0;
        float valorPagoDespesa = 0;
        float valorAbertoDespesa = 0;
        
        //valores da origem despesa
        float valorTotalEvento = 0;
        float valorPagoEvento = 0;
        float valorAbertoEvento = 0;
        
        Conversor conversor = new Conversor();
        
        //classe que vai receber a lista das despesa
        ArrayList<ListagemDeDespesa> listagemDespesaDespesa = new ArrayList(); 
        ArrayList<ListagemDeDespesa> listagemDespesaEvento = new ArrayList(); 
        
        //classe de comunicação com o banco de dados 
        DespesaSQL despesaBanco = new DespesaSQL();
        DespesaFestaSQL despesaFestaBanco = new DespesaFestaSQL();
        
        //pegando do request as informações necessarias
        String origem = request.getParameter("origem");
        if (origem != null) {

            if (!origem.equals("")) {
                origem2 = Integer.parseInt(origem);
            }

        }   

        String exibir = request.getParameter("exibir");
        if (exibir != null) {

            if (!exibir.equals("")) {
                exibir2 = Integer.parseInt(exibir);
            }

        }
        
        String periodoDespesa = request.getParameter("periodoDespesa");
        if (periodoDespesa != null) {
            if (!periodoDespesa.equals("")) {
                periodoDespesaConvertido = conversor.formatarData(periodoDespesa);
            }
        }
        
        String periodoDespesa2 = request.getParameter("periodoDespesa2");
        if (periodoDespesa2 != null) {
            if (!periodoDespesa2.equals("")) {
                periodoDespesaConvertido2 = conversor.formatarData(periodoDespesa2);
            }
        }
        
        //DEFINE STRINGS DO FILTRO
        String origemDaDespesa = "";
        switch (origem2) { //1 = cadastro de despesas ----  2 = cadastro de evento --- 3 ambas
            case 1: {
                
                origemDaDespesa= " Cadastro de Despesa ";
                        
                break;
            }
            case 2: {
                
                origemDaDespesa= " Cadastro de Evento ";
                
                break;
            }
            case 3: {
                
                origemDaDespesa= " Ambas ";
                
                break;
            }
        }
        

        String exibirDespesa = "";
        switch (exibir2) { // 1 = nao pagas ---  2 = pagas  --- 3 = ambas
            case 1: {
                
                exibirDespesa = " Somente não pagas ";
                
                break;
            }
            case 2: {
                
                exibirDespesa = " Somente pagas ";
                
                break;
            }
            case 3: {
                
                exibirDespesa = " Ambas ";
                
                break;
            }
        }

        switch (origem2) {
            case 1: {//somente despesa
                
                try {
                    
                    //chama o método de comunicação com o banco e recebe o resultado na lista
                    listagemDespesaDespesa = despesaBanco.getListagemDeDespesa(exibir2, periodoDespesaConvertido, periodoDespesaConvertido2);
                    
                    if(listagemDespesaDespesa.size() > 0) { //se a lista tiver conteudo
                        
                        //faz o calculo dos valores da despesa de despesa
                        for(int i = 0; i < listagemDespesaDespesa.size(); i++){
                            
                            valorTotalDespesa = valorTotalDespesa + listagemDespesaDespesa.get(i).getValor();
                            valorPagoDespesa = valorPagoDespesa + listagemDespesaDespesa.get(i).getValorPago();
                            
                        }
                        
                        valorAbertoDespesa = valorTotalDespesa - valorPagoDespesa;
                        
                        //adiciona os parametro no response e dispacha para a pagina de listagem
                        request.setAttribute("listagemDespesaDespesa", listagemDespesaDespesa);
                        request.setAttribute("origemDespesa", 1);
                        request.setAttribute("origemDaDespesa", origemDaDespesa);
                        request.setAttribute("exibirDespesa", exibirDespesa);                        
                        request.setAttribute("origem", origem);
                        request.setAttribute("exibir", exibir);
                        request.setAttribute("periodoDespesa", periodoDespesa);
                        request.setAttribute("periodoDespesa2", periodoDespesa2);
                        request.setAttribute("valorTotalDespesa", valorTotalDespesa);
                        request.setAttribute("valorPagoDespesa", valorPagoDespesa);
                        request.setAttribute("valorAbertoDespesa", valorAbertoDespesa);                         
                        
                        request.getRequestDispatcher("despesaListagem.jsp").forward(request, response); // dispara para essa página
                        
                    }else{ //se a lista não tiver conteudo 
                        
                        //adiciona os parametro no response e dispacha para a pagina de pesquisa
                        request.setAttribute("msgValidacao", msgValidacao);
                        request.setAttribute("msgValidacaoController", 1);
                        
                        request.getRequestDispatcher("despesaPrincipal.jsp").forward(request, response); // dispara para essa página
                    }

                } catch (Exception ex) {
                    //se acontecer um problema vai ser tratado igual como não tivesse conteudo
                    Logger.getLogger(ControllerDespesaListar.class.getName()).log(Level.SEVERE, null, ex);
                    
                    request.setAttribute("msgValidacao", msgValidacao);
                    request.setAttribute("msgValidacaoController", 1);

                    request.getRequestDispatcher("despesaPrincipal.jsp").forward(request, response); // dispara para essa página
                    
                }
                
                break;
            }
            
            case 2: { //somente evento
                
                try {
                    //chama o método de comunicação com o banco e recebe o resultado na lista
                    listagemDespesaEvento = despesaFestaBanco.getListagemDeDespesa(exibir2, periodoDespesaConvertido, periodoDespesaConvertido2);
                    
                    if(listagemDespesaEvento.size() > 0) { //se a lista tiver conteudo 
                        
                        //faz o calculo dos valores da despesa de evento
                        for(int i = 0; i < listagemDespesaEvento.size(); i++){
                            
                            valorTotalEvento = valorTotalEvento + listagemDespesaEvento.get(i).getValor();
                            valorPagoEvento = valorPagoEvento + listagemDespesaEvento.get(i).getValorPago();
                            
                        }
                        
                        valorAbertoEvento = valorTotalEvento - valorPagoEvento;
                        
                        //adiciona os parametro no response e dispacha para a pagina de listagem
                        request.setAttribute("listagemDespesaEvento", listagemDespesaEvento);
                        request.setAttribute("origemEvento", 1);
                        request.setAttribute("origem", origem);
                        request.setAttribute("exibir", exibir);                        
                        request.setAttribute("origemDaDespesa", origemDaDespesa);
                        request.setAttribute("exibirDespesa", exibirDespesa);
                        request.setAttribute("periodoDespesa", periodoDespesa);
                        request.setAttribute("periodoDespesa2", periodoDespesa2);
                        request.setAttribute("valorTotalEvento", valorTotalEvento);
                        request.setAttribute("valorPagoEvento", valorPagoEvento);
                        request.setAttribute("valorAbertoEvento", valorAbertoEvento);                        
                        
                        request.getRequestDispatcher("despesaListagem.jsp").forward(request, response); // dispara para essa página
                        
                    }else{ //se a lista não tiver conteudo 
                        
                        //adiciona os parametro no response e dispacha para a pagina de pesquisa
                        request.setAttribute("msgValidacao", msgValidacao);
                        request.setAttribute("msgValidacaoController", 1);
                        
                        request.getRequestDispatcher("despesaPrincipal.jsp").forward(request, response); // dispara para essa página
                    }                    
                    
                } catch (Exception ex) {
                    
                    Logger.getLogger(ControllerDespesaListar.class.getName()).log(Level.SEVERE, null, ex);
                    
                    request.setAttribute("msgValidacao", msgValidacao);
                    request.setAttribute("msgValidacaoController", 1);

                    request.getRequestDispatcher("despesaPrincipal.jsp").forward(request, response); // dispara para essa página
                    
                }
                
                break;
            }
                  
            case 3: { //ambas
                
                try {

                    //recebe as despesas através dos metodos de comunicação com o banco de dados
                    listagemDespesaEvento = despesaFestaBanco.getListagemDeDespesa(exibir2, periodoDespesaConvertido, periodoDespesaConvertido2);                
                    listagemDespesaDespesa = despesaBanco.getListagemDeDespesa(exibir2, periodoDespesaConvertido, periodoDespesaConvertido2);

                    if(listagemDespesaEvento.size() > 0 || listagemDespesaDespesa.size() > 0) { //se uma das 2 lista tiver conteudo
                        
                        //verifica se tem despesa de evento
                        if(listagemDespesaEvento.size() > 0){
                            
                            //faz o calculo dos valores da despesa de evento
                            for(int i = 0; i < listagemDespesaEvento.size(); i++){

                                valorTotalEvento = valorTotalEvento + listagemDespesaEvento.get(i).getValor();
                                valorPagoEvento = valorPagoEvento + listagemDespesaEvento.get(i).getValorPago();

                            }

                            valorAbertoEvento = valorTotalEvento - valorPagoEvento;
                        
                            //adiciona os parametro no response e dispacha para a pagina de listagem
                            request.setAttribute("listagemDespesaEvento", listagemDespesaEvento);
                            request.setAttribute("origemEvento", 1);
                            request.setAttribute("valorTotalEvento", valorTotalEvento);
                            request.setAttribute("valorPagoEvento", valorPagoEvento);
                            request.setAttribute("valorAbertoEvento", valorAbertoEvento);                               
                            
                        }else{
                            
                            //adiciona os parametro no response e dispacha para a pagina de listagem
                            request.setAttribute("msgTratamentoSemConteudo", msgValidacao);
                            request.setAttribute("origemEventoSemConteudo", 1);                        
                            
                        }
                        
                        //verifica se tem despesa de despesa
                        if(listagemDespesaDespesa.size() > 0){
                            
                            //faz o calculo dos valores da despesa de despesa
                            for(int i = 0; i < listagemDespesaDespesa.size(); i++){

                                valorTotalDespesa = valorTotalDespesa + listagemDespesaDespesa.get(i).getValor();
                                valorPagoDespesa = valorPagoDespesa + listagemDespesaDespesa.get(i).getValorPago();

                            }

                            valorAbertoDespesa = valorTotalDespesa - valorPagoDespesa;
                        
                            //adiciona os parametro no response e dispacha para a pagina de listagem
                            request.setAttribute("listagemDespesaDespesa", listagemDespesaDespesa);
                            request.setAttribute("origemDespesa", 1);
                            request.setAttribute("valorTotalDespesa", valorTotalDespesa);
                            request.setAttribute("valorPagoDespesa", valorPagoDespesa);
                            request.setAttribute("valorAbertoDespesa", valorAbertoDespesa);                            
                            
                        }else{
                         
                            //adiciona os parametro no response e dispacha para a pagina de listagem
                            request.setAttribute("msgTratamentoSemConteudo", msgValidacao);
                            request.setAttribute("origemDespesaSemConteudo", 1);                        
                            
                        }
                        
                        request.setAttribute("origemDaDespesa", origemDaDespesa);
                        request.setAttribute("exibirDespesa", exibirDespesa);
                        request.setAttribute("origem", origem);
                        request.setAttribute("exibir", exibir);                        
                        request.setAttribute("periodoDespesa", periodoDespesa);
                        request.setAttribute("periodoDespesa2", periodoDespesa2);
                        
                        request.getRequestDispatcher("despesaListagem.jsp").forward(request, response); // dispara para essa página

                    }else{ //se nenhuma das duas lista tiver conteudo

                        //adiciona os parametro no response e dispacha para a pagina de pesquisa
                        request.setAttribute("msgValidacao", msgValidacao);
                        request.setAttribute("msgValidacaoController", 1);

                        request.getRequestDispatcher("despesaPrincipal.jsp").forward(request, response); // dispara para essa página
                    }                

                } catch (Exception ex) {

                    Logger.getLogger(ControllerDespesaListar.class.getName()).log(Level.SEVERE, null, ex);

                    request.setAttribute("msgValidacao", msgValidacao);
                    request.setAttribute("msgValidacaoController", 1);

                    request.getRequestDispatcher("despesaPrincipal.jsp").forward(request, response); // dispara para essa página

                }
                
                break;
                
            }

        }
  
    } 
}
