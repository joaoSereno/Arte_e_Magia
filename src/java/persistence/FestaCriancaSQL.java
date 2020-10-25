/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.FestaCrianca;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public ArrayList<FestaCrianca> getFestaCriancaEspecifica(int idEvento) throws Exception {
        try {
            open(); //abre conexão com o banco
            ArrayList<FestaCrianca> listaFestaCrianca = new ArrayList();

            stmt = con.prepareStatement("SELECT idFestaCrianca,\n" +
                                        "	idFesta,\n" +
                                        "	idCrianca\n" +
                                        "FROM festacrianca\n" +
                                        "WHERE idFesta = ?"); //executa query na base               
            
            stmt.setInt(1, idEvento); //seta idEvento no ?
            
            ResultSet resultadoConsulta = stmt.executeQuery();

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                FestaCrianca festaCrianca = new FestaCrianca();

                //seta valores retornados pelo banco na variavel do tipo despesa
                festaCrianca.setIdFestaCrianca(resultadoConsulta.getInt("idFestaCrianca"));
                festaCrianca.setIdFesta(resultadoConsulta.getInt("idFesta"));
                festaCrianca.setIdFestaCrianca(resultadoConsulta.getInt("idCrianca"));

                listaFestaCrianca.add(festaCrianca);
            }
            close();
            return listaFestaCrianca;

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
