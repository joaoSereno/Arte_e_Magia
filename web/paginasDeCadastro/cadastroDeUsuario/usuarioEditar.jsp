<%-- 
    Document   : usuarioEditar
    Created on : 11/03/2020, 22:56:53
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
        <br>
        <h3>Edição de usuário</h3>
        <br>
        <form method="POST" action="usuarioEditar2"> 
                Login:
                <input type="text" name="login" value="${usuario.usuario}">
                <br>
                <br>
                Nome do usuário:
                <input type="text" name="nomeUsuario" value="${usuario.nomeUsuario}">
                <br>
                <br>
                <div id="func" style="display: none"> 
                    <input type="hidden" id="valorDisplay" value="${valorDisplay}">
                    Funcionario:
                    <select type="select" name="idFuncionario" >
                        <option value="">Clique para selecionar</option>
                            <c:forEach var="item" items="${funcionarios}">
                                <option value="${item.idFuncionario}">
                                    ${item.nomeFuncionario}
                                </option>
                            </c:forEach>
                    </select>                                
                </div>
                <br>
                <br>
                <button type="submit">Confirmar</button>                    
        </form>
        <br>
        <form method="POST" action="trocarSenhaUsuario"> 
            <button type="submit">Alterar Senha</button>                    
        </form>
        <br>
        <form method="GET" action="inativarUsuario"> 
            <button type="submit">Excluir</button>                    
        </form>        

        <h3>${msg}</h3>
    </body>
</html>
