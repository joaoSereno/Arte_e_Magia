/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configConexao;

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

@WebServlet("/conexao")
public class ControllerConexao extends HttpServlet{

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String statusConexao = null;
        try {
            Conexao conexao = new Conexao();
            conexao.open();
            statusConexao = "Conexão OK!";
        } catch (Exception ex) {
            statusConexao = "Conexão deu ruim! - " + ex.getMessage();
        }
        request.setAttribute("msg", statusConexao);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }    

}    

