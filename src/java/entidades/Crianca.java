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
public class Crianca implements Serializable {

    private Integer idCrianca;
    private String nomeCrianca;
    private String sexo;
    private String dataNascimento;
    private int ativo;
    private Cliente idCliente;
    private List<FestaCrianca> festacriancaList;

    public Crianca() {
    }

    public Crianca(Integer idCrianca) {
        this.idCrianca = idCrianca;
    }

    public Crianca(Integer idCrianca, String nomeCrianca, String sexo, String dataNascimento, int ativo) {
        this.idCrianca = idCrianca;
        this.nomeCrianca = nomeCrianca;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.ativo = ativo;
    }

    public Integer getIdCrianca() {
        return idCrianca;
    }

    public void setIdCrianca(Integer idCrianca) {
        this.idCrianca = idCrianca;
    }

    public String getNomeCrianca() {
        return nomeCrianca;
    }

    public void setNomeCrianca(String nomeCrianca) {
        this.nomeCrianca = nomeCrianca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public List<FestaCrianca> getFestacriancaList() {
        return festacriancaList;
    }

    public void setFestacriancaList(List<FestaCrianca> festacriancaList) {
        this.festacriancaList = festacriancaList;
    }
    
}
