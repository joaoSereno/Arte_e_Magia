
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.festas;

/**
 *
 * @author João Pedro
 */
import entidades.DespesaFesta;
import entidades.Enderecos;
import entidades.HorarioFesta;
import entidades.PacotesAdicionaisFesta;
import entidades.PagamentoFesta;
import entidades.ValorAdicionalFesta;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paginasDeCadastro/cadastroDeFesta/cadastrarFesta")
public class ControllerCadastrarFesta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //cliente
        int idCliente2 = 0;
        //aniversariante
        int qtdCrianca2 = 0;
        ArrayList<Integer> listaIdCriancas = new ArrayList();
        //funcionario
        int qtdFuncioanrio2 = 0;
        ArrayList<Integer> listaIdFuncionario = new ArrayList();
        //despesas da festa
        ArrayList<DespesaFesta> listaDespesaFesta = new ArrayList();
        //pacote
        int idPacote2 = 0;
        //pacote adicional
        int temPacoteAdicional2 = 0;
        int qtdPacoteAdicional2 = 0;
        ArrayList<PacotesAdicionaisFesta> listaPacotesAdicionaisFesta = new ArrayList();
        //valor adicional
        int qtdValorAdicional2 = 0;
        ArrayList<ValorAdicionalFesta> listaValorAdicionalFesta = new ArrayList();
        //despesa
        int qtdDespesa2 = 0;
        //fp e valor
        int qtdFPeValor2 = 0;
        ArrayList<PagamentoFesta> listaPagamentoFesta = new ArrayList();
        //horarios
        int qtdHorario2 = 0;
        ArrayList<HorarioFesta> listaHorarioFesta = new ArrayList();

        //COMEÇO DOS GETS DOS ELEMENTOS ENVIADOS NO FORM
        //CLIENTE
        String idCliente = request.getParameter("idCliente");
        if (idCliente != null) {
            if (!idCliente.equals("")) {

                idCliente2 = Integer.parseInt(idCliente);

            }
        }

        //ANIVERSARIANTE
        //pega a qtd de crianças
        String qtdCrianca = request.getParameter("qtdCrianca");
        if (qtdCrianca != null) {
            if (!qtdCrianca.equals("")) {

                qtdCrianca2 = Integer.parseInt(qtdCrianca);

            }
        }

        //pega dinamicamente os parametros de crianca enquanto tem qtd
        if (qtdCrianca2 != 0) {

            for (int i = 0; i < qtdCrianca2; i++) { //loop enquanto tiver criança

                String idCrianca = request.getParameter("idCrianca" + (i + 1));

                if (idCrianca != null) {
                    if (!idCrianca.equals("")) {

                        int idCrianca2 = Integer.parseInt(idCrianca);
                        //adiciona na lista de crianças
                        listaIdCriancas.add(idCrianca2);
                    }
                }

            }
        }

        //FUNCIONARIO
        //pega a qtd de funcionario
        String qtdFuncioanrio = request.getParameter("qtdFuncioanrio");
        if (qtdFuncioanrio != null) {
            if (!qtdFuncioanrio.equals("")) {

                qtdFuncioanrio2 = Integer.parseInt(qtdFuncioanrio);

            }
        }
        //pega dinamicamente os parametros de funcionario enquanto tem qtd
        if (qtdFuncioanrio2 != 0) {

            for (int i = 0; i < qtdFuncioanrio2; i++) { //loop enquanto tiver funcionario

                //instancia uma classe DespesaFesta toda vez que passar dentro do loop
                DespesaFesta despesaFesta = new DespesaFesta();

                String idFuncionario = request.getParameter("idFuncionario" + (i + 1));
                if (idFuncionario != null) {
                    if (!idFuncionario.equals("")) {

                        int idFuncionario2 = Integer.parseInt(idFuncionario);

                        //adiciona na lista de funcionario
                        listaIdFuncionario.add(idFuncionario2);

                        //seta na classe o idFuncionario
                        despesaFesta.setIdFuncionario(idFuncionario2);
                    }
                }

                String cacheFuncionario = request.getParameter("cacheFuncionario" + (i + 1));
                if (cacheFuncionario != null) {
                    if (!cacheFuncionario.equals("")) {

                        float cacheFuncionario2 = Float.parseFloat(cacheFuncionario);

                        //seta na classe o valor da despesa (cache do funcionario)
                        despesaFesta.setValorDespesa(cacheFuncionario2);

                    }
                }

                String idFormaDePagamentoFuncionario = request.getParameter("idFormaDePagamentoFuncionario" + (i + 1));
                if (idFormaDePagamentoFuncionario != null) {
                    if (!idFormaDePagamentoFuncionario.equals("")) {

                        int idFormaDePagamentoFuncionario2 = Integer.parseInt(idFormaDePagamentoFuncionario);

                        //seta na classe o idFormaDePagamento
                        despesaFesta.setIdFormaPagamento(idFormaDePagamentoFuncionario2);
                    }
                }

                despesaFesta.setStatus(0);
                despesaFesta.setIsFuncionariaPag(1);

                if (idFuncionario != null && cacheFuncionario != null && idFormaDePagamentoFuncionario != null) {
                    listaDespesaFesta.add(despesaFesta);
                }

            }
        }

        //PACOTE E PACOTE ADICIONAL
        //pega o idPacote
        String idPacote = request.getParameter("idPacoteF");
        if (idPacote != null) {
            if (!idPacote.equals("")) {

                idPacote2 = Integer.parseInt(idPacote);

            }
        }

        //pacote adicional
        //pega o input que verifica se tem pacote adicional
        String temPacoteAdicional = request.getParameter("temPacoteAdicional");
        if (temPacoteAdicional != null) {
            if (!temPacoteAdicional.equals("")) {

                temPacoteAdicional2 = Integer.parseInt(temPacoteAdicional);

            }
        }
        //verifica se tem pacote adicional, caso tenha pega a qtd e os inputs dinamicos
        if (temPacoteAdicional2 == 1) {
            //pega a qtd pacote add
            String qtdPacoteAdicional = request.getParameter("qtdPacoteAdicional");
            if (qtdPacoteAdicional != null) {
                if (!qtdPacoteAdicional.equals("")) {

                    qtdPacoteAdicional2 = Integer.parseInt(qtdPacoteAdicional);

                }
            }

            if (qtdPacoteAdicional2 != 0) {

                for (int i = 0; i < qtdPacoteAdicional2; i++) { //loop enquanto tiver pacote add

                    PacotesAdicionaisFesta pacoteAdd = new PacotesAdicionaisFesta();

                    String idPacoteAdicional = request.getParameter("idPacoteAdicional" + (i + 1));
                    if (idPacoteAdicional != null) {
                        if (!idPacoteAdicional.equals("")) {

                            int idPacoteAdicional2 = Integer.parseInt(idPacoteAdicional);

                            //seta na classe instanciada o idPacote
                            pacoteAdd.setIdTipoPacoteAdicional(idPacoteAdicional2);

                        }
                    }

                    String valorPacoteAdicional = request.getParameter("valorPacoteAdicional" + (i + 1));
                    if (valorPacoteAdicional != null) {
                        if (!valorPacoteAdicional.equals("")) {

                            float valorPacoteAdicional2 = Float.parseFloat(valorPacoteAdicional);

                            //seta na classe instanciada o valor do pacote add
                            pacoteAdd.setValorPacoteAdd(valorPacoteAdicional2);

                        }
                    }

                    if (idPacoteAdicional != null && valorPacoteAdicional != null) {
                        //adiciona o pacote add na lista de pacote add
                        listaPacotesAdicionaisFesta.add(pacoteAdd);

                    }

                }

            }

        }

        //VALORES ADICIONAIS
        //pega a qtd de valores adicionais adicionados
        String qtdValorAdicional = request.getParameter("qtdValorAdicional");
        if (qtdValorAdicional != null) {
            if (!qtdValorAdicional.equals("")) {

                qtdValorAdicional2 = Integer.parseInt(qtdValorAdicional);

            }
        }

        //pega dinamicamente os inputs dos valores adicional
        if (qtdValorAdicional2 != 0) {
            for (int i = 0; i < qtdValorAdicional2; i++) { //loop enquanto tiver valor adicional
                //instancia classe valor adional festa toda vez que passar pelo loop
                ValorAdicionalFesta valorAdicionalFesta = new ValorAdicionalFesta();

                String valorAdicional = request.getParameter("valorAdicional" + (i + 1));
                if (valorAdicional != null) {
                    if (!valorAdicional.equals("")) {

                        int valorAdicional2 = Integer.parseInt(valorAdicional);

                        //seta na classe o valor na classe instanciada
                        valorAdicionalFesta.setValor(valorAdicional2);
                    }
                }

                String descricaoValorAdicional = request.getParameter("descricaoValorAdicional" + (i + 1));
                if (descricaoValorAdicional != null) {

                    //seta na classe a descricao na classe instanciada
                    valorAdicionalFesta.setDescricao(descricaoValorAdicional);

                }

                if (valorAdicional != null && descricaoValorAdicional != null) {
                    listaValorAdicionalFesta.add(valorAdicionalFesta);
                }

            }

        }

        //DESPESA
        //pega a qtd de despesas adicionadas
        String qtdDespesa = request.getParameter("qtdDespesa");
        if (qtdDespesa != null) {
            if (!qtdDespesa.equals("")) {

                qtdDespesa2 = Integer.parseInt(qtdDespesa);

            }
        }

        //pega dinamicamente os inputs das despesas
        if (qtdDespesa2 != 0) {

            for (int i = 0; i < qtdDespesa2; i++) { //loop enquanto tiver despesa
                //cria uma classe do tipo despesa toda vez que passar pelo laço
                DespesaFesta despesaFesta = new DespesaFesta();

                String valorDespesa = request.getParameter("valorDespesa" + (i + 1));
                if (valorDespesa != null) {
                    if (!valorDespesa.equals("")) {

                        float valorDespesa2 = Float.parseFloat(valorDespesa);

                        //seta na classe instanciada o valor da despesa
                        despesaFesta.setValorDespesa(valorDespesa2);

                    }
                }

                String formaPagamentoDespesa = request.getParameter("formaPagamentoDespesa" + (i + 1));
                if (formaPagamentoDespesa != null) {
                    if (!formaPagamentoDespesa.equals("")) {

                        int formaPagamentoDespesa2 = Integer.parseInt(formaPagamentoDespesa);

                        //seta na classe instanciada o idFormaPagamento
                        despesaFesta.setIdFormaPagamento(formaPagamentoDespesa2);
                    }
                }

                String despesaPaga = request.getParameter("despesaPaga" + (i + 1));
                if (despesaPaga != null) {
                    if (despesaPaga.equals("Sim")) {
                        despesaFesta.setStatus(1);
                    } else {
                        despesaFesta.setStatus(0);
                    }
                }

                int manualOuTipoDespesa2 = 3;

                String manualOuTipoDespesa = request.getParameter("manualOuTipoDespesa" + (i + 1));
                if (manualOuTipoDespesa != null) {
                    if (!manualOuTipoDespesa.equals("")) {

                        manualOuTipoDespesa2 = Integer.parseInt(manualOuTipoDespesa);

                    }
                }

                //1 == idTipoDespesa 0 == descricao
                if (manualOuTipoDespesa2 == 1) { //se for idTipoDespesa

                    String idTipoDespesa = request.getParameter("idTipoDespesa" + (i + 1));
                    if (idTipoDespesa != null) {
                        if (!idTipoDespesa.equals("")) {

                            int idTipoDespesa2 = Integer.parseInt(idTipoDespesa);

                            //seta o idTipoDespesa na classe de despesa
                            despesaFesta.setIdTipoDeDespesa(idTipoDespesa2);

                        }
                    }

                } else if (manualOuTipoDespesa2 == 0) { //se for descricao

                    String descricaoDespesa = request.getParameter("descricaoDespesa" + (i + 1));

                    //seta a descricao na classe de despesa
                    despesaFesta.setDescricao(descricaoDespesa);
                }

                if (valorDespesa != null && formaPagamentoDespesa != null && despesaPaga != null) {
                    //adiciona a despesa na lista de despesa da festa
                    listaDespesaFesta.add(despesaFesta);
                }

            }

        }

        //FORMAS DE PAGAMENTO E VALORES
        //pega a qtd de formas de pagamento e valor  adicionados
        String qtdFPeValor = request.getParameter("qtdFPeValor");
        if (qtdFPeValor != null) {
            if (!qtdFPeValor.equals("")) {

                qtdFPeValor2 = Integer.parseInt(qtdFPeValor);

            }
        }

        //pega dinamicamente os inputs das fp
        if (qtdFPeValor2 != 0) {

            for (int i = 0; i < qtdFPeValor2; i++) {
                //instancia uma classe pagamentoFesta toda vez que passar pelo laço
                PagamentoFesta pagamentoFesta = new PagamentoFesta();

                String valorFP = request.getParameter("valorFP" + (i + 1));
                if (valorFP != null) {
                    if (!valorFP.equals("")) {

                        float valorFP2 = Float.parseFloat(valorFP);

                        // seta na classe instanciada o valor
                        pagamentoFesta.setValor(valorFP2);

                    }
                }

                String formaPagamento = request.getParameter("formaPagamento" + (i + 1));
                if (formaPagamento != null) {
                    if (!formaPagamento.equals("")) {

                        int formaPagamento2 = Integer.parseInt(formaPagamento);

                        // seta na classe instanciada o idFormaPagamento
                        pagamentoFesta.setIdFormaDePagamento(formaPagamento2);
                    }
                }

                String valorPago = request.getParameter("valorPago" + (i + 1));
                if (valorPago != null) { // 0 == NÃO PAGO ** 1 == PAGO
                    if (valorPago.equals("Sim")) {
                        pagamentoFesta.setPagamentoStatus(1);
                    } else {
                        pagamentoFesta.setPagamentoStatus(1);
                    }
                }

                //se existir pagamento adiciona na lista de pagamento
                if (valorFP != null && formaPagamento != null && valorPago != null) {
                    listaPagamentoFesta.add(pagamentoFesta);
                }
            }

        }

        //HORARIOS DO EVENTO
        //pega a qtd de horarios adicionadas
        String qtdHorario = request.getParameter("qtdHorario");
        if (qtdHorario != null) {
            if (!qtdHorario.equals("")) {

                qtdHorario2 = Integer.parseInt(qtdHorario);

            }
        }
        
        //se existir horario
        if (qtdHorario2 != 0) {
            
            //loop enquanto tiver horario
            for(int i = 0; i < qtdHorario2; i++){
                //instacia classe que representa o horario toda vez que entra no loop
                HorarioFesta horarioFesta = new HorarioFesta(); 
                
                String horario = request.getParameter("horario" + (i + 1));
                if (horario != null) {
                    horarioFesta.setHorario(horario);
                }

                String horarioDesricao = request.getParameter("horarioDesricao" + (i + 1));
                if (horarioDesricao != null) {
                    horarioFesta.setDescricao(horarioDesricao);
                }
                
                //se existir horario, adiciona lista de horarios
                if(horario != null && horarioDesricao != null){
                    listaHorarioFesta.add(horarioFesta);
                }
                
            }

        }
        
        //ENDEREÇO
        String cep = request.getParameter("cepF");
        String cidade = request.getParameter("cidadeF");
        String bairro = request.getParameter("bairroF");
        String rua = request.getParameter("ruaF");
        String numero = request.getParameter("numeroF");
        String complemento = request.getParameter("complementoF");
        
        //instancia classe de endereco e seta os valores nela
        Enderecos enderecoFesta = new Enderecos();
        enderecoFesta.setCep(cep);
        enderecoFesta.setCidade(cidade);
        enderecoFesta.setBairro(bairro);
        enderecoFesta.setRua(rua);
        enderecoFesta.setComplemento(complemento);
        enderecoFesta.setIsFesta(1);

        //INFORMAÇÕES ADICIONAIS
        String descricaoEvento = request.getParameter("descricaoEventoF");
        String qtdCriancaNaFesta = request.getParameter("qtdCriancaNaFestaF");
        String dataFesta = request.getParameter("dataFestaF");
        String idTipoDeFesta = request.getParameter("idTipoDaFestaF");
        if (idTipoDeFesta != null) {
            if (!idTipoDeFesta.equals("")) {

                int idTipoDeFesta2 = Integer.parseInt(idTipoDeFesta);

            }
        }
        
        String observacao = request.getParameter("observacaoF");
        String festaRealizada = request.getParameter("festaRealizadaF");
        
        //VALORES DA FESTA
        String valorTotalFesta = request.getParameter("valorTotalFesta");
        String valorTotalDespesa = request.getParameter("valorTotalDespesa");
        String valorTotalLucro = request.getParameter("valorTotalLucro");
        String valorReceberContratante = request.getParameter("valorReceberContratante");

        
        
        
        
        
        
        
        
        
        
        
        
        
    }

}
