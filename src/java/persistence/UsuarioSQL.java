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

            stmt = con.prepareStatement("SELECT idusuario,\n"
                    + "	usuario,\n"
                    + "     senha,\n"
                    + "     tipoUsuario,\n"
                    + "     idFuncionario,\n"
                    + "     nomeUsuario \n"
                    + "FROM usuario\n"
                    + "WHERE ativo = 1 \n"
                    + "ORDER BY tipoUsuario");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipoUsuario(rs.getInt("tipoUsuario"));
                usuario.setIdFuncionario(rs.getInt("idFuncionario"));
                usuario.setNomeUsuario(rs.getString("nomeUsuario"));

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

        for (int i = 0; i < listaUsuario.size(); i++) {//loop para verificar se o usuario e senha tem no banco
            if (listaUsuario.get(i).getUsuario().equals(usuario) && listaUsuario.get(i).getSenha().equals(senha)) {//verifica o usuário e verifica a senha se é igual aos do parametros
                usuarioEncontrado = listaUsuario.get(i); //recebe o funcionario na variavel usuarioEncontrado e retorna para aonde chamo a função
                break;//para o loop
            }
        }
        return usuarioEncontrado; //retorna usuario encontrado        
    }

    public void create(Usuario usuario) throws Exception { //recebe usuario vindo do controller

        open(); //abre conexão com o banco de dados

        if (usuario.getIdFuncionario() != null) { //se for != null é cadastro do tipo FUNC

            //define comando para o banco de dados
            stmt = con.prepareStatement("INSERT INTO usuario(usuario, senha, ativo, tipoUsuario, idFuncionario, nomeUsuario) VALUES (?,?,?,?,?,?)");

            //atribui os valores das marcações do comando acima 
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, 1);
            stmt.setInt(4, 2); // 2 = FUNC
            stmt.setInt(5, usuario.getIdFuncionario());
            stmt.setString(6, usuario.getNomeUsuario());

        } else { //se não é do tipo ADM

            //define comando para o banco de dados
            stmt = con.prepareStatement("INSERT INTO usuario (usuario, senha, ativo, tipoUsuario, nomeUsuario) VALUES (?,?,?,?,?)");

            //atribui os valores das marcações do comando acima 
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, 1);
            stmt.setInt(4, 1); // 1 = ADM
            stmt.setString(5, usuario.getNomeUsuario());

        }

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados

    }

    public void inativaUsuario(int idusuario) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE usuario SET ativo = 0 WHERE idusuario = ?");

        stmt.setInt(1, idusuario); //seta idusuario no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }
    
    public void inativaUsuarioDeFuncionario(int idFuncionario) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE usuario SET ativo = 0 WHERE idFuncionario = ?");

        stmt.setInt(1, idFuncionario); //seta idFuncionario no ?

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }

    public void editarUsuario(Usuario usuario) throws Exception {

        open(); //abre conexão com o banco de dados

        if (usuario.getIdFuncionario() != null) { //se for cadastro do tipo FUNC

            stmt = con.prepareStatement("UPDATE usuario SET usuario = ?, idFuncionario =?, nomeUsuario =? WHERE idusuario = ?");

            //setando valores do update
            stmt.setString(1, usuario.getUsuario());
            stmt.setInt(2, usuario.getIdFuncionario());
            stmt.setString(3, usuario.getNomeUsuario());
            stmt.setInt(4, usuario.getIdusuario());

        } else { //se for cadastro do tipo ADM

            stmt = con.prepareStatement("UPDATE usuario SET usuario = ?, nomeUsuario =? WHERE idusuario = ?");

            //setando valores do update
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getNomeUsuario());
            stmt.setInt(3, usuario.getIdusuario());

        }

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados

    }

    public Usuario getUsuarioEspecifico(int idUsuario) throws Exception {

        try {
            open();

            stmt = con.prepareStatement("SELECT idusuario, usuario, senha, ativo, tipoUsuario, idFuncionario, nomeUsuario FROM usuario WHERE idusuario = ?");

            stmt.setInt(1, idUsuario); //seta idusuario no ?

            ResultSet rs = stmt.executeQuery();

            Usuario usuario = new Usuario();

            while (rs.next()) {

                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipoUsuario(rs.getInt("tipoUsuario"));
                usuario.setIdFuncionario(rs.getInt("idFuncionario"));
                usuario.setNomeUsuario(rs.getString("nomeUsuario"));

            }
            close();
            return usuario;

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

    public void novaSenha(int idUsuario, String senha) throws Exception {

        open(); //abre conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE usuario SET senha = ? WHERE idusuario = ?");

        //setando valores do update
        stmt.setString(1, senha);
        stmt.setInt(2, idUsuario);

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
        
    }

}
