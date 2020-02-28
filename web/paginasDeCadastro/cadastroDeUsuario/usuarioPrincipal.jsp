<%-- 
    Document   : usuarioPrincipal
    Created on : 08/02/2020, 21:15:05
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros - Usuário</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
        <!--        navbar da página-->
        <nav class="navbar navbar-light navbar-expand-lg" style="background-color: #ef1b3436;">
            <!-- logo do navbar -->
            <div>
                <a class="navbar-brand">
                    <img src="../../custom/img/logoArte_E_Magia.png" width="130" height="60" class="d-inline-block align-top" alt="Logo Arte & Magia">
                </a>
            </div>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <!-- botão sair -->
                    <li class="nav-item">
                        <a href="/Arte-E-Magia_tst/paginaInicial.jsp" class="btn btn-outline-light" style="background-color: #ec1b1b00;">Página Inicial</a>
                    </li>
                    <!-- botão cadastros -->
                    <li class="nav-item">
                        <a href="../cadastros.jsp" class="btn btn-outline-light" style="background-color: #ec1b1b00;">Cadastros</a>
                    </li>
                    <!-- botão relatorios -->
                    <li class="nav-item">
                        <a href="../../paginasDeRelatorios/relatorios.jsp" class="btn btn-outline-light" style="background-color: #ec1b1b00;">Relatórios</a>
                    </li>
                    <!-- botão sair que redireciona para a página deslogar.jsp -->
                    <li class="nav-item">
                        <a href="/Arte-E-Magia_tst/deslogar.jsp" class="btn btn-outline-light" style="background-color: #ec1b1b00;">Sair</a>
                    </li>
                </ul>
            </div>
        </nav>
        <br><br>
        <!-- botão/form de listar os usuários do sistema-->  
        <form method="GET" action="usuariosListar"> 
            <button type="submit" class="btn btn-primary">Listar usuários</button>
        </form>
        <br>
        <!-- div de listagem usuários do sistemaa-->          
        <div>
            <table id="tabela" class="table table-secondary">
                <thead> 
                    <tr>    
                        <th scope="col">Nome</th>
                        <th scope="col">Login</th>
                        <th scope="col">Tipo usuário</th>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${listaUsuarios}" var="item"> 
                        <tr>
                            <td>${item.nomeDespesa}</td>
                            <td>${item.nomeDespesa}</td>
                            <td>${item.nomeDespesa}</td>
                            <!-- botão/form para editar registro tipo despesa , envia para ControllerTipoDespesaEditar  --> 
                            <td>
                                <form method="GET" action="usuarioEditar"> 
                                    <input type="hidden" name="idTipoDeDespesa" value="${item.idTipoDeDespesa}">
                                    <input type="hidden" name="nomeDespesa" value="${item.nomeDespesa}">
                                    <button class="btn btn-warning"> Editar </button>
                                </form> 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>         
    </body>
</html>
