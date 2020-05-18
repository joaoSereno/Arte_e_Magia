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
        <meta name="viewport" content="width=device-width, initial-scale=1">         
        <title>Cadastros - Evento</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT" crossorigin="anonymous"></script>        
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customização -->   
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeFesta/festaCadastrar.css">
<!--<style>
	div{
		border: solid 1px blue;
	}
</style>-->


    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../../custom/img/logoFundoLogin.png" id="logo-navbar">
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon navbar-light"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto">
                    <!-- Botão página inicial -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp"><i class="fas fa-home"></i>&nbsp;Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="../cadastros.jsp"><i class="far fa-address-book"></i>&nbsp;Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="../../paginasDeRelatorios/relatorios.jsp"><i class="far fa-clipboard"></i>&nbsp;Relatórios</a>
                    </li>                    
                    <!-- Botão relatorios -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="../configAniversariante/telaConfigAniversariante.jsp"><i class="fas fa-cog"></i>&nbsp;Configuração</a>                        
                    </li>
                </ul>
                <!-- Botão Sair -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item h5">
                        <a class="nav-link" href="/Arte-E-Magia_tst/deslogar.jsp"><i class="fas fa-sign-out-alt"></i>&nbsp;Sair</a>
                    </li>
                </ul>
                <!-- Fim navbar da página-->                
            </div>
        </nav>
        <!-- titulo da etapa -->
        <div class="jumbotron text-center">
            <h1 id="tituloDaEtapa">1º Etapa - Contratante</h1>
        </div> 

<!-- 1 etapa -->
<!-- div de listagem cliente-->
<div class="container" id="listagemDeCliente">

    <div class="row justify-content-center">

        <div class="col-sm-12 col-md-12 col-lg-12">

            <div class="col-lg-12">

                <h3> Por favor selecione o contratante do evento: </h3>

            </div>

            <div class="col-lg-12">

                <div class="table-responsive border border-secondary rounded">
                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr class="bg-info">
                                <th scope="col">Nome</th>
                                <th scope="col">CPF/CNPJ</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaClientes}" var="item">
                                <tr>
                                    <td>${item.nomeCliente}</td>
                                    <td>${item.cpf}</td>
                                    <!-- botão/form para editar registro cliente -->
                                    <td>
                                        <input type="hidden" id="nomeCliente${item.idCliente}"
                                            value="${item.nomeCliente}">
                                        <button id="btnSelecionarCliente" onclick="selecionarCliente(${item.idCliente})"
                                            class="btn btn-info"> Selecionar </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>

        </div>

    </div>

</div>

<!-- div de confirmação cliente-->

<div class="container" id="confirmacaoCliente" style="display: none">

    <div class="row justify-content-center">

        <div class="col-sm-12 col-md-12 col-lg-12">

            <div class="row">

                <div class="col-lg-12">

                    <h2 id="clienteSelecionado" class="text-center"></h2>

                </div>

            </div>

            <div class="row mt-2">

                <div class="col-lg-6 my-2">

                    <button id="btn-trocarCliente" type="submit" class="btn btn-secondary btn-lg btn-block"
                        onclick="trocarCliente()"> Trocar Contratante </button>

                </div>

                <div class="col-lg-6 my-2">

                    <button id="btn-2etapa" class="btn btn-info btn-lg btn-block" onclick="etapa2()"> 2º Etapa </button>

                </div>

            </div>

        </div>

    </div>

</div>
<!-- fim 1 etapa -->

<!-- 2 etapa -->
<!-- div de selecionar aniversariante ( 2 etapa ) -->
<div class="container" id="selecionarAniversariantes" style="display: none">

    <input type="hidden" id="totalCriancas" value="${totalCriancas}">
    <input type="hidden" id="listaConcatenadaCrianca" value="${listaConcatenadaCrianca}">

    <div class="row justify-content-center">

        <div class="col-sm-12 col-md-12 col-lg-12">

            <div class="row my-2">

                <div class="col-lg-12">

                    <h3 id="subTituloEtapa2">Por favor, clique em remover caso alguma criança não faça parte do
                        cadastro: </h3>

                </div>

            </div>

            <div class="row my-2">

                <div class="col-lg-12">

                    <button class="btn btn-info btn-lg btn-block" onclick="restartCrianca()">Recarregar
                        Crianças</button>

                </div>

            </div>

            <div class="row my-2">

                <div class="col-lg-12">

                    <div id="tabelaAniversariante" style="display: none"
                        class="table-responsive border border-secondary rounded">

                        <table class="table table-striped table-bordered">
                            <thead>
                                <tr class="bg-info">
                                    <th scope="col">Nome da criança</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody id="tbodyAniversariantes">
                            </tbody>
                        </table>

                    </div>

                </div>

            </div>

            <div class="row my-2">

                <div class="col-lg-6 my-2">

                    <button class="btn btn-secondary btn-lg btn-block" onclick="voltarEtapa1()"> Voltar </button>

                </div>

                <div class="col-lg-6 my-2">

                    <button class="btn btn-info btn-lg btn-block" onclick="etapa3()"> 3º Etapa </button>

                </div>

            </div>

        </div>

    </div>

</div>
<!-- fim 2 etapa -->

<!-- 3 etapa -->
<!-- div de selecionar funcionario ( 3 etapa ) -->
<div class="container" id="selecionarFuncionarios" style="display: none">

    <div class="row justify-content-center">

        <div class="col-sm-12 col-md-12 col-lg-12">

            <div class="row my-2">

                <div class="col-lg-12">

                    <h6>Selecione o animador ou animadora e informe seu cache e forma de pagamento, após isso clique em
                        "Adicionar":</h6>

                </div>

            </div>

            <form class="form-group" id="formFuncionario">

                <div class="form-row">

                    <div class="form-group col-lg-4">

                        <label for="jsFuncionarios">Colaborador: *</label>
                        <select type="select" class="form-control" name="jsFuncionarios" required>
                            <option value="">Clique para selecionar</option>
                            <c:forEach var="item" items="${listaFuncionario}">
                                <option value="${item.idFuncionario}+${item.nomeFuncionario}">
                                    ${item.nomeFuncionario}
                                </option>
                            </c:forEach>
                        </select>

                    </div>

                    <div class="form-group col-lg-4">

                        <label for="jsCache">Cache: *</label>
                        <input type="text" class="form-control" placeholder="0.00" name="jsCache" id="jsCache" required>

                    </div>

                    <div class="form-group col-lg-4">

                        <label for="jsFormaPagamentoFuncionario">Forma de Pagamento: *</label>
                        <select type="select" class="form-control" name="jsFormaPagamentoFuncionario" required>
                            <option value="">Clique para selecionar</option>
                            <c:forEach var="item" items="${listaFormaPagamento}">
                                <option value="${item.idFormaPagamento}+${item.nomePagamento}">
                                    ${item.nomePagamento}
                                </option>
                            </c:forEach>
                        </select>

                    </div>

                </div>

                <div class="form-row">

                    <div class="form-group col-lg-12">

                        <button type="button" class="btn btn-info btn-lg btn-block" id="add-funcionario"> Adicionar
                        </button>

                    </div>

                </div>

            </form>

            <div class="row">

                <div class="col-lg-12">

                    <p id="msgTratamentoEtapa3" style="color: red;"></p>

                </div>

            </div>

            <div class="row" id="tabelaFuncionario" style="display: none">

                <div class="col-lg-12">

                    <div class="table-responsive border border-secondary rounded">

                        <table class="table table-striped table-bordered">
                            <thead>
                                <tr class="bg-info">
                                    <th scope="col">Colaborador</th>
                                    <th scope="col">Cache</th>
                                    <th scope="col">Forma de Pagamento</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody id="tbodyFuncionario">
                            </tbody>
                        </table>

                    </div>

                </div>

            </div>

            <div class="row mt-4">

                <div class="col-lg-6 my-2">

                    <button class="btn btn-secondary btn-lg btn-block" onclick="voltarEtapa2()"> Voltar </button>

                </div>

                <div class="col-lg-6 my-2">

                    <button class="btn btn-info btn-lg btn-block" onclick="etapa4()"> 4º Etapa </button>

                </div>

            </div>

        </div>

    </div>

