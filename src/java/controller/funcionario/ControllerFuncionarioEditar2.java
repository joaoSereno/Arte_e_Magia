/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.funcionario;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.FuncionarioSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeFuncionario/editarCadastroFuncionario2")
public class ControllerFuncionarioEditar2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String msg = "Funcionário editado com sucesso!";

        //pega os parametros do form
        String idFuncionario = request.getParameter("idFuncionario");
        int idFuncionario2 = Integer.parseInt(idFuncionario);

        String nomeFuncionario = request.getParameter("nomeFuncionario");
        String sexo = request.getParameter("sexoFuncionario");

        FuncionarioSQL funcionarioBanco = new FuncionarioSQL(); //instanciando classe do banco de dados

        try {
            //chama método de update do banco
            funcionarioBanco.editarCadastroFuncionario(idFuncionario2, nomeFuncionario, sexo);

            //set de atributo para outra página
            request.setAttribute("idFuncionario", idFuncionario2);
            request.setAttribute("nomeFuncionario", nomeFuncionario);
            request.setAttribute("sexo", sexo);
            request.setAttribute("msg", msg);

            //dispara os atributos setados para outra página
            request.getRequestDispatcher("funcionarioEditar.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControllerFuncionarioEditar2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
