/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.PagamentoDespesasDetalhe;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class pagamentoDespesaDetalheSQL extends Conexao {

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

}
