/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoDeFesta;

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
@WebServlet("/paginasDeCadastro/cadastroTipoDeFesta/editarTipoDeFesta")
public class ControllerTipoDeFestaEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //pega o idTipoDeFesta da página
        String idTipoDeFesta = request.getParameter("idTipoDeFesta");
        int idTipoDeFesta2 = Integer.parseInt(idTipoDeFesta);

        //pega descricao do tipo de festa
        String descricaoTipoDeFesta = request.getParameter("descricaoTipoDeFesta");

        //atribui no request para enviar para a página
        request.setAttribute("idTipoDeFestaE", idTipoDeFesta);
        request.setAttribute("descricaoTipoDeFestaE", descricaoTipoDeFesta);
        request.getRequestDispatcher("tipoDeFestaPrincipal.jsp").forward(request, response); //dispara para a página

    }
}
