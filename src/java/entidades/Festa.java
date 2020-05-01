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
public class Festa {

    private Integer idFesta;
    private String descricaoFesta;
    private String dataFesta;
    private String obs;
    private int festaStatus;
    private Enderecos idEnderecos;
    private Cliente idCliente;
    private Pacote idPacote;
    private int qtdCriancas;
    private int idTipoDeFesta;
    private float valorTotal;
    private float totalDespesa;
    private float lucroFesta;
    private float receberContrante ;
    private List<PagamentoFesta> pagamentofestaList;
    private List<FuncionarioFesta> funcionariofestaList;
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

    public Festa(Integer idFesta, String dataFesta, String obs, int festaStatus) {
        this.idFesta = idFesta;
        this.dataFesta = dataFesta;
        this.obs = obs;
        this.festaStatus = festaStatus;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public List<PagamentoFesta> getPagamentofestaList() {
        return pagamentofestaList;
    }

    public void setPagamentofestaList(List<PagamentoFesta> pagamentofestaList) {
        this.pagamentofestaList = pagamentofestaList;
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

    public int getQtdCriancas() {
        return qtdCriancas;
    }

    public void setQtdCriancas(int qtdCriancas) {
        this.qtdCriancas = qtdCriancas;
    }

    public int getFestaStatus() {
        return festaStatus;
    }

    public void setFestaStatus(int festaStatus) {
        this.festaStatus = festaStatus;
    }

    public int getIdTipoDeFesta() {
        return idTipoDeFesta;
    }

    public void setIdTipoDeFesta(int idTipoDeFesta) {
        this.idTipoDeFesta = idTipoDeFesta;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getTotalDespesa() {
        return totalDespesa;
    }

    public void setTotalDespesa(float totalDespesa) {
        this.totalDespesa = totalDespesa;
    }

    public float getLucroFesta() {
        return lucroFesta;
    }

    public void setLucroFesta(float lucroFesta) {
        this.lucroFesta = lucroFesta;
    }

    public float getReceberContrante() {
        return receberContrante;
    }

    public void setReceberContrante(float receberContrante) {
        this.receberContrante = receberContrante;
    }
    
    
}
