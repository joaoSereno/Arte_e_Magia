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
import persistence.PagamentoDespesasDetalheSQL;
import persistence.TipoDespesaSQL;
import persistence.TipoPagamentoSQL;
import util.Conversor;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeDespesa/editarDespesa2")
public class ControllerDespesaEditar2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //variaveis globais necessarias
        boolean deveEditar = true;
        boolean despesaFechada = true;
        int idDespesas2 = 0;
        int tipoDespesa2 = 0; //id do tipo de despesa selecionado
        int countDespesa2 = 0;  //contador da quantidade de despesas cadastradas

        Conversor conversor = new Conversor();
        ArrayList<PagamentoDespesasDetalhe> listaDespesasInseridas = new ArrayList(); //lista de detalhes da despesa 

        //variaveis necesarias para mostrar mensagem de retorno ao usuario
        String msgSucesso = "Despesa editada com sucesso!"; //msg de retorno para o usuário
        String msgErro = "Por favor, informe o valor, forma de pagamento e a data da despesa!"; //msg de retorno para o usuário    

        //COISAS QUE SEMPRE TEM QUE IR PARA A PÁGINA DE EDITAR (INDEPENDENTE DE SUCESSO OU ERRO)
        //pega a origem data etc
        String origem = request.getParameter("origem");
        String exibir = request.getParameter("exibir");
        String periodoDespesa = request.getParameter("periodoDespesa");
        String periodoDespesa2 = request.getParameter("periodoDespesa2");

        //formas de pagamento e tipos de despesa do banco 
        TipoDespesaSQL tipoDespesaBanco = new TipoDespesaSQL();
        TipoPagamentoSQL tipoPagamentoBanco = new TipoPagamentoSQL();

        List<TipoDeDespesa> listaTipoDespesas = null;
        List<FormaPagamento> listaTipoPagamento;

        try {
            //recebendo os cadastros na lista
            listaTipoDespesas = tipoDespesaBanco.getTipoDeDespesa();
            listaTipoPagamento = tipoPagamentoBanco.getFormaPagamento();

            //setando no response as coisas
            request.setAttribute("listaTipoPagamento", listaTipoPagamento);
            request.setAttribute("origem", origem);
            request.setAttribute("exibir", exibir);
            request.setAttribute("periodoDespesa", periodoDespesa);
            request.setAttribute("periodoDespesa2", periodoDespesa2);

        } catch (Exception ex) {
            Logger.getLogger(ControllerPreCadastroDespesa.class.getName()).log(Level.SEVERE, null, ex);
            deveEditar = false;
        }
        //FIM COISAS QUE SEMPRE TEM QUE IR PARA A PÁGINA DE EDITAR (INDEPENDENTE DE SUCESSO OU ERRO)

        //COMEÇO DOS GETS DO REQUEST PARA OS INPUTS QUE NÃO SÃO RELACIONADOS A VALORES        
        String idDespesas = request.getParameter("idDespesas");  //id despesa

        if (idDespesas != null) {

            if (!idDespesas.equals("")) {

                idDespesas2 = Integer.parseInt(idDespesas);

            }

        }

        //pega o controller se é tipo manual ou tipo despesa
        int controllerManualOuTipoDespesa2 = 0;
        String controllerManualOuTipoDespesa = request.getParameter("controllerManualOuTipoDespesa");  //id despesa
        if (controllerManualOuTipoDespesa != null) {

            if (!controllerManualOuTipoDespesa.equals("")) {

                controllerManualOuTipoDespesa2 = Integer.parseInt(controllerManualOuTipoDespesa);

            }

        }

        String descricaoDespesa = "";
        //verifica se é descricao manual ou tipo de despesa
        if (controllerManualOuTipoDespesa2 == 1) {

            descricaoDespesa = conversor.ConvereterString(request.getParameter("descricaoDespesa")); //descricao da despesa

        } else {

            String tipoDespesa = request.getParameter("tipoDespesa");  //tipo de despesa
            if (tipoDespesa != null) {

                if (!tipoDespesa.equals("")) {

                    tipoDespesa2 = Integer.parseInt(tipoDespesa);

                }

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

            int idFormaPagamento2 = 0; //id do tipo de pagamento selecionado

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
                
                deveEditar = false;

                //controller da msg de erro e msg de erro
                request.setAttribute("msgErroController", 1);
                request.setAttribute("msgErro", msgErro);

                //instancia classe de comunicação com o banco de dados e seta o idDespesa
                Despesas despesas = new Despesas();
                despesas.setIdDespesas(idDespesas2);

                //verifica se é tipo de despesa ou manual
                if (tipoDespesa2 == 0) { //se for manual

                    despesas.setDescricaoDespesa(descricaoDespesa);

                    request.setAttribute("controllerTipoCadastroDespesa", 2);
                    request.setAttribute("listaTipoDespesas", listaTipoDespesas);

                } else { //se for tipo de despesa

                    //retira da lista o tipo de despesa selecionado e coloca no request o valor 
                    for (int x = 0; x < listaTipoDespesas.size(); x++) {

                        if (tipoDespesa2 == listaTipoDespesas.get(x).getIdTipoDeDespesa()) {

                            request.setAttribute("valorOptionTipoDespesa", tipoDespesa2 + "+" + listaTipoDespesas.get(x).getNomeDespesa());

                            listaTipoDespesas.remove(x);

                            x = listaTipoDespesas.size();

                        }

                    }

                    request.setAttribute("controllerTipoCadastroDespesa", 1);
                    request.setAttribute("listaTipoDespesas", listaTipoDespesas);

                }

                despesas.setObs(obsDespesa);

                request.setAttribute("despesas", despesas);

                request.setAttribute("totalDespesa", 0);
                request.setAttribute("valorPago", 0);
                request.setAttribute("valorApagar", 0);

                //dispara para a página com a msg de erro
                request.getRequestDispatcher("despesaEditar.jsp").forward(request, response); // dispara para essa página
                
            }

        } else { //se não existir 

            deveEditar = false;

            //controller da msg de erro e msg de erro
            request.setAttribute("msgErroController", 1);
            request.setAttribute("msgErro", msgErro);
            
            //instancia classe de comunicação com o banco de dados e seta o idDespesa
            Despesas despesas = new Despesas();
            despesas.setIdDespesas(idDespesas2);

            //verifica se é tipo de despesa ou manual
            if (tipoDespesa2 == 0) { //se for manual

                despesas.setDescricaoDespesa(descricaoDespesa);

                request.setAttribute("controllerTipoCadastroDespesa", 2);
                request.setAttribute("listaTipoDespesas", listaTipoDespesas);

            } else { //se for tipo de despesa
                
                //retira da lista o tipo de despesa selecionado e coloca no request o valor 
                for (int x = 0; x < listaTipoDespesas.size(); x++) {

                    if (tipoDespesa2 == listaTipoDespesas.get(x).getIdTipoDeDespesa()) {

                        request.setAttribute("valorOptionTipoDespesa", tipoDespesa2 + "+" + listaTipoDespesas.get(x).getNomeDespesa());

                        listaTipoDespesas.remove(x);

                        x = listaTipoDespesas.size();
                        
                    }

                }

                request.setAttribute("controllerTipoCadastroDespesa", 1);
                request.setAttribute("listaTipoDespesas", listaTipoDespesas);

            }

            despesas.setObs(obsDespesa);

            request.setAttribute("despesas", despesas);

            request.setAttribute("totalDespesa", 0);
            request.setAttribute("valorPago", 0);
            request.setAttribute("valorApagar", 0);

            //dispara para a página com a msg de erro
            request.getRequestDispatcher("despesaEditar.jsp").forward(request, response); // dispara para essa página

        }
        //FIM DOS GETS DO REQUEST DINAMICOS PARA OS VALORES, QUANTIDE ETC        

        //COMEÇO DO PROCESSO DE EDIÇÃO NO BANCO PARA A TABELA DESPESAS E DESPESAS DETALHE
        if (deveEditar == true) {

            //instancia as classes de comunicão com o banco de dados 
            PagamentoDespesasDetalheSQL detalheDespesaBanco = new PagamentoDespesasDetalheSQL();
            DespesaSQL despesaBanco = new DespesaSQL();

            Despesas despesa = new Despesas();
            despesa.setIdDespesas(idDespesas2);

            //DA UPDATE NA TABELA DESPESA COM OS DADOS ATUAIS
            //verifica se a despesa está fechada
            int despesaFechada2 = 0;
            if (despesaFechada == true) {
                despesaFechada2 = 1;
            } else {
                despesaFechada2 = 0;
            }

            //update na tabela "despesas"
            if (tipoDespesa2 != 0) { //se for despesa utilizando os cadatros do tipo de despesa

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
                    //chamando método que realiza o upadte da despesa, passando como parametro a variavel que representa a despesa
                    despesaBanco.editarDespesa(despesa);

                } catch (Exception ex) {
                    deveEditar = false;
                    Logger.getLogger(ControllerCadastrarDespesa.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else { //se for cadastro manual

                //setando na variavel que representa a despesa, os valores
                despesa.setDescricaoDespesa(descricaoDespesa);
                despesa.setObs(obsDespesa);
                despesa.setStatusDespesa(despesaFechada2);

                try {
                    //chamando método que realiza o cadastro de despesa, passando como parametro a variavel que representa a despesa
                    despesaBanco.editarDespesa(despesa);

                } catch (Exception ex) {
                    deveEditar = false;
                    Logger.getLogger(ControllerCadastrarDespesa.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //APAGA TODAS AS DESPESAS ANTIGAS CHAMANDO METODO DO BANCO E PASSANDO IDDESPESA
            if (deveEditar == true) {

                try {
                    detalheDespesaBanco.excluirDespesa(idDespesas2);
                } catch (Exception ex) {
                    deveEditar = false;
                    Logger.getLogger(ControllerDespesaEditar2.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //CRIA UMA NOVA LISTA DE PAGAMENTO DESPESA DETALHE
            //cadastro na tabela pagamentoDespesaDetalhe
            if (deveEditar == true) {

                try {

                    //chamando o método de creat do banco e passando a lista de despesa inserida pelo usuário 
                    detalheDespesaBanco.createDespesaDetalhe(listaDespesasInseridas, idDespesas2);

                    //setando msg de confirmação da exclusão e disparando para página
                    request.setAttribute("msgEdicaoController", 1);
                    request.setAttribute("msgEdicao", msgSucesso);

                    request.getRequestDispatcher("despesaPrincipal.jsp").forward(request, response); // dispara para essa página

                } catch (Exception ex) {
                    Logger.getLogger(ControllerCadastrarDespesa.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }
}
