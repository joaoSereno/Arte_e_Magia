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
public class Enderecos implements Serializable {

    private Integer idEnderecos;
    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    private int isFesta;
    private List<Festa> festaList;
    private Integer idCliente;

    public Enderecos() {
    }

    public Enderecos(Integer idEnderecos) {
        this.idEnderecos = idEnderecos;
    }

    public Enderecos(Integer idEnderecos, String rua, int isFesta) {
        this.idEnderecos = idEnderecos;
        this.rua = rua;
        this.isFesta = isFesta;
    }

    public Integer getIdEnderecos() {
        return idEnderecos;
    }

    public void setIdEnderecos(Integer idEnderecos) {
        this.idEnderecos = idEnderecos;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getIsFesta() {
        return isFesta;
    }

    public void setIsFesta(int isFesta) {
        this.isFesta = isFesta;
    }

    public List<Festa> getFestaList() {
        return festaList;
    }

    public void setFestaList(List<Festa> festaList) {
        this.festaList = festaList;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
}
