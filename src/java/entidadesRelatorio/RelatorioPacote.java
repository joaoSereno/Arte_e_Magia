/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesRelatorio;

/**
 *
 * @author João Pedro
 */
public class RelatorioPacote {
    
    private String nomePacote;
    private int qtdVendida;

    public RelatorioPacote() {
    }

    public RelatorioPacote(String nomePacote, int qtdVendida) {
        this.nomePacote = nomePacote;
        this.qtdVendida = qtdVendida;
    }

    public String getNomePacote() {
        return nomePacote;
    }

    public void setNomePacote(String nomePacote) {
        this.nomePacote = nomePacote;
    }

    public int getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    } 
    
}
