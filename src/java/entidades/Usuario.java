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
public class Usuario{

    private Integer idusuario;
    private String usuario;
    private String senha;
    private int ativo;
    private int tipoUsuario;
    private Integer idFuncionario;
    private String nomeUsuario;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String usuario, String senha, String nomeUsuario) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    }
    
    public Usuario(Integer idusuario, String usuario, String nomeUsuario) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.nomeUsuario = nomeUsuario;
    }
 
    public Usuario(Integer idusuario, String usuario, String senha, int idFuncionario, String nomeUsuario) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.senha = senha;
        this.idFuncionario = idFuncionario;
        this.nomeUsuario = nomeUsuario;
    }
    
    public Usuario(Integer idusuario, String usuario, int idFuncionario, String nomeUsuario) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.idFuncionario = idFuncionario;
        this.nomeUsuario = nomeUsuario;
    }
    
    public Usuario(Integer idusuario, String usuario, String senha, int ativo, int tipoUsuario) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.senha = senha;
        this.ativo = ativo;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    

}
