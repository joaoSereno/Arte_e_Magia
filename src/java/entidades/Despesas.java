/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


import java.util.List;

/**
 *
 * @author João Pedro
 */
public class Despesas {

    private Integer idDespesas;
    private String descricaoDespesa;
    private String obs;
    private int statusDespesa;
    private List<PagamentoDespesasDetalhe> pagamentodespesasdetalheList;
    private Integer idTipoDeDespesa;
    private String origem;
    

    public Despesas() {
    }

    public Despesas(Integer idDespesas) {
        this.idDespesas = idDespesas;
    }

    public Despesas(Integer idDespesas, int statusDespesa) {
        this.idDespesas = idDespesas;
        this.statusDespesa = statusDespesa;
    }

    public Integer getIdDespesas() {
        return idDespesas;
    }

    public void setIdDespesas(Integer idDespesas) {
        this.idDespesas = idDespesas;
    }

    public String getDescricaoDespesa() {
        return descricaoDespesa;
    }

    public void setDescricaoDespesa(String descricaoDespesa) {
        this.descricaoDespesa = descricaoDespesa;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getStatusDespesa() {
        return statusDespesa;
    }

    public void setStatusDespesa(int statusDespesa) {
        this.statusDespesa = statusDespesa;
    }

    public List<PagamentoDespesasDetalhe> getPagamentodespesasdetalheList() {
        return pagamentodespesasdetalheList;
    }

    public void setPagamentodespesasdetalheList(List<PagamentoDespesasDetalhe> pagamentodespesasdetalheList) {
        this.pagamentodespesasdetalheList = pagamentodespesasdetalheList;
    }

    public Integer getIdTipoDeDespesa() {
        return idTipoDeDespesa;
    }

    public void setIdTipoDeDespesa(Integer idTipoDeDespesa) {
        this.idTipoDeDespesa = idTipoDeDespesa;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
}