</div>
<!-- fim 3 etapa -->

<!-- 4 etapa -->
<!-- div de selecionar pacote e pacote adicional ( 4 etapa ) -->
<div id="selecionarPacotes" style="display: none">

    <div class="container">

        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-12 col-lg-12">

                <div class="row">

                    <div class="col-lg-12">

                        <h3>Por favor, selecione o pacote e os adicionais de pacote do evento:</h3>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <div class="container mt-3">

        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-12 col-lg-12">

                <div class="row">

                    <div class="col-lg-12">

                        <label for="jsPacote">
                            <h5>Pacote: * </h5>
                        </label>
                        <select type="select" class="form-control" name="jsPacote" id="jsPacote">
                            <option value="">Clique para selecionar</option>
                            <c:forEach var="item" items="${listaPacote}">
                                <option value="${item.idPacote}+${item.nomePacote}+${item.valorPacoteVenda}">
                                    ${item.nomePacote}
                                </option>
                            </c:forEach>
                        </select>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <div class="container mt-4">

        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-12 col-lg-12">

                <div class="row">

                    <div class="col-lg-5 my-1">

                        <h5>Evento possui adicionais de pacote?</h5>

                    </div>

                </div>

                <div class="row">

                    <div class="col-lg-2 my-1">

                        <button class="btn btn-info btn-lg btn-block" onclick="habilitaPacoteAdicional()">Sim</button>

                    </div>

                    <div class="col-lg-2 my-1">

                        <button class="btn btn-info btn-lg btn-block" onclick="desabilitaPacoteAdicional()">Não</button>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <div id="divPacoteAdicional" style="display: none">

        <div class="container mt-3">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-12 col-lg-12">

                    <form class="form-group" id="formPacoteAdicional">

                        <div class="form-row">

                            <div class="form-group col-lg-4">

                                <label for="jsPacotesAdicionais">
                                    <h5>Adicional no Pacote: *</h5>
                                </label>
                                <select type="select" class="form-control" name="jsPacotesAdicionais"
                                    id="jsPacotesAdicionais">
                                    <option value="">Clique para selecionar</option>
                                    <c:forEach var="item" items="${listaTipoPacoteAdicional}">
                                        <option value="${item.idTipoPacoteAdicional}+${item.descricaoPacoteAdd}">
                                            ${item.descricaoPacoteAdd}
                                        </option>
                                    </c:forEach>
                                </select>

                            </div>

                            <div class="form-group col-lg-4">

                                <label for="jsValorPacoteAdicional">
                                    <h5>Valor: *</h5>
                                </label>
                                <input type="text" class="form-control" placeholder="0.00" name="jsValorPacoteAdicional"
                                    id="jsValorPacoteAdicional" value="" required>

                            </div>

                            <div class="form-group col-lg-4">

                                <div id="bntAddAdicional">

                                    <button class="btn btn-info btn-lg btn-block"
                                        id="add-pacoteAdicional">Adicionar</button>

                                </div>

                            </div>

                        </div>

                    </form>

                </div>

            </div>

        </div>

        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-12 col-lg-12">

                    <div class="row my-2">

                        <div class="col-lg-12">

                            <div id="tabelaPacoteAdicional" class="table-responsive border border-secondary rounded"
                                style="display: none">

                                <table class="table table-striped table-bordered">
                                    <thead>
                                        <tr class="bg-info">
                                            <th scope="col">Adicional no Pacote</th>
                                            <th scope="col">Valor</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody id="tbodyPacoteAdicional">
                                    </tbody>
                                </table>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <div class="container mt-4">

        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-12 col-lg-12">

                <div class="row my-2">

                    <div class="col-lg-6 my-2">

                        <button class="btn btn-secondary btn-lg btn-block" onclick="voltarEtapa3()"> Voltar </button>

                    </div>

                    <div class="col-lg-6 my-2">

                        <button class="btn btn-info btn-lg btn-block" onclick="etapa5()"> 5º Etapa </button>

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>
<!-- fim 4 etapa -->

<!-- 5 etapa -->
<div id="inserirValorAdicional" style="display: none">

    <div class="container">

        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-12 col-lg-12">

                <div class="row my-2">

                    <div class="col-lg-12">

                        <h5>Caso o evento tenha valores adicionais, informe a baixo. Caso não tenha, por favor siga para
                            6° Etapa.</h5>

                    </div>

                </div>

                <form class="form-group" id="formValorAdicional">

                    <div class="form-row">

                        <div class="form-group col-lg-6">

                            <label for="jsValorPacoteAdicional">
                                <h5>Valor: *</h5>
                            </label>
                            <input type="text" class="form-control" placeholder="0.00" name="jsValorAdicional"
                                id="jsValorAdicional" required>

                        </div>

                        <div class="form-group col-lg-6">

                            <label for="jsDescricaoValorAdicional">
                                <h5>Descrição: *</h5>
                            </label>
                            <input type="text" class="form-control" placeholder="Ex: Hora Extra"
                                name="jsDescricaoValorAdicional" id="jsDescricaoValorAdicional" required>

                        </div>

                    </div>

                    <div class="form-row">

                        <div class="form-group col-lg-12">

                            <button class="btn btn-info btn-lg btn-block" id="add-valorAdicional">Adicionar</button>

                        </div>

                    </div>

                </form>

                <div class="row my-2">

                    <div class="col-lg-12">

                        <div id="tabelaValorAdicional" class="table-responsive border border-secondary rounded"
                            style="display: none">

                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr class="bg-info">
                                        <th scope="col">Valor</th>
                                        <th scope="col">Descrição do Valor</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody id="tbodyValorAdicional">
                                </tbody>
                            </table>

                        </div>

                    </div>

                </div>

                <div class="row mt-4">

                    <div class="col-lg-6 my-2">

                        <button class="btn btn-secondary btn-lg btn-block" onclick="voltarEtapa4()"> Voltar </button>

                    </div>

                    <div class="col-lg-6 my-2">

                        <button class="btn btn-info btn-lg btn-block" onclick="etapa6()"> 6º Etapa </button>

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>
<!-- fim 5 etapa -->

