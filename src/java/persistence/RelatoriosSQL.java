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
import entidadesRelatorio.AniversariantesProximos;
import entidadesRelatorio.RelatorioAniversariante;
import entidadesRelatorio.RelatorioEvento;
import entidadesRelatorio.RelatorioFuncionario;
import entidadesRelatorio.RelatorioPacote;
import entidadesRelatorio.RelatorioTipoDespesa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

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
    
    public ArrayList<RelatorioPacote> getRelatorioPacote(String periodo, String periodo2) throws Exception {
        try {
            open(); //abre conexão com o banco

            //cria lista que será retornada
            ArrayList<RelatorioPacote> listaRelatorioPacote = new ArrayList();
            
            stmt = con.prepareStatement("SELECT COUNT(1),\n" +
                                        "	p.nomePacote\n" +
                                        "FROM festa f,\n" +
                                        "     pacote p\n" +
                                        "WHERE f.idPacote = p.idPacote\n" +
                                        "AND p.ativo = 1\n" +
                                        "AND f.dataFesta >= ?\n" +
                                        "AND f.dataFesta <= ?\n" +
                                        "GROUP BY p.nomePacote");
    
            //define valor dos ?
            stmt.setString(1, periodo);
            stmt.setString(2, periodo2);

            //executa a query no banco
            ResultSet resultadoConsulta = stmt.executeQuery();
            
            //percorre o resultado e monta o dados da lista que será retornado
            while (resultadoConsulta.next()) {
                
                RelatorioPacote relatorioPacote = new RelatorioPacote();

                //seta valores pegos no select no cliente
                relatorioPacote.setQtdVendida(resultadoConsulta.getInt("COUNT(1)"));
                relatorioPacote.setNomePacote(resultadoConsulta.getString("p.nomePacote"));

                listaRelatorioPacote.add(relatorioPacote); 
                
            }
            
            close(); // fecha conexão com o banco

            return listaRelatorioPacote; //retorna para onde foi chamado

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

    public ArrayList<RelatorioTipoDespesa> getRelatorioTipoDespesa(String periodo, String periodo2) throws Exception {
        
        try {
            open(); //abre conexão com o banco

            //lista do cadastro de despesa, evento e a que oficial do relatorio
            ArrayList<RelatorioTipoDespesa> listaRelatorioTipoDespesaDespesa = new ArrayList();
            ArrayList<RelatorioTipoDespesa> listaRelatorioTipoDespesaDespesaOficial = new ArrayList();
            
            ArrayList<RelatorioTipoDespesa> listaRelatorioTipoDespesaEvento = new ArrayList();
            ArrayList<RelatorioTipoDespesa> listaRelatorioTipoDespesaEventoOficial = new ArrayList();

            ArrayList<RelatorioTipoDespesa> listaRelatorioTipoDespesa = new ArrayList();
            
            //lista aonde é salva os id dos tipos de despesa
            ArrayList<Integer> listaIdDespesas = new ArrayList();
            ArrayList<Integer> listaIdEventos = new ArrayList();
            
            //COMEÇA DE MONTAR A LISTA DO CADASTRO DO DESPESA
            //consulta as despesas que existem no periodo do parametro
            stmt = con.prepareStatement("SELECT DISTINCT despesas.idDespesas \n" +
                                        "FROM despesas despesas,\n" +
                                        "     pagamentodespesasdetalhe pagamentodespesasdetalhe\n" +
                                        "where despesas.idDespesas = pagamentodespesasdetalhe.idDespesas\n" +
                                        "and pagamentodespesasdetalhe.dataPagamento >= ?\n" +
                                        "and pagamentodespesasdetalhe.dataPagamento <= ?");

            //define valor dos ?
            stmt.setString(1, periodo);
            stmt.setString(2, periodo2);

            //executa a query no banco
            ResultSet resultadoConsulta = stmt.executeQuery();
   
            //percorre o resultado e salva os ids retornado nas lista de id
            while (resultadoConsulta.next()) {                              
                //adiciona na lista os id das despesas que existe na data do filtro
                listaIdDespesas.add(resultadoConsulta.getInt("despesas.idDespesas"));
            }
            
            //percora os ids e monta o resto das informações 
            for(int i = 0; i < listaIdDespesas.size(); i++){
                
                //pega o idTipoDeDespesa e o valor total da despesa
                stmt = con.prepareStatement("SELECT despesas.idTipoDeDespesa, SUM(pagamentodespesasdetalhe.valor)\n" +
                                            "FROM arteemagia.despesas,\n" +
                                            "	 pagamentodespesasdetalhe pagamentodespesasdetalhe\n" +
                                            "WHERE pagamentodespesasdetalhe.idDespesas = despesas.idDespesas\n" +
                                            "AND despesas.idDespesas = ?");


                //define valor dos ?
                stmt.setInt(1, listaIdDespesas.get(i));
                
                //executa a query no banco
                ResultSet resultadoConsulta2 = stmt.executeQuery();
                
                RelatorioTipoDespesa relatorioTipoDespesaDespesa = new RelatorioTipoDespesa();

                //percorre o resultado e monta o dados da lista que será retornado
                while (resultadoConsulta2.next()) {  
                    
                    relatorioTipoDespesaDespesa.setIdTipoDespesa(resultadoConsulta2.getInt("despesas.idTipoDeDespesa"));
                    relatorioTipoDespesaDespesa.setValorTotal(resultadoConsulta2.getFloat("SUM(pagamentodespesasdetalhe.valor)"));
                    
                    if(relatorioTipoDespesaDespesa.getIdTipoDespesa() == 0){
                        
                        relatorioTipoDespesaDespesa.setDescricaoDespesa("Descrição Manual");
                        
                    }else{
                        
                        //verifica o filtro e salva a query
                        stmt = con.prepareStatement("SELECT nomeDespesa\n" +
                                                    "FROM tipodedespesa\n" +
                                                    "WHERE idTipoDeDespesa = ?");


                        //define valor dos ?
                        stmt.setInt(1, relatorioTipoDespesaDespesa.getIdTipoDespesa());  
                        
                        ResultSet resultadoConsulta3 = stmt.executeQuery();
                        
                        while (resultadoConsulta3.next()) { 
                            
                            relatorioTipoDespesaDespesa.setDescricaoDespesa(resultadoConsulta3.getString("nomeDespesa"));

                        }      
                        
                    }
                    
                    //adiciona na lista os id das despesas que existe na data do filtro
                    listaRelatorioTipoDespesaDespesa.add(relatorioTipoDespesaDespesa);
                    
                }                
   
            }
            
            int controleFormataLista = 0;
            
            //formata a lista
            for(int i = 0; i < listaRelatorioTipoDespesaDespesa.size(); i++){
                
                if(controleFormataLista == 0){
                    
                    controleFormataLista++;
                    
                    listaRelatorioTipoDespesaDespesa.get(i).setQtd(1);
                    listaRelatorioTipoDespesaDespesaOficial.add(listaRelatorioTipoDespesaDespesa.get(i));
                    
                }else{
                    
                    boolean isNew = true;
                    
                    for(int x = 0; x < listaRelatorioTipoDespesaDespesaOficial.size(); x++){

                        if(Objects.equals(listaRelatorioTipoDespesaDespesa.get(i).getIdTipoDespesa(), listaRelatorioTipoDespesaDespesaOficial.get(x).getIdTipoDespesa())){
                            
                            isNew = false;
                            
                            listaRelatorioTipoDespesaDespesaOficial.get(x).setValorTotal(listaRelatorioTipoDespesaDespesaOficial.get(x).getValorTotal() + listaRelatorioTipoDespesaDespesa.get(i).getValorTotal());
                            listaRelatorioTipoDespesaDespesaOficial.get(x).setQtd(listaRelatorioTipoDespesaDespesaOficial.get(x).getQtd() + 1);

                            x = listaRelatorioTipoDespesaDespesaOficial.size();
                        }
                       
                    }

                    if(isNew){

                        listaRelatorioTipoDespesaDespesa.get(i).setQtd(1);
                        listaRelatorioTipoDespesaDespesaOficial.add(listaRelatorioTipoDespesaDespesa.get(i));                            

                    }                    
   
                }
                
            }
            //TERMINA DE MONTAR A LISTA DO CADASTRO DO DESPESA
            
            //COMEÇA A MONTAR A LISTA DO CADASTRO DE EVENTO
            //consulta as despesas de evento que existem no periodo do parametro
            stmt = con.prepareStatement("SELECT idFesta \n" +
                                        "FROM festa\n" +
                                        "where dataFesta >= ?\n" +
                                        "and dataFesta <= ?");

            //define valor dos ?
            stmt.setString(1, periodo);
            stmt.setString(2, periodo2);            
            
            //executa a query no banco
            ResultSet resultadoConsulta4 = stmt.executeQuery();
   
            //percorre o resultado e salva os ids retornado nas lista de id
            while (resultadoConsulta4.next()) {                              
                //adiciona na lista os id das festas que existe na data do filtro
                listaIdEventos.add(resultadoConsulta4.getInt("idFesta"));
            }      
            
            //percora os ids e monta o resto das informações 
            for(int i = 0; i < listaIdEventos.size(); i++){
                
                //pega as despesas de cada idEvento
                stmt = con.prepareStatement("SELECT idTipoDeDespesa,\n" +
                                            "	   valorDespesa,\n" +
                                            "	   isFuncionariaPag\n" +
                                            "FROM despesafesta\n" +
                                            "WHERE idFesta = ?");

                //define valor dos ?
                stmt.setInt(1, listaIdEventos.get(i));
                
                //executa a query no banco
                ResultSet resultadoConsulta5 = stmt.executeQuery();
                
                //percorre o resultado e monta o dados da lista que será retornado
                while (resultadoConsulta5.next()) {
                    
                    RelatorioTipoDespesa relatorioTipoDespesaEvento = new RelatorioTipoDespesa();
                    
                    relatorioTipoDespesaEvento.setIdTipoDespesa(resultadoConsulta5.getInt("idTipoDeDespesa"));
                    relatorioTipoDespesaEvento.setIsFuncionario(resultadoConsulta5.getInt("isFuncionariaPag"));
                    relatorioTipoDespesaEvento.setValorTotal(resultadoConsulta5.getFloat("valorDespesa"));                    
                    
                    //verifica se existe idTipoDespesa
                    if(relatorioTipoDespesaEvento.getIdTipoDespesa() == 0){
                        
                        //verifica se é um pagamento de funcionario
                        if(relatorioTipoDespesaEvento.getIsFuncionario() == 1){
                            
                            relatorioTipoDespesaEvento.setDescricaoDespesa("Pagamento Colaborador");
                            relatorioTipoDespesaEvento.setIdTipoDespesa(1000); //coloca os pagamentos de funcionario como idTipo 1000 para facilitar a montagem dps
                            
                        }else{ //se não for
                            
                            relatorioTipoDespesaEvento.setDescricaoDespesa("Descrição Manual");
                            
                        }

                    }else{ //se existir idTipoDespesa pega o nome dela
                        
                        //verifica o filtro e salva a query
                        stmt = con.prepareStatement("SELECT nomeDespesa\n" +
                                                    "FROM tipodedespesa\n" +
                                                    "WHERE idTipoDeDespesa = ?");

                        //define valor dos ?
                        stmt.setInt(1, relatorioTipoDespesaEvento.getIdTipoDespesa());  
                        
                        ResultSet resultadoConsulta6 = stmt.executeQuery();
                        
                        while (resultadoConsulta6.next()) { 
                            
                            relatorioTipoDespesaEvento.setDescricaoDespesa(resultadoConsulta6.getString("nomeDespesa"));

                        }      
                        
                    }      
                    
                    //adiciona na lista de relatorio de despesa das festa
                    listaRelatorioTipoDespesaEvento.add(relatorioTipoDespesaEvento);
                    
                }       
                
            }
            
            int controleFormataLista2 = 0;
            
            //formata a lista
            for(int i = 0; i < listaRelatorioTipoDespesaEvento.size(); i++){
                
                if(controleFormataLista2 == 0){
                    
                    controleFormataLista2++;
                    
                    listaRelatorioTipoDespesaEvento.get(i).setQtd(1);
                    listaRelatorioTipoDespesaEventoOficial.add(listaRelatorioTipoDespesaEvento.get(i));
                    
                }else{
                    
                    boolean isNew = true;
                    
                    for(int x = 0; x < listaRelatorioTipoDespesaEventoOficial.size(); x++){

                        if(Objects.equals(listaRelatorioTipoDespesaEvento.get(i).getIdTipoDespesa(), listaRelatorioTipoDespesaEventoOficial.get(x).getIdTipoDespesa())){
                            
                            isNew = false;
                            
                            listaRelatorioTipoDespesaEventoOficial.get(x).setValorTotal(listaRelatorioTipoDespesaEventoOficial.get(x).getValorTotal() + listaRelatorioTipoDespesaEvento.get(i).getValorTotal());
                            listaRelatorioTipoDespesaEventoOficial.get(x).setQtd(listaRelatorioTipoDespesaEventoOficial.get(x).getQtd() + 1);

                            x = listaRelatorioTipoDespesaEventoOficial.size();
                        }
                        
                    }

                    if(isNew){

                        listaRelatorioTipoDespesaEvento.get(i).setQtd(1);
                        listaRelatorioTipoDespesaEventoOficial.add(listaRelatorioTipoDespesaEvento.get(i));                            

                    }                    
   
                }
                
            }            
            //TERMINA A MONTAR A LISTA DO CADASTRO DE EVENTO
            
            close(); // fecha conexão com o banco
            
            //COMEÇA ONDE JUNTO AS LISTA DO EVENTO E DESPESA E ORDENO POR ORDEM CRESCENTE
            //lista do relatorio recebe todos os dados da lista de evento
            listaRelatorioTipoDespesa = listaRelatorioTipoDespesaEventoOficial;
            
            //percorre a lista de despesa e junta com a lista oficial
            for(int y = 0; y < listaRelatorioTipoDespesaDespesaOficial.size(); y++){
                
                boolean isNew = true;
                
                for(int b = 0; b < listaRelatorioTipoDespesa.size(); b++){
                                      
                    if(Objects.equals(listaRelatorioTipoDespesa.get(b).getIdTipoDespesa(), listaRelatorioTipoDespesaDespesaOficial.get(y).getIdTipoDespesa())){
                        
                        isNew = false;
                        
                        listaRelatorioTipoDespesa.get(b).setValorTotal(listaRelatorioTipoDespesa.get(b).getValorTotal() + listaRelatorioTipoDespesaDespesaOficial.get(y).getValorTotal());
                        listaRelatorioTipoDespesa.get(b).setQtd(listaRelatorioTipoDespesa.get(b).getQtd() + listaRelatorioTipoDespesaDespesaOficial.get(y).getQtd());
                                
                        b = listaRelatorioTipoDespesa.size();                        
                        
                    }
   
                }
                
                if(isNew){

                    listaRelatorioTipoDespesa.add(listaRelatorioTipoDespesaDespesaOficial.get(y));
  
                }                
 
            }
            
            //COMEÇA ONDE JUNTO AS LISTA DO EVENTO E DESPESA E ORDENO POR ORDEM CRESCENTE
            //ordena a lista em ordem crescente
            Collections.sort(listaRelatorioTipoDespesa);
            
            //percorre a lista para colocar a ordem nos counts
            for(int n = 0; n < listaRelatorioTipoDespesa.size(); n++){
                listaRelatorioTipoDespesa.get(n).setCount(n + 1);
            }
            //FIM ONDE JUNTO AS LISTA DO EVENTO E DESPESA E ORDENO POR ORDEM CRESCENTE
            
            return listaRelatorioTipoDespesa; //retorna para onde foi chamado

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
    
//    public ArrayList<AniversariantesProximos> getAniversariantesProximos() throws Exception {
//        try {
//            open(); //abre conexão com o banco
//
//            //cria lista que será retornada
//            ArrayList<AniversariantesProximos> listaAniversariantesProximos = new ArrayList();
//
//
//            stmt = con.prepareStatement("");
//    
//            //define valor dos ?
//            stmt.setString(1, periodo);
//            stmt.setString(2, periodo2);
//            stmt.setInt(3, idFuncionario);
//
//            //executa a query no banco
//            ResultSet resultadoConsulta = stmt.executeQuery();
//            
//            
//            //percorre o resultado e monta o dados da lista que será retornado
//            while (resultadoConsulta.next()) {
//                
//                RelatorioFuncionario relatorioFuncionario = new RelatorioFuncionario();
//
//                //seta valores pegos no select no cliente
//                relatorioFuncionario.setTotalFesta(resultadoConsulta.getInt("COUNT(1)"));
//                relatorioFuncionario.setNomeFuncionario(resultadoConsulta.getString("func.nomeFuncionario"));
//                relatorioFuncionario.setTotalGanho(resultadoConsulta.getFloat("SUM(funcFesta.cacheDaFesta)"));
//                
//                listaRelatorioFuncionario.add(relatorioFuncionario); 
//                
//            }
//            
//            close(); // fecha conexão com o banco
//
//            return listaAniversariantesProximos; //retorna aniversariantes
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                close();
//            } catch (SQLException e) {
//                throw new Exception(e.getMessage());
//            }
//        }        
//    }

}
    
