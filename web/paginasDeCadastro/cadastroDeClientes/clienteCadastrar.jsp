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
        <title>Cadastros - Cliente</title>
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
    </body>
</html>
