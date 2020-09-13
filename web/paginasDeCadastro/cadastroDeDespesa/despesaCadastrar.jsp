<%-- 
    Document   : despesaCadastrar
    Created on : 07/03/2020, 19:56:08
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">          
        <title>Cadastros - Despesa</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js" integrity="sha256-yE5LLp5HSQ/z+hJeCqkz9hdjNkk1jaiGG0tDCraumnA=" crossorigin="anonymous"></script>  
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeDespesa/despesaCadastrar.css">
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
            <h1>Cadastro de Despesa</h1>
        </div> 
        
        <div class="container my-2">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">
                    
                    <div id="divMsgConfirmacaoCadastro" class="form-row my-2" style="display: none">

                        <div class="form-group col-lg-12">
                            
                            <input type="hidden" id="msgConfirmacaoCadastro" value="${msgConfirmacaoCadastro}">

                            <h3 class="text-success">${msgSucesso}</h3>
                            <p id="msgErro" class="text-danger">${msgErro}</p>

                        </div>

                    </div> 

                    <div class="row col-lg-12">

                        <h6 id="msgTextoSelecioneOpcoes">Por favor, selecione a opção de cadastro nos botões abaixo:</h6>

                    </div> 

                </div>  

            </div>

        </div>

        <div class="container my-2">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">

                        <div class="col-lg-6 my-1">

                            <button type="submit" class="btn btn-info btn-lg btn-block" onclick="tipoDespesa()">TIPO DE DESPESA</button>

                        </div>

                        <div class="col-lg-6 my-1">

                            <button type="submit" class="btn btn-info btn-lg btn-block" onclick="tipoDespesaManual()"/>DESCRIÇÃO MANUAL</button>

                        </div>

                    </div> 

                </div>  

            </div>

        </div>

        <div class="container">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <form method="POST" id="cadastrarDespesaForm" action="cadastrarDespesa">
                        
                        <input type="hidden" id="controllerManualOuTipoDespesa" name="controllerManualOuTipoDespesa" value="1">
                        <input type="hidden" id="countDespesa" name="countDespesa" value="0">

                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <label for="jsDescricaoDespesa"><h5>Despesa: *</h5></label>

                                <input type="text" id="descricaoDespesa" maxlength="100" class="form-control" placeholder="Ex: Figurino" name="descricaoDespesa" value="${descricaoDespesa}">

                                <select type="select" class="form-control" id="tipoDespesa" name="tipoDespesa" style="display: none">
                                    <option value="">Clique para selecionar</option>
                                        <c:forEach var="item" items="${listaTipoDespesas}">
                                            <option value="${item.idTipoDeDespesa}">
                                                ${item.nomeDespesa}
                                            </option>
                                        </c:forEach>
                                </select>

                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-6">

                                <label for="jsValorDepesa"><h5>Valor da Despesa: *</h5></label>
                                <input type="text" id="jsValorDepesa" class="form-control" placeholder="Ex: 0.00" name="jsValorDepesa" value="">

                            </div>

                            <div class="form-group col-lg-6">

                                <label for="jsFormaPagamento"><h5>Forma de Pagamento: *</h5></label>
                                <select type="select" class="form-control" id="jsFormaPagamento">
                                    <option value="">Clique para selecionar</option>
                                    <c:forEach var="item" items="${listaTipoPagamento}">
                                        <option value="${item.idFormaPagamento}+${item.nomePagamento}">
                                            ${item.nomePagamento}
                                        </option>
                                    </c:forEach>
                                </select>

                            </div>

                        </div>   

                        <div class="form-row">

                            <div class="form-group col-lg-5">

                                <label for="jsDataPagamento"><h5>Data de pagamento: *</h5></label>
                                <input type="text" id="jsDataPagamento" minlenth="10" class="form-control" placeholder="Ex: 00/00/0000" name="jsDataPagamento" value="">

                            </div>

                            <div class="form-group col-lg-5">

                                <label for="jsDespesaPpaga"><h5>Pago? *</h5></label>
                                <select class="form-control" name="jsDespesaPpaga" id="jsDespesaPaga">
                                    <option value="Sim" selected>Sim</option>
                                    <option values="Não">Não</option>
                                </select>

                            </div>

                            <div class="form-group col-lg-2 mt-3">

                                <button type="button" class="btn btn-info btn-block" id="add-despesa">Adicionar</button>

                            </div>

                        </div>
                        
                        <div id="divMsgValidacao" class="form-row my-2" style="display: none">

                            <div class="form-group col-lg-12">    

                                <h5 id="msgTratamentoAddDespesa" style="color: red;"></h5>

                            </div>

                        </div> 
                        
                        <div id="divTabelaDespesa" style="display: none">
                            
                            <div class="form-row my-2">    
                                
                                <div class="form-group col-lg-12">
                                    
                                    <div class="table-responsive border border-secondary rounded">

                                        <table id="tabelaDespesas" class="table table-striped table-bordered">
                                            <thead> 
                                                <tr class="bg-info">    
                                                    <th scope="col">Valor</th>
                                                    <th scope="col">Forma de Pagamento</th>
                                                    <th scope="col">Data de Pagamento</th>
                                                    <th scope="col">Pago?</th>
                                                    <th scope="col"></th>
                                                </tr>
                                            </thead> 
                                            <tbody id="tbodyDespesas">
                                            </tbody>
                                        </table>

                                    </div> 
                                    
                                </div>
                                
                            </div>

                            <div class="form-row my-2">

                                <div class="form-group col-lg-4">    

                                    <h6 class="valores" id="valorTotalDespesa"></h6>

                                </div>

                                <div class="form-group col-lg-4">    

                                    <h6 class="valores" id="valorPagoDespesa"></h6>

                                </div>

                                <div class="form-group col-lg-4">    

                                    <h6 class="valores" id="valorApagarDespesa"></h6>

                                </div>

                            </div>   
                            
                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <label for="obsDespesa"><h5>Observação: *</h5></label>
                                <textarea type="text" class="form-control" maxlength="200" name="obsDespesa" id="obsDespesa" rows="3" value="${obsDespesa}"></textarea>

                            </div>

                        </div>                

                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <button class="btn btn-success btn-lg btn-block" type="submit">Cadastrar</button> 

                            </div>

                        </div> 

                    </form>

                </div>

            </div> 

        </div>

        <div class="container my-2">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="row">

                        <div class="col-lg-12 my-1">

                            <a class="btn btn-secondary btn-lg btn-block" href="despesaPrincipal.jsp">Voltar</a>

                        </div>

                    </div> 

                </div>  

            </div>

        </div>                        
    </body>
    <script src="../../javascripts/cadastroDeDespesa/cadastrarDespesa.js"></script>
    <script>
              
        $("#jsDataPagamento").mask("00/00/0000");
        $("#jsValorDepesa").mask("999999.00", {reverse: true});
  
    </script>    
</html>
