<%-- 
    Document   : funcionarioEditar
    Created on : 15/02/2020, 10:33:30
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros - Funcionário</title>
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
        <h3>tela editar funcionario</h3>
        
        <!--form para edição de funcionario-->
        <div>
            <form method="GET" action="editarCadastroFuncionario2"> <%-- joga formulario para o controllerFuncionarioEditar --%>
                <input type="hidden" name="idFuncionario" value="${idFuncionario}">
                Nome do funcionário:
                <input type="text" name="nomeFuncionario" value="${nomeFuncionario}">
                <br>
                <br>
                Sexo:
                <select type="select" name="sexoFuncionario">
                    <option value="${sexo}">${sexo}</option>
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
                <button type="submit" value="SalvarEdicoes"/>Salvar</button>
            </form>    
            <br>
            <!-- botão que abre o modal de confirmação de exclusão -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#confirmaçãoExclusao">
              Excluir
            </button>

            <!-- Modal -->
            <div class="modal fade" id="confirmaçãoExclusao" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Excluir funcionário</h5>
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
                    <form method="GET" action="inativarFuncionario"> <%-- joga formulario para o controllerInativarFcunionario --%>
                        <input type="hidden" name="idFuncionario" value="${idFuncionario}">
                        <button type="submit" class="btn btn-primary" value="Confirmar">Confirmar</button>
                    </form> 
                  </div>
                </div>
              </div>
            </div> 
            <!-- fim Modal -->
        </div>
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
                        <form method="GET" action="adicionarNovoTelefoneFunc"> <%-- joga formulario para o controllerTelefoneNovo --%>
                            <input type="hidden" name="idFuncionario" value="${idFuncionario}">
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
            
            <!-- div de listagem listagem telefone funcionario-->          
            <div>
                <table id="tabela" class="table table-secondary">
                    <thead> 
                        <tr>    
                            <th scope="col">Número</th>
                            <th scope="col">Tipo</th>
                        </tr>
                    </thead> 
                    <tbody>
                        <c:forEach items="${listaTelefoneFuncionario}" var="item"> 
                            <tr>
                                <td>${item.numero}</td>
                                <td>${item.tipoTelefone}</td>
                                <td>
                                    <!-- form para excluir contato --> 
                                    <form method="GET" action="excluirTelefoneFunc">
                                        <input type="hidden" name="idFuncionarioTelefone" value="${idFuncionario}">
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
            <!-- fim  div de listagem telefone funcionario-->   
        </div>
         
        <!--form para edição de funcionario-->
        <h3>${msg}</h3>
        <br>
        <!--botão de voltar página-->
        <div>
            <!-- form para listar os funcionarios cadastrados -->
            <form method="POST" action="listaFuncionarios"> <%-- joga formulario para o controllerFuncionarioListar --%>
                <button type="submit" value="ListarFuncionarios"/>Voltar</button>
            </form>                        
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>    
</html>
