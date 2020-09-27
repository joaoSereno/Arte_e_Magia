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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA=" crossorigin="anonymous"></script>        
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
            <h1>Eventos</h1>
        </div>
        
        <div class="container my-3">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <form method="GET" action="preCadastroFesta">

                        <div class="form-row">

                            <button type="submit" class="btn btn-info btn-lg btn-block" >+Novo Evento</button>

                        </div>

                    </form>

                </div>  

            </div>

        </div> 
        
        <div class="container" id="divMsgConfirmacaoDeFesta" style="display: none;">
            
            <input type="hidden" id="controllerCadastroEvento" value="${controllerCadastroEvento}">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12 my-3">
                            
                            <p id="textoFestaCastrada" class="text-success">${msgConfirmaçãoFesta}</p>
                            <p id="textoFestaCastrada" class="text-danger">${msgConfirmaçãoFestaErro}</p>
                            
                        </div>
                            
                    </div>

                </div>  

            </div>

        </div> 
                            
        <div class="container" id="divMsgConfirmacaoDeExclusaoFesta" style="display: none;">
            
            <input type="hidden" id="controllerExclusaoEvento" value="${controllerExclusaoEvento}">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12 my-3">
                            
                            <p id="textoFestaCastrada" class="text-success">${msgExclusaoFesta}</p>
                            <p id="textoFestaCastrada" class="text-danger">${msgExclusaoFestaErro}</p>
                            
                        </div>
                            
                    </div>

                </div>  

            </div>

        </div> 
                            
        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">
                        
                        <div class="col-lg-12">
                            
                            <h4>Informe os filtros a baixo e liste os eventos cadastrados:</h4>
                            
                        </div>
                        
                    </div>

                </div>  

            </div>

        </div>     
        
        <div class="container my-2">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <form method="GET" action="listarFesta">

                        <div class="form-row">

                            <div class="form-group col-lg-3">
                                <h5>Status do Evento:</h5>
                            </div>

                            <div class="form-group col-lg-9">
                                <select id="statuEvento" class="form-control" name="statusEvento">
                                    <option value="1" selected>Somente não realizados</option>
                                    <option value="2">Somente realizados</option>
                                    <option value="3">Todos</option>
                                </select>
                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-3">
                                <h5>Período:</h5>
                            </div>

                            <div class="form-group col-lg-4">
                                <input type="text" class="form-control" minlength="10" id="periodoEvento" name="periodoEvento" placeholder="00/00/0000" required> 
                            </div>

                            <div class="form-group text-center col-lg-1">
                                <h5>à</h5>
                            </div>

                            <div class="form-group col-lg-4">
                                <input type="text" class="form-control" minlength="10" id="periodoEvento2" name="periodoEvento2" placeholder="00/00/0000" required>
                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <button type="submit" class="btn btn-info btn-lg btn-block" >Listar Eventos</button>

                            </div>

                        </div>   

                    </form>

                </div>

            </div>

        </div>

        <div class="container mt-3">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="form-col-lg-8" id="divMsgEvento" style="display: none">

                        <input type="hidden" id="controllerMsgEvento" value="${controllerMsgEvento}">

                        <h4>${msgQtdEvento}</h4>

                    </div>

                </div>  

            </div>

        </div> 

        <div class="container" id="divListagemEvento" style="display: none">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="table-responsive border border-secondary rounded"> 

                        <input type="hidden" id="controllerListagemEvento" value="${controllerListagemEvento}">    

                        <table id="tabela" class="table table-striped table-bordered">
                            <thead> 
                                <tr class="bg-info">
                                    <th scope="col">Descrição do Evento</th>
                                    <th scope="col">Data do Evento</th>
                                    <th scope="col">Evento realizado?</th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
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
                                                <button class="btn btn-info"> Editar </button>
                                            </form> 
                                        </td>
                                        <td>
                                            <button onclick="excluirEvento(${item.idFesta})" class="btn btn-danger" data-toggle="modal" data-target="#confirmaçãoExclusaoEvento">Excluir</button> 
                                        </td>    
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div> 

                </div>  

            </div>

        </div>    

        <div class="container mt-3">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="form-col-lg-8 my-2">

                        <a  class="btn btn-secondary btn-lg btn-block" href="../cadastros.jsp">Voltar</a> 

                    </div>

                </div>  

            </div>

        </div>
                        
        <!-- Modal de exclusão do cadastro-->
        <div>
            
            <div class="modal fade" id="confirmaçãoExclusaoEvento" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                
                <div class="modal-dialog" role="document">
                  
                    <div class="modal-content">

                        <div class="modal-header">

                            <h5 class="modal-title" id="exampleModalLabel">Excluir Evento</h5>
                            
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">&times;</span>
                            </button>
                            
                        </div>

                        <div class="modal-body">
                          Tem certeza que deseja realizar a exclusão do evento?
                        </div>

                        <div class="container">
                            
                            <div class="row justify-content-center">
                                
                                <div class="col-sm-12 col-md-10 col-lg-8">
                                    
                                    <form method="GET" action="excluirEvento">
                                        
                                        <div class="form-row">

                                            <div class="form-group col-lg-6">

                                                <input type="hidden" id="idEventoExcluir" name="idEventoExcluir" value="">

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
                        
        </div>
                                                
    </body>
    <script src="../../javascripts/cadastroDeFesta/festaPrincipal.js"></script> 
</html>
