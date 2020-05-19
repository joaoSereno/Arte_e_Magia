<%-- 
    Document   : pacoteAdicionalPrincipal
    Created on : 01/05/2020, 17:40:00
    Author     : João Pedro
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">          
        <title>Cadastros - Pacote Adicional</title>
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
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroPacoteAdicional/pacoteAdicionalPrincipal.css">
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
            <h1>Adicional no Pacote</h1>
        </div>  
        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <form method="GET" action="editarORcadastrarPacoteAdd">

                        <input type="hidden" name="idTipoPacoteAdicional" value="${idTipoPacoteAdicionalE}">

                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <label for="descricaoPacoteAdd">Descrição do Adicional: *</label>
                                <input type="text" class="form-control" name="descricaoPacoteAdd" placeholder="Ex: Espaço Kids" id="descricaoPacoteAdd" value="${descricaoPacoteAddE}" required>

                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-6">

                                <button type="submit" class="btn btn-info btn-lg btn-block"> Confirmar </button>

                            </div>

                            <div class="form-group col-lg-6">

                                <button type="button" class="btn btn-danger btn-lg btn-block" data-toggle="modal" data-target="#confirmaçãoExclusao">
                                    Excluir
                                </button>

                            </div>                    

                        </div>

                    </form>

                    <div class="row my-3">

                        <div class="text-center col-lg-12">

                            <h3 class="text-success">${msg}</h3>

                        </div>                    

                    </div>                

                </div>

            </div>

        </div> 

        <div class="container my-2">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <form method="GET" action="listarPacoteAdicional">

                        <div class="form-col-lg-12 my-3">
                            <button type="submit" class="btn btn-info btn-lg btn-block">Listar Adicionais</button>
                        </div>

                    </form>  

                </div>  

            </div>

        </div>                    

        <div class="container my-2">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="table-responsive border border-secondary rounded" id="divPacoteAdicional" style="display: none">
                        <input type="hidden" id="controllerListagemPacoteAdicional" value="${controllerListagemPacoteAdicional}">

                        <table class="table table-striped table-bordered">
                            <thead> 
                                <tr class="bg-danger">    
                                    <th scope="col">Descrição</th>
                                    <th></th>
                                </tr>
                            </thead> 
                            <tbody>
                                <c:forEach items="${listaPacoteAdicional}" var="item"> 
                                    <tr>
                                        <td>${item.descricaoPacoteAdd}</td>
                                        <!-- botão/form para editar registro pacote add -->
                                        <td>
                                            <form method="GET" action="editarPacoteAdicional"> 
                                                <input type="hidden" name="idTipoPacoteAdicional" value="${item.idTipoPacoteAdicional}">
                                                <input type="hidden" name="descricaoPacoteAdd" value="${item.descricaoPacoteAdd}">
                                                <button class="btn btn-info"> Editar </button>
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

        <div class="container my-5">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="form-col-lg-12 my-3">

                        <a href="../cadastros.jsp" class="btn btn-secondary btn-lg btn-block" >Voltar</a>                

                    </div>   

                </div>  

            </div>

        </div>

        <!-- Modal -->
        <div class="modal fade" id="confirmaçãoExclusao" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

            <div class="modal-dialog" role="document">

                <div class="modal-content">

                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Excluir Adicional?</h5>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>

                    </div>

                    <div class="modal-body">
                        Tem certeza que deseja realizar a exclusão do cadastro?
                    </div>

                    <div class="container">

                        <div class="row justify-content-center">

                            <div class="col-sm-12 col-md-10 col-lg-8">

                                <form method="GET" action="inativarPacoteAdicional">

                                    <div class="form-row">

                                        <div class="form-group col-lg-6">

                                            <input type="hidden" name="idTipoPacoteAdicional" value="${idTipoPacoteAdicionalE}">
                                            <button type="submit" class="btn btn-danger btn-block" value="Confirmar">Sim</button>

                                        </div>

                                        <div class="form-group col-lg-6">

                                            <button type="button" class="btn btn-info btn-block" data-dismiss="modal">Não</button>

                                        </div>

                                    </div>

                                </form>  

                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </div>
    </body>
    <script src="../../javascripts/cadastroPacoteAdicional/pacoteAdicional.js"></script>          
</html>
