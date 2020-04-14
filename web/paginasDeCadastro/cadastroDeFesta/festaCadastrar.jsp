<%-- 
    Document   : cadastroDeFesta
    Created on : 02/04/2020, 16:54:11
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
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
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeFesta/festaCadastrar.css">
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
        <h3>Cadastro de Festa - Etapa 1</h3>
        <br>
        <div>
            <form method="GET" id="listarOpcoes" action="listarOpcoes">
                <input type="hidden" id="countCliente" name="countCliente" value="${countCliente}"><!--
                <input type="hidden" id="temValorAdicional" name="temValorAdicional" value="0">-->
    <!--            <input type="hidden" id="temPagamentoAdiantado" name="temPagamentoAdiantado" value="0">-->
<!--                <input type="hidden" id="temPacotesAdicionais" name="temPacotesAdicionais" value="0">
                <input type="hidden" id="countAniversariante" name="countAniversariante" value="0">
                <input type="hidden" id="countFuncionario" name="countFuncionario" value="0">
                <input type="hidden" id="countHorario" name="countHorario" value="0">-->
    <!--            <input type="hidden" id="countFormaDePagamento" name="countFormaDePagamento" value="0">-->
<!--                <input type="hidden" id="countValorAdicional" name="countValorAdicional" value="0">-->
    <!--            <input type="hidden" id="countPagamentoAdiantado" name="countPagamentoAdiantado" value="0">-->
<!--                <input type="hidden" id="countPacotesAdicionais" name="countPacotesAdicionais" value="0">
                <input type="hidden" id="countDespesaFesta" name="countDespesaFesta" value="0">                -->
                <button type="submit">Selecionar cliente</button>
            </form>            
            <h5> Cliente: </h5> 
            <h6>${nomeCliente}</h6>
        </div>
        <br>
<!--        div aniversariante-->
        <div id="divAniversariante" style="display: none">
            <form id="formAniversariante">                
                <input type="hidden" id="countCrianca" name="countCrianca" value="${countCrianca}">
                Aniversariantes:
                <select type="select" name="jsAniversariante" >
                    <option value="">Selecionar Aniversariante</option>
                        <c:forEach var="item" items="${listaCrianca}">
                            <option value="${item.idCrianca}+${item.nomeCrianca}">
                                ${item.nomeCrianca}
                            </option>
                        </c:forEach>
                </select> 
                <button type="button" id="add-aniversariante">+</button> 
            </form> 
            <br>
            <div> 
                <table id="tabelaAniversariantes" style="display: none">
                    <thead> 
                        <tr>    
                            <th>Nome aniveráriante</th>
                            <th></th>
                        </tr>
                    </thead> 
                    <tbody id="tbodyAniversariantes">
                    </tbody>
                </table> 
            </div> 
            <br>
        </div>
<!--        div funcionario-->
        <div>
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
                <button type="button" id="add-funcionario">+</button> 
            </form>         
            <br>
            <div> 
                <table id="tabelaFuncionario" style="display: none">
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
            </div>    
        </div>
        <br>
<!--        div horario-->        
        <div>
            <form id="formHorario">
                Horario:
                <input type="text" name="jsHorario" value="">
                Descrição horario:
                <input type="text" name="jsDescricaoH" value="">
                <button type="button" id="add-horario">+</button> 
            </form>
            <br>
            <div> 
                <table id="tabelaHorario" style="display: none">
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
            </div>               
        </div>
        <br>
<!--    div despesa  -->     
        <div>
            <h5>Despesas da Festa</h5>
            <button type="button" onclick="tipoDespesa()"/>TIPO DE DESPESA</button>
            <button type="button" onclick="descricaoManual()"/>DESCRIÇÃO MANUAL</button>
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
            <div> 
                <table id="tabelaDespesas" style="display: none">
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
            </div>
        </div>   
        <br>           
<!--        div forma pagamento--> 
<!--        <div>
            <form id="formFormaPagamento">
                Forma de Pagamento:
                <select type="select" name="jsFormaPagamento">
                    <option value="">Clique para selecionar</option>
                        <c:forEach var="item" items="${listaFormaPagamento}">
                            <option value="${item.idFormaPagamento}+${item.nomePagamento}">
                                ${item.nomePagamento}
                            </option>
                        </c:forEach>
                </select>
                <button type="button" id="add-formaPagamento">+</button> 
            </form>
            <div> 
                <table id="tabelaFP" style="display: none">
                    <thead> 
                        <tr>    
                            <th>Forma de pagamento</th>
                            <th></th>
                        </tr>
                    </thead> 
                    <tbody id="tbodyFP">
                    </tbody>
                </table> 
            </div>              
        </div>
        <br> -->
<!--        div valor adicional-->
        <h6>Valor Adicional</h6>
        <button onclick="habilitaValorAdicional()">Sim</button>
        <button onclick="desabilitaValorAdicional()">Não</button>
        <br>
        <div id="divValorAdicional" style="display: none">
            <form id="formValorAdicional">
                Valor:
                <input type="text" name="jsValorAdicional" value="">
                Descrição:
                <input type="text" name="jsDescricaoValorAdicional" value="">
                <button type="button" id="add-valorAdicional">+</button> 
            </form>
            <br>
            <div> 
                <table id="tabelaValorAdicional" style="display: none">
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
            </div>              
        </div>            
        </div>    
        <br> 
