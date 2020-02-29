/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.Crianca;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class CriancaSQL extends Conexao {

    public void create(Crianca crianca) throws Exception { //recebe crianca vindo do controller

        open(); //abre conexão com o banco de dados

        //define comando para o banco de dados
        stmt = con.prepareStatement("INSERT INTO crianca(nomeCrianca, sexo, dataNascimento, ativo, idCliente) VALUES(?,?,?,?,?)");

        //atribui os valores das marcações do comando acima 
        stmt.setString(1, crianca.getNomeCrianca());
        stmt.setString(2, crianca.getSexo());
        stmt.setString(3, crianca.getDataNascimento());
        stmt.setInt(4, 1);
        stmt.setInt(5, crianca.getIdCliente());

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }

    public void editarCadastroCrianca(Crianca crianca) throws Exception {

        open(); // abre a conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE cliente SET nomeCrianca = ?, sexo = ?, dataNascimento = ? where idCrianca = ?");

        //seta valores para comando sql
        stmt.setString(1, crianca.getNomeCrianca());
        stmt.setString(2, crianca.getSexo());
        stmt.setString(3, crianca.getDataNascimento());
        stmt.setInt(4, crianca.getIdCrianca());

        stmt.execute();//executa comando sql

        close();// fecha a conexão 

    }

    public ArrayList<Crianca> getCrianca(int idCliente) throws Exception {
        try {
            open(); //abre conexão com o banco
            ArrayList<Crianca> listaCrianca = new ArrayList(); //instancia uma arrayList de Crianca

            stmt = con.prepareStatement("SELECT idCrianca, nomeCrianca, sexo, dataNascimento, idCliente FROM crianca WHERE idCliente = ? AND ativo = 1"); //executa query na base               

            //seta valores para comando sql
            stmt.setInt(1, idCliente);

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                Crianca crianca = new Crianca(); //toda vez que passar no while vai criar uma variavel do tipo Crianca

                //seta valores retornados pelo banco na variavel do tipo crianca
                crianca.setIdCrianca(resultadoConsulta.getInt("idCrianca"));
                crianca.setNomeCrianca(resultadoConsulta.getString("nomeCrianca"));
                crianca.setSexo(resultadoConsulta.getString("sexo"));
                crianca.setDataNascimento(resultadoConsulta.getString("dataNascimento"));
                crianca.setIdCliente(resultadoConsulta.getInt("idCliente"));

                listaCrianca.add(crianca);// add na lista de forma de pagamento
            }
            close(); // fecha conexão com o banco
            return listaCrianca;//retorna a lista de crianca para onde foi chamado

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

    public void inativarCadastro(int idCrianca) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE crianca SET ativo = 0 WHERE idCrianca = ?");

        stmt.setInt(1, idCrianca); //seta idCrianca no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }

    public void inativarTodosCadastroCliente(int idCliente) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE crianca SET ativo = 0 WHERE idCliente = ?");

        stmt.setInt(1, idCliente); //seta idCliente no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }

}
