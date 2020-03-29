/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.despesa;

import entidades.Despesas;
import entidades.PagamentoDespesasDetalhe;
import entidades.TipoDeDespesa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.DespesaSQL;
import persistence.TipoDespesaSQL;
import persistence.pagamentoDespesaDetalheSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeDespesa/cadastrarDespesa")
public class ControllerCadastrarDespesa extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int countDespesa2 = 0; //contador da quantidade de despesas cadastradas
        int valorDisplay = 0; //controler se vai continuar listando tipo de de despesa
        int tipoDespesa2 = 0; //id do tipo de despesa selecionado 
        int despesaFechada2 = 0; //controler se o usuário marcou como despesa fechada (1 = Sim e 0 = Não)
        boolean despesaFechada = true;
        List<TipoDeDespesa> listaTipoDespesas = null; //lista que vai receber os dados do tipo de despesas
        ArrayList<PagamentoDespesasDetalhe> listaDespesasInseridas = new ArrayList(); //lista de detalhes da despesa
        String msg = ""; //msg de retorno para o usuário
        boolean deveCadastrar = true;

        //aqui pega os dados adicionais da despesas (nada voltado a valores)
        String descricaoDespesa = request.getParameter("descricaoDespesa");

        String tipoDespesa = request.getParameter("tipoDespesa");
        if (tipoDespesa != null) {

            if (!tipoDespesa.equals("")) {

                tipoDespesa2 = Integer.parseInt(tipoDespesa);

                //para continuar listando os tipos de despesa
                valorDisplay = 1;
                request.setAttribute("valorDisplay", valorDisplay);

            }

        }

        String obsDespesa = request.getParameter("obsDespesa");

