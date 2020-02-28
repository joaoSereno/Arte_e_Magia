/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cliente;

import entidades.Cliente;
import entidades.Enderecos;
import entidades.Telefone;
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
import persistence.EnderecoSQL;
import persistence.TelefoneSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeClientes/editarCadastroCliente")
public class ControllerClienteEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //pega os parametros do form
        String idCliente = request.getParameter("idCliente");
        int idCliente2 = Integer.parseInt(idCliente);

        ClienteSQL clienteBanco = new ClienteSQL(); //instanciando classe que faz comunicação com o banco de dados
        Cliente cliente = new Cliente();

        List<Telefone> listaTelefoneCliente = null; //lista de telefone
        TelefoneSQL telefoneBanco = new TelefoneSQL(); //instancia classe de banco do telefone

        EnderecoSQL enderecoBanco = new EnderecoSQL();//instancia classe de banco do endereco
        Enderecos endereco = new Enderecos();

        try {

            cliente = clienteBanco.getClienteEspecifico(idCliente2); //recebendo na instancia cliente , o cliente que será editado
            listaTelefoneCliente = telefoneBanco.getTelefone(0, idCliente2); //recebendo na lista de telefone , todos os telefones do cliente
            endereco = enderecoBanco.getEnderecoCliente(idCliente2); // recebendo endereco do cliente na variavel endereco

            //set de atributo para outra página
            request.setAttribute("cliente", cliente);
            request.setAttribute("listaTelefoneCliente", listaTelefoneCliente);
            request.setAttribute("endereco", endereco);

            //dispara os atributos setados para outra página
            request.getRequestDispatcher("clienteEditar.jsp").forward(request, response);
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerClienteEditar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
