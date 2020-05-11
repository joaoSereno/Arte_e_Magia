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
import entidadesRelatorio.RelatorioAniversariante;
import entidadesRelatorio.RelatorioEvento;
import entidadesRelatorio.RelatorioFuncionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class RelatoriosSQL extends Conexao{

    public ArrayList<RelatorioAniversariante> getRelatorioAniversariante(int mesInicial, int mesFinal) throws Exception {
        try {
            open(); //abre conexão com o banco
           
            ArrayList<RelatorioAniversariante> listaRelatorioAniversariante = new ArrayList(); //instancia um lista
            
            //define query de consulta
            stmt = con.prepareStatement("SELECT cri.nomeCrianca,\n" +
                                        "	DATE_FORMAT(cri.dataNascimento, '%d/%m/%Y'),\n" +
                                        "       cli.nomeCliente,\n" +
                                        "       tel.numero\n" +
                                        "FROM crianca cri,\n" +
                                        "     cliente cli,\n" +
                                        "     telefone tel\n" +
                                        "WHERE cri.ativo = 1\n" +
                                        "AND EXTRACT(MONTH FROM cri.dataNascimento) >= ? \n" +
                                        "AND EXTRACT(MONTH FROM cri.dataNascimento) <= ? \n" +
                                        "AND cri.idCliente = cli.idCliente\n" +
                                        "AND tel.idCliente = cli.idCliente\n" +
                                        "AND tel.isPrincipal = 1\n" +
                                        "ORDER BY EXTRACT(MONTH FROM cri.dataNascimento)");             

            //seta valores para comando sql
            stmt.setInt(1, mesInicial);
            stmt.setInt(2, mesFinal);
            
            //executa a query
            ResultSet resultadoConsulta = stmt.executeQuery(); 
            
            int count = 0;
            
            //percorre o resultado da query e monsta o dado da lista
            while (resultadoConsulta.next()) {
                count++;
                
                RelatorioAniversariante relatorioAniversariante = new RelatorioAniversariante(); 
                
                relatorioAniversariante.setAniversariante(resultadoConsulta.getString("cri.nomeCrianca"));
                relatorioAniversariante.setDataAniversario(resultadoConsulta.getString("DATE_FORMAT(cri.dataNascimento, '%d/%m/%Y')"));
                relatorioAniversariante.setCliente(resultadoConsulta.getString("cli.nomeCliente"));
                relatorioAniversariante.setContato(resultadoConsulta.getString("tel.numero"));
                relatorioAniversariante.setCount(count);

                listaRelatorioAniversariante.add(relatorioAniversariante);
            }
            close(); // fecha conexão com o banco
            
            return listaRelatorioAniversariante; //retorna o relatorio gerado

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
    
    public ArrayList<RelatorioEvento> getRelatorioEvento(int statusEvento, String periodoEvento, String periodoEvento2) throws Exception {
       
        try {
            open(); //abre conexão com o banco

            //cria lista que será retornada
            ArrayList<RelatorioEvento> listaRelatorioEvento = new ArrayList();

            //verifica o filtro e salva a query
            switch (statusEvento) {
                case 1:
                    stmt = con.prepareStatement("SELECT  descricaoFesta, \n" +
                                                "	 DATE_FORMAT(dataFesta, '%d/%m/%Y'), \n" +
                                                "        valorTotal,\n" +
                                                "        totalDespesa,\n" +
                                                "        lucroEvento,\n" +
                                                "	 festaStatus \n" +
                                                "FROM festa\n" +
                                                "WHERE dataFesta >= ? \n" +
                                                "AND dataFesta <= ? \n" +
                                                "ORDER BY DATE_FORMAT(dataFesta, '%d/%m/%Y')");

                    break;

                case 2:
                    stmt = con.prepareStatement("SELECT  descricaoFesta, \n" +
                                                "	 DATE_FORMAT(dataFesta, '%d/%m/%Y'), \n" +
                                                "        valorTotal,\n" +
                                                "        totalDespesa,\n" +
                                                "        lucroEvento,\n" +
                                                "	 festaStatus \n" +
                                                "FROM festa\n" +
                                                "WHERE dataFesta >= ? \n" +
                                                "AND dataFesta <= ? \n" +
                                                "AND festaStatus = 1 \n" +
                                                "ORDER BY DATE_FORMAT(dataFesta, '%d/%m/%Y')");


                    break;

                default:
                    stmt = con.prepareStatement("SELECT  descricaoFesta, \n" +
                                                "	 DATE_FORMAT(dataFesta, '%d/%m/%Y'), \n" +
                                                "        valorTotal,\n" +
                                                "        totalDespesa,\n" +
                                                "        lucroEvento,\n" +
                                                "	 festaStatus \n" +
                                                "FROM festa\n" +
                                                "WHERE dataFesta >= ? \n" +
                                                "AND dataFesta <= ? \n" +
                                                "AND festaStatus = 0 \n" +
                                                "ORDER BY DATE_FORMAT(dataFesta, '%d/%m/%Y')");
                    break;
            }

            //define valor dos ?
            stmt.setString(1, periodoEvento);
            stmt.setString(2, periodoEvento2);

            //executa a query no banco
            ResultSet resultadoConsulta = stmt.executeQuery();
            
            int count = 0;
            
            //percorre o resultado e monta o dados da lista que será retornado
            while (resultadoConsulta.next()) {
                count++;
                
                RelatorioEvento relatorioEvento = new RelatorioEvento();

                //seta valores pegos no select no cliente
                relatorioEvento.setDescricaoEvento(resultadoConsulta.getString("descricaoFesta"));
                relatorioEvento.setDataEvento(resultadoConsulta.getString("DATE_FORMAT(dataFesta, '%d/%m/%Y')"));
                relatorioEvento.setValorTotalBruto(resultadoConsulta.getFloat("valorTotal"));
                relatorioEvento.setValorTotalDespesa(resultadoConsulta.getFloat("totalDespesa"));
                relatorioEvento.setLucroEvento(resultadoConsulta.getFloat("lucroEvento"));
                relatorioEvento.setCount(count);
                relatorioEvento.setStatusEvento2(resultadoConsulta.getInt("festaStatus"));
                if(relatorioEvento.getStatusEvento2() == 0){
                    relatorioEvento.setStatusEvento("Não");
                }else{
                    relatorioEvento.setStatusEvento("Sim");
                }

                listaRelatorioEvento.add(relatorioEvento);
            }
            close(); // fecha conexão com o banco

            return listaRelatorioEvento; //retorna a relatorio

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
    
    public ArrayList<RelatorioFuncionario> getRelatorioFuncionario(int statusEvento, String periodo, String periodo2, int idFuncionario) throws Exception {
        try {
            open(); //abre conexão com o banco

            //cria lista que será retornada
            ArrayList<RelatorioFuncionario> listaRelatorioFuncionario = new ArrayList();

            //verifica o filtro e salva a query
            if (idFuncionario == 0) { // se for um relatorio geral

                switch (statusEvento) {
                    case 1:
                        stmt = con.prepareStatement("SELECT COUNT(1),\n" +
                                                    "	    func.nomeFuncionario,\n" +
                                                    "	    SUM(funcFesta.cacheDaFesta)\n" +
                                                    "FROM funcionariofesta funcFesta,\n" +
                                                    "	  funcionario func,\n" +
                                                    "     festa festa\n" +
                                                    "WHERE func.idFuncionario = funcFesta.idFuncionario\n" +
                                                    "AND funcFesta.idFesta = festa.idFesta\n" +
                                                    "AND func.ativo = 1\n" +
                                                    "AND festa.dataFesta >= ?\n" +
                                                    "AND festa.dataFesta <= ?\n" +
                                                    "GROUP BY func.nomeFuncionario\n" +
                                                    "ORDER BY SUM(funcFesta.cacheDaFesta) DESC");
                        
                        break;

                    case 2:
                        stmt = con.prepareStatement("SELECT COUNT(1),\n" +
                                                    "	    func.nomeFuncionario,\n" +
                                                    "	    SUM(funcFesta.cacheDaFesta)\n" +
                                                    "FROM funcionariofesta funcFesta,\n" +
                                                    "	  funcionario func,\n" +
                                                    "     festa festa\n" +
                                                    "WHERE func.idFuncionario = funcFesta.idFuncionario\n" +
                                                    "AND funcFesta.idFesta = festa.idFesta\n" +
                                                    "AND func.ativo = 1\n" +
                                                    "AND festa.festaStatus = 1 \n" +
                                                    "AND festa.dataFesta >= ? \n" +
                                                    "AND festa.dataFesta <= ? \n" +
                                                    "GROUP BY func.nomeFuncionario\n" +
                                                    "ORDER BY SUM(funcFesta.cacheDaFesta) DESC");


                        break;

                    default:
                        stmt = con.prepareStatement("SELECT COUNT(1),\n" +
                                                    "	    func.nomeFuncionario,\n" +
                                                    "	    SUM(funcFesta.cacheDaFesta)\n" +
                                                    "FROM funcionariofesta funcFesta,\n" +
                                                    "	  funcionario func,\n" +
                                                    "     festa festa\n" +
                                                    "WHERE func.idFuncionario = funcFesta.idFuncionario\n" +
                                                    "AND funcFesta.idFesta = festa.idFesta\n" +
                                                    "AND func.ativo = 1 \n" +
                                                    "AND festa.festaStatus = 0 \n" +
                                                    "AND festa.dataFesta >= ? \n" +
                                                    "AND festa.dataFesta <= ? \n" +
                                                    "GROUP BY func.nomeFuncionario\n" +
                                                    "ORDER BY SUM(funcFesta.cacheDaFesta) DESC");
                        
                        break;
                }
                
                //define valor dos ?
                stmt.setString(1, periodo);
                stmt.setString(2, periodo2);

            }else{ //se for um relatorio especifico funcionario
                
                switch (statusEvento) {
                    case 1:
                        stmt = con.prepareStatement("SELECT COUNT(1),\n" +
                                                    "	    func.nomeFuncionario,\n" +
                                                    "	    SUM(funcFesta.cacheDaFesta)\n" +
                                                    "FROM funcionariofesta funcFesta,\n" +
                                                    "	  funcionario func,\n" +
                                                    "     festa festa\n" +
                                                    "WHERE func.idFuncionario = funcFesta.idFuncionario\n" +
                                                    "AND funcFesta.idFesta = festa.idFesta\n" +
                                                    "AND func.ativo = 1 \n" +
                                                    "AND func.idFuncionario = ? \n" +
                                                    "AND festa.dataFesta >= ? \n" +
                                                    "AND festa.dataFesta <= ? \n" +
                                                    "GROUP BY func.nomeFuncionario\n" +
                                                    "ORDER BY SUM(funcFesta.cacheDaFesta) DESC");

                        break;

                    case 2:
                        stmt = con.prepareStatement("SELECT COUNT(1),\n" +
                                                    "	    func.nomeFuncionario,\n" +
                                                    "	    SUM(funcFesta.cacheDaFesta)\n" +
                                                    "FROM funcionariofesta funcFesta,\n" +
                                                    "	  funcionario func,\n" +
                                                    "     festa festa\n" +
                                                    "WHERE func.idFuncionario = funcFesta.idFuncionario\n" +
                                                    "AND funcFesta.idFesta = festa.idFesta\n" +
                                                    "AND func.ativo = 1 \n" +
                                                    "AND festa.festaStatus = 1 \n" +
                                                    "AND func.idFuncionario = ? \n" +
                                                    "AND festa.dataFesta >= ? \n" +
                                                    "AND festa.dataFesta <= ? \n" +
                                                    "GROUP BY func.nomeFuncionario\n" +
                                                    "ORDER BY SUM(funcFesta.cacheDaFesta) DESC");


                        break;

                    default:
                        stmt = con.prepareStatement("SELECT COUNT(1),\n" +
                                                    "	    func.nomeFuncionario,\n" +
                                                    "	    SUM(funcFesta.cacheDaFesta)\n" +
                                                    "FROM funcionariofesta funcFesta,\n" +
                                                    "	  funcionario func,\n" +
                                                    "     festa festa\n" +
                                                    "WHERE func.idFuncionario = funcFesta.idFuncionario\n" +
                                                    "AND funcFesta.idFesta = festa.idFesta\n" +
                                                    "AND func.ativo = 1 \n" +
                                                    "AND festa.festaStatus = 0 \n" +
                                                    "AND func.idFuncionario = ? \n" +
                                                    "AND festa.dataFesta >= ? \n" +
                                                    "AND festa.dataFesta <= ? \n" +
                                                    "GROUP BY func.nomeFuncionario\n" +
                                                    "ORDER BY SUM(funcFesta.cacheDaFesta) DESC");
                        break;
                }
                
                //define valor dos ?
                stmt.setString(1, periodo);
                stmt.setString(2, periodo2);
                stmt.setInt(3, idFuncionario);
            }

            //executa a query no banco
            ResultSet resultadoConsulta = stmt.executeQuery();
            
            int count = 0;
            
            //percorre o resultado e monta o dados da lista que será retornado
            while (resultadoConsulta.next()) {
                count++;
                
                RelatorioFuncionario relatorioFuncionario = new RelatorioFuncionario();

                //seta valores pegos no select no cliente
                relatorioFuncionario.setTotalFesta(resultadoConsulta.getInt("COUNT(1)"));
                relatorioFuncionario.setNomeFuncionario(resultadoConsulta.getString("func.nomeFuncionario"));
                relatorioFuncionario.setTotalGanho(resultadoConsulta.getFloat("SUM(funcFesta.cacheDaFesta)"));
                relatorioFuncionario.setCount(count);

                listaRelatorioFuncionario.add(relatorioFuncionario); 
            }
            
            close(); // fecha conexão com o banco

            return listaRelatorioFuncionario; //retorna a relatorio

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
    
