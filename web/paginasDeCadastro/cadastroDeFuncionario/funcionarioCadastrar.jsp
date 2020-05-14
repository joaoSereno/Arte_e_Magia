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
        <meta name="viewport" content="width=device-width, initial-scale=1">         
        <title>Cadastros - Colaborador</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA=" crossorigin="anonymous"></script>
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
            <h1>Cadastrar Colaborador</h1>
        </div>         
        <!-- form para cadastrar funcionario-->
        <div class="container">

            <div class="row justify-content-center">
                
                <div class="col-sm-12 col-md-10 col-lg-8">
                    
                    <form method="POST" action="cadastrarFuncionario">
                        
                        <div class="form-row">

                            <div class="form-group col-lg-8">

                                <label for="nomeFuncionario">Nome do Colaborador *</label>
                                <input type="text" class="form-control" maxlength="45" placeholder="Ex: Jeniffer Nobre" name="nomeFuncionario" id="nomeFuncionario" required>

                            </div>

                            <div class="form-group col-lg-4">

                                <label for="sexoFuncionario">Gênero *</label>
                                <select id="sexoFuncionario" class="form-control" name="sexoFuncionario">
                                    <option value="F" selected>F</option>
                                    <option value="M" >M</option>
                                </select>
                    
                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-8">

                                <label for="contato">Contato *</label>
                                <input type="text" class="form-control" placeholder="Ex: (17) 99261-2072" name="contato" id="contato" required>

                            </div>

                            <div class="form-group col-lg-4">

                                <label for="tipoTelefone">Tipo do Contato *</label>
                                <select id="tipoTelefone" class="form-control" name="tipoTelefone">
                                    <option value="Celular" selected>Celular</option>
                                    <option value="Fixo">Fixo</option>
                                </select>

                            </div>

                        </div>     
                        
                        <div class="form-row">

                            <div class="form-group col-lg-12 my-2">

                                <button type="submit" class="btn btn-info btn-lg btn-block" >Confirmar</button>
                                
                            </div>
                            
                        </div>                        
                        
                    </form>
                    
                    <div class="row">

                        <div class="col-lg-12 text-center my-2">

                            <h3>${msg}</h3>

                        </div>

                    </div>                      

                </div>

            </div>

        </div>        
                            
        <div class="container my-2">
            
            <div class="row justify-content-center">
                
                <div class="col-sm-12 col-md-10 col-lg-8">
                    
                        <form method="POST" action="listaFuncionarios"> <%-- joga formulario para o controllerFuncionarioListar --%>
                            
                            <div class="form-col-lg-8 my-3">
                                <button type="submit" class="btn btn-info btn-lg btn-block">Listar Colaboradores</button>
                            </div>
                            
                        </form>  

                            
                    <div class="form-col-lg-8 my-4">

                        <a href="../cadastros.jsp" class="btn btn-secondary btn-lg btn-block" >Voltar</a>

                    </div>
                            
                </div>  
                
            </div>
            
        </div>                    
    </body>
    <script src="../../javascripts/telefones/telefone.js"></script>
</html>
