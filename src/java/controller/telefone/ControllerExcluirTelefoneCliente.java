/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.telefone;

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

        String idCliente = request.getParameter("idClienteTelefone");
        if (idCliente != null) {
            idCliente2 = Integer.parseInt(idCliente);
        }

        String isPrincipal = request.getParameter("isPrincipal");
        int isPrincipal2 = Integer.parseInt(isPrincipal);

        String idTelefone = request.getParameter("idTelefone");
        int idTelefone2 = Integer.parseInt(idTelefone);

        Telefone telefone = new Telefone(); //instanciando classe de telefone

        if (idCliente != null) {
            telefone.setIdCliente(idCliente2);   // seta na fk "IdCliente" o cliente pego.  
            telefone.setIdFuncionario(0);
        }

        telefone.setIsPrincipal(isPrincipal2);
        telefone.setIdTelefone(idTelefone2);

        //instanciando classe de comunicão com o banco de dados
        TelefoneSQL telefoneBanco = new TelefoneSQL();

        try {

            if (idCliente != null) {
                listaTelefone = telefoneBanco.getTelefone(0, idCliente2);//recebe lista
                countTelefone = listaTelefone.size();  //pega quantidade da lista
            }

            if (countTelefone > 1) {
                telefoneBanco.excluirTelefone(telefone);//chamando método de delete da classe TelefoneSQL e passando telefone como parametro
                request.setAttribute("msg", "Telefone excluido com sucesso!!");
                request.getRequestDispatcher("clienteEditar.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Não é possível ficar sem nenhum telefone no cadastro, por favor realize um novo cadastro de telefone e tente excluir este novamente!!");
                request.getRequestDispatcher("clienteEditar.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControllerExcluirTelefoneCliente.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
}
