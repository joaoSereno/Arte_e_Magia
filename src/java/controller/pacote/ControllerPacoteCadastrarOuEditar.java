/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pacote;

import entidades.Pacote;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.PacoteSQL;

/**
 *
 * @author João Pedro 
 */
@WebServlet("/paginasDeCadastro/cadastroDePacote/editarORcadastrarPacote")
public class ControllerPacoteCadastrarOuEditar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPacote2 = 0;
        float valorPacoteVenda2 = 0;

        //pegando os valores do usuario digitados no front
        String idPacote = request.getParameter("idPacote");
        if (idPacote != "") { //se for diferente de vazio (ou seja for editar) , faz a conversão para int
            idPacote2 = Integer.parseInt(idPacote);
        }
        String nomePacote = request.getParameter("nomePacote");

        String valorPacoteVenda = request.getParameter("valorPacoteVenda");
        if (valorPacoteVenda != ""){
            valorPacoteVenda2 = Float.parseFloat(valorPacoteVenda);            
        }


        //instanciando classe Pacote
        Pacote pacote = new Pacote();

        //setando valores pegos pelo usuario na classe 
        if (idPacote2 != 0) {
            pacote.setIdPacote(idPacote2);
        }
        if (!nomePacote.equals("")) {
            pacote.setNomePacote(nomePacote);
        }
        if (valorPacoteVenda2 > 0) {
            pacote.setValorPacoteVenda(valorPacoteVenda2);
        }

        PacoteSQL pacoteBanco = new PacoteSQL(); //instanciando classe que realiza comunicação com banco de dados

        try {
            //se for o idPacote2 = 0 significa que é para cadastrar 
            if (idPacote2 == 0) {
                //verifica se o nome é em branco 
                if (pacote.getNomePacote() == null) {
                    
                    request.setAttribute("msg", "Não é possível inserir o nome em branco!!");
                    request.getRequestDispatcher("pacotePrincipal.jsp").forward(request, response);
                    
                } else if (valorPacoteVenda2 == 0) {//verifica se o valor é 0 
                    
                    request.setAttribute("msg", "O valor deve ser maior que 0!!");
                    request.getRequestDispatcher("pacotePrincipal.jsp").forward(request, response);
                    
                } else {
                    
                    pacoteBanco.create(pacote);//chamando método de inserir da classe PacoteSQL e passando classe instanciada do pacote como parametro  
                    request.setAttribute("msg", "Pacote cadastrado com sucesso!!");
                    request.getRequestDispatcher("pacotePrincipal.jsp").forward(request, response);
                    
                }
            } else {//se não significa que é para editar

                pacoteBanco.editaPacote(pacote);//chamando método de update da classe PacoteSQL e passando classe instanciada do pacote como parametro  
                request.setAttribute("msg", "Pacote editado com sucesso!!");
                request.getRequestDispatcher("pacotePrincipal.jsp").forward(request, response);

            }
        } catch (Exception ex) {
            Logger.getLogger(ControllerPacoteCadastrarOuEditar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }

    }
}
