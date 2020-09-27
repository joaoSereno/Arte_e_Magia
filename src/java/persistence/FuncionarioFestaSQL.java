/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.FuncionarioFesta;

/**
 *
 * @author João Pedro
 */
public class FuncionarioFestaSQL extends Conexao{
    
    public void create(FuncionarioFesta funcionarioFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("INSERT INTO funcionariofesta(idFuncionario, cacheDaFesta, idFesta) VALUES(?,?,?)");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, funcionarioFesta.getIdFuncionario());
        stmt.setFloat(2, funcionarioFesta.getCacheFesta());
        stmt.setInt(3, funcionarioFesta.getIdFesta());

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }    
    
    public void excluir(int idFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("DELETE FROM funcionariofesta WHERE idFesta = ?");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, idFesta);

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }
    
}
