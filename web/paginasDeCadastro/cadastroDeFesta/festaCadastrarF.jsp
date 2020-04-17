<%-- 
    Document   : paginaSelecionarCliente
    Created on : 02/04/2020, 17:25:22
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    int contadorCliente = 0;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros - Festa</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeFesta/paginaSelecionarCliente.css">
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
        <div>
            <h3 id="tituloDaEtapa">1º Etapa - Selecionar Cliente</h3>
        </div>
        <!-- div da confirmação do cliente ( 1 etapa ) -->
        <div id="confirmacaoCliente"  style="display: none">
            <h4 id="clienteSelecionado"></h4>
            <br>
            <button id="btn-trocarCliente"  class="btn btn-warning" onclick="trocarCliente()"> Trocar cliente </button>
            <button id="btn-2etapa"  class="btn btn-warning" onclick="etapa2()"> 2º Etapa </button>
        </div>
        <br>
        <!-- div de listagem cliente-->
        <div id="listagemDeCliente">
            <table  class="table table-secondary">
                <thead> 
                    <tr>    
                        <th scope="col">Nome</th>
                        <th scope="col">CPF/CNPJ</th>
                    </tr>
                </thead> 
                <tbody>
                    <c:forEach items="${listaClientes}" var="item">                
                        <tr>
                            <td>${item.nomeCliente}</td>
                            <td>${item.cpf}</td>
                            <!-- botão/form para editar registro cliente --> 
                            <td>
                                <input type="hidden" id="nomeCliente${item.idCliente}" value="${item.nomeCliente}">
                                <button id="btnSelecionarCliente" onclick="selecionarCliente(${item.idCliente})" class="btn btn-warning"> Selecionar </button>                                    
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- div de selecionar aniversariante ( 2 etapa )-->
        <div id="selecionarAniversariantes" style="display: none">
            <input type="hidden" id="totalCriancas" value="${totalCriancas}"> <!-- controlador para pegar o total de criancas -->
            <input type="hidden" id="listaConcatenadaCrianca" value="${listaConcatenadaCrianca}"> <!--  controlador lista de todas as crianças que será filtrada no js -->
            <h5 id="subTituloEtapa2">Caso alguma criança não faça parte do cadastro, clique em remover!</h5>
            <table id="tabelaAniversariante" class="table table-secondary" style="display: none">
                <thead> 
                    <tr>    
                        <th scope="col">Nome da criança</th>
                        <th></th>
                    </tr>
                </thead> 
                <tbody id="tbodyAniversariantes">
                </tbody>
            </table>            
            <button class="btn btn-warning" onclick="voltarEtapa1()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa3()"> 3º Etapa </button>            
        </div>
        <!-- div de selecionar funcionario ( 3 etapa )-->
        <div id="selecionarFuncionarios" style="display: none">
            <h5>Selecione o animador ou animadora e informe seu cache e forma de pagamento, após isso clique em "Adicionar"</h5>
            <form id="formFuncionario">
                Funcionario:
                <select type="select" name="jsFuncionarios">
                    <option value="">Clique para selecionar</option>
                        <c:forEach var="item" items="${listaFuncionario}">
                            <option value="${item.idFuncionario}+${item.nomeFuncionario}">
                                ${item.nomeFuncionario}
                            </option>
                        </c:forEach>
                </select>
                Cache: <input type="text" name="jsCache">
                Forma de Pagamento:
                <select type="select" name="jsFormaPagamentoFuncionario">
                    <option value="">Clique para selecionar</option>
                        <c:forEach var="item" items="${listaFormaPagamento}">
                            <option value="${item.idFormaPagamento}+${item.nomePagamento}">
                                ${item.nomePagamento}
                            </option>
                        </c:forEach>
                </select>                
                <button type="button" id="add-funcionario">Adicionar</button> 
            </form>         
            <br>
            <table id="tabelaFuncionario" class="table table-secondary" style="display: none">
                <thead> 
                    <tr>    
                        <th>Funcionario</th>
                        <th>Cache</th>
                        <th>Forma de Pagamento</th>
                        <th></th>
                    </tr>
                </thead> 
                <tbody id="tbodyFuncionario">
                </tbody>
            </table> 
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa2()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa4()"> 4º Etapa </button>            
        </div> 
        <div id="selecionarPacotes" style="display: none">
            <h5> Selecione o pacote do evento: </h5>
            Pacote:
            <select type="select" name="jsPacote">
                <option value="">Clique para selecionar</option>
                    <c:forEach var="item" items="${listaPacote}">
                        <option value="${item.idPacote}">
                            ${item.nomePacote}
                        </option>
                    </c:forEach>
            </select>
            <br>
            <br>
            Esse evento possui pacotes adicionais?
            <button onclick="habilitaPacoteAdicional()">Sim</button>
            <button onclick="desabilitaPacoteAdicional()">Não</button>
            <br>
            <br>
            <div id="divPacoteAdicional" style="display: none">
                <form id="formPacoteAdicional">
                    <select type="select" name="jsPacotesAdicionais">
                        <option value="">Selecionar Pacote Adicional</option>
                            <c:forEach var="item" items="${listaTipoPacoteAdicional}">
                                <option value="${item.idTipoPacoteAdicional}+${item.descricaoPacoteAdd}">
                                    ${item.descricaoPacoteAdd}
                                </option>
                            </c:forEach>
                    </select>
                    Valor:
                    <input type="text" name="jsValorPacoteAdicional" value="">
                    <button type="button" id="add-pacoteAdicional">+</button> 
                </form>
                <br>
                <table id="tabelaPacoteAdicional" class="table table-secondary" style="display: none">
                    <thead> 
                        <tr>    
                            <th>Pacote Adicional</th>
                            <th>Valor</th>
                            <th></th>
                        </tr>
                    </thead> 
                    <tbody id="tbodyPacoteAdicional">
                    </tbody>
                </table>                  
            </div>      
            <br>
            <button class="btn btn-warning" onclick="voltarEtapa3()"> Voltar </button>
            <button class="btn btn-warning" onclick="etapa5()"> 5º Etapa </button>            
        </div>
        <br>
        <a href="festaPrincipal.jsp" type="button" class="btn btn-primary">Voltar</a>
    </body>
    <script src="../../javascripts/cadastroDeFesta/festaCadastrarF.js"></script>
    <script src="../../javascripts/cadastroDeFesta/festaCadastrarF2.js"></script>
</html>
