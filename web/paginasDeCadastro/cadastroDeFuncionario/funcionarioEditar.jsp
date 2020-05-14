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
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros - Colaborador</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customização -->   
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeFuncionario/funcionarioEditar.css">     
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
        
        <div class="jumbotron text-center">
            <h1>Editar Colaborador</h1>
        </div>
        
        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <form method="GET" action="editarCadastroFuncionario2">

                        <input type="hidden" name="listaTelefoneFuncionario" value="${listaTelefoneFuncionario}">
                        <input type="hidden" name="idFuncionario" value="${idFuncionario}">
                        <input type="hidden" id="sexo2" name="sexo2" value="${sexo}">                

                        <div class="form-row">

                            <div class="form-group col-lg-8">

                                <label for="nomeFuncionario">Nome do Colaborador *</label>
                                <input type="text" class="form-control" maxlength="45" name="nomeFuncionario" id="nomeFuncionario" value="${nomeFuncionario}" required>

                            </div>

                            <div class="form-group col-lg-4">

                                <label for="sexoFuncionario">Gênero *</label>
                                <select type="select" id="sexoFuncionario" class="form-control" name="sexo"> <!--select controlado por js -->
                                    <option value="${sexo}" selected>${sexo}</option>
                                    <option id="sexo3" value="" >F/M</option>
                                </select>

                            </div>
                                    
                            <div class="form-group col-lg-12 my-2">

                                <button type="submit" class="btn btn-info btn-lg btn-block" >Salvar</button>

                            </div>
                                    
                            <div class="form-group col-lg-12">

                                <!-- botão que abre o modal de confirmação de exclusão -->
                                <button type="button" class="btn btn-danger btn-lg btn-block" data-toggle="modal" data-target="#confirmaçãoExclusao">
                                    Excluir Cadastro
                                </button>

                            </div>
                                    
                        </div>        

                    </form>

                </div>            

            </div>

        </div> 
                                    
        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">      
                    
                    <div class="row">

                        <div class="col-lg-12 text-center my-2">

                            <h3>${msg}</h3>

                        </div>

                    </div>   
                            
                </div>
            
            </div>
        
        </div>    
                            
        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8 my-5">

                    <div class="row">
                        <div class="col-lg-7">

                            <h3><i class="fas fa-address-book"></i> Contatos do Colaborador :</h3>

                        </div>

                        <div class="col-lg-5">

                            <button type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#novoTelefone">
                                +Novo Contato
                            </button>                    

                        </div>                
                    </div>
                    
                    <div class="col-lg-13 my-1">
                        
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered">
                                <thead> 
                                    <tr class="bg-danger">    
                                        <th scope="col">Número</th>
                                        <th scope="col">Tipo</th>
                                        <th></th>
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
                                                    <button class="btn btn-info"> Excluir </button>
                                                </form> 
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div> 
                        
                    </div>
                         
                </div>    

            </div>

        </div>                            
                            
        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">                    
                    
                    <form method="POST" action="listaFuncionarios">
                        
                        <div class="form-row my-3">

                            <button type="submit" class="btn btn-secondary btn-lg btn-block" value="ListarFuncionarios"/>Voltar</button>
                            
                        </div>
                
                    </form>
                    
                </div>
                
            </div>
            
        </div>                               
        
        <!-- Modal de exclusão do cadastro-->
        <div>
            
            <div class="modal fade" id="confirmaçãoExclusao" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                
                <div class="modal-dialog" role="document">
                  
                    <div class="modal-content">

                        <div class="modal-header">

                            <h5 class="modal-title" id="exampleModalLabel">Excluir Colaborador</h5>
                            
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">&times;</span>
                            </button>
                            
                        </div>

                        <div class="modal-body">
                          Tem certeza que deseja realizar a exclusão do cadastro?
                        </div>

                        <div class="container">
                            
                            <div class="row justify-content-center">
                                
                                <div class="col-sm-12 col-md-10 col-lg-8">
                                    
                                    <form method="GET" action="inativarFuncionario">
                                        
                                        <div class="form-row">

                                            <div class="form-group col-lg-6">

                                                <input type="hidden" name="idFuncionario" value="${idFuncionario}">
                                                <button type="submit" class="btn btn-danger btn-block" value="Confirmar">Sim</button>

                                            </div>
                                                
                                            <div class="form-group col-lg-6">

                                                <button type="button" class="btn btn-info btn-block" data-dismiss="modal">Não</button>

                                            </div>
                                            
                                        </div>

                                    </form>                                
                                    
                                </div>
                            </div>

                        </div>

                    </div>
                        
                </div>
                        
            </div>
                        
        </div>

        <!-- Modal novo telefone -->
        <div class="modal fade" id="novoTelefone" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            
            <div class="modal-dialog" role="document">
                
                <div class="modal-content">
                    
                    <div class="modal-header">

                        <h5 class="modal-title" id="exampleModalLabel">Cadastro de Contato</h5>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>

                    </div>
                    
                    <div class="modal-body">
                        
                        <div class="container">
                            
                            <form  method="GET" action="adicionarNovoTelefoneFunc">
                                <input type="hidden" name="idFuncionario" value="${idFuncionario}">
                                <div class="form-row">
                                    
                                    <label for="contato">Número *</label>
                                    <input type="text" class="form-control" placeholder="Ex: (17) 99261-2072" name="contato" id="contato" required>
                                    
                                </div>
                                
                                <div class="form-row">
                                    
                                    <label for="tipoTelefone">Tipo do Contato *</label>
                                    <select id="tipoTelefone" class="form-control" name="tipoTelefone">
                                        <option value="Celular" selected>Celular</option>
                                        <option value="Fixo">Fixo</option>
                                    </select>
                                    
                                </div>

                                <div class="form-row my-2">
                                    
                                    <div class="form-group col-lg-6">
                                        
                                        Contato Principal <input type="radio" value="sim" name="telefonePrincipal">
                                        
                                    </div>
                                    
                                </div>
                                
                                <div class="form-row">
                                    
                                    <div class="form-group col-lg-6">
                                        <button type="submit" class="btn btn-info btn-block" value="Confirmar">Adicionar</button>
                                    </div>

                                    <div class="form-group col-lg-6">
                                        <button type="button" class="btn btn-secondary btn-block" data-dismiss="modal">Cancelar</button>
                                    </div>    
                                    
                                </div>  
                                
                            </form>
                            
                        </div>
                        
                    </div>
                                
                </div>
                        
            </div>
                        
        </div>   
    </body>
    <script src="../../javascripts/telefones/telefone.js"></script>
    <script src="../../javascripts/cadastroFuncionario/funcionarioEditar.js"></script>
</html>
