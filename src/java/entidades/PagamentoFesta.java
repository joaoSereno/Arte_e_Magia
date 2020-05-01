/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author João Pedro
 */
public class PagamentoFesta{

    private Integer idPagamentoFesta;
    private float valor;
    private int pagamentoStatus;
    private String dataPagamento;
    private Integer idFesta;
    private Integer idFormaDePagamento;

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
    
    public Integer getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Integer idFesta) {
        this.idFesta = idFesta;
    }

    public Integer getIdFormaDePagamento() {
        return idFormaDePagamento;
    }

    public void setIdFormaDePagamento(Integer idFormaDePagamento) {
        this.idFormaDePagamento = idFormaDePagamento;
    }
        
}
