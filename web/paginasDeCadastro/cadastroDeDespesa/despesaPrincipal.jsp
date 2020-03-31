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
        <h3>Listar despesa</h3>
        <form method="GET" action="listarDespesas">
            Origem Despesa
            <select name="origem">
                <option value="1">Cadastro de Despesa</option>
                <option value="2">Cadastro de Festa</option>
            </select>
            Exibir
            <select name="exibir">
                <option value="1">Somente abertas</option>
                <option value="2">Somente fechadas</option>
                <option value="3">Todas</option>
            </select>
            <button type="submit">Listar</button>
        </form>         
        <br>
        <br>
        <!-- div de listagem despesas-->          
        <div>
            <table id="tabela" class="table table-secondary">
                <thead> 
                    <tr>    
                        <th scope="col">Origem despesa</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Status</th>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${listaDespesas}" var="item"> 
                        <tr>
                            <td>${item.origem}</td>
                            <td>${item.descricao}</td>
                            <td>${item.status}</td>
                            <!-- botão/form para editar registro cliente --> 
                            <td>
                                <form method="GET" action="edicaoDespesa">
                                    <input type="hidden" name="idDespesas" value="${item.idDespesas}">
                                    <button class="btn btn-warning"> + </button>
                                </form> 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>         
        <a  class="btn btn-primary" href="despesaCadastrar.jsp">Cadastrar Despesa</a>
        <br>
        <br>
        <a  class="btn btn-primary" href="../cadastros.jsp">Voltar</a> 
        <br>
    </body>
</html>
