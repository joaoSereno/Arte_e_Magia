<%-- 
    Document   : cadastros
    Created on : 08/02/2020, 19:30:44
    Author     : João Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a validação de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastros</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
        <!--        navbar da página-->
        <nav class="navbar navbar-light navbar-expand-lg" style="background-color: #ef1b3436;">
            <!-- logo do navbar -->
            <div>
                <a class="navbar-brand">
                    <img src="../custom/img/logoArte_E_Magia.png" width="130" height="60" class="d-inline-block align-top" alt="Logo Arte & Magia">
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
                        <a href="cadastros.jsp" class="btn btn-outline-light" style="background-color: #ec1b1b00;">Cadastros</a>
                    </li>
                    <!-- botão relatorios -->
                    <li class="nav-item">
                        <a href="../paginasDeRelatorios/relatorios.jsp" class="btn btn-outline-light" style="background-color: #ec1b1b00;">Relatórios</a>
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
        <a href="cadastroDeClientes/clienteCadastrar.jsp" type="button" class="btn btn-primary">Clientes</a>
        <br>
        <br>
        <a href="cadastroDeFuncionario/funcionarioCadastrar.jsp" type="button" class="btn btn-primary">Funcionário</a>
        
        <a href="cadastroDeFesta/clientePrincipal.jsp" type="button" class="btn btn-primary">Festa</a>
        
        <a href="cadastroTipoPagamento/tipoPagamentoPrincipal.jsp" class="btn btn-primary">Formas de Pagamento</a>

        <a href="cadastroTipoDespesa/tipoDespesaPrincipal.jsp" type="button" class="btn btn-primary">Tipo de Despesa</a>
        
        <a href="cadastroDeDespesa/despesaCadastrar.jsp" type="button "class="btn btn-primary">Despesa</a>
        
        <a href="cadastroDePacote/pacotePrincipal.jsp" type="button" class="btn btn-primary">Pacote</a>
        
        <a href="cadastroDeUsuario/usuarioCadastrar.jsp" type="button "class="btn btn-primary">Conta de acesso</a>
        
        <br>
        <br>
        <!-- div de modal para notificação de aniversariante -->
        <div>
            <!-- botão que abre o modal de novo  -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#novoTelefone">
              Notificação aniversariante
            </button>

            <!-- Modal -->
            <div class="modal fade" id="novoTelefone" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Notificação de aniversariante próximos =)</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <br> 
                  <div>
                    <!-- form para config aniversario --> 
                    <form method="GET" action="configAniversariante"> <%-- joga formulario para o controllerConfigAniversariante --%>
                        Quantidade de dias:
                        <input type="text" name="qtdDias">
                        <button type="submit" class="btn btn-primary" value="Confirmar">Confirmar</button>
                    </form> 
                    <!-- fim form para adicionar novo contato --> 
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                  </div>
                </div>
              </div>
            </div> 
             <!-- fim Modal -->                          
        </div> 
</body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>    
</html>
