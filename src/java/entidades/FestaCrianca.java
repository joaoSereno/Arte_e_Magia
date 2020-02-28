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
public class FestaCrianca implements Serializable {

    private Integer idFestaCrianca;
    private Crianca idCrianca;
    private Festa idFesta;

    public FestaCrianca() {
    }

    public FestaCrianca(Integer idFestaCrianca) {
        this.idFestaCrianca = idFestaCrianca;
    }

    public Integer getIdFestaCrianca() {
        return idFestaCrianca;
    }

    public void setIdFestaCrianca(Integer idFestaCrianca) {
        this.idFestaCrianca = idFestaCrianca;
    }

    public Crianca getIdCrianca() {
        return idCrianca;
    }

    public void setIdCrianca(Crianca idCrianca) {
        this.idCrianca = idCrianca;
    }

    public Festa getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Festa idFesta) {
        this.idFesta = idFesta;
    }
 
}
