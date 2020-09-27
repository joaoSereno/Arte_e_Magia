/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.ValorAdicionalFesta;

/**
 *
 * @author João Pedro
 */
public class ValorAdicionalFestaSQL extends Conexao{
    
    public void create(ValorAdicionalFesta valorAdicionalFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("INSERT INTO valoradicionalfesta(descricao, valor, idFesta) VALUES (?,?,?)");

        //atribui os valores nos ? do comando acima 
        stmt.setString(1, valorAdicionalFesta.getDescricao());
        stmt.setFloat(2, valorAdicionalFesta.getValor());
        stmt.setInt(3, valorAdicionalFesta.getIdFesta());

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }

    public void excluir(int idFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("DELETE FROM valoradicionalfesta WHERE idFesta = ?");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, idFesta);

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }    
    
}
