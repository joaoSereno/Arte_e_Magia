/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cliente;

import entidades.Cliente;
import entidades.Email;
import entidades.Enderecos;
import entidades.Telefone;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ClienteSQL;
import persistence.EmailSQL;
import persistence.EnderecoSQL;
import persistence.TelefoneSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeClientes/cadastrarCliente")
public class ControllerClienteCadastrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCliente = 0; //idCliente para registrar o telefone e endereço
        
    //pega os valores inseridos no formulario
        //dados do cliente
        String nomeCliente = request.getParameter("nomeCliente");
        String cpf = request.getParameter("cpf");
        String tipoFesta = request.getParameter("tipoFesta");
        //dados do telefone do cliente
        String contatoCliente = request.getParameter("contato");
        String tipoTelefone = request.getParameter("tipoTelefone");
        //dados do email
        String emailInserido = request.getParameter("email");
        //dados endereço
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");        
        String rua = request.getParameter("rua");        
        String numero = request.getParameter("numero");        
        String complemento = request.getParameter("complemento");
        
        //instanciando variavel do tipo cliente
        Cliente cliente = new Cliente(); 
        //setando valores "dados do cliente" na variavel cliente
        cliente.setNomeCliente(nomeCliente);
        cliente.setCpf(cpf);
        cliente.setTipoFesta(tipoFesta);
        
        //instanciando classe que faz a comunicação com o banco de dados do cliente
        ClienteSQL clienteBanco = new ClienteSQL();
        
        
        try {
            clienteBanco.create(cliente); //chamando método de inserir da classe ClienteSQL e passando cliente como parametro
            idCliente = clienteBanco.getUltimoIdCliente(); //chama metodo do banco que retorna o ultimo idCliente registrado para inserir na tabela do telefone e endereço
        } catch (Exception ex) {
            Logger.getLogger(ControllerClienteCadastrar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
        
        //instanciando variavel do tipo telefone e email
        Telefone telefone = new Telefone(); 
        Email email = new Email();
        
        //setando os valores pego no email
        email.setEmail(emailInserido);
        email.setIdCliente(idCliente);
        
        //setando os valores pego "telefone do cliente"
        telefone.setNumero(contatoCliente);
        if ("Celular".equals(tipoTelefone)) { //se o usuario celular "Celular" na pagina vai criar assim
            telefone.setIsCelular(1);
            telefone.setIsFixo(0);
        } else { //se for diferente disso é assim
            telefone.setIsCelular(0);
            telefone.setIsFixo(1);
        }
        telefone.setIdCliente(idCliente); // seta na fk "idCliente" o cliente pego na linha 58 dessa página.
        telefone.setIsPrincipal(1);

        //instanciando classe do banco de dados para fazer a inserção no banco
        TelefoneSQL telefoneBanco = new TelefoneSQL();
        EmailSQL emailBanco = new EmailSQL();

        try {
            telefoneBanco.create(telefone); //chamando método de inserir da classe TelefoneSQL e passando telefone como parametro
            emailBanco.createEmail(email); //chamando método de inserir da classe EmailSQL e passando email como parametro
        } catch (Exception ex) {
            Logger.getLogger(ControllerClienteCadastrar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } 
        
        //instanciando variavel do tipo endereco
        Enderecos endereco = new Enderecos();        
        //setando valores "dados endereço" na variavel endereco
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setBairro(bairro);
        endereco.setRua(rua);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setIdCliente(idCliente); // seta na fk "idCliente" o cliente pego na linha 58 dessa página.
        endereco.setIsFesta(0); // como não é endereço de festa é 0 (false)

        //instanciando classe do banco de dados para fazer a inserção no banco
        EnderecoSQL enderecoBanco = new EnderecoSQL();        

        try {
            enderecoBanco.create(endereco);//chamando método de inserir da classe EnderecoSQL e passando endereco como parametro
            request.setAttribute("msg", "Cadastro realizado com sucesso!!");
            request.getRequestDispatcher("clienteCadastrar.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControllerClienteCadastrar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }         
    }
    
}
