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

public class PacotesAdicionaisFesta implements Serializable {

    private Integer idPacotesAdicionaisFesta;
    private float valorPacoteAdd;
    private TipoPacoteAdicional idTipoPacoteAdicional;
    private Festa idFesta;

    public PacotesAdicionaisFesta() {
    }

    public PacotesAdicionaisFesta(Integer idPacotesAdicionaisFesta) {
        this.idPacotesAdicionaisFesta = idPacotesAdicionaisFesta;
    }

    public PacotesAdicionaisFesta(Integer idPacotesAdicionaisFesta, float valorPacoteAdd) {
        this.idPacotesAdicionaisFesta = idPacotesAdicionaisFesta;
        this.valorPacoteAdd = valorPacoteAdd;
    }

    public Integer getIdPacotesAdicionaisFesta() {
        return idPacotesAdicionaisFesta;
    }

    public void setIdPacotesAdicionaisFesta(Integer idPacotesAdicionaisFesta) {
        this.idPacotesAdicionaisFesta = idPacotesAdicionaisFesta;
    }

    public float getValorPacoteAdd() {
        return valorPacoteAdd;
    }

    public void setValorPacoteAdd(float valorPacoteAdd) {
        this.valorPacoteAdd = valorPacoteAdd;
    }

    public TipoPacoteAdicional getIdTipoPacoteAdicional() {
        return idTipoPacoteAdicional;
    }

    public void setIdTipoPacoteAdicional(TipoPacoteAdicional idTipoPacoteAdicional) {
        this.idTipoPacoteAdicional = idTipoPacoteAdicional;
    }

    public Festa getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Festa idFesta) {
        this.idFesta = idFesta;
    }
    
}
