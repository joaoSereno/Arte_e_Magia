/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.FuncionarioFesta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class FuncionarioFestaSQL extends Conexao{
    
    public void create(FuncionarioFesta funcionarioFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("INSERT INTO funcionariofesta(idFuncionario, cacheDaFesta, idFesta) VALUES(?,?,?)");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, funcionarioFesta.getIdFuncionario());
        stmt.setFloat(2, funcionarioFesta.getCacheFesta());
        stmt.setInt(3, funcionarioFesta.getIdFesta());

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }    
    
    public void excluir(int idFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("DELETE FROM funcionariofesta WHERE idFesta = ?");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, idFesta);

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }
    
    public ArrayList<FuncionarioFesta> getFuncionarioFestaEspecifica(int idEvento) throws Exception {
        try {
            open(); //abre conexão com o banco
            ArrayList<FuncionarioFesta> listaFuncionarioFesta = new ArrayList();

            stmt = con.prepareStatement("SELECT idFuncionarioFesta,\n" +
                                        "	idFuncionario,\n" +
                                        "       cacheDaFesta,\n" +
                                        "       idFesta\n" +
                                        "FROM funcionariofesta\n" +
                                        "WHERE idFesta = ?"); //executa query na base               
            
            stmt.setInt(1, idEvento); //seta idEvento no ?
            
            ResultSet resultadoConsulta = stmt.executeQuery();

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                FuncionarioFesta funcionarioFesta = new FuncionarioFesta();

                //seta valores retornados pelo banco na variavel do tipo despesa
                funcionarioFesta.setIdFuncionarioFesta(resultadoConsulta.getInt("idFuncionarioFesta"));
                funcionarioFesta.setIdFuncionario(resultadoConsulta.getInt("idFuncionario"));
                funcionarioFesta.setCacheFesta(resultadoConsulta.getFloat("cacheDaFesta"));
                funcionarioFesta.setIdFesta(resultadoConsulta.getInt("idFesta"));

                listaFuncionarioFesta.add(funcionarioFesta);
            }
            close();
            return listaFuncionarioFesta;

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
