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
import persistence.TelefoneSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeFuncionario/inativarFuncionario")
public class ControllerInativarFuncionario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idFuncionario2 = 0;
        String msg = "Cadastro excluído com sucesso!";

        String idFuncionario = request.getParameter("idFuncionario"); //recebe o idFuncionario
        if (idFuncionario != null) { //se existir funcionario

            if (!idFuncionario.equals("")) {

                idFuncionario2 = Integer.parseInt(idFuncionario); //converte para inteiro o idFuncionario

            }

        }

        FuncionarioSQL funcionarioBanco = new FuncionarioSQL();//instanciando classe do banco de dados para fazer o update no banco
        TelefoneSQL telefoneBanco = new TelefoneSQL(); //instanciando classe de comunicação com o banco para fazer delete
        
        try {

            if (idFuncionario2 != 0) {//se existir funcionario

                funcionarioBanco.inativarCadastro(idFuncionario2);//chama metodo que faz update para inativar o funcionario e passa o idFuncionario pego no request
                telefoneBanco.excluirTelFuncionario(idFuncionario2);//chama método que delete os telefonedo funcionario
                
                request.setAttribute("msg", msg);

            }

            request.getRequestDispatcher("funcionarioEditar.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ControllerFuncionarioListar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
}
