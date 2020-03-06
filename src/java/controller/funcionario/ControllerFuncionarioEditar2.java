/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.funcionario;

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
@WebServlet("/paginasDeCadastro/cadastroDeFuncionario/editarCadastroFuncionario2")
public class ControllerFuncionarioEditar2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Telefone> listaTelefoneFuncionario = null; //lista de telefone
        String msg = "Funcionário editado com sucesso!";

        //pega os parametros do form
        String idFuncionario = request.getParameter("idFuncionario");
        int idFuncionario2 = Integer.parseInt(idFuncionario);

        String nomeFuncionario = request.getParameter("nomeFuncionario");
        String sexo = request.getParameter("sexo");
        
        FuncionarioSQL funcionarioBanco = new FuncionarioSQL(); //instanciando classe do banco de dados
        TelefoneSQL telefoneBanco = new TelefoneSQL(); //instanciando classe de comunicao com o banco de dados 
        
        try {
            //chama método de update do banco
            funcionarioBanco.editarCadastroFuncionario(idFuncionario2, nomeFuncionario, sexo);
            //chama métod que recebe a lista do funcionario, para atualizar a página no cadastro
            listaTelefoneFuncionario = telefoneBanco.getTelefone(idFuncionario2, 0);
            
            //set de atributo para outra página
            request.setAttribute("idFuncionario", idFuncionario2);
            request.setAttribute("nomeFuncionario", nomeFuncionario);
            request.setAttribute("sexo", sexo);
            request.setAttribute("listaTelefoneFuncionario", listaTelefoneFuncionario);
            request.setAttribute("msg", msg);

            //dispara os atributos setados para outra página
            request.getRequestDispatcher("funcionarioEditar.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControllerFuncionarioEditar2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
