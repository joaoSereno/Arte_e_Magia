/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.usuario;

import entidades.Usuario;
import java.io.IOException;
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
@WebServlet("/paginasDeCadastro/cadastroDeUsuario/usuarioEditar2")
public class ControllerUsuarioEditar2 extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idFuncionario2 = 0;
        int idUsuario2 = 0;
        int valorDisplay2 = 0;
                
        //pegando os valores da recebidos pelo usuario na tela
        String idUsuario = request.getParameter("idusuario");
        if(idUsuario != null){ //se for cadastro do tipo FUNC
            if(!idUsuario.equals("")){
                idUsuario2 = Integer.parseInt(idUsuario);
            }
        }          
        
        String login = request.getParameter("login");
        String nomeUsuario = request.getParameter("nomeUsuario");
        
        String valorDisplay = request.getParameter("valorDisplay");
        if(valorDisplay != null){ //se for cadastro do tipo FUNC
            if(!valorDisplay.equals("")){
                valorDisplay2 = Integer.parseInt(valorDisplay);
            }
        }  
        
        String idFuncionario = request.getParameter("idFuncionario");
        if(idFuncionario != null){ //se for cadastro do tipo FUNC
            if(!idFuncionario.equals("")){
                idFuncionario2 = Integer.parseInt(idFuncionario);
            }
        }
        
        if(idUsuario2 != 0){ //se tiver usuario
            
            UsuarioSQL usuarioBanco = new UsuarioSQL(); //instanciando classe de comunicação com o banco  de dados
            
            if(idFuncionario2 != 0){ //se for cadastro tipo FUNC
                Usuario usuario = new Usuario(idUsuario2, login, idFuncionario2, nomeUsuario); //instanciando classe usuario                 
                
                
            }else{ //se for tipo ADM
                Usuario usuario = new Usuario(idUsuario2, login, nomeUsuario); //instanciando classe usuario 
                
            }

            
            //setando os dados pegos no form no usuario
            
            
        }else{ //se não tiver usuário
            
            //setando atributos que será jogados para outra página
            request.setAttribute("valorDisplay2", valorDisplay2);
            
            //dispachando para a página
            request.getRequestDispatcher("usuarioEditar.jsp").forward(request, response);            
        }
        
    }
    
}
