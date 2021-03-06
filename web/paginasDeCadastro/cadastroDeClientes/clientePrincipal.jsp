<%-- 
    Document   : clientePrincipal
    Created on : 08/02/2020, 20:45:32
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastros - Cliente</title>
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
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeClientes/clientePrincipal.css">
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
        
        <div class="jumbotron text-center">
            <h1>Clientes</h1>
        </div>
        
        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-10">

                    <form method="GET" action="listarTipoDeFestaNoCadastroCliente">

                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <button type="submit" class="btn btn-info btn-lg btn-block" >Cadastrar Cliente</button>

                            </div>
                        
                        </div>

                    </form>

                </div>
                
            </div>
            
        </div>

        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-10">

                    <form method="GET" action="listaCliente">

                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <button type="submit" class="btn btn-info btn-lg btn-block" >Listar Clientes</button>

                            </div>
                            
                        </div>
                        
                    </form>

                </div>

            </div>

        </div>
            
        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-10"> 
                    
                    <div class="col-lg-14 border border-secondary rounded" id="divListagemCliente" style="display: none">

                        <div class="table-responsive">

                            <input type="hidden" id="controllerListagemCliente" value="${controllerListagemCliente}"> 

                            <table class="table table-striped table-bordered">
                                <thead> 
                                    <tr class="bg-danger">    
                                        <th scope="col">Nome</th>
                                        <th scope="col">CPF/CNPJ</th>
                                        <th scope="col">Tipo de Festa</th>
                                        <th scope="col">Contato</th>
                                        <th></th>
                                    </tr>
                                </thead> 
                                <tbody>
                                    <c:forEach items="${clientes}" var="item"> 
                                        <tr>
                                            <td>${item.nomeCliente}</td>
                                            <td>${item.cpf}</td>
                                            <td>${item.tipoDeFesta}</td>
                                            <td>${item.telefonePrincipal}</td>
                                            <td>
                                                <form method="GET" action="editarCadastroCliente">
                                                    <input type="hidden" name="idCliente" value="${item.idCliente}">
                                                    <button class="btn btn-info"> + </button>
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
                            
        <div class="container my-4">
            
            <div class="row justify-content-center">
                
                <div class="col-sm-12 col-md-10 col-lg-10">
                         
                    <div class="col-lg-14">
                            
                        <a href="../cadastros.jsp" class="btn btn-secondary btn-lg btn-block" >Voltar</a>

                    </div>
                            
                </div>  
                
            </div>
            
        </div>                             

    </body>
    <script src="../../javascripts/cadastroDeClientes/clientePrincipal.js"></script>      
</html>
