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
@WebServlet("/paginasDeCadastro/cadastroDeFuncionario/adicionarNovoTelefoneFunc")
public class ControllerTelefoneNovoFuncionario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idFuncionario2 = 0;
        List<Telefone> listaTelefoneFuncionario = null; //lista de telefone

        //pega os parametros do form
        String idFuncionario = request.getParameter("idFuncionario");
        if (idFuncionario != null) { //verifica se existe funcionario

            if (!idFuncionario.equals("")) {

                idFuncionario2 = Integer.parseInt(idFuncionario);

            }

        }

        String contato = request.getParameter("contato");
        String tipoTelefone = request.getParameter("tipoTelefone");

        String telefonePrincipal = request.getParameter("telefonePrincipal");

        //instanciando telefone que vai passar como parametro no método do banco que insere
        Telefone telefoneNovo = new Telefone();

        //setando os valores pego no formulario na instancia do telefone
        telefoneNovo.setNumero(contato);
        if ("Celular".equals(tipoTelefone)) { //se o usuario celular "Celular" na pagina vai criar assim
            telefoneNovo.setIsCelular(1);
            telefoneNovo.setIsFixo(0);
        } else { //se for diferente disso é assim
            telefoneNovo.setIsCelular(0);
            telefoneNovo.setIsFixo(1);
        }

        if (idFuncionario2 != 0) { //se vier idFuncionario 
            telefoneNovo.setIdFuncionario(idFuncionario2); // seta na fk "IdFuncionario" o funcionario pego. 
        }
        
        if(telefonePrincipal != null){

            if (telefonePrincipal.equals("sim")) { // se o usuário determinou como principal
                telefoneNovo.setIsPrincipal(1);
            } else { // se não
                telefoneNovo.setIsPrincipal(0);
            }

        }

        TelefoneSQL telefoneBanco = new TelefoneSQL();//instanciando classe do banco de dados para fazer a inserção no banco
        FuncionarioSQL funcionarioBanco = new FuncionarioSQL();//instanciando classe que faz comunicação com o banco de dados

        try {

            if (idFuncionario2 != 0) {

                telefoneBanco.createNovo(telefoneNovo);//chamando método de inserir da classe TelefoneSQL e passando telefone como parametro
                listaTelefoneFuncionario = telefoneBanco.getTelefone(idFuncionario2, 0);//recebendo a lista de telefone atualizado do funcionario para dispachar
                
                Funcionario funcionario = new Funcionario();//instanciando classe do tipo Funcionario
                funcionario = funcionarioBanco.getFuncionarioEspecifico(idFuncionario2); //chamando método para retoranr dados do funcionario, para enviar para a tela de ediçao novamente

                //set de atributo para outra página
                request.setAttribute("idFuncionario", idFuncionario2);
                request.setAttribute("nomeFuncionario", funcionario.getNomeFuncionario());
                request.setAttribute("sexo", funcionario.getSexo());
                request.setAttribute("listaTelefoneFuncionario", listaTelefoneFuncionario);
                request.setAttribute("msg", "Telefone cadastrado com sucesso!!");

            }

            request.getRequestDispatcher("funcionarioEditar.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ControllerTelefoneNovoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }

    }
}
