<%-- 
    Document   : usuarioCadastrar
    Created on : 07/03/2020, 21:16:18
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <h1>Pagina cadastrar usuario</h1>
        <br>
        <!-- form para cadastrar funcionario-->
        <div>
            <button type="button" onclick="Adm('func','nomeUsuario')"/>ADM</button>
            <br>
            <br>
            <!--   form para listar os funcionarios no campo "funcionario" -->
            <form method="GET" action="usuarioFuncListar">
                <button type="submit" onclick="Func('func')"/>FUNC</button> 
            </form>           
            <br>
            <br>
            <form method="POST" action="cadastrarUsuario"> <%-- joga formulario para o controllerUsuarioCadastrar --%>
                Login:
                <input type="text" name="login" value="${login}">
                <br>
                <br>
                Senha:
                <input type="password" name="senha">
                <br>
                <br>
                Confirmação de senha:
                <input type="password" name="confirmacaoSenha">
                <br>
                <br>
                <div id="nomeUsuario">
                    Nome do usuário:
                    <input type="text" name="nomeUsuario">
                </div>
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
                <button type="submit" value="Cadastrar"/>Cadastrar</button>                    
            </form>
        <div>
        <h3>${msg}</h3>
        <br>
        <br>
        <div>
            <!-- form para listar os usuarios cadastrados -->
            <form method="GET" action="listaUsuarios"> <%-- joga formulario para o controllerUsuarioListar --%>
                <button type="submit" value="ListaUsuarios">Listar funcionários</button>
            </form>                        
        </div>
        <br>
        <br>
        <a href="../cadastros.jsp" class="btn btn-primary" >Voltar</a>
        
            
        <script>            
            //sempre que carregar a página vai verificar se o valorDisplay é == 1 
            var valorDisplay = document.getElementById('valorDisplay').value;
            if(valorDisplay == 1){
                document.getElementById('func').style.display = 'block';  //habilita a div com id "func"              
                document.getElementById('nomeUsuario').style.display = 'none'; //desabilita a div com id "nomeUsuario"       
            }           
            //se clicar no botão ADM vai ocultar a div com id "func" e desocultar a div com id "nomeUsuario"
            function Adm() {
                document.getElementById('func').style.display = 'none';               
                document.getElementById('nomeUsuario').style.display = 'block';                  
            }; 
            
        </script>
    </body>
</html>

