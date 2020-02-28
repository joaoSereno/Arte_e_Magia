/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.funcionario;

import java.io.IOException;
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

@WebServlet("/paginasDeCadastro/cadastroDeFuncionario/inativarFuncionario")
public class ControllerInativarFuncionario extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String msg = "Cadastro excluído com sucesso!";
        
        String idFuncionario = request.getParameter("idFuncionario"); //recebe o idFuncionario
        int idFuncionario2 = Integer.parseInt(idFuncionario); //converte para inteiro o idFuncionario
        
        
        FuncionarioSQL funcionarioBanco = new FuncionarioSQL();//instanciando classe do banco de dados para fazer o update no banco
        
        try {
            funcionarioBanco.inativarCadastro(idFuncionario2);//chama metodo que faz update para inativar o funcionario e passa o idFuncionario pego no request
            
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("funcionarioEditar.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControllerFuncionarioListar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }    
}
