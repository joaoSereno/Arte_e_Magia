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
        <title>Cadastros - Despesa</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../../custom/img/logoArte_E_Magia.png" id="logo-navbar">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto mb-0">
                    <!-- Botão página inicial -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp">Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../cadastros.jsp">Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../../paginasDeRelatorios/relatorios.jsp">Relatórios</a>
                    </li>                    
                    <!-- Botão relatorios -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../configAniversariante/telaConfigAniversariante.jsp">Configuração</a>                        
                    </li>
                </ul>
                <!-- Botão Sair -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/deslogar.jsp">Sair</a>
                    </li>
                </ul>
                <!-- Fim navbar da página-->
            </div>
        </nav>
        <h3>Tela cadastro despesa</h3>
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
        <div> 
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
    </body>
    <script src="../../javascripts/cadastroDeDespesa/cadastrarDespesa.js"></script>
    <script src="../../javascripts/cadastroDeDespesa/cadastrarDespesa2.js"></script>
</html>
