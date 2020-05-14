/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.telefone;

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
@WebServlet("/paginasDeCadastro/cadastroDeClientes/adicionarNovoTelefoneCliente")
public class ControllerTelefoneNovoCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCliente2 = 0;
        List<Telefone> listaTelefone;
        List<Crianca> listaCrianca;

        String idCliente = request.getParameter("idCliente");
        if (idCliente != null) {

            if (!idCliente.equals("")) {

                idCliente2 = Integer.parseInt(idCliente);

            }
        }

        String contato = request.getParameter("contato");
        String tipoTelefone = request.getParameter("tipoTelefone");

        String telefonePrincipal = request.getParameter("telefonePrincipal");

        //instanciando telefone que vai passar como parametro no método do banco que insere
        Telefone telefoneNovo = new Telefone();

        //setando os valores pego no formulario na instancia do telefone
        telefoneNovo.setNumero(contato);
        if ("Celular".equals(tipoTelefone)) { //se o usuario celular "Celular" na pagina vai criar assim
            telefoneNovo.setIsCelular(1);
            telefoneNovo.setIsFixo(0);
        } else { //se for diferente disso é assim
            telefoneNovo.setIsCelular(0);
            telefoneNovo.setIsFixo(1);
        }

        if (idCliente != null) {

            if (!idCliente.equals("")) {

                telefoneNovo.setIdCliente(idCliente2);   // seta na fk "IdCliente" o cliente pego.              

            }

        }

        if (telefonePrincipal.equals("sim")) { // se o usuário determinou como principal
            telefoneNovo.setIsPrincipal(1);
        } else { // se não
            telefoneNovo.setIsPrincipal(0);
        }

        //instanciando classe de comunicão com o banco de dados
        TelefoneSQL telefoneBanco = new TelefoneSQL();
        ClienteSQL clienteBanco = new ClienteSQL();
        EnderecoSQL enderecoBanco = new EnderecoSQL();
        CriancaSQL criancaBanco = new CriancaSQL();

        try {
            if (telefoneNovo.getIdFuncionario() != null || telefoneNovo.getIdCliente() != null) { // verifica se existe idCliente ou idFuncionario

                telefoneBanco.createNovo(telefoneNovo);//chamando método de inserir da classe TelefoneSQL e passando telefone como parametro

                //instanciando classe do tipo enderecos
                Cliente cliente = new Cliente();
                cliente = clienteBanco.getClienteEspecifico(idCliente2); //recebendo dados da criança 

                //instanciando classe do tipo enderecos
                Enderecos endereco = new Enderecos();
                endereco = enderecoBanco.getEnderecoCliente(idCliente2); //recebendo endereco do cliente

                //recebendo lista de crianças do cliente
                listaCrianca = criancaBanco.getCrianca(idCliente2);
                       
                //recebendo lista de telefone atual do cliente
                listaTelefone =  telefoneBanco.getTelefone(0, idCliente2);

                if(listaCrianca.size() > 0){
                    request.setAttribute("controllerListagemCrianca", 1);
                }
                
                request.setAttribute("cliente", cliente);
                request.setAttribute("endereco", endereco);
                request.setAttribute("listaCriancaCliente", listaCrianca);
                request.setAttribute("listaTelefoneCliente", listaTelefone);
                request.setAttribute("msg", "Contato cadastrado com sucesso!");

            }

            // dispacha para tela
            request.getRequestDispatcher("clienteEditar.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControllerTelefoneNovoCliente.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }

    }

}
