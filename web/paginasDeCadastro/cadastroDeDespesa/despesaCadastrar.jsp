<%-- 
    Document   : despesaCadastrar
    Created on : 07/03/2020, 19:56:08
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
        <title>Cadastros - Despesa</title>
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
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeDespesa/despesaCadastrar.css">
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
            <h1>Despesas - Cadastrar</h1>
        </div>   
        <br>
        <button type="button" onclick="tipoDespesa()"/>DESCRIÇÃO MANUAL</button>
        <!--   form para listar os tipos de despesa no campo "tipoDespesa" -->
        <form method="GET" action="listarTipoDespesa">
            <button type="submit">TIPO DE DESPESA</button> 
        </form>
        <br>
        <form id="formAddDespesa">
            Valor:
            <input type="text" name="jsValorDepesa" value="">
            Data de pagamento:
            <input type="text" name="jsDataPagamento" value="">
            Despesa paga?
            <select name="jsDespesaPpaga">
                <option>Sim</option>
                <option>Não</option>
            </select>
            <button type="button" id="add-despesa">+</button> 
        </form> 
        <br>
        <div id="divTabelaDespesa" style="display: none"> 
            <table id="tabelaDespesas">
                <thead> 
                    <tr>    
                        <th>Valor</th>
                        <th>Data de Pamento</th>
                        <th>Pago?</th>
                        <th></th>
                    </tr>
                </thead> 
                <tbody id="tbodyDespesas">
                </tbody>
            </table> 
        </div>
        <br>
        <!-- form para cadastrar despesa -->
        <form method="POST" id="cadastrarDespesaForm" action="cadastrarDespesa">
            <input type="hidden" id="countDespesa" name="countDespesa" value="0">
            <div id="divDescricao">
                Descrição da despesa:
                <input type="text" name="descricaoDespesa" value="${descricaoDespesa}">            
            </div>
            <div id="divTipoDespesa" style="display: none"> 
                <input type="hidden" id="valorDisplay" value="${valorDisplay}">
                Tipo de despesa:
                <select type="select" name="tipoDespesa" >
                    <option value="">Clique para selecionar</option>
                        <c:forEach var="item" items="${listaTipoDespesas}">
                            <option value="${item.idTipoDeDespesa}">
                                ${item.nomeDespesa}
                            </option>
                        </c:forEach>
                </select>                                
            </div>
            <br>
            Observação:
            <input type="text" name="obsDespesa" value="${obsDespesa}">
            <br>
            <br>
            <button type="submit">Cadastrar</button>
        </form> 
        <br>
        <h3>${msg}</h3>
        <br>
        <br>
        <a class="btn btn-primary"  href="despesaPrincipal.jsp">Voltar</a>
    </body>
    <script src="../../javascripts/cadastroDeDespesa/cadastrarDespesa.js"></script>
    <script src="../../javascripts/cadastroDeDespesa/cadastrarDespesa2.js"></script>
</html>
