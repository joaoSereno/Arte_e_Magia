<%-- 
    Document   : telaConfigAniversariante
    Created on : 19/03/2020, 23:24:44
    Author     : Jo�o Pedro
--%>

<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a valida��o de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notifica��o Aniversariante</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/paginaConfigAniversariante/telaConfigAniversariante.css">
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../../custom/img/logoArte_E_Magia.png" id="logo-navbar">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto mb-0">
                    <!-- Bot�o p�gina inicial -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp">P�gina Inicial</a>
                    </li>
                    <!-- Bot�o cadastros -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../cadastros.jsp">Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../../paginasDeRelatorios/relatorios.jsp">Relat�rios</a>
                    </li>                    
                    <!-- Bot�o relatorios -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="telaConfigAniversariante.jsp">Configura��o</a>                        
                    </li>
                </ul>
                <!-- Bot�o Sair -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/deslogar.jsp">Sair</a>
                    </li>
                </ul>
                <!-- Fim navbar da p�gina-->
            </div>
        </nav>
        <br>
        <div>
            <h1>Notifica��o de Aniversariante</h1>
            <!-- form para config aniversario -->
            <form method="GET" action="configAniversariante"> <%-- joga formulario para o controllerConfigAniversariante --%>
                Por favor, digite a quantidade de dias para a notifica��o de aniversariante pr�ximo:
                <br>
                Quantidade de dias:
                <input type="text" name="qtdDias">
                <button type="submit" class="btn btn-primary" value="Confirmar">Confirmar</button>
            </form>
            <br>
            <h1>${msg}</h1>
        </div>
    </body>
</html>
