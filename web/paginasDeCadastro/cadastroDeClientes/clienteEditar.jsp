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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastros - Cliente</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-tsQFqpEReu7ZLhBV2VZlAu7zcOV+rXbYlF2cqB8txI/8aZajjp4Bqd+V6D5IgvKT" crossorigin="anonymous"></script>        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA=" crossorigin="anonymous"></script>                
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customização -->       
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeClientes/clienteEditar.css">
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../../custom/img/logoFundoLogin.png" id="logo-navbar">
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon navbar-light"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto">
                    <!-- Botão página inicial -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp"><i class="fas fa-home"></i>&nbsp;Página Inicial</a>
                    </li>
                    <!-- Botão cadastros -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="../cadastros.jsp"><i class="far fa-address-book"></i>&nbsp;Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="../../paginasDeRelatorios/relatorios.jsp"><i class="far fa-clipboard"></i>&nbsp;Relatórios</a>
                    </li>                    
                    <!-- Botão relatorios -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="../configAniversariante/telaConfigAniversariante.jsp"><i class="fas fa-cog"></i>&nbsp;Configuração</a>                        
                    </li>
                </ul>
                <!-- Botão Sair -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item h5">
                        <a class="nav-link" href="/Arte-E-Magia_tst/deslogar.jsp"><i class="fas fa-sign-out-alt"></i>&nbsp;Sair</a>
                    </li>
                </ul>
                <!-- Fim navbar da página-->
            </div>
        </nav>
        
        <div class="jumbotron text-center">
            <h1>Editar Cliente</h1>
        </div> 
        
        <div class="container">

            <div class="row justify-content-center">
                
                <div class="col-sm-12 col-md-10 col-lg-8">          
                    
                    <form class="form-group" method="GET" action="editarCliente2">

                        <input type="hidden" name="tipoDeFesta" value="${cliente.tipoDeFesta}">
                        <input type="hidden" name="idCliente" value="${cliente.idCliente}">                        
                        
                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <h3><i class="fas fa-user-check"></i> Dados do Cliente </h3>

                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-6">

                                <label for="nomeCliente">Nome do Cliente *</label>
                                <input type="text" class="form-control" maxlength="45" name="nomeCliente" id="nomeCliente" value="${cliente.nomeCliente}" required>

                            </div>

                            <div class="form-group col-lg-6">

                                <label for="cpf">CPF do Cliente *</label>
                                <input type="text" class="form-control" minlength="14" name="cpf" id="cpf" value="${cliente.cpf}" required>
                    
                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-6">

                                <label for="tipoFesta">Tipo de Evento *</label>
                                <select type="select" class="form-control" id="tipoFesta" name="tipoFesta">
                                    <option value="${cliente.idTipoDeFesta}">${cliente.tipoDeFesta}</option>
                                        <c:forEach var="item" items="${listaTipoDeFesta}">
                                            <option value="${item.idTipoDeFesta}">
                                                ${item.descricaoTipoDeFesta}
                                            </option>
                                        </c:forEach>
                                </select>      

                            </div>                            

                            <div class="form-group col-lg-6">

                                <input type="hidden" name="idEmail" value="${email.idEmail}">

                                <label for="email"> E-mail: *</label>
                                <input type="email" class="form-control" maxlength="45" name="email" id="email" value="${email.email}">

                            </div>

                        </div>

                        <div class="form-row mt-3">

                            <div class="form-group col-lg-12">

                                <h3><i class="fas fa-map-marker-alt"></i> Dados Residênciais </h3>

                            </div>

                        </div>   

                        <div class="form-row">

                            <input type="hidden" name="idEnderecos" value="${endereco.idEnderecos}">

                            <div class="form-group col-lg-6">

                                <label for="cep"> CEP: *</label>
                                <input type="text" class="form-control" minlength="9" name="cep" id="cep" value="${endereco.cep}" required>

                            </div>

                            <div class="form-group col-lg-6">

                                <label for="cidade">Cidade: *</label>
                                <input type="text" class="form-control" name="cidade" id="cidade" value="${endereco.cidade}" required>
                    
                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-6">

                                <label for="bairro"> Bairro: *</label>
                                <input type="text" class="form-control" name="bairro" id="bairro" value="${endereco.bairro}" required>

                            </div>

                            <div class="form-group col-lg-6">

                                <label for="rua">Rua: *</label>
                                <input type="text" class="form-control" name="rua" id="rua" value="${endereco.rua}" required>
                    
                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-6">

                                <label for="numero"> Número: *</label>
                                <input type="text" class="form-control" name="numero" id="numero" value="${endereco.numero}" required>

                            </div>

                            <div class="form-group col-lg-6">

                                <label for="rua">Complemento: *</label>
                                <input type="text" class="form-control" name="complemento" id="complemento" value="${endereco.complemento}">
                    
                            </div>

                        </div>
                        
                        <div class="form-row">

                            <div class="form-group col-lg-12 my-2">

                                <button type="submit" class="btn btn-info btn-lg btn-block" >Salvar</button>
                                
                            </div>
                            
                        </div>                        
                        
                        <div class="form-row">

                            <div class="form-group col-lg-12 my-2">

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

                        <div class="col-lg-12 text-center my-3">

                            <h3 class="text-success">${msg}</h3>

                        </div>

                    </div>   
                            
                </div>
            
            </div>
        
        </div>
                            
        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">

                        <div class="col-lg-7">

                            <h3><i class="fas fa-address-book"></i> Contatos do Cliente :</h3>

                        </div>

                        <div class="col-lg-5">

                            <button type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#novoTelefone">
                                +Novo Contato
                            </button>                    

                        </div> 

                    </div>

                    <div class="col-lg-13 my-1 border border-secondary rounded">

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
                                    <c:forEach items="${listaTelefoneCliente}" var="item"> 
                                        <tr>
                                            <td>${item.numero}</td>
                                            <td>${item.tipoTelefone}</td>
                                            <td>
                                                <form method="GET" action="excluirTelefoneCliente">
                                                    <input type="hidden" name="idClienteTelefone" value="${cliente.idCliente}">
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
                            
        <div class="container my-3 mt-4">

            <input type="hidden" id="controllerListagemCrianca" value="${controllerListagemCrianca}">  

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">

                        <div class="col-lg-7">

                            <h3><i class="fas fa-child"></i> Crianças do Cliente :</h3>

                        </div>

                        <div class="col-lg-5">

                            <form method="GET" action="editarORcadastrarCrianca">
                                <input type="hidden" name="idClienteCrianca" value="${cliente.idCliente}">
                                <button type="submit" class="btn btn-info btn-block" >+Nova Criança</button>
                            </form>                      

                        </div> 

                    </div>

                    <div class="col-lg-13 my-1 border border-secondary rounded"  style="display: none" id="divCrianca">

                        <div class="table-responsive">

                            <table class="table table-striped table-bordered">
                                <thead> 
                                    <tr class="bg-danger">    
                                        <th scope="col">Nome</th>
                                        <th scope="col">Sexo</th>
                                        <th scope="col">Data de Nascimento</th>
                                        <th></th>
                                    </tr>
                                </thead> 
                                <tbody>
                                    <c:forEach items="${listaCriancaCliente}" var="item"> 
                                        <tr>
                                            <td>${item.nomeCrianca}</td>
                                            <td>${item.sexo}</td>
                                            <td>${item.dataNascimento}</td>
                                            <td>
                                                <form method="GET" action="editarORcadastrarCrianca">
                                                    <input type="hidden" name="idClienteCrianca" value="${item.idCliente}">
                                                    <input type="hidden" name="idCrianca" value="${item.idCrianca}">
                                                    <input type="hidden" name="nomeCrianca" value="${item.nomeCrianca}">
                                                    <input type="hidden" name="sexo" value="${item.sexo}">
                                                    <input type="hidden" name="dataNascimento" value="${item.dataNascimento}">
                                                    <button class="btn btn-info"> Editar </button>
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
                    
                    <form method="GET" action="listaCliente">
                        
                        <div class="form-row my-3">

                            <button type="submit" class="btn btn-secondary btn-lg btn-block">Voltar</button>
                            
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

                            <h5 class="modal-title" id="exampleModalLabel">Excluir Cliente</h5>
                            
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
                                    
                                    <form method="GET" action="inativarCliente2">
                                        
                                        <div class="form-row">

                                            <div class="form-group col-lg-6">

                                                <input type="hidden" name="idCliente" value="${cliente.idCliente}">

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
        
                            <form  method="GET" action="adicionarNovoTelefoneCliente">

                                <input type="hidden" name="idCliente" value="${cliente.idCliente}">

                                <div class="form-row">
                                    
                                    <label for="contato">Número *</label>
                                    <input type="text" class="form-control" minlength="13" placeholder="Ex: (17) 99261-2072" name="contato" id="contato" required>
                                    
                                </div>
                                
                                <div class="form-row mt-2">
                                    
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
<!--    <script src="../../javascripts/telefones/destacarTelefone.js"></script>-->
    <script src="../../javascripts/enderecos/enderecosAutomaticos.js"></script>  
    <script src="../../javascripts/cadastroDeClientes/clienteEditar.js"></script> 
    <script src="../../javascripts/telefones/telefone.js"></script>    
    <script>
        $("#cpf").mask("000.000.000-00");
        $("#cep").mask("00000-000");        
    </script>     
</html>