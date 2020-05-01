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

public class TipoDeDespesa {

    private Integer idTipoDeDespesa;
    private String nomeDespesa;
    private int ativo;
    private List<DespesaFesta> despesafestaList;
    private List<Despesas> despesasList;

    public TipoDeDespesa() {
    }

    public TipoDeDespesa(Integer idTipoDeDespesa) {
        this.idTipoDeDespesa = idTipoDeDespesa;
    }

    public TipoDeDespesa(Integer idTipoDeDespesa, String nomeDespesa, int ativo) {
        this.idTipoDeDespesa = idTipoDeDespesa;
        this.nomeDespesa = nomeDespesa;
        this.ativo = ativo;
    }

    public Integer getIdTipoDeDespesa() {
        return idTipoDeDespesa;
    }

    public void setIdTipoDeDespesa(Integer idTipoDeDespesa) {
        this.idTipoDeDespesa = idTipoDeDespesa;
    }

    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public List<DespesaFesta> getDespesafestaList() {
        return despesafestaList;
    }

    public void setDespesafestaList(List<DespesaFesta> despesafestaList) {
        this.despesafestaList = despesafestaList;
    }

    public List<Despesas> getDespesasList() {
        return despesasList;
    }

    public void setDespesasList(List<Despesas> despesasList) {
        this.despesasList = despesasList;
    }    
}
