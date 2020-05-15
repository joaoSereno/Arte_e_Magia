<%-- 
    Document   : festaEditar
    Created on : 10/05/2020, 10:57:55
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
        <title>Cadastros - Evento</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customização -->   
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/cadastroDeFesta/festaEditar.css">
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
        <h3>Tela Editar Festa</h3>
        <!-- div confirmar informações ( etapa final etapa )-->         
        <div id="confirmarInformacoes" style="display: none">
            <div class="accordion" id="accordionExample">
                <!-- Contratante -->
                <div class="card bg-light border-dark">
                    <div class="card-header" id="headingContratante">
                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseContratante" aria-expanded="false" aria-controls="collapseContratante">
                            <h5 class="mb-0">1° ETAPA - Contratante</h5>
                        </button>
                        <button class="btn btn-primary float-right" onclick="editarEtapa(1)">Editar</button>
                    </div>
                    <div id="collapseContratante" class="collapse" aria-labelledby="headingContratante" data-parent="#accordionExample">
                        <div class="card-body">
                            <h6 class="card-title" id="clienteInf"></h6>
                        </div>
                    </div>
                </div>
                <!-- Aniversariantes  -->
                <div class="card border-dark">
                    <div class="card-header" id="headingAniversariante">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseAniversariante" aria-expanded="false" aria-controls="collapseAniversariante">
                            <h5 class="mb-0">2° ETAPA - Aniversariantes</h5>
                        </button>
                        <button class="btn btn-primary float-right" onclick="editarEtapa(2)">Editar</button>
                    </div>
                    <div id="collapseAniversariante" class="collapse" aria-labelledby="headingAniversariante" data-parent="#accordionExample">
                        <div class="card-body">
                            <h6 class="card-title" id="criancasInf"></h6>
                        </div>
                    </div>
                </div>
                <!-- Animadores -->
                <div class="card border-dark bg-light">
                    <div class="card-header border-dark" id="headingAnimadores">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseAnimadores" aria-expanded="false" aria-controls="collapseAnimadores">
                            <h5 class="mb-0">3° ETAPA - Animadores</h5>
                        </button>
                        <button class="btn btn-primary float-right" onclick="editarEtapa(3)">Editar</button>
                    </div>
                    <div id="collapseAnimadores" class="collapse" aria-labelledby="headingAnimadores" data-parent="#accordionExample">
                        <div id="funcionarioInf" class="card-body">
                        
                        </div>
                    </div>
                </div>
                <!-- Pacotes e pacote add -->
                <div class="card border-dark">
                    <div class="card-header" id="headingPacotes">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapsePacotes" aria-expanded="false" aria-controls="collapsePacotes">
                            <h5 class="mb-0">4° ETAPA - Pacotes & Pacotes Adicionais</h5>
                        </button>
                        <button class="btn btn-primary float-right" onclick="editarEtapa(4)">Editar</button>
                    </div>
                    <div id="collapsePacotes" class="collapse" aria-labelledby="headingPacotes" data-parent="#accordionExample">
                        <div class="card-body">
                            <h6  class="card-title" id="pacoteInf"></h6>
                            <div id="pacoteAddInf">
                                
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Valores add -->
                <div class="card border-dark bg-light">
                    <div class="card-header" id="headingValoresAdd">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseValoresAdd" aria-expanded="false" aria-controls="collapseValoresAdd">
                            <h5 class="mb-0">5° ETAPA - Valores Adicionais</h5>
                        </button>
                        <button class="btn btn-primary float-right" onclick="editarEtapa(5)">Editar</button>
                    </div>
                    <div id="collapseValoresAdd" class="collapse" aria-labelledby="headingValoresAdd" data-parent="#accordionExample">
                        <div id="valoresAddInf" class="card-body">
                        
                        </div>
                    </div>
                </div> 
                <!--  Despesas -->
                <div class="card border-dark">
                    <div class="card-header" id="headingDespesas">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseDespesas" aria-expanded="false" aria-controls="collapseDespesas">
                            <h5 class="mb-0">6° ETAPA - Despesas do Evento</h5>
                        </button>
                        <button class="btn btn-primary float-right" onclick="editarEtapa(6)">Editar</button>
                    </div>
                    <div id="collapseDespesas" class="collapse" aria-labelledby="headingDespesas" data-parent="#accordionExample">
                        <div id="despesasInf" class="card-body">
                        
                        </div>
                    </div>
                </div>
                <!--  Formas de pagamento -->
                <div class="card border-dark bg-light">
                    <div class="card-header" id="headingFormaPagamento">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFormaPagamento" aria-expanded="false" aria-controls="collapseFormaPagamento">
                            <h5 class="mb-0">7° ETAPA - Formas de Pagamento</h5>
                        </button>
                        <button class="btn btn-primary float-right" onclick="editarEtapa(7)">Editar</button>
                    </div>
                    <div id="collapseFormaPagamento" class="collapse" aria-labelledby="headingFormaPagamento" data-parent="#accordionExample">
                        <div id="formasDePagamentoInf" class="card-body">
                        
                        </div>
                    </div>
                </div>
                <!--  Horarios -->
                <div class="card border-dark">
                    <div class="card-header" id="headingHorarios">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseHorarios" aria-expanded="false" aria-controls="collapseHorarios">
                            <h5 class="mb-0">8° ETAPA - Horários do Evento</h5>
                        </button>
                        <button class="btn btn-primary float-right" onclick="editarEtapa(8)">Editar</button>
                    </div>
                    <div id="collapseHorarios" class="collapse" aria-labelledby="headingHorarios" data-parent="#accordionExample">
                        <div id="horariosInf" class="card-body">
                        
                        </div>
                    </div>
                </div> 
                <!-- Endereco -->
                <div class="card border-dark bg-light">
                    <div class="card-header" id="headingEndereco">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseEndereco" aria-expanded="false" aria-controls="collapseEndereco">
                            <h5 class="mb-0">9° ETAPA - Endereço do Evento</h5>
                        </button>
                        <button class="btn btn-primary float-right" onclick="editarEtapa(9)">Editar</button>
                    </div>
                    <div id="collapseEndereco" class="collapse" aria-labelledby="headingEndereco" data-parent="#accordionExample">
                        <div id="enderecoFestaInf" class="card-body">
                            
                        </div>
                    </div>
                </div>
                <!--  Informações finais --> 
                <div class="card border-dark">
                    <div class="card-header" id="headingInformacoesFinais">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseInformacoesFinais" aria-expanded="false" aria-controls="collapseInformacoesFinais">
                            <h5 class="mb-0">10° ETAPA - Informações Finais</h5>
                        </button>
                        <button class="btn btn-primary float-right" onclick="editarEtapa(10)">Editar</button>
                    </div>
                    <div id="collapseInformacoesFinais" class="collapse secondary" aria-labelledby="headingInformacoesFinais" data-parent="#accordionExample">
                        <div class="card-body">
                            <h6 class="card-title" id="descricaoEventoInf"></h6>
                            <h6 class="card-title" id="dataDaFestaInf"></h6>
                            <h6 class="card-title" id="tipoDeFestaInf"></h6>
                            <h6 class="card-title" id="qtdCriancaNaFestaInf"></h6>
                            <h6 class="card-title" id="ObsInf"></h6>
                            <h6 class="card-title" id="festaRealizadaInf"></h6>                  
                        </div>
                    </div>
                </div>
                <!-- Valores finais -->
                <div class="card border-dark bg-light">
                    <div class="card-header" id="headingValores">
                        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseValores" aria-expanded="false" aria-controls="collapseValores">
                            <h5 class="mb-0">Valores Finais do Evento</h5>
                        </button>
                    </div>
                    <div id="collapseValores" class="collapse" aria-labelledby="headingValores" data-parent="#accordionExample">
                        <div id="valoresFinalInf" class="card-body">
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>        
        <form method="POST" id="editarFestaForm" action="editarEvento2">
            <!-- contador input crianca -->
            <input type="hidden" name="qtdCrianca" id="qtdCrianca" value="0">
            <!-- contador input funcionario -->
            <input type="hidden" name="qtdFuncioanrio" id="qtdFuncioanrio" value="0">
            <!-- contador input valor add -->
            <input type="hidden" name="qtdValorAdicional" id="qtdValorAdicional" value="0">
            <!-- input pacote -->
            <input type="hidden" name="idPacoteF" id="idPacoteF" value="">
            <!-- input contador e verificao se tem de pacote add--> 
            <input type="hidden" name="qtdPacoteAdicional" id="qtdPacoteAdicional" value="0">
            <input type="hidden" name="temPacoteAdicional" id="temPacoteAdicional" value="0">
            <!-- input contador despesa --> 
            <input type="hidden" name="qtdDespesa" id="qtdDespesa" value="0">
            <!-- input contador horario -->
            <input type="hidden" name="qtdHorario" id="qtdHorario" value="0">
            <!-- input contador formas de pagamento e valor -->
            <input type="hidden" name="qtdFPeValor" id="qtdFPeValor" value="0">
            <!-- inputs do endereço -->
            <input type="hidden" name="cepF" id="cepF" value="">
            <input type="hidden" name="cidadeF" id="cidadeF" value="">
            <input type="hidden" name="bairroF" id="bairroF" value="">
            <input type="hidden" name="ruaF" id="ruaF" value="">
            <input type="hidden" name="numeroF" id="numeroF" value="">
            <input type="hidden" name="complementoF" id="complementoF" value="">   
            <!-- inputs das inf adicionais -->
            <input type="hidden" name="descricaoEventoF" id="descricaoEventoF" value="">
            <input type="hidden" name="qtdCriancaNaFestaF" id="qtdCriancaNaFestaF" value="">
            <input type="hidden" name="dataFestaF" id="dataFestaF" value="">
            <input type="hidden" name="idTipoDaFestaF" id="idTipoDaFestaF" value="">
            <input type="hidden" name="observacaoF" id="observacaoF" value="">
            <input type="hidden" name="festaRealizadaF" id="festaRealizadaF" value="">
            <!-- input valores finais da festa -->
            <input type="hidden" name="valorTotalFesta" id="valorTotalFesta" value="">
            <input type="hidden" name="valorTotalDespesa" id="valorTotalDespesa" value="">
            <input type="hidden" name="valorTotalLucro" id="valorTotalLucro" value="">
            <input type="hidden" name="valorReceberContratante" id="valorReceberContratante" value="">
            <button class="btn btn-warning" type="submit">Confirmar</button> 
        </form>        
    </body>
</html>
