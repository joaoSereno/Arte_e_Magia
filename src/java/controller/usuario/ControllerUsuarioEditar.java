/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.usuario;

import entidades.Funcionario;
import entidades.Usuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.FuncionarioSQL;
import persistence.UsuarioSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeUsuario/usuarioEditar")
public class ControllerUsuarioEditar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario2 = 0;
        List<Funcionario> listaFuncionario = null; //lista que vai receber os dados do funcionario
        int valorDisplay = 0;

        String idUsuario = request.getParameter("idUsuario");
        if (idUsuario != null) {
            if (!idUsuario.equals("")) {

                idUsuario2 = Integer.parseInt(idUsuario);

            }
        }

        UsuarioSQL usuarioBanco = new UsuarioSQL();//instanciando classe que faz comunicação com o banco de dados

        Usuario usuario = new Usuario();

        try {

            usuario = usuarioBanco.getUsuarioEspecifico(idUsuario2); //recebe usuario do banco na instancia do usuario
            
            if(usuario.getIdFuncionario() != 0){ //se o usuario editado for tipo FUNC 
                
                FuncionarioSQL funcionarioBanco = new FuncionarioSQL(); //instancia a classe de comunicação com o banco de dados de funcionario
                Funcionario funcionarioDoUsuario = new Funcionario();
                
                listaFuncionario = funcionarioBanco.getFuncionarioNaoTemUsuario(); //recebe na lista os usuarios para ser editado
                funcionarioDoUsuario = funcionarioBanco.getFuncionarioEspecifico(usuario.getIdFuncionario()); //recebe na instancia funcionario, o funcionario do usuario
                valorDisplay = 1;
                
                //seta os atributos necessarios para listar os funcionarios disponiveis caso for cadastro do tipo FUNC
                request.setAttribute("funcionarioDoUsuario", funcionarioDoUsuario);
                request.setAttribute("listaFuncionario", listaFuncionario);
                request.setAttribute("valorDisplay", valorDisplay);
                
            }
            
            //setando atributos que será jogados para outra página
            request.setAttribute("usuario", usuario);
            
            //dispachando para a página
            request.getRequestDispatcher("usuarioEditar.jsp").forward(request, response);
            
        } catch (Exception ex) {

            Logger.getLogger(ControllerUsuarioEditar.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
