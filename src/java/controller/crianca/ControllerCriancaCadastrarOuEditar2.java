/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.crianca;

import entidades.Crianca;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeClientes/editarORcadastrarCrianca2")
public class ControllerCriancaCadastrarOuEditar2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCrianca2 = 0;

        //pegando os valores do usuario digitados no front
        String idCrianca = request.getParameter("idCrianca");
        if (!"".equals(idCrianca)) { //se for diferente de vazio (ou seja for editar) , faz a conversão para int
            idCrianca2 = Integer.parseInt(idCrianca);
        }
        
        String nomeCrianca = request.getParameter("nomeCrianca");
        String dataNascimento = request.getParameter("dataNascimento");
        String sexoCrianca = request.getParameter("sexoCrianca");
        
        String idCliente = request.getParameter("idCliente");
        int idCliente2 = Integer.parseInt(idCliente);
        
        Crianca crianca = new Crianca(); //instanciando variavel do tipo crianca
        
        //setando valores recebidos pelo usuario
        if(idCrianca2 != 0){
            crianca.setIdCrianca(idCrianca2);            
        }
        crianca.setNomeCrianca(nomeCrianca);
        crianca.setDataNascimento(dataNascimento);
        crianca.setSexo(sexoCrianca);
        crianca.setIdCliente(idCliente2);
        
    }

}
