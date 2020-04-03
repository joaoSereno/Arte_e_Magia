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
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeFuncionario/funcionarioEditar.css">
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
        <h3>tela editar funcionario</h3>
        
        <!--form para edição de funcionario-->
        <div>
            <form method="GET" action="editarCadastroFuncionario2"> <%-- joga formulario para o controllerFuncionarioEditar --%>              
                <input type="hidden" name="listaTelefoneFuncionario" value="${listaTelefoneFuncionario}">
                <input type="hidden" name="idFuncionario" value="${idFuncionario}">
                <input type="hidden" id="sexo2" name="sexo2" value="${sexo}">
                Nome do funcionário:
                <input type="text" name="nomeFuncionario" value="${nomeFuncionario}">
                Sexo:
                <select type="select" name="sexo">  <!--select controlado por js no final da pagina -->
                    <option value="${sexo}">${sexo}</option>
                    <option id="sexo3" value="">F/M</option>
                </select> 
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
                <table  class="table table-secondary">
                    <thead> 
                        <tr>    
                            <th scope="col">Número</th>
                            <th scope="col">Tipo</th>
                        </tr>
                    </thead> 
                    <tbody>
                        <c:forEach items="${listaTelefoneFuncionario}" var="item"> 
                            <tr id="tabelaTelefone">
                                <td name="numero">${item.numero}</td>
                                <td name="telefone">${item.tipoTelefone}</td>
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
        <script>
                        
            var sexo = document.getElementById('sexo2').value; //pega o valor do select dos sexos
            if(sexo == ""){   //se estiver vazio, deixa o outro vazio também
                  document.getElementById("sexo3").value = "";
                  document.getElementById("sexo3").innerHTML = "";                
            }else{ //se não tiver
                if(sexo == "M"){//se o sexo for M , na outro campo vai mostra F
                  document.getElementById("sexo3").value = "F";
                  document.getElementById("sexo3").innerHTML = "F";
                }else{ // se não vai mostra M
                  document.getElementById("sexo3").value = "M";
                  document.getElementById("sexo3").innerHTML = "M";
                }  
            }
            
        </script>
    </body>
    <script src="../../javascripts/telefones/destacarTelefone.js"></script>  
</html>
