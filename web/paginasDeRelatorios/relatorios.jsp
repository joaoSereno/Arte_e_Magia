<%--
    Document   : relatorios
    Created on : 08/02/2020, 20:06:13
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatórios</title>
        <link rel="shortcut icon" href="../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../custom/css/paginaDeRelatorios/paginaDeRelatorios.css">
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../custom/img/logoArte_E_Magia.png" id="logo-navbar">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto mb-0">
                    <!-- Botão página inicial -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link labelNav" href="/Arte-E-Magia_tst/paginaInicial.jsp">Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../paginasDeCadastro/cadastros.jsp">Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="relatorios.jsp">Relatórios</a>
                    </li>
                    <!-- Botão relatorios -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../paginasDeCadastro/configAniversariante/telaConfigAniversariante.jsp">Configuração</a>                        
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
        <!-- Cards Dos Botões -->
        <div id="card-deck">
            <!-- CardCliente -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/relatorioAni.png" class="card-img-top imagens-cards" alt="Aniversariante">
                <div class="card-body">
                    <a href="cadastroDeClientes/clienteCadastrar.jsp" class="btn botoes-card">Relatório - Aniversariante</a>
                </div>
            </div>
            <!-- CardFuncionários -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconFunc.png" class="card-img-top imagens-cards" alt="Tipo de Despesa" >
                <div class="card-body">
                    <a href="cadastroDeFuncionario/funcionarioCadastrar.jsp" class="btn botoes-card">Relatório - Tipo de Despesa</a>
                </div>
            </div>
            <!-- CardFestas -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/relatorioFunc.png" class="car-img-top imagens-cards" alt="Festa">
                <div class="card-body">
                    <a href="cadastroDeFesta/clientePrincipal.jsp" type="button" class="btn botoes-card">Relatório - Funcionário</a>
                </div>
            </div>
            <!-- Card FormaPgto -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconFP.png" class="car-img-top imagens-cards" alt="Forma de pagamento">
                <div class="card-body">
                    <a href="cadastroTipoPagamento/tipoPagamentoPrincipal.jsp" class="btn botoes-card">Relatório - Pacote</a>
                </div>
            </div>
        </div>
</html>
