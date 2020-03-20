<%-- 
    Document   : usuarioEditar
    Created on : 11/03/2020, 22:56:53
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
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
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
        <br>
        <h3>Edição de usuário</h3>
        <br>
        <form method="GET" action="usuarioEditar2"> 
                <input type="hidden" name="idusuario" value="${usuario.idusuario}">           
                Login:
                <input type="hidden" name="loginAtual" value="${usuario.usuario}">
                <input type="text" name="login" value="${usuario.usuario}">
                <br>
                <br>
                <div id="nomeUsuario">
                    Nome do usuário:
                    <input type="text" name="nomeUsuario" value="${usuario.nomeUsuario}">
                </div>
                <br>
                <br>
                <div id="func" style="display: none"> 
                    <input type="hidden" name="valorDisplay" id="valorDisplay" value="${valorDisplay}">
                    Funcionario:
                    <select type="select" name="idFuncionario" >
                        <option value="${funcionarioDoUsuario.idFuncionario}">${funcionarioDoUsuario.nomeFuncionario}</option>
                            <c:forEach var="item" items="${listaFuncionario}">
                                <option value="${item.idFuncionario}">${item.nomeFuncionario}</option>
                            </c:forEach>
                    </select>                                
                </div>
                <br>
                <br>
                <button type="submit">Confirmar</button>                    
        </form>
        <br>
        <form method="GET" action="trocarSenhaUsuario">
            <input type="hidden" name="idUsuario" value="${usuario.idusuario}"> 
            <input type="hidden" name="valorDisplay" id="valorDisplay" value="${valorDisplay}">
            <button type="submit">Alterar Senha</button>                    
        </form>
        <br>
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
                        <h5 class="modal-title" id="exampleModalLabel">Excluir usuário</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Tem certeza que deseja realizar a exclusão do cadastro?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <!-- form realizar a exclusão do usuario -->
                        <form method="POST" action="inativarUsuario">
                            <input type="hidden" name="valorDisplay" id="valorDisplay" value="${valorDisplay}">
                            <input type="hidden" name="idUsuario" value="${usuario.idusuario}"> 
                            <button type="submit">Excluir</button>                    
                        </form>     
                    </div>
                </div>
            </div>
        </div>
        <!-- fim Modal de exclusão-->      
        <br>
        <h3>${msg}</h3>
        <br>
        <div>
            <!-- form para voltar a pagina e listar os usuarios cadastrados -->
            <form method="GET" action="listaUsuarios"> <%-- joga formulario para o controllerUsuarioListar --%>
                <button type="submit" value="ListaUsuarios">Voltar</button>
            </form>                        
        </div> 
    <script>            
        //sempre que carregar a página vai verificar se o valorDisplay é == 1 
        var valorDisplay = document.getElementById('valorDisplay').value;
        if(valorDisplay == 1){
            document.getElementById('func').style.display = 'block';  //habilita a div com id "func"              
            document.getElementById('nomeUsuario').style.display = 'none'; //desabilita a div com id "nomeUsuario"       
        }           
    </script>
    </body>
</html>
