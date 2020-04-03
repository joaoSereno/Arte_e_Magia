/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cliente;

import entidades.Cliente;
import entidades.Crianca;
import entidades.Email;
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
import persistence.EmailSQL;
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
        int idCliente2 = 0;
        int idEnderecos2 = 0;
        int idEmail2 = 0;
        String msg = "Cliente editado com sucesso!";

        //pega os parametros do form
        //Cliente
        String idCliente = request.getParameter("idCliente");

        if (idCliente != null) { //verifica se existe idCliente

            if (!idCliente.equals("")) {

                idCliente2 = Integer.parseInt(idCliente);

            }

        }

        String nomeCliente = request.getParameter("nomeCliente");
        String cpf = request.getParameter("cpf");
        String tipoFesta = request.getParameter("tipoFesta");

        if (idCliente2 != 0) { //verifica se existe idCliente

            Cliente cliente = new Cliente(idCliente2, nomeCliente, cpf, tipoFesta);//instanciando classe do tipo cliente            
            request.setAttribute("cliente", cliente); // coloca instancia como atributo da proxima página
        }
        
        //Email
        String idEmail = request.getParameter("idEmail");

        if (idEmail != null) { //verifica se existe idEmail

            if (!idEmail.equals("")) {

                idEmail2 = Integer.parseInt(idEmail);

            }

        }
        String emailInserido = request.getParameter("email"); 
        
        if(idEmail2 != 0){
            Email email = new Email(idEmail2, emailInserido);
            request.setAttribute("email", email);
        }

        
        //Endereço
        String idEnderecos = request.getParameter("idEnderecos");

        if (idEnderecos != null) { //verifica se existe idEnderecos

            if (!idEnderecos.equals("")) {

                idEnderecos2 = Integer.parseInt(idEnderecos);

            }

        }

        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");

        if (idEnderecos2 != 0) {

            Enderecos endereco = new Enderecos(idEnderecos2, cep, cidade, bairro, rua, numero, complemento);//instanciando classe do tipo endereco
            request.setAttribute("endereco", endereco); //coloca instancia endereco como atributo da proxima pagina
        }

        //instanciando classe do banco de dados
        ClienteSQL clienteBanco = new ClienteSQL();
        EnderecoSQL enderecoBanco = new EnderecoSQL();
        TelefoneSQL telefoneBanco = new TelefoneSQL();
        CriancaSQL criancaBanco = new CriancaSQL();
        EmailSQL emailBanco = new EmailSQL();

        try {
              
            if (idCliente2 != 0) { //verifica se existe cliente
                //chama método de update do banco
                clienteBanco.editarCadastroCliente(idCliente2, nomeCliente, cpf, tipoFesta);

                //chama método que pega os valores , para retornarem em tela dps que o usuario editar o cadastro
                listaTelefoneCliente = telefoneBanco.getTelefone(0, idCliente2); //recebendo na lista de telefone , todos os telefones do cliente
                listaCriancaCliente = criancaBanco.getCrianca(idCliente2); // recebendo na lista todas as crianças do cliente

            }

            if (idEnderecos2 != 0) {//verifica se existe endereco

                enderecoBanco.editarEnderecoCliente(idEnderecos2, cep, cidade, bairro, rua, numero, complemento);

            }
            
            if(idEmail2 != 0){
                emailBanco.editarEmailCliente(idEmail2, emailInserido);
            }

            if (idCliente2 != 0 || idEnderecos2 != 0) {

                //set de atributo para outra página
                request.setAttribute("msg", msg);
                request.setAttribute("listaTelefoneCliente", listaTelefoneCliente);
                request.setAttribute("listaCriancaCliente", listaCriancaCliente);

            }

            //dispara os atributos setados para outra página
            request.getRequestDispatcher("clienteEditar.jsp").forward(request, response);
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteControllerEditar2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
