/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.FestaCrianca;

/**
 *
 * @author João Pedro
 */
public class FestaCriancaSQL extends Conexao{

    public void create(FestaCrianca festaCrianca) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("INSERT INTO festacrianca(idFesta, idCrianca) VALUES(?,?)");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, festaCrianca.getIdFesta());
        stmt.setInt(2, festaCrianca.getIdCrianca());

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }

    public void excluir(int idFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("DELETE FROM festacrianca WHERE idFesta = ?");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, idFesta);

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }    
}
