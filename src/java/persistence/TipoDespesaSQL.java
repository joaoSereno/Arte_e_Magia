/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.TipoDeDespesa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class TipoDespesaSQL extends Conexao {

    public ArrayList<TipoDeDespesa> getTipoDeDespesa() throws Exception {
        try {
            open(); //abre conexão com o banco
            ArrayList<TipoDeDespesa> listaTipoDeDespesa = new ArrayList(); //instancia uma arrayList de tipo de despesa

            stmt = con.prepareStatement("SELECT idTipoDeDespesa, nomeDespesa FROM tipoDeDespesa WHERE ativo = 1"); //executa query na base               

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                TipoDeDespesa tipoDeDespesa = new TipoDeDespesa(); //toda vez que passar no while vai criar uma variavel do tipo despesa

                //seta valores retornados pelo banco na variavel do tipo despesa
                tipoDeDespesa.setIdTipoDeDespesa(resultadoConsulta.getInt("idTipoDeDespesa"));
                tipoDeDespesa.setNomeDespesa(resultadoConsulta.getString("nomeDespesa"));

                listaTipoDeDespesa.add(tipoDeDespesa);// add na lista de tipo de despesa
            }
            close(); // fecha conexão com o banco
            return listaTipoDeDespesa;//retorna a lista de tipo de despesa para onde foi chamado

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
    
    public void create(TipoDeDespesa tipoDeDespesa) throws Exception { //recebe formaPagamento vindo do controller

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("INSERT INTO tipoDeDespesa(nomeDespesa,ativo) VALUES (?,?)");

        //seta valores no comando insert
        stmt.setString(1, tipoDeDespesa.getNomeDespesa());
        stmt.setInt(2, 1);

        stmt.execute();//executa  insert no banco de dados

        close();//fecha conexão com o banco de dados

    }
    
    public void editarTipoDespesa(TipoDeDespesa tipoDeDespesa) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE tipoDeDespesa SET nomeDespesa = ? WHERE idTipoDeDespesa = ?");
        
        stmt.setString(1, tipoDeDespesa.getNomeDespesa()); //seta nomeDespesa no ?
        stmt.setInt(2, tipoDeDespesa.getIdTipoDeDespesa()); //seta idTipoDeDespesa no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }
    
    public void inativaTipoDespesa(int idTipoDeDespesa) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE tipoDeDespesa SET ativo = 0 WHERE idTipoDeDespesa = ?");
        
        stmt.setInt(1, idTipoDeDespesa); //seta idTipoDeDespesa no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }
    
    public TipoDeDespesa getTipoDeDespesaEspecifico(int idTipoDeDespesa) throws Exception {
        
        try {
            open(); //abre conexão com o banco
            
            TipoDeDespesa tipoDeDespesa = new TipoDeDespesa(); //instanciando classe que representa o tipo de despesa

            stmt = con.prepareStatement("SELECT idTipoDeDespesa, nomeDespesa FROM tipoDeDespesa WHERE idTipoDeDespesa = ?"); //executa query na base               
            stmt.setInt(1, idTipoDeDespesa); //seta idTipoDeDespesa no ?
            
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados

                //seta valores retornados pelo banco na variavel do tipo despesa
                tipoDeDespesa.setIdTipoDeDespesa(resultadoConsulta.getInt("idTipoDeDespesa"));
                tipoDeDespesa.setNomeDespesa(resultadoConsulta.getString("nomeDespesa"));

            }
            
            close(); // fecha conexão com o banco
            return tipoDeDespesa;//retorna o tipo de despesa para onde foi chamado

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
