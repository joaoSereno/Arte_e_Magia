/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pacoteAdd;

import entidades.TipoPacoteAdicional;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PacoteAdicionalSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroPacoteAdicional/editarPacoteAdicional")
public class ControllerPacoteAddEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PacoteAdicionalSQL pacoteAddBanco = new PacoteAdicionalSQL(); //instancia a classe de comunicação com o banco de dados 
        List<TipoPacoteAdicional> listaPacoteAdicional; //lista que vai receber os dados do pacote add

        //pega o idTipoPacoteAdicional da página
        String idTipoPacoteAdicional = request.getParameter("idTipoPacoteAdicional");
        int idTipoPacoteAdicional2 = Integer.parseInt(idTipoPacoteAdicional);

        //pega descricao do pacote add
        String descricaoPacoteAdd = request.getParameter("descricaoPacoteAdd");

        try {
            listaPacoteAdicional = pacoteAddBanco.getTipoPacoteAdicional();

            request.setAttribute("controllerListagemPacoteAdicional", 1);
            request.setAttribute("listaPacoteAdicional", listaPacoteAdicional);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPacoteAddEditar.class.getName()).log(Level.SEVERE, null, ex);
        }

        //atribui no request para enviar para a página
        request.setAttribute("idTipoPacoteAdicionalE", idTipoPacoteAdicional2);
        request.setAttribute("descricaoPacoteAddE", descricaoPacoteAdd);
        request.getRequestDispatcher("pacoteAdicionalPrincipal.jsp").forward(request, response); //dispara para a página

    }

}
