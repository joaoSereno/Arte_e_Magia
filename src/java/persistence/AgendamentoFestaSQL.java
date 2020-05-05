/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.AgendamentoFesta;

/**
 *
 * @author João Pedro
 */
public class AgendamentoFestaSQL extends Conexao{

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
    
}
