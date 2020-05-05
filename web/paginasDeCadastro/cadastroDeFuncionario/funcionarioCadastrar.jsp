<%-- 
    Document   : funcionarioCadastrar
    Created on : 10/02/2020, 21:44:21
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros - Funcionário</title>
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
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeFuncionario/funcionarioCadastrar.css">
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
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp"><i class="fas fa-home"></i>Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../cadastros.jsp"><i class="far fa-address-book"></i>Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../../paginasDeRelatorios/relatorios.jsp"><i class="far fa-clipboard"></i>Relatórios</a>
                    </li>                    
                    <!-- Botão relatorios -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../configAniversariante/telaConfigAniversariante.jsp"><i class="fas fa-cog"></i>Configuração</a>                        
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
        <h3>tela cadastrar funcionario</h3>
        <br>
        <br>
        <!-- form para cadastrar funcionario-->
        <div>
            <form method="POST" action="cadastrarFuncionario"> <%-- joga formulario para o controllerFuncionarioCadastrar --%>
                Nome do funcionário:
                <input type="text" name="nomeFuncionario">
                Sexo:
                <select type="select" name="sexoFuncionario">
                    <option value="M">M</option>
                    <option value="F">F</option>
                </select> 
                Contato:
                <input type="text" name="contato">
                <select type="select" name="tipoTelefone">
                    <option value="Celular">Celular</option>
                    <option value="Fixo">Fixo</option>
                </select> 
                <button type="submit" value="Cadastrar"/>Cadastrar</button>
            </form>            
        <div>
        <h3>${msg}</h3>
        <!-- fim do form para cadastrar funcionario-->
        <br>
        <br>
        <div>
            <!-- form para listar os funcionarios cadastrados -->
            <form method="POST" action="listaFuncionarios"> <%-- joga formulario para o controllerFuncionarioListar --%>
                <button type="submit" value="ListarFuncionarios"/>Listar funcionários</button>
            </form>                        
        </div>
        <br>
        <br>
        <a href="../cadastros.jsp" class="btn btn-primary" >Voltar</a>
    </body>
</html>
