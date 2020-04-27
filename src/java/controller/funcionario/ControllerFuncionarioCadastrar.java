/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.funcionario;

import entidades.Funcionario;
import entidades.Telefone;
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
@WebServlet("/paginasDeCadastro/cadastroDeFuncionario/cadastrarFuncionario")
public class ControllerFuncionarioCadastrar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //pega os valores inseridos no formulario
        String nomeFuncionario = request.getParameter("nomeFuncionario");
        String sexoFuncionario = request.getParameter("sexoFuncionario");
        String contatoFuncionario = request.getParameter("contato");
        String tipoTelefone = request.getParameter("tipoTelefone");

        Funcionario funcionario = new Funcionario();//instanciando funcionario que vai passar como parametro no método do banco que insere

        //setando os valores pegos no formulario no funcionariio
        funcionario.setNomeFuncionario(nomeFuncionario);
        funcionario.setSexo(sexoFuncionario);
        funcionario.setAtivo(1); //setando 1 sempre que cadastrar pela primeira vez

        FuncionarioSQL funcionarioBanco = new FuncionarioSQL(); //instanciando classe do banco de dados para fazer a inserção no banco

        int idFuncionario = 0; //idFuncionario para registrar o telefone

        try {
            funcionarioBanco.create(funcionario); //chamando método de inserir da classe FuncionarioSQL e passando funcionario como parametro
            idFuncionario = funcionarioBanco.getUltimoIdFuncionario(); //chama metodo do banco que retorna o ultimo idFuncionario registrado para inserir na tabela do telefone
        } catch (Exception ex) {
            Logger.getLogger(ControllerFuncionarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }

        Telefone telefone = new Telefone(); //instanciando telefone que vai passar como parametro no método do banco que insere

        //setando os valores pego no formulario
        telefone.setNumero(contatoFuncionario);
        if ("Celular".equals(tipoTelefone)) { //se o usuario celular "Celular" na pagina vai criar assim
            telefone.setIsCelular(1);
            telefone.setIsFixo(0);
        } else { //se for diferente disso é assim
            telefone.setIsCelular(0);
            telefone.setIsFixo(1);
        }
        telefone.setIdFuncionario(idFuncionario); // seta na fk "IdFuncionario" o funcionario pego na linha 49 dessa página.
        telefone.setIsPrincipal(1);

        TelefoneSQL telefoneBanco = new TelefoneSQL();//instanciando classe do banco de dados para fazer a inserção no banco

        try {
            telefoneBanco.create(telefone); //chamando método de inserir da classe TelefoneSQL e passando telefone como parametro
            request.setAttribute("msg", "Cadastro realizado com sucesso!!");
            request.getRequestDispatcher("funcionarioCadastrar.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControllerFuncionarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }

    }
}
