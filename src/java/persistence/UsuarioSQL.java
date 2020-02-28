/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class UsuarioSQL extends Conexao {

    public static ArrayList<Usuario> getUsuario() throws Exception {

        try {
            open();
            ArrayList<Usuario> listaUsuario = new ArrayList();

            stmt = con.prepareStatement("SELECT u.usuario,\n"
                    + "	   u.senha,\n"
                    + "       u.tipoUsuario,\n"
                    + "       u.idFuncionario,\n"
                    + "       f.nomeFuncionario\n"
                    + "FROM usuario u,\n"
                    + "	 funcionario f\n"
                    + "WHERE u.idFuncionario = f.idFuncionario\n"
                    + "AND u.ativo = 1");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setUsuario(rs.getString("u.usuario"));
                usuario.setSenha(rs.getString("u.senha"));
                usuario.setTipoUsuario(rs.getInt("u.tipoUsuario"));
                usuario.setIdFuncionario(rs.getInt("u.idFuncionario"));
                usuario.setNomeFuncionario(rs.getString("f.nomeFuncionario"));

                listaUsuario.add(usuario);
            }
            close();
            return listaUsuario;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                close();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }
  
    public static Usuario verificaUsuarioLogin(String usuario, String senha) throws Exception {
        
        ArrayList<Usuario> listaUsuario = new ArrayList(); //cria uma lista para receber a lista do banco através do método UsuarioSQL.getUsuario()
        
        listaUsuario = UsuarioSQL.getUsuario(); //recebe a lista de usuario do banco
        
        Usuario usuarioEncontrado = new Usuario(); //cria uma variavel do tipo USUARIO
        
        usuarioEncontrado = null;
        
        for(int i = 0; i < listaUsuario.size(); i++){//loop para verificar se o usuario e senha tem no banco
            if (listaUsuario.get(i).getUsuario().equals(usuario) && listaUsuario.get(i).getSenha().equals(senha)) {//verifica o usuário e verifica a senha se é igual aos do parametros
                usuarioEncontrado = listaUsuario.get(i); //recebe o funcionario na variavel usuarioEncontrado e retorna para aonde chamo a função
                break;//para o loop
                }
        }
        return usuarioEncontrado; //retorna usuario encontrado        
    }          
}
