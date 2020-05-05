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
public class HorarioFesta{

    private Integer idHorarioFesta;
    private String horario;
    private String descricao;
    private Integer idFesta;

    public HorarioFesta() {
    }

    public HorarioFesta(Integer idHorarioFesta) {
        this.idHorarioFesta = idHorarioFesta;
    }

    public HorarioFesta(Integer idHorarioFesta, String horario) {
        this.idHorarioFesta = idHorarioFesta;
        this.horario = horario;
    }

    public Integer getIdHorarioFesta() {
        return idHorarioFesta;
    }

    public void setIdHorarioFesta(Integer idHorarioFesta) {
        this.idHorarioFesta = idHorarioFesta;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Integer idFesta) {
        this.idFesta = idFesta;
    }

}
