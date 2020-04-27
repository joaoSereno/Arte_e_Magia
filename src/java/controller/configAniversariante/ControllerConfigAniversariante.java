/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.configAniversariante;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ConfigAniversarianteSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/configAniversariante/configAniversariante")
public class ControllerConfigAniversariante extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int qtdDias2 =0;
        
        String qtdDias = request.getParameter("qtdDias");
        if (qtdDias != null) {

            if (!qtdDias.equals("")) {

                qtdDias2 = Integer.parseInt(qtdDias);

            }

        }
        
        ConfigAniversarianteSQL configAniversarianteBanco = new ConfigAniversarianteSQL();
        
        try {

            if(qtdDias2 != 0){
                
                configAniversarianteBanco.editarConfigAniversariante(qtdDias2);
            
            }

            //set de atributo para outra página
            request.setAttribute("msg", "Configurado para "+qtdDias2+" dias com sucesso!");   
            request.getRequestDispatcher("telaConfigAniversariante.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ControllerConfigAniversariante.class.getName()).log(Level.SEVERE, null, ex);
        }        

    }

}
