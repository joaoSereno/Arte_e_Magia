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
public class FestaCrianca {

    private Integer idFestaCrianca;
    private Integer idCrianca;
    private Integer idFesta;

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

    public Integer getIdCrianca() {
        return idCrianca;
    }

    public void setIdCrianca(Integer idCrianca) {
        this.idCrianca = idCrianca;
    }

    public Integer getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Integer idFesta) {
        this.idFesta = idFesta;
    }

 
}
