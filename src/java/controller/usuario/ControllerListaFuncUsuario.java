/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.usuario;

import entidades.Funcionario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.FuncionarioSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeUsuario/usuarioFuncListar")
public class ControllerListaFuncUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int valorDisplay = 1;
        
        FuncionarioSQL funcionarioBanco = new FuncionarioSQL(); //instancia a classe de comunicação com o banco de dados de funcionario

        List<Funcionario> listaFuncionario; //lista que vai receber os dados do funcionario

        try {
            
            listaFuncionario = funcionarioBanco.getFuncionarioNaoTemUsuario(); // recebe na lista os funcionarios pelo método de get do banco
            
            request.setAttribute("valorDisplay", valorDisplay);
            request.setAttribute("funcionarios", listaFuncionario); // atribui a lista na marcação "funcionario"
            
            request.getRequestDispatcher("usuarioCadastrar.jsp").forward(request, response); // dispara para essa página
            
        } catch (Exception ex) {
            
            Logger.getLogger(ControllerListaFuncUsuario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
            
        }
        
    }
     
}
