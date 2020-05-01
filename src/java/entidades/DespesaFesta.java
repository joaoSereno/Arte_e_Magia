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
public class DespesaFesta  {

    private Integer idDespesas;
    private String descricao;
    private float valorDespesa;
    private int isFuncionariaPag;
    private int status;
    private Integer idFormaPagamento;
    private Integer idTipoDeDespesa;
    private Integer idFesta;
    private Integer idFuncionario;
    private String origem;
        
    public DespesaFesta() {
    }

    public DespesaFesta(Integer idDespesas) {
        this.idDespesas = idDespesas;
    }

    public DespesaFesta(Integer idDespesas, float valorDespesa, int isFuncionariaPag, int status) {
        this.idDespesas = idDespesas;
        this.valorDespesa = valorDespesa;
        this.isFuncionariaPag = isFuncionariaPag;
        this.status = status;
    }

    public Integer getIdTipoDeDespesa() {
        return idTipoDeDespesa;
    }

    public void setIdTipoDeDespesa(Integer idTipoDeDespesa) {
        this.idTipoDeDespesa = idTipoDeDespesa;
    }

    public Integer getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(Integer idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public Integer getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Integer idFesta) {
        this.idFesta = idFesta;
    }

    public Integer getIdDespesaFesta() {
        return idDespesas;
    }

    public void setIdDespesaFesta(Integer idDespesas) {
        this.idDespesas = idDespesas;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Integer getIdDespesas() {
        return idDespesas;
    }

    public void setIdDespesas(Integer idDespesas) {
        this.idDespesas = idDespesas;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    
}
