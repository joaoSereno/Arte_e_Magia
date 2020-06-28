/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.despesa;

import entidades.Despesas;
import entidades.FormaPagamento;
import entidades.PagamentoDespesasDetalhe;
import entidades.TipoDeDespesa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.DespesaSQL;
import persistence.PagamentoDespesaDetalheSQL;
import persistence.TipoDespesaSQL;
import persistence.TipoPagamentoSQL;
import util.Conversor;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeDespesa/editarDespesa")
public class ControllerDespesaEditar1 extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDespesas2 = 0;
        Conversor conversor = new Conversor();
                
        //pegando do request as informações necessarias
        String origem = request.getParameter("origem");  
        String exibir = request.getParameter("exibir");
        String periodoDespesa = request.getParameter("periodoDespesa");
        String periodoDespesa2 = request.getParameter("periodoDespesa2");
        
        String idDespesa = request.getParameter("idDespesa");
        if (idDespesa != null) {

            if (!idDespesa.equals("")) {
                idDespesas2 = Integer.parseInt(idDespesa);
            }

        }        
        
        //instanciando as classe de comunicação com o banco de dados e as entidades
        PagamentoDespesaDetalheSQL pagamentoDespesaDetalheBanco = new PagamentoDespesaDetalheSQL();
        DespesaSQL despesaBanco = new DespesaSQL();
        TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL();
        TipoPagamentoSQL tipoPagamentoBanco = new TipoPagamentoSQL();        

        Despesas despesas = new Despesas();
        ArrayList<PagamentoDespesasDetalhe> listaPagamentoDespesasDetalhe = new ArrayList();
        List<TipoDeDespesa> listaTipoDespesas;
        List<FormaPagamento> listaTipoPagamento;
   
        try {
            
            //recebendo os dos cadastros que serão listados
            listaTipoDespesas = tipoDespesaBanco.getTipoDeDespesa();
            listaTipoPagamento = tipoPagamentoBanco.getFormaPagamento();
            
            //recebendo os valores da despesa que vai ser editada
            despesas = despesaBanco.getDespesa(idDespesas2);
            listaPagamentoDespesasDetalhe = pagamentoDespesaDetalheBanco.getPagamentoDespesasDetalhe(idDespesas2);
            
            //verificando se é tipo descrição ou tipo despesa
            if(despesas.getIdTipoDeDespesa() != 0){ //se for tipo de despesa , retira da listagem o tipo de despesa
                
                for(int x = 0; x < listaTipoDespesas.size(); x++){
                    
                   if(despesas.getIdTipoDeDespesa() == listaTipoDespesas.get(x).getIdTipoDeDespesa()){
                       
                       listaTipoDespesas.remove(x);
                       
                       x = listaTipoDespesas.size();
                   } 
                   
                }
                
                request.setAttribute("controllerTipoCadastroDespesa", 1);
                request.setAttribute("valorOptionTipoDespesa", despesas.getIdTipoDeDespesa() + "+" + despesas.getDescricaoDespesa());
 
            }else{ //se for descrição
                
                request.setAttribute("controllerTipoCadastroDespesa", 2);
                
            }
            
            String listaPagamentoDespesasDetalheString = "";
            float totalDespesa = 0;
            float valorPago = 0;
            float valorApagar = 0;
            
            //percorrendo os pagamentos para montar as coisas necessarias
            for(int i = 0; i < listaPagamentoDespesasDetalhe.size(); i++){
                
                //calculando valores que será enviado para o front
                totalDespesa = totalDespesa + listaPagamentoDespesasDetalhe.get(i).getValor();

                if(listaPagamentoDespesasDetalhe.get(i).getStatus() == 1){
                    valorPago = valorPago + listaPagamentoDespesasDetalhe.get(i).getValor();
                }else{
                    valorApagar = valorApagar + listaPagamentoDespesasDetalhe.get(i).getValor();
                }

                //montando string concatenada que será enviada para o front-end das despesas
                String formaPagamento = "";
                
                //monta a parte de forma de pagamento
                for(int a = 0; a < listaTipoPagamento.size(); a++){
                    
                    if(listaPagamentoDespesasDetalhe.get(i).getIdFormaPagamento() == listaTipoPagamento.get(a).getIdFormaPagamento()){
                        
                        formaPagamento = Integer.toString(listaTipoPagamento.get(a).getIdFormaPagamento()) + "+" + listaTipoPagamento.get(a).getNomePagamento();
                        
                        a = listaTipoPagamento.size();
                        
                    }
                    
                }
                
                listaPagamentoDespesasDetalheString = 
                listaPagamentoDespesasDetalheString + Float.toString(listaPagamentoDespesasDetalhe.get(i).getValor()) + "," 
                + formaPagamento + "," 
                + conversor.formatarData2(listaPagamentoDespesasDetalhe.get(i).getDataPagamento()) + "," 
                + Integer.toString(listaPagamentoDespesasDetalhe.get(i).getStatus()) + "|";
                                    
            }
            
            //setando os atributos que serão enviados para o front
            request.setAttribute("listaPagamentoDespesasDetalheQtd", listaPagamentoDespesasDetalhe.size());
            request.setAttribute("listaPagamentoDespesasDetalheString", listaPagamentoDespesasDetalheString);
            request.setAttribute("totalDespesa", totalDespesa);
            request.setAttribute("valorPago", valorPago);
            request.setAttribute("valorApagar", valorApagar);
            request.setAttribute("despesas", despesas);
            request.setAttribute("listaTipoDespesas", listaTipoDespesas);
            request.setAttribute("listaTipoPagamento", listaTipoPagamento);
            
            request.setAttribute("origem", origem);
            request.setAttribute("exibir", exibir);
            request.setAttribute("periodoDespesa", periodoDespesa);
            request.setAttribute("periodoDespesa2", periodoDespesa2);
            
            //dispachando para a página
            request.getRequestDispatcher("despesaEditar.jsp").forward(request, response); // dispara para essa página            
                    
        } catch (Exception ex) {
            Logger.getLogger(ControllerDespesaEditar1.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
