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

public class FuncionarioFesta {

    private Integer idFuncionarioFesta;
    private Integer idFuncionario;
    private float cacheFesta;
    private Integer idFesta;

    public FuncionarioFesta() {
    }

    public FuncionarioFesta(Integer idFuncionarioFesta) {
        this.idFuncionarioFesta = idFuncionarioFesta;
    }

    public Integer getIdFuncionarioFesta() {
        return idFuncionarioFesta;
    }

    public void setIdFuncionarioFesta(Integer idFuncionarioFesta) {
        this.idFuncionarioFesta = idFuncionarioFesta;
    }

    public float getCacheFesta() {
        return cacheFesta;
    }

    public void setCacheFesta(float cacheFesta) {
        this.cacheFesta = cacheFesta;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Integer idFesta) {
        this.idFesta = idFesta;
    }
    
}
