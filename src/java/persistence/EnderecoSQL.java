/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.Enderecos;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author João Pedro
 */
public class EnderecoSQL extends Conexao {

    public void create(Enderecos endereco) throws Exception {

        open(); //abre conexão com o banco de dados 

        if (endereco.getIdCliente() != null) { //se for endereço residencial de cliente
            stmt = con.prepareStatement("INSERT INTO enderecos(cep, cidade, bairro, rua, numero, complemento, idCliente, isFesta) VALUES (?,?,?,?,?,?,?,?)");
        } else { //se for de festa
            stmt = con.prepareStatement("INSERT INTO enderecos(cep, cidade, bairro, rua, numero, complemento, isFesta) VALUES (?,?,?,?,?,?,?)");
        }

        if (endereco.getIdCliente() != null) {//se for endereço residencial de cliente

            //atribui os valores das marcações do comando acima 
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getCidade());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getRua());
            stmt.setString(5, endereco.getNumero());
            stmt.setString(6, endereco.getComplemento());
            stmt.setInt(7, endereco.getIdCliente());
            stmt.setInt(8, endereco.getIsFesta());

        } else {//se for de festa

            //atribui os valores das marcações do comando acima
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getCidade());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getRua());
            stmt.setString(5, endereco.getNumero());
            stmt.setString(6, endereco.getComplemento());
            stmt.setInt(7, endereco.getIsFesta());
        }

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }

    public Enderecos getEnderecoCliente(int idCliente) throws Exception {

        try {
            open(); //abre conexão com o banco

            Enderecos endereco = new Enderecos();

            stmt = con.prepareStatement("SELECT idEnderecos, cep, cidade, bairro, rua, numero, complemento FROM enderecos WHERE idCliente = ?"); //executa query na base
            stmt.setInt(1, idCliente); //seta valor do parametro como condição da query
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) {
                //seta valores pego na consulta na classe endereco 
                endereco.setIdEnderecos(resultadoConsulta.getInt("idEnderecos"));
                endereco.setCep(resultadoConsulta.getString("cep"));
                endereco.setCidade(resultadoConsulta.getString("cidade"));
                endereco.setBairro(resultadoConsulta.getString("bairro"));
                endereco.setRua(resultadoConsulta.getString("rua"));
                endereco.setNumero(resultadoConsulta.getString("numero"));
                endereco.setComplemento(resultadoConsulta.getString("complemento"));
            }

            close(); // fecha conexão com o banco
            return endereco;//retorna endereco para onde foi chamado
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

    public void editarEnderecoCliente(int idEnderecos, String cep, String cidade, String bairro, String rua, String numero, String complemento) throws Exception {

        open(); // abre a conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE enderecos SET cep = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, complemento = ? WHERE idEnderecos = ?");

        //seta valores para comando sql
        stmt.setString(1, cep);
        stmt.setString(2, cidade);
        stmt.setString(3, bairro);
        stmt.setString(4, rua);
        stmt.setString(5, numero);
        stmt.setString(6, complemento);
        stmt.setInt(7, idEnderecos);

        stmt.execute();//executa comando sql

        close();// fecha a conexão 

    }
    
    public void excluirEnderecoCliente(int idCliente) throws Exception{
        
        open(); //abre conexão com o banco de dados  
        
        stmt = con.prepareStatement("DELETE FROM enderecos WHERE idCliente = ?"); // query para executar no banco
        
        stmt.setInt(1, idCliente); //seta getIdCliente no ?
        
        stmt.execute(); // executa query
        
        close(); // fecha conexão com o banco de dados
        
    } 
}
