/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.PacotesAdicionaisFesta;
import entidades.TipoPacoteAdicional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class PacoteAdicionalSQL extends Conexao{
    
    public ArrayList<TipoPacoteAdicional> getTipoPacoteAdicional() throws Exception {
        try {
            open(); //abre conexão com o banco
            ArrayList<TipoPacoteAdicional> listaTipoPacoteAdicional = new ArrayList(); //instancia uma arrayList de PacotesAdicionaisFesta

            stmt = con.prepareStatement("SELECT idTipoPacoteAdicional, descricaoPacoteAdd FROM tipopacoteadicional WHERE ativo = 1"); //executa query na base               

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                TipoPacoteAdicional tipoPacoteAdicional = new TipoPacoteAdicional(); //toda vez que passar no while vai criar uma variavel do PacotesAdicionaisFesta

                //seta valores retornados pelo banco na variavel do tipo despesa
                tipoPacoteAdicional.setIdTipoPacoteAdicional(resultadoConsulta.getInt("idTipoPacoteAdicional"));
                tipoPacoteAdicional.setDescricaoPacoteAdd(resultadoConsulta.getString("descricaoPacoteAdd"));

                listaTipoPacoteAdicional.add(tipoPacoteAdicional);// add na lista d
            }
            close(); // fecha conexão com o banco
            return listaTipoPacoteAdicional;//retorna a lista de PacotesAdicionaisFestaa para onde foi chamado

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