<!-- 6 etapa -->
<div id="inserirDespesas" style="display: none">

    <div class="container">

        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-12 col-lg-12">

                <div class="row my-2">

                    <div class="col-lg-12">

                        <h4>Por favor, informe as despesas do evento nos campos a baixo: </h4>

                    </div>

                </div>

                <div class="row my-2">

                    <div class="col-lg-12">

                        <h5>Selecione a opção de cadastro: </h5>

                    </div>

                </div>

                <div class="row my-2">

                    <div class="col-lg-6 my-1">

                        <button type="button" class="btn btn-info btn-lg btn-block" onclick="tipoDespesa()">TIPO DE DESPESA</button>

                    </div>

                    <div class="col-lg-6 my-1">

                        <button type="button" class="btn btn-info btn-lg btn-block" onclick="descricaoManual()">DESCRIÇÃO MANUAL</button>

                    </div>

                </div>

                <form class="form-group mt-3" id="formAddDespesaFesta">

                    <div class="form-row my-1">

                        <div class="form-group col-lg-6">

                            <label for="jsDescricaoDespesa"><h5>Despesa: *</h5></label>

                            <input type="text" id="jsDescricaoDespesa" class="form-control" placeholder="Ex: Gasolina" name="jsDescricaoDespesa" value="" style="display: none">

                            <select type="select" class="form-control" id="jsTipoDespesa" name="jsTipoDespesa">
                                <option value="">Clique para selecionar</option>
                                <c:forEach var="item" items="${listaTipoDeDespesa}">
                                    <option value="${item.idTipoDeDespesa}+${item.nomeDespesa}">
                                        ${item.nomeDespesa}
                                    </option>
                                </c:forEach>
                            </select>

                        </div>

                        <div class="form-group col-lg-6">

                            <label for="jsValorDepesa"><h5>Valor: *</h5></label>
                            <input type="text" class="form-control" placeholder="0.00" name="jsValorDepesa" id="jsValorDepesa" value="" required>

                        </div>                       
                        
                    </div>

                    <div class="form-row my-1">

                        <div class="form-group col-lg-6">

                            <label for="jsFormaPagamentoDespesa"><h5>Forma de Pagamento: *</h5></label>
                            <select type="select" class="form-control" name="jsFormaPagamentoDespesa">
                                <option value="">Clique para selecionar</option>
                                <c:forEach var="item" items="${listaFormaPagamento}">
                                    <option value="${item.idFormaPagamento}+${item.nomePagamento}">
                                        ${item.nomePagamento}
                                    </option>
                                </c:forEach>
                            </select>                                    

                        </div> 

                        <div class="form-group col-lg-6">

                            <label for="jsDespesaPaga"><h5>Despesa paga?: *</h5></label>
                            <select  class="form-control" name="jsDespesaPaga">
                                <option selected>Sim</option>
                                <option>Não</option>
                            </select>
                            
                        </div>

                    </div>

                    <div class="form-row my-1">

                        <div class="form-group col-lg-12" id="dataPagamentoDespesa" style="display: none">

                            <label for="jsDataPagamentoDespesa"><h5>Data de Pagamento: *</h5></label>
                            <input type="text" class="form-control" placeholder="00/00/0000" name="jsDataPagamentoDespesa" id="jsDataPagamentoDespesa" value="">

                        </div> 

                    </div>

                    <div class="form-row my-1">

                        <div class="form-group col-lg-12">

                            <button type="button" class="btn btn-info btn-lg btn-block" id="add-despesaFesta">Adicionar</button> 

                        </div> 

                    </div>

                </form>  

            </div>

        </div>

    </div>

    <div class="container">

        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-12 col-lg-12">

                <div class="row my-4">

                    <div class="col-lg-12">

                        <div id="tabelaDespesas" class="table-responsive border border-secondary rounded" style="display: none">

                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr class="bg-info">
                                        <th scope="col">Descrição da Despesa</th>
                                        <th scope="col">Valor</th>
                                        <th scope="col">Forma de Pagamento</th>
                                        <th scope="col">Pago?</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody id="tbodyDespesas">
                                </tbody>
                            </table>

                        </div>

                    </div>

                </div>
                
                <div class="row my-4">

                    <div class="col-lg-6 my-2">

                        <button class="btn btn-secondary btn-lg btn-block" onclick="voltarEtapa5()"> Voltar </button>

                    </div>

                    <div class="col-lg-6 my-2">

                        <button class="btn btn-info btn-lg btn-block" onclick="etapa7()"> 7º Etapa </button>

                    </div>

                </div>  

            </div>  

        </div>  

    </div>  

</div>
<!-- fim 6 etapa -->

