/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.ValorAdicionalFesta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class ValorAdicionalFestaSQL extends Conexao{
    
    public void create(ValorAdicionalFesta valorAdicionalFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("INSERT INTO valoradicionalfesta(descricao, valor, idFesta) VALUES (?,?,?)");

        //atribui os valores nos ? do comando acima 
        stmt.setString(1, valorAdicionalFesta.getDescricao());
        stmt.setFloat(2, valorAdicionalFesta.getValor());
        stmt.setInt(3, valorAdicionalFesta.getIdFesta());

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }

    public void excluir(int idFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("DELETE FROM valoradicionalfesta WHERE idFesta = ?");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, idFesta);

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }

    public ArrayList<ValorAdicionalFesta> getValorAdicionalFestaEspecifica(int idEvento) throws Exception {
        try {
            open(); //abre conexão com o banco
            ArrayList<ValorAdicionalFesta> listaValorAdicionalFesta = new ArrayList();

            stmt = con.prepareStatement("SELECT  idValorAdicionalFesta,\n" +
                                        "	 descricao,\n" +
                                        "	 valor,\n" +
                                        "	 idFesta\n" +
                                        "FROM valoradicionalfesta\n" +
                                        "where idFesta = ?"); //executa query na base               
            
            stmt.setInt(1, idEvento); //seta idEvento no ?
            
            ResultSet resultadoConsulta = stmt.executeQuery();

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                ValorAdicionalFesta valorAdicionalFesta = new ValorAdicionalFesta();
                
                valorAdicionalFesta.setIdValorAdicionalFesta(resultadoConsulta.getInt("idValorAdicionalFesta"));
                valorAdicionalFesta.setDescricao(resultadoConsulta.getString("descricao"));
                valorAdicionalFesta.setValor(resultadoConsulta.getFloat("valor"));
                valorAdicionalFesta.setIdFesta(resultadoConsulta.getInt("idFesta"));

                listaValorAdicionalFesta.add(valorAdicionalFesta);
            }
            close();
            return listaValorAdicionalFesta;

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
