/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.festas;

import entidades.Crianca;
import entidades.FormaPagamento;
import entidades.Funcionario;
import entidades.Pacote;
import entidades.TipoDeDespesa;
import entidades.TipoPacoteAdicional;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.CriancaSQL;
import persistence.FuncionarioSQL;
import persistence.PacoteAdicionalSQL;
import persistence.PacoteSQL;
import persistence.TipoDespesaSQL;
import persistence.TipoPagamentoSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeFesta/listarOpcoes2")
public class ControllerListaOpcoesFesta2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int countCliente2 = 0;
        int idCliente2 = 0;
        
        //pega os dados do cliente selecionado
        String countCliente = request.getParameter("countCliente");
        if (countCliente != null) {

            if (!countCliente.equals("")) {

                countCliente2 = Integer.parseInt(countCliente);

                request.setAttribute("countCliente", countCliente2);

            }

        }

        String idCliente = request.getParameter("idCliente");
        if (idCliente != null) {

            if (!idCliente.equals("")) {

                idCliente2 = Integer.parseInt(idCliente);

            }

        }  
        
        String nomeCliente = request.getParameter("nomeCliente");
               

        //aqui começa a instanciação das classes de comunicação com o banco de dado e chamada de get dos métodos
        CriancaSQL criancaBanco = new CriancaSQL();
        List<Crianca> listaCrianca;
        
        FuncionarioSQL funcionarioBanco = new FuncionarioSQL();
        List<Funcionario> listaFuncionario;
        
        TipoPagamentoSQL tipoPagamentoBanco = new TipoPagamentoSQL();
        List<FormaPagamento> listaFormaPagamento;
        
        PacoteSQL pacoteBanco = new PacoteSQL();
        List<Pacote> listaPacote;
        
        TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL();
        List<TipoDeDespesa> listaTipoDeDespesa;
        
        PacoteAdicionalSQL pacoteAdicionalBanco = new PacoteAdicionalSQL();
        List<TipoPacoteAdicional> listaTipoPacoteAdicional;
        
        //chamando os métodos de get do banco e add as lista no response
        try {
            //chamando método de get e recebendo o resultado na lista
            listaCrianca = criancaBanco.getCrianca(idCliente2);
            int countCrianca = listaCrianca.size();
            
            listaFuncionario = funcionarioBanco.getFuncionario();
            listaFormaPagamento  = tipoPagamentoBanco.getFormaPagamento();
            listaPacote = pacoteBanco.getPacote();
            listaTipoDeDespesa = tipoDespesaBanco.getTipoDeDespesa();
            listaTipoPacoteAdicional = pacoteAdicionalBanco.getTipoPacoteAdicional();
            
            //adicionando as lista no response
            request.setAttribute("listaCrianca", listaCrianca);
            request.setAttribute("countCrianca", countCrianca);
            request.setAttribute("listaFuncionario", listaFuncionario);
            request.setAttribute("listaFormaPagamento", listaFormaPagamento);
            request.setAttribute("listaPacote", listaPacote);
            request.setAttribute("listaTipoDeDespesa", listaTipoDeDespesa);
            request.setAttribute("listaTipoPacoteAdicional", listaTipoPacoteAdicional);
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerListaOpcoesFesta2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //se é a primeira vez que vai selecionar cliente
        if(countCliente2 == 0){ 
            countCliente2 = 1;
            
            //seta atributos no response , dados do cliente e se já passou por aqui alguma vez
            request.setAttribute("countCliente", countCliente2);
            request.setAttribute("nomeCliente", nomeCliente);
            request.setAttribute("idCliente", idCliente2);
            
            
            
            request.getRequestDispatcher("festaCadastrar.jsp").forward(request, response);
            
        }else{ //se não é
            
            
        }
        
    }
    
}
