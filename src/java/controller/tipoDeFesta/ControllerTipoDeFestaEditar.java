/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoDeFesta;

import entidades.TipoDeFesta;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.TipoDeFestaSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroTipoDeFesta/editarTipoDeFesta")
public class ControllerTipoDeFestaEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoDeFestaSQL tipoDeFestaBanco = new TipoDeFestaSQL();
        List<TipoDeFesta> listaTipoDeFesta;

        //pega o idTipoDeFesta da página
        String idTipoDeFesta = request.getParameter("idTipoDeFesta");
        int idTipoDeFesta2 = Integer.parseInt(idTipoDeFesta);

        //pega descricao do tipo de festa
        String descricaoTipoDeFesta = request.getParameter("descricaoTipoDeFesta");

        try {
            listaTipoDeFesta = tipoDeFestaBanco.getTipoDeFesta();
            
            //atribui no request para enviar para a página
            request.setAttribute("listaTipoDeFesta", listaTipoDeFesta);
            request.setAttribute("controllerListagemTipoDeFesta", 1);   
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerTipoDeFestaEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //atribui no request para enviar para a página
        request.setAttribute("idTipoDeFestaE", idTipoDeFesta);
        request.setAttribute("descricaoTipoDeFestaE", descricaoTipoDeFesta);
        request.getRequestDispatcher("tipoDeFestaPrincipal.jsp").forward(request, response); //dispara para a página

    }
}
