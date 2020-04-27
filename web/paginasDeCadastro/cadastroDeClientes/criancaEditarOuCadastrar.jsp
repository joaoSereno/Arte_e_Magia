<%-- 
    Document   : criancaEditarOuCadastrar
    Created on : 29/02/2020, 12:59:21
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros - Criança</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT" crossorigin="anonymous"></script>        
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customização -->       
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeClientes/criancaEditarOuCadastrar.css">
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
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp"><i class="fas fa-home"></i>&nbsp;Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../cadastros.jsp"><i class="far fa-address-book"></i>&nbsp;Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../../paginasDeRelatorios/relatorios.jsp"><i class="far fa-clipboard"></i>&nbsp;Relatórios</a>
                    </li>                    
                    <!-- Botão relatorios -->
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="../configAniversariante/telaConfigAniversariante.jsp"><i class="fas fa-cog"></i>&nbsp;Configuração</a>                        
                    </li>
                </ul>
                <!-- Botão Sair -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item h5 mb-0">
                        <a class="nav-link" href="/Arte-E-Magia_tst/deslogar.jsp"><i class="fas fa-sign-out-alt"></i>&nbsp;Sair</a>
                    </li>
                </ul>
                <!-- Fim navbar da página-->
            </div>
        </nav>
        <h3>Tela Criança</h3>
        <br>
        <div>
            <!-- form para cadastrar ou editar criança-->
            <form method="GET" action="editarORcadastrarCrianca2">
                    <input type="hidden" name="idCliente" value="${idClienteE}">
                    <input type="hidden" name="idCrianca" value="${idCriancaE}">
                    Nome da criança:
                    <input type="text" name="nomeCrianca" value="${nomeCriancaE}">
                    <br>
                    <br>
                    Data de Nascimento:
                    <input type="text" name="dataNascimento" value="${dataNascimentoE}">
                    <br>
                    <br>
                    Sexo:
                    <select type="select" name="sexoCrianca">
<%  
                        String sexo = request.getParameter("sexo"); //se for editar
                        if(sexo != null){
%>
                        <option value="${sexoE}">${sexoE}</option>
<%
                                if(sexo.equals("M")){
%>
                                <option value="F">F</option>
<%                            
                                }else{
%>
                                <option value="M">M</option>
<%   
                                }
                        }else{ //se for cadastrar
%>
                                <option value="M">M</option>
                                <option value="F">F</option>
<% 
                        }        
%>
                    </select> 
                    <br>
                    <br>
                    <button class="btn btn-warning"> Confirmar </button>
            </form>
            <!-- botão que abre o modal de confirmação de exclusão -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#confirmaçãoExclusao">
                Excluir
            </button>

            <!-- Modal -->
            <div class="modal fade" id="confirmaçãoExclusao" tabindex="-1" role="dialog"
                aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Excluir criança</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Tem certeza que deseja realizar a exclusão do cadastro?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <!-- form realizar a exclusão da crianca -->
                            <form method="GET" action="inativarCrianca">
                                <%-- joga formulario para o controllerInativarCrianca --%>
                                <input type="hidden" name="idCrianca" value="${idCriancaE}">
                                <input type="hidden" name="idCliente" value="${idClienteE}">
                                <button type="submit" class="btn btn-primary" value="Confirmar">Confirmar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
                                
        </div>
        <!-- fim Modal -->
        </div>
        <h3>${msg}</h3>
        <br>
        <br>
        <!--botão de voltar página-->
        <div>
            <!-- form voltar para a página de funcionario -->
            <form method="GET" action="editarCadastroCliente">
                <input type="hidden" name="idCliente" value="${idClienteE}">
                <button class="btn btn-warning"> Voltar </button>
            </form>                      
        </div>      
    </body>
</html>
