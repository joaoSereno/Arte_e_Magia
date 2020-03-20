<%-- 
    Document   : editarCliente
    Created on : 08/02/2020, 20:45:32
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros - Cliente</title>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
        <h3>Tela editar cliente</h3>
        <br>
        <br>
        <!-- form para editar cliente-->
        <div>
            <form method="GET" action="editarCliente2"> <%-- joga formulario para o controllerClienteEditar2 --%>
                <input type="hidden" name="idCliente" value="${cliente.idCliente}">
                Nome do cliente:
                <input type="text" name="nomeCliente" value="${cliente.nomeCliente}">
                <br>
                <br>
                CPF:
                <input type="text" name="cpf" value="${cliente.cpf}">
                <br>
                <br>
                Tipo de Festa:
                <input type="text" name="tipoFesta" value="${cliente.tipoFesta}">
                <br>
                <br>
                <h6>Endereço:</h6>
                <input type="hidden" name="idEnderecos" value="${endereco.idEnderecos}">
                CEP:
                <input type="text" name="cep" value="${endereco.cep}">
                CIDADE:
                <input type="text" name="cidade" value="${endereco.cidade}">
                BAIRRO:
                <input type="text" name="bairro" value="${endereco.bairro}">
                RUA:
                <input type="text" name="rua" value="${endereco.rua}">
                NUMERO:
                <input type="text" name="numero" value="${endereco.numero}">
                COMPLEMENTO:
                <input type="text" name="complemento" value="${endereco.complemento}">
                <br>
                <br>
                <button type="submit" value="Cadastrar" />Salvar</button>
            </form>
        <!-- fim do form para editar cliente-->
        </div>
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
                        <h5 class="modal-title" id="exampleModalLabel">Excluir cliente</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Tem certeza que deseja realizar a exclusão do cadastro?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <!-- form realizar a exclusão do funcionario -->
                        <form method="GET" action="inativarCliente2">
                            <%-- joga formulario para o controllerInativarCliente --%>
                            <input type="hidden" name="idCliente" value="${cliente.idCliente}">
                            <button type="submit" class="btn btn-primary" value="Confirmar">Confirmar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- fim Modal -->
        <br>
        <h3>${msg}</h3>
        <br>
        <div>
            <div>
                <h3>Telefone/s:</h3>                
            </div>
            <br>
            <!-- div de modal para o  novo telefone-->
            <div>
                <!-- botão que abre o modal de novo  -->
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#novoTelefone">
                  Novo telefone
                </button>

                <!-- Modal -->
                <div class="modal fade" id="novoTelefone" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Novo telefone =)</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <br> 
                      <div>
                        <!-- form para adicionar novo contato --> 
                        <form method="GET" action="adicionarNovoTelefoneCliente"> <%-- joga formulario para o controllerTelefoneNovo --%>
                            <input type="hidden" name="idCliente" value="${cliente.idCliente}">
                            Número:
                            <input type="text" name="contato">
                            Tipo:
                            <select type="select" name="tipoTelefone">
                                <option value="Celular">Celular</option>
                                <option value="Fixo">Fixo</option>
                            </select>
                            <br>
                            Telefone Principal? 
                            <input type="radio" value="sim" name="telefonePrincipal"> Sim                        
                            <input type="radio" value="nao" name="telefonePrincipal"> Não                        
                            <br>
                            <button type="submit" class="btn btn-primary" value="Confirmar">Adicionar</button>
                        </form> 
                        <!-- fim form para adicionar novo contato --> 
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                      </div>
                    </div>
                  </div>
                </div> 
                 <!-- fim Modal -->                          
            </div>
            <!-- fim da div de modal para o  novo telefone-->
            
            <!-- div de listagem listagem telefone cliente-->          
            <div>
                <table id="tabela" class="table table-secondary">
                    <thead> 
                        <tr>    
                            <th scope="col">Número</th>
                            <th scope="col">Tipo</th>
                        </tr>
                    </thead> 
                    <tbody>
                        <c:forEach items="${listaTelefoneCliente}" var="item"> 
                            <tr>
                                <td>${item.numero}</td>
                                <td>${item.tipoTelefone}</td>
                                <td>
                                    <!-- form para excluir contato --> 
                                    <form method="GET" action="excluirTelefoneCliente">
                                        <input type="hidden" name="idClienteTelefone" value="${cliente.idCliente}">
                                        <input type="hidden" name="isPrincipal" value="${item.isPrincipal}">
                                        <input type="hidden" name="idTelefone" value="${item.idTelefone}">
                                        <button class="btn btn-warning"> Excluir </button>
                                    </form> 
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
            <!-- fim  div de listagem telefone cliente-->   
        </div>
       <br>
        <div>
            <h3>Crianças:</h3>
            <div>
                <!-- form cadastrar criança -->
                <form method="GET" action="editarORcadastrarCrianca">
                    <input type="hidden" name="idClienteCrianca" value="${cliente.idCliente}">
                    <button type="submit">Nova Criança</button>
                </form>                        
            </div>        
            <!-- div de listagem crianca do cliente-->          
            <div>
                <table id="tabela" class="table table-secondary">
                    <thead> 
                        <tr>    
                            <th scope="col">Nome</th>
                            <th scope="col">sexo</th>
                            <th scope="col">Data de Nascimento</th>
                        </tr>
                    </thead> 
                    <tbody>
                        <c:forEach items="${listaCriancaCliente}" var="item"> 
                            <tr>
                                <td>${item.nomeCrianca}</td>
                                <td>${item.sexo}</td>
                                <td>${item.dataNascimento}</td>
                                <td>
                                    <!-- form para editar contato --> 
                                    <form method="GET" action="editarORcadastrarCrianca">
                                        <input type="hidden" name="idClienteCrianca" value="${item.idCliente}">
                                        <input type="hidden" name="idCrianca" value="${item.idCrianca}">
                                        <input type="hidden" name="nomeCrianca" value="${item.nomeCrianca}">
                                        <input type="hidden" name="sexo" value="${item.sexo}">
                                        <input type="hidden" name="dataNascimento" value="${item.dataNascimento}">
                                        <button class="btn btn-warning"> + </button>
                                    </form> 
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
            <!-- fim  div de listagem crianca do cliente-->              
        </div>
       <br>
       <br>
        <!--botão de voltar página-->
        <div>
            <!-- form para listar os clientes cadastrados -->
            <form method="GET" action="listaCliente"> <%-- joga formulario para o controllerClienteListar --%>
                <button type="submit" value="ListarClientes"/>Voltar</button>
            </form>                        
        </div>                            
    </body>
</html>