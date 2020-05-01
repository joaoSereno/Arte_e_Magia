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
public class TipoDeFesta {
    private int idTipoDeFesta;
    private String descricaoTipoDeFesta;
    private int ativo;

    public TipoDeFesta() {
        
    }
    
    public TipoDeFesta(int idTipoDeFesta, String descricaoTipoDeFesta, int ativo) {
        this.idTipoDeFesta = idTipoDeFesta;
        this.descricaoTipoDeFesta = descricaoTipoDeFesta;
        this.ativo = ativo;
    }

    public int getIdTipoDeFesta() {
        return idTipoDeFesta;
    }

    public void setIdTipoDeFesta(int idTipoDeFesta) {
        this.idTipoDeFesta = idTipoDeFesta;
    }

    public String getDescricaoTipoDeFesta() {
        return descricaoTipoDeFesta;
    }

    public void setDescricaoTipoDeFesta(String descricaoTipoDeFesta) {
        this.descricaoTipoDeFesta = descricaoTipoDeFesta;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

}
