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
public class Email implements Serializable {

    private Integer idEmail;
    private String email;
    private Integer idCliente;

    public Email() {
    }

    public Email(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public Email(Integer idEmail, String email) {
        this.idEmail = idEmail;
        this.email = email;
    }

    public Integer getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

}
