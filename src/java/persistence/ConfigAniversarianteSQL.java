/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.ConfigNotificacaoAniversariante;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author João Pedro
 */
public class ConfigAniversarianteSQL extends Conexao{
    
    public void create(ConfigNotificacaoAniversariante configAniversariante) throws Exception { //recebe cliente vindo do controller

        open(); //abre conexão com o banco de dados

        //define comando para o banco de dados
        stmt = con.prepareStatement("INSERT INTO confignotificacaoaniversariante(dias) VALUES(?)");

        //atribui os valores das marcações do comando acima 
        stmt.setInt(1, configAniversariante.getDias());

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }    
    
    public void editarConfigAniversariante(int dias) throws Exception {

        open(); // abre a conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE confignotificacaoaniversariante SET dias = ? where idConfigNotificacaoAniversariante = ?");

        //seta valores para comando sql
        stmt.setInt(1, dias);
        stmt.setInt(2, 1);

        stmt.execute();//executa comando sql

        close();// fecha a conexão 

    }
    
    public ConfigNotificacaoAniversariante getDiasConfigAniversariante(int idConfigNotificacaoAniversariante) throws Exception {

        try {
            open(); //abre conexão com o banco

            ConfigNotificacaoAniversariante configAniversariante = new ConfigNotificacaoAniversariante();

            stmt = con.prepareStatement("SELECT idConfigNotificacaoAniversariante, dias FROM confignotificacaoaniversariante WHERE idConfigNotificacaoAniversariante = ?"); //executa query na base
            stmt.setInt(1, idConfigNotificacaoAniversariante); //seta valor do parametro como condição da query
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) {
                //seta valores pego na consulta na classe cliente 
                configAniversariante.setIdConfigNotificacaoAniversariante(resultadoConsulta.getInt("idConfigNotificacaoAniversariante"));
                configAniversariante.setDias(resultadoConsulta.getInt("dias"));
            }

            close(); // fecha conexão com o banco
            return configAniversariante;//retorna cliente para onde foi chamado
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
