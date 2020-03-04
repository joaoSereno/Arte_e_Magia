/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.crianca;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.CriancaSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeClientes/inativarCrianca")
public class ControllerCriancaInativar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCrianca2 = 0;
        int idCliente2 = 0;

        String msg = "Cadastro excluído com sucesso!";
        
        //recebendo parametros do request
        String idCrianca = request.getParameter("idCrianca"); //recebe o idCrianca
        if (idCrianca != "") { // verifica se existe criança (ou seja se a pessoa clicou no excluir pelo cadastro)
            idCrianca2 = Integer.parseInt(idCrianca); //converte para inteiro o idCrianca
        }
        
        String idCliente = request.getParameter("idCliente"); //recebe o idCliente
        if(idCliente != ""){ // verifica se existe idCliente antes de vonverter
            idCliente2 = Integer.parseInt(idCliente);           
        }


        
        

        CriancaSQL criancaBanco = new CriancaSQL(); //instanciando classe do banco de dados para fazer update no banco

        try {
            if (idCrianca2 != 0) { //se existir criança inativa o cadastro

                criancaBanco.inativarCadastro(idCrianca2); //chamando método que inativa o cadastro da criança 
                
                request.setAttribute("idClienteE", idCliente2);
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("criancaEditarOuCadastrar.jsp").forward(request, response);

            } else { //se não existir não faz nada
                request.setAttribute("idClienteE", idCliente2);
                request.getRequestDispatcher("criancaEditarOuCadastrar.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            Logger.getLogger(ControllerCriancaInativar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }

    }

}
