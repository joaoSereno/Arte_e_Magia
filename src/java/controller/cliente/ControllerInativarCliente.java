/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cliente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ClienteSQL;
import persistence.CriancaSQL;

/**
 *
 * @author João Pedro
 */

@WebServlet("/paginasDeCadastro/cadastroDeClientes/inativarCliente2")
public class ControllerInativarCliente extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String msg = "Cadastro excluído com sucesso!";
        
        String idCliente = request.getParameter("idCliente"); //recebe o idCliente
        int idCliente2 = Integer.parseInt(idCliente); //converte para inteiro o idCliente
        
        
        ClienteSQL clienteBanco = new ClienteSQL();//instanciando classe do banco de dados para fazer o update no banco
        CriancaSQL criancaBanco = new CriancaSQL(); //instanciando classe do banco de dados para fazer update no banco
        
        try {
            clienteBanco.inativarCadastro(idCliente2);//chama metodo que faz update para inativar o funcionario e passa o idFuncionario pego no request
            criancaBanco.inativarTodosCadastroCliente(idCliente2); //chamando método que inativa os cadastros da criança desse funcionario
            
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("clienteEditar.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControllerInativarCliente.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }   
    
}
