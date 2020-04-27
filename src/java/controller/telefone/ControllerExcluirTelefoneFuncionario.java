/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.telefone;

import entidades.Funcionario;
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
import persistence.FuncionarioSQL;
import persistence.TelefoneSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeFuncionario/excluirTelefoneFunc")
public class ControllerExcluirTelefoneFuncionario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idFuncionario2 = 0;

        int countTelefone = 0;
        List<Telefone> listaTelefone;

        //pega os parametros do form
        String idFuncionario = request.getParameter("idFuncionarioTelefone");
        if (idFuncionario != null) {

            if (!idFuncionario.equals("")) {

                idFuncionario2 = Integer.parseInt(idFuncionario);

            }

        }

        String isPrincipal = request.getParameter("isPrincipal");
        int isPrincipal2 = Integer.parseInt(isPrincipal);

        String idTelefone = request.getParameter("idTelefone");
        int idTelefone2 = Integer.parseInt(idTelefone);

        Telefone telefone = new Telefone(); //instanciando classe de telefone

        //setando os valores no telefone
        if (idFuncionario2 != 0) { //se vier idFuncionario 
            telefone.setIdFuncionario(idFuncionario2); // seta na fk "IdFuncionario" o funcionario pego. 
        }

        telefone.setIsPrincipal(isPrincipal2);
        telefone.setIdTelefone(idTelefone2);

        //instanciando classe de comunicão com o banco de dados
        TelefoneSQL telefoneBanco = new TelefoneSQL();
        FuncionarioSQL funcionarioBanco = new FuncionarioSQL();

        try {

            if (idFuncionario2 != 0) {

                listaTelefone = telefoneBanco.getTelefone(idFuncionario2, 0); //recebe lista
                countTelefone = listaTelefone.size();//pega quantidade da lista

                Funcionario funcionario = new Funcionario();//instanciando classe do tipo Funcionario
                funcionario = funcionarioBanco.getFuncionarioEspecifico(idFuncionario2); //chamando método para retoranr dados do funcionario, para enviar para a tela de ediçao novamente
                
                //set de atributo para outra página
                request.setAttribute("idFuncionario", idFuncionario2);
                request.setAttribute("nomeFuncionario", funcionario.getNomeFuncionario());
                request.setAttribute("sexo", funcionario.getSexo());
                
            }

            if (countTelefone > 1) {

                telefoneBanco.excluirTelefone(telefone);//chamando método de delete da classe TelefoneSQL e passando telefone como parametro
                listaTelefone = telefoneBanco.getTelefone(idFuncionario2, 0); //recebe lista
                
                request.setAttribute("listaTelefoneFuncionario", listaTelefone);
                request.setAttribute("msg", "Telefone excluido com sucesso!!");
                request.getRequestDispatcher("funcionarioEditar.jsp").forward(request, response);

            } else {
                
                listaTelefone = telefoneBanco.getTelefone(idFuncionario2, 0); //recebe lista
                               
                request.setAttribute("listaTelefoneFuncionario", listaTelefone);                
                request.setAttribute("msg", "Não é possível ficar sem nenhum telefone no cadastro, por favor realize um novo cadastro de telefone e tente excluir este novamente!!");
                request.getRequestDispatcher("funcionarioEditar.jsp").forward(request, response);

            }

        } catch (Exception ex) {

            Logger.getLogger(ControllerExcluirTelefoneFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();

        }
    }
}
