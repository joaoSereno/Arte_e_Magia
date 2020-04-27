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
import persistence.CriancaSQL;
import persistence.EnderecoSQL;
import persistence.TelefoneSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeClientes/inativarCliente2")
public class ControllerInativarCliente extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCliente2 = 0;
        String msg = "Cadastro excluído com sucesso!";

        String idCliente = request.getParameter("idCliente"); //recebe o idCliente
        if (idCliente != null) {
            
            if (!idCliente.equals("")) {

                idCliente2 = Integer.parseInt(idCliente); //converte para inteiro o idCliente    

            }
            
        }

        ClienteSQL clienteBanco = new ClienteSQL();//instanciando classe do banco de dados para fazer o update no banco
        CriancaSQL criancaBanco = new CriancaSQL(); //instanciando classe do banco de dados para fazer update no banco
        EnderecoSQL enderecoBanco = new EnderecoSQL(); //instanciando classe do banco de dados para fazer delete no banco
        TelefoneSQL telefoneBanco = new TelefoneSQL(); //instanciando classe do banco de dados para fazer delete no banco
        
        try {

            if (idCliente2 != 0) { //se existir idCliente ele vai inativar, se não exisitir somente redireciona até a página

                clienteBanco.inativarCadastro(idCliente2);//chama metodo que faz update para inativar o funcionario e passa o idFuncionario pego no request
                criancaBanco.inativarTodosCadastroCliente(idCliente2); //chamando método que inativa os cadastros da criança desse funcionario
                enderecoBanco.excluirEnderecoCliente(idCliente2); //chama método que realiza delete nos endereços desse cliente
                telefoneBanco.excluirTelCliente(idCliente2); //chama método que realiza delete no telefone do cliente
                
                request.setAttribute("msg", msg);

            }

            request.getRequestDispatcher("clienteEditar.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ControllerInativarCliente.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }

}
