/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
/**
 *
 * @author João Pedro
 */
public class ValorAdicionalFesta implements Serializable {

    private Integer idValorAdicionalFesta;
    private String descricao;
    private float valor;
    private Festa idFesta;

    public ValorAdicionalFesta() {
    }

    public ValorAdicionalFesta(Integer idValorAdicionalFesta) {
        this.idValorAdicionalFesta = idValorAdicionalFesta;
    }

    public ValorAdicionalFesta(Integer idValorAdicionalFesta, String descricao, float valor) {
        this.idValorAdicionalFesta = idValorAdicionalFesta;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getIdValorAdicionalFesta() {
        return idValorAdicionalFesta;
    }

    public void setIdValorAdicionalFesta(Integer idValorAdicionalFesta) {
        this.idValorAdicionalFesta = idValorAdicionalFesta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Festa getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Festa idFesta) {
        this.idFesta = idFesta;
    }
    
}
