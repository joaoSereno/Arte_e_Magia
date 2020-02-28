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
public class TipoPacoteAdicional implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idTipoPacoteAdicional;
    private String descricaoPacoteAdd;
    private List<PacotesAdicionaisFesta> pacotesadicionaisfestaList;

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

    public List<PacotesAdicionaisFesta> getPacotesadicionaisfestaList() {
        return pacotesadicionaisfestaList;
    }

    public void setPacotesadicionaisfestaList(List<PacotesAdicionaisFesta> pacotesadicionaisfestaList) {
        this.pacotesadicionaisfestaList = pacotesadicionaisfestaList;
    }
    
}
