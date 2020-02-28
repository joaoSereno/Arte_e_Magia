<%-- 
    Document   : funcionarioPrincipal
    Created on : 08/02/2020, 21:14:39
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros - Funcionário</title>
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
        <!-- fim navbar da página-->
       
        <!-- div de listagem funcionario-->          
        <div>
            <table id="tabela" class="table table-secondary">
                <thead> 
                    <tr>    
                        <th scope="col">Nome</th>
                        <th scope="col">Sexo</th>
                        <th scope="col">Contato</th>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${funcionarios}" var="item"> 
                        <tr>
                            <td>${item.nomeFuncionario}</td>
                            <td>${item.sexo}</td>
                            <td>${item.telefonePrincipal}</td>
                            <!-- botão/form para editar registro funcionario --> 
                            <td>
                                <form method="GET" action="editarCadastroFuncionario">
                                    <input type="hidden" name="idFuncionario" value="${item.idFuncionario}">
                                    <input type="hidden" name="nomeFuncionario" value="${item.nomeFuncionario}">
                                    <input type="hidden" name="sexo" value="${item.sexo}">
                                    <button class="btn btn-warning"> + </button>
                                </form> 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> 
        <!-- fim  div de listagem funcionario--> 
        <br>
        <!-- botão de voltar página-->
        <a href="funcionarioCadastrar.jsp" class="btn btn-primary" >Voltar</a>
    </body>
</html>
