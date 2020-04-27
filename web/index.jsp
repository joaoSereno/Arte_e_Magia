<%--
    Document   : login
    Created on : 27/01/2020, 23:55:34
    Author     : João Pedro

    Página de login do sistema.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>Página de login</title>
        <link rel="shortcut icon" href="custom/img/favicon.jpg">
        
        <!-- CSS -->
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customização -->
        <link rel="stylesheet" type="text/css" href="custom/css/paginaDeLogin/paginaDeLogin.css" />
        
    </head>
    <body>
        <div class="container">
            <div class="row">
                <form class="form" method="POST" action="logarSistema.jsp">
                    <div class="form-group">
                        <div class="text-center row">
                             <img src="custom/img/paginaDeLogin/logoFundoLogin.jpg" class="img-fluid" alt="Logo" title="Arte e Mágia">
                            <!--h1>Login</h1-->
                        </div>
                        <!--div class="text-center row">
                            <p>Gerencie seu negócio</p>
                        </div-->                
                        <div class="form-group row">
                            <label for="usr">Usuário:</label>
                            <input type="text" name="usuario" placeholder="Digite seu usuário" class="form-control" id="usr">
                        </div>
                        <div class="form-group row">
                            <label for="pwd">Senha:</label>
                            <input type="password" name="senha" placeholder="Digite sua senha" class="form-control" id="pwd">
                        </div>
                        <div class="form-group row">
                            <div class="custom-control custom-switch">
                                <input type="checkbox" name="lembrar" class="custom-control-input" id="switch1">
                                <label class="custom-control-label" for="switch1">Lembrar-me</label>
                            </div>
                        </div>
                        <div class="form-group row">
                            <button type="submit" class="btn btn-primary btn-lg btn-block">Acessar</button>
                        </div>
                        <div class="login-msg">
                        <%
                            String usarioInvalido = request.getParameter("usarioInvalido"); //se caiu no else do logarSistema.jsp recebe esse parametro
                            if (usarioInvalido != null) {
                                if (usarioInvalido.equals("USUARIO_NAO_EXISTE")) {//exibe mensagem de usuario invalido
                        %>
                        Usuário ou senha inválido!
                        <%
                                }
                            }
                        %>
                        </div>
                    </div>
                </form>
            </div>        
        </div>        
        <br>
        <form method="GET" action="conexao">
            <input type="hidden" class="btn btn-info"  value="Testar Conexão"/>
        </form>
        <br>
        <h3>${msg}</h3>
    </body>
</html>
