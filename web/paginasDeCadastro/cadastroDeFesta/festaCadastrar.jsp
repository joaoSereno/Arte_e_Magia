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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA=" crossorigin="anonymous"></script>                
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customização -->   
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeFesta/festaCadastrar.css">
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

                <div class="col-sm-12 col-md-12 col-lg-10">

                    <div class="row">
                        
                        <div class="col-lg-12">

                            <h3> Por favor selecione o contratante do evento: </h3>

                        </div>
                        
                    </div>

                    <div class="row">
                        
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

        </div>

        <!-- div de confirmação cliente-->
        <div class="container" id="confirmacaoCliente" style="display: none">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-12 col-lg-10">

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

                <div class="col-sm-12 col-md-12 col-lg-10">

                    <div class="row my-2">

                        <div class="col-lg-12">

                            <h5 id="subTituloEtapa2">Por favor, caso alguma criança não faça parte do cadastro clique em "Remover":</h5>

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

                <div class="col-sm-12 col-md-12 col-lg-10">

                    <div class="row my-2">

                        <div class="col-lg-12">

                            <h4>Por favor, informe os colabores que trabalharam no evento.</h4> 
                                
                        </div>

                    </div>

                    <form class="form-group" id="formFuncionario">

                        <div class="form-row">

                            <div class="form-group col-lg-4">

                                <label for="jsFuncionarios"><h5>Colaborador: *</h5></label>
                                <select type="select" class="form-control" id="jsFuncionarios" name="jsFuncionarios">
                                    <option value="">Clique para selecionar</option>
                                    <c:forEach var="item" items="${listaFuncionario}">
                                        <option value="${item.idFuncionario}+${item.nomeFuncionario}">
                                            ${item.nomeFuncionario}
                                        </option>
                                    </c:forEach>
                                </select>

                            </div>

                            <div class="form-group col-lg-4">

                                <label for="jsCache"><h5>Cache: *</h5></label>
                                <input type="text" class="form-control" placeholder="0.00" name="jsCache" id="jsCache">

                            </div>

                            <div class="form-group col-lg-4">

                                <label for="jsFormaPagamentoFuncionario"><h5>Forma de Pagamento: *</h5></label>
                                <select type="select" class="form-control" id="jsFormaPagamentoFuncionario" name="jsFormaPagamentoFuncionario">
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

                            <h5 id="msgTratamentoEtapa3" style="color: red;"></h5>

                        </div>

                    </div>

                    <div class="row mt-3" id="tabelaFuncionario" style="display: none">

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

                    <div class="row mt-3">

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

                    <div class="col-sm-12 col-md-12 col-lg-10">

                        <div class="row">

                            <div class="col-lg-12">

                                <h4>Por favor, selecione o pacote e os adicionais de pacote do evento:</h4>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

            <div class="container mt-3">

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-10">

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

            <div class="container my-3">

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-10">

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

                        <div class="col-sm-12 col-md-12 col-lg-10">

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

                        <div class="col-sm-12 col-md-12 col-lg-10">

                            <div class="row my-1">

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

            <div class="container my-3">

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-10">

                        <div class="row">

                            <div class="col-lg-12">
                                
                                <h5 id="msgTratamentoEtapa4" style="color: red;"></h5>
                                
                            </div>

                        </div>

                    </div>

                </div>

            </div>                   
                                
            <div class="container">

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-10">

                        <div class="row">

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

                    <div class="col-sm-12 col-md-12 col-lg-10">

                        <div class="row my-2">

                            <div class="col-lg-12">

                                <h5 id="subTituloEtapa5">Por favor, informe os valores adicionais e/ou desconto do evento. Caso não tenha siga para a 6° Etapa.</h5>

                            </div>

                        </div>
                        
                        <div class="row mt-4">

                            <div class="col-lg-8">

                                <label for="jsDesconto"><h5>Desconto:</h5></label>
                                
                                <input type="text" class="form-control" placeholder="0.00" name="jsDesconto"
                                id="jsDesconto" required>
                                
                            </div>

                        </div>

                        <div class="row mt-4">

                            <div class="col-lg-12">

                                <h5>Valores Adicionais:</h5>

                            </div>

                        </div>                          

                        <form class="form-group mt-1" id="formValorAdicional">

                            <div class="form-row">

                                <div class="form-group col-lg-6">

                                    <label for="jsValorPacoteAdicional">
                                        <h6>Valor: *</h6>
                                    </label>
                                    <input type="text" class="form-control" placeholder="0.00" name="jsValorAdicional"
                                        id="jsValorAdicional" required>

                                </div>

                                <div class="form-group col-lg-6">

                                    <label for="jsDescricaoValorAdicional">
                                        <h6>Descrição: *</h6>
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
                        
                        <div class="row mt-3">

                            <div class="col-lg-12">

                                <h5 id="msgTratamentoEtapa5" style="color: red;"></h5>

                            </div>

                        </div>
                        
                        <div class="row my-3">

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
                        
                        <div class="row">

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

                    <div class="col-sm-12 col-md-12 col-lg-10">

                        <div class="row my-2">

                            <div class="col-lg-12">

                                <h4>Por favor, informe as despesas do evento nos campos a baixo:</h4>

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

                    <div class="col-sm-12 col-md-12 col-lg-10">
                        
                        <div class="row my-2">

                            <div class="col-lg-12">

                                <h5 id="msgTratamentoEtapa6" style="color: red;"></h5>

                            </div>

                        </div>                          

                        <div id="tabelaDespesas" class="row my-3" style="display: none">

                            <div class="col-lg-12">

                                <div  class="table-responsive border border-secondary rounded">

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
                        
                        <div class="row">

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

                    <div class="col-sm-12 col-md-12 col-lg-10">

                        <div class="row my-2">

                            <div class="col-lg-12">

                                <h4 id="subTituloEtapa7">Por favor, informe os valores e formas de pagamento do evento nos campos a baixo: </h4>

                            </div>

                        </div>

                        <div class="row my-3">

                            <div class="col-lg-3 my-1">

                                <h5 class="fontInfValores" id="valorTotal"></h5>

                            </div>

                            <div class="col-lg-3 my-1">

                                <h5 class="fontInfValores" id="totalDesconto"></h5>

                            </div>
                            
                            <div class="col-lg-3 my-1">

                                <h5 class="fontInfValores" id="totalDespesas"></h5>

                            </div>

                            <div class="col-lg-3 my-1">

                                <h5 class="fontInfValores" id="lucro"></h5>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

            <div class="container mt-2">

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-10">

                        <form class="form-group" id="formAddValorEformaPagamento">

                            <div class="form-row">

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

                            <div class="form-row mt-1">

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

                    <div class="col-sm-12 col-md-12 col-lg-10">

                        <div id="tabelaFormaPagamentoEvalor" class="row my-4" style="display: none">

                            <div  class="col-lg-12">    

                                <div class="table-responsive border border-secondary rounded">

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

                    <div class="col-sm-12 col-md-12 col-lg-10">

                        <div class="row">

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

                    <div class="col-sm-12 col-md-12 col-lg-10">   

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

                                <h5 id="msgTratamentoEtapa8" style="color: red;"></h5> 

                            </div>

                        </div>  
                        
                        <div class="row my-3">

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

                        <div class="row">

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

                    <div class="col-sm-12 col-md-12 col-lg-10">   

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
                        
                        <div class="row my-3">

                            <div class="col-lg-12">

                                <h5 id="msgTratamentoEtapa9" style="color: red;"></h5> 

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

                    <div class="col-sm-12 col-md-12 col-lg-10">   

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
                        
                        <div class="row my-3">

                            <div class="col-lg-12">

                                <h5 id="msgTratamentoEtapa10" style="color: red;"></h5> 

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

        <!-- etapa final de confirmação -->
        <div id="confirmarInformacoes" style="display: none">

            <div class="container" >

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-10">   

                        <div class="row my-3">

                            <div class="col-lg-12">

                                <h4 id="subTituloEtapaFinal">Por favor confira as informações inseridas, caso estejam corretas clique em "Finalizar cadastro".</h4>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

            <div class="container">

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-10 accordion" id="accordionExample">   

                        <!-- Contratante -->                
                        <div class="card bg-light border-dark">

                            <div class="card-header row" id="headingContratante">

                                <div class="col-lg-4 my-2">
                                    <button class="btn btn-info btn-block" onclick="editarEtapa(1)">Editar</button>
                                </div>

                                <div class="col-lg-8 my-2">

                                    <button class="btn btn-link collapsed btn-block" type="button" data-toggle="collapse" data-target="#collapseContratante" aria-expanded="false" aria-controls="collapseContratante">
                                        <h4 class="mb-0">1° ETAPA - CONTRATANTE</h4>
                                    </button>

                                </div>

                            </div>


                            <div id="collapseContratante" class="row collapse" aria-labelledby="headingContratante" data-parent="#accordionExample">

                                <div class="col-lg-12">

                                    <div class="card-body">
                                        <h5 class="card-title" id="clienteInf"></h5>
                                    </div>

                                </div>

                            </div>

                        </div>

                        <!--Aniversariantes-->  
                        <div class="card border-dark">

                            <div class="card-header row" id="headingAniversariante">

                                <div class="col-lg-4 my-2">
                                    <button class="btn btn-info btn-block" onclick="editarEtapa(2)">Editar</button>
                                </div>

                                <div class="col-lg-8 my-2">

                                    <button class="btn btn-link collapsed btn-block" type="button" data-toggle="collapse" data-target="#collapseAniversariante" aria-expanded="false" aria-controls="collapseAniversariante">
                                        <h4 class="mb-0">2° ETAPA - CRIANÇAS</h4>
                                    </button>

                                </div>      

                            </div>

                            <div id="collapseAniversariante" class="row collapse" aria-labelledby="headingAniversariante" data-parent="#accordionExample">

                                <div class="col-lg-12">

                                    <div class="card-body">
                                        <h5 class="card-title" id="criancasInf"></h5>
                                    </div>

                                </div>

                            </div>

                        </div>  

                        <!--Animadores--> 
                        <div class="card border-dark bg-light">

                            <div class="card-header row" id="headingAnimadores">

                                <div class="col-lg-4 my-2">

                                    <button class="btn btn-info btn-block" onclick="editarEtapa(3)">Editar</button>

                                </div>

                                <div class="col-lg-8 my-2">

                                    <button class="btn btn-link collapsed btn-block" type="button" data-toggle="collapse" data-target="#collapseAnimadores" aria-expanded="false" aria-controls="collapseAnimadores">
                                        <h4 class="mb-0">3° ETAPA - COLABORADORES</h4>
                                    </button>

                                </div>

                            </div>

                            <div id="collapseAnimadores" class="row collapse" aria-labelledby="headingAnimadores" data-parent="#accordionExample">

                                <div class="col-lg-12">

                                    <div class="card-body">

                                        <div id="funcionarioInf">

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </div>  

                        <!--Pacotes e pacote add--> 
                        <div class="card border-dark">

                            <div class="card-header row" id="headingPacotes">

                                <div class="col-lg-4 my-2">

                                    <button class="btn btn-info btn-block" onclick="editarEtapa(4)">Editar</button>

                                </div>

                                <div class="col-lg-8 my-2">

                                    <button class="btn btn-link collapsed btn-block" type="button" data-toggle="collapse" data-target="#collapsePacotes" aria-expanded="false" aria-controls="collapsePacotes">
                                        <h4 class="mb-0">4° ETAPA - PACOTE & ADICIONAIS</h4>
                                    </button>

                                </div>                


                            </div>

                            <div id="collapsePacotes" class="row collapse" aria-labelledby="headingPacotes" data-parent="#accordionExample">

                                <div class="col-lg-12">

                                    <div class="card-body">

                                        <h5  class="card-title" id="pacoteInf"></h5>
                                        <div class="mt-2" id="pacoteAddInf">

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </div> 

                        <!--Valores add--> 
                        <div class="card border-dark bg-light">

                            <div class="card-header row" id="headingValoresAdd">

                                <div class="col-lg-4 my-2">

                                    <button class="btn btn-info btn-block" onclick="editarEtapa(5)">Editar</button>

                                </div>

                                <div class="col-lg-8 my-2">

                                    <button class="btn btn-link collapsed btn-block" type="button" data-toggle="collapse" data-target="#collapseValoresAdd" aria-expanded="false" aria-controls="collapseValoresAdd">
                                        <h4 class="mb-0">5° ETAPA - VALORES ADICIONAIS & DESCONTO</h4>
                                    </button>

                                </div>

                            </div>

                            <div id="collapseValoresAdd" class="row collapse" aria-labelledby="headingValoresAdd" data-parent="#accordionExample">

                                <div class="col-lg-12">

                                    <div class="card-body">

                                        <div id="valoresAddInf">

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </div> 

                        <!--Despesas--> 
                        <div class="card border-dark">

                            <div class="card-header row" id="headingDespesas">

                                <div class="col-lg-4 my-2">

                                    <button class="btn btn-info btn-block" onclick="editarEtapa(6)">Editar</button>

                                </div>                        

                                <div class="col-lg-8 my-2">

                                    <button class="btn btn-link collapsed btn-block" type="button" data-toggle="collapse" data-target="#collapseDespesas" aria-expanded="false" aria-controls="collapseDespesas">
                                        <h4 class="mb-0">6° ETAPA - DESPESAS DO EVENTO</h4>
                                    </button>

                                </div>  

                            </div>

                            <div id="collapseDespesas" class="row collapse" aria-labelledby="headingDespesas" data-parent="#accordionExample">

                                <div class="col-lg-12">

                                    <div class="card-body">

                                        <div id="despesasInf">

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </div>

                        <!--Formas de pagamento--> 
                        <div class="card border-dark bg-light">

                            <div class="card-header row" id="headingFormaPagamento">

                                <div class="col-lg-4 my-2">

                                    <button class="btn btn-info btn-block" onclick="editarEtapa(7)">Editar</button>

                                </div>

                                <div class="col-lg-8 my-2">

                                    <button class="btn btn-link collapsed btn-block" type="button" data-toggle="collapse" data-target="#collapseFormaPagamento" aria-expanded="false" aria-controls="collapseFormaPagamento">
                                        <h4 class="mb-0">7° ETAPA - VALORES & FORMAS DE PAGAMENTO</h4>
                                    </button>

                                </div>

                            </div>

                            <div id="collapseFormaPagamento" class="row collapse" aria-labelledby="headingFormaPagamento" data-parent="#accordionExample">

                                <div class="col-lg-12">

                                    <div class="card-body">

                                        <div id="formasDePagamentoInf">

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </div>   

                        <!--Horarios--> 
                        <div class="card border-dark">

                            <div class="card-header row" id="headingHorarios">

                                <div class="col-lg-4 my-2">

                                    <button class="btn btn-info btn-block" onclick="editarEtapa(8)">Editar</button>

                                </div>  

                                <div class="col-lg-8 my-2">

                                    <button class="btn btn-link collapsed btn-block" type="button" data-toggle="collapse" data-target="#collapseHorarios" aria-expanded="false" aria-controls="collapseHorarios">
                                        <h4 class="mb-0">8° ETAPA - HORÁRIOS DO EVENTO</h4>
                                    </button>

                                </div> 

                            </div>

                            <div id="collapseHorarios" class="row collapse" aria-labelledby="headingHorarios" data-parent="#accordionExample">

                                <div class="col-lg-12">

                                    <div class="card-body">

                                        <div id="horariosInf">

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </div>  

                        <!--Endereco--> 
                        <div class="card border-dark bg-light">

                            <div class="card-header row" id="headingEndereco">

                                <div class="col-lg-4 my-2">

                                    <button class="btn btn-info btn-block" onclick="editarEtapa(9)">Editar</button>

                                </div>                

                                <div class="col-lg-8 my-2">

                                    <button class="btn btn-link collapsed btn-block" type="button" data-toggle="collapse" data-target="#collapseEndereco" aria-expanded="false" aria-controls="collapseEndereco">
                                        <h4 class="mb-0">9° ETAPA - LOCAL DO EVENTO</h4>
                                    </button>

                                </div>             

                            </div>

                            <div id="collapseEndereco" class="row collapse" aria-labelledby="headingEndereco" data-parent="#accordionExample">

                                <div class="col-lg-12">

                                    <div class="card-body">

                                        <div id="enderecoFestaInf">

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </div>                         

                        <!--Informações finais-->  
                        <div class="card border-dark">

                            <div class="card-header row" id="headingInformacoesFinais">

                                <div class="col-lg-4 my-2">

                                    <button class="btn btn-info btn-block" onclick="editarEtapa(10)">Editar</button>

                                </div>  

                                <div class="col-lg-8 my-2">

                                    <button class="btn btn-link collapsed btn-block" type="button" data-toggle="collapse" data-target="#collapseInformacoesFinais" aria-expanded="false" aria-controls="collapseInformacoesFinais">
                                        <h4 class="mb-0">10° ETAPA - INFORMAÇÕES FINAIS</h4>
                                    </button>

                                </div> 

                            </div>

                            <div id="collapseInformacoesFinais" class="collapse row" aria-labelledby="headingInformacoesFinais" data-parent="#accordionExample">

                                <div class="col-lg-12">

                                    <div class="card-body">

                                        <h5 class="card-title" id="descricaoEventoInf"></h5>
                                        <h5 class="card-title" id="dataDaFestaInf"></h5>
                                        <h5 class="card-title" id="tipoDeFestaInf"></h5>
                                        <h5 class="card-title" id="qtdCriancaNaFestaInf"></h5>
                                        <h5 class="card-title" id="ObsInf"></h5>
                                        <h5 class="card-title" id="festaRealizadaInf"></h5>  

                                    </div>

                                </div>

                            </div>

                        </div>

                        <!-- Valores finais -->
                        <div class="card border-dark bg-light">

                            <div class="card-header row" id="headingValores">

                                <div class="col-lg-12 my-2">

                                    <button class="btn btn-link collapsed btn-block" type="button" data-toggle="collapse" data-target="#collapseValores" aria-expanded="false" aria-controls="collapseValores">
                                        <h4 class="mb-0">VALORES FINAIS DO EVENTO</h4>
                                    </button>

                                </div>   

                            </div>

                            <div id="collapseValores" class="row collapse" aria-labelledby="headingValores" data-parent="#accordionExample">

                                <div class="col-lg-12">

                                    <div class="card-body">

                                        <div id="valoresFinalInf">

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </div>   

                    </div>

                </div>

            </div>

            <div class="container" >

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-10">
                        
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
                            <input type="hidden" name="descontoEvento" id="descontoEvento" value="">
                            <input type="hidden" name="valorTotalDespesa" id="valorTotalDespesa" value="">
                            <input type="hidden" name="valorTotalLucro" id="valorTotalLucro" value="">
                            <input type="hidden" name="valorReceberContratante" id="valorReceberContratante" value="">

                            <div class="row my-5">
                                
                                <div class="col-lg-12">

                                    <button class="btn btn-success btn-lg btn-block" type="submit">Finalizar cadastro</button> 

                                </div>
                                
                            </div>

                        </form>

                        <div class="row my-1">

                            <div class="col-lg-12">

                                <button class="btn btn-secondary btn-lg btn-block" onclick="voltarEtapa10()"> Voltar </button> 

                            </div>

                        </div>

                    </div>

                </div>

            </div>                  

        </div> 

        <!--  botão de cancelar cadastro-->
        <div class="container mt-4">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-12 col-lg-10">

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
    <script>
               
        $("#jsHorario").mask("00:00");
        $("#cep").mask("00000-000");
        $("#dataFesta").mask("00/00/0000");
        $("#qtdCriancaNaFesta").mask("0000");
        $("#jsCache").mask("999999.00", {reverse: true});
        $("#jsValorPacoteAdicional").mask("999999.00", {reverse: true});
        $("#jsValorAdicional").mask("999999.00", {reverse: true});
        $("#jsValorDepesa").mask("999999.00", {reverse: true});
        $("#jsValorFormaPagamento").mask("999999.00", {reverse: true});
        $("#jsDesconto").mask("999999.00", {reverse: true});
 
    </script>
</html>
