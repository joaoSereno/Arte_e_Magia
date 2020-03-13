<%-- 
    Document   : pacotePrincipal
    Created on : 22/02/2020, 15:07:11
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros - Pacotes</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
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
        <h3>Tela pacote</h3>
        <br>
        <div>
            <!--form para adicionar/editar um pacote-->
            <form method="GET" action="editarORcadastrarPacote"> 
                <input type="hidden" name="idPacote" value="${idPacoteE}">
                Nome Pacote:
                <input type="text" name="nomePacote" value="${nomePacoteE}">
                Valor Pacote:
                <input type="text" name="valorPacoteVenda" value="${valorPacoteVendaE}">
                <button class="btn btn-warning"> Confirmar </button>
            </form> 

            <!-- botão que abre o modal de confirmação de exclusão -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#confirmaçãoExclusao">
                Excluir
            </button>

            <!-- Modal -->
            <div class="modal fade" id="confirmaçãoExclusao" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Excluir pacote?</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Tem certeza que deseja realizar a exclusão do cadastro?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <!--form inativar pacote-->
                            <form method="GET" action="inativarPacote">
                                <input type="hidden" name="idPacoteE" value="${idPacoteE}">
                                <button class="btn btn-warning"> Excluir </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- fim Modal -->
        </div>
        <br>
        <h3>${msg}</h3>
        <br><br>
        <!-- botão/form de listar os pacotes-->  
        <form method="GET" action="pacoteListar"> 
            <button type="submit" class="btn btn-primary">Listar Pacotes</button>
        </form>
        <br>
        <!-- div de listagem de pacote -->          
        <div>
            <table id="tabela" class="table table-secondary">
                <thead> 
                    <tr>    
                        <th scope="col">Pacote</th>
                        <th scope="col">Valor do Pacote</th>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${listaPacotes}" var="item"> 
                        <tr>
                            <td>${item.nomePacote}</td>
                            <td>R$ ${item.valorPacoteVenda}</td>
                            <!-- botão/form para editar registro de pacote , envia para o  --> 
                            <td>
                                <form method="GET" action="pacoteEditar"> 
                                    <input type="hidden" name="idPacote" value="${item.idPacote}">
                                    <input type="hidden" name="nomePacote" value="${item.nomePacote}">
                                    <input type="hidden" name="valorPacoteVenda" value="${item.valorPacoteVenda}">
                                    <button class="btn btn-warning"> Editar </button>
                                </form> 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> 
        <!-- fim  div de listagem listagem de pacote-->   
        <br>
        <br>
        <a href="../cadastros.jsp" class="btn btn-primary" >Voltar</a>
        
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>        

</html>
