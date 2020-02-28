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
import persistence.EnderecoSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeClientes/editarCliente2")
public class ClienteControllerEditar2 extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String msg = "Cliente editado com sucesso!";

        //pega os parametros do form
        //Cliente
        String idCliente = request.getParameter("idCliente");
        int idCliente2 = Integer.parseInt(idCliente);

        String nomeCliente = request.getParameter("nomeCliente");
        String cpf = request.getParameter("cpf");
        String tipoFesta = request.getParameter("tipoFesta");

        //Endereço
        String idEnderecos = request.getParameter("idEnderecos");
        int idEnderecos2 = Integer.parseInt(idEnderecos);

        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");        
        String rua = request.getParameter("rua");        
        String numero = request.getParameter("numero");        
        String complemento = request.getParameter("complemento");        
        
        
        //instanciando classe do banco de dados
        ClienteSQL clienteBanco = new ClienteSQL(); 
        EnderecoSQL enderecoBanco = new EnderecoSQL(); 

        try {
            //chama método de update do banco
            clienteBanco.editarCadastroCliente(idCliente2, nomeCliente, cpf, tipoFesta);
            enderecoBanco.editarEnderecoCliente(idEnderecos2, cep, cidade, bairro, rua, numero, complemento);
            
            //set de atributo para outra página
            request.setAttribute("msg", msg);

            //dispara os atributos setados para outra página
            request.getRequestDispatcher("clienteEditar.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ClienteControllerEditar2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }   
    
}
