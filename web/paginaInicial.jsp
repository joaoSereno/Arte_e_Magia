<%--
    Document   : paginaInicial
    Created on : 02/02/2020, 17:57:26
    Author     : João Pedro

    Página inicial do sistema.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial</title>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">

            <a class="navbar-brand" href="/Arte-E-Magia_tst/paginaInicial.jsp">Arte e Magia</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon"></span></button>

            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav">
                    <!-- botão sair -->
                    <li class="nav-item">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp">Página Inicial</a>
                    </li>
                    <!-- botão cadastros -->
                    <li class="nav-item">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginasDeCadastro.jsp">Cadastros</a>
                    </li>
                    <!-- botão relatorios -->
                    <li class="nav-item">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginasDeRelatorio.jsp">Relatórios</a>
                    </li>
                    <!-- botão sair que redireciona para a página deslogar.jsp -->
                    <li class="nav-item">
                        <a class="nav-link" href="/Arte-E-Magia_tst/deslogar.jsp">Sair</a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- fim navbar da página-->
        <br>
    </body>
</html>
