/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cliente;

import entidades.Cliente;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ClienteSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeClientes/listaCliente")
public class ControllerClienteListar extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteSQL clienteBanco = new ClienteSQL(); //instancia a classe de comunicação com o banco de dados
              
        List<Cliente> listaClientes; //lista que vai receber os dados do cliente

        try {
    
            listaClientes = clienteBanco.getClientes(); // recebe na lista os clientes pelo método de get do banco 
            request.setAttribute("clientes", listaClientes); // atribui a lista na marcação "clientes"
            request.getRequestDispatcher("clientePrincipal.jsp").forward(request, response); // dispara para essa página
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerClienteListar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }  
    
}
