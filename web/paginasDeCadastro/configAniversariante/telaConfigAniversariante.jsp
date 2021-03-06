<%-- 
    Document   : telaConfigAniversariante
    Created on : 19/03/2020, 23:24:44
    Author     : Jo�o Pedro
--%>

<%@include file="/controleDeSession.jsp" %> <%-- inclui o arquivo que faz a valida��o de session do usuario --%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notifica��o Aniversariante</title>
        <link rel="shortcut icon" href="../../custom/img/favicon.jpg">
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
       
        <!-- Icons -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
        <!-- Customiza��o -->       
        <link rel="stylesheet" href="../../custom/css/navBarOnly/navBar.css">
        <link rel="stylesheet" href="../../custom/css/paginaDeCadastros/paginaConfigAniversariante/telaConfigAniversariante.css">
<!--<style>
	div{
		border: solid 1px blue;
	}
</style>        -->
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-expand-lg navbar-light navbar-css">
            <img src="../../custom/img/logoFundoLogin.png" id="logo-navbar">
            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#NavbarSite"><span class="navbar-toggler-icon navbar-light"></span></button>
            <div class="collapse navbar-collapse" id="NavbarSite">
                <ul class="navbar-nav ml-auto">
                    <!-- Bot�o p�gina inicial -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="/Arte-E-Magia_tst/paginaInicial.jsp"><i class="fas fa-home"></i>&nbsp;P�gina Inicial</a>
                    </li>
                    <!-- Bot�o cadastros -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="../cadastros.jsp"><i class="far fa-address-book"></i>&nbsp;Cadastros</a>
                    </li>
                    <!-- Config aniversariante -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="../../paginasDeRelatorios/relatorios.jsp"><i class="far fa-clipboard"></i>&nbsp;Relat�rios</a>
                    </li>                    
                    <!-- Bot�o relatorios -->
                    <li class="nav-item h5">
                        <a class="nav-link" href="telaConfigAniversariante.jsp"><i class="fas fa-cog"></i>&nbsp;Configura��o</a>                        
                    </li>
                </ul>
                <!-- Bot�o Sair -->
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item h5">
                        <a class="nav-link" href="/Arte-E-Magia_tst/deslogar.jsp"><i class="fas fa-sign-out-alt"></i>&nbsp;Sair</a>
                    </li>
                </ul>
                <!-- Fim navbar da p�gina-->
            </div>
        </nav>
        <div class="jumbotron text-center">
            <h1>Notifica��o de Aniversariante</h1>
        </div>
        
        <div class="container my-2">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <form method="GET" action="verificarConfigAniversariante">

                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <button type="submit" class="btn btn-info btn-lg btn-block" value="VerificarConfigAtual">Ver configura��o atual</button>

                            </div>

                        </div>

                    </form>
                    
                </div>

            </div>

        </div> 

        <div class="container my-2">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <button type="button" class="btn btn-info btn-lg btn-block" onclick="editarConfig()" value="Confirmar">Editar Configura��o</button>            

                </div>

            </div>

        </div>

        <div class="container my-4" id="formEditarConfig" style="display: none !important">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <form method="GET" action="configAniversariante">

                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <label for="qtdDias"><h5>Por favor, digite a quantidade de dias para a notifica��o de aniversariante: </h5></label>
                                <input type="text" name="qtdDias" placeholder="Digite aqui a quantidade de dias" maxlength="3" class="form-control" id="qtdDias" required>

                            </div>

                        </div>

                        <div class="form-row">

                            <div class="form-group col-lg-12">

                                <button type="submit" class="btn btn-info btn-lg btn-block" value="Confirmar">Confirmar</button>

                            </div>

                        </div>                

                    </form>               

                </div>

            </div>

        </div>
                            
        <div class="container my-3">

            <div class="row justify-content-center">

                <div class="col-sm-12 col-md-10 col-lg-8">

                    <div class="col-sm-12 text-center">
                    
                        <h3 class="text-success">${msg}</h3>
                        <h3>${textoConfigAtual}</h3>
                        
                    </div>
                    
                </div>


            </div>
                    
        </div>
                        
    </body>
    <script src="../../javascripts/cadastroDeConfigAniversariante/configAniversariante.js"></script>    
</html>
