/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pacoteAdd;

import entidades.TipoPacoteAdicional;
import java.io.IOException;
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
@WebServlet("/paginasDeCadastro/cadastroPacoteAdicional/editarORcadastrarPacoteAdd")
public class ControllerPacoteAddCadastrarOuEditar extends HttpServlet{
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTipoPacoteAdicional2 = 0;

        //pegando os valores do usuario digitados no front
        String idTipoPacoteAdicional = request.getParameter("idTipoPacoteAdicional");
        if (!idTipoPacoteAdicional.equals("")) { //se for diferente de vazio (ou seja for editar) , faz a conversão para int
            idTipoPacoteAdicional2 = Integer.parseInt(idTipoPacoteAdicional);
        }
        String descricaoPacoteAdd = request.getParameter("descricaoPacoteAdd");

        TipoPacoteAdicional tipoPacoteAdicional = new TipoPacoteAdicional(); //instanciando classe Pacote Adicional
        
        //setando valores pegos pelo usuario na classe 
        if (!descricaoPacoteAdd.equals("")) {
            tipoPacoteAdicional.setDescricaoPacoteAdd(descricaoPacoteAdd);
        }
        if (idTipoPacoteAdicional2 != 0) {
            tipoPacoteAdicional.setIdTipoPacoteAdicional(idTipoPacoteAdicional2);
        }

        PacoteAdicionalSQL pacoteAddBanco = new PacoteAdicionalSQL();; //instanciando classe que realiza comunicação com banco de dados

        try {
            //se for o idTipoDeDespesa2 = 0 significa que é para cadastrar 
            if (idTipoPacoteAdicional2 == 0) {
                //verifica se o nome é em branco 
                if (tipoPacoteAdicional.getDescricaoPacoteAdd() == null) {
                    
                    request.setAttribute("msg", "Não é possível inserir o nome em branco!!");
                    request.getRequestDispatcher("pacoteAdicionalPrincipal.jsp").forward(request, response);
                    
                } else {//se não for vazio add no banco
                    
                    pacoteAddBanco.create(tipoPacoteAdicional);//chamando método de inserir da classe de comuniação com o banco
                    request.setAttribute("msg", "Pacote adicional cadastrado com sucesso!!");
                    request.getRequestDispatcher("pacoteAdicionalPrincipal.jsp").forward(request, response);
                    
                }
                
            } else {//se não significa que é para editar

                pacoteAddBanco.editarPacoteAdicional(tipoPacoteAdicional);//chamando método de editar da classe de comunicação com o banco 
                request.setAttribute("msg", "Pacote adicional editado com sucesso!!");
                request.getRequestDispatcher("pacoteAdicionalPrincipal.jsp").forward(request, response);
                
            }
        } catch (Exception ex) {
            Logger.getLogger(ControllerPacoteAddCadastrarOuEditar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }    
        
    }
       
}
