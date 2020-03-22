/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.despesa;
import entidades.PagamentoDespesasDetalhe;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeDespesa/teste")
public class teste extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int countDespesa2 = 0;
        ArrayList<PagamentoDespesasDetalhe> listaDespesasInseridas = new ArrayList();
        
        String countDespesa = request.getParameter("countDespesa");
        if (countDespesa != null) { //se existir cliente

            if (!countDespesa.equals("")) {

                countDespesa2 = Integer.parseInt(countDespesa);

            }
        }
        
        if(countDespesa2 != 0){
            for(int i = 0; i < countDespesa2; i++){
                PagamentoDespesasDetalhe pagamentoDespesasDetalhe = new PagamentoDespesasDetalhe();
                float valorDespesa2 = 0;
                
                //pegando a lista de despesas do front
                String dataDespesa = request.getParameter("dataDespesa"+(i+1));
                
                String valorDespesa = request.getParameter("valorDespesa"+(i+1));
                if(valorDespesa != null){
                    if(!valorDespesa.equals("")){
                        valorDespesa2 = Float.parseFloat(valorDespesa);
                    }
                }
                
                String despesaIsPago = request.getParameter("despesaIsPago"+(i+1));
                
                //setando os valores pegos na variavel
                if(dataDespesa != null){
                    pagamentoDespesasDetalhe.setDataPagamento(dataDespesa);                    
                }

                if(valorDespesa2 != 0){
                    pagamentoDespesasDetalhe.setValor(valorDespesa2);                   
                }

                if(despesaIsPago != null){
                    if(despesaIsPago.equals("Sim")){
                        pagamentoDespesasDetalhe.setStatus(1);
                    }else{
                        pagamentoDespesasDetalhe.setStatus(0);
                    }  
                }
                
                //add variavel na lista de despesas do back-end
                if(dataDespesa != null && despesaIsPago != null && valorDespesa != null){
                    listaDespesasInseridas.add(pagamentoDespesasDetalhe);   
                }
                
            } 
        }
        
    }

}
