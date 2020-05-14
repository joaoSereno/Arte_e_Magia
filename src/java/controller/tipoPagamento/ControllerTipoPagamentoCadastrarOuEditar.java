/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tipoPagamento;

import entidades.FormaPagamento;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.TipoPagamentoSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroTipoPagamento/editarORcadastrarFP")
public class ControllerTipoPagamentoCadastrarOuEditar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idFormaPagamento2 = 0;

        //pegando os valores do usuario digitados no front
        String idFormaPagamento = request.getParameter("idFormaPagamento");
        if (idFormaPagamento != "") { //se for diferente de vazio (ou seja for editar) , faz a conversão para int
            idFormaPagamento2 = Integer.parseInt(idFormaPagamento);
        }
        String nomePagamento = request.getParameter("nomePagamento");

        FormaPagamento formaPagamento = new FormaPagamento(); //instanciando classe Forma de Pagamento
        //setando valores pegos pelo usuario na classe 
        if (!nomePagamento.equals("")) {
            formaPagamento.setNomePagamento(nomePagamento);
        }
        if (idFormaPagamento2 != 0) {
            formaPagamento.setIdFormaPagamento(idFormaPagamento2);
        }

        TipoPagamentoSQL formaPagamentoBanco = new TipoPagamentoSQL(); //instanciando classe que realiza comunicação com banco de dados

        try {
            //se for o idFormaPagamento2 = 0 significa que é para cadastrar 
            if (idFormaPagamento2 == 0) {
                //verifica se o nome é em branco 
                if (formaPagamento.getNomePagamento() == null) {
                    request.setAttribute("msg", "Não é possível inserir o nome em branco!!");
                    request.getRequestDispatcher("tipoPagamentoPrincipal.jsp").forward(request, response);
                } else {//se não for vazio add no banco
                    formaPagamentoBanco.create(formaPagamento);//chamando método de inserir da classe TipoPagamentoSQL e passando classe instanciada do tipoPagamento como parametro  
                    request.setAttribute("msg", "Cadastro realizado com sucesso!");
                    request.getRequestDispatcher("tipoPagamentoPrincipal.jsp").forward(request, response);
                }
            } else {//se não significa que é para editar

                formaPagamentoBanco.editaFormaPagamento(formaPagamento);//chamando método de update da classe TipoPagamentoSQL e passando classe instanciada do tipoPagamento como parametro  
                request.setAttribute("msg", "Cadastro editado com sucesso!");
                request.getRequestDispatcher("tipoPagamentoPrincipal.jsp").forward(request, response);
                
            }
        } catch (Exception ex) {
            Logger.getLogger(ControllerTipoPagamentoCadastrarOuEditar.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }

    }

}
