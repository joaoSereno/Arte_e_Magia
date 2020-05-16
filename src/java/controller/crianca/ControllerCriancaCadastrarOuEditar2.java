/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.crianca;

import entidades.Crianca;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.CriancaSQL;
import util.Conversor;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeClientes/editarORcadastrarCrianca2")
public class ControllerCriancaCadastrarOuEditar2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCrianca2 = 0;
        Conversor conversorData = new Conversor();

        //pegando os valores do usuario digitados no front
        String idCrianca = request.getParameter("idCrianca");
        if (!"".equals(idCrianca)) { //se for diferente de vazio (ou seja for editar) , faz a conversão para int
            idCrianca2 = Integer.parseInt(idCrianca);
        }

        String nomeCrianca = request.getParameter("nomeCrianca");
        String dataNascimento = request.getParameter("dataNascimento");
        //converte para o formato correto a data
        String dataNascimento2 = conversorData.formatarData(dataNascimento);
        
        String sexoCrianca = request.getParameter("sexoCrianca");

        String idCliente = request.getParameter("idCliente");
        int idCliente2 = Integer.parseInt(idCliente);

        Crianca crianca = new Crianca(); //instanciando variavel do tipo crianca

        //setando valores recebidos pelo usuario
        if (idCrianca2 != 0) {
            crianca.setIdCrianca(idCrianca2);
        }
        crianca.setNomeCrianca(nomeCrianca);
        crianca.setDataNascimento(dataNascimento2);
        crianca.setSexo(sexoCrianca);
        crianca.setIdCliente(idCliente2);

        //instanciando classe que vai fazer a comunicação com o banco de dados
        CriancaSQL criancaBanco = new CriancaSQL();

        try {
            //se for o idCrianca2 = 0 significa que é para cadastrar 
            if (idCrianca2 == 0) {

                criancaBanco.create(crianca);//chamando método de inserir da classe CriancaSQL e passando classe instanciada da crianca como parametro  
                
                //setando atributos que será jogados para outra página
                request.setAttribute("idClienteE", idCliente2);
                request.setAttribute("msg", "Cadastro realizado com sucesso!");
                
                //dispachando para a página
                request.getRequestDispatcher("criancaEditarOuCadastrar.jsp").forward(request, response);

            } else {//se não significa que é para editar

                criancaBanco.editarCadastroCrianca(crianca);//chamando método de update da classe CriancaSQL e passando classe instanciada da crianca como parametro  
                
                //setando atributos que será jogados para outra página
                request.setAttribute("idClienteE", idCliente2);
                request.setAttribute("idCriancaE", idCrianca2);
                request.setAttribute("nomeCriancaE", nomeCrianca);
                request.setAttribute("dataNascimentoE", dataNascimento);
                request.setAttribute("sexo", sexoCrianca);
                request.setAttribute("msg", "Cadastro editado com sucesso!");
                
                //dispachando para a página
                request.getRequestDispatcher("criancaEditarOuCadastrar.jsp").forward(request, response);

            }
        } catch (Exception ex) {
            Logger.getLogger(ControllerCriancaCadastrarOuEditar2.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }

}
