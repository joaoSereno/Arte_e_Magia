/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.HorarioFesta;

/**
 *
 * @author João Pedro
 */
public class HorarioFestaSQL extends Conexao{
    
    public void create(HorarioFesta horarioFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("INSERT INTO horariofesta(horario, descricao, idFesta) VALUES (?,?,?)");

        //atribui os valores nos ? do comando acima 
        stmt.setString(1, horarioFesta.getHorario());
        stmt.setString(2, horarioFesta.getDescricao());
        stmt.setInt(3, horarioFesta.getIdFesta());

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }

    public void excluir(int idFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("DELETE FROM horariofesta WHERE idFesta = ?");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, idFesta);

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }    
    
}
