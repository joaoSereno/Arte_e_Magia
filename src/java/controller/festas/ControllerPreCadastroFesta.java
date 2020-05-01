/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.festas;

import entidades.Cliente;
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
import persistence.ClienteSQL;
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
@WebServlet("/paginasDeCadastro/cadastroDeFesta/preCadastroFesta")
public class ControllerPreCadastroFesta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //CLIENTE
        //instanciando as classes necessarias para a listagem de cliente
        ClienteSQL clienteBanco = new ClienteSQL();
        List<Cliente> listaClientes;

        //recebendo registros de cliente do banco 
        try {
            listaClientes = clienteBanco.getClientes();

            //setando os atributos que será enviando para o front
            request.setAttribute("listaClientes", listaClientes);

        } catch (Exception ex) {
            Logger.getLogger(ControllerPreCadastroFesta.class.getName()).log(Level.SEVERE, null, ex);
        }

        //CRIANCA
        //instanciando as classes necessarias para a listagem de crianca
        CriancaSQL criancaBanco = new CriancaSQL();
        List<Crianca> listaCriancas;

        try {
            String listaConcatenadaCrianca = "";
            int totalCriancas = 0;

            //recebendo registros de criancas do banco 
            listaCriancas = criancaBanco.getTodasCriancasAtivas();

            //recebendo o total registros na variavel 
            totalCriancas = listaCriancas.size();

            //loop em todos os registros da lista e concatenando tudo em um string que servira de controlador(input) no front
            for (int i = 0; i < listaCriancas.size(); i++) {
                listaConcatenadaCrianca = listaConcatenadaCrianca + Integer.toString(listaCriancas.get(i).getIdCrianca())
                        + "," + listaCriancas.get(i).getNomeCrianca()
                        + "," + Integer.toString(listaCriancas.get(i).getIdCliente()) + "/";
            }

            //setando os atributos que será enviando para o front
            request.setAttribute("totalCriancas", totalCriancas);
            request.setAttribute("listaConcatenadaCrianca", listaConcatenadaCrianca);

        } catch (Exception ex) {
            Logger.getLogger(ControllerPreCadastroFesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //FUNCIONARIOS
        //instanciando as classes necessarias para a listagem de funcionario
        FuncionarioSQL funcionarioBanco = new FuncionarioSQL();
        List<Funcionario> listaFuncionario;

        try {
            //recebendo registros de funcionario do banco 
            listaFuncionario = funcionarioBanco.getFuncionario();
            
            //setando os atributos que será enviando para o front
            request.setAttribute("listaFuncionario", listaFuncionario);
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerPreCadastroFesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //FORMAS DE PAGAMENTO
        //instanciando as classes necessarias para a listagem de forma de pagamentos
        TipoPagamentoSQL tipoPagamentoBanco = new TipoPagamentoSQL();
        List<FormaPagamento> listaFormaPagamento;
        
        try {
            //recebendo registros de forma de pagamento do banco 
            listaFormaPagamento  = tipoPagamentoBanco.getFormaPagamento();
            
            //setando os atributos que será enviando para o front
            request.setAttribute("listaFormaPagamento", listaFormaPagamento);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPreCadastroFesta.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        //PACOTE
        //instanciando as classes necessarias para a listagem de pacote
        PacoteSQL pacoteBanco = new PacoteSQL();
        List<Pacote> listaPacote;
        
        try {
            //recebendo registros de forma de pacote do banco
            listaPacote = pacoteBanco.getPacote();
            
            //setando os atributos que será enviando para o front
            request.setAttribute("listaPacote", listaPacote);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPreCadastroFesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //PACOTE ADICIONAL
        //instanciando as classes necessarias para a listagem de pacote adicionais
        PacoteAdicionalSQL pacoteAdicionalBanco = new PacoteAdicionalSQL();
        List<TipoPacoteAdicional> listaTipoPacoteAdicional; 
        
        try {
            //recebendo registros de pacote adicionais do banco 
            listaTipoPacoteAdicional = pacoteAdicionalBanco.getTipoPacoteAdicional();
            
            //setando os atributos que será enviando para o front
            request.setAttribute("listaTipoPacoteAdicional", listaTipoPacoteAdicional);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPreCadastroFesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //TIPO DE DESPESA
        //instanciando as classes necessarias para a listagem de tipo de despesa
        TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL();
        List<TipoDeDespesa> listaTipoDeDespesa;
        
        try {
            //recebendo registros de tipo de despesa do banco 
            listaTipoDeDespesa = tipoDespesaBanco.getTipoDeDespesa();
            
            //setando os atributos que será enviando para o front
            request.setAttribute("listaTipoDeDespesa", listaTipoDeDespesa);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPreCadastroFesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //dispachando para a página
        request.getRequestDispatcher("festaCadastrar.jsp").forward(request, response); // dispara para essa página
    }
}