<!--        div pagamento adiantado-->
<!--        <h6>Pagamento Adiantado</h6>
        <button onclick="habilitaPagamentoAdiantado()">Sim</button>
        <button onclick="desabilitaPagamentoAdiantado()">Não</button>
        <br>
        <div id="divPagamentoAdiantado" style="display: none">
            <form id="formPagamentoAdiantado">
                Valor:
                <input type="text" name="jsValorPagamentoAdiantado" value="">
                Forma de Pagamento:
                <select type="select" name="jsFormaPagamentoAdiantado">
                    <option value="">Clique para selecionar</option>
                        <c:forEach var="item" items="${listaFormaPagamento}">
                            <option value="${item.idFormaPagamento}+${item.nomePagamento}">
                                ${item.nomePagamento}
                            </option>
                        </c:forEach>
                </select>
                <button type="button" id="add-pagamentoAdiantado">+</button> 
            </form>
            <br>
            <div> 
                <table id="tabelaPagamentoAdiantado" style="display: none">
                    <thead> 
                        <tr>    
                            <th>Valor</th>
                            <th>Forma de Pagamento</th>
                            <th></th>
                        </tr>
                    </thead> 
                    <tbody id="tbodyPagamentoAdiantado">
                    </tbody>
                </table> 
            </div>             
        </div>
        <br>      -->
<!--        div pacote adicional-->
        <h6> Pacotes Adicionais </h6>
        <button onclick="habilitaPacoteAdicional()">Sim</button>
        <button onclick="desabilitaPacoteAdicional()">Não</button>
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
            <div> 
                <table id="tabelaPacoteAdicional" style="display: none">
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
        </div>
        <br>     
        <form method="POST" id="cadastrarFestaForm" action="cadastrarFesta">
            <input type="hidden" id="temValorAdicional" name="temValorAdicional" value="0">
<!--            <input type="hidden" id="temPagamentoAdiantado" name="temPagamentoAdiantado" value="0">-->
            <input type="hidden" id="temPacotesAdicionais" name="temPacotesAdicionais" value="0">
            <input type="hidden" id="countAniversariante" name="countAniversariante" value="0">
            <input type="hidden" id="countFuncionario" name="countFuncionario" value="0">
            <input type="hidden" id="countHorario" name="countHorario" value="0">
<!--            <input type="hidden" id="countFormaDePagamento" name="countFormaDePagamento" value="0">-->
            <input type="hidden" id="countValorAdicional" name="countValorAdicional" value="0">
<!--            <input type="hidden" id="countPagamentoAdiantado" name="countPagamentoAdiantado" value="0">-->
            <input type="hidden" id="countPacotesAdicionais" name="countPacotesAdicionais" value="0">
            <input type="hidden" id="countDespesaFesta" name="countDespesaFesta" value="0">
            <input type="hidden" id="" name="count" value="0">
            Pacote:
            <select type="select" name="pacote">
                <option value="">Clique para selecionar</option>
                    <c:forEach var="item" items="${listaPacote}">
                        <option value="${item.idPacote}">
                            ${item.nomePacote}
                        </option>
                    </c:forEach>
            </select>
            <br>
            <br>
            Quantidade de crianças: <input type="text" name="qtdCrianca" value="${qtdCrianca}">
            <br>
            <br>
            Data da festa: <input type="text" name="dataFesta" value="${dataFesta}">
            <br>
            <br>
            Observação: <input type="text" name="obs" value="${obs}">
            <br>
            <br>
            <h5>Endereço da Festa</h5>
            CEP: <input type="text" name="cep" id="cep" placeholder="CEP Logradouro" value="${cep}">
            Cidade: <input type="text" name="cidade" id="cidade" placeholder="Cidade" value="${cidade}" >
            Bairro: <input type="text" name="bairro" id="bairro" placeholder="Bairro" value="${bairro}">
            Rua: <input type="text" name="rua" id="rua" placeholder="Nome Logradouro" value="${rua}">
            N° <input type="text" name="numero"  placeholder="Número residência" value="${numero}">
            Complemento: <input type="text" name="complemento" placeholder="Complemento" value="${complemento}">
            <br>    
            <br>
            Festa realizada?
            <select name="festaRealida">
                <option value="Não">Não</option>
                <option value="Sim">Sim</option>
            </select>
            <button type="submit">Próxima Etapa -></button>            
        </form>        
        <br>
        <a class="btn btn-primary"  href="../cadastros.jsp">Voltar</a> 
        <input type="hidden" id="listaCriancaString" name="listaCriancaString"  value="${listaCriancaString}">
    </body>
    <script src="../../javascripts/cadastroDeFesta/festaCadastrar.js"></script>
    <script src="../../javascripts/cadastroDeFesta/festaCadastrar2.js"></script>
    <script src="../../javascripts/cadastroDeFesta/festaCadastrar3.js"></script>
    <script src="../../javascripts/enderecos/enderecosAutomaticos.js"></script>  
</html>
