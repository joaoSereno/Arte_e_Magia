/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.festas;

import entidades.AgendamentoFesta;
import entidades.Cliente;
import entidades.Crianca;
import entidades.DespesaFesta;
import entidades.Enderecos;
import entidades.Festa;
import entidades.FestaCrianca;
import entidades.Funcionario;
import entidades.FuncionarioFesta;
import entidades.HorarioFesta;
import entidades.Pacote;
import entidades.PacotesAdicionaisFesta;
import entidades.PagamentoFesta;
import entidades.TipoDeFesta;
import entidades.TipoPacoteAdicional;
import entidades.ValorAdicionalFesta;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.AgendamentoFestaSQL;
import persistence.ClienteSQL;
import persistence.CriancaSQL;
import persistence.DespesaFestaSQL;
import persistence.EnderecoSQL;
import persistence.FestaCriancaSQL;
import persistence.FestaSQL;
import persistence.FuncionarioFestaSQL;
import persistence.FuncionarioSQL;
import persistence.HorarioFestaSQL;
import persistence.PacoteAdicionalSQL;
import persistence.PacoteSQL;
import persistence.PacotesAdicionaisFestaSQL;
import persistence.PagamentoFestaSQL;
import persistence.TipoDeFestaSQL;
import persistence.ValorAdicionalFestaSQL;
import util.Conversor;

/**
 *
 * @author João Pedro
 */

