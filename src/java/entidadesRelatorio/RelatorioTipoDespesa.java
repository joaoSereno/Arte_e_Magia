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
public class RelatorioTipoDespesa implements Comparable<RelatorioTipoDespesa>{
    
    private String descricaoDespesa;
    private Integer idTipoDespesa;
    private int qtd;
    private float valorTotal;
    private int count;
    private int isFuncionario;

    public Integer getIdTipoDespesa() {
        return idTipoDespesa;
    }

    public void setIdTipoDespesa(Integer idTipoDespesa) {
        this.idTipoDespesa = idTipoDespesa;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescricaoDespesa() {
        return descricaoDespesa;
    }

    public void setDescricaoDespesa(String descricaoDespesa) {
        this.descricaoDespesa = descricaoDespesa;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIsFuncionario() {
        return isFuncionario;
    }

    public void setIsFuncionario(int isFuncionario) {
        this.isFuncionario = isFuncionario;
    }    

    @Override
    public int compareTo(RelatorioTipoDespesa relatorioTipoDespesa) {
        
        if(this.valorTotal > relatorioTipoDespesa.getValorTotal()){
            
            
            return -1;
            
        }else if (this.valorTotal < relatorioTipoDespesa.getValorTotal()){
            
            return 1;
            
        }else{
            
            return 0;
        }   
        
    }
}
