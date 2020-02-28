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
public class Festa implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idFesta;
    private String descricaoFesta;
    private String dataFesta;
    private int festaRealizada;
    private String obs;
    private int festaRealizaStatus;
    private List<PagamentoFesta> pagamentofestaList;
    private List<PagamentoAdiantadoFesta> pagamentoadiantadofestaList;
    private List<FuncionarioFesta> funcionariofestaList;
    private Enderecos idEnderecos;
    private Cliente idCliente;
    private Pacote idPacote;
    private List<DespesaFesta> despesafestaList;
    private List<TabelaAgendamentoFesta> tabelaagendamentofestaList;
    private List<ValorAdicionalFesta> valoradicionalfestaList;
    private List<HorarioFesta> horariofestaList;
    private List<PacotesAdicionaisFesta> pacotesadicionaisfestaList;
    private List<FestaCrianca> festacriancaList;

    public Festa() {
    }

    public Festa(Integer idFesta) {
        this.idFesta = idFesta;
    }

    public Festa(Integer idFesta, String dataFesta, int festaRealizada, String obs, int festaRealizaStatus) {
        this.idFesta = idFesta;
        this.dataFesta = dataFesta;
        this.festaRealizada = festaRealizada;
        this.obs = obs;
        this.festaRealizaStatus = festaRealizaStatus;
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

    public String getDataFesta() {
        return dataFesta;
    }

    public void setDataFesta(String dataFesta) {
        this.dataFesta = dataFesta;
    }

    public int getFestaRealizada() {
        return festaRealizada;
    }

    public void setFestaRealizada(int festaRealizada) {
        this.festaRealizada = festaRealizada;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getFestaRealizaStatus() {
        return festaRealizaStatus;
    }

    public void setFestaRealizaStatus(int festaRealizaStatus) {
        this.festaRealizaStatus = festaRealizaStatus;
    }

    public List<PagamentoFesta> getPagamentofestaList() {
        return pagamentofestaList;
    }

    public void setPagamentofestaList(List<PagamentoFesta> pagamentofestaList) {
        this.pagamentofestaList = pagamentofestaList;
    }

    public List<PagamentoAdiantadoFesta> getPagamentoadiantadofestaList() {
        return pagamentoadiantadofestaList;
    }

    public void setPagamentoadiantadofestaList(List<PagamentoAdiantadoFesta> pagamentoadiantadofestaList) {
        this.pagamentoadiantadofestaList = pagamentoadiantadofestaList;
    }

    public List<FuncionarioFesta> getFuncionariofestaList() {
        return funcionariofestaList;
    }

    public void setFuncionariofestaList(List<FuncionarioFesta> funcionariofestaList) {
        this.funcionariofestaList = funcionariofestaList;
    }

    public Enderecos getIdEnderecos() {
        return idEnderecos;
    }

    public void setIdEnderecos(Enderecos idEnderecos) {
        this.idEnderecos = idEnderecos;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Pacote getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(Pacote idPacote) {
        this.idPacote = idPacote;
    }

    public List<DespesaFesta> getDespesafestaList() {
        return despesafestaList;
    }

    public void setDespesafestaList(List<DespesaFesta> despesafestaList) {
        this.despesafestaList = despesafestaList;
    }

    public List<TabelaAgendamentoFesta> getTabelaagendamentofestaList() {
        return tabelaagendamentofestaList;
    }

    public void setTabelaagendamentofestaList(List<TabelaAgendamentoFesta> tabelaagendamentofestaList) {
        this.tabelaagendamentofestaList = tabelaagendamentofestaList;
    }

    public List<ValorAdicionalFesta> getValoradicionalfestaList() {
        return valoradicionalfestaList;
    }

    public void setValoradicionalfestaList(List<ValorAdicionalFesta> valoradicionalfestaList) {
        this.valoradicionalfestaList = valoradicionalfestaList;
    }

    public List<HorarioFesta> getHorariofestaList() {
        return horariofestaList;
    }

    public void setHorariofestaList(List<HorarioFesta> horariofestaList) {
        this.horariofestaList = horariofestaList;
    }

    public List<PacotesAdicionaisFesta> getPacotesadicionaisfestaList() {
        return pacotesadicionaisfestaList;
    }

    public void setPacotesadicionaisfestaList(List<PacotesAdicionaisFesta> pacotesadicionaisfestaList) {
        this.pacotesadicionaisfestaList = pacotesadicionaisfestaList;
    }

    public List<FestaCrianca> getFestacriancaList() {
        return festacriancaList;
    }

    public void setFestacriancaList(List<FestaCrianca> festacriancaList) {
        this.festacriancaList = festacriancaList;
    }

}
