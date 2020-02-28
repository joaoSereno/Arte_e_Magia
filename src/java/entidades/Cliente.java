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
public class Cliente implements Serializable {

    private Integer idCliente;
    private String nomeCliente;
    private String cpf;
    private String tipoFesta;
    private int ativo;
    private List<Telefone> telefoneList;
    private List<Crianca> criancaList;
    private List<Festa> festaList;
    private List<Enderecos> enderecosList;
    private List<Email> emailList;
    private String telefonePrincipal;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nomeCliente, String cpf, String tipoFesta, int ativo) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.tipoFesta = tipoFesta;
        this.ativo = ativo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoFesta() {
        return tipoFesta;
    }

    public void setTipoFesta(String tipoFesta) {
        this.tipoFesta = tipoFesta;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public List<Telefone> getTelefoneList() {
        return telefoneList;
    }

    public void setTelefoneList(List<Telefone> telefoneList) {
        this.telefoneList = telefoneList;
    }

    public List<Crianca> getCriancaList() {
        return criancaList;
    }

    public void setCriancaList(List<Crianca> criancaList) {
        this.criancaList = criancaList;
    }

    public List<Festa> getFestaList() {
        return festaList;
    }

    public void setFestaList(List<Festa> festaList) {
        this.festaList = festaList;
    }

    public List<Enderecos> getEnderecosList() {
        return enderecosList;
    }

    public void setEnderecosList(List<Enderecos> enderecosList) {
        this.enderecosList = enderecosList;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    public String getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(String telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    
}
