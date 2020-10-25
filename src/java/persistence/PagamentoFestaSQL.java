/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.PagamentoFesta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class PagamentoFestaSQL extends Conexao{
    
    public void create(PagamentoFesta pagamentoFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("INSERT INTO pagamentofesta(valor, pagamentoStatus, idFesta, idFormaPagamento) VALUES (?,?,?,?)");

        //atribui os valores nos ? do comando acima 
        stmt.setFloat(1, pagamentoFesta.getValor());
        stmt.setInt(2, pagamentoFesta.getPagamentoStatus());
        stmt.setInt(3, pagamentoFesta.getIdFesta());
        stmt.setInt(4, pagamentoFesta.getIdFormaDePagamento());

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }  
    
    public void excluir(int idFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("DELETE FROM pagamentofesta WHERE idFesta = ?");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, idFesta);

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }
    
    public ArrayList<PagamentoFesta> getPagamentoFestaEspecifica(int idEvento) throws Exception {
        try {
            open(); //abre conexão com o banco
            ArrayList<PagamentoFesta> listaPagamentoFesta = new ArrayList();

            stmt = con.prepareStatement("SELECT idPagamentoFesta,\n" +
                                        "	valor,\n" +
                                        "	pagamentoStatus,\n" +
                                        "	idFesta,\n" +
                                        "	idFormaPagamento,\n" +
                                        "	dataPagamento \n" +
                                        "FROM pagamentofesta\n" +
                                        "where idFesta = ?"); //executa query na base               
            
            stmt.setInt(1, idEvento); //seta idEvento no ?
            
            ResultSet resultadoConsulta = stmt.executeQuery();

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                PagamentoFesta pagamentoFesta = new PagamentoFesta();
                
                pagamentoFesta.setIdPagamentoFesta(resultadoConsulta.getInt("idPagamentoFesta"));
                pagamentoFesta.setValor(resultadoConsulta.getFloat("valor"));
                pagamentoFesta.setPagamentoStatus(resultadoConsulta.getInt("pagamentoStatus"));
                pagamentoFesta.setIdFesta(resultadoConsulta.getInt("idFesta"));
                pagamentoFesta.setIdFormaDePagamento(resultadoConsulta.getInt("idFormaPagamento"));
                pagamentoFesta.setDataPagamento(resultadoConsulta.getString("dataPagamento"));

                listaPagamentoFesta.add(pagamentoFesta);
            }
            close();
            return listaPagamentoFesta;

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
    
}
