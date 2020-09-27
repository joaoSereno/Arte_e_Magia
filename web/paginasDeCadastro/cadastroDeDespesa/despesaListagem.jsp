<%-- 
    Document   : despesaListagem
    Created on : 31/05/2020, 18:02:03
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
        <title>Cadastros - Despesas</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeDespesa/despesaListagem.css">
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
            <h4>Origem:  ${origemDaDespesa} | Exibir: ${exibirDespesa} | Período: ${periodoDespesa} à ${periodoDespesa2} </h4>
        </div>

        <input type="hidden" id="origemDespesa" value="${origemDespesa}">
        <input type="hidden" id="origemEvento" value="${origemEvento}">
        <input type="hidden" id="origemEventoSemConteudo" value="${origemEventoSemConteudo}">
        <input type="hidden" id="origemDespesaSemConteudo" value="${origemDespesaSemConteudo}">

        <div id="divOrigemDespesa" class="my-3" style="display: none">

            <div class="container">

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-12">

                        <h4>Origem: Cadastro de Despesa</h4>

                        <div class="row my-2 mt-4">

                            <div class="col-lg-4">

                                <h4>Valor Total: R$ ${valorTotalDespesa}</h4> 

                            </div>
                            
                            <div class="col-lg-4">

                                <h4>Valor Pago: R$ ${valorPagoDespesa}</h4> 

                            </div>
                            
                            <div class="col-lg-4">

                                <h4>Valor em Aberto: R$ ${valorAbertoDespesa}</h4> 

                            </div>

                        </div>                        

                        <div class="table-responsive border border-secondary rounded">

                            <table class="table table-striped table-bordered">
                                <thead> 
                                    <tr class="bg-danger">    
                                        <th scope="col">Descrição da Despesa</th>
                                        <th scope="col">Valor Total</th>
                                        <th scope="col">Valor Pago</th>
                                        <th scope="col">Pago?</th>
                                        <th></th>
                                    </tr>
                                </thead> 
                                <tbody>
                                    <c:forEach items="${listagemDespesaDespesa}" var="item"> 
                                        <tr>
                                            <td>${item.descricaoDespesa}</td>
                                            <td>${item.valor}</td>
                                            <td>${item.valorPago}</td>
                                            <td>${item.pago}</td>
                                            <td>
                                                <form method="POST" action="editarDespesa">                                               
                                                    <input type="hidden" name="periodoDespesa" value="${periodoDespesa}">
                                                    <input type="hidden" name="periodoDespesa2" value="${periodoDespesa2}">
                                                    <input type="hidden" name="exibir" value="${exibir}">
                                                    <input type="hidden" name="origem" value="${origem}">
                                                    <input type="hidden" name="idDespesa" value="${item.idDespesa}">
                                                    <button class="btn btn-info"> +Detalhes </button>
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

        </div>

        <div id="divOrigemDespesaSemConteudo" class="my-3" style="display: none">

            <div class="container">

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-12">

                        <h4>Origem: Cadastro de Despesa</h4>

                        <h5>${msgTratamentoSemConteudo}</h5>

                    </div> 

                </div> 

            </div>

        </div>


        <div id="divOrigemEvento" class="my-3 mt-5" style="display: none">

            <div class="container">

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-12">

                        <h4>Origem: Cadastro de Evento</h4>
                        
                        <div class="row my-2 mt-4">

                            <div class="col-lg-4">

                                <h4>Valor Total: R$ ${valorTotalEvento}</h4> 

                            </div>
                            
                            <div class="col-lg-4">

                                <h4>Valor Pago: R$ ${valorPagoEvento}</h4> 

                            </div>
                            
                            <div class="col-lg-4">

                                <h4>Valor em Aberto: R$ ${valorAbertoEvento}</h4> 

                            </div>

                        </div>  
                        
                        <div class="table-responsive border border-secondary rounded">

                            <table class="table table-striped table-bordered">
                                <thead> 
                                    <tr  class="bg-danger">  
                                        <th scope="col">Descrição do Evento</th>
                                        <th scope="col">Valor Total</th>
                                        <th scope="col">Valor Pago</th>
                                        <th scope="col">Pago?</th>
                                        <th></th>
                                    </tr>
                                </thead> 
                                <tbody>
                                    <c:forEach items="${listagemDespesaEvento}" var="item"> 
                                        <tr>
                                            <td>${item.descricaoEvento}</td>
                                            <td>${item.valor}</td>
                                            <td>${item.valorPago}</td>
                                            <td>${item.pago}</td>
                                            <td>
                                                <form method="GET" action="editarFesta">
                                                    <input type="hidden" name="idFesta" value="${item.idFesta}">
                                                    <button class="btn btn-info"> +Detalhes </button>
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

        </div>

        <div id="divOrigemEventoSemConteudo" class="my-3 mt-5" style="display: none">

            <div class="container">

                <div class="row justify-content-center">

                    <div class="col-sm-12 col-md-12 col-lg-12">

                        <h4>Origem: Cadastro de Evento</h4>

                        <h5>${msgTratamentoSemConteudo}</h5>

                    </div> 

                </div> 

            </div>

        </div>                        

        <div class="container mt-4">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="form-col-lg-8 my-2">

                        <a  class="btn btn-secondary btn-lg btn-block" href="despesaPrincipal.jsp">Voltar</a> 

                    </div>

                </div>  

            </div>

        </div> 

    </body>
    <script src="../../javascripts/cadastroDeDespesa/despesaListagem.js"></script>
</html>
