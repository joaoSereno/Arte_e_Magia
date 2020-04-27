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
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <title>Cadastros - Usuário</title>
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
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeUsuario/usuarioCadastrar.css">
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../../custom/img/logoFundoLogin.png" id="logo-navbar">
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon navbar-light"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto mb-0">
                    <!-- Botão página inicial -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp"><i class="fas fa-home"></i>Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../cadastros.jsp"><i class="far fa-address-book"></i>Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../../paginasDeRelatorios/relatorios.jsp"><i class="far fa-clipboard"></i>Relatórios</a>
                    </li>                    
                    <!-- Botão relatorios -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../configAniversariante/telaConfigAniversariante.jsp"><i class="fas fa-cog"></i>Configuração</a>                        
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
                <button type="submit" value="ListaUsuarios">Listar usuário</button>
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