<!-- 7 etapa -->
<div  id="valoresEformaPagamento" style="display: none">

    <div class="container">

        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-12 col-lg-12">

                <div class="row my-2">

                    <div class="col-lg-12">

                        <h4>Por favor, informe as despesas do evento nos campos a baixo: </h4>

                    </div>

                </div>

                <div class="row my-3">

                    <div class="col-lg-4 my-1">

                        <h5 class="fontInfValores" id="valorTotal"></h5>

                    </div>

                    <div class="col-lg-4 my-1">

                        <h5 class="fontInfValores" id="totalDespesas"></h5>

                    </div>

                    <div class="col-lg-4 my-1">

                        <h5 class="fontInfValores" id="lucro"></h5>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <div class="container mt-2">

        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-12 col-lg-12">

                <form class="form-group" id="formAddValorEformaPagamento">

                    <div class="form-row my-1">

                        <div class="form-group col-lg-4">

                            <label for="jsValorFormaPagamento"><h5>Valor: *</h5></label>
                            <input type="text" id="jsValorFormaPagamento" class="form-control" placeholder="Ex: 0.00" name="jsValorFormaPagamento" value="" required>

                        </div>

                        <div class="form-group col-lg-4">

                            <label for="jsFormaPagamento"><h5>Forma de Pagamento: *</h5></label>
                            <select type="select" class="form-control" name="jsFormaPagamento">
                                <option value="">Clique para selecionar</option>
                                <c:forEach var="item" items="${listaFormaPagamento}">
                                    <option value="${item.idFormaPagamento}+${item.nomePagamento}">
                                        ${item.nomePagamento}
                                    </option>
                                </c:forEach>
                            </select>

                        </div>   

                        <div class="form-group col-lg-4">

                            <label for="jsValorPago"><h5>Pago? *</h5></label>
                            <select class="form-control" name="jsValorPago" id="jsValorPago">
                                <option value="Não" selected>Não</option>
                                <option values="Sim">Sim</option>
                            </select>
                            
                        </div>

                    </div>

                    <div class="form-row my-1">

                        <div class="form-group col-lg-12">

                            <button type="button" class="btn btn-info btn-lg btn-block" id="add-valorEfp">Adicionar</button> 

                        </div> 

                    </div>

                </form>                  

                <!-- <form class="form-group" id="formAddValorEformaPagamento">

                    <div class="form-row">

                        <div class="form-group col-lg-6">

                            <label for="jsValorFormaPagamento"><h5>Valor: *</h5></label>
                            <input type="text" id="jsValorFormaPagamento" class="form-control" placeholder="Ex: 0.00" name="jsValorFormaPagamento" value="" required>

                        </div>

                        <div class="form-group col-lg-6">

                            <label for="jsFormaPagamento"><h5>Forma de Pagamento: *</h5></label>
                            <select type="select" class="form-control" name="jsFormaPagamento">
                                <option value="">Clique para selecionar</option>
                                <c:forEach var="item" items="${listaFormaPagamento}">
                                    <option value="${item.idFormaPagamento}+${item.nomePagamento}">
                                        ${item.nomePagamento}
                                    </option>
                                </c:forEach>
                            </select>

                        </div>   
                        
                    </div>

                    <div class="form-row">

                        <div class="form-group col-lg-6">

                            <label for="jsValorPago"><h5>Pago? *</h5></label>
                            <select name="jsValorPago" class="form-control" id="jsValorPago">
                                <option selected>Sim</option>
                                <option>Não</option>
                            </select>
                            
                        </div>

                        <div class="form-group col-lg-6">

                            <label for="jsDataPagamentoPagAdiantado"><h5>Data de Pagamento: *</h5></label>
                            <input type="text" class="form-control" placeholder="00/00/0000" name="jsDataPagamentoPagAdiantado" id="jsDataPagamentoPagAdiantado" value="">

                        </div> 

                    </div>

                    <div class="form-row">

                        <div class="form-group col-lg-12">

                            <button type="button" class="btn btn-info btn-lg btn-block" id="add-despesaFesta">Adicionar</button> 

                        </div> 

                    </div>

                </form>   -->

            </div>

        </div>

    </div>

    <div class="container">

        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-12 col-lg-12">

                <div class="row my-2">

                    <div class="col-lg-12">    

                        <div id="tabelaFormaPagamentoEvalor" class="table-responsive border border-secondary rounded" style="display: none">

                            <table class="table table-striped table-bordered">
                                <thead> 
                                    <tr class="bg-info">    
                                        <th scope="col">Valor</th>
                                        <th scope="col">Forma de Pagamento</th>
                                        <th scope="col">Pago?</th>
                                        <th></th>
                                    </tr>
                                </thead> 
                                <tbody id="tbodyFormaPagamentoEvalor">
                                </tbody>
                            </table>

                        </div>
   
                    </div>

                </div>

                <div class="row my-2">

                    <div class="col-lg-12">    

                        <h5 id="msgTratamentoEtapa7" style="color: red;"></h5>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <div class="container">

        <div class="row justify-content-center">

            <div class="col-sm-12 col-md-12 col-lg-12">

                <div class="row my-2">

                    <div class="col-lg-6 my-2">    

                        <button type="button" class="btn btn-secondary btn-lg btn-block" onclick="voltarEtapa6()"> Voltar </button>

                    </div>

                    <div class="col-lg-6 my-2">    

                        <button type="button" class="btn btn-info btn-lg btn-block" onclick="etapa8()"> 8º Etapa </button> 

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>
<!-- fim 7 etapa -->

<!-- 8 etapa 
div de inserir os horarios ( 8 etapa )         -->
<div id="inserirHorarios" style="display: none">

    <div class="container" >

        <div class="row justify-content-center">
            
            <div class="col-sm-12 col-md-12 col-lg-12">   

                <div class="row my-2">

                    <div class="col-lg-12">

                        <h4>Por favor, adicione os horários do evento:</h4>

                    </div>
    
                </div>  

                <form class="form-group" id="formHorario">
    
                    <div class="form-row">
    
                        <div class="form-group col-lg-6">

                            <label for="jsHorario"><h5>Horário: *</h5></label>
                            <input type="text" class="form-control" placeholder="Ex: 12:00" name="jsHorario" id="jsHorario"  required>

                        </div>

                        <div class="form-group col-lg-6">

                            <label for="jsDescricaoH"><h5>Descrição do Horário: *</h5></label>
                            <input type="text" class="form-control" placeholder="Ex: Fim do Evento" name="jsDescricaoH" id="jsDescricaoH"  required>

                        </div>

                    </div> 

                    <div class="form-row">
    
                        <div class="form-group col-lg-12">

                            <button class="btn btn-info btn-lg btn-block" id="add-horario">Adicionar</button>  

                        </div>

                    </div>    

                </form>
                
                <div class="row my-2">

                    <div class="col-lg-12">
    
                        <div id="tabelaHorario" class="table-responsive border border-secondary rounded" style="display: none">

                            <table class="table table-striped table-bordered">
                                <thead> 
                                    <tr class="bg-info">    
                                        <th scope="col">Horário</th>
                                        <th scope="col">Descrição</th>
                                        <th></th>
                                    </tr>
                                </thead> 
                                <tbody id="tbodyHorario">
                                </tbody>
                            </table>
                            
                        </div> 

                    </div>
    
                </div> 
                
                <div class="row my-2">

                    <div class="col-lg-12">

                        <h5 id="msgTratamentoEtapa8" style="color: red;"></h5> 

                    </div>
    
                </div>                  
                
                <div class="row my-2">
    
                    <div class="col-lg-6 my-2">

                        <button class="btn btn-secondary btn-lg btn-block" onclick="voltarEtapa7()"> Voltar </button>
                        
                    </div>
                    
                    <div class="col-lg-6 my-2">

                        <button class="btn btn-info btn-lg btn-block" onclick="etapa9()"> 9º Etapa </button>  

                    </div>
    
                </div>                     

            </div>
    
        </div>
    
    </div>                    

