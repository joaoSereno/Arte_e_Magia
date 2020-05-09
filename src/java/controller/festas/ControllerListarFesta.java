/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.festas;

import entidades.Festa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.FestaSQL;
import util.Conversor;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeFesta/listarFesta")
public class ControllerListarFesta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int statusEvento2 = 0;
        String periodoEventoConvertido = "";
        String periodoEventoConvertido2 = "";
        Conversor conversorString = new Conversor();
        ArrayList<Festa> listaFesta = new ArrayList(); //lista de festa
        FestaSQL festaBanco = new FestaSQL(); //classe de comunicação com o banco de dados

        //pega os parametro da pesquisa do request
        String statusEvento = request.getParameter("statusEvento");
        if (statusEvento != null) {
            if (!statusEvento.equals("")) {
                statusEvento2 = Integer.parseInt(statusEvento);
            }
        }
        String periodoEvento = request.getParameter("periodoEvento");
        if (periodoEvento != null) {
            if (!periodoEvento.equals("")) {
                periodoEventoConvertido = conversorString.formatarData(periodoEvento);
            }
        }
        String periodoEvento2 = request.getParameter("periodoEvento2");
        if (periodoEvento2 != null) {
            if (!periodoEvento2.equals("")) {
                periodoEventoConvertido2 = conversorString.formatarData(periodoEvento2);
            }
        }

        try {
            //executa o método de busca do banco passando os parametros do request
            listaFesta = festaBanco.getFestaListagem(statusEvento2, periodoEventoConvertido, periodoEventoConvertido2);

            //texto de qtd de evento
            String msgQtdEvento = "Total de " + listaFesta.size() + " eventos dentro do período de " + periodoEvento + " a " + periodoEvento2;

            int controllerListagemEvento = 0;
            if (listaFesta.size() > 0) {
                controllerListagemEvento = 1;
            }

            //setando os atributos que será enviando para o front
            request.setAttribute("controllerListagemEvento", controllerListagemEvento);
            request.setAttribute("controllerMsgEvento", 1);
            request.setAttribute("listaEvento", listaFesta);
            request.setAttribute("msgQtdEvento", msgQtdEvento);

            //dispachando para a página
            request.getRequestDispatcher("festaPrincipal.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ControllerListarFesta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
