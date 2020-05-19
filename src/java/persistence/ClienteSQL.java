/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class ClienteSQL extends Conexao {

    public void create(Cliente cliente) throws Exception { //recebe cliente vindo do controller

        open(); //abre conexão com o banco de dados

        //define comando para o banco de dados
        stmt = con.prepareStatement("INSERT INTO cliente(nomeCliente, cpf, idTipoDeFesta, ativo) VALUES(?,?,?,?)");

        //atribui os valores das marcações do comando acima 
        stmt.setString(1, cliente.getNomeCliente());
        stmt.setString(2, cliente.getCpf());
        stmt.setInt(3, cliente.getIdTipoDeFesta());
        stmt.setInt(4, 1);

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }

    public int getUltimoIdCliente() throws Exception {

        try {
            open(); //abre conexão com o banco
            int idCliente = 0; //idCliente de retorno

            stmt = con.prepareStatement("SELECT idCliente FROM cliente WHERE ativo = 1 ORDER BY 1 DESC limit 1"); //executa query na base
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) {
                idCliente = resultadoConsulta.getInt("idCliente");//seta na variavel criada acima do tipo cliente o id            
            }

            close(); // fecha conexão com o banco
            return idCliente;//retorna idCliente para onde foi chamado
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

    public ArrayList<Cliente> getClientes() throws Exception { //método de retorno arrayList de cliente
        try {
            open(); //abre conexão com o banco
            ArrayList<Cliente> listaCliente = new ArrayList(); //instancia uma arrayList de Cliente

            stmt = con.prepareStatement("SELECT  c.idCliente,\n" +
                                        "        c.nomeCliente,\n" +
                                        "        c.cpf,\n" +
                                        "        c.idTipoDeFesta,\n" +
                                        "        tf.descricaoTipoDeFesta,\n" +
                                        "	 t.numero\n" +
                                        "FROM cliente c,\n" +
                                        "     telefone t,\n" +
                                        "     tipodefesta tf\n" +
                                        "WHERE c.ativo = 1\n" +
                                        "AND c.idCliente = t.idCliente\n" +
                                        "AND t.isPrincipal = 1\n" +
                                        "AND c.idTipoDeFesta = tF.idTipoDeFesta\n" +
                                        "ORDER BY c.nomeCliente"); //QUERY

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                Cliente cliente = new Cliente(); //toda vez que passar no while vai criar uma variavel do tipo Cliente

                //seta valores pegos no select no cliente
                cliente.setIdCliente(resultadoConsulta.getInt("c.idCliente"));
                cliente.setNomeCliente(resultadoConsulta.getString("c.nomeCliente"));
                cliente.setCpf(resultadoConsulta.getString("c.cpf"));
                cliente.setIdTipoDeFesta(resultadoConsulta.getInt("c.idTipoDeFesta"));
                cliente.setTipoDeFesta(resultadoConsulta.getString("tf.descricaoTipoDeFesta"));
                cliente.setTelefonePrincipal(resultadoConsulta.getString("t.numero"));

                listaCliente.add(cliente);// add na lista de cliente
            }
            close(); // fecha conexão com o banco
            return listaCliente;//retorna a lista de cliente para onde foi chamado

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

    public Cliente getClienteEspecifico(int idCliente) throws Exception {

        try {
            open(); //abre conexão com o banco

            Cliente cliente = new Cliente();

            stmt = con.prepareStatement("SELECT  c.idCliente, \n" +
                                        "	 c.nomeCliente, \n" +
                                        "	 c.cpf, \n" +
                                        "	 c.idTipoDeFesta,\n" +
                                        "        tf.descricaoTipoDeFesta\n" +
                                        "FROM   cliente c,\n" +
                                        "       tipodefesta tf\n" +
                                        "WHERE c.idTipoDeFesta = tf.idTipoDeFesta\n" +
                                        "AND c.idCliente = ?"); //query
            
            stmt.setInt(1, idCliente); //seta valor do parametro como condição da query
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) {
                //seta valores pego na consulta na classe cliente 
                cliente.setIdCliente(resultadoConsulta.getInt("c.idCliente"));
                cliente.setNomeCliente(resultadoConsulta.getString("c.nomeCliente"));
                cliente.setCpf(resultadoConsulta.getString("c.cpf"));
                cliente.setIdTipoDeFesta(resultadoConsulta.getInt("c.idTipoDeFesta"));
                cliente.setTipoDeFesta(resultadoConsulta.getString("tf.descricaoTipoDeFesta"));
            }

            close(); // fecha conexão com o banco
            return cliente;//retorna cliente para onde foi chamado
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

    public void inativarCadastro(int idCliente) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE cliente SET ativo = 0 WHERE idCliente = ?");

        stmt.setInt(1, idCliente); //seta idCliente no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }

    public void editarCadastroCliente(int idCliente, String nomeCliente, String cpf, int idTipoDeFesta) throws Exception {

        open(); // abre a conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE cliente SET nomeCliente = ?, cpf = ?, idTipoDeFesta = ? where idCliente = ?");

        //seta valores para comando sql
        stmt.setString(1, nomeCliente);
        stmt.setString(2, cpf);
        stmt.setInt(3, idTipoDeFesta);
        stmt.setInt(4, idCliente);

        stmt.execute();//executa comando sql

        close();// fecha a conexão 

    }
}