</div>  
<!--  fim 8 etapa  -->

<!-- 9 etapa -->
<!-- div de endereço da festa ( 9 etapa ) -->     
<div id="inserirEndereco" style="display: none">

    <div class="container" >

        <div class="row justify-content-center">
            
            <div class="col-sm-12 col-md-12 col-lg-12">   

                <div class="row my-3">

                    <div class="col-lg-12">

                        <h4>Por favor, informe o local do evento:</h4>

                    </div>
    
                </div>  

                <div class="row my-1">

                    <div class="form-group col-lg-6">

                        <label for="cep"><h5>CEP:  *</h5></label>
                        <input type="text" class="form-control" placeholder="00000-000" name="cep" id="cep" required>
    
                    </div>

                    <div class="form-group col-lg-6">

                        <label for="cidade"><h5>Cidade: *</h5></label>
                        <input type="text" class="form-control" placeholder="Ex: São José do Rio Preto" name="cidade" id="cidade" required>
    
                    </div>
    
                </div>  

                <div class="row my-1">

                    <div class="form-group col-lg-6">

                        <label for="bairro"><h5>Bairro:  *</h5></label>
                        <input type="text" class="form-control" placeholder="Ex: Condomínio Débora Cristina" name="bairro" id="bairro" required>
    
                    </div>

                    <div class="form-group col-lg-6">

                        <label for="rua"><h5>Rua: *</h5></label>
                        <input type="text" class="form-control" placeholder="Ex: Rua Bonanza" name="rua" id="rua" required>
    
                    </div>
    
                </div> 

                <div class="row my-1">

                    <div class="form-group col-lg-6">

                        <label for="numero"><h5>Número: *</h5></label>
                        <input type="text" class="form-control" placeholder="Ex: 123" name="numero" id="numero" required>
    
                    </div>

                    <div class="form-group col-lg-6">

                        <label for="rua"><h5>Complemento: *</h5></label>
                        <input type="text" class="form-control" placeholder="" name="complemento" id="complemento" required>
    
                    </div>
    
                </div>

                <div class="row mt-4">

                    <div class="col-lg-6 my-2">

                        <button class="btn btn-secondary btn-lg btn-block" onclick="voltarEtapa8()"> Voltar </button>  

                    </div>

                    <div class="col-lg-6 my-2">

                        <button class="btn btn-info btn-lg btn-block" onclick="etapa10()"> 10º Etapa </button>

                    </div>
    
                </div> 

            </div>
    
        </div>
    
    </div>                    

</div>  
<!-- fim 9 etapa -->

<!-- 10 etapa  -->
<!-- div de informações adicionais ( 10 etapa ) -->     
<div id="inserirInfoAdicionais" style="display: none">

    <div class="container" >

        <div class="row justify-content-center">
            
            <div class="col-sm-12 col-md-12 col-lg-12">   

                <div class="row my-3">

                    <div class="col-lg-12">

                        <h4>Por favor, informe as informações finais para o cadastro:</h4>

                    </div>
    
                </div>  

                <div class="row my-1">

                    <div class="form-group col-lg-7">

                        <label for="descricaoEvento"><h5>Descrição do Evento: *</h5></label>
                        <input type="text" class="form-control" placeholder="Ex: Aniversario de 10 anos do Daniel" name="descricaoEvento" id="descricaoEvento" required>
    
                    </div>

                    <div class="form-group col-lg-5">

                        <label for="qtdCriancaNaFesta"><h5>Quantidade de Crianças: *</h5></label>
                        <input type="text" class="form-control" placeholder="Ex: 20" name="qtdCriancaNaFesta" id="qtdCriancaNaFesta" required>
    
                    </div>
    
                </div>  

                <div class="row my-1">

                    <div class="form-group col-lg-4">

                        <label for="dataFesta"><h5>Data do evento:  *</h5></label>
                        <input type="text" class="form-control" placeholder="Ex: 00/00/0000" name="dataFesta" id="dataFesta" required>
    
                    </div>

                    <div class="form-group col-lg-4">

                        <label for="rutipoDaFestaa"><h5>Tipo de Evento:  *</h5></label>
                        <select type="select" class="form-control" name="tipoDaFesta" id="tipoDaFesta">
                            <option value="">Clique para selecionar</option>
                                <c:forEach var="item" items="${listaTipoDeFesta}">
                                    <option value="${item.idTipoDeFesta}+${item.descricaoTipoDeFesta}">
                                        ${item.descricaoTipoDeFesta}
                                    </option>
                                </c:forEach>
                        </select>  
    
                    </div>

                    <div class="form-group col-lg-4">

                        <label for="festaRealizada"><h5>Evento realizado? *</h5></label>
                        <select class="form-control" name="festaRealizada" id="festaRealizada">
                            <option value="Não" selected>Não</option>
                            <option value="Sim">Sim</option>
                        </select>
    
                    </div>
    
                </div> 

                <div class="row my-1">

                    <div class="form-group col-lg-12">

                        <label for="obs"><h5>Observação: *</h5></label>
                        <textarea  type="text" class="form-control" placeholder="Ex: Vou buscar no final do evento." name="obs" id="obs" rows="3"></textarea>
    
                    </div>
    
                </div>

                <div class="row mt-4">

                    <div class="col-lg-6 my-2">

                        <button class="btn btn-secondary btn-lg btn-block" onclick="voltarEtapa9()"> Voltar </button>

                    </div>

                    <div class="col-lg-6 my-2">

                        <button class="btn btn-info btn-lg btn-block" onclick="etapaFinal()"> Etapa Final </button>

                    </div>
    
                </div>   

            </div>
    
        </div>
    
    </div>                    

</div>  
<!-- fim 10 etapa -->   

