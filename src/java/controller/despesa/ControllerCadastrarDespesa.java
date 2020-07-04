/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.despesa;

import entidades.Despesas;
import entidades.FormaPagamento;
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
import persistence.TipoPagamentoSQL;
import persistence.PagamentoDespesasDetalheSQL;
import util.Conversor;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeDespesa/cadastrarDespesa")
public class ControllerCadastrarDespesa extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //variaveis necesarias para mostrar mensagem de retorno ao usuario
        int msgConfirmacaoCadastro = 1; //msg de confirmação do cadastro para desocultar a div
        request.setAttribute("msgConfirmacaoCadastro", msgConfirmacaoCadastro);
        String msgSucesso = "Despesa cadastrada com sucesso!"; //msg de retorno para o usuário
        String msgErro = "Por favor, informe o valor, forma de pagamento e a data da despesa!"; //msg de retorno para o usuário
        
        //variaveis complementares
        int countDespesa2 = 0;  //contador da quantidade de despesas cadastradas
        int tipoDespesa2 = 0; //id do tipo de despesa selecionado 
        int idFormaPagamento2 = 0; //id do tipo de pagamento selecionado
        boolean deveCadastrar = true;
        boolean despesaFechada = true;
        ArrayList<PagamentoDespesasDetalhe> listaDespesasInseridas = new ArrayList(); //lista de detalhes da despesa
        Conversor conversor = new Conversor();

        //COMEÇO DOS GETS DO BANCO DE DADOS PARA O TIPO DE DESPESA E FORMA DE PAGAMENTO
        List<TipoDeDespesa> listaTipoDespesas; //lista que vai receber os dados do tipo de despesas
        List<FormaPagamento> listaTipoPagamento; //lista que vai receber os tipos de pagamento
        
        //classes de comunicação com o banco de dados
        TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL();
        TipoPagamentoSQL tipoPagamentoBanco = new TipoPagamentoSQL();
        
        try {
            //recebendo os cadastros na lista
            listaTipoDespesas = tipoDespesaBanco.getTipoDeDespesa();
            listaTipoPagamento = tipoPagamentoBanco.getFormaPagamento();
            
            //setando no response as lista
            request.setAttribute("listaTipoPagamento", listaTipoPagamento);
            request.setAttribute("listaTipoDespesas", listaTipoDespesas); 
            
        } catch (Exception ex) {
            Logger.getLogger(ControllerPreCadastroDespesa.class.getName()).log(Level.SEVERE, null, ex);
            deveCadastrar = false;
        }
        //FIM DOS GETS DO BANCO DE DADOS PARA O TIPO DE DESPESA E FORMA DE PAGAMENTO
        
        //COMEÇO DOS GETS DO REQUEST PARA OS INPUTS QUE NÃO SÃO RELACIONADOS A VALORES
        String descricaoDespesa = conversor.ConvereterString(request.getParameter("descricaoDespesa")); //descricao da despesa
       
        String tipoDespesa = request.getParameter("tipoDespesa");  //tipo de despesa
        if (tipoDespesa != null) {

            if (!tipoDespesa.equals("")) {

                tipoDespesa2 = Integer.parseInt(tipoDespesa);

            }

        }
       
        String obsDespesa = conversor.ConvereterString(request.getParameter("obsDespesa")); //observação da despesa
        //FIM DOS GETS DO REQUEST PARA OS INPUTS QUE NÃO SÃO RELACIONADOS A VALORES
        
        //COMEÇO DOS GETS DO REQUEST DINAMICOS PARA OS VALORES, QUANTIDE ETC
        //pega a quantidade de despesas adicionadas
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

                String idFormaPagamento = request.getParameter("idFormaPagamento" + (i + 1));
                if (idFormaPagamento != null) {
                    if (!idFormaPagamento.equals("")) {
                        idFormaPagamento2 = Integer.parseInt(idFormaPagamento);
                    }
                }

                String despesaIsPago = request.getParameter("despesaIsPago" + (i + 1));

                //verifica se existe
                if (dataDespesa != null && idFormaPagamento != null && despesaIsPago != null && valorDespesa != null) {
                    
                    //converte a data da despesa para o formato correto
                    dataDespesa = conversor.formatarData(dataDespesa);
                    
                    //seta valores na classe que representa
                    pagamentoDespesasDetalhe.setDataPagamento(dataDespesa);
                    pagamentoDespesasDetalhe.setValor(valorDespesa2);
                    pagamentoDespesasDetalhe.setIdFormaPagamento(idFormaPagamento2);

                    if (despesaIsPago.equals("Sim")) {
                        pagamentoDespesasDetalhe.setStatus(1);
                    } else {
                        pagamentoDespesasDetalhe.setStatus(0);
                        despesaFechada = false; //se algumas das despesas estiver marcada como "Não" 
                    }

                    //adiciona na lista
                    listaDespesasInseridas.add(pagamentoDespesasDetalhe);
                }

            }

            if (listaDespesasInseridas.size() < 1) {
                deveCadastrar = false;
            }

        } else { //se não existir 

            deveCadastrar = false;

            request.setAttribute("msgErro", msgErro);

            if (tipoDespesa2 == 0) {
                request.setAttribute("descricaoDespesa", descricaoDespesa);
            }

            request.setAttribute("obsDespesa", obsDespesa);

            //dispara para a página com a msg de erro
            request.getRequestDispatcher("despesaCadastrar.jsp").forward(request, response); // dispara para essa página            

        }
        //FIM DOS GETS DO REQUEST DINAMICOS PARA OS VALORES, QUANTIDE ETC

        //COMEÇO DO PROCESSO DE CADASTRO NO BANCO PARA A TABELA DESPESAS E DESPESAS DETALHE
        if (deveCadastrar == true) {

            int despesaFechada2 = 0;

            //instancia a classe de comunicação com o banco de dados e a entidade que representa a tabela
            DespesaSQL despesaBanco = new DespesaSQL();
            Despesas despesa = new Despesas();

            //verifica se a despesa está fechada
            if (despesaFechada == true) {
                despesaFechada2 = 1;
            } else {
                despesaFechada2 = 0;
            }

            //cadastro na tabela "despesas"
            if (tipoDespesa2 != 0) { //se for cadastro utilizando os cadatros do tipo de despesa

                TipoDeDespesa tipoDeDespesa = new TipoDeDespesa();//instancia a classe que representa o tipo de depesa
                try {
                    //recebe a despesa 
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
                PagamentoDespesasDetalheSQL detalheDespesaBanco = new PagamentoDespesasDetalheSQL();

                try {
                    //pegando o id da ultima despesa cadastrada no banco
                    int idDespesa = despesaBanco.getUltimoIdDespesas();

                    //chamando o método de creat do banco e passando a lista de despesa inserida pelo usuário e o id da ultima despesa cadastrada
                    detalheDespesaBanco.createDespesaDetalhe(listaDespesasInseridas, idDespesa);

                    request.setAttribute("msgSucesso", msgSucesso);

                    request.getRequestDispatcher("despesaCadastrar.jsp").forward(request, response); // dispara para essa página            

                } catch (Exception ex) {
                    Logger.getLogger(ControllerCadastrarDespesa.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

}
