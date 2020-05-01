/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.TipoDeFesta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class TipoDeFestaSQL extends Conexao {

    public ArrayList<TipoDeFesta> getTipoDeFesta() throws Exception {
        try {
            open(); //abre conexão com o banco
            ArrayList<TipoDeFesta> listaTipoDeFesta = new ArrayList(); //instancia uma arrayList de TipoDeFesta

            stmt = con.prepareStatement("SELECT idTipoDeFesta, descricaoTipoDeFesta FROM tipoDeFesta WHERE ativo = 1"); //executa query na base               

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                TipoDeFesta tipoDeFesta = new TipoDeFesta(); //toda vez que passar no while vai criar uma variavel do TipoDeFesta

                //seta valores retornados pelo banco na variavel TipoDeFesta
                tipoDeFesta.setIdTipoDeFesta(resultadoConsulta.getInt("idTipoDeFesta"));
                tipoDeFesta.setDescricaoTipoDeFesta(resultadoConsulta.getString("descricaoTipoDeFesta"));

                listaTipoDeFesta.add(tipoDeFesta);// add na lista d
            }
            close(); // fecha conexão com o banco
            return listaTipoDeFesta;//retorna a lista de listaTipoDeFesta para onde foi chamado

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

    public void create(TipoDeFesta tipoDeFesta) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("INSERT INTO tipoDeFesta(descricaoTipoDeFesta, ativo) VALUES (?,?)");

        //seta valores no comando insert
        stmt.setString(1, tipoDeFesta.getDescricaoTipoDeFesta());
        stmt.setInt(2, 1);

        stmt.execute();//executa  insert no banco de dados

        close();//fecha conexão com o banco de dados

    }

    public void editarPacoteAdicional(TipoDeFesta tipoDeFesta) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE tipoDeFesta SET descricaoTipoDeFesta = ? WHERE idTipoDeFesta = ?");

        
        stmt.setString(1, tipoDeFesta.getDescricaoTipoDeFesta());
        stmt.setInt(2, tipoDeFesta.getIdTipoDeFesta());

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados

    }

    public void inativaPacoteAdicional(int idTipoDeFesta) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE tipoDeFesta SET ativo = 0 WHERE idTipoDeFesta = ?");

        stmt.setInt(1, idTipoDeFesta);

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }

    public TipoDeFesta getTipoPacoteAdicionalEspecifico(int idTipoDeFesta) throws Exception {

        try {
            open(); //abre conexão com o banco

            TipoDeFesta tipoDeFesta = new TipoDeFesta(); //instanciando classe que representa o tipo de festa 

            stmt = con.prepareStatement("SELECT idTipoDeFesta, descricaoTipoDeFesta FROM tipoDeFesta WHERE idTipoDeFesta = ?"); //executa query na base               
            stmt.setInt(1, idTipoDeFesta); //seta idTipoDeFesta no ?

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados

                //seta valores retornados pelo banco na variavel TipoDeFesta
                tipoDeFesta.setIdTipoDeFesta(resultadoConsulta.getInt("idTipoDeFesta"));
                tipoDeFesta.setDescricaoTipoDeFesta(resultadoConsulta.getString("descricaoTipoDeFesta"));
                
            }

            close(); // fecha conexão com o banco
            return tipoDeFesta;//retorna o TipoDeFesta para onde foi chamado

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
