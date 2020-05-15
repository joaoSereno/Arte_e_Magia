/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.configAniversariante;

import entidades.ConfigNotificacaoAniversariante;
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
@WebServlet("/paginasDeCadastro/configAniversariante/verificarConfigAniversariante")
public class ControllerVisualizarConfigAtual extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //instancia classes necessarias
        ConfigAniversarianteSQL configAniversarianteBanco = new ConfigAniversarianteSQL();
        ConfigNotificacaoAniversariante configAtual = new ConfigNotificacaoAniversariante();
        
        try {
            //recebe a config atual
            configAtual = configAniversarianteBanco.getDiasConfigAniversariante(1);
            
            String textoConfigAtual = "";
            
            //monta o texto de exibição
            if(configAtual.getDias() < 2){
                textoConfigAtual = "Configuração Atual: "+configAtual.getDias()+" dia.";
            }else{
                textoConfigAtual = "Configuração Atual: "+configAtual.getDias()+" dias.";
            }
            
            
            //set de atributo para outra página
            request.setAttribute("textoConfigAtual", textoConfigAtual);   
            request.getRequestDispatcher("telaConfigAniversariante.jsp").forward(request, response);            
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerVisualizarConfigAtual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
