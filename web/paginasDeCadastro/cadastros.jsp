<%--
    Document   : cadastros
    Created on : 08/02/2020, 19:30:44
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <title>Cadastros</title>
        <link rel="shortcut icon" href="../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customização -->     
        <link rel="stylesheet" href="../custom/css/paginaDeCadastros/paginaDeCadastros.css">
        <link rel="stylesheet" href="../custom/css/navBarOnly/navBar.css">
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../custom/img/logoFundoLogin.png" id="logo-navbar">
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon navbar-light"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto mb-0">
                    <!-- Botão página inicial -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link labelNav" href="/Arte-E-Magia_tst/paginaInicial.jsp"><i class="fas fa-home"></i>Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="cadastros.jsp"><i class="far fa-address-book"></i>Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../paginasDeRelatorios/relatorios.jsp"><i class="far fa-clipboard"></i>Relatórios</a>
                    </li>
                    <!-- Botão relatorios -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="configAniversariante/telaConfigAniversariante.jsp"><i class="fas fa-cog"></i>Configuração</a>                        
                    </li>
                </ul>
                <!-- Botão Sair -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/deslogar.jsp"><i class="fas fa-sign-out-alt"></i>Sair</a>
                    </li>
                </ul>
                <!-- Fim navbar da página-->
            </div>
        </nav>
        <!-- Cards Dos Botões -->
        <div id="card-deck">
            <!-- CardCliente -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconCliente.png" class="card-img-top imagens-cards" alt="Cliente">
                <div class="card-body">
                   <a href="cadastroDeClientes/clientePrincipal.jsp" class="btn botoes-card">Cliente</a>
                </div>
            </div>
            <!-- CardFuncionários -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconFunc.png" class="card-img-top imagens-cards" alt="Funcionário" >
                <div class="card-body">
                    <a href="cadastroDeFuncionario/funcionarioCadastrar.jsp" class="btn botoes-card">Funcionário</a>
                </div>
            </div>
            <!-- CardFestas -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconFesta.png" class="car-img-top imagens-cards" alt="Evento">
                <div class="card-body">
                    <a href="cadastroDeFesta/festaPrincipal.jsp" type="button" class="btn botoes-card">Evento</a>
                </div>
            </div>
            <!-- Card FormaPgto -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconFP.png" class="car-img-top imagens-cards" alt="Forma de pagamento">
                <div class="card-body">
                    <a href="cadastroTipoPagamento/tipoPagamentoPrincipal.jsp" class="btn botoes-card">Forma de pagamento</a>
                </div>
            </div>
            <!-- Card Tipo de Evento -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconFP.png" class="car-img-top imagens-cards" alt="Tipo de Evento">
                <div class="card-body">
                    <a href="cadastroTipoDeFesta/tipoDeFestaPrincipal.jsp" class="btn botoes-card">Tipo de Evento</a>
                </div>
            </div>
        </div>
        <div id="card-deck">
            <!-- CardTipoDespesa -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconTipoDespesa.png" class="car-img-top imagens-cards" alt="Tipo Despesas">
                <div class="card-body">
                    <a href="cadastroTipoDespesa/tipoDespesaPrincipal.jsp" type="button" class="btn botoes-card">Tipo de despesa</a>
                </div>
            </div>            
            <!--CardDespesas -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconDespesa.png" class="car-img-top imagens-cards" alt="Despesas" >
                <div class="card-body">
                    <a href="cadastroDeDespesa/despesaPrincipal.jsp" type="button "class="btn botoes-card" >Despesa</a>
                </div>
            </div>
            <!-- CardPacotes -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconPacote.png" class="car-img-top imagens-cards" alt="Pacotes">
                <div class="card-body">
                    <a href="cadastroDePacote/pacotePrincipal.jsp" type="button" class="btn botoes-card">Pacote</a>
                </div>
            </div>
            <!-- Card Pacotes Adicionais-->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconPacote.png" class="car-img-top imagens-cards" alt="Pacote Adicionais">
                <div class="card-body">
                    <a href="cadastroPacoteAdicional/pacoteAdicionalPrincipal.jsp" type="button" class="btn botoes-card">Adicional no Pacote</a>
                </div>
            </div>
            <!-- CardContaAcesso -->
            <div class="card cards">
                <img src="../custom/img/avatares-cards/iconContaUsuario.png" class="car-img-top imagens-cards" alt="Conta Acesso">
                <div class="card-body">
                    <a href="cadastroDeUsuario/usuarioCadastrar.jsp" type="button "class="btn botoes-card">Conta de acesso</a>
                </div>
            </div>
        </div>
</body>
</html>
