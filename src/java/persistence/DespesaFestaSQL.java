/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.DespesaFesta;

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

}
