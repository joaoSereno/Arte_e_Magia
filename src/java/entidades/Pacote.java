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

public class Pacote implements Serializable {

    private Integer idPacote;
    private String nomePacote;
    private float valorPacoteVenda;
    private int ativo;
    private List<Festa> festaList;

    public Pacote() {
    }

    public Pacote(Integer idPacote) {
        this.idPacote = idPacote;
    }

    public Pacote(Integer idPacote, String nomePacote, float valorPacoteVenda, int ativo) {
        this.idPacote = idPacote;
        this.nomePacote = nomePacote;
        this.valorPacoteVenda = valorPacoteVenda;
        this.ativo = ativo;
    }

    public Integer getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(Integer idPacote) {
        this.idPacote = idPacote;
    }

    public String getNomePacote() {
        return nomePacote;
    }

    public void setNomePacote(String nomePacote) {
        this.nomePacote = nomePacote;
    }

    public float getValorPacoteVenda() {
        return valorPacoteVenda;
    }

    public void setValorPacoteVenda(float valorPacoteVenda) {
        this.valorPacoteVenda = valorPacoteVenda;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public List<Festa> getFestaList() {
        return festaList;
    }

    public void setFestaList(List<Festa> festaList) {
        this.festaList = festaList;
    }
    
}
