<%--
    Document   : paginaInicial
    Created on : 02/02/2020, 17:57:26
    Author     : João Pedro

    Página inicial do sistema.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Página Inicial</title>
        <link rel="shortcut icon" href="custom/img/favicon.jpg">
        <!-- Script Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customização -->       
        <link rel="stylesheet" href="custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="custom/css/paginaInicial/paginaInicial.css" />
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="custom/img/logoFundoLogin.png" id="logo-navbar">
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon navbar-light"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto">
                    <!-- Botão página inicial -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp"><i class="fas fa-home"></i>&nbsp;Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="paginasDeCadastro/cadastros.jsp"><i class="far fa-address-book"></i>&nbsp;Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="paginasDeRelatorios/relatorios.jsp"><i class="far fa-clipboard"></i>&nbsp;Relatórios</a>
                    </li>                    
                    <!-- Botão relatorios -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="paginasDeCadastro/configAniversariante/telaConfigAniversariante.jsp"><i class="fas fa-cog"></i>&nbsp;Configuração</a>                        
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
            <h1>Bem vindo ao sistema do Arte & Magia</h1>
        </div>
        
        <div class="container my-2">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">

                            <p id="textoEventoAgendados">Liste os eventos agendados através do botão "Eventos Agendados".</p>

                        </div>
                        
                    </div>  
                    
                    <div class="row">
                        
                        <div class="col-lg-12">

                            <form method="GET" action="listarAgendamentos">
                                <button type="submit" class="btn btn-info btn-lg btn-block" value="listagemAgendamento">Eventos Agendados</button>
                            </form>   

                        </div>
                        
                    </div>  
                                        
                </div>  
                
            </div> 
            
        </div> 
                            
        <div class="container my-3">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">

                            <p id="textoValidacaoAgendamento" class="text-danger">${msgValidacaoAgendamento}</p> 

                        </div>
                        
                    </div>   
                                        
                </div>  
                
            </div> 
            
        </div>                         
        
        <div class="container my-2" id="divAgendamentoFesta" style="display: none">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">        
                            
                            <div class="table-responsive border border-secondary rounded"> 
                                
                                <input type="hidden" id="controllerListagemAgendamento" value="${controllerListagemAgendamento}">          
                                
                                <table class="table table-striped table-bordered">
                                    <thead>
                                        <tr class="bg-danger">
                                            <th>Descrição do Evento</th>
                                            <th>Data do Evento</th>
                                            <th>Tipo de Evento</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listaAgendamentoFesta}" var="item"> 
                                            <tr>
                                                <td>${item.descricaoFesta}</td>
                                                <td>${item.dataEvento}</td>
                                                <td>${item.tipoDeFesta}</td>
                                                <!-- form para detalhes do agendamento--> 
                                                <td>
                                                    <form method="GET" action="agendamentoDetalhe"> 
                                                        <input type="hidden" name="idTabelaAgendamentoFesta" value="${item.idTabelaAgendamentoFesta}">
                                                        <button class="btn btn-info">+Detalhes</button>
                                                    </form> 
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
                                
        <div class="container mt-4">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">

                            <p id="textoAniversariantes">Liste os aniversariantes próximos através do botão "Aniversariantes Próximos".</p>

                        </div>
                        
                    </div>  
                    
                    <div class="row">
                        
                        <div class="col-lg-12">

                            <form method="GET" action="listarAniversariantesProximos">
                                <button type="submit" class="btn btn-info btn-lg btn-block" value="listarAniversariantesProximos">Aniversariantes Próximos</button>
                            </form>      

                        </div>
                        
                    </div>  
                                               
                </div>  
                
            </div> 
            
        </div>

        <div class="container my-3">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">
                                                                                        <!--Desculpe, não encontramos aniversariante dentro do período configurado. -->
                            <h5 id="textoValidacaoAniversariante" class="text-danger">${msgValidacaoAniversariantesProximos}</h5>

                        </div>
                        
                    </div>   
                                        
                </div>  
                
            </div> 
            
        </div>                            
        
        <div class="container" id="listagemAniversariantesProximos" style="display: none">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">        

                            <div class="table-responsive border border-secondary rounded"> 

                                <input type="hidden" id="listagemAniversariantesProximos" value="${listagemAniversariantesProximos}">            

                                <table class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">Aniversariante</th>
                                            <th scope="col">Dias para Aniversario</th>
                                            <th scope="col">Idade a Fazer</th>
                                            <th scope="col">Contratante</th>
                                            <th scope="col">Contato</th>
                                            <th scope="col"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listaAniversariantesProximos}" var="item"> 
                                            <tr>
                                                <td>${item.descricaoFesta}</td>
                                                <td>${item.dataEvento}</td>
                                                <td>${item.tipoDeFesta}</td>
                                                <td>${item.tipoDeFesta}</td>
                                                <td>${item.tipoDeFesta}</td>
                                                <td>
                                                    <form method="GET" action="verCadastroAniversariante"> 
                                                        <input type="hidden" name="idCliente" value="${item.idCliente}">
                                                        <button class="btn btn-warning">Ver Cadastro</button>
                                                    </form> 
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
                                
    </body>
    <script src="javascripts/paginaInicial/paginaInicial.js"></script>
</html>
