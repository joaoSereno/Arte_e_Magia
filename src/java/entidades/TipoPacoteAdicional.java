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
public class TipoPacoteAdicional {

    private Integer idTipoPacoteAdicional;
    private String descricaoPacoteAdd;
    private int ativo;

    public TipoPacoteAdicional() {
    }

    public TipoPacoteAdicional(Integer idTipoPacoteAdicional) {
        this.idTipoPacoteAdicional = idTipoPacoteAdicional;
    }

    public TipoPacoteAdicional(Integer idTipoPacoteAdicional, String descricaoPacoteAdd) {
        this.idTipoPacoteAdicional = idTipoPacoteAdicional;
        this.descricaoPacoteAdd = descricaoPacoteAdd;
    }

    public Integer getIdTipoPacoteAdicional() {
        return idTipoPacoteAdicional;
    }

    public void setIdTipoPacoteAdicional(Integer idTipoPacoteAdicional) {
        this.idTipoPacoteAdicional = idTipoPacoteAdicional;
    }

    public String getDescricaoPacoteAdd() {
        return descricaoPacoteAdd;
    }

    public void setDescricaoPacoteAdd(String descricaoPacoteAdd) {
        this.descricaoPacoteAdd = descricaoPacoteAdd;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
}
