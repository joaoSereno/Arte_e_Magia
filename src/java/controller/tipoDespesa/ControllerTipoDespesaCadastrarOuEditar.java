/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoDespesa;

import entidades.TipoDeDespesa;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.TipoDespesaSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroTipoDespesa/editarORcadastrarTD")
public class ControllerTipoDespesaCadastrarOuEditar extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTipoDeDespesa2 = 0;

        //pegando os valores do usuario digitados no front
        String idTipoDeDespesa = request.getParameter("idTipoDeDespesa");
        if (idTipoDeDespesa != "") { //se for diferente de vazio (ou seja for editar) , faz a conversão para int
            idTipoDeDespesa2 = Integer.parseInt(idTipoDeDespesa);
        }
        String nomeDespesa = request.getParameter("nomeDespesa");

        TipoDeDespesa tipoDeDespesa = new TipoDeDespesa(); //instanciando classe Tipo De Despesa
        
        //setando valores pegos pelo usuario na classe 
        if (!nomeDespesa.equals("")) {
            tipoDeDespesa.setNomeDespesa(nomeDespesa);
        }
        if (idTipoDeDespesa2 != 0) {
            tipoDeDespesa.setIdTipoDeDespesa(idTipoDeDespesa2);
        }

        TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL(); //instanciando classe que realiza comunicação com banco de dados

        try {
            //se for o idTipoDeDespesa2 = 0 significa que é para cadastrar 
            if (idTipoDeDespesa2 == 0) {
                //verifica se o nome é em branco 
                if (tipoDeDespesa.getNomeDespesa() == null) {
                    request.setAttribute("msg", "Não é possível inserir o nome em branco!!");
                    request.getRequestDispatcher("tipoDespesaPrincipal.jsp").forward(request, response);
                } else {//se não for vazio add no banco
                    tipoDespesaBanco.create(tipoDeDespesa);//chamando método de inserir da classe TipoDespesaSQL e passando classe instanciada do tipoDeDespesa como parametro  
                    request.setAttribute("msg", "Tipo de Despesa cadastrada com sucesso!!");
                    request.getRequestDispatcher("tipoDespesaPrincipal.jsp").forward(request, response);
                }
            } else {//se não significa que é para editar

                tipoDespesaBanco.editarTipoDespesa(tipoDeDespesa);//chamando método de update da classe TipoDespesaSQL e passando classe instanciada do tipoDeDespesa como parametro  
                request.setAttribute("msg", "Tipo de Despesa  editada com sucesso!!");
                request.getRequestDispatcher("tipoDespesaPrincipal.jsp").forward(request, response);
                
            }
        } catch (Exception ex) {
            Logger.getLogger(ControllerTipoDespesaCadastrarOuEditar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }

    }    
}
