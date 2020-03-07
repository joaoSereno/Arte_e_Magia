/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class FuncionarioSQL extends Conexao { //extende classe de conexão com o banco de dados

    /**
     * Método que realiza um insert de um registro na tabela "funcionario" do
     * banco de dados.
     *
     * @param funcionario
     * @throws Exception
     */
    public void create(Funcionario funcionario) throws Exception { //recebe funcionario vindo do controller

        open(); //abre conexão com o banco de dados

        //define comando para o banco de dados
        stmt = con.prepareStatement("INSERT INTO funcionario(nomeFuncionario, sexo, ativo) VALUES(?,?,?)");

        //atribui os valores das marcações do comando acima 
        stmt.setString(1, funcionario.getNomeFuncionario());
        stmt.setString(2, funcionario.getSexo());
        stmt.setInt(3, funcionario.getAtivo());

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados
    }

    /**
     * Método que retorna todos os registros da tabela "funcionario" que estejam
     * ativos.
     *
     * @return
     * @throws Exception
     */
    public ArrayList<Funcionario> getFuncionario() throws Exception { //método de retorno arrayList de funcionario
        try {
            open(); //abre conexão com o banco
            ArrayList<Funcionario> listaFuncionario = new ArrayList(); //instancia uma arrayList de funcionario

            stmt = con.prepareStatement("SELECT   f.idFuncionario,\n"
                    + "		 f.nomeFuncionario,\n"
                    + "		 f.sexo,\n"
                    + "         t.numero\n"
                    + "FROM funcionario f,\n"
                    + "	 telefone t\n"
                    + "WHERE f.ativo = 1\n"
                    + "AND f.idFuncionario = t.idFuncionario\n"
                    + "AND t.isPrincipal = 1"); //executa query na base

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                Funcionario funcionario = new Funcionario(); //toda vez que passar no while vai criar uma variavel do tipo funcionario

                funcionario.setIdFuncionario(resultadoConsulta.getInt("f.idFuncionario"));//seta na variavel criada a cima do tipo funcionario o id
                funcionario.setNomeFuncionario(resultadoConsulta.getString("f.nomeFuncionario"));//seta na variavel criada a cima do tipo funcionario o nome
                funcionario.setSexo(resultadoConsulta.getString("f.sexo"));//seta na variavel criada a cima do tipo funcionario o sexo
                funcionario.setTelefonePrincipal(resultadoConsulta.getString("t.numero"));//seta na variavel criada a cima do tipo funcionario o sexo

                listaFuncionario.add(funcionario);// add na lista de funcionario
            }
            close(); // fecha conexão com o banco
            return listaFuncionario;//retorna a lista de funcionario para onde foi chamado

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

    /**
     * Método retorna o último registro da tabela "funcionario" do banco de
     * dados.
     *
     * @return
     * @throws Exception
     */
    public int getUltimoIdFuncionario() throws Exception {

        try {
            open(); //abre conexão com o banco
            int idFuncionario = 0; //idFuncionario de retorno

            stmt = con.prepareStatement("SELECT idFuncionario FROM funcionario WHERE ativo = 1 ORDER BY 1 DESC limit 1"); //executa query na base
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) {
                idFuncionario = resultadoConsulta.getInt("idFuncionario");//seta na variavel criada acima do tipo funcionario o id            
            }

            close(); // fecha conexão com o banco
            return idFuncionario;//retorna idFuncionario para onde foi chamado
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

    /**
     * Método que inativa o registro de funcionario da tabela "funcionario" ,
     * realizando um update ativo = 0.
     *
     * @param idFuncionario
     * @throws Exception
     */
    public void inativarCadastro(int idFuncionario) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE funcionario SET ativo = 0 WHERE idFuncionario = ?");

        stmt.setInt(1, idFuncionario); //seta idFuncionario no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }

    /**
     * Metódo que realiza a edição de um registro de funcionario especifico da
     * tabela "funcionario".
     *
     * @param idFuncionario
     * @param nomeFuncionario
     * @param sexo
     * @throws Exception
     */
    public void editarCadastroFuncionario(int idFuncionario, String nomeFuncionario, String sexo) throws Exception {

        open(); // abre a conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE funcionario SET nomeFuncionario = ?, sexo = ? where idFuncionario = ?");

        //seta valores para comando sql
        stmt.setString(1, nomeFuncionario);
        stmt.setString(2, sexo);
        stmt.setInt(3, idFuncionario);

        stmt.execute();//executa comando sql

        close();// fecha a conexão 

    }

    public Funcionario getFuncionarioEspecifico(int idFuncionario) throws Exception {

        try {
            open(); //abre conexão com o banco

            //instanciando "variavel" do tipo funcionario para returnar na chamada
            Funcionario funcionario = new Funcionario();

            //define consulta
            stmt = con.prepareStatement("SELECT nomeFuncionario, sexo FROM funcionario WHERE idFuncionario = ?");
            
            //seta valores para comando sql
            stmt.setInt(1, idFuncionario);
            
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados

                funcionario.setIdFuncionario(idFuncionario);//seta na variavel criada a cima do tipo funcionario o id
                funcionario.setNomeFuncionario(resultadoConsulta.getString("nomeFuncionario"));//seta na variavel criada a cima do tipo funcionario o nome
                funcionario.setSexo(resultadoConsulta.getString("sexo"));//seta na variavel criada a cima do tipo funcionario o sexo

            }
            close(); // fecha conexão com o banco
            return funcionario;//retorna funcionario para onde foi chamado

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
