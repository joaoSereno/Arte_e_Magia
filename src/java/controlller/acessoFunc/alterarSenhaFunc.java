/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlller.acessoFunc;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.UsuarioSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/alterarSenhaFunc")
public class alterarSenhaFunc extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PEGANDO idUsuario e nomeUsuario E JOGANDO DE VOLTA NO DISPACHER
        int idUsuario2 = 0;
        
        String idUsuario = request.getParameter("idUsuario");
        if (idUsuario != null) {
            
            if (!idUsuario.equals("")) {

                idUsuario2 = Integer.parseInt(idUsuario);
                
            }
            
        }
        
        String stringNomeUsuario = request.getParameter("nomeUsuario");
        byte array[] = stringNomeUsuario.getBytes("ISO-8859-1");
        String nomeUsuario = new String(array, "UTF-8");
                   
        request.setAttribute("idUsuario", idUsuario2);
        request.setAttribute("nomeUsuario", nomeUsuario);
        
        //COMEÇO DO PROCESSO DE ALTERAÇÃO SENHA FUNC
        //instancia as variaveis necessarias
        String msgErroSenhasNaoIguais = "A senha e confirmação de senha não são iguais! Por favor tente novamente.";
        String msgConfirmacaoAlteracaoSenha = "Senha alterada com sucesso!";
        String msgErroAlteracaoSenha = "";
        //String msgErroAlteracaoSenha = "Ops! Não foi possível alterar a senha =(";
        
        //recebe a senha e confirmação de senha
        String senha = request.getParameter("senha");
        String confirmacaoDeSenha = request.getParameter("confirmacaoDeSenha");
        
        if (!senha.equals("")) { //se a senha for diferente de vazia

                if (senha.equals(confirmacaoDeSenha)) {//se a senha de confirmação e senha forem iguais

                    UsuarioSQL usuarioBanco = new UsuarioSQL();//instanciando classe de comunicação com o banco de dados

                    try {

                        usuarioBanco.novaSenha(idUsuario2, senha); //chama método que realiza a alteração na senha do usuario

                        request.setAttribute("controllerMsgAlteracaoSenha", 1);
                        request.setAttribute("msgConfirmacaoAlteracaoSenha", msgConfirmacaoAlteracaoSenha);

                        request.getRequestDispatcher("funcPaginaInicial.jsp").forward(request, response);
                        
                    } catch (Exception ex) {
                        Logger.getLogger(alterarSenhaFunc.class.getName()).log(Level.SEVERE, null, ex);
                        
                        msgErroAlteracaoSenha = "Ops! Não foi possível alterar a senha =(";

                        request.setAttribute("controllerMsgAlteracaoSenha", 2);
                        request.setAttribute("msgErroAlteracaoSenha", msgErroAlteracaoSenha);
                    }

                } else { //se não igual

                    request.setAttribute("controllerMsgAlteracaoSenha", 3);
                    request.setAttribute("msgErroSenhasNaoIguais", msgErroSenhasNaoIguais);

                    request.getRequestDispatcher("funcPaginaInicial.jsp").forward(request, response);
                }

            } else { //se não for diferente de vazia

                msgErroAlteracaoSenha = "Senha não pode ser em branco";

                request.setAttribute("controllerMsgAlteracaoSenha", 2);
                request.setAttribute("msgErroAlteracaoSenha", msgErroAlteracaoSenha);

                request.getRequestDispatcher("funcPaginaInicial.jsp").forward(request, response);
            }
        
    }   
            
}
