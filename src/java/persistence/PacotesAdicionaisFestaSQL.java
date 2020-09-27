/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.PacotesAdicionaisFesta;

/**
 *
 * @author João Pedro
 */
public class PacotesAdicionaisFestaSQL extends Conexao{
    
    public void create(PacotesAdicionaisFesta pacotesAdicionaisFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("INSERT INTO pacotesadicionaisfesta(valorPacoteAdd, idFesta, idTipoPacoteAdicional) VALUES(?,?,?)");

        //atribui os valores nos ? do comando acima 
        stmt.setFloat(1, pacotesAdicionaisFesta.getValorPacoteAdd());
        stmt.setInt(2, pacotesAdicionaisFesta.getIdFesta());
        stmt.setInt(3, pacotesAdicionaisFesta.getIdTipoPacoteAdicional());

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }
    
    public void excluir(int idFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("DELETE FROM pacotesadicionaisfesta WHERE idFesta = ?");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, idFesta);

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }    
    
}
