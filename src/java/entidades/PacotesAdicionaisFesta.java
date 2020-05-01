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

public class PacotesAdicionaisFesta {

    private Integer idPacotesAdicionaisFesta;
    private float valorPacoteAdd;
    private Integer idTipoPacoteAdicional;
    private Integer idFesta;

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

    public Integer getIdTipoPacoteAdicional() {
        return idTipoPacoteAdicional;
    }

    public void setIdTipoPacoteAdicional(Integer idTipoPacoteAdicional) {
        this.idTipoPacoteAdicional = idTipoPacoteAdicional;
    }

    public Integer getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Integer idFesta) {
        this.idFesta = idFesta;
    }
    
}
