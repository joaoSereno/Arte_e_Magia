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
public class TabelaAgendamentoFesta implements Serializable {

    private Integer idTabelaAgendamentoFesta;
    private String contratante;
    private String aniversariante;
    private String tipoDeFesta;
    private String localDaFesta;
    private String cacheFuncionarios;
    private String horarios;
    private String pacote;
    private String pacotesAdicionais;
    private String lucroFesta;
    private String valorReceber;
    private String observacaoFesta;
    private Festa idFesta;

    public TabelaAgendamentoFesta() {
    }

    public TabelaAgendamentoFesta(Integer idTabelaAgendamentoFesta) {
        this.idTabelaAgendamentoFesta = idTabelaAgendamentoFesta;
    }

    public Integer getIdTabelaAgendamentoFesta() {
        return idTabelaAgendamentoFesta;
    }

    public void setIdTabelaAgendamentoFesta(Integer idTabelaAgendamentoFesta) {
        this.idTabelaAgendamentoFesta = idTabelaAgendamentoFesta;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getAniversariante() {
        return aniversariante;
    }

    public void setAniversariante(String aniversariante) {
        this.aniversariante = aniversariante;
    }

    public String getTipoDeFesta() {
        return tipoDeFesta;
    }

    public void setTipoDeFesta(String tipoDeFesta) {
        this.tipoDeFesta = tipoDeFesta;
    }

    public String getLocalDaFesta() {
        return localDaFesta;
    }

    public void setLocalDaFesta(String localDaFesta) {
        this.localDaFesta = localDaFesta;
    }

    public String getCacheFuncionarios() {
        return cacheFuncionarios;
    }

    public void setCacheFuncionarios(String cacheFuncionarios) {
        this.cacheFuncionarios = cacheFuncionarios;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getPacote() {
        return pacote;
    }

    public void setPacote(String pacote) {
        this.pacote = pacote;
    }

    public String getPacotesAdicionais() {
        return pacotesAdicionais;
    }

    public void setPacotesAdicionais(String pacotesAdicionais) {
        this.pacotesAdicionais = pacotesAdicionais;
    }

    public String getLucroFesta() {
        return lucroFesta;
    }

    public void setLucroFesta(String lucroFesta) {
        this.lucroFesta = lucroFesta;
    }

    public String getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(String valorReceber) {
        this.valorReceber = valorReceber;
    }

    public String getObservacaoFesta() {
        return observacaoFesta;
    }

    public void setObservacaoFesta(String observacaoFesta) {
        this.observacaoFesta = observacaoFesta;
    }

    public Festa getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Festa idFesta) {
        this.idFesta = idFesta;
    }

}
