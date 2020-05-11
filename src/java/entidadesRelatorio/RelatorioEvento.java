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
public class RelatorioEvento {
  
    private String descricaoEvento;
    private String dataEvento;
    private float valorTotalBruto;
    private float valorTotalDespesa;
    private float lucroEvento;
    private int statusEvento2;
    private String statusEvento;
    private int count;

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public float getValorTotalBruto() {
        return valorTotalBruto;
    }

    public void setValorTotalBruto(float valorTotalBruto) {
        this.valorTotalBruto = valorTotalBruto;
    }

    public float getValorTotalDespesa() {
        return valorTotalDespesa;
    }

    public void setValorTotalDespesa(float valorTotalDespesa) {
        this.valorTotalDespesa = valorTotalDespesa;
    }

    public float getLucroEvento() {
        return lucroEvento;
    }

    public void setLucroEvento(float lucroEvento) {
        this.lucroEvento = lucroEvento;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStatusEvento() {
        return statusEvento;
    }

    public void setStatusEvento(String statusEvento) {
        this.statusEvento = statusEvento;
    }

    public int getStatusEvento2() {
        return statusEvento2;
    }

    public void setStatusEvento2(int statusEvento2) {
        this.statusEvento2 = statusEvento2;
    }
    
}
