/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.HorarioFesta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public ArrayList<HorarioFesta> getHorarioFestaEspecifica(int idEvento) throws Exception {
        try {
            open(); //abre conexão com o banco
            ArrayList<HorarioFesta> listaHorarioFesta = new ArrayList();

            stmt = con.prepareStatement("SELECT idHorarioFesta,\n" +
                                        "	horario,\n" +
                                        "	descricao,\n" +
                                        "	idFesta\n" +
                                        "FROM horariofesta\n" +
                                        "WHERE idFesta = ?"); //executa query na base               
            
            stmt.setInt(1, idEvento); //seta idEvento no ?
            
            ResultSet resultadoConsulta = stmt.executeQuery();

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                HorarioFesta horarioFesta = new HorarioFesta();

                horarioFesta.setIdHorarioFesta(resultadoConsulta.getInt("idHorarioFesta"));
                horarioFesta.setHorario(resultadoConsulta.getString("horario"));
                horarioFesta.setDescricao(resultadoConsulta.getString("descricao"));
                horarioFesta.setIdFesta(resultadoConsulta.getInt("idFesta"));

                listaHorarioFesta.add(horarioFesta);
            }
            close();
            return listaHorarioFesta;

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
