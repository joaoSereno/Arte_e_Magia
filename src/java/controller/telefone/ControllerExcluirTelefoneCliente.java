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
@WebServlet("/paginasDeCadastro/cadastroDeClientes/excluirTelefoneCliente")
public class ControllerExcluirTelefoneCliente extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCliente2 = 0;
        int countTelefone = 0;
        List<Telefone> listaTelefone;
        List<Crianca> listaCrianca;

        String idCliente = request.getParameter("idClienteTelefone");
        if (idCliente != null) {//verifa se tem cliente

            if (!idCliente.equals("")) {

                idCliente2 = Integer.parseInt(idCliente);

            }
        }
        
        String isPrincipal = request.getParameter("isPrincipal");
        int isPrincipal2 = Integer.parseInt(isPrincipal);

        String idTelefone = request.getParameter("idTelefone");
        int idTelefone2 = Integer.parseInt(idTelefone);

        Telefone telefone = new Telefone(); //instanciando classe de telefone

        if (idCliente2 != 0) {
            telefone.setIdCliente(idCliente2);   // seta na fk "IdCliente" o cliente pego.  
            telefone.setIdFuncionario(0);
        }

        telefone.setIsPrincipal(isPrincipal2);
        telefone.setIdTelefone(idTelefone2);

        //instanciando classe de comunicão com o banco de dados
        TelefoneSQL telefoneBanco = new TelefoneSQL();
        ClienteSQL clienteBanco = new ClienteSQL();
        EnderecoSQL enderecoBanco = new EnderecoSQL();
        CriancaSQL criancaBanco = new CriancaSQL();

        try {

            if (idCliente2 != 0) {
                listaTelefone = telefoneBanco.getTelefone(0, idCliente2);//recebe lista
                countTelefone = listaTelefone.size();  //pega quantidade da lista
                
                Cliente cliente = new Cliente();//instanciando classe do tipo cliente
                cliente = clienteBanco.getClienteEspecifico(idCliente2);//chamando método para retoranr dados do cliente, para enviar para a tela de ediçao novamente
                
                Enderecos endereco = new Enderecos();
                endereco = enderecoBanco.getEnderecoCliente(idCliente2);
                
                //set de atributo para outra página
                request.setAttribute("cliente", cliente);
                request.setAttribute("endereco", endereco);

            }

            if (countTelefone > 1) {
                telefoneBanco.excluirTelefone(telefone);//chamando método de delete da classe TelefoneSQL e passando telefone como parametro
                listaTelefone = telefoneBanco.getTelefone(0, idCliente2); //recebendo na lista telefone , os telefones do cliente
                listaCrianca = criancaBanco.getCrianca(idCliente2); //recebendo lista de crianças do cliente

                if(listaCrianca.size() > 0){
                    request.setAttribute("controllerListagemCrianca", 1);
                }               
                
                request.setAttribute("listaCriancaCliente", listaCrianca);
                request.setAttribute("listaTelefoneCliente", listaTelefone);
                request.setAttribute("msg", "Contato excluído com sucesso!");
                request.getRequestDispatcher("clienteEditar.jsp").forward(request, response);
            } else {
                
                listaTelefone = telefoneBanco.getTelefone(0, idCliente2); //recebendo na lista telefone , os telefones do cliente
                listaCrianca = criancaBanco.getCrianca(idCliente2); //recebendo lista de crianças do cliente
                
                if(listaCrianca.size() > 0){
                    request.setAttribute("controllerListagemCrianca", 1);
                }
                
                request.setAttribute("listaCriancaCliente", listaCrianca);                
                request.setAttribute("listaTelefoneCliente", listaTelefone);
                request.setAttribute("msg", "Não foi possível concluir a exclusão. É necessário no mínimo um contato no cadastro!");
                request.getRequestDispatcher("clienteEditar.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControllerExcluirTelefoneCliente.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
}
