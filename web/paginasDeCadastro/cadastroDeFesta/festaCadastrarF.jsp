<%-- 
    Document   : festaCadastrar
    Created on : 02/04/2020, 17:25:22
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros - Festa</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeFesta/paginaSelecionarCliente.css">
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../../custom/img/logoArte_E_Magia.png" id="logo-navbar">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto mb-0">
                    <!-- Botão página inicial -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp">Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../cadastros.jsp">Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../../paginasDeRelatorios/relatorios.jsp">Relatórios</a>
                    </li>                    
                    <!-- Botão relatorios -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../configAniversariante/telaConfigAniversariante.jsp">Configuração</a>                        
                    </li>
                </ul>
                <!-- Botão Sair -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/deslogar.jsp">Sair</a>
                    </li>
                </ul>
                <!-- Fim navbar da página-->                
            </div>
        </nav>
        <br>
        <div>
            <h3 id="tituloDaEtapa">1º Etapa - Selecionar Cliente</h3>
        </div>
        <!-- div da confirmação do cliente ( 1 etapa ) -->
        <div id="confirmacaoCliente"  style="display: none">
            <h4 id="clienteSelecionado"></h4>
            <br>
            <button id="btn-trocarCliente" class="btn btn-warning" onclick="trocarCliente()"> Trocar cliente </button>
            <button id="btn-2etapa"  class="btn btn-warning" onclick="etapa2()"> 2º Etapa </button>
        </div>
        <br>
        <!-- div de listagem cliente-->
        <div id="listagemDeCliente">
            <table  class="table table-secondary">
                <thead> 
                    <tr>    
                        <th scope="col">Nome</th>
                        <th scope="col">CPF/CNPJ</th>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${listaClientes}" var="item">                
                        <tr>
                            <td>${item.nomeCliente}</td>
                            <td>${item.cpf}</td>
                            <!-- botão/form para editar registro cliente --> 
                            <td>
                                <input type="hidden" id="nomeCliente${item.idCliente}" value="${item.nomeCliente}">
                                <button id="btnSelecionarCliente" onclick="selecionarCliente(${item.idCliente})" class="btn btn-warning"> Selecionar </button>                                    
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- div de selecionar aniversariante ( 2 etapa )-->
        <div id="selecionarAniversariantes" style="display: none">
            <input type="hidden" id="totalCriancas" value="${totalCriancas}"> <!-- controlador para pegar o total de criancas -->
            <input type="hidden" id="listaConcatenadaCrianca" value="${listaConcatenadaCrianca}"> <!--  controlador lista de todas as crianças que será filtrada no js -->
            <h5 id="subTituloEtapa2">Caso alguma criança não faça parte do cadastro, clique em remover!</h5>
            <table id="tabelaAniversariante" class="table table-secondary" style="display: none">
                <thead> 
                    <tr>    
                        <th scope="col">Nome da criança</th>
                        <th></th>
                    </tr>
                </thead> 
                <tbody id="tbodyAniversariantes">
                </tbody>
            </table>            
            <button class="btn btn-warning" onclick="voltarEtapa1()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa3()"> 3º Etapa </button>            
        </div>
        <!-- div de selecionar funcionario ( 3 etapa )-->
        <div id="selecionarFuncionarios" style="display: none">
            <h5>Selecione o animador ou animadora e informe seu cache e forma de pagamento, após isso clique em "Adicionar"</h5>
            <form id="formFuncionario">
                Funcionario:
                <select type="select" name="jsFuncionarios">
                    <option value="">Clique para selecionar</option>
                        <c:forEach var="item" items="${listaFuncionario}">
                            <option value="${item.idFuncionario}+${item.nomeFuncionario}">
                                ${item.nomeFuncionario}
                            </option>
                        </c:forEach>
                </select>
                Cache: <input type="text" name="jsCache">
                Forma de Pagamento:
                <select type="select" name="jsFormaPagamentoFuncionario">
                    <option value="">Clique para selecionar</option>
                        <c:forEach var="item" items="${listaFormaPagamento}">
                            <option value="${item.idFormaPagamento}+${item.nomePagamento}">
                                ${item.nomePagamento}
                            </option>
                        </c:forEach>
                </select>                
                <button type="button" id="add-funcionario">Adicionar</button> 
            </form>         
            <br>
            <table id="tabelaFuncionario" class="table table-secondary" style="display: none">
                <thead> 
                    <tr>    
                        <th>Funcionario</th>
                        <th>Cache</th>
                        <th>Forma de Pagamento</th>
                        <th></th>
                    </tr>
                </thead> 
                <tbody id="tbodyFuncionario">
                </tbody>
            </table>
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa2()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa4()"> 4º Etapa </button>            
        </div> 
        <!-- div de selecionar pacote e pacote adicional ( 4 etapa )-->        
        <div id="selecionarPacotes" style="display: none">
            <h5> Selecione o pacote do evento: </h5>
            Pacote:
            <select type="select" name="jsPacote">
                <option value="">Clique para selecionar</option>
                    <c:forEach var="item" items="${listaPacote}">
                        <option value="${item.idPacote}+${valorPacoteVenda}">
                            ${item.nomePacote}
                        </option>
                    </c:forEach>
            </select>
            <br>
            <br>
            Esse evento possui pacotes adicionais?
            <button onclick="habilitaPacoteAdicional()">Sim</button>
            <button onclick="desabilitaPacoteAdicional()">Não</button>
            <br>
            <br>
            <div id="divPacoteAdicional" style="display: none">
                <form id="formPacoteAdicional">
                    <select type="select" name="jsPacotesAdicionais">
                        <option value="">Selecionar Pacote Adicional</option>
                            <c:forEach var="item" items="${listaTipoPacoteAdicional}">
                                <option value="${item.idTipoPacoteAdicional}+${item.descricaoPacoteAdd}">
                                    ${item.descricaoPacoteAdd}
                                </option>
                            </c:forEach>
                    </select>
                    Valor:
                    <input type="text" name="jsValorPacoteAdicional" value="">
                    <button type="button" id="add-pacoteAdicional">+</button> 
                </form>
                <br>
                <table id="tabelaPacoteAdicional" class="table table-secondary" style="display: none">
                    <thead> 
                        <tr>    
                            <th>Pacote Adicional</th>
                            <th>Valor</th>
                            <th></th>
                        </tr>
                    </thead> 
                    <tbody id="tbodyPacoteAdicional">
                    </tbody>
                </table>                  
            </div>            
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa3()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa5()"> 5º Etapa </button>            
        </div>
        <!-- div de inserir valores adiconais ( 5 etapa )-->          
        <div id="inserirValorAdicional" style="display: none">
            <h5>O evento possui valores adicionais? Caso não tenha siga para a próxima etapa, caso tenha adicione a baixo:</h5>
            <form id="formValorAdicional">
                Valor:
                <input type="text" name="jsValorAdicional" value="">
                Descrição:
                <input type="text" name="jsDescricaoValorAdicional" value="">
                <button type="button" id="add-valorAdicional">Adicionar</button> 
            </form>
            <br>
            <table id="tabelaValorAdicional" class="table table-secondary" style="display: none">
                <thead> 
                    <tr>    
                        <th>Valor</th>
                        <th>Descrição</th>
                        <th></th>
                    </tr>
                </thead> 
                <tbody id="tbodyValorAdicional">
                </tbody>
            </table>
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa4()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa6()"> 6º Etapa </button>                
        </div>
        <!-- div de inserir as despesas da festa ( 6 etapa )-->          
        <div id="inserirDespesas" style="display: none">
            <h5>Adicione as despesas do evento:</h5>
            Selecione a opção de cadastro:
            <button type="button" onclick="tipoDespesa()"/>TIPO DE DESPESA</button>
            <button type="button" onclick="descricaoManual()"/>DESCRIÇÃO MANUAL</button>
            <br>
            <br>
            <form id="formAddDespesaFesta">
                Despesa:
                <input type="text" id="jsDescricaoDespesa" name="jsDescricaoDespesa" value="" style="display: none">
                <select type="select" id="jsTipoDespesa" name="jsTipoDespesa">
                    <option value="">Clique para selecionar</option>
                        <c:forEach var="item" items="${listaTipoDeDespesa}">
                            <option value="${item.idTipoDeDespesa}+${item.nomeDespesa}">
                                ${item.nomeDespesa}
                            </option>
                        </c:forEach>
                </select>
                Valor:
                <input type="text" name="jsValorDepesa" value="">
                Forma de Pagamento:
                <select type="select" name="jsFormaPagamentoDespesa">
                    <option value="">Clique para selecionar</option>
                        <c:forEach var="item" items="${listaFormaPagamento}">
                            <option value="${item.idFormaPagamento}+${item.nomePagamento}">
                                ${item.nomePagamento}
                            </option>
                        </c:forEach>
                </select>                
                Despesa paga?
                <select name="jsDespesaPaga">
                    <option>Sim</option>
                    <option>Não</option>
                </select>
                <button type="button" id="add-despesaFesta">+</button> 
            </form> 
            <table id="tabelaDespesas" class="table table-secondary" style="display: none">
                <thead> 
                    <tr>    
                        <th>Despesa</th>
                        <th>Valor</th>
                        <th>Forma de Pagamento</th>
                        <th>Pago?</th>
                        <th></th>
                    </tr>
                </thead> 
                <tbody id="tbodyDespesas">
                </tbody>
            </table>
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa5()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa7()"> 7º Etapa </button>   
        </div>        
        <!-- div de calculos do valores e formas de pagamento ( 7 etapa )-->          
        <div id="valoresEformaPagamento" style="display: none">
            <h5>AQUI VAI FICA OS CALCULOS DO VALORES</h5>
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa6()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa8()"> 8º Etapa </button>   
        </div>
        <!-- div de inserir os horarios ( 8 etapa )-->         
        <div id="inserirHorarios" style="display: none">
            <h5>Adicione os horários do evento:</h5>
            <form id="formHorario">
                Horario:
                <input type="text" name="jsHorario" value="">
                Descrição horario:
                <input type="text" name="jsDescricaoH" value="">
                <button type="button" id="add-horario">Adicionar</button> 
            </form>
            <table id="tabelaHorario" class="table table-secondary" style="display: none">
                <thead> 
                    <tr>    
                        <th>Horário</th>
                        <th>Descrição</th>
                        <th></th>
                    </tr>
                </thead> 
                <tbody id="tbodyHorario">
                </tbody>
            </table>
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa7()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa9()"> 9º Etapa </button>              
        </div>       
        <!-- div de endereço da festa ( 9 etapa )-->         
        <div id="inserirEndereco" style="display: none">
            <h5>Insira o endereço do evento:</h5>
            CEP: <input type="text" name="cep" id="cep" placeholder="CEP Logradouro">
            Cidade: <input type="text" name="cidade" id="cidade" placeholder="Cidade">
            Bairro: <input type="text" name="bairro" id="bairro" placeholder="Bairro">
            Rua: <input type="text" name="rua" id="rua" placeholder="Nome Logradouro">
            N° <input type="text" name="numero" id="numero"  placeholder="Número residência">
            Complemento: <input type="text" name="complemento" id="complemento" placeholder="Complemento">
            <br>
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa8()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa10()"> 10º Etapa </button>              
        </div>       
        <!-- div de informações adicionais ( 10 etapa )-->         
        <div id="inserirInfoAdicionais" style="display: none">
            <h5>Insira as informações finais para o cadastro:</h5>
            <br>
            Quantidade de crianças: <input type="text" name="qtdCriancaNaFesta" id="qtdCriancaNaFesta">
            Data da festa: <input type="text" name="dataFesta" id="dataFesta">
            Observação: <input type="text" name="obs" id="obs">
            Festa realizada?
            <select name="festaRealizada" id="festaRealizada">
                <option value="Não">Não</option>
                <option value="Sim">Sim</option>
            </select>
            <br>
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa9()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapaFinal()"> Etapa Final </button>              
        </div>       
        <!-- div confirmar informações ( etapa final etapa )-->         
        <div id="confirmarInformacoes" style="display: none">
            <h5>Por favor confira as informações inseridas, caso estejam corretas clique em "Finalizar cadastro"</h5>
            <br>
            <h6 id="clienteInf"></h6>
            <h6 id="criancasInf"></h6>
            <h6 id="funcionarioInf"></h6>
            <h6 id="pacoteAddInf"></h6>
            <h6 id="valoresAddInf"></h6>
            <h6 id="despesasInf"></h6>
            <h6 id="horariosInf"></h6>
            <h6 id="qtdCriancaNaFestaInf"></h6>
            <h6 id="dataDaFestaInf"></h6>
            <h6 id="ObsInf"></h6>
            <h6 id="festaRealizadaInf"></h6>
            <h6 id="enderecoFestaInf"></h6>
            <br>
            <form method="POST" id="cadastrarFestaForm" action="cadastrarFesta">
                <input type="hidden" name="cepF" id="cepF" value="">
                <input type="hidden" name="cidadeF" id="cidadeF" value="">
                <input type="hidden" name="bairroF" id="bairroF" value="">
                <input type="hidden" name="ruaF" id="ruaF" value="">
                <input type="hidden" name="numeroF" id="numeroF" value="">
                <input type="hidden" name="complementoF" id="complementoF" value="">
                <input type="hidden" name="idPacoteF" id="idPacoteF" value="">
                <input type="hidden" name="festaRealizadaF" id="festaRealizadaF" value="">
                <input type="hidden" name="observacaoF" id="observacaoF" value="">
                <input type="hidden" name="dataFestaF" id="dataFestaF" value="">
                <input type="hidden" name="qtdCriancaNaFestaF" id="qtdCriancaNaFestaF" value="">
                <input type="hidden" name="qtdCrianca" id="qtdCrianca" value="0">
                <input type="hidden" name="qtdFuncioanrio" id="qtdFuncioanrio" value="0">
                <input type="hidden" name="qtdPacoteAdicional" id="qtdPacoteAdicional" value="0">
                <input type="hidden" name="temPacoteAdicional" id="temPacoteAdicional" value="0">
                <input type="hidden" name="qtdValorAdicional" id="qtdValorAdicional" value="0">
                <input type="hidden" name="qtdHorario" id="qtdHorario" value="0">
                <input type="hidden" name="qtdDespesa" id="qtdDespesa" value="0">
                <button class="btn btn-warning" type="submit">Finalizar cadastro</button> 
            </form>
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa10()"> Voltar </button>        
        </div>        
        <br>
        <a href="festaPrincipal.jsp" type="button" class="btn btn-primary">Voltar</a>
    </body>
    <script src="../../javascripts/cadastroDeFesta/festaCadastrarF.js"></script>
    <script src="../../javascripts/cadastroDeFesta/festaCadastrarF2.js"></script>
    <script src="../../javascripts/enderecos/enderecosAutomaticos.js"></script>  
</html>
