/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.Pacote;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class PacoteSQL extends Conexao {

    public ArrayList<Pacote> getPacote() throws Exception {
        try {
            open(); //abre conexão com o banco
            ArrayList<Pacote> listaPacote = new ArrayList(); //instancia uma arrayList de Pacote

            stmt = con.prepareStatement("SELECT idPacote, nomePacote, valorPacoteVenda FROM pacote WHERE ativo = 1"); //executa query na base               

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                Pacote pacote = new Pacote(); //toda vez que passar no while vai criar uma variavel do tipo Pacote

                //seta valores retornados pelo banco na variavel do tipo pacote
                pacote.setIdPacote(resultadoConsulta.getInt("idPacote"));
                pacote.setNomePacote(resultadoConsulta.getString("nomePacote"));
                pacote.setValorPacoteVenda(resultadoConsulta.getFloat("valorPacoteVenda"));

                listaPacote.add(pacote);// add na lista de forma de pagamento
            }
            close(); // fecha conexão com o banco
            return listaPacote;//retorna a lista de forma de pagamento para onde foi chamado

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

    public void create(Pacote pacote) throws Exception { //recebe formaPagamento vindo do controller

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("INSERT pacote(nomePacote, valorPacoteVenda, ativo) VALUES(?,?,?)");

        //seta valores no comando insert
        stmt.setString(1, pacote.getNomePacote());
        stmt.setFloat(2, pacote.getValorPacoteVenda());
        stmt.setInt(3, 1);

        stmt.execute();//executa  insert no banco de dados

        close();//fecha conexão com o banco de dados

    }

    public void editaPacote(Pacote pacote) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE pacote SET nomePacote = ? , valorPacoteVenda = ? WHERE idPacote = ?");

        stmt.setString(1, pacote.getNomePacote()); //seta nomePacote no ?
        stmt.setFloat(2, pacote.getValorPacoteVenda()); //seta valorPacoteVenda no ?
        stmt.setInt(3, pacote.getIdPacote()); //seta idPacote no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }
    
    public void inativaPacote(int idPacote) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE pacote SET ativo = 0 WHERE idPacote = ?");
        
        stmt.setInt(1, idPacote); //seta idPacote no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }

    public Pacote getPacoteEspecifico(int idPacote) throws Exception {
        try {
            open(); //abre conexão com o banco
            Pacote pacote = new Pacote();

            stmt = con.prepareStatement("SELECT idPacote, nomePacote, valorPacoteVenda FROM pacote WHERE idPacote = ?"); //executa query na base               
            stmt.setInt(1, idPacote); //seta idTipoDeFesta no ?
            
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { 
               
                //seta valores retornados pelo banco na variavel do tipo pacote
                pacote.setIdPacote(resultadoConsulta.getInt("idPacote"));
                pacote.setNomePacote(resultadoConsulta.getString("nomePacote"));
                pacote.setValorPacoteVenda(resultadoConsulta.getFloat("valorPacoteVenda"));

            }
            close(); // fecha conexão com o banco
            return pacote;//retorn de forma de pagamento para onde foi chamado

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
