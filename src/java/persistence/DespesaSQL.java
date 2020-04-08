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
import entidades.Despesas;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author João Pedro
 */
public class DespesaSQL extends Conexao{
    
    public void createDespesa(Despesas despesa) throws Exception { //recebe crianca vindo do controller

        open(); //abre conexão com o banco de dados

        //define comando para o banco de dados
        if(despesa.getIdTipoDeDespesa() == null ){ //se não tiver idTipoDeDespesa
            
            stmt = con.prepareStatement("INSERT INTO despesas(descricao, obs, status) VALUES (?,?,?)");
       
            //atribui os valores das marcações do comando acima 
            stmt.setString(1, despesa.getDescricaoDespesa());
            stmt.setString(2, despesa.getObs());
            stmt.setInt(3, despesa.getStatusDespesa());     
            
        }else{ //se tiver
            
            stmt = con.prepareStatement("INSERT INTO despesas(descricao, idTipoDeDespesa, obs, status) VALUES (?,?,?,?)");               

            //atribui os valores das marcações do comando acima 
            stmt.setString(1, despesa.getDescricaoDespesa());
            stmt.setInt(2, despesa.getIdTipoDeDespesa());    
            stmt.setString(3, despesa.getObs());
            stmt.setInt(4, despesa.getStatusDespesa());     
            
        }

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }    

    public int getUltimoIdDespesas() throws Exception {

        try {
            open(); //abre conexão com o banco
            int idDespesas = 0; //idDespesas de retorno

            stmt = con.prepareStatement("SELECT idDespesas FROM despesas ORDER BY 1 DESC limit 1"); //executa query na base
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) {
                idDespesas = resultadoConsulta.getInt("idDespesas");
            }

            close(); // fecha conexão com o banco
            return idDespesas;//retorna idDespesas para onde foi chamado
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
