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
public class AgendamentoFesta {

    private Integer idTabelaAgendamentoFesta;
    private String descricaoFesta;
    private String dataEvento;
    private String contratante;
    private String aniversariante;
    private String tipoDeFesta;
    private String localDaFesta;
    private String cacheFuncionarios;
    private String horarios;
    private String pacote;
    private String qtdCriancas;
    private String pacotesAdicionais;
    private String valorPegarContratante;
    private String observacaoFesta;
    private Integer idFesta;

    public AgendamentoFesta() {
    }

    public AgendamentoFesta(Integer idTabelaAgendamentoFesta) {
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

    public String getValorPegarContratante() {
        return valorPegarContratante;
    }

    public void setValorPegarContratante(String valorPegarContratante) {
        this.valorPegarContratante = valorPegarContratante;
    }

    public String getObservacaoFesta() {
        return observacaoFesta;
    }

    public void setObservacaoFesta(String observacaoFesta) {
        this.observacaoFesta = observacaoFesta;
    }

    public String getQtdCriancas() {
        return qtdCriancas;
    }

    public void setQtdCriancas(String qtdCriancas) {
        this.qtdCriancas = qtdCriancas;
    }

    public Integer getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Integer idFesta) {
        this.idFesta = idFesta;
    }

    public String getDescricaoFesta() {
        return descricaoFesta;
    }

    public void setDescricaoFesta(String descricaoFesta) {
        this.descricaoFesta = descricaoFesta;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }
    
}
