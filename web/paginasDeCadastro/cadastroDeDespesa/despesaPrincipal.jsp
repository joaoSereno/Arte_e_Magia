<%-- 
    Document   : despesaPrincipal
    Created on : 30/03/2020, 20:22:57
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">          
        <title>Cadastros - Despesa</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA=" crossorigin="anonymous"></script>          
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeDespesa/despesaPrincipal.css">
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
            <h1>Despesas</h1>
        </div>
        
        <div class="container my-3" id="divMsgValidacaoExclusao" style="display: none">
            
            <input type="hidden"  id="msgValidacaoExclusaoController" value="${msgValidacaoExclusaoController}">
            
            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">
                            
                            <h4 class="text-success">${msgValidacaoExclusao}</h4>
                            
                        </div>
                        
                    </div>

                </div>  

            </div>

        </div>  
                            
        <div class="container my-3" id="divMsgEdicao" style="display: none">
            
            <input type="hidden"  id="msgEdicaoController" value="${msgEdicaoController}">
            
            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">
                            
                            <h4 class="text-success">${msgEdicao}</h4>
                            
                        </div>
                        
                    </div>

                </div>  

            </div>

        </div>        
        
        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <form method="GET" action="preCadastroDespesa">

                        <div class="form-row">
                
                            <button type="submit" class="btn btn-info btn-lg btn-block" >+Nova Despesa</button>

                        </div>

                    </form>

                </div>  

            </div>
        
        </div>
        
        <div class="container my-3 mt-4">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">
                            
                            <h4>Informe os filtros a baixo e liste as despesas cadastradas:</h4>
                            
                        </div>
                        
                    </div>

                </div>  

            </div>

        </div>         
        
        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <form method="GET" action="listarDespesas">

                        <div class="form-row"> 
                            
                            <div class="form-group col-lg-6">
                                
                                <label for="origem"><h5>Origem da Despesa: *</h5></label>
                                <select id="origem" name="origem" class="form-control">
                                    <option value="1">Cadastro de Despesa</option>
                                    <option value="2">Cadastro de Evento</option>
                                    <option value="3">Ambas</option>
                                </select>

                            </div>
                            
                            <div class="form-group col-lg-6">
                                
                                <label for="exibir"><h5>Exibir *</h5></label>
                                <select id="exibir" name="exibir" class="form-control">
                                    <option value="1">Somente não pagas</option>
                                    <option value="2">Somente pagas</option>
                                    <option value="3">Ambas</option>
                                </select>

                            </div>
                            
                        </div>
                        
                        <div class="form-row">

                            <div class="form-group col-lg-3">
                                <h5>Período:</h5>
                            </div>

                            <div class="form-group col-lg-4">
                                <input type="text" class="form-control" minlength="10" id="periodoDespesa" name="periodoDespesa" placeholder="00/00/0000"> 
                            </div>

                            <div class="form-group text-center col-lg-1">
                                <h5>à</h5>
                            </div>

                            <div class="form-group col-lg-4">
                                <input type="text" class="form-control" minlength="10" id="periodoDespesa2" name="periodoDespesa2" placeholder="00/00/0000">
                            </div>

                        </div>
                        
                        <div class="form-row">
                            
                            <div class="form-group col-lg-12">
                                
                                <button type="submit" class="btn btn-info btn-lg btn-block" >Listar Despesas</button>
                                
                            </div>  
                            
                        </div>

                    </form>

                </div>  

            </div>
        
        </div>
        
        <div class="container my-3" id="msgValidacao" style="display: none">
            
            <input type="hidden"  id="msgValidacaoController" value="${msgValidacaoController}">
            
            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">
                            
                            <h5 class="text-danger">${msgValidacao}</h5>
                            
                        </div>
                        
                    </div>

                </div>  

            </div>

        </div>
        
        <div class="container mt-4 my-3">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">

                            <a  class="btn btn-secondary btn-lg btn-block" href="../cadastros.jsp">Voltar</a>
                            
                        </div>
                        
                    </div>

                </div>  

            </div>

        </div>            
    </body>
    <script src="../../javascripts/cadastroDeDespesa/despesaPrincipal.js"></script>    
</html>