<!--         1 etapa 
         div de listagem cliente
        <div id="listagemDeCliente" class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead> 
                    <tr class="bg-info">    
                        <th scope="col">Nome</th>
                        <th scope="col">CPF/CNPJ</th>
                        <th scope="col"></th>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${listaClientes}" var="item">                
                        <tr>
                            <td>${item.nomeCliente}</td>
                            <td>${item.cpf}</td>
                             botão/form para editar registro cliente  
                            <td>
                                <input type="hidden" id="nomeCliente${item.idCliente}" value="${item.nomeCliente}">
                                <button id="btnSelecionarCliente" onclick="selecionarCliente(${item.idCliente})" class="btn btn-info"> Selecionar </button>                                    
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>        
         div da confirmação do cliente ( 1 etapa ) 
        <div id="confirmacaoCliente"  style="display: none">
            <h4 id="clienteSelecionado"></h4>
            <br>
            <button id="btn-trocarCliente" class="btn btn-warning" onclick="trocarCliente()"> Trocar cliente </button>
            <button id="btn-2etapa"  class="btn btn-warning" onclick="etapa2()"> 2º Etapa </button>
        </div>
         fim 1 etapa         

         2 etapa  
         div de selecionar aniversariante ( 2 etapa )
        <div id="selecionarAniversariantes" style="display: none">
            <input type="hidden" id="totalCriancas" value="${totalCriancas}">  controlador para pegar o total de criancas 
            <input type="hidden" id="listaConcatenadaCrianca" value="${listaConcatenadaCrianca}">   controlador lista de todas as crianças que será filtrada no js 
            <h5 id="subTituloEtapa2">Clique em remover caso alguma criança não faça parte do cadastro ! =)</h5>
            <br>
            <button class="btn btn-warning" onclick="restartCrianca()">Recarregar crianças</button>
            <br>
            <div class="table-responsive">
                <table id="tabelaAniversariante" class="table table-striped table-bordered" style="display: none">
                    <thead> 
                        <tr class="bg-info">    
                            <th scope="col">Nome da criança</th>
                            <th></th>
                        </tr>
                    </thead> 
                    <tbody id="tbodyAniversariantes">
                    </tbody>
                </table>
            </div>           
            <button class="btn btn-warning" onclick="voltarEtapa1()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa3()"> 3º Etapa </button>            
        </div>
         fim 2 etapa  
        
         3 etapa  
         div de selecionar funcionario ( 3 etapa )
        <div id="selecionarFuncionarios" style="display: none">
            <h5>Selecione o animador ou animadora e informe seu cache e forma de pagamento, após isso clique em "Adicionar"</h5>
            <form id="formFuncionario">
                Colaborador:
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
            <div>
                <p id="msgTratamentoEtapa3" style="color: red;"></p>
            </div>            
            <div class="table-responsive">
                <table id="tabelaFuncionario" class="table table-striped table-bordered" style="display: none">
                    <thead> 
                        <tr class="bg-info">    
                            <th scope="col">Colaborador</th>
                            <th scope="col">Cache</th>
                            <th scope="col">Forma de Pagamento</th>
                            <th></th>
                        </tr>
                    </thead> 
                    <tbody id="tbodyFuncionario">
                    </tbody>
                </table>
            </div>   
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa2()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa4()"> 4º Etapa </button>            
        </div> 
         fim 3 etapa 

         4 etapa  
         div de selecionar pacote e pacote adicional ( 4 etapa )        
        <div id="selecionarPacotes" style="display: none">
            <h5> Selecione o pacote do evento: </h5>
            Pacote:
            <select type="select" name="jsPacote" id="jsPacote">
                <option value="">Clique para selecionar</option>
                    <c:forEach var="item" items="${listaPacote}">
                        <option value="${item.idPacote}+${item.nomePacote}+${item.valorPacoteVenda}">
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
                <div>
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
                </div>    
                <br>
                <div class="table-responsive">
                    <table id="tabelaPacoteAdicional" class="table table-striped table-bordered" style="display: none">
                        <thead> 
                            <tr class="bg-info">    
                                <th scope="col">Adicional no Pacote</th>
                                <th scope="col">Valor</th>
                                <th></th>
                            </tr>
                        </thead> 
                        <tbody id="tbodyPacoteAdicional">
                        </tbody>
                    </table> 
                </div>                           
            </div>            
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa3()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa5()"> 5º Etapa </button>            
        </div>
         fim 4 etapa  -->

<!--        5 etapa 
         div de inserir valores adiconais ( 5 etapa )          -->
<!--        <div id="inserirValorAdicional" style="display: none">
            <h5>O evento possui valores adicionais? Caso não tenha siga para a próxima etapa, caso tenha adicione a baixo:</h5>
            <div>
                <form id="formValorAdicional">
                    Valor:
                    <input type="text" name="jsValorAdicional" value="">
                    Descrição:
                    <input type="text" name="jsDescricaoValorAdicional" value="">
                    <button type="button" id="add-valorAdicional">Adicionar</button> 
                </form>            
            </div>
            <br>
            <div class="table-responsive">
                <table id="tabelaValorAdicional" class="table table-striped table-bordered" style="display: none">
                    <thead> 
                        <tr class="bg-info">    
                            <th scope="col">Valor</th>
                            <th scope="col">Descrição do Valor</th>
                            <th></th>
                        </tr>
                    </thead> 
                    <tbody id="tbodyValorAdicional">
                    </tbody>
                </table>
            </div>             
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa4()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa6()"> 6º Etapa </button>                
        </div>-->
<!--          fim 5 etapa 

         6 etapa 
         div de inserir as despesas da festa ( 6 etapa )          -->
<!--        <div id="inserirDespesas" style="display: none">
            <h5>Adicione as despesas do evento:</h5>
            Selecione a opção de cadastro:
            <button type="button" onclick="tipoDespesa()">TIPO DE DESPESA</button>
            <button type="button" onclick="descricaoManual()">DESCRIÇÃO MANUAL</button>
            <br>
            <div>
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
            </div>            
            <div>
                <p id="msgTratamentoEtapa6" style="color: red;"></p>
            </div>
            <div class="table-responsive">
                <table id="tabelaDespesas" class="table table-striped table-bordered" style="display: none">
                    <thead> 
                        <tr class="bg-info">    
                            <th scope="col">Descrição da Despesa</th>
                            <th scope="col">Valor</th>
                            <th scope="col">Forma de Pagamento</th>
                            <th scope="col">Pago?</th>
                            <th></th>
                        </tr>
                    </thead> 
                    <tbody id="tbodyDespesas">
                    </tbody>
                </table>
            </div>
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa5()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa7()"> 7º Etapa </button>   
        </div>-->
<!--         fim 6 etapa 
        
         7 etapa 
         div de calculos do valores e formas de pagamento ( 7 etapa )          -->
<!--        <div id="valoresEformaPagamento" style="display: none">
            <h5> Confirme os valores a baixo e informe as formas de pagamento do evento: </h5>
            <h6 id="valorTotal"></h6>
            <h6 id="totalDespesas"></h6>
            <h6 id="lucro"></h6>
            <br>
            <div>
                <form id="formAddValorEformaPagamento">
                    Valor:
                    <input type="text" name="jsValorFormaPagamento" value="">
                    Forma de Pagamento:
                    <select type="select" name="jsFormaPagamento">
                        <option value="">Clique para selecionar</option>
                            <c:forEach var="item" items="${listaFormaPagamento}">
                                <option value="${item.idFormaPagamento}+${item.nomePagamento}">
                                    ${item.nomePagamento}
                                </option>
                            </c:forEach>
                    </select>                
                    Pago?
                    <select name="jsValorPago">
                        <option>Não</option>
                        <option>Sim</option>
                    </select>
                    <button type="button" id="add-valorEfp">Adicionar</button> 
                </form>
            </div>
            <div>
                <p id="msgTratamentoEtapa7" style="color: red;"></p>
            </div>
            <div class="table-responsive">
                <table id="tabelaFormaPagamentoEvalor" class="table table-striped table-bordered" style="display: none">
                    <thead> 
                        <tr class="bg-info">    
                            <th scope="col">Valor</th>
                            <th scope="col">Forma de Pagamento</th>
                            <th scope="col">Pago?</th>
                            <th></th>
                        </tr>
                    </thead> 
                    <tbody id="tbodyFormaPagamentoEvalor">
                    </tbody>
                </table>
            </div>
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa6()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa8()"> 8º Etapa </button>   
        </div>-->
