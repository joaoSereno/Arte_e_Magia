/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoDeFesta;

import entidades.TipoDeFesta;
import java.io.IOException;
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
@WebServlet("/paginasDeCadastro/cadastroTipoDeFesta/editarORcadastrarTipoDeFesta")
public class ControllerTipoDeFestaCadastrarOuEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTipoDeFesta2 = 0;

        //pegando os valores do usuario digitados no front
        String idTipoDeFesta = request.getParameter("idTipoDeFesta");
        if (!idTipoDeFesta.equals("")) { //se for diferente de vazio (ou seja for editar) , faz a conversão para int
            idTipoDeFesta2 = Integer.parseInt(idTipoDeFesta);
        }
        String descricaoTipoDeFesta = request.getParameter("descricaoTipoDeFesta");

        TipoDeFesta tipoDeFesta = new TipoDeFesta(); //instanciando classe Tipo de Festa
        
        //setando valores pegos pelo usuario na classe 
        if (!descricaoTipoDeFesta.equals("")) {
            tipoDeFesta.setDescricaoTipoDeFesta(descricaoTipoDeFesta);
        }
        if (idTipoDeFesta2 != 0) {
            tipoDeFesta.setIdTipoDeFesta(idTipoDeFesta2);
        }

        TipoDeFestaSQL tipoDeFestaBanco = new TipoDeFestaSQL(); //instanciando classe que realiza comunicação com banco de dados

        try {
            //se for o idTipoDeFesta2 = 0 significa que é para cadastrar 
            if (idTipoDeFesta2 == 0) {
                
                //verifica se o nome é em branco 
                if (tipoDeFesta.getDescricaoTipoDeFesta() == null) {
                    request.setAttribute("msg", "Não é possível inserir o nome em branco!!");
                    request.getRequestDispatcher("tipoDeFestaPrincipal.jsp").forward(request, response);
                } else {//se não for vazio add no banco
                    tipoDeFestaBanco.create(tipoDeFesta);//chamando método de inserir da classe de comunicação com o banco de dados
                    request.setAttribute("msg", "Tipo de Festa cadastrada com sucesso!!");
                    request.getRequestDispatcher("tipoDeFestaPrincipal.jsp").forward(request, response);
                }
                
            } else {//se não significa que é para editar

                tipoDeFestaBanco.editarPacoteAdicional(tipoDeFesta);//chamando método de editar da classe de comunicação com o banco 
                request.setAttribute("msg", "Tipo de Festa editada com sucesso!!");
                request.getRequestDispatcher("tipoDeFestaPrincipal.jsp").forward(request, response);
                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerTipoDeFestaCadastrarOuEditar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }

}
