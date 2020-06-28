/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.DespesaFesta;
import entidadesRelatorio.ListagemDeDespesa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class DespesaFestaSQL extends Conexao {

    public void create(DespesaFesta despesaFesta) throws Exception {

        open(); //abre conexão com o banco de dados 

        if (despesaFesta.getIsFuncionariaPag() == 1) { //se for despesa que é pagamento de funcionario
            stmt = con.prepareStatement("INSERT INTO despesafesta(descricao, valorDespesa, idFormaPagamento, isFuncionariaPag, idFuncionario, idFesta, status) VALUES(?,?,?,?,?,?,?)");

            //atribui os valores nos ? do comando acima 
            stmt.setString(1, despesaFesta.getDescricao());
            stmt.setFloat(2, despesaFesta.getValorDespesa());
            stmt.setInt(3, despesaFesta.getIdFormaPagamento());
            stmt.setInt(4, despesaFesta.getIsFuncionariaPag());
            stmt.setInt(5, despesaFesta.getIdFuncionario());
            stmt.setInt(6, despesaFesta.getIdFesta());
            stmt.setInt(7, despesaFesta.getStatus());

        } else { //se for despesa normal
            //se for cadastro utilizando os tipos de despesas
            if (despesaFesta.getIdTipoDeDespesa() != null) {
                stmt = con.prepareStatement("INSERT INTO despesafesta(idTipoDeDespesa, valorDespesa, idFormaPagamento, isFuncionariaPag, idFesta, status) VALUES(?,?,?,?,?,?)");

                //atribui os valores nos ? do comando acima 
                stmt.setInt(1, despesaFesta.getIdTipoDeDespesa());
                stmt.setFloat(2, despesaFesta.getValorDespesa());
                stmt.setInt(3, despesaFesta.getIdFormaPagamento());
                stmt.setInt(4, despesaFesta.getIsFuncionariaPag());
                stmt.setInt(5, despesaFesta.getIdFesta());
                stmt.setInt(6, despesaFesta.getStatus());

            } else { //se for cadastro utilizando a descricao
                stmt = con.prepareStatement("INSERT INTO despesafesta(descricao, valorDespesa, idFormaPagamento, isFuncionariaPag, idFesta, status) VALUES(?,?,?,?,?,?)");

                //atribui os valores nos ? do comando acima 
                stmt.setString(1, despesaFesta.getDescricao());
                stmt.setFloat(2, despesaFesta.getValorDespesa());
                stmt.setInt(3, despesaFesta.getIdFormaPagamento());
                stmt.setInt(4, despesaFesta.getIsFuncionariaPag());
                stmt.setInt(5, despesaFesta.getIdFesta());
                stmt.setInt(6, despesaFesta.getStatus());

            }
        }

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados
    }

    public ArrayList<ListagemDeDespesa> getListagemDeDespesa(int isPago, String periodo, String periodo2) throws Exception {

        try {

            open(); //abre conexão com o banco

            ArrayList<ListagemDeDespesa> listaModelListagemDeDespesa = new ArrayList(); //lista que será retornada no controller

            stmt = con.prepareStatement("SELECT  f.idFesta,\n"
                                        + "      f.descricaoFesta \n"
                                        + "FROM festa f \n"
                                        + "WHERE f.dataFesta >= ? \n"
                                        + "AND f.dataFesta <= ?"); //query

            //parametros da query
            stmt.setString(1, periodo);
            stmt.setString(2, periodo2);

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel
            
            while (resultadoConsulta.next()) { //percorre o resultado da query
                
                ListagemDeDespesa listagemDeDespesa = new ListagemDeDespesa();
                ListagemDeDespesa listagemDeDespesa2 = new ListagemDeDespesa();

                //seta o resultado da query no listagemDeDespesa
                listagemDeDespesa.setIdFesta(resultadoConsulta.getInt("f.idFesta"));
                listagemDeDespesa.setDescricaoEvento(resultadoConsulta.getString("f.descricaoFesta"));
                
                //chama método que retorna os dados da tabela festa que tem o id passado no parametro
                listagemDeDespesa2 = this.getListagemDeDespesa2(listagemDeDespesa.getIdFesta());

                //pega os dados da listagemDespesa2 e seta na listagemDeDespesa que vai ser adicionada na lista
                listagemDeDespesa.setValor(listagemDeDespesa2.getValor());
                listagemDeDespesa.setValorPago(listagemDeDespesa2.getValorPago());
                listagemDeDespesa.setPago(listagemDeDespesa2.getPago());

                if (isPago == 3) {

                    //adiciona na lista
                    listaModelListagemDeDespesa.add(listagemDeDespesa); //adiciona lista que será retornada

                } else {

                    if (isPago == 1) {
                        if (listagemDeDespesa.getPago().equals("Não")) {
                            //adiciona na lista
                            listaModelListagemDeDespesa.add(listagemDeDespesa); //adiciona lista que será retornada
                        }
                    }

                    if (isPago == 2) {
                        if (listagemDeDespesa.getPago().equals("Sim")) {
                            //adiciona na lista
                            listaModelListagemDeDespesa.add(listagemDeDespesa); //adiciona lista que será retornada
                        }
                    }

                }
                
            }

            close(); // fecha conexão com o banco

            return listaModelListagemDeDespesa;//retorna a lista para onde foi chamado

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
    
    public ListagemDeDespesa getListagemDeDespesa2(int idFesta) throws Exception {

        try {
            open(); //abre conexão com o banco

            ListagemDeDespesa listagemDeDespesa = new ListagemDeDespesa();

            stmt = con.prepareStatement("SELECT df.valorDespesa,\n"
                    + "	    df.status	\n"
                    + "FROM despesafesta df \n"
                    + "where df.idFesta = ? \n"
                    + "AND isFuncionariaPag = 0"); //query

            //parametros da query
            stmt.setInt(1, idFesta);
            
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            float valorTotalDespesa = 0;
            float valorDespesaPaga = 0;
            int status = 3;

            while (resultadoConsulta.next()) {

                float valor = resultadoConsulta.getFloat("df.valorDespesa");

                valorTotalDespesa = valorTotalDespesa + valor;

                if (resultadoConsulta.getInt("df.status") == 1) {

                    valorDespesaPaga = valorDespesaPaga + valor;

                    if (status != 0) {
                        status = 1;
                    }

                } else {

                    status = 0;

                }

            }
            
            listagemDeDespesa.setValor(valorTotalDespesa);
            listagemDeDespesa.setValorPago(valorDespesaPaga);   
            
            if (status == 0) {
                listagemDeDespesa.setPago("Não");
            } else {
                listagemDeDespesa.setPago("Sim");
            }            

            close(); // fecha conexão com o banco
            return listagemDeDespesa;//retorna  para onde foi chamado
            
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
