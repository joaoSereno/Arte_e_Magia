/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import static configConexao.Conexao.close;
import static configConexao.Conexao.con;
import static configConexao.Conexao.open;
import static configConexao.Conexao.stmt;
import entidades.Festa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class FestaSQL extends Conexao {

    public void create(Festa festa) throws Exception {

        open(); //abre conexão com o banco de dados 

        //comando que vai ser executado
        stmt = con.prepareStatement("INSERT INTO festa(descricaoFesta, idCliente, qtdCriancas, dataFesta, idPacote, idTipoDeFesta, idEnderecos, obs, valorTotal, totalDespesa, lucroEvento, receberContrante, festaStatus) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

        //atribui os valores nos ? do comando acima 
        stmt.setString(1, festa.getDescricaoFesta()); //descricaoFesta
        stmt.setInt(2, festa.getIdCliente()); //idCliente
        stmt.setInt(3, festa.getQtdCriancas()); //qtdCriancas
        stmt.setString(4, festa.getDataFesta()); //dataFesta
        stmt.setInt(5, festa.getIdPacote()); //idPacote
        stmt.setInt(6, festa.getIdTipoDeFesta()); //idTipoDeFesta
        stmt.setInt(7, festa.getIdEnderecos()); //idEnderecos
        stmt.setString(8, festa.getObs()); //obs
        stmt.setFloat(9, festa.getValorTotal()); //valorTotal
        stmt.setFloat(10, festa.getTotalDespesa()); //totalDespesa
        stmt.setFloat(11, festa.getLucroFesta()); //lucroEvento
        stmt.setFloat(12, festa.getReceberContrante()); //recebeContrante
        stmt.setInt(13, festa.getFestaStatus()); //festaStatus

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }

    public int getUltimoIdFesta() throws Exception {
        try {
            open(); //abre conexão com o banco
            int idFesta = 0; //idFesta de retorno

            stmt = con.prepareStatement("SELECT idFesta FROM festa ORDER BY 1 DESC LIMIT 1"); //executa query na base
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) {
                idFesta = resultadoConsulta.getInt("idFesta");
            }

            close(); // fecha conexão com o banco
            return idFesta;//retorna idFesta para onde foi chamado

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

    public ArrayList<Festa> getFestaListagem(int statusEvento, String periodoEvento, String periodoEvento2) throws Exception {
        try {
            open(); //abre conexão com o banco
            
            //cria lista que será retornada
            ArrayList<Festa> listaFesta = new ArrayList();
            
            //verifica o filtro e salva a query
            switch (statusEvento) {
                case 1:
                    stmt = con.prepareStatement("SELECT idFesta, \n"
                                                + "descricaoFesta, \n"
                                                + "	DATE_FORMAT(dataFesta, '%d/%m/%Y'), \n"
                                                + "festaStatus \n"
                                                + "FROM festa\n"
                                                + "WHERE dataFesta >= ? \n"
                                                + "AND dataFesta <= ? \n"
                                                + "AND festaStatus = 0 \n"
                                                + "ORDER BY DATE_FORMAT(dataFesta, '%d/%m/%Y')");

                    break;
                    
                case 2:
                    stmt = con.prepareStatement("SELECT idFesta, \n"
                                                + "descricaoFesta, \n"
                                                + "	DATE_FORMAT(dataFesta, '%d/%m/%Y'), \n"
                                                + "festaStatus \n"
                                                + "FROM festa\n"
                                                + "WHERE dataFesta >= ? \n"
                                                + "AND dataFesta <= ? \n"
                                                + "AND festaStatus = 1 \n"
                                                + "ORDER BY DATE_FORMAT(dataFesta, '%d/%m/%Y')");                 
            
                    break;
                    
                default:
                    stmt = con.prepareStatement("SELECT idFesta, \n"
                            + "descricaoFesta, \n"
                            + "DATE_FORMAT(dataFesta, '%d/%m/%Y'), \n"
                            + "festaStatus \n"
                            + "FROM festa\n"
                            + "WHERE dataFesta >= ? \n"
                            + "AND dataFesta <= ?\n"
                            + "ORDER BY DATE_FORMAT(dataFesta, '%d/%m/%Y')");                      
                    
                    break;
            }
            
            //define valor dos ?
            stmt.setString(1, periodoEvento);
            stmt.setString(2, periodoEvento2);
            
            //executa a query no banco
            ResultSet resultadoConsulta = stmt.executeQuery();
            
            //percorre o resultado e monta o dados da lista que será retornado
            while (resultadoConsulta.next()) {
                Festa festa = new Festa();

                //seta valores pegos no select no cliente
                festa.setIdFesta(resultadoConsulta.getInt("idFesta"));
                festa.setDescricaoFesta(resultadoConsulta.getString("descricaoFesta"));
                festa.setDataFesta(resultadoConsulta.getString("DATE_FORMAT(dataFesta, '%d/%m/%Y')"));
                festa.setFestaStatus(resultadoConsulta.getInt("festaStatus"));

                listaFesta.add(festa);
            }
            close(); // fecha conexão com o banco
            
            return listaFesta; //retorna a lista de festa

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
