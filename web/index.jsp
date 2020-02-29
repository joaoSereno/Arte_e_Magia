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
        <title>Página de login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="custom/css/paginaLogin.css" />
    </head>
    <body>
        <div>
            <div>
                <form method="POST" action="logarSistema.jsp"> <%--chama a página que valida o usuário --%>
                    Login:
                    <input type="text" name="usuario">
                    <br>
                    <br>
                    Senha:
                    <input type="password" name="senha">
                    <br>
                    <br>
                    <button style="background-color: #ef1b3436;" type="submit" value="Confirmar"/>Confirmar</button>
                </form>
            </div>
            <%
                String usarioInvalido = request.getParameter("usarioInvalido"); //se caiu no else do logarSistema.jsp recebe esse parametro
                if(usarioInvalido != null){
                    if (usarioInvalido.equals("USUARIO_NAO_EXISTE")) {//exibe mensagem de usuario invalido
                    %>    
                    Usuário ou senha inválido!!
                    <%
                    }
                }
            %>
        </div>
        <br>
        <br>
        <form method="GET" action="conexao">
            <input class="btn btn-info" type="submit" value="Testar Conexão"/>
        </form>
        <br>
        <h3>${msg}</h3>
    </body>
</html>
