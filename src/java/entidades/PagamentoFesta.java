/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author João Pedro
 */
public class PagamentoFesta implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idPagamentoFesta;
    private float valor;
    private int pagamentoStatus;
    private String dataPagamento;
    private Festa idFesta;
    private List<PagamentoAdiantadoFesta> pagamentoadiantadofestaList;

    public PagamentoFesta() {
    }

    public PagamentoFesta(Integer idPagamentoFesta) {
        this.idPagamentoFesta = idPagamentoFesta;
    }

    public PagamentoFesta(Integer idPagamentoFesta, float valor, int pagamentoStatus) {
        this.idPagamentoFesta = idPagamentoFesta;
        this.valor = valor;
        this.pagamentoStatus = pagamentoStatus;
    }

    public Integer getIdPagamentoFesta() {
        return idPagamentoFesta;
    }

    public void setIdPagamentoFesta(Integer idPagamentoFesta) {
        this.idPagamentoFesta = idPagamentoFesta;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getPagamentoStatus() {
        return pagamentoStatus;
    }

    public void setPagamentoStatus(int pagamentoStatus) {
        this.pagamentoStatus = pagamentoStatus;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Festa getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Festa idFesta) {
        this.idFesta = idFesta;
    }

    public List<PagamentoAdiantadoFesta> getPagamentoadiantadofestaList() {
        return pagamentoadiantadofestaList;
    }

    public void setPagamentoadiantadofestaList(List<PagamentoAdiantadoFesta> pagamentoadiantadofestaList) {
        this.pagamentoadiantadofestaList = pagamentoadiantadofestaList;
    }
    
}