<!--         fim 7 etapa 

 <!--        9 etapa 
         div de endereço da festa ( 9 etapa )         -->
<!--        <div id="inserirEndereco" style="display: none">
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
        </div> -->
<!--         fim 9 etapa         
        
         10 etapa 
         div de informações adicionais ( 10 etapa )         -->
<!--        <div id="inserirInfoAdicionais" style="display: none">
            <h5>Insira as informações finais para o cadastro:</h5>
            <br>
            Descrição do Evento: <input type="text" name="descricaoEvento" id="descricaoEvento">
            Quantidade de crianças no evento: <input type="text" name="qtdCriancaNaFesta" id="qtdCriancaNaFesta">
            Data do evento: <input type="text" name="dataFesta" id="dataFesta">
            <br>
            Tipo de evento: 
            <select type="select" name="tipoDaFesta" id="tipoDaFesta">
                <option value="">Clique para selecionar</option>
                    <c:forEach var="item" items="${listaTipoDeFesta}">
                        <option value="${item.idTipoDeFesta}+${item.descricaoTipoDeFesta}">
                            ${item.descricaoTipoDeFesta}
                        </option>
                    </c:forEach>
            </select>   
            Observação: <input type="text" name="obs" id="obs">
            Evento realizado?
            <select name="festaRealizada" id="festaRealizada">
                <option value="Não">Não</option>
                <option value="Sim">Sim</option>
            </select>
            <br>
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa9()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapaFinal()"> Etapa Final </button>              
        </div>-->
<!--         fim 10 etapa         
        
        div confirmar informações ( etapa final etapa )      -->    
        <div id="confirmarInformacoes" style="display: none">
            <h5>Por favor confira as informações inseridas, caso estejam corretas clique em "Finalizar cadastro"</h5>
            <div class="accordion" id="accordionExample">
<!--                 Contratante -->
                <div class="card bg-light border-dark">
                    <div class="card-header" id="headingContratante">
                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseContratante" aria-expanded="false" aria-controls="collapseContratante">
                            <h5 class="mb-0">1° ETAPA - Contratante</h5>
                        </button>
                        <button class="btn btn-info float-right" onclick="editarEtapa(1)">Editar</button>
                    </div>
                    <div id="collapseContratante" class="collapse" aria-labelledby="headingContratante" data-parent="#accordionExample">
                        <div class="card-body">
                            <h6 class="card-title" id="clienteInf"></h6>
                        </div>
                    </div>
                </div>
                 <!--Aniversariantes-->  
                <div class="card border-dark">
                    <div class="card-header" id="headingAniversariante">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseAniversariante" aria-expanded="false" aria-controls="collapseAniversariante">
                            <h5 class="mb-0">2° ETAPA - Crianças</h5>
                        </button>
                        <button class="btn btn-info float-right" onclick="editarEtapa(2)">Editar</button>
                    </div>
                    <div id="collapseAniversariante" class="collapse" aria-labelledby="headingAniversariante" data-parent="#accordionExample">
                        <div class="card-body">
                            <h6 class="card-title" id="criancasInf"></h6>
                        </div>
                    </div>
                </div>
                 <!--Animadores--> 
                <div class="card border-dark bg-light">
                    <div class="card-header border-dark" id="headingAnimadores">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseAnimadores" aria-expanded="false" aria-controls="collapseAnimadores">
                            <h5 class="mb-0">3° ETAPA - Colaborador</h5>
                        </button>
                        <button class="btn btn-info float-right" onclick="editarEtapa(3)">Editar</button>
                    </div>
                    <div id="collapseAnimadores" class="collapse" aria-labelledby="headingAnimadores" data-parent="#accordionExample">
                        <div id="funcionarioInf" class="card-body">
                        
                        </div>
                    </div>
                </div>
                 <!--Pacotes e pacote add--> 
                <div class="card border-dark">
                    <div class="card-header" id="headingPacotes">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapsePacotes" aria-expanded="false" aria-controls="collapsePacotes">
                            <h5 class="mb-0">4° ETAPA - Pacote & Adicionais</h5>
                        </button>
                        <button class="btn btn-info float-right" onclick="editarEtapa(4)">Editar</button>
                    </div>
                    <div id="collapsePacotes" class="collapse" aria-labelledby="headingPacotes" data-parent="#accordionExample">
                        <div class="card-body">
                            <h6  class="card-title" id="pacoteInf"></h6>
                            <div id="pacoteAddInf">
                                
                            </div>
                        </div>
                    </div>
                </div>
                 <!--Valores add--> 
                <div class="card border-dark bg-light">
                    <div class="card-header" id="headingValoresAdd">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseValoresAdd" aria-expanded="false" aria-controls="collapseValoresAdd">
                            <h5 class="mb-0">5° ETAPA - Valores Adicionais</h5>
                        </button>
                        <button class="btn btn-info float-right" onclick="editarEtapa(5)">Editar</button>
                    </div>
                    <div id="collapseValoresAdd" class="collapse" aria-labelledby="headingValoresAdd" data-parent="#accordionExample">
                        <div id="valoresAddInf" class="card-body">
                        
                        </div>
                    </div>
                </div> 
                  <!--Despesas--> 
                <div class="card border-dark">
                    <div class="card-header" id="headingDespesas">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseDespesas" aria-expanded="false" aria-controls="collapseDespesas">
                            <h5 class="mb-0">6° ETAPA - Despesas do Evento</h5>
                        </button>
                        <button class="btn btn-info float-right" onclick="editarEtapa(6)">Editar</button>
                    </div>
                    <div id="collapseDespesas" class="collapse" aria-labelledby="headingDespesas" data-parent="#accordionExample">
                        <div id="despesasInf" class="card-body">
                        
                        </div>
                    </div>
                </div>
                  <!--Formas de pagamento--> 
                <div class="card border-dark bg-light">
                    <div class="card-header" id="headingFormaPagamento">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFormaPagamento" aria-expanded="false" aria-controls="collapseFormaPagamento">
                            <h5 class="mb-0">7° ETAPA - Valores & Formas de Pagamento</h5>
                        </button>
                        <button class="btn btn-info float-right" onclick="editarEtapa(7)">Editar</button>
                    </div>
                    <div id="collapseFormaPagamento" class="collapse" aria-labelledby="headingFormaPagamento" data-parent="#accordionExample">
                        <div id="formasDePagamentoInf" class="card-body">
                        
                        </div>
                    </div>
                </div>
                  <!--Horarios--> 
                <div class="card border-dark">
                    <div class="card-header" id="headingHorarios">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseHorarios" aria-expanded="false" aria-controls="collapseHorarios">
                            <h5 class="mb-0">8° ETAPA - Horários do Evento</h5>
                        </button>
                        <button class="btn btn-info float-right" onclick="editarEtapa(8)">Editar</button>
                    </div>
                    <div id="collapseHorarios" class="collapse" aria-labelledby="headingHorarios" data-parent="#accordionExample">
                        <div id="horariosInf" class="card-body">
                        
                        </div>
                    </div>
                </div> 
                 <!--Endereco--> 
                <div class="card border-dark bg-light">
                    <div class="card-header" id="headingEndereco">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseEndereco" aria-expanded="false" aria-controls="collapseEndereco">
                            <h5 class="mb-0">9° ETAPA - Local do Evento</h5>
                        </button>
                        <button class="btn btn-info float-right" onclick="editarEtapa(9)">Editar</button>
                    </div>
                    <div id="collapseEndereco" class="collapse" aria-labelledby="headingEndereco" data-parent="#accordionExample">
                        <div id="enderecoFestaInf" class="card-body">
                            
                        </div>
                    </div>
                </div>
                  <!--Informações finais-->  
                <div class="card border-dark">
                    <div class="card-header" id="headingInformacoesFinais">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseInformacoesFinais" aria-expanded="false" aria-controls="collapseInformacoesFinais">
                            <h5 class="mb-0">10° ETAPA - Informações Finais</h5>
                        </button>
                        <button class="btn btn-info float-right" onclick="editarEtapa(10)">Editar</button>
                    </div>
                    <div id="collapseInformacoesFinais" class="collapse secondary" aria-labelledby="headingInformacoesFinais" data-parent="#accordionExample">
                        <div class="card-body">
                            <h6 class="card-title" id="descricaoEventoInf"></h6>
                            <h6 class="card-title" id="dataDaFestaInf"></h6>
                            <h6 class="card-title" id="tipoDeFestaInf"></h6>
                            <h6 class="card-title" id="qtdCriancaNaFestaInf"></h6>
                            <h6 class="card-title" id="ObsInf"></h6>
                            <h6 class="card-title" id="festaRealizadaInf"></h6>                  
                        </div>
                    </div>
                </div>
