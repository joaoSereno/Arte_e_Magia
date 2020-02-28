/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import static configConexao.Conexao.stmt;
import entidades.FormaPagamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class TipoPagamentoSQL extends Conexao {

    /**
     * O método retorna todos os registro do banco da tabela "formapagamento"
     * que estão ativos
     *
     * @return lista dos registros da tabela "formapagamento"
     * @throws Exception
     */
    public ArrayList<FormaPagamento> getFormaPagamento() throws Exception {
        try {
            open(); //abre conexão com o banco
            ArrayList<FormaPagamento> listaFormapagamento = new ArrayList(); //instancia uma arrayList de forma de pagamento

            stmt = con.prepareStatement("SELECT idFormaPagamento, nomePagamento FROM formapagamento WHERE ativo = 1"); //executa query na base               

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                FormaPagamento formaPagamento = new FormaPagamento(); //toda vez que passar no while vai criar uma variavel do tipo forma de pagamento

                //seta valores retornados pelo banco na variavel do tipo forma de pagamento
                formaPagamento.setIdFormaPagamento(resultadoConsulta.getInt("idFormaPagamento"));
                formaPagamento.setNomePagamento(resultadoConsulta.getString("nomePagamento"));

                listaFormapagamento.add(formaPagamento);// add na lista de forma de pagamento
            }
            close(); // fecha conexão com o banco
            return listaFormapagamento;//retorna a lista de forma de pagamento para onde foi chamado

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
     * Método que realizada um insert na tabela "formapagamento" do banco de
     * dados.
     *
     * @param formaPagamento
     * @throws Exception
     */
    public void create(FormaPagamento formaPagamento) throws Exception { //recebe formaPagamento vindo do controller

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("INSERT INTO formapagamento(nomePagamento,ativo) VALUES (?,?)");

        //seta valores no comando insert
        stmt.setString(1, formaPagamento.getNomePagamento());
        stmt.setInt(2, 1);

        stmt.execute();//executa  insert no banco de dados

        close();//fecha conexão com o banco de dados

    }
    
    /**
     * Método que realiza update do campo nome da tabela "formapagamento" no banco de dados
     * @param formaPagamento
     * @throws Exception 
     */
    public void editaFormaPagamento(FormaPagamento formaPagamento) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE formapagamento SET nomePagamento = ? WHERE idFormaPagamento = ?");
        
        stmt.setString(1, formaPagamento.getNomePagamento()); //seta NomePagamento no ?
        stmt.setInt(2, formaPagamento.getIdFormaPagamento()); //seta IdFormaPagamento no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }
    
    /**
     * Método que inativa um registro da tabela "formapagamento", realizando um update ativo = 0.
     * @param idFormaPagamento
     * @throws Exception 
     */
    public void inativaFormaPagamento(int idFormaPagamento) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE formapagamento SET ativo = 0 WHERE idFormaPagamento = ?");
        
        stmt.setInt(1, idFormaPagamento); //seta idFuncionario no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }
}
