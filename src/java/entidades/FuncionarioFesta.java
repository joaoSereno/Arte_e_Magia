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
    private Funcionario idFuncionario;
    private float cacheFesta;
    private Festa idFesta;

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

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Festa getIdFesta() {
        return idFesta;
    }

    public void setIdFesta(Festa idFesta) {
        this.idFesta = idFesta;
    }

    public float getCacheFesta() {
        return cacheFesta;
    }

    public void setCacheFesta(float cacheFesta) {
        this.cacheFesta = cacheFesta;
    }
    
}
