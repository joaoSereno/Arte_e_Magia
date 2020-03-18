<%--
    Document   : cadastros
    Created on : 08/02/2020, 19:30:44
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
        <link rel="stylesheet" href="../custom/css/paginaDeCadastros/paginaDeCadastros.css">
        <link rel="stylesheet" href="../custom/css/navBarOnly/navBarCss.css">
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../custom/img/logoArte_E_Magia.png" id="logo-navbar">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto mb-0">
                    <!-- Botão página inicial -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp">Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="cadastros.jsp">Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../configAniversariante/relatorios.jsp">Config. Aniversáriante</a>
                    </li>
                    <!-- Botão relatorios -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../paginasDeRelatorios/relatorios.jsp">Relatórios</a>
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
        <!-- Cards Dos Botões -->
        <div id="card-deck">
            <!-- CardCliente -->
            <div class="card" id="cards" style="width: 14rem;">
                <img src="../custom/img/avatares-cards/cadastrar-cliente.jpg" class="card-img-top" alt="Cadastros" id="imagens-cards">
                <div class="card-body">
                    <a href="cadastroDeClientes/clienteCadastrar.jsp" class="btn btn-primary" id="botoes-card">Cliente</a>
                </div>
            </div>
            <!-- CardFuncionários -->
            <div class="card" id="cards" style="width: 14rem;">
                <img src="../custom/img/avatares-cards/cadastrar-cliente.jpg" class="card-img-top" alt="Funcionários" id="imagens-cards">
                <div class="card-body">
                    <a href="cadastroDeFuncionario/funcionarioCadastrar.jsp" class="btn btn-primary" id="botoes-card">Funcionário</a>
                </div>
            </div>
            <!-- CardFestas -->
            <div class="card" id="cards" style="width: 14rem;">
                <img src="../custom/img/avatares-cards/cadastrar-cliente.jpg" class="car-img-top" alt="Funcionarios" id="imagens-cards">
                <div class="card-body">
                    <a href="cadastroDeFesta/clientePrincipal.jsp" type="button" class="btn btn-primary" id="botoes-card">Festa</a>
                </div>
            </div>
            <!-- Card FormaPgto -->
            <div class="card" id="cards" style="width: 14rem;">
                <img src="../custom/img/avatares-cards/cadastrar-cliente.jpg" class="car-img-top" alt="Funcionarios" id="imagens-cards">
                <div class="card-body">
                    <a href="cadastroTipoPagamento/tipoPagamentoPrincipal.jsp" class="btn btn-primary" id="botoes-card">Forma de pagamento</a>
                </div>
            </div>
            <!-- CardTipoDespesa -->
            <div class="card" id="cards" style="width: 14rem;">
                <img src="../custom/img/avatares-cards/cadastrar-cliente.jpg" class="car-img-top" alt="Tipo-Despesas" id="imagens-cards">
                <div class="card-body">
                    <a href="cadastroTipoDespesa/tipoDespesaPrincipal.jsp" type="button" class="btn btn-primary" id="botoes-card">Tipo de despesa</a>
                </div>
            </div>
        </div>
        <div id="card-deck">
            <!--CardDespesas -->
            <div class="card" id="cards" style="width: 14rem;">
                <img src="../custom/img/avatares-cards/cadastrar-cliente.jpg" class="car-img-top" alt="Despesas" id="imagens-cards">
                <div class="card-body">
                    <a href="cadastroDeDespesa/despesaCadastrar.jsp" type="button "class="btn btn-primary" id="botoes-card">Despesa</a>
                </div>
            </div>
            <!-- CardPacotes -->
            <div class="card" id="cards" style="width: 14rem;">
                <img src="../custom/img/avatares-cards/cadastrar-cliente.jpg" class="car-img-top" alt="Pacotes" id="imagens-cards">
                <div class="card-body">
                    <a href="cadastroDePacote/pacotePrincipal.jsp" type="button" class="btn btn-primary" id="botoes-card">Pacote</a>
                </div>
            </div>
            <!-- CardContaAcesso -->
            <div class="card" id="cards" style="width: 14rem;">
                <img src="../custom/img/avatares-cards/cadastrar-cliente.jpg" class="car-img-top" alt="ContaAcesso" id="imagens-cards">
                <div class="card-body">
                    <a href="cadastroDeUsuario/usuarioCadastrar.jsp" type="button "class="btn btn-primary" id="botoes-card">Conta de acesso</a>
                </div>
            </div>
            <!-- Div Botão Modal Aniversariante -->
            <div class="card" id="cards" style="width: 14rem;">
                <img src="../custom/img/avatares-cards/cadastrar-cliente.jpg" class="car-img-top" alt="Modal" id="imagens-cards">
                <div class="card-body">
                    <button type="button" class="btn btn-primary" id="botoes-card" data-toggle="modal" data-target="#novoTelefone">Config. Aniversariante</button>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="novoTelefone" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Notificação de aniversariante próximos =)</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <br>
                    <div>
                        <!-- form para config aniversario -->
                        <form method="GET" action="configAniversariante"> <%-- joga formulario para o controllerConfigAniversariante --%>
                            Quantidade de dias:
                            <input type="text" name="qtdDias">
                            <button type="submit" class="btn btn-default" value="Confirmar">Confirmar</button>
                        </form>
                        <!-- fim form para adicionar novo contato -->
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- fim Modal -->
    </div>
</body>
</html>
