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
public class DespesaFesta implements Serializable {

    private Integer idDespesaFesta;
    private String descricao;
    private float valorDespesa;
    private int isFuncionariaPag;
    private int statusPagamento;
    private FormaPagamento idFormaPagamento;
    private TipoDeDespesa idTipoDeDespesa;
    private Festa idFesta;
    private Funcionario idFuncionario;

    public DespesaFesta() {
    }

    public DespesaFesta(Integer idDespesaFesta) {
        this.idDespesaFesta = idDespesaFesta;
    }

    public DespesaFesta(Integer idDespesaFesta, float valorDespesa, int isFuncionariaPag, int statusPagamento) {
        this.idDespesaFesta = idDespesaFesta;
        this.valorDespesa = valorDespesa;
        this.isFuncionariaPag = isFuncionariaPag;
        this.statusPagamento = statusPagamento;
    }

    public Integer getIdDespesaFesta() {
        return idDespesaFesta;
    }

    public void setIdDespesaFesta(Integer idDespesaFesta) {
        this.idDespesaFesta = idDespesaFesta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(float valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public int getIsFuncionariaPag() {
        return isFuncionariaPag;
    }

    public void setIsFuncionariaPag(int isFuncionariaPag) {
        this.isFuncionariaPag = isFuncionariaPag;
    }

    public int getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(int statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public FormaPagamento getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(FormaPagamento idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public TipoDeDespesa getIdTipoDeDespesa() {
        return idTipoDeDespesa;
    }

    public void setIdTipoDeDespesa(TipoDeDespesa idTipoDeDespesa) {
        this.idTipoDeDespesa = idTipoDeDespesa;
    }

    public Festa getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Festa idFesta) {
        this.idFesta = idFesta;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
}
