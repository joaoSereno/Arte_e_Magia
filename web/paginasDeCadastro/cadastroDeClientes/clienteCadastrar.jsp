<%-- 
    Document   : clienteCadastrar
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA=" crossorigin="anonymous"></script>        
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customização -->       
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeClientes/clienteCadastrar.css">
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
            <h1>Cadastrar Cliente</h1>
        </div> 
        
        <div class="container">

            <div class="row justify-content-center">
                
                <div class="col-sm-12 col-md-10 col-lg-8">          
                    
                    <form class="form-group" method="GET" action="cadastrarCliente">
                        
                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <h3><i class="fas fa-user-check"></i> Dados do Cliente </h3>

                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-4">

                                <label for="nomeCliente">Nome do Cliente *</label>
                                <input type="text" class="form-control" maxlength="45" placeholder="Ex: Poliana" name="nomeCliente" id="nomeCliente" required>

                            </div>

                            <div class="form-group col-lg-4">

                                <label for="cpf">CPF do Cliente *</label>
                                <input type="text" class="form-control" minlength="14" placeholder="000.000.000-00" name="cpf" id="cpf" required>
                    
                            </div>

                            <div class="form-group col-lg-4">

                                <label for="tipoFesta">Tipo de Evento *</label>
                                <select type="select" class="form-control" id="tipoFesta" name="tipoFesta" required>
                                    <option value="">Clique para selecionar</option>
                                        <c:forEach var="item" items="${listaTipoDeFesta}">
                                            <option value="${item.idTipoDeFesta}">
                                                ${item.descricaoTipoDeFesta}
                                            </option>
                                        </c:forEach>
                                </select>      

                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-5">

                                <label for="email"> E-mail: *</label>
                                <input type="email" class="form-control" maxlength="45" placeholder="Ex: exemplo@hotmail.com" name="email" id="email" required>

                            </div>

                            <div class="form-group col-lg-4">

                                <label for="contato">Contato: *</label>
                                <input type="text" class="form-control" minlength="13" placeholder="Ex: (17) 99261-2072" name="contato" id="contato" required>
                    
                            </div>

                            <div class="form-group col-lg-3">

                                <label for="tipoTelefone">Tipo do Contato *</label>
                                <select id="tipoTelefone" class="form-control" name="tipoTelefone">
                                    <option value="Celular" selected>Celular</option>
                                    <option value="Fixo">Fixo</option>
                                </select>

                            </div>

                        </div>

                        <div class="form-row mt-3">

                            <div class="form-group col-lg-12">

                                <h3><i class="fas fa-map-marker-alt"></i> Dados Residênciais </h3>

                            </div>

                        </div>   

                        <div class="form-row">

                            <div class="form-group col-lg-6">

                                <label for="cep"> CEP: *</label>
                                <input type="text" class="form-control" minlength="9" placeholder="00000-000" name="cep" id="cep" required>

                            </div>

                            <div class="form-group col-lg-6">

                                <label for="cidade">Cidade: *</label>
                                <input type="text" class="form-control" placeholder="Ex: São José do Rio Preto" name="cidade" id="cidade" required>
                    
                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-6">

                                <label for="bairro"> Bairro: *</label>
                                <input type="text" class="form-control" placeholder="Ex: Jardim Santo Antônio" name="bairro" id="bairro" required>

                            </div>

                            <div class="form-group col-lg-6">

                                <label for="rua">Rua: *</label>
                                <input type="text" class="form-control" placeholder="Ex: Rua Walder Antonio Sbrogio" name="rua" id="rua" required>
                    
                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-6">

                                <label for="numero"> Número: *</label>
                                <input type="text" class="form-control" placeholder="Ex: 12" name="numero" id="numero" required>

                            </div>

                            <div class="form-group col-lg-6">

                                <label for="rua">Complemento: *</label>
                                <input type="text" class="form-control" placeholder="Ex: fundo casa 6" name="complemento" id="complemento">
                    
                            </div>

                        </div>
                        
                        <div class="form-row">

                            <div class="form-group col-lg-12 my-2">

                                <button type="submit" class="btn btn-info btn-lg btn-block" >Cadastrar Cliente</button>
                                
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
                    
                    <div class="form-col-lg-12">

                        <a href="clientePrincipal.jsp" class="btn btn-secondary btn-lg btn-block" >Voltar</a>

                    </div>
                            
                </div>  
                
            </div>
            
        </div>        
    </body>
    <script src="../../javascripts/enderecos/enderecosAutomaticos.js"></script>
    <script src="../../javascripts/telefones/telefone.js"></script>
    <script>
        $("#cpf").mask("000.000.000-00");
        $("#cep").mask("00000-000");
    </script>      
</html>
