/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.usuario;

import entidades.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.UsuarioSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeUsuario/listaUsuarios")
public class ControllerUsuarioListar extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioSQL usuarioBanco = new UsuarioSQL(); //instancia a classe de comunicação com o banco de dados 
        
        
        List<Usuario> listaUsuarios; //lista que vai receber os dados do usuarios

        try {
 
            listaUsuarios =  UsuarioSQL.getUsuario();// recebe na lista os usuarios pelo método de get do banco 
            request.setAttribute("listaUsuarios", listaUsuarios); // atribui a lista na marcação "listaUsuarios"
            
            request.getRequestDispatcher("usuarioPrincipal.jsp").forward(request, response); // dispara para essa página
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerUsuarioListar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
    
}
