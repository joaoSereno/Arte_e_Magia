/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cliente;

import entidades.Cliente;
import entidades.Crianca;
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
import persistence.CriancaSQL;
import persistence.EnderecoSQL;
import persistence.TelefoneSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeClientes/editarCliente2")
public class ClienteControllerEditar2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Crianca> listaCriancaCliente = null; //lista de criança
        List<Telefone> listaTelefoneCliente = null; //lista de telefone
        String msg = "Cliente editado com sucesso!";

        //pega os parametros do form
        //Cliente
        String idCliente = request.getParameter("idCliente");
        int idCliente2 = Integer.parseInt(idCliente);

        String nomeCliente = request.getParameter("nomeCliente");
        String cpf = request.getParameter("cpf");
        String tipoFesta = request.getParameter("tipoFesta");

        Cliente cliente = new Cliente(idCliente2, nomeCliente, cpf, tipoFesta);//instanciando classe do tipo cliente

        //Endereço
        String idEnderecos = request.getParameter("idEnderecos");
        int idEnderecos2 = Integer.parseInt(idEnderecos);

        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");

        Enderecos endereco = new Enderecos(idEnderecos2, cep, cidade, bairro, rua, numero, complemento);//instanciando classe do tipo endereco

        //instanciando classe do banco de dados
        ClienteSQL clienteBanco = new ClienteSQL();
        EnderecoSQL enderecoBanco = new EnderecoSQL();
        TelefoneSQL telefoneBanco = new TelefoneSQL();
        CriancaSQL criancaBanco = new CriancaSQL();

        try {
            //chama método de update do banco
            clienteBanco.editarCadastroCliente(idCliente2, nomeCliente, cpf, tipoFesta);
            enderecoBanco.editarEnderecoCliente(idEnderecos2, cep, cidade, bairro, rua, numero, complemento);

            //chama método que pega os valores , para retornarem em tela dps que o usuario editar o cadastro
            listaTelefoneCliente = telefoneBanco.getTelefone(0, idCliente2); //recebendo na lista de telefone , todos os telefones do cliente
            listaCriancaCliente = criancaBanco.getCrianca(idCliente2); // recebendo na lista todas as crianças do cliente

            //set de atributo para outra página
            request.setAttribute("msg", msg);
            request.setAttribute("cliente", cliente);
            request.setAttribute("listaTelefoneCliente", listaTelefoneCliente);
            request.setAttribute("listaCriancaCliente", listaCriancaCliente);
            request.setAttribute("endereco", endereco);

            //dispara os atributos setados para outra página
            request.getRequestDispatcher("clienteEditar.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ClienteControllerEditar2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
