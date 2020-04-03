/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.festas;

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
@WebServlet("/paginasDeCadastro/cadastroDeFesta/listarOpcoes")
public class ControllerListaOpcoesFesta extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int countCliente2 = 0;
        List<Cliente> listaClientes;

        String countCliente = request.getParameter("countCliente");
        if (countCliente != null) {

            if (!countCliente.equals("")) {

                countCliente2 = Integer.parseInt(countCliente);

                request.setAttribute("countCliente", countCliente2);

            }

        }
        
        if(countCliente2 == 0){ //se é a primeira vez que vai selecionar cliente
            
            ClienteSQL clienteBanco = new ClienteSQL();
            
            try {
                listaClientes = clienteBanco.getClientes();
                
                request.setAttribute("listaClientes", listaClientes);
                request.setAttribute("countCliente", countCliente2);
                
                request.getRequestDispatcher("paginaSelecionarClienteFesta.jsp").forward(request, response); // dispara para essa página
                
            } catch (Exception ex) {
                Logger.getLogger(ControllerListaOpcoesFesta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{ //se não é
            
        }
    }

}
