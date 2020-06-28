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
import entidades.Despesas;
import entidadesRelatorio.ListagemDeDespesa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class DespesaSQL extends Conexao{
    
    public void createDespesa(Despesas despesa) throws Exception { //recebe crianca vindo do controller

        open(); //abre conexão com o banco de dados

        //define comando para o banco de dados
        if(despesa.getIdTipoDeDespesa() == null ){ //se não tiver idTipoDeDespesa
            
            stmt = con.prepareStatement("INSERT INTO despesas(descricao, obs, status) VALUES (?,?,?)");
       
            //atribui os valores das marcações do comando acima 
            stmt.setString(1, despesa.getDescricaoDespesa());
            stmt.setString(2, despesa.getObs());
            stmt.setInt(3, despesa.getStatusDespesa());     
            
        }else{ //se tiver
            
            stmt = con.prepareStatement("INSERT INTO despesas(descricao, idTipoDeDespesa, obs, status) VALUES (?,?,?,?)");               

            //atribui os valores das marcações do comando acima 
            stmt.setString(1, despesa.getDescricaoDespesa());
            stmt.setInt(2, despesa.getIdTipoDeDespesa());    
            stmt.setString(3, despesa.getObs());
            stmt.setInt(4, despesa.getStatusDespesa());     
            
        }

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }    

    public int getUltimoIdDespesas() throws Exception {

        try {
            open(); //abre conexão com o banco
            int idDespesas = 0; //idDespesas de retorno

            stmt = con.prepareStatement("SELECT idDespesas FROM despesas ORDER BY 1 DESC limit 1"); //executa query na base
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) {
                idDespesas = resultadoConsulta.getInt("idDespesas");
            }

            close(); // fecha conexão com o banco
            return idDespesas;//retorna idDespesas para onde foi chamado
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
     * Método que monta a lista que será exibido na página de despesa principal
     * @param isPago
     * @param periodo
     * @param periodo2
     * @return
     * @throws Exception 
     */
    public ArrayList<ListagemDeDespesa> getListagemDeDespesa(int isPago, String periodo, String periodo2) throws Exception {

        try {
            
            open(); //abre conexão com o banco
            
            ArrayList<ListagemDeDespesa> listaModelListagemDeDespesa = new ArrayList(); //lista que será retornada no controller
            
            if(isPago != 3){ // se o pago for diferente de ambos
                
                stmt = con.prepareStatement("SELECT d.idDespesas,\n" +
                                            "       d.descricao,\n" +
                                            "       d.status	\n" +
                                            "FROM despesas d\n" +
                                            "WHERE d.idDespesas IN ( SELECT pdd.idDespesas\n" +
                                            "                        FROM pagamentodespesasdetalhe pdd\n" +
                                            "                        WHERE pdd.dataPagamento >= ?\n" +
                                            "                        AND pdd.dataPagamento <= ?\n" +
                                            "                        GROUP BY pdd.idDespesas)\n" +
                                            "AND status = ?"); //query
                
                //parametros da query
                stmt.setString(1, periodo); 
                stmt.setString(2, periodo2);
                
                if(isPago == 1){
                    stmt.setInt(3, 0);
                }else{
                    stmt.setInt(3, 1);  
                }
               


            }else{ //se não for
                
                stmt = con.prepareStatement("SELECT d.idDespesas,\n" +
                                            "       d.descricao,\n" +
                                            "       d.status	\n" +
                                            "FROM despesas d\n" +
                                            "WHERE d.idDespesas IN ( SELECT pdd.idDespesas\n" +
                                            "                        FROM pagamentodespesasdetalhe pdd\n" +
                                            "                        WHERE pdd.dataPagamento >= ?\n" +
                                            "                        AND pdd.dataPagamento <= ?\n" +
                                            "                        GROUP BY pdd.idDespesas)"); //query

                //parametros da query
                stmt.setString(1, periodo); 
                stmt.setString(2, periodo2);     
                
            }            
            
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel
            
            //instancia classe de comunicação com o banco 
            PagamentoDespesaDetalheSQL pagamentoDespesaDetalheBanco = new PagamentoDespesaDetalheSQL();
                    
            while (resultadoConsulta.next()) { //percorre o resultado da query
                
                ListagemDeDespesa listagemDeDespesa = new ListagemDeDespesa();
                ListagemDeDespesa listagemDeDespesa2 = new ListagemDeDespesa();
                
                //seta o resultado da query no listagemDeDespesa
                listagemDeDespesa.setIdDespesa(resultadoConsulta.getInt("d.idDespesas"));
                listagemDeDespesa.setDescricaoDespesa(resultadoConsulta.getString("d.descricao"));
                
                if(resultadoConsulta.getInt("d.status") == 1){
                    listagemDeDespesa.setPago("Sim");
                }else{
                    listagemDeDespesa.setPago("Não");
                }
                
                //recebe os outros dados da listagemDeDespesa chamando o método do banco 
                listagemDeDespesa2 = pagamentoDespesaDetalheBanco.getMontagemListagemDeDespesa(listagemDeDespesa.getIdDespesa());
                
                //seta os outros dados na listagemDeDespesa
                listagemDeDespesa.setValor(listagemDeDespesa2.getValor());
                listagemDeDespesa.setValorPago(listagemDeDespesa2.getValorPago());
                
                //adiciona na lista
                listaModelListagemDeDespesa.add(listagemDeDespesa); //adiciona lista que será retornada
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
    
    public Despesas getDespesa(int idDespesas) throws Exception {

        try {
            
            open(); //abre conexão com o banco
            
            Despesas despesa = new Despesas();
                
            stmt = con.prepareStatement("SELECT idDespesas, descricao, idTipoDeDespesa, obs, status\n" +
                                        "FROM despesas\n" +
                                        "where idDespesas = ?"); //query

            //parametros da query
            stmt.setInt(1, idDespesas); 
            
            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel
                                
            while (resultadoConsulta.next()) { //percorre o resultado da query

                //seta o resultado da query na despesa
                despesa.setIdDespesas(resultadoConsulta.getInt("idDespesas"));
                despesa.setDescricaoDespesa(resultadoConsulta.getString("descricao"));
                despesa.setIdTipoDeDespesa(resultadoConsulta.getInt("idTipoDeDespesa"));
                despesa.setObs(resultadoConsulta.getString("obs"));
                despesa.setStatusDespesa(resultadoConsulta.getInt("status"));

            }

            close(); // fecha conexão com o banco
            
            return despesa;//retorna para onde foi chamado
            
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
    
    public void excluirDespesa(int idDespesas) throws Exception {
        
        open(); //abre conexão com o banco de dados  

        stmt = con.prepareStatement("DELETE FROM despesas WHERE idDespesas = ?"); // query para executar no banco

        stmt.setInt(1, idDespesas); 

        stmt.execute(); // executa query

        close(); // fecha conexão com o banco de dados     
        
    }
    
}
