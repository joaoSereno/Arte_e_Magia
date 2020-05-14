/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoDeFesta;

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
@WebServlet("/paginasDeCadastro/cadastroTipoDeFesta/inativarTipoDeFesta")
public class ControllerTipoDeFestaInativar extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idTipoDeFesta2 = 0;
        
        //pegando parametros do usuário
        String idTipoDeFesta = request.getParameter("idTipoDeFesta");
        if (!idTipoDeFesta.equals("")) { //verifica se tem valor
            idTipoDeFesta2 = Integer.parseInt(idTipoDeFesta);
        }
        
        TipoDeFestaSQL tipoDeFestaBanco = new TipoDeFestaSQL(); //instanciando classe que faz comunicação com o banco de dados
        
        try {
            
            if (idTipoDeFesta2 != 0) { //se existir valor no idTipoDeFesta2 
                tipoDeFestaBanco.inativaPacoteAdicional(idTipoDeFesta2); //chama método da classe de comunicação com o banco que inativa o cadastro
                request.setAttribute("msg", "Cadastro excluído com sucesso!");  
                request.getRequestDispatcher("tipoDeFestaPrincipal.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("tipoDeFestaPrincipal.jsp").forward(request, response);                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerTipoDeFestaInativar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }    
}
