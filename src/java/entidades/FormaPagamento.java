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
public class FormaPagamento implements Serializable {

    private Integer idFormaPagamento;
    private String nomePagamento;
    private int ativo;
    private List<PagamentoAdiantadoFesta> pagamentoadiantadofestaList;
    private List<DespesaFesta> despesafestaList;

    public FormaPagamento() {
    }

    public FormaPagamento(Integer idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public FormaPagamento(Integer idFormaPagamento, String nomePagamento, int ativo) {
        this.idFormaPagamento = idFormaPagamento;
        this.nomePagamento = nomePagamento;
        this.ativo = ativo;
    }

    public Integer getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(Integer idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getNomePagamento() {
        return nomePagamento;
    }

    public void setNomePagamento(String nomePagamento) {
        this.nomePagamento = nomePagamento;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public List<PagamentoAdiantadoFesta> getPagamentoadiantadofestaList() {
        return pagamentoadiantadofestaList;
    }

    public void setPagamentoadiantadofestaList(List<PagamentoAdiantadoFesta> pagamentoadiantadofestaList) {
        this.pagamentoadiantadofestaList = pagamentoadiantadofestaList;
    }

    public List<DespesaFesta> getDespesafestaList() {
        return despesafestaList;
    }

    public void setDespesafestaList(List<DespesaFesta> despesafestaList) {
        this.despesafestaList = despesafestaList;
    }

    
}
