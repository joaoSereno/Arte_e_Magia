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

public class PagamentoAdiantadoFesta implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idPagamentoAdiantadoFesta;
    private float valorPagamento;
    private PagamentoFesta idPagamentoFesta;
    private FormaPagamento idFormaPagamento;
    private Festa idFesta;

    public PagamentoAdiantadoFesta() {
    }

    public PagamentoAdiantadoFesta(Integer idPagamentoAdiantadoFesta) {
        this.idPagamentoAdiantadoFesta = idPagamentoAdiantadoFesta;
    }

    public PagamentoAdiantadoFesta(Integer idPagamentoAdiantadoFesta, float valorPagamento) {
        this.idPagamentoAdiantadoFesta = idPagamentoAdiantadoFesta;
        this.valorPagamento = valorPagamento;
    }

    public Integer getIdPagamentoAdiantadoFesta() {
        return idPagamentoAdiantadoFesta;
    }

    public void setIdPagamentoAdiantadoFesta(Integer idPagamentoAdiantadoFesta) {
        this.idPagamentoAdiantadoFesta = idPagamentoAdiantadoFesta;
    }

    public float getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(float valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public PagamentoFesta getIdPagamentoFesta() {
        return idPagamentoFesta;
    }

    public void setIdPagamentoFesta(PagamentoFesta idPagamentoFesta) {
        this.idPagamentoFesta = idPagamentoFesta;
    }

    public FormaPagamento getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(FormaPagamento idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public Festa getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Festa idFesta) {
        this.idFesta = idFesta;
    }
   
}
