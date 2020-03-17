<%-- 
    Document   : adicionarCliente
    Created on : 08/02/2020, 20:45:32
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros</title>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand h1 mb-0" href="/Arte-E-Magia_tst/paginaInicial.jsp">Arte e Magia</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav mr-auto mb-0">
                    <!-- Botão página inicial -->
                    <li class="nav-item h6 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp">Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h6 mb-0">
                        <a class="nav-link" href="../cadastros.jsp">Cadastros</a>
                    </li>
                    <!-- Botão relatorios -->
                    <li class="nav-item h6 mb-0">
                        <a class="nav-link" href="../../paginasDeRelatorios/relatorios.jsp">Relatórios</a>
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
        <h3>Tela cadastrar cliente</h3>
        <br>
        <br>
        <!-- form para cadastrar cliente-->
        <div>
            <form method="GET" action="cadastrarCliente"> <%-- joga formulario para o controllerClienteCadastrar --%>
                Nome do cliente:
                <input type="text" name="nomeCliente">
                <br>
                <br>
                CPF:
                <input type="text" name="cpf">
                <br>
                <br>
                Tipo de Festa:
                <input type="text" name="tipoFesta">
                <br>
                <br>
                Contato:
                <input type="text" name="contato">
                <select type="select" name="tipoTelefone">
                    <option value="Celular">Celular</option>
                    <option value="Fixo">Fixo</option>
                </select> 
                <br>
                <br>
                <h6>Endereço:</h6>
                CEP:
                <input type="text" name="cep">
                CIDADE:
                <input type="text" name="cidade">
                BAIRRO:
                <input type="text" name="bairro">
                RUA:
                <input type="text" name="rua">
                NUMERO:
                <input type="text" name="numero">
                COMPLEMENTO:
                <input type="text" name="complemento">
                <br>
                <br>
                <button type="submit" value="Cadastrar"/>Cadastrar</button>
            </form>
            <!-- fim do form para cadastrar cliente-->    
        <div>
        <h3>${msg}</h3>
        <br>
        <br>
        <div>
            <!-- form para listar os clientes cadastrados -->
            <form method="GET" action="listaCliente"> <%-- joga formulario para o controllerClienteListar --%>
                <button type="submit" value="ListarFuncionarios"/>Listar Clientes</button>
            </form>                        
        </div>   
        <br>
        <br>
        <a href="../cadastros.jsp" class="btn btn-primary" >Voltar</a>
    </body>
</html>