<!--                 Valores finais -->
                <div class="card border-dark bg-light">
                    <div class="card-header" id="headingValores">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseValores" aria-expanded="false" aria-controls="collapseValores">
                            <h5 class="mb-0">Valores Finais do Evento</h5>
                        </button>
                    </div>
                    <div id="collapseValores" class="collapse" aria-labelledby="headingValores" data-parent="#accordionExample">
                        <div id="valoresFinalInf" class="card-body">
                            
                        </div>
                    </div>
                </div>
            </div>
            
            <button class="btn btn-warning" onclick="voltarEtapa10()"> Voltar </button> 
        </div>
            <br>
            <form method="POST" id="cadastrarFestaForm" action="cadastrarFesta">
                <!-- contador input crianca -->
                <input type="hidden" name="qtdCrianca" id="qtdCrianca" value="0">
                <!-- contador input funcionario -->
                <input type="hidden" name="qtdFuncioanrio" id="qtdFuncioanrio" value="0">
                <!-- contador input valor add -->
                <input type="hidden" name="qtdValorAdicional" id="qtdValorAdicional" value="0">
                <!-- input pacote -->
                <input type="hidden" name="idPacoteF" id="idPacoteF" value="">
                <!-- input contador e verificao se tem de pacote add--> 
                <input type="hidden" name="qtdPacoteAdicional" id="qtdPacoteAdicional" value="0">
                <input type="hidden" name="temPacoteAdicional" id="temPacoteAdicional" value="0">
                <!-- input contador despesa --> 
                <input type="hidden" name="qtdDespesa" id="qtdDespesa" value="0">
                <!-- input contador horario -->
                <input type="hidden" name="qtdHorario" id="qtdHorario" value="0">
                <!-- input contador formas de pagamento e valor -->
                <input type="hidden" name="qtdFPeValor" id="qtdFPeValor" value="0">
                <!-- inputs do endereço -->
                <input type="hidden" name="cepF" id="cepF" value="">
                <input type="hidden" name="cidadeF" id="cidadeF" value="">
                <input type="hidden" name="bairroF" id="bairroF" value="">
                <input type="hidden" name="ruaF" id="ruaF" value="">
                <input type="hidden" name="numeroF" id="numeroF" value="">
                <input type="hidden" name="complementoF" id="complementoF" value="">   
                <!-- inputs das inf adicionais -->
                <input type="hidden" name="descricaoEventoF" id="descricaoEventoF" value="">
                <input type="hidden" name="qtdCriancaNaFestaF" id="qtdCriancaNaFestaF" value="">
                <input type="hidden" name="dataFestaF" id="dataFestaF" value="">
                <input type="hidden" name="idTipoDaFestaF" id="idTipoDaFestaF" value="">
                <input type="hidden" name="observacaoF" id="observacaoF" value="">
                <input type="hidden" name="festaRealizadaF" id="festaRealizadaF" value="">
                <!-- input valores finais da festa -->
                <input type="hidden" name="valorTotalFesta" id="valorTotalFesta" value="">
                <input type="hidden" name="valorTotalDespesa" id="valorTotalDespesa" value="">
                <input type="hidden" name="valorTotalLucro" id="valorTotalLucro" value="">
                <input type="hidden" name="valorReceberContratante" id="valorReceberContratante" value="">
<!--                <button class="btn btn-warning" type="submit">Finalizar cadastro</button> -->
            </form>
            
<!--            botão de cancelar cadastro-->
<div class="container mt-4">

    <div class="row justify-content-center">

        <div class="col-sm-12 col-md-12 col-lg-12">

            <div class="row my-2">

                <div class="col-lg-12">
                    
                    <a href="festaPrincipal.jsp" type="button" class="btn btn-danger btn-lg btn-block">Cancelar Cadastro</a>   
                    
                </div>
                
            </div>
            
        </div>
        
    </div>
    
</div>
        
    </body>
    <script src="../../javascripts/cadastroDeFesta/festaCadastrar.js"></script>
    <script src="../../javascripts/enderecos/enderecosAutomaticos.js"></script>  
</html>
