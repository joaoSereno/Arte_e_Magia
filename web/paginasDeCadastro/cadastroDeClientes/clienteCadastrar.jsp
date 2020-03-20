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
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeClientes/clienteCadastrar.css">
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
        <!-- form para cadastrar cliente-->
        <hr/>
            <h4>Dados do Cliente</h4>
            <form class="form-group" id="formgroup" method="GET" action="cadastrarCliente"><%-- joga formulario para o controllerClienteCadastrar --%>
                <div class="row formularios">
                    <div class="col">
                        <label for="cadastrarCliente">Nome do Cliente</label>
                        <input type="text" class="form-control" name="nomeCliente" id="validationTooltip01" placeholder="Nome do Cliente" required>
                    </div>
                    <div class="col-md-3">
                        <label for="cpfCliente">CPF Cliente</label>
                        <input type="txt" class="form-control" name="cpf" id="cpfCliente" placeholder="CPF do Cliente">
                    </div>
                    <div class="col-md-3">
                        <label for="tipoFesta">Tipo de Festa</label>
                        <input type="txt" class="form-control" name="tipoFesta" id="tipoFesta" placeholder="Tipo Festa">
                    </div>
                </div>
                <div class="row formularios2">
                    <div class="col-md-2">
                        <label for="contatoCliente" id="lables">Contato</label>
                        <input type="txt" class="form-control" name="contato" id="contato" placeholder="Contato">
                        <select class='form-control'>
                            <option>Celular</option>
                            <option>Fixo</option>
                        </select>
                    </div>
                </div>
                <hr/>
                <h4>Dados Residenciais</h4>
                <div class="row formularios3">
                    <div class="col">
                        <label for="cep">Logradouro</label>
                        <input type="text" class="form-control" name="rua" id="logradouro" placeholder="Nome Logradouro">
                    </div>
                    <div class="col">
                        <label for="cidade">Cidade</label>
                        <input type="text" class="form-control" name="cidade" id="cidade" placeholder="Cidade">
                    </div>
                    <div class="col">
                        <label for="bairro">Bairro</label>
                        <input type="text" class="form-control" name="bairro" id="bairro" placeholder="Bairro">
                    </div>
                    <div class="row formularios4">    
                        <div class="col">
                            <label for="cep">CEP</label>
                            <input type="text" class="form-control" name="cep" id="cep" placeholder="CEP Logradouro">
                        </div>
                        <div class="col">
                            <label for="numero">Número</label>
                            <input type="text" class="form-control" name="numero" id="numero" placeholder="Número residência">
                        </div>
                        <div class="col">
                            <label for="complemento">Complemento</label>
                            <input type="text" class="form-control" name="complemento" id="complemento" placeholder="Complemento">
                        </div>
                    </div>
                </div>
                <hr/>
                <button class="btn btn-primary" type="submit" value="Finaliza Cadastro">Finalizar Cadastro</button>
            </form>  
            <!-- fim do form para cadastrar cliente-->    
            <h3>${msg}</h3>
            <!-- form para listar os clientes cadastrados -->
            <div class="row botoes-inf">
                <div class="col offset-md-4">
                    <form class="form-inline botoes-form" method="GET" action="listaCliente"> <%-- joga formulario para o controllerClienteListar --%>
                        <button class="btn btn-primary" type="submit" value="ListarFuncionarios"/>Listar Clientes</button>
                        <a href="../cadastros.jsp" class="btn btn-primary" >Voltar</a>
                    </form>
                </div>
            </div>
    </body>
</html>
