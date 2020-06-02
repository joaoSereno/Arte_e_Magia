/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.despesa;

import entidadesRelatorio.ListagemDeDespesa;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        
        Conversor conversor = new Conversor();
        ArrayList<ListagemDeDespesa> listagemDespesaDespesa = new ArrayList(); 
        ArrayList<ListagemDeDespesa> listagemDespesaEvento = new ArrayList(); 
        
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

        switch (origem2) {
            case 1: //somente despesa
                

                    
                break;

            case 2: //somente evento
                
                                   
                break;

            case 3: //ambas

                                   
                break;
        }

//        switch (origem2) {
//            case 1: //somente despesa
//                
//                    switch (exibir2) {
//                        case 1: //nao pagas
//                            
//                            if(periodoDespesaConvertido.equals("") && periodoDespesaConvertido2.equals("")){
//                                
//                            }else{
//                                    
//                            }
//
//                            break;
//
//                        case 2: //pagas
//                            
//                            if(periodoDespesaConvertido.equals("") && periodoDespesaConvertido2.equals("")){
//                                
//                            }else{
//                                    
//                            }
//
//                            break;
//
//                        case 3: //ambas
//                            
//                            if(periodoDespesaConvertido.equals("") && periodoDespesaConvertido2.equals("")){
//                                
//                            }else{
//                                    
//                            }
//                            
//                            break;    
//                    }
//                    
//                break;
//
//            case 2: //somente evento
//                
//                    switch (exibir2) {
//                        case 1: //nao pagas
//                            
//                            if(periodoDespesaConvertido.equals("") && periodoDespesaConvertido2.equals("")){
//                                
//                            }else{
//                                    
//                            }
//
//                            break;
//
//                        case 2: //pagas
//                            
//                            if(periodoDespesaConvertido.equals("") && periodoDespesaConvertido2.equals("")){
//                                
//                            }else{
//                                    
//                            }
//
//                            break;
//
//                        case 3: //ambas
//                            
//                            if(periodoDespesaConvertido.equals("") && periodoDespesaConvertido2.equals("")){
//                                
//                            }else{
//                                    
//                            }
//                            
//                            break;    
//                    }
//                                   
//                break;
//
//            case 3: //ambas
//                
//                    switch (exibir2) {
//                        case 1: //nao pagas
//                            
//                            if(periodoDespesaConvertido.equals("") && periodoDespesaConvertido2.equals("")){
//                                
//                            }else{
//                                    
//                            }
//
//                            break;
//
//                        case 2: //pagas
//                            
//                            if(periodoDespesaConvertido.equals("") && periodoDespesaConvertido2.equals("")){
//                                
//                            }else{
//                                    
//                            }
//
//                            break;
//
//                        case 3: //ambas
//                            
//                            if(periodoDespesaConvertido.equals("") && periodoDespesaConvertido2.equals("")){
//                                
//                            }else{
//                                    
//                            }
//                            
//                            break;    
//                    }
//                                   
//                break;
//        }
  
    } 
}
