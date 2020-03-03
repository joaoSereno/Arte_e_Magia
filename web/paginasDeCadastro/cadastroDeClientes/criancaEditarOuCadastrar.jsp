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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>

    <body>
        <!--        navbar da página-->
        <nav class="navbar navbar-light navbar-expand-lg" style="background-color: #ef1b3436;">
            <!-- logo do navbar -->
            <div>
                <a class="navbar-brand">
                    <img src="../../custom/img/logoArte_E_Magia.png" width="130" height="60"
                        class="d-inline-block align-top" alt="Logo Arte & Magia">
                </a>
            </div>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <!-- botão sair -->
                    <li class="nav-item">
                        <a href="/Arte-E-Magia_tst/paginaInicial.jsp" class="btn btn-outline-light"
                            style="background-color: #ec1b1b00;">Página Inicial</a>
                    </li>
                    <!-- botão cadastros -->
                    <li class="nav-item">
                        <a href="../cadastros.jsp" class="btn btn-outline-light"
                            style="background-color: #ec1b1b00;">Cadastros</a>
                    </li>
                    <!-- botão relatorios -->
                    <li class="nav-item">
                        <a href="../../paginasDeRelatorios/relatorios.jsp" class="btn btn-outline-light"
                            style="background-color: #ec1b1b00;">Relatórios</a>
                    </li>
                    <!-- botão sair que redireciona para a página deslogar.jsp -->
                    <li class="nav-item">
                        <a href="/Arte-E-Magia_tst/deslogar.jsp" class="btn btn-outline-light"
                            style="background-color: #ec1b1b00;">Sair</a>
                    </li>
                </ul>
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
                        <option value="${sexoE}">${sexoE}</option>
                        <%  
                            String sexo = request.getParameter("sexo");
                            if(sexo != null){
                                if(sexo.equals("M")){
                                    %>
                                    <option value="F">F</option>
                                    <%                            
                                }else{
                                    %>
                                    <option value="M">M</option>
                                    <%   
                                }
                            }        
                        %>
                    </select> 
                    <br>
                    <br>
                    <button class="btn btn-warning"> Confirmar </button>
            </form>             
        </div>
        <h3>${msg}</h3>
    </body>
</html>
