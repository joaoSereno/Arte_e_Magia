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
public class ConfigNotificacaoAniversariante implements Serializable {


    private Integer idConfigNotificacaoAniversariante;
    private int dias;

    public ConfigNotificacaoAniversariante() {
    }

    public ConfigNotificacaoAniversariante(Integer idConfigNotificacaoAniversariante) {
        this.idConfigNotificacaoAniversariante = idConfigNotificacaoAniversariante;
    }

    public ConfigNotificacaoAniversariante(Integer idConfigNotificacaoAniversariante, int dias) {
        this.idConfigNotificacaoAniversariante = idConfigNotificacaoAniversariante;
        this.dias = dias;
    }

    public Integer getIdConfigNotificacaoAniversariante() {
        return idConfigNotificacaoAniversariante;
    }

    public void setIdConfigNotificacaoAniversariante(Integer idConfigNotificacaoAniversariante) {
        this.idConfigNotificacaoAniversariante = idConfigNotificacaoAniversariante;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

}
