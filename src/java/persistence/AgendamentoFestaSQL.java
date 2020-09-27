/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.AgendamentoFesta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class AgendamentoFestaSQL extends Conexao {

    public void create(AgendamentoFesta agendamentoFesta) throws Exception {

        open(); //abre conexão com o banco de dados 

        //comando que vai ser executado
        stmt = con.prepareStatement("INSERT INTO agendamentofesta(descricaoFesta, dataEvento, contratante, aniversariante, qtdCrianca, tipoDeFesta, localDaFesta, cacheFuncionarios, horarios, pacote, pacotesAdicionais, valorPegarContratante, observacaoFesta, idFesta) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        //atribui os valores nos ? do comando acima 
        stmt.setString(1, agendamentoFesta.getDescricaoFesta()); //descricaoFesta
        stmt.setString(2, agendamentoFesta.getDataEvento()); //dataEvento
        stmt.setString(3, agendamentoFesta.getContratante()); //contratante
        stmt.setString(4, agendamentoFesta.getAniversariante()); //aniversariante
        stmt.setString(5, agendamentoFesta.getQtdCriancas()); //qtdCrianca
        stmt.setString(6, agendamentoFesta.getTipoDeFesta()); //tipoDeFesta
        stmt.setString(7, agendamentoFesta.getLocalDaFesta()); //localDaFesta
        stmt.setString(8, agendamentoFesta.getCacheFuncionarios()); //cacheFuncionarios
        stmt.setString(9, agendamentoFesta.getHorarios()); //horarios
        stmt.setString(10, agendamentoFesta.getPacote()); //pacote
        stmt.setString(11, agendamentoFesta.getPacotesAdicionais()); //pacotesAdicionais
        stmt.setString(12, agendamentoFesta.getValorPegarContratante()); //valorPegarContratante
        stmt.setString(13, agendamentoFesta.getObservacaoFesta()); //observacaoFesta
        stmt.setInt(14, agendamentoFesta.getIdFesta()); //idFesta

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }

    public ArrayList<AgendamentoFesta> getAgendamentoFesta(int idFuncionario) throws Exception {
        try {
            open(); //abre conexão com o banco

            //cria lista que será retornada
            ArrayList<AgendamentoFesta> listaAgendamentoFesta = new ArrayList();

            //verifica se é de idFuncionario ou especifico
            if (idFuncionario == 0) { 
                //se for geral
                stmt = con.prepareStatement("SELECT af.descricaoFesta,\n" +
                                            "       af.idAgendamentoFesta,\n" +
                                            "       DATE_FORMAT(af.dataEvento, '%d/%m/%Y'),\n" +
                                            "       af.tipoDeFesta\n" +
                                            "FROM agendamentofesta af,\n" +
                                            "	  festa f\n" +
                                            "WHERE af.idFesta = f.idFesta\n" +
                                            "AND f.festaStatus = 0\n" +
                                            "ORDER BY DATE_FORMAT(af.dataEvento, '%d/%m/%Y')");

            } else { 
                
                //se for de funcionario
                stmt = con.prepareStatement("SELECT af.descricaoFesta,\n" +
                                            "       af.idAgendamentoFesta,\n" +
                                            "       DATE_FORMAT(af.dataEvento, '%d/%m/%Y'),\n" +
                                            "       af.tipoDeFesta\n" +
                                            "FROM agendamentofesta af,\n" +
                                            "	  festa f,\n" +
                                            "     funcionariofesta ff\n" +
                                            "WHERE af.idFesta = f.idFesta\n" +
                                            "AND f.festaStatus = 0\n" +
                                            "AND f.idFesta = ff.idFesta\n" +
                                            "AND ff.idFuncionario = ? \n" +
                                            "ORDER BY DATE_FORMAT(af.dataEvento, '%d/%m/%Y')");
                
                
                //define valor dos ?
                stmt.setInt(1, idFuncionario);
            }

            //executa a query no banco
            ResultSet resultadoConsulta = stmt.executeQuery();

            //percorre o resultado e monta o dados da lista que será retornado
            while (resultadoConsulta.next()) {
                AgendamentoFesta agendamentoFesta = new AgendamentoFesta();

                //seta valores pegos no select no cliente
                String descricaoFesta = resultadoConsulta.getString("af.descricaoFesta");
                descricaoFesta = descricaoFesta.substring(102);
                agendamentoFesta.setDescricaoFesta(descricaoFesta);
                
                agendamentoFesta.setIdTabelaAgendamentoFesta(resultadoConsulta.getInt("af.idAgendamentoFesta"));
                agendamentoFesta.setDataEvento(resultadoConsulta.getString("DATE_FORMAT(af.dataEvento, '%d/%m/%Y')"));
                
                String tipoDeFesta = resultadoConsulta.getString("af.tipoDeFesta");
                tipoDeFesta = tipoDeFesta.substring(97);
                agendamentoFesta.setTipoDeFesta(tipoDeFesta);

                listaAgendamentoFesta.add(agendamentoFesta);
            }
            close(); // fecha conexão com o banco

            return listaAgendamentoFesta; //retorna a lista de agendamento

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
  
    public AgendamentoFesta getAgendamentoFestaEspecifico(int idAgendamentoFesta) throws Exception {
        
        try {
            
            open(); //abre conexão com o banco

            //instancia entidade que será retornado
            AgendamentoFesta agendamentoFesta = new AgendamentoFesta();
            
            //define consulta sql
            stmt = con.prepareStatement("SELECT descricaoFesta,\n" +
                                        "	DATE_FORMAT(dataEvento, '%d/%m/%Y'),\n" +
                                        "       contratante,\n" +
                                        "       aniversariante,\n" +
                                        "       qtdCrianca,\n" +
                                        "       tipoDeFesta,\n" +
                                        "       localDaFesta,\n" +
                                        "       cacheFuncionarios,\n" +
                                        "       horarios,\n" +
                                        "       pacote,\n" +
                                        "       pacotesAdicionais,\n" +
                                        "       valorPegarContratante,\n" +
                                        "       observacaoFesta\n" +
                                        "FROM agendamentofesta\n" +
                                        "WHERE idAgendamentoFesta = ?");

            //seta valor no ?
            stmt.setInt(1, idAgendamentoFesta);

            //executa a query no banco
            ResultSet resultadoConsulta = stmt.executeQuery();

            //percorre o resultado e monta o dados da lista que será retornado
            while (resultadoConsulta.next()) {

                agendamentoFesta.setIdTabelaAgendamentoFesta(idAgendamentoFesta);
                agendamentoFesta.setDescricaoFesta(resultadoConsulta.getString("descricaoFesta"));
                agendamentoFesta.setDataEvento(resultadoConsulta.getString("DATE_FORMAT(dataEvento, '%d/%m/%Y')"));
                agendamentoFesta.setContratante(resultadoConsulta.getString("contratante"));
                agendamentoFesta.setAniversariante(resultadoConsulta.getString("aniversariante"));
                agendamentoFesta.setQtdCriancas(resultadoConsulta.getString("qtdCrianca"));
                agendamentoFesta.setTipoDeFesta(resultadoConsulta.getString("tipoDeFesta"));
                agendamentoFesta.setLocalDaFesta(resultadoConsulta.getString("localDaFesta"));
                agendamentoFesta.setCacheFuncionarios(resultadoConsulta.getString("cacheFuncionarios"));
                agendamentoFesta.setHorarios(resultadoConsulta.getString("horarios"));
                agendamentoFesta.setPacote(resultadoConsulta.getString("pacote"));
                agendamentoFesta.setPacotesAdicionais(resultadoConsulta.getString("pacotesAdicionais"));
                agendamentoFesta.setValorPegarContratante(resultadoConsulta.getString("valorPegarContratante"));
                agendamentoFesta.setObservacaoFesta(resultadoConsulta.getString("observacaoFesta"));                
            }
            
            close(); // fecha conexão com o banco

            return agendamentoFesta; //agendamento

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

    public void excluir(int idFesta) throws Exception {

        open(); //abre conexão com o banco de dados 
        
        //comando que vai ser executado
        stmt = con.prepareStatement("DELETE FROM agendamentofesta WHERE idFesta = ?");

        //atribui os valores nos ? do comando acima 
        stmt.setInt(1, idFesta);

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }
}
