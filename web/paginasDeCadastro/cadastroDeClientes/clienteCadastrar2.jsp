<%-- 
    Document   : clienteCadastrar2
    Created on : 21/04/2020, 19:35:40
    Author     : joseh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeClientes/clienteCadastrar2.css">
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
        <div class="jumbotron text-center">
            <h1>Dados do Cliente</h1>
        </div>
        <div class="container">
            <div class="d-flex justify-content-center">
                <!-- form para cadastrar cliente-->
                <form method="GET" action="cadastrarCliente"><%-- joga formulario para o controllerClienteCadastrar --%>
                    <div class="form-group">
                        <div class="form-group row">
                            <div class="col-12">
                                <label for="cadastrarCliente">Nome do Cliente</label>
                                <input type="text" name="nomeCliente" placeholder="Nome do Cliente" class="form-control" id="cadastrarCliente" required>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12">
                                <label for="cpfCliente">CPF Cliente</label>
                                <input type="text" name="cpf" placeholder="CPF do Cliente" class="form-control" id="cpfCliente">
                            </div>
                        </div>
                        <div class="form-group row">
                             <div class="col-12">
                                <label for="tipoFesta">Tipo de Festa</label>
                                <input type="text" name="tipoFesta" placeholder="Tipo Festa" class="form-control" id="tipoFesta">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-8">
                                <label for="contatoCliente">Telefone</label>
                                <input type="text" name="contato" placeholder="Contato" class="form-control" id="contatoCliente">
                            </div>
                            <div class="col-4">
                                <label for="tipo">Tipo</label>
                                <select class='form-control' id="tipo">
                                    <option>Celular</option>
                                    <option>Fixo</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12">
                                <label for="email">E-mail</label>
                                <input type="email" name="email" placeholder="exemplo@hotmail.com" class="form-control" id="email">
                            </div>
                        </div>
                    </div>
                    <hr class="my-4">
                    <h4>Dados Residenciais</h4>
                    <div class="form-group">
                        <div class="form-group row">
                            <div class="col-4">
                                <label for="cep">CEP</label>
                                <input type="text" class="form-control" name="cep" id="cep" placeholder="CEP Logradouro">
                            </div>                    
                            <div class="col-4">
                                <label for="cidade">Cidade</label>
                                <input type="text" class="form-control" name="cidade" id="cidade" placeholder="Cidade">
                            </div>
                            <div class="col-4">
                                <label for="bairro">Bairro</label>
                                <input type="text" class="form-control" name="bairro" id="bairro" placeholder="Bairro">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-4">
                                <label for="cep">Logradouro</label>
                                <input type="text" class="form-control" name="rua" id="rua" placeholder="Nome Logradouro">
                            </div>                        
                            <div class="col-4">
                                <label for="numero">Número</label>
                                <input type="text" class="form-control" name="numero" id="numero" placeholder="Número residência">
                            </div>
                            <div class="col-4">
                                <label for="complemento">Complemento</label>
                                <input type="text" class="form-control" name="complemento" id="complemento" placeholder="Complemento">
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-warning btn-lg btn-block" type="submit" value="Finaliza Cadastro">Finalizar Cadastro</button>
                </form>  
                <!-- fim do form para cadastrar cliente-->    
            </div>
        </div>
        <div class="alert alert-success fade " role="alert">
            ${msg}
        </div>
    </body>
    <script src="../../javascripts/enderecos/enderecosAutomaticos.js"></script>      
</html>