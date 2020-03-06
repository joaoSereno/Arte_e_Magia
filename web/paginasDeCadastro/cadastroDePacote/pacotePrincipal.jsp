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
        <!-- fim navbar da página-->
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