@WebServlet("/paginasDeCadastro/cadastroDeFesta/editarFesta")
public class ControllerEdicaoFesta extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //classes e variaveis que serão usadas nesse controller
        //variaveis
        int idEventoAntigo2 = 0;
        boolean novoEventoCadastrado = false;
        
        //classes
        Conversor conversorString = new Conversor();
        AgendamentoFesta agendamentoFesta = new AgendamentoFesta();
        Festa festa = new Festa();
        
        //instancia as classes de comunicação com o banco de dados que serão utilizadas
        AgendamentoFestaSQL agendamentoFestaBanco = new AgendamentoFestaSQL();
        DespesaFestaSQL despesaFestaBanco = new DespesaFestaSQL();
        FestaCriancaSQL festaCriancaBanco = new FestaCriancaSQL();
        FestaSQL festaBanco = new FestaSQL();
        FuncionarioFestaSQL funcionarioFestaBanco = new FuncionarioFestaSQL();
        HorarioFestaSQL horarioFestaBanco = new HorarioFestaSQL();
        PacotesAdicionaisFestaSQL pacotesAdicionaisFestaBanco = new PacotesAdicionaisFestaSQL();
        PagamentoFestaSQL pagamentoFestaBanco = new PagamentoFestaSQL();
        ValorAdicionalFestaSQL valorAdicionalFestaBanco = new ValorAdicionalFestaSQL();
        EnderecoSQL enderecoBanco = new EnderecoSQL();
          
        //cria a nova festa com os dados da edição
        try {
            
            //FESTA STATUS
            String festaRealizada = request.getParameter("festaRealizadaF");
            if (festaRealizada != null) {
                if (festaRealizada.equals("Sim")) {
                    festa.setFestaStatus(1);
                } else {
                    festa.setFestaStatus(0);
                }
            }

            //COMEÇO ENDEREÇO
            //pega o endereço do request e faz a conversão de string
            String cep = request.getParameter("cepF");
            String cidade = conversorString.ConvereterString(request.getParameter("cidadeF"));
            String bairro = conversorString.ConvereterString(request.getParameter("bairroF"));
            String rua = conversorString.ConvereterString(request.getParameter("ruaF"));
            String numero = request.getParameter("numeroF");
            String complemento = conversorString.ConvereterString(request.getParameter("complementoF"));

            //instancia entidade que representa a tabela do banco de dados
            Enderecos enderecoFesta = new Enderecos();
            enderecoFesta.setCep(cep);
            enderecoFesta.setCidade(cidade);
            enderecoFesta.setBairro(bairro);
            enderecoFesta.setRua(rua);
            enderecoFesta.setNumero(numero);
            enderecoFesta.setComplemento(complemento);
            enderecoFesta.setIsFesta(1);

            //verifica se é necessario agendamento
            if (festa.getFestaStatus() == 0) {
                //Monta a String do agendamento de festa
                String localFestaAF = "<h5 class=\"list-group-item list-group-item-info\">Local do Evento:</h5>";
                String localFestaSubAf = "";

                if (!enderecoFesta.getCep().equals("")) {
                    localFestaSubAf = localFestaSubAf + "CEP: " + enderecoFesta.getCep() + " <br> ";
                }
                if (!enderecoFesta.getCidade().equals("")) {
                    localFestaSubAf = localFestaSubAf + "Cidade: " + enderecoFesta.getCidade() + " <br> ";
                }
                if (!enderecoFesta.getBairro().equals("")) {
                    localFestaSubAf = localFestaSubAf + "Bairro: " + enderecoFesta.getBairro() + " <br> ";
                }
                if (!enderecoFesta.getRua().equals("")) {
                    localFestaSubAf = localFestaSubAf + "Rua: " + enderecoFesta.getRua() + " <br> ";
                }
                if (!enderecoFesta.getNumero().equals("")) {
                    localFestaSubAf = localFestaSubAf + "Nº: " + enderecoFesta.getNumero() + " <br>";
                }
                if (!enderecoFesta.getComplemento().equals("")) {
                    localFestaSubAf = localFestaSubAf + "Complemento: " + enderecoFesta.getComplemento() + " <br> ";
                }

                localFestaAF = localFestaAF + "<p class=\"list-group-item\">" + localFestaSubAf + "</p>";

                //seta a string no agendamentoFesta
                agendamentoFesta.setLocalDaFesta(localFestaAF);

            }

            //cadastra o endereço no banco de dados
            enderecoBanco.create(enderecoFesta);

            //pega o id do endereço cadastrado
            int idEndereco = enderecoBanco.getUltimoIdEndereco();

            //seta o idEndereco na entidade da festa
            festa.setIdEnderecos(idEndereco);
            //FIM DO ENDEREÇO              
            
            //CLIENTE
            //pega do request o idCliente
            String idCliente = request.getParameter("idCliente");
            if (idCliente != null) {
                if (!idCliente.equals("")) {

                    int idCliente2 = Integer.parseInt(idCliente);

                    //adiciona o idcliente na entidade da festa
                    festa.setIdCliente(idCliente2);

                    //verifica se é necessario agendamento
                    if (festa.getFestaStatus() == 0) {
                        //adiciona o cliente no agendamento
                        //instancia classe de comunicação com o banco de dados e entidade que representa a tabela do cliente
                        ClienteSQL clienteBanco = new ClienteSQL();
                        Cliente cliente = new Cliente();

                        //recebe do banco o dados os dados
                        cliente = clienteBanco.getClienteEspecifico(idCliente2);

                        //monta string do agendamento e seta ela na entidade do agendamento
                        String clienteAF = "<h5  class=\"list-group-item list-group-item-info\">Nome do Contrante:</h5><p class=\"list-group-item\">" + cliente.getNomeCliente() + "</p>";

                        agendamentoFesta.setContratante(clienteAF);
                    }

                }
            }            
            
            //PACOTE
            String idPacote = request.getParameter("idPacoteF");
            if (idPacote != null) {
                if (!idPacote.equals("")) {

                    int idPacote2 = Integer.parseInt(idPacote);

                    //adiciona o idPacote na entidade da festa
                    festa.setIdPacote(idPacote2);

                    //verifica se é necessario agendamento
                    if (festa.getFestaStatus() == 0) {
                        //adiciona o pacote no agendamento
                        //instancia classe de comunicação com o banco de dados e entidade que representa a tabela do pacote
                        PacoteSQL pacoteBanco = new PacoteSQL();
                        Pacote pacote = new Pacote();

                        //recebe do banco os dados
                        pacote = pacoteBanco.getPacoteEspecifico(idPacote2);

                        //monta string do agendamento e seta ela na entidade do agendamento
                        String pacoteAF = "<h5 class=\"list-group-item list-group-item-info\">Pacote:</h5><p class=\"list-group-item\">" + pacote.getNomePacote() + "</p>";

                        agendamentoFesta.setPacote(pacoteAF);
                    }
                }
            }

            //COMEÇO DOS VALORES FINAIS
            //VALOR TOTAL EVENTO
            String valorTotalFesta = request.getParameter("valorTotalFesta");
            if (valorTotalFesta != null) {
                if (!valorTotalFesta.equals("")) {

                    //converte o valor para float e add na festa
                    float valorTotalFesta2 = Float.parseFloat(valorTotalFesta);
                    festa.setValorTotal(valorTotalFesta2);

                }
            }
            
            //DESCONTO DO EVENTO
            String descontoEvento = request.getParameter("descontoEvento");
            if (descontoEvento != null) {
                if (!descontoEvento.equals("")) {

                    //converte o valor para float e add na festa
                    float descontoEvento2 = Float.parseFloat(descontoEvento);
                    festa.setDescontoEvento(descontoEvento2);

                }
            }            

            //VALOR TOTAL DESPESA
            String valorTotalDespesa = request.getParameter("valorTotalDespesa");
            if (valorTotalDespesa != null) {
                if (!valorTotalDespesa.equals("")) {

                    //converte o valor para float e add na festa
                    float valorTotalDespesa2 = Float.parseFloat(valorTotalDespesa);
                    festa.setTotalDespesa(valorTotalDespesa2);
                }
            }

            //VALORES DE LUCRO
            String valorTotalLucro = request.getParameter("valorTotalLucro");
            if (valorTotalLucro != null) {
                if (!valorTotalLucro.equals("")) {

                    //converte o valor para float e add na festa
                    float valorTotalLucro2 = Float.parseFloat(valorTotalLucro);
                    festa.setLucroFesta(valorTotalLucro2);

                }
            }

            //VALOR A PEGAR CONTRATANTE
            String valorReceberContratante = request.getParameter("valorReceberContratante");
            if (valorReceberContratante != null) {
                if (!valorReceberContratante.equals("")) {

                    //verifica se é necessario agendamento
                    if (festa.getFestaStatus() == 0) {
                        //adiciona o valor no agendamento de festa
                        String receberContratanteAF = "<h5 class=\"list-group-item list-group-item-info\">Valor a receber com contratante:</h5><p class=\"list-group-item\">R$" + valorReceberContratante + "</p>";
                        agendamentoFesta.setValorPegarContratante(receberContratanteAF);
                    }

                    //converte o valor para float e add na festa
                    float valorReceberContratante2 = Float.parseFloat(valorReceberContratante);
                    festa.setReceberContrante(valorReceberContratante2);
                }
            }
            //FIM DOS VALORES FINAIS      
            
            //COMEÇO INFORMAÇÕES FINAIS
            //DESCRICAO DO EVENTO
            String descricaoEvento = conversorString.ConvereterString(request.getParameter("descricaoEventoF"));
            festa.setDescricaoFesta(descricaoEvento); //adiciona na festa a descricao

            //verifica se é necessario agendamento
            if (festa.getFestaStatus() == 0) {

                String descricaoEventoAF = "<h5  class=\"list-group-item list-group-item-info\">Descrição do Evento:</h5><p class=\"list-group-item\">" + descricaoEvento + "</p>";

                agendamentoFesta.setDescricaoFesta(descricaoEventoAF); //adiciona na agendamentoFesta   
            }

            //QTD DE CRIANCA
            //pega a qtd de crianca  do request
            String qtdCriancaNaFesta = request.getParameter("qtdCriancaNaFestaF");
            if (qtdCriancaNaFesta != null) {
                if (!qtdCriancaNaFesta.equals("")) {

                    int qtdCriancaNaFesta2 = Integer.parseInt(qtdCriancaNaFesta);

                    //adiciona na festa a qtd crianca
                    festa.setQtdCriancas(qtdCriancaNaFesta2);

                    //verifica se é necessario agendamento
                    if (festa.getFestaStatus() == 0) {
                        //adiciona na agendamentoFesta
                        String qtdCriancaAF = "<h5 class=\"list-group-item list-group-item-info\">Quantidade de Crianças:</h5><p class=\"list-group-item\">";
                        qtdCriancaAF = qtdCriancaAF + Integer.toString(qtdCriancaNaFesta2) + "</p>";

                        agendamentoFesta.setQtdCriancas(qtdCriancaAF);
                    }

                }
            }

            //DATA DA FESTA
            String dataFesta = request.getParameter("dataFestaF");
            //converte a data da festa para o formato correto
            dataFesta = conversorString.formatarData(dataFesta);
            //seta na festa
            festa.setDataFesta(dataFesta);

            //verifica se é necessario agendamento
            if (festa.getFestaStatus() == 0) {
                agendamentoFesta.setDataEvento(dataFesta); //seta no agendamento de festa
            }

            //OBSERVAÇÃO
            //pega a obs do request
            String observacao = conversorString.ConvereterString(request.getParameter("observacaoF"));
            festa.setObs(observacao); //adiciona na festa
            //verifica se é necessario agendamento
            if (festa.getFestaStatus() == 0) {
                agendamentoFesta.setObservacaoFesta("<h5 class=\"list-group-item list-group-item-info\">Observações:</h5><p class=\"list-group-item\">" + observacao + "</p>"); //adiciona no agendamento
            }

            //TIPO DE FESTA
            //pego o idTipoDeFesta do request
            String idTipoDeFesta = request.getParameter("idTipoDaFestaF");
            if (idTipoDeFesta != null) {
                if (!idTipoDeFesta.equals("")) {

                    int idTipoDeFesta2 = Integer.parseInt(idTipoDeFesta);

                    //adiciona o id na festa
                    festa.setIdTipoDeFesta(idTipoDeFesta2);

                    //verifica se é necessario agendamento
                    if (festa.getFestaStatus() == 0) {
                        //adiciona no agendamento
                        //instancia classe de comunicação com o banco de dados e entidade que representa a tabela do tipo de festa
                        TipoDeFestaSQL tipoDeFestaBanco = new TipoDeFestaSQL();
                        TipoDeFesta tipoDeFesta = new TipoDeFesta();

                        //recebe do banco o dados do tipo de evento
                        tipoDeFesta = tipoDeFestaBanco.getTipoPacoteAdicionalEspecifico(idTipoDeFesta2);

                        //monta string do agendamento e seta ela na entidade do agendamento
                        String tipoEventoAF = "<h5  class=\"list-group-item list-group-item-info\">Tipo do Evento:</h5><p class=\"list-group-item\">" + tipoDeFesta.getDescricaoTipoDeFesta() + "</p>";

                        agendamentoFesta.setTipoDeFesta(tipoEventoAF);
                    }

                }
            }
            //FIM INFORMAÇÕES FINAIS
            
            //CADASTRA A FESTA NO BANCO DE DADO
            //realiza o cadastro no banco passando como parametro a entidade da festa
            festaBanco.create(festa);

            //pega o id da festa cadastrada que vai passar como FK das tabelas secundarias
            int idFesta = festaBanco.getUltimoIdFesta();

            //COMEÇO DOS PROCESSAMENTO DAS TABELAS SECUNDARIAS
            //ANIVERSARIANTES
            int qtdCrianca2 = 0;

            //pega a qtd de crianças
            String qtdCrianca = request.getParameter("qtdCrianca");
            if (qtdCrianca != null) {
                if (!qtdCrianca.equals("")) {

                    qtdCrianca2 = Integer.parseInt(qtdCrianca);

                }
            }

            //pega dinamicamente os parametros de crianca enquanto tem qtd
            if (qtdCrianca2 != 0) {
                //variavel do texto de agendamento de festa
                String aniversariantesAF = "";
                int countTexto = 0;

                for (int i = 0; i < qtdCrianca2; i++) { //loop enquanto tiver criança

                    //instancia entidade que representa os aniversariantes
                    FestaCrianca festaCrianca = new FestaCrianca();

                    //pega o idCrianca do request
                    String idCrianca = request.getParameter("idCrianca" + (i + 1));

                    //se existir crianca
                    if (idCrianca != null) {
                        if (!idCrianca.equals("")) {

                            int idCrianca2 = Integer.parseInt(idCrianca);

                            //seta o valor na entidade festaCrianca
                            festaCrianca.setIdCrianca(idCrianca2);
                            festaCrianca.setIdFesta(idFesta);

                            //realiza o cadastro do registro no banco
                            festaCriancaBanco.create(festaCrianca);

                            //verifica se é necessario agendamento
                            if (festa.getFestaStatus() == 0) {

                                //instancia a classe de comunicação do banco e entidade crianca
                                CriancaSQL criancaBanco = new CriancaSQL();
                                Crianca crianca = new Crianca();

                                //recebe os dados da crianca adicionada
                                crianca = criancaBanco.getCriancaEspecifica(idCrianca2);

                                //define o texto agendamento de festa
                                if (countTexto == 0) {
                                    countTexto++;
                                    aniversariantesAF = aniversariantesAF + "<h5 class=\"list-group-item list-group-item-info\">Aniversariante:</h5><p class=\"list-group-item\">" + crianca.getNomeCrianca();
                                } else {
                                    aniversariantesAF = aniversariantesAF + " & " + crianca.getNomeCrianca();
                                }

                            }

                        }
                    }

                }
                //verifica se é necessario agendamento
                if (festa.getFestaStatus() == 0) {

                    if (!aniversariantesAF.equals("")) {
                        aniversariantesAF = aniversariantesAF + "</p>";
                    }

                    //adiciona a string montada no loop na entidade de agendamento
                    agendamentoFesta.setAniversariante(aniversariantesAF);
                }

            }
            //FIM ANIVERSARIANTE

            //FUNCIONARIO
            int qtdFuncionario2 = 0;

            //pega a quantidade de funcionario
            String qtdFuncionario = request.getParameter("qtdFuncioanrio");
            if (qtdFuncionario != null) {
                if (!qtdFuncionario.equals("")) {

                    qtdFuncionario2 = Integer.parseInt(qtdFuncionario);

                }
            }

            //se existir funcionario
            if (qtdFuncionario2 != 0) {

                String funcionarioInfAF = "<h5 class=\"list-group-item list-group-item-info\">Colaboradores:</h5><p class=\"list-group-item\">";

                //instancia classe de comunicação com o banco de dados
                FuncionarioSQL funcionarioBanco = new FuncionarioSQL();

                for (int i = 0; i < qtdFuncionario2; i++) { //laço na quantidade de funcionario

                    //pega os inputs do request dinamicamente                            
                    String idFuncionario = request.getParameter("idFuncionario" + (i + 1)); //pega qual é o funcionario
                    String cacheFuncionario = request.getParameter("cacheFuncionario" + (i + 1));  //qual é o cache do funcionario                
                    String idFormaDePagamentoFuncionario = request.getParameter("idFormaDePagamentoFuncionario" + (i + 1)); //qual a forma de pagamento do cache

                    //verifica se existe valor 
                    if (idFuncionario != null && cacheFuncionario != null && idFormaDePagamentoFuncionario != null) {
                        if (!idFuncionario.equals("") && !cacheFuncionario.equals("") && !idFormaDePagamentoFuncionario.equals("")) {

                            //converte os valores de string para o tipo correto
                            int idFuncionario2 = Integer.parseInt(idFuncionario);
                            float cacheFuncionario2 = Float.parseFloat(cacheFuncionario);
                            int idFormaDePagamentoFuncionario2 = Integer.parseInt(idFormaDePagamentoFuncionario);

                            //instancia as entidades que representa a tabela do BD
                            FuncionarioFesta funcionarioFesta = new FuncionarioFesta();
                            DespesaFesta despesaFesta = new DespesaFesta();

                            //seta os valores nas entidades
                            //funcionarioFesta
                            funcionarioFesta.setIdFuncionario(idFuncionario2);
                            funcionarioFesta.setCacheFesta(cacheFuncionario2);
                            funcionarioFesta.setIdFesta(idFesta);

                            //despesaFesta
                            despesaFesta.setIdFuncionario(idFuncionario2);
                            despesaFesta.setValorDespesa(cacheFuncionario2);
                            despesaFesta.setIdFormaPagamento(idFormaDePagamentoFuncionario2);
                            despesaFesta.setDescricao("Pagamento de funcionário");
                            despesaFesta.setIsFuncionariaPag(1);
                            despesaFesta.setStatus(1);
                            despesaFesta.setIdFesta(idFesta);

                            //cadastra no banco
                            funcionarioFestaBanco.create(funcionarioFesta);
                            despesaFestaBanco.create(despesaFesta);

                            //verifica se é necessario o agendamento
                            if (festa.getFestaStatus() == 0) {
                                //instancia a entidade do funcionario
                                Funcionario funcionario = new Funcionario();

                                //pega o nome do funcionario do banco
                                funcionario = funcionarioBanco.getFuncionarioEspecifico(idFuncionario2);

                                //monta o texto do agendamento
                                funcionarioInfAF = funcionarioInfAF + funcionario.getNomeFuncionario() + " -  Cache: R$" + cacheFuncionario2 + "<br>";

                            }
                        }
                    }
                }
                //verifica se é necessario agendamento
                if (festa.getFestaStatus() == 0) {

                    funcionarioInfAF = funcionarioInfAF + "</p>";

                    //adiciona a string montada no loop na entidade de agendamento
                    agendamentoFesta.setCacheFuncionarios(funcionarioInfAF);
                }
            }
            //FIM FUNCIONARIO

            //COMEÇO PACOTE ADICIONAL
            int temPacoteAdicional2 = 0;

            //pega o input que verifica se tem pacote adicional
            String temPacoteAdicional = request.getParameter("temPacoteAdicional");
            if (temPacoteAdicional != null) {
                if (!temPacoteAdicional.equals("")) {

                    temPacoteAdicional2 = Integer.parseInt(temPacoteAdicional);

                }
            }

            //se tiver pacote adicional
            if (temPacoteAdicional2 == 1) {
                int qtdPacoteAdicional2 = 0;

                //pega a quantidade do request
                String qtdPacoteAdicional = request.getParameter("qtdPacoteAdicional");
                if (qtdPacoteAdicional != null) {
                    if (!qtdPacoteAdicional.equals("")) {
                        //converte para inteiro a quantidade
                        qtdPacoteAdicional2 = Integer.parseInt(qtdPacoteAdicional);

                    }
                }

                //string que vai o texto do agendamento
                String pacoteAdicionalAF = "";
                int countText = 0;

                //instancia a classe de comunicação com o banco de dados do pacote adicional
                PacoteAdicionalSQL pacoteAdicionalBanco = new PacoteAdicionalSQL();

                for (int i = 0; i < qtdPacoteAdicional2; i++) { //loop enquanto tiver pacote add

                    //pega os inputs do request dinamicamente    
                    String idPacoteAdicional = request.getParameter("idPacoteAdicional" + (i + 1));
                    String valorPacoteAdicional = request.getParameter("valorPacoteAdicional" + (i + 1));

                    //verifica se existe valor 
                    if (idPacoteAdicional != null && valorPacoteAdicional != null) {
                        if (!idPacoteAdicional.equals("") && !valorPacoteAdicional.equals("")) {

                            //se existir converte os valores do input de string para o tipo correto
                            int idPacoteAdicional2 = Integer.parseInt(idPacoteAdicional);
                            float valorPacoteAdicional2 = Float.parseFloat(valorPacoteAdicional);

                            //instancia as entidades que representa a tabela do BD
                            PacotesAdicionaisFesta pacoteAddFesta = new PacotesAdicionaisFesta();

                            //seta os valores nas entidades
                            pacoteAddFesta.setIdTipoPacoteAdicional(idPacoteAdicional2);
                            pacoteAddFesta.setValorPacoteAdd(valorPacoteAdicional2);
                            pacoteAddFesta.setIdFesta(idFesta);

                            //cadastra o no banco
                            pacotesAdicionaisFestaBanco.create(pacoteAddFesta);

                            //verifica se é necessario agendamento
                            if (festa.getFestaStatus() == 0) {
                                //instancia a entidade do pacote add
                                TipoPacoteAdicional pacoteAdicional = new TipoPacoteAdicional();

                                //pega o nome do funcionario do banco
                                pacoteAdicional = pacoteAdicionalBanco.getTipoPacoteAdicionalEspecifico(idPacoteAdicional2);

                                //monta o texto do agendamento
                                if (countText == 0) {
                                    countText++;
                                    pacoteAdicionalAF = pacoteAdicionalAF + "<h5 class=\"list-group-item list-group-item-info\">Adicional no Pacote:</h5><p class=\"list-group-item\">" + pacoteAdicional.getDescricaoPacoteAdd();
                                } else {
                                    pacoteAdicionalAF = pacoteAdicionalAF + " & " + pacoteAdicional.getDescricaoPacoteAdd();
                                }
                            }
                        }
                    }
                }
                //verifica se é necessario agendamento
                if (festa.getFestaStatus() == 0) {

                    if (!pacoteAdicionalAF.equals("")) {
                        pacoteAdicionalAF = pacoteAdicionalAF + "</p>";
                    }

                    //adiciona a string montada no loop na entidade de agendamento
                    agendamentoFesta.setPacotesAdicionais(pacoteAdicionalAF);
                }

            }
            //FIM PACOTE ADICIONAL

            //COMEÇO HORARIO
            int qtdHorario2 = 0;

            //pega a qtd de horarios adicionadas do request
            String qtdHorario = request.getParameter("qtdHorario");
            if (qtdHorario != null) {
                if (!qtdHorario.equals("")) {

                    qtdHorario2 = Integer.parseInt(qtdHorario);

                }
            }

            //se existir horario
            if (qtdHorario2 != 0) {

                String horarioFestaAG = "<h5 class=\"list-group-item list-group-item-info\">Horários:</h5><p class=\"list-group-item\">";

                //loop enquanto tiver horario
                for (int i = 0; i < qtdHorario2; i++) {

                    //pega o request dinamicamente
                    String horario = request.getParameter("horario" + (i + 1));
                    String horarioDesricao = request.getParameter("horarioDesricao" + (i + 1));

                    //verifica se existe valor
                    if (horario != null && horarioDesricao != null) {
                        //realiza a conversão do texto
                        horarioDesricao = conversorString.ConvereterString(horarioDesricao);

                        //instancia as entidades que representa a tabela do BD
                        HorarioFesta horarioFesta = new HorarioFesta();

                        //seta os valores nas entidades
                        horarioFesta.setHorario(horario);
                        horarioFesta.setDescricao(horarioDesricao);
                        horarioFesta.setIdFesta(idFesta);

                        //cadastra o no banco
                        horarioFestaBanco.create(horarioFesta);

                        //verifica se é necessario agendamento
                        if (festa.getFestaStatus() == 0) {
                            //monta o texto de agendamento
                            horarioFestaAG = horarioFestaAG + horario + " - " + horarioDesricao + "<br>";
                        }

                    }
                }
                
                //verifica se é necessario agendamento
                if (festa.getFestaStatus() == 0) {
                    
                    horarioFestaAG = horarioFestaAG + "</p>";
                    
                    //adiciona na entidade de agendamento
                    agendamentoFesta.setHorarios(horarioFestaAG);
                }

            }
            //FIM HORARIO  

            //INICIO DO CADASTRO DO AGENDAMENTO DE FESTA
            if (festa.getFestaStatus() == 0) {
                //adiciona de qual festa pertence o agendamento
                agendamentoFesta.setIdFesta(idFesta);

                //cadastra no banco de dados
                agendamentoFestaBanco.create(agendamentoFesta);
            }
            //FIM DO CADASTRO DO AGENDAMENTO DE FESTA

            //VALORES ADICIONAIS
            int qtdValorAdicional2 = 0;

            //pega a qtd de valores adicionais adicionados do request
            String qtdValorAdicional = request.getParameter("qtdValorAdicional");
            if (qtdValorAdicional != null) {
                if (!qtdValorAdicional.equals("")) {

                    qtdValorAdicional2 = Integer.parseInt(qtdValorAdicional);

                }
            }

            //se existir valor adicional
            if (qtdValorAdicional2 != 0) {
                //loop enquanto tiver valor adicional
                for (int i = 0; i < qtdValorAdicional2; i++) {

                    //pega os inputs do request dinamicamente 
                    String valorAdicional = request.getParameter("valorAdicional" + (i + 1));
                    String descricaoValorAdicional = request.getParameter("descricaoValorAdicional" + (i + 1));

                    //verifica se existe valor 
                    if (valorAdicional != null && descricaoValorAdicional != null) {
                        if (!valorAdicional.equals("") && !valorAdicional.equals("")) {

                            //se existir converte os valores do input para o tipo correto
                            float valorAdicional2 = Float.parseFloat(valorAdicional);
                            descricaoValorAdicional = conversorString.ConvereterString(descricaoValorAdicional);

                            //instancia entidade do valor adicional
                            ValorAdicionalFesta valorAdicionalFesta = new ValorAdicionalFesta();

                            //seta os valores na entidade
                            valorAdicionalFesta.setValor(valorAdicional2);
                            valorAdicionalFesta.setDescricao(descricaoValorAdicional);
                            valorAdicionalFesta.setIdFesta(idFesta);

                            //cadastra o no banco
                            valorAdicionalFestaBanco.create(valorAdicionalFesta);

                        }

                    }

                }
            }
            //FIM VALORES ADICIONAIS

            //DESPESA
            int qtdDespesa2 = 0;

            //pega a qtd de despesas adicionadas
            String qtdDespesa = request.getParameter("qtdDespesa");
            if (qtdDespesa != null) {
                if (!qtdDespesa.equals("")) {

                    qtdDespesa2 = Integer.parseInt(qtdDespesa);

                }
            }

            //se tiver despesa
            if (qtdDespesa2 != 0) {
                //loop enquanto tiver despesa
                for (int i = 0; i < qtdDespesa2; i++) {
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

                    //se existir despesa
                    if (valorDespesa != null && formaPagamentoDespesa != null && despesaPaga != null) {

                        despesaFesta.setIsFuncionariaPag(0);
                        despesaFesta.setIdFesta(idFesta);

                        //cadastra no banco de dados
                        despesaFestaBanco.create(despesaFesta);
                    }

                }

            }
            //FIM DESPESA

            //FORMAS DE PAGAMENTO E VALORES
            int qtdFPeValor2 = 0;

            String qtdFPeValor = request.getParameter("qtdFPeValor");
            if (qtdFPeValor != null) {
                if (!qtdFPeValor.equals("")) {

                    qtdFPeValor2 = Integer.parseInt(qtdFPeValor);

                }
            }
            //se existir pagamento
            if (qtdFPeValor2 != 0) {
                //loop enquanto tiver pagamento
                for (int i = 0; i < qtdFPeValor2; i++) {

                    //pega os inputs do request dinamicamente 
                    String valorFP = request.getParameter("valorFP" + (i + 1));
                    String formaPagamento = request.getParameter("formaPagamento" + (i + 1));
                    String valorPago = request.getParameter("valorPago" + (i + 1));

                    //verifica se existe valor 
                    if (valorFP != null && formaPagamento != null && valorPago != null) {
                        if (!valorFP.equals("") && !formaPagamento.equals("") && !valorPago.equals("")) {

                            //se existir converte os valores do input para o tipo correto
                            float valorFP2 = Float.parseFloat(valorFP);
                            int formaPagamento2 = Integer.parseInt(formaPagamento);

                            //instancia entidade do pagamento
                            PagamentoFesta pagamentoFesta = new PagamentoFesta();

                            //seta os valores na entidade
                            pagamentoFesta.setValor(valorFP2);
                            pagamentoFesta.setIdFormaDePagamento(formaPagamento2);
                            pagamentoFesta.setIdFesta(idFesta);
                            if (valorPago.equals("Sim")) {  // 0 == NÃO PAGO ** 1 == PAGO
                                pagamentoFesta.setPagamentoStatus(1);
                            } else {
                                pagamentoFesta.setPagamentoStatus(0);
                            }

                            //cadastra o no banco
                            pagamentoFestaBanco.create(pagamentoFesta);

                        }

                    }

                }
            }
            //FIM FORMAS DE PAGAMENTO E VALORES 
            
            //seta que deu certo o cadastro
            novoEventoCadastrado = true;
                        
        } catch (Exception ex) {
            Logger.getLogger(ControllerEdicaoFesta.class.getName()).log(Level.SEVERE, null, ex);
            
            novoEventoCadastrado = false;
            request.setAttribute("controllerEdicaoEvento", 1);
            request.setAttribute("msgEdicaoFestaErro", "Desculpe não foi possível editar o evento! =( ");
            request.getRequestDispatcher("festaPrincipal.jsp").forward(request, response);  
        }
              
        //apaga os dados antigos da festa
        if(novoEventoCadastrado){ //se deu certo o cadastro
            
            String idEvento = request.getParameter("idEvento");
            if (idEvento != null) {
                if (!idEvento.equals("")) {

                    idEventoAntigo2 = Integer.parseInt(idEvento);

                }
            }  
            
            try {
                //instancia classe que representa a fest
                Festa eventoAntigo = new Festa();
                
                //recebe os dados do evento 
                eventoAntigo = festaBanco.getFestaEspecifica(idEventoAntigo2);
                
                //deleta os dados de todas as tabelas vinculadas a festa
                agendamentoFestaBanco.excluir(idEventoAntigo2);
                despesaFestaBanco.excluir(idEventoAntigo2);        
                festaCriancaBanco.excluir(idEventoAntigo2);
                funcionarioFestaBanco.excluir(idEventoAntigo2);
                horarioFestaBanco.excluir(idEventoAntigo2);        
                pacotesAdicionaisFestaBanco.excluir(idEventoAntigo2);      
                pagamentoFestaBanco.excluir(idEventoAntigo2);        
                valorAdicionalFestaBanco.excluir(idEventoAntigo2);
                
                //deleta a festa
                festaBanco.excluir(idEventoAntigo2);
                
                //deleta o endereço da festa
                enderecoBanco.excluir(eventoAntigo.getIdEnderecos());
                
                request.setAttribute("controllerEdicaoEvento", 1);
                request.setAttribute("msgEdicaoFesta", "Evento editado com sucesso!");
                request.getRequestDispatcher("festaPrincipal.jsp").forward(request, response);                
                
            } catch (Exception ex) {
                
                Logger.getLogger(ControllerEdicaoFesta.class.getName()).log(Level.SEVERE, null, ex);
                
                request.setAttribute("controllerEdicaoEvento", 1);
                request.setAttribute("msgEdicaoFestaErro", "Desculpe ocorreu um problema na edição do evento! =( ");
                request.getRequestDispatcher("festaPrincipal.jsp").forward(request, response);  
                
            }            
        }    

    }
    
}
