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

public class PagamentoDespesasDetalhe {

    private Integer idPagamentoDespesas;
    private float valor;
    private String dataPagamento;
    private int status;
    private Integer idDespesas;

    public PagamentoDespesasDetalhe() {
    }

    public PagamentoDespesasDetalhe(Integer idPagamentoDespesas) {
        this.idPagamentoDespesas = idPagamentoDespesas;
    }

    public PagamentoDespesasDetalhe(Integer idPagamentoDespesas, float valor, String dataPagamento, int status) {
        this.idPagamentoDespesas = idPagamentoDespesas;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.status = status;
    }

    public Integer getIdPagamentoDespesas() {
        return idPagamentoDespesas;
    }

    public void setIdPagamentoDespesas(Integer idPagamentoDespesas) {
        this.idPagamentoDespesas = idPagamentoDespesas;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getIdDespesas() {
        return idDespesas;
    }

    public void setIdDespesas(Integer idDespesas) {
        this.idDespesas = idDespesas;
    }


    
}
