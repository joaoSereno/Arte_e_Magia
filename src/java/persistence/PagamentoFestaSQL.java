/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.PagamentoFesta;

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
    
}
