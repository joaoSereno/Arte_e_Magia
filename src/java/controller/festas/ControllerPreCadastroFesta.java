/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.festas;

import entidades.Cliente;
import entidades.Crianca;
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
import persistence.CriancaSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeFesta/preCadastroFesta")
public class ControllerPreCadastroFesta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //instanciando as classes necessarias para a listagem de cliente
        ClienteSQL clienteBanco = new ClienteSQL();
        List<Cliente> listaClientes;
        
        try {
            listaClientes = clienteBanco.getClientes();
                       
            //setando os atributos que será enviandopara o front
            request.setAttribute("listaClientes", listaClientes);
            
            //dispachando para a página
            request.getRequestDispatcher("festaCadastrarF.jsp").forward(request, response); // dispara para essa página

        } catch (Exception ex) {
            Logger.getLogger(ControllerListaOpcoesFesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
