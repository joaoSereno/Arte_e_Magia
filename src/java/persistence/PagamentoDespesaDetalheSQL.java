/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.PagamentoDespesasDetalhe;
import entidadesRelatorio.ListagemDeDespesa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class PagamentoDespesaDetalheSQL extends Conexao {

    public void createDespesaDetalhe(ArrayList<PagamentoDespesasDetalhe> listaDespesasInseridas, int idDespesa) throws Exception { //recebe uma lista de despesa vindo do controller

        for(int i=0; i < listaDespesasInseridas.size(); i++){
            
            open(); //abre conexão com o banco de dados

            //define comando para o banco de dados
            stmt = con.prepareStatement("INSERT INTO pagamentoDespesasDetalhe(valor, dataPagamento, status, idDespesas, idFormaPagamento) VALUES (?,?,?,?,?)");

            //atribui os valores das marcações do comando acima 
            stmt.setFloat(1, listaDespesasInseridas.get(i).getValor());
            stmt.setString(2, listaDespesasInseridas.get(i).getDataPagamento());
            stmt.setInt(3, listaDespesasInseridas.get(i).getStatus());
            stmt.setInt(4, idDespesa);
            stmt.setInt(5, listaDespesasInseridas.get(i).getIdFormaPagamento());

            stmt.execute();//executa  insert no banco de dados

            close();//fecha conexão com o banco de dados
            
        }     

    }
    
    public ListagemDeDespesa getMontagemListagemDeDespesa(int idDespesas) throws Exception {

        try {

            open(); //abre conexão com o banco
            
            //variaveis ncessarias
            ListagemDeDespesa listagemDeDespesa = new ListagemDeDespesa();
            float valorTotal = 0;
            float valorPago = 0;

            stmt = con.prepareStatement("SELECT valor,\n" +
                                        "	status\n" +
                                        "FROM pagamentodespesasdetalhe\n" +
                                        "WHERE idDespesas = ?"); //query

            //parametros da query
            stmt.setInt(1, idDespesas);

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel
            
            //percorre o resultado da query e calculo os valores que faltam no ListagemDeDespesa
            while (resultadoConsulta.next()) {
                
                float valor = resultadoConsulta.getFloat("valor");
                int status = resultadoConsulta.getInt("status");
                
                valorTotal = valorTotal + valor;
                
                if(status == 1){
                    valorPago = valorPago + valor;
                }
            }
            
            close(); // fecha conexão com o banco  
            
            //seta os valores calculos no ListagemDeDespesa
            listagemDeDespesa.setValor(valorTotal);
            listagemDeDespesa.setValorPago(valorPago);

            return listagemDeDespesa; // retorna para onde foi chamado

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                close();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }

    }
    
    public ArrayList<PagamentoDespesasDetalhe> getPagamentoDespesasDetalhe(int idDespesas) throws Exception {

        try {

            open(); //abre conexão com o banco
            
            ArrayList<PagamentoDespesasDetalhe> listaPagamentoDespesasDetalhe = new ArrayList();

            stmt = con.prepareStatement("SELECT  idPagamentoDespesas,\n" +
                                        "	 valor,\n" +
                                        "        dataPagamento,\n" +
                                        "        status,\n" +
                                        "        idFormaPagamento,\n" +
                                        "        idDespesas\n" +
                                        "FROM pagamentodespesasdetalhe\n" +
                                        "where idDespesas = ?"); //query

            //parametros da query
            stmt.setInt(1, idDespesas);

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel
            
            //percorre o resultado da query
            while (resultadoConsulta.next()) {
                
                PagamentoDespesasDetalhe pagamentoDespesasDetalhe = new PagamentoDespesasDetalhe();
                
                pagamentoDespesasDetalhe.setIdPagamentoDespesas(resultadoConsulta.getInt("idPagamentoDespesas"));
                pagamentoDespesasDetalhe.setValor(resultadoConsulta.getFloat("valor"));
                pagamentoDespesasDetalhe.setIdFormaPagamento(resultadoConsulta.getInt("idFormaPagamento"));
                pagamentoDespesasDetalhe.setDataPagamento(resultadoConsulta.getString("dataPagamento"));
                pagamentoDespesasDetalhe.setStatus(resultadoConsulta.getInt("status"));
                pagamentoDespesasDetalhe.setIdDespesas(resultadoConsulta.getInt("idDespesas"));

                listaPagamentoDespesasDetalhe.add(pagamentoDespesasDetalhe);
            }
            
            close(); // fecha conexão com o banco  

            return listaPagamentoDespesasDetalhe; // retorna para onde foi chamado

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                close();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }

    }
    
    public void excluirDespesa(int idDespesas) throws Exception {
        
        open(); //abre conexão com o banco de dados  

        stmt = con.prepareStatement("DELETE FROM pagamentodespesasdetalhe WHERE idDespesas = ?"); // query para executar no banco

        stmt.setInt(1, idDespesas); 

        stmt.execute(); // executa query

        close(); // fecha conexão com o banco de dados     
        
    }    

}
