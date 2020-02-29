/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.Crianca;

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

    public void inativarCadastro(int idCrianca) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE crianca SET ativo = 0 WHERE idCrianca = ?");

        stmt.setInt(1, idCrianca); //seta idCrianca no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
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
}
