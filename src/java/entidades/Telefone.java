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
public class Telefone implements Serializable {

    private Integer idTelefone;
    private String numero;
    private int isCelular;
    private int isFixo;
    private Integer idFuncionario;
    private Integer idCliente;
    private int isPrincipal;
    private String tipoTelefone;

    public Telefone() {
    }

    public Telefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public Telefone(Integer idTelefone, String numero, int isCelular, int isFixo) {
        this.idTelefone = idTelefone;
        this.numero = numero;
        this.isCelular = isCelular;
        this.isFixo = isFixo;
    }

    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getIsCelular() {
        return isCelular;
    }

    public void setIsCelular(int isCelular) {
        this.isCelular = isCelular;
    }

    public int getIsFixo() {
        return isFixo;
    }

    public void setIsFixo(int isFixo) {
        this.isFixo = isFixo;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public int getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(int isPrincipal) {
        this.isPrincipal = isPrincipal;
    }
 
}
