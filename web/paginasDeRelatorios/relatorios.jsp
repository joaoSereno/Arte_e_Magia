<%-- 
    Document   : relatorios2
    Created on : 21/04/2020, 14:40:54
    Author     : joseh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Relatórios</title>
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
        <link rel="stylesheet" href="../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../custom/css/paginaDeRelatorios/paginaDeRelatorios.css">
    </head>
    <body>
       <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../custom/img/logoFundoLogin.png" id="logo-navbar">
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon navbar-light"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto">
                    <!-- Botão página inicial -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp"><i class="fas fa-home"></i>&nbsp;Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="../paginasDeCadastro/cadastros.jsp"><i class="far fa-address-book"></i>&nbsp;Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="relatorios.jsp"><i class="far fa-clipboard"></i>&nbsp;Relatórios</a>
                    </li>                    
                    <!-- Botão relatorios -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="../paginasDeCadastro/configAniversariante/telaConfigAniversariante.jsp"><i class="fas fa-cog"></i>&nbsp;Configuração</a>                        
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
       
        <div class="jumbotron text-center">
            <h1>Relatórios</h1>
        </div>          
                       
        <div class="col-sm-12 col-md-12 col-lg-12">

            <div class="row justify-content-center">

                <div clas="col-lg-2" id="card-deck">

                    <div class="card cards my-1">

                        <img src="../custom/img/avatares-cards/relatorioEvento.png" class="car-img-top imagens-cards" alt="Eventos">

                        <div class="card-body">
                            <a href="relatorioEvento/eventoFiltroRel.jsp" class="btn bnt2 botoes-card">Eventos</a>
                        </div>

                    </div>

                </div>

                <div clas="col-lg-2" id="card-deck">

                    <div class="card cards my-1">

                        <img src="../custom/img/avatares-cards/relatorioAni.png" class="card-img-top imagens-cards" alt="Aniversariantes">

                        <div class="card-body">
                            <a href="relatorioAniversariante/aniversarianteFiltroRel.jsp" class="btn bnt2 botoes-card">Aniversariantes</a>
                        </div>
                    </div>

                </div>


                <div clas="col-lg-2" id="card-deck">

                    <div class="card cards my-1">

                        <img src="../custom/img/avatares-cards/relatorioTD.png" class="card-img-top imagens-cards" alt="Tipos de Despesa">

                        <div class="card-body">
                            <a href="relatorioTipoDespesa/tipoDespesaFiltroRel.jsp" class="btn bnt2 botoes-card">Tipos de Despesa</a>
                        </div>

                    </div>

                </div>
                
                <div clas="col-lg-2" id="card-deck">

                    <div class="card cards my-1">

                        <img src="../custom/img/avatares-cards/relatorioFunc.png" class="car-img-top imagens-cards" alt="Colaboradores">

                        <div class="card-body">
                            <a href="relatorioFuncionario/funcionarioFiltroRel.jsp" type="button" class="btn bnt2 botoes-card">Colaboradores</a>
                        </div>

                    </div>

                </div>

                <div clas="col-lg-2" id="card-deck">

                    <div class="card cards my-1">

                        <img src="../custom/img/avatares-cards/relatorioPacote.png" class="car-img-top imagens-cards" alt="Pacotes">

                        <div class="card-body">
                            <a href="relatorioPacote/pacoteFiltroRel.jsp" class="btn bnt2 botoes-card">Pacotes</a>
                        </div>

                    </div>

                </div>                

            </div>

        </div>
       
        <div class="my-3">

        </div>            

</html>
