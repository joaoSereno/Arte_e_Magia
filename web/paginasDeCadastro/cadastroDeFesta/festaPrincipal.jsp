<%-- 
    Document   : festaPrincipal
    Created on : 11/04/2020, 15:33:38
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
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customização -->   
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeFesta/festaPrincipal.css">
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../../custom/img/logoFundoLogin.png" id="logo-navbar">
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon navbar-light"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto mb-0">
                    <!-- Botão página inicial -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp"><i class="fas fa-home"></i>&nbsp;Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../cadastros.jsp"><i class="far fa-address-book"></i>&nbsp;Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../../paginasDeRelatorios/relatorios.jsp"><i class="far fa-clipboard"></i>&nbsp;Relatórios</a>
                    </li>                    
                    <!-- Botão relatorios -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../configAniversariante/telaConfigAniversariante.jsp"><i class="fas fa-cog"></i>&nbsp;Configuração</a>                        
                    </li>
                </ul>
                <!-- Botão Sair -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/deslogar.jsp"><i class="fas fa-sign-out-alt"></i>&nbsp;Sair</a>
                    </li>
                </ul>
                <!-- Fim navbar da página-->
            </div>
        </nav>
        <h3>Tela Principal Festa</h3>
        <form method="GET" action="listarFesta">
            Status do Evento:
            <select name="statusEvento">
                <option value="1">Somente não realizados</option>
                <option value="2">Somente realizados</option>
                <option value="3">Todos</option>
            </select>
            Período do Evento:
            <input type="text" name="periodoEvento">
            à
            <input type="text" name="periodoEvento2">
            <button type="submit">Listar</button>
        </form>
        <br>
        <div id="divMsgEvento" style="display: none">
            ${msgQtdEvento}
            <input type="hidden" id="controllerMsgEvento" value="${controllerMsgEvento}">
        </div>
        <!-- div de listagem evento-->
        <div id="divListagemEvento" style="display: none">
            <input type="hidden" id="controllerListagemEvento" value="${controllerListagemEvento}">
            <table id="tabela" class="table table-secondary">
                <thead> 
                    <tr>
                        <th scope="col">Descrição do Evento</th>
                        <th scope="col">Data do Evento</th>
                        <th scope="col">Evento realizado?</th>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${listaEvento}" var="item"> 
                        <tr>
                            <td>${item.descricaoFesta}</td>
                            <td>${item.dataFesta}</td>
                            <td>${item.festaStatus2}</td>
                            <!-- botão/form para editar registro cliente --> 
                            <td>
                                <form method="GET" action="edicaoEvento">
                                    <input type="hidden" name="idFesta" value="${item.idFesta}">
                                    <button class="btn btn-warning"> + </button>
                                </form> 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>              
        <form method="GET" action="preCadastroFesta">
            <button class="btn btn-primary" type="submit">Cadastrar de evento</button>        
        </form>
        <br>
        <div>
            <h5>${msgConfirmaçãoFesta}</h5>
        </div>
        <br>
        <a  class="btn btn-primary" href="../cadastros.jsp">Voltar</a> 
        <br>        
    </body>
    <script src="../../javascripts/cadastroDeFesta/festaPrincipal.js"></script>
</html>
