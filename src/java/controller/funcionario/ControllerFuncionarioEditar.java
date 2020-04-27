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
import persistence.TelefoneSQL;

/**
 *
 * @author João Pedro
 */

@WebServlet("/paginasDeCadastro/cadastroDeFuncionario/editarCadastroFuncionario")
public class ControllerFuncionarioEditar extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
        //pega os parametros do form
        String idFuncionario = request.getParameter("idFuncionario");
        int idFuncionario2 = Integer.parseInt(idFuncionario);
        
        String nomeFuncionario = request.getParameter("nomeFuncionario");
        String  sexo = request.getParameter("sexo");
        
        List<Telefone> listaTelefoneFuncionario = null; //lista de telefone
        TelefoneSQL telefoneBanco = new TelefoneSQL(); //instancia classe de banco do telefone
        
        //pega os telefone do funcionario
        try {
            listaTelefoneFuncionario = telefoneBanco.getTelefone(idFuncionario2, 0); //set em uma lista a consulta realizada no banco
        } catch (Exception ex) {
            Logger.getLogger(ControllerFuncionarioEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //set de atributo para outra página
        request.setAttribute("idFuncionario", idFuncionario2);
        request.setAttribute("nomeFuncionario", nomeFuncionario);
        request.setAttribute("sexo", sexo);
        request.setAttribute("listaTelefoneFuncionario", listaTelefoneFuncionario);
        
        //dispara os atributos setados para outra página
        request.getRequestDispatcher("funcionarioEditar.jsp").forward(request, response);
    }
        
}