//        String despesaFechada = request.getParameter("despesaFechada");
//        if (despesaFechada.equals("Sim")) {
//            despesaFechada2 = 1;
//        } else {
//            despesaFechada2 = 0;
//        }
        //aqui começa a pegar os detalhes da despesas cadastradas... valores, quantidade etc
        String countDespesa = request.getParameter("countDespesa");
        if (countDespesa != null) {

            if (!countDespesa.equals("")) {

                countDespesa2 = Integer.parseInt(countDespesa);

            }
        }

        if (countDespesa2 != 0) { //se existir despesa
            for (int i = 0; i < countDespesa2; i++) { //loop enquanto tiver despesa
                PagamentoDespesasDetalhe pagamentoDespesasDetalhe = new PagamentoDespesasDetalhe();
                float valorDespesa2 = 0;

                //pegando a lista de despesas do front
                String dataDespesa = request.getParameter("dataDespesa" + (i + 1));

                String valorDespesa = request.getParameter("valorDespesa" + (i + 1));
                if (valorDespesa != null) {
                    if (!valorDespesa.equals("")) {
                        valorDespesa2 = Float.parseFloat(valorDespesa);
                    }
                }

                String despesaIsPago = request.getParameter("despesaIsPago" + (i + 1));

                //setando os valores pegos na variavel
                if (dataDespesa != null) {
                    pagamentoDespesasDetalhe.setDataPagamento(dataDespesa);
                }

                if (valorDespesa2 != 0) {
                    pagamentoDespesasDetalhe.setValor(valorDespesa2);
                }

                if (despesaIsPago != null) {
                    if (despesaIsPago.equals("Sim")) {
                        pagamentoDespesasDetalhe.setStatus(1);
                    } else {
                        pagamentoDespesasDetalhe.setStatus(0);
                        despesaFechada = false; //se algumas das despesas estiver marcada como "Não" 
                    }
                }

                //add variavel na lista de despesas do back-end
                if (dataDespesa != null && despesaIsPago != null && valorDespesa != null) {
                    listaDespesasInseridas.add(pagamentoDespesasDetalhe);
                }

            }

        } else { //se não existir 

            deveCadastrar = false;
            msg = "Para realizar o cadastro, deve conter no minimo 1 despesa";
            request.setAttribute("msg", msg);

            if (valorDisplay != 0) { //se for cadastro utilizando "tipo de despesa", continua listando...
                TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL();

                try {
                    listaTipoDespesas = tipoDespesaBanco.getTipoDeDespesa();
                } catch (Exception ex) {
                    Logger.getLogger(ControllerCadastrarDespesa.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("valorDisplay", valorDisplay);
                request.setAttribute("listaTipoDespesas", listaTipoDespesas); // atribui a lista na marcação "listaTipoDespesas"

            } else {

                request.setAttribute("descricaoDespesa", descricaoDespesa);
                request.setAttribute("valorDisplay", valorDisplay);

            }

            request.setAttribute("obsDespesa", obsDespesa);

            request.getRequestDispatcher("despesaCadastrar.jsp").forward(request, response); // dispara para essa página            

        }

        //aqui começa o processo de cadastro no banco
        if (deveCadastrar == true) {

            DespesaSQL despesaBanco = new DespesaSQL(); //instancia classe que faz comunicação com o banco de dados
            Despesas despesa = new Despesas(); //instancia a classe que representa a despesa

            //verifica se a despesa está fechada
            if (despesaFechada == true) {
                despesaFechada2 = 1;
            } else {
                despesaFechada2 = 0;
            }

            //cadastro na tabela "despesas"
            if (tipoDespesa2 != 0) { //se for cadastro utilizando os cadatros do tipo de despesa

                TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL();//instancia a classe de comunicação com o banco de dados
                TipoDeDespesa tipoDeDespesa = new TipoDeDespesa();//instancia a classe que representa o tipo de depesa

                try {
                    //recebendo na variavel que representa o tipo de despesa , o registro do tipo de despesa do banco 
                    tipoDeDespesa = tipoDespesaBanco.getTipoDeDespesaEspecifico(tipoDespesa2);

                } catch (Exception ex) {
                    Logger.getLogger(ControllerCadastrarDespesa.class.getName()).log(Level.SEVERE, null, ex);
                }

                //setando na variavel que representa a despesa, os valores
                despesa.setDescricaoDespesa(tipoDeDespesa.getNomeDespesa());
                despesa.setIdTipoDeDespesa(tipoDespesa2);
                despesa.setObs(obsDespesa);
                despesa.setStatusDespesa(despesaFechada2);

                try {
                    //chamando método que realiza o cadastro de despesa, passando como parametro a variavel que representa a despesa
                    despesaBanco.createDespesa(despesa);

                    listaTipoDespesas = tipoDespesaBanco.getTipoDeDespesa();

                    request.setAttribute("valorDisplay", valorDisplay);
                    request.setAttribute("listaTipoDespesas", listaTipoDespesas); // atribui a lista na marcação "listaTipoDespesas"                    
                } catch (Exception ex) {
                    deveCadastrar = false;
                    Logger.getLogger(ControllerCadastrarDespesa.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else { //se for cadastro manual

                //setando na variavel que representa a despesa, os valores
                despesa.setDescricaoDespesa(descricaoDespesa);
                despesa.setObs(obsDespesa);
                despesa.setStatusDespesa(despesaFechada2);

                try {
                    //chamando método que realiza o cadastro de despesa, passando como parametro a variavel que representa a despesa
                    despesaBanco.createDespesa(despesa);
                } catch (Exception ex) {
                    deveCadastrar = false;
                    Logger.getLogger(ControllerCadastrarDespesa.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //cadastro na tabela pagamentoDespesaDetalhe
            if (deveCadastrar == true) {
                pagamentoDespesaDetalheSQL detalheDespesaBanco = new pagamentoDespesaDetalheSQL();

                try {
                    //pegando o id da ultima despesa cadastrada no banco
                    int idDespesa = despesaBanco.getUltimoIdDespesas();
                    //chamando o método de creat do banco e passando a lista de despesa inserida pelo usuário e o id da ultima despesa cadastrada
                    detalheDespesaBanco.createDespesaDetalhe(listaDespesasInseridas, idDespesa);

                    msg = "Despesa cadastrada com sucesso!";

                    request.setAttribute("msg", msg);

                    request.getRequestDispatcher("despesaCadastrar.jsp").forward(request, response); // dispara para essa página            

                } catch (Exception ex) {
                    Logger.getLogger(ControllerCadastrarDespesa.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

}
