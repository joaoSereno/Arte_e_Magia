/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//variaveis globais utilizadas nas functions onclik
    //dados globais dos clientes selecionados
    var idCliente;
    var nomeCliente;

    //variavel que verifica se já passou pela etapa 2 para não criar duplicado
    var countEtapa2 = 0;
    
    //verifica se o cliente possui crianca
    var possuiCrianca = 0;

    //varivel que recebe a quantidade de crianças adicionadas no form
    var quantidadeCrianca = 0;
    var quantidadeCrianca2 = 0;
    var quantidadeCriancaBotaoRemover = 0;

    //variaveis que controlam o texto de confirmação da criança na ultima etapa
    let listaNomeCrianca = [];
    var textoConfirmacaoCrianca = "";

    //variaveis do valor do pacote para fazer os calculos da etapa 8
    var nomePacote = "";
    var valorPacote = 0;

    //variaveis globais dos valores finais
    var valorTotalFesta = 0;
    var valorTotalDespesa = 0;
    var valorLucro = 0;
    var valorPegarContratante = 0;
    
    //verifica se passo pela etapa 8 alguma vez e criou o texto de valor a pegar com contratante
    var criouPegarContratante = 0;

//variaveis globais utilizadas nas criação das tabelas e inputs dinamicos
//var dos funcionarios
    //count
    var jsCountFuncionario = 0;
    var jsCountFuncionario2 = 0;
    
    //variaveis que controlam o texto de confirmação dos funcionario na ultima etapa
    let listaFuncionarios = [];
    var countListaFuncionario = 0;
    
    //lista que controla os valores relacionados ao funcionario
    var listaFuncionarioValores = [];
    
    //variavel de msg de erro da etapa 3
    var msgTratamentoEtapa3 = document.querySelector("#msgTratamentoEtapa3");
    
//var das pacotes adicionais
    //count
    var jsCountPacotesAdicionais = 0;
    var jsCountPacotesAdicionais2 = 0;

    //variaveis que controlam o texto de confirmação dos pacotes adicionais na ultima etapa
    let listaPacotesAdicionais = [];
    var countPacotesAdicionais = 0;

    //lista que controla os valores relacionados ao pacote adicionais
    let listaPacoteAddValores = [];
    
//var do valor adicional
    //count
    var jsCountValorAdicional = 0;
    var jsCountValorAdicional2 = 0;

    //variaveis que controlam o texto de confirmação dos valores adicionais na ultima etapa
    let listaValoresAdicionais = [];
    var countValoresAdicionais = 0;
    
    //lista que controla os valores relacionados ao valores adicionais
    let listaValoresAddValores = [];
    
//var das despesas
    //count
    var jsCountDespesa = 0;
    var jsCountDespesa2 = 0;
    
    //variaveis que controlam o texto de confirmação das despesas na ultima etapa
    let listaDespesas = [];
    var countDespesas = 0;
    
    //lista que controla os valores relacionados as despesas
    let listaValoresDespesa = [];
    
    //variavel tratamento de erro etapa 6
    var msgTratamentoEtapa6 = document.querySelector("#msgTratamentoEtapa6");

//var dos horarios
    //count
    var jsCountHorario = 0;
    var jsCountHorario2 = 0;

    //variaveis que controlam o texto de confirmação dos valores adicionais na ultima etapa
    let listaHorarios = [];
    var countHorarios = 0;
    
    //variavel de msg de erro da etapa 3
    var msgTratamentoEtapa8 = document.querySelector("#msgTratamentoEtapa8");    

//var das formas de pagamento e valor
    //count
    var jsCountFPeValor = 0;
    var jsCountFPeValor2 = 0;
    
    //variaveis que controlam o texto de confirmação dos valores e fp na ultima etapa
    let listaFPeValor = [];
    var countFPeValor = 0;
    
    //variaveis que controla o calculo ao adicionar forma de pagamento
    var valorTotalFestaLocal = 0;
    var countPrimeiraVezAdd = 0; //verifica se é a primeira vez que add fp
    var valorTotalFestaLocalAnterior = 0; //salvo o valor total anterior caso o usuário voltar etapas
    
    //variavel para tratamento de erro na etapa 7;
    var msgTratamentoEtapa7 = document.querySelector("#msgTratamentoEtapa7");
    
//recebendo os botões dos inputs dinamicos e salvando em uma variavel
var btnAddFuncionario = document.querySelector("#add-funcionario");
var btnAddPacotesAdicionais = document.querySelector("#add-pacoteAdicional");
var btnAddValorAdicional = document.querySelector("#add-valorAdicional");
var btnAddDespesa = document.querySelector("#add-despesaFesta");
var btnAddHorario = document.querySelector("#add-horario");
var btnFPeValor = document.querySelector("#add-valorEfp");

//FUNÇÕES PRESENTES NA ETAPA 1
    //quando clicar no selecionar cliente
    function selecionarCliente(idClienteP) { //recebe por parametro o idCliente

        //salva o valor do parametro na varialvel global "idCliente"
        idCliente = idClienteP;
        //salva na variavel global "nomeCliente"
        nomeCliente = document.getElementById('nomeCliente'+idCliente).value;

        //recebendo H3 e setando nela o texto com o nome do cliente
        var h3ClienteSelecionado = document.querySelector("#clienteSelecionado");
        h3ClienteSelecionado.textContent = "Cliente: " + nomeCliente;

        document.getElementById('listagemDeCliente').style.display = 'none'; //desabilita a tabela de listagem dos clientes
        document.getElementById('confirmacaoCliente').style.display = ''; //habilita a confirmação da etapa 1
        
        //seta informação do cliente na ultima etapa
        var confirmacaoInfCliente = document.querySelector("#clienteInf");
        confirmacaoInfCliente.textContent = "Contratante: " + nomeCliente;        
        
        //COMEÇO DA CRIAÇÃO O INPUT DO CADASTRO DE FESTA
        //cria um elento html input
        var inputCliente = document.createElement("input"); 
        
        //setando atributos do input
        inputCliente.type = "hidden";
        inputCliente.name = "idCliente";
        inputCliente.id = "idCliente";
        inputCliente.value = idCliente;
        
        //buscando o form de cadastro e setando nele o input criado
        var formCadastroDeFesta = document.querySelector('#cadastrarFestaForm');
        formCadastroDeFesta.appendChild(inputCliente);
        //FIM DA CRIAÇÃO O INPUT DO CADASTRO DE FESTA
    
    }; 

    //quando clicar para trocar cliente
    function trocarCliente() {

        //seta como vazio os atributos do cliente seleciado
        idCliente = 0;
        nomeCliente = "";

        //apaga o input criado na "function selecionarCliente"
        document.getElementById('idCliente').remove();
        
        document.getElementById('listagemDeCliente').style.display = ''; //habilita a tabela de listagem do cliente
        document.getElementById('confirmacaoCliente').style.display = 'none'; //desabilita a confirmação da etapa 1
        document.getElementById('confirmacaoCliente').style.display = 'none'; //desabilita a confirmação da etapa 1

        //como está trocando de cliente , as crianças serão outras , então limpa tudo que é relacionado as crianças (etapa2)
        if(countEtapa2 !== 0){
            document.getElementById("tbodyAniversariantes").innerHTML="";
            document.getElementById('tabelaAniversariante').style.display = 'none'; //desabilita a tabela de listagem de criança
            countEtapa2 = 0;
        }        
        
        //apaga os inputs das crianças caso tiver
        for(var i = 0; i < quantidadeCrianca2; i++){
            var existeInputCrianca = document.getElementById('idCrianca'+(i+1));  
            if(existeInputCrianca !== null){
                document.getElementById('idCrianca'+(i+1)).remove();            
            }
            
        }
        
        //limpando/zerando as variaveis relacionadas a criança
        quantidadeCrianca = 0;
        quantidadeCriancaBotaoRemover = 0;
        quantidadeCrianca2 = 0;
        textoConfirmacaoCrianca = "";
        listaNomeCrianca = [];
        possuiCrianca = 0;
    };

    //quando clicar em etapa 2
    function etapa2() {
        countEtapa2++;

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "2º Etapa - Selecionar Criança";    

        //recebe o controlador com total e todos os aniversariantes e salva em uma variavel 
        var totalCriancas = document.getElementById('totalCriancas').value;
        var listaConcatenadaCrianca = document.getElementById('listaConcatenadaCrianca').value;   

        document.getElementById('confirmacaoCliente').style.display = 'none'; //desabilita a confirmação da etapa 1
        document.getElementById('selecionarAniversariantes').style.display = ''; //habilita a etapa 2

        //pega a lista concatenada das crianças e faz um split e salva o resultado na lista resultado
        var resultado = listaConcatenadaCrianca.split("/");

        //percorre essa lista resultado
        resultado.forEach((valorAtual) => {

            //variaveis 
            var idCrianca = 0;
            var nomeCrianca = "";
            var idClienteCrianca = 0;
            var countResultado = 0;

            //faz novamente um split em cada objeto da lista 
            var resultado2 = valorAtual.split(",");     

            //salva nas variaveis os valores da criança
            resultado2.forEach((valorAtual2) => {
                countResultado++;
                //se é a primeira vez que passa na lista, salva o id
                if (countResultado == 1) {
                    idCrianca = valorAtual2;
                } 
                if (countResultado == 2){
                    nomeCrianca = valorAtual2;
                }
                if(countResultado == 3){
                    idClienteCrianca = valorAtual2;
                }
            });

            //verifica se a criança atual do laço, tem o mesmo idCliente que foi selecionado
            if(idCliente == idClienteCrianca){
                //condição para verificar se alguma vez já passou pela etapa 2 e criou os elementos 
                if(countEtapa2 == 1){
                    quantidadeCrianca++;
                    quantidadeCrianca2++;

                    document.getElementById('tabelaAniversariante').style.display = ''; //habilita a tabela de listagem de criança
                    
                    //COMEÇO DA CRIAÇÃO DA TABELA DAS CRIANÇAS
                    //cria um elemento do tipo TR e salva ele em uma variavel
                    var aniversariantesTr = document.createElement("tr");
                    aniversariantesTr.id = "tdAniversariante" + quantidadeCrianca;

                    //cria elementos do tipo TD e salva eles em uma variavel
                    var aniversarianteTd = document.createElement("td");
                    var removerAniversarianteTd = document.createElement("td");

                    //criando elemento button para remover
                    var removerAniversarianteBotao = document.createElement("button");
                    removerAniversarianteBotao.textContent = "Remover";
                    removerAniversarianteBotao.type = "button";
                    removerAniversarianteBotao.id = "idRemoverAniversarianteBotao";
                    removerAniversarianteBotao.name = "nameRemoverAniversarianteBotao" + quantidadeCrianca;
                    
                    //criando atributo onclick para o botão remover
                    removerAniversarianteBotao.onclick = function (){
                        quantidadeCrianca--; //remove 1 da quantidade de criança
                        
                        //remove o elemento tr da table
                        document.getElementById(aniversariantesTr.id).remove();
                        
                        //remove o input 
                        document.getElementById(inputCrianca.id).remove();
                        
                        //remove da lista de nome a criança removida
                        listaNomeCrianca.splice(listaNomeCrianca.indexOf(nomeCrianca), 1);                                      
                                              
                        //se não ficou nenhuma criança oculta a table
                        if(quantidadeCrianca == 0){
                            document.getElementById('tabelaAniversariante').style.display = 'none';
                            quantidadeCriancaBotaoRemover = 0;
                            quantidadeCrianca2 = 0;
                            textoConfirmacaoCrianca = "";
                            
                            var subTituloEtapa2 = document.querySelector("#subTituloEtapa2");
                            subTituloEtapa2.textContent = "Nenhuma criança selecionada! Por favor, siga para a próxima etapa ou clique no botão 'Recarregar crianças' para selecionar novamente. =) ";        
                        }
                    };
                    
                    //colocando o botão de remover dentro do td de remover
                    removerAniversarianteTd.appendChild(removerAniversarianteBotao);

                    //seta o texto das td com o nome da criança
                    aniversarianteTd.textContent = nomeCrianca;

                    //coloca os TDS criados que estão com os valores do form dentro do TR
                    aniversariantesTr.appendChild(aniversarianteTd);
                    aniversariantesTr.appendChild(removerAniversarianteTd);

                    //pega o elemento table do html através do id e seta nele o TR criado
                    var tabelaTbodyAniversariante = document.querySelector("#tbodyAniversariantes");
                    tabelaTbodyAniversariante.appendChild(aniversariantesTr);
                    //FIM DA CRIAÇÃO DA TABELA DAS CRIANÇAS
                    
                    //COMEÇO DA CRIAÇÃO O INPUT DO CADASTRO DE FESTA
                    //cria um elemento html input
                    var inputCrianca = document.createElement("input");
                    
                    //seta os atributos do input
                    inputCrianca.type = "hidden";
                    inputCrianca.value = idCrianca;
                    inputCrianca.name = "idCrianca"+quantidadeCrianca;
                    inputCrianca.id = "idCrianca"+quantidadeCrianca;
                    
                    //buscando o form de cadastro e setando nele o input criado
                    var formCadastroDeFesta = document.querySelector('#cadastrarFestaForm');
                    formCadastroDeFesta.appendChild(inputCrianca);
                    //FIM DA CRIAÇÃO O INPUT DO CADASTRO DE FESTA
                    
                    //adiciona o nome da criança na lista de nome da criança
                    listaNomeCrianca.push(nomeCrianca);
                   
                }
                               
            }
            
        });
        
        quantidadeCriancaBotaoRemover = quantidadeCrianca;
        
        //se o cliente não tiver criança
        if(quantidadeCrianca < 1){
            
            if(possuiCrianca == 1){
                var subTituloEtapa2 = document.querySelector("#subTituloEtapa2");
                subTituloEtapa2.textContent = "Nenhuma criança selecionada! Por favor, siga para a próxima etapa ou clique no botão 'Recarregar crianças' para selecionar novamente. =)";                        
            }else{
                var subTituloEtapa2 = document.querySelector("#subTituloEtapa2");
                subTituloEtapa2.textContent = "Esse cliente não possui nenhuma criança vinculada ao seu cadastro. Por favor, siga para a próxima etapa ou atualize as informações no cadastro de cliente. =)";        
            }
            
        }else{
            possuiCrianca = 1;
            
            var subTituloEtapa2 = document.querySelector("#subTituloEtapa2");
            subTituloEtapa2.textContent = "Clique em remover caso alguma criança não faça parte do cadastro ! =)";
        }
       
    };
//FIM FUNÇÕES PRESENTES NA ETAPA 1


//FUNÇÕES PRESENTES NA ETAPA 2
    //quando clicar para voltar
    function voltarEtapa1() {

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "1º Etapa - Selecionar Cliente";

        document.getElementById('confirmacaoCliente').style.display = ''; //habilita a confirmação da etapa 1
        document.getElementById('selecionarAniversariantes').style.display = 'none'; //desabilita a etapa 2
        
    };
    
    //caso o usuario clicar em reiniciar selecao
    function restartCrianca() {
        //limpa a listagem atual
        document.getElementById("tbodyAniversariantes").innerHTML="";

        //apaga os inputs
        for(var i=0; i < quantidadeCrianca2; i++){
            var idCrianca = "idCrianca"+(i+1);
            
            var inputCrianca = document.querySelector("#"+idCrianca);
            
            //recebe o input e remove
            if(inputCrianca !== null){   
                document.getElementById(idCrianca).remove();     
            }
        }        
        
        //limpando/zerando as variaveis relacionadas a criança
        quantidadeCrianca = 0;
        quantidadeCriancaBotaoRemover = 0;
        quantidadeCrianca2 = 0;
        textoConfirmacaoCrianca = "";
        listaNomeCrianca = [];     

        //reecria tudo do zero relacionado a criança
        //recebe o controlador com total e todos os aniversariantes e salva em uma variavel 
        var totalCriancas = document.getElementById('totalCriancas').value;
        var listaConcatenadaCrianca = document.getElementById('listaConcatenadaCrianca').value;   

        //pega a lista concatenada das crianças e faz um split e salva o resultado na lista resultado
        var resultado = listaConcatenadaCrianca.split("/");

        //percorre essa lista resultado
        resultado.forEach((valorAtual) => {

            //variaveis 
            var idCrianca = 0;
            var nomeCrianca = "";
            var idClienteCrianca = 0;
            var countResultado = 0;

            //faz novamente um split em cada objeto da lista 
            var resultado2 = valorAtual.split(",");     

            //salva nas variaveis os valores da criança
            resultado2.forEach((valorAtual2) => {
                countResultado++;
                //se é a primeira vez que passa na lista, salva o id
                if (countResultado == 1) {
                    idCrianca = valorAtual2;
                } 
                if (countResultado == 2){
                    nomeCrianca = valorAtual2;
                }
                if(countResultado == 3){
                    idClienteCrianca = valorAtual2;
                }
            });

            //verifica se a criança atual do laço, tem o mesmo idCliente que foi selecionado
            if(idCliente == idClienteCrianca){
                    quantidadeCrianca++;
                    quantidadeCrianca2++;

                    document.getElementById('tabelaAniversariante').style.display = ''; //habilita a tabela de listagem de criança
                    
                    //COMEÇO DA CRIAÇÃO DA TABELA DAS CRIANÇAS
                    //cria um elemento do tipo TR e salva ele em uma variavel
                    var aniversariantesTr = document.createElement("tr");
                    aniversariantesTr.id = "tdAniversariante" + quantidadeCrianca;

                    //cria elementos do tipo TD e salva eles em uma variavel
                    var aniversarianteTd = document.createElement("td");
                    var removerAniversarianteTd = document.createElement("td");

                    //criando elemento button para remover
                    var removerAniversarianteBotao = document.createElement("button");
                    removerAniversarianteBotao.textContent = "Remover";
                    removerAniversarianteBotao.type = "button";
                    removerAniversarianteBotao.id = "idRemoverAniversarianteBotao";
                    removerAniversarianteBotao.name = "nameRemoverAniversarianteBotao" + quantidadeCrianca;
                    
                    //criando atributo onclick para o botão remover
                    removerAniversarianteBotao.onclick = function (){
                        quantidadeCrianca--; //remove 1 da quantidade de criança
                        
                        //remove o elemento tr da table
                        document.getElementById(aniversariantesTr.id).remove();
                        
                        //remove o input 
                        document.getElementById(inputCrianca.id).remove();
                        
                        //remove da lista de nome a criança removida
                        listaNomeCrianca.splice(listaNomeCrianca.indexOf(nomeCrianca), 1);                                      
                                              
                        //se não ficou nenhuma criança oculta a table
                        if(quantidadeCrianca == 0){
                            document.getElementById('tabelaAniversariante').style.display = 'none';
                            quantidadeCriancaBotaoRemover = 0;
                            quantidadeCrianca2 = 0;
                            textoConfirmacaoCrianca = "";
                            
                            var subTituloEtapa2 = document.querySelector("#subTituloEtapa2");
                            subTituloEtapa2.textContent = "Nenhuma criança selecionada! Por favor, siga para a próxima etapa ou clique no botão 'Recarregar crianças' para selecionar novamente. =)";                           
                        }
                    };
                    
                    //colocando o botão de remover dentro do td de remover
                    removerAniversarianteTd.appendChild(removerAniversarianteBotao);

                    //seta o texto das td com o nome da criança
                    aniversarianteTd.textContent = nomeCrianca;

                    //coloca os TDS criados que estão com os valores do form dentro do TR
                    aniversariantesTr.appendChild(aniversarianteTd);
                    aniversariantesTr.appendChild(removerAniversarianteTd);

                    //pega o elemento table do html através do id e seta nele o TR criado
                    var tabelaTbodyAniversariante = document.querySelector("#tbodyAniversariantes");
                    tabelaTbodyAniversariante.appendChild(aniversariantesTr);
                    //FIM DA CRIAÇÃO DA TABELA DAS CRIANÇAS
                    
                    //COMEÇO DA CRIAÇÃO O INPUT DO CADASTRO DE FESTA
                    //cria um elemento html input
                    var inputCrianca = document.createElement("input");
                    
                    //seta os atributos do input
                    inputCrianca.type = "hidden";
                    inputCrianca.value = idCrianca;
                    inputCrianca.name = "idCrianca"+quantidadeCrianca;
                    inputCrianca.id = "idCrianca"+quantidadeCrianca;
                    
                    //buscando o form de cadastro e setando nele o input criado
                    var formCadastroDeFesta = document.querySelector('#cadastrarFestaForm');
                    formCadastroDeFesta.appendChild(inputCrianca);
                    //FIM DA CRIAÇÃO O INPUT DO CADASTRO DE FESTA
                    
                    //adiciona o nome da criança na lista de nome da criança
                    listaNomeCrianca.push(nomeCrianca);                                               
            }
            
        });
        
        quantidadeCriancaBotaoRemover = quantidadeCrianca;
        
        //se o cliente não tiver criança
        if(quantidadeCrianca < 1){
            
            if(possuiCrianca == 1){
                var subTituloEtapa2 = document.querySelector("#subTituloEtapa2");
                subTituloEtapa2.textContent = "Nenhuma criança selecionada! Por favor, siga para a próxima etapa ou clique no botão 'Recarregar crianças' para selecionar novamente. =)";                        
            }else{
                var subTituloEtapa2 = document.querySelector("#subTituloEtapa2");
                subTituloEtapa2.textContent = "Esse cliente não possui nenhuma criança vinculada ao seu cadastro. Por favor, siga para a próxima etapa ou atualize as informações no cadastro de cliente. =)";        
            }
            
        }else{ //se tiver
            possuiCrianca = 1;
            
            var subTituloEtapa2 = document.querySelector("#subTituloEtapa2");
            subTituloEtapa2.textContent = "Clique em remover caso alguma criança não faça parte do cadastro ! =)";        
        }
    };

    //quando clicar em etapa 3
    function etapa3() {
        countListaNomeCrianca = 0; //count de quantas vezes passou na lista de crianças

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "3º Etapa - Selecionar Animadoras/Animadores";

        document.getElementById('selecionarFuncionarios').style.display = ''; //habilita a etapa 3
        document.getElementById('selecionarAniversariantes').style.display = 'none'; //desabilita a etapa 2
        
        //seta a quantidade de criança que foi definida no input de controle "qtdCrianca"
        document.getElementById('qtdCrianca').value = quantidadeCrianca2;
        
        //percorre a lista de nomes das crianças e monta o texto de confirmação para as crianças
        var tamanhoListaNomeCrianca = listaNomeCrianca.length; //recebe o tamanho da lista em uma variavel

        listaNomeCrianca.forEach((valorAtualLista) => {
            if(countListaNomeCrianca == 0){
                textoConfirmacaoCrianca = "Aniversariantes: ";
            }
            countListaNomeCrianca++;
            
            if(countListaNomeCrianca == tamanhoListaNomeCrianca){
                textoConfirmacaoCrianca = textoConfirmacaoCrianca + valorAtualLista;
            }else{
                textoConfirmacaoCrianca = textoConfirmacaoCrianca + valorAtualLista + " / ";
            }
            
        }); 
        countListaNomeCrianca = 0;
        
        if(tamanhoListaNomeCrianca == 0){
            textoConfirmacaoCrianca = "Evento não possui aniversariante.";
        }
        
        //seta o texto informação da crianças na ultima etapa
        var confirmacaoInfCrianca = document.querySelector("#criancasInf");
        confirmacaoInfCrianca.textContent = textoConfirmacaoCrianca;             
      
    };
//FIM FUNÇÕES PRESENTES NA ETAPA 2

//FUNÇÕES PRESENTES NA ETAPA 3
    //quando clicar em etapa 2
    function voltarEtapa2() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "2º Etapa - Selecionar Criança";

        document.getElementById('selecionarFuncionarios').style.display = 'none'; //desabilita a etapa 3
        document.getElementById('selecionarAniversariantes').style.display = ''; //habilita a etapa 2
        
        textoConfirmacaoCrianca = "";
    };

    //quando clicar em etapa 4
    function etapa4() {
        //recebe a quantidade de funcionario selecionado
        var qtdFuncionario = document.getElementById('qtdFuncioanrio').value;
        
        //verifica se tem pelo menos 1 funcionario
        if(qtdFuncionario == 0){
            
            msgTratamentoEtapa3.textContent = "Não foi possível seguir para a 4º Etapa! É obrigatório adicionar no mínimo um animador. =)" 
                   
        }else{
            //recebendo H3 e setando nela o texto com o nome do cliente
            var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
            tituloDaEtapa.textContent = "4º Etapa - Selecionar Pacotes";            
            
            document.getElementById('selecionarPacotes').style.display = ''; //habilita a etapa 4
            document.getElementById('selecionarFuncionarios').style.display = 'none'; //desabilita a etapa 3    
        }
        
    };

    //evento para adicionar funcionario
    btnAddFuncionario.addEventListener("click", function (event) {
        event.preventDefault();
            
            msgTratamentoEtapa3.innerHTML = "";
            
            //toda vez que add, vai somar 1 no count para saber quantos funcionario foram adicionados
            jsCountFuncionario++;
            jsCountFuncionario2++;

            //pega o elemento form inteiro do html
            var form = document.querySelector("#formFuncionario");

            //mapea todos os inputs pelo nome e salva nas variaveis os valores
            var funcionario = form.jsFuncionarios.value;
            var cache = form.jsCache.value;
            var formaDePagamento = form.jsFormaPagamentoFuncionario.value;

            //para os values que são dropsdows e listado dinamicamente
            //cria as variavel
            var idFuncionario = 0;
            var nomeFuncionario = "";
            var countResultado = 0;

            var idFormaDePagamento = 0;
            var nomePagamento = "";
            var countResultado2 = 0;

            //recebe o id + o nome e usa a função split para separar e coloca em uma lista
            resultado = funcionario.split("+");
            resultado2 = formaDePagamento.split("+");

            //percorre essa lista
            resultado.forEach((valorAtual) => {
                countResultado++;
                //se é a primeira vez que passa na lista, pega o id e adiciona na variavel idFuncionario
                if (countResultado == 1) {
                    idFuncionario = valorAtual;
                } else {//se não é , pega o nome e adiciona na variavel atual
                    nomeFuncionario = valorAtual;
                    countResultado = 0;
                }
            });

            resultado2.forEach((valorAtual2) => {
                countResultado2++;
                //se é a primeira vez que passa na lista, pega o id e adiciona na variavel idFormaDePagamento
                if (countResultado2 == 1) {
                    idFormaDePagamento = valorAtual2;
                } else {//se não é , pega o nome e adiciona na variavel atual
                    nomePagamento = valorAtual2;
                    countResultado2 = 0;
                }
            });

            //habilita a div da tabela
            document.getElementById('tabelaFuncionario').style.display = 'block';

            //cria um elemento do tipo TR e salva ele em uma variavel
            var funcionarioTr = document.createElement("tr");
            funcionarioTr.id = "tdFuncionario" + jsCountFuncionario;

            //cria elementos do tipo TD e salva eles em uma variavel
            var funcionarioTd = document.createElement("td");
            var cacheTd = document.createElement("td");
            var formaPagamentoFuncionarioTd = document.createElement("td");
            var removerfuncionarioTd = document.createElement("td");

            //criando elemento button para remover 
            var removerFuncionarioBotao = document.createElement("button");

            removerFuncionarioBotao.textContent = "Remover";
            removerFuncionarioBotao.type = "button";
            removerFuncionarioBotao.id = "idRemoverFuncionarioBotao";
            removerFuncionarioBotao.name = "nameRemoverFuncionarioBotao" + jsCountFuncionario;

            //criando função on clik para remover o funcionario adicionado
            removerFuncionarioBotao.onclick = function () {
                jsCountFuncionario2--; //toda vez que remove diminui

                //remove o tr (coluna)
                document.getElementById(funcionarioTr.id).remove();

                //remove os inputs
                document.getElementById(inputIdFuncionario.id).remove();
                document.getElementById(inputCacheFuncionario.id).remove();
                document.getElementById(inputIdFormaDePagamentoFuncionario.id).remove();
                
                //removendo da lista de funcionarios que forma o texto de confirmação da ultima etapa
                listaFuncionarios.splice(listaFuncionarios.indexOf(nomeFuncionario+"+"+cache), 1);
                
                //remove da lista de valores dos funcionarios
                listaFuncionarioValores.splice(listaFuncionarioValores.indexOf(cache), 1);
                
                //recebe o elemento html que está as inf do funcionario e apaga tudo, pois vai ser montado novamente
                var confirmacaoInfFuncionario = document.querySelector("#funcionarioInf");
                confirmacaoInfFuncionario.innerHTML = "";

                listaFuncionarios.forEach((valorAtualLista) => {
                    countListaFuncionario++;

                    //realiza um split no valor atual
                    var resultado = valorAtualLista.split("+");

                    //variaveis utilizadas para montagem do texto
                    var textoParagrafoFuncionario = "";
                    var countResultadoSplit = 0;

                    //percorre o resultado do split
                    resultado.forEach((valorAtualLista2) => {
                        if(countResultadoSplit == 0){
                            textoParagrafoFuncionario = "Animador ou Animadora: "+valorAtualLista2;
                            countResultadoSplit++;
                        }else{
                            textoParagrafoFuncionario = textoParagrafoFuncionario+"   -   Cache: R$"+valorAtualLista2;
                            countResultadoSplit = 0;
                        }

                    });

                    //cria um elento inpunt <h6>
                    var paragrafoFuncionario = document.createElement("h6");

                    //define os atributos desse elemento
                    paragrafoFuncionario.id = "h6Funcionario"+countListaFuncionario;
                    paragrafoFuncionario.class = "card-title";

                    //define o texto dentro do paragrafo
                    paragrafoFuncionario.textContent = textoParagrafoFuncionario;

                    //seta criado paragrafo na informação dos funcionarios na ultima etapa
                    confirmacaoInfFuncionario.appendChild(paragrafoFuncionario);         

                }); 
                countListaFuncionario = 0;
            
                if (jsCountFuncionario2 == 0) { //se for igual a zero
                    //desabilita a div da tabela
                    document.getElementById('tabelaFuncionario').style.display = 'none';
                    document.getElementById('qtdFuncioanrio').value = jsCountFuncionario2;
                }
            };

            //colocando o botão de remover dentro do td
            removerfuncionarioTd.appendChild(removerFuncionarioBotao);

            //seta o texto das td com os valores das variaveis que receberam os valores dos inputs do form
            funcionarioTd.textContent = nomeFuncionario;
            cacheTd.textContent = cache;
            formaPagamentoFuncionarioTd.textContent = nomePagamento;

            //coloca os TDS criados que estão com os valores do form dentro do TR
            funcionarioTr.appendChild(funcionarioTd);
            funcionarioTr.appendChild(cacheTd);
            funcionarioTr.appendChild(formaPagamentoFuncionarioTd);
            funcionarioTr.appendChild(removerfuncionarioTd);

            //pega o elemento table do html através do id e seta nele o TR criado
            var tabelaTbodyFuncionario = document.querySelector("#tbodyFuncionario");
            tabelaTbodyFuncionario.appendChild(funcionarioTr);

            //MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA O FUNCIONARIO NA ULTIMA ETAPA
            //adiciona na lista o nome + cache do funcionario adicionado
            listaFuncionarios.push(nomeFuncionario+"+"+cache);

            //adiciona da lista de valores dos funcionarios
            listaFuncionarioValores.push(cache);

            //recebe o elemento html que está as inf do funcionario e apaga tudo, pois vai ser montado novamente
            var confirmacaoInfFuncionario = document.querySelector("#funcionarioInf");
            confirmacaoInfFuncionario.innerHTML = "";

            listaFuncionarios.forEach((valorAtualLista) => {
                countListaFuncionario++;

                //realiza um split no valor atual
                var resultado = valorAtualLista.split("+");

                //variaveis utilizadas para montagem do texto
                var textoParagrafoFuncionario = "";
                var countResultadoSplit = 0;

                //percorre o resultado do split
                resultado.forEach((valorAtualLista2) => {
                    if(countResultadoSplit == 0){
                        textoParagrafoFuncionario = "Animador ou Animadora: "+valorAtualLista2;
                        countResultadoSplit++;
                    }else{
                        textoParagrafoFuncionario = textoParagrafoFuncionario+"   -   Cache: R$"+valorAtualLista2;
                        countResultadoSplit = 0;
                    }

                });

                //cria um elento inpunt <h6>
                var paragrafoFuncionario = document.createElement("h6");

                //define os atributos desse elemento
                paragrafoFuncionario.id = "h6Funcionario"+countListaFuncionario;
                paragrafoFuncionario.class = "card-title";

                //define o texto dentro do paragrafo
                paragrafoFuncionario.textContent = textoParagrafoFuncionario;

                //seta criado paragrafo na informação dos funcionarios na ultima etapa
                confirmacaoInfFuncionario.appendChild(paragrafoFuncionario);         

            }); 
            countListaFuncionario = 0;
            //FIM MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA O FUNCIONARIO NA ULTIMA ETAPA

            //COMEÇO DA CRIAÇÃO E DEFINIÇÃO DOS INPUTS
            //cria elemento html input
            var inputIdFuncionario = document.createElement("input"); //idFuncionario
            var inputCacheFuncionario = document.createElement("input"); //cache do funcionario
            var inputIdFormaDePagamentoFuncionario = document.createElement("input"); //fp do funcionario     
            
            //definindo os atributos dos inputs
            //tipo
            inputIdFuncionario.type = "hidden";
            inputCacheFuncionario.type = "hidden";
            inputIdFormaDePagamentoFuncionario.type = "hidden";  
            
            //value
            inputIdFuncionario.value = idFuncionario;
            inputCacheFuncionario.value = cache;
            inputIdFormaDePagamentoFuncionario.value = idFormaDePagamento;        
            
            //name
            inputIdFuncionario.name = "idFuncionario" + jsCountFuncionario;
            inputCacheFuncionario.name = "cacheFuncionario" + jsCountFuncionario;
            inputIdFormaDePagamentoFuncionario.name = "idFormaDePagamentoFuncionario" + jsCountFuncionario;   
            
            //id
            inputIdFuncionario.id = "idFuncionario" + jsCountFuncionario;
            inputCacheFuncionario.id = "cacheFuncionario" + jsCountFuncionario;
            inputIdFormaDePagamentoFuncionario.id = "idFormaDePagamentoFuncionario" + jsCountFuncionario;        

            //buscando o form de cadastro e setando nele o input criado
            var formCadastroDeFesta = document.querySelector('#cadastrarFestaForm');
            formCadastroDeFesta.appendChild(inputIdFuncionario);
            formCadastroDeFesta.appendChild(inputCacheFuncionario);
            formCadastroDeFesta.appendChild(inputIdFormaDePagamentoFuncionario);
            
            //FIM DA CRIAÇÃO E DEFINIÇÃO DOS INPUTS
            
            //define o valor do input qtdFuncionario
            document.getElementById('qtdFuncioanrio').value = jsCountFuncionario;

            //limpa os valores do input
            form.jsFuncionarios.value = "";
            form.jsCache.value = "";
            form.jsFormaPagamentoFuncionario.value = "";

    });    
//FIM FUNÇÕES PRESENTES NA ETAPA 3

//FUNÇÕES PRESENTES NA ETAPA 4
    //se clicar no botão Sim do pacote adicional
    function habilitaPacoteAdicional() {
        document.getElementById('divPacoteAdicional').style.display = 'block';  //habilita a div com id "divPacoteAdicional"
        document.getElementById('temPacoteAdicional').value = 1;
        document.getElementById('pacoteAddInf').style.display = ''; //habilita o texto de confirmação da ultima etapa
    }; 

    //se clicar no botão Não do pacote adicional
    function desabilitaPacoteAdicional() {             
        document.getElementById('divPacoteAdicional').style.display = 'none';  //desabilita a div com id "divPacoteAdicional"                 
        document.getElementById('temPacoteAdicional').value = 0;
        document.getElementById('pacoteAddInf').style.display = 'none'; //desabilita o texto de confirmação da ultima etapa
    }; 
    
    //quando clicar para voltar etapa 3
    function voltarEtapa3() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "3º Etapa - Selecionar Animadoras/Animadores";

        document.getElementById('selecionarPacotes').style.display = 'none'; //desabilita a etapa 4
        document.getElementById('selecionarFuncionarios').style.display = ''; //habilita a etapa 3
    };

    //quando clicar em etapa 5
    function etapa5() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "5º Etapa - Valores Adicionais";
    
        document.getElementById('inserirValorAdicional').style.display = ''; //habilita a etapa 5
        document.getElementById('selecionarPacotes').style.display = 'none'; //desabilita a etapa 4
        
        //recebe
        var pacoteSelecionado = document.getElementById('jsPacote').value;
        
        //recebe a string de pacote selecionado e faz um split e salva em uma lista
        resultado = pacoteSelecionado.split("+");

        //variavel utilizada para percorrer a lista
        var countResultado = 0;
        var idPacoteSelecionado = 0; 
         
        //percorre essa lista
        resultado.forEach((valorAtual) => {
            countResultado++;
             
            //se é a primeira vez que passa na lista, pega o valorAtual e adiciona na variavel idPacoteSelecionado
            if (countResultado == 1) {
                idPacoteSelecionado = valorAtual;
            }
            //se é a segunda vez que passa na lista, pega o valorAtual e adiciona na variavel nomePacote
            if (countResultado == 2) {
                nomePacote = valorAtual;
            }
            //se é a terceira vez que passa na lista, pega o valorAtual e adiciona na variavel valorPacote
            if (countResultado == 3) {
                valorPacote = valorAtual;
                countResultado = 0;
            }

        });       
        
        //define o texto informação do pacote na ultima etapa
        var confirmacaoInfPacote = document.querySelector("#pacoteInf");
        confirmacaoInfPacote.textContent = "Pacote: "+nomePacote+" - Valor: R$"+valorPacote;          
        
        //SETA O ID DO PACOTE NO INPUT DO CADASTRO DE FESTA
        document.getElementById('idPacoteF').value = idPacoteSelecionado;

    };

    //evento para adicionar pacote adicional
    btnAddPacotesAdicionais.addEventListener("click", function (event) {
        event.preventDefault();

            //toda vez que add, vai somar 1 no count para saber quantos pacotes adicionais foram adicionados
            jsCountPacotesAdicionais++;
            jsCountPacotesAdicionais2++;

            //pega o elemento form inteiro do html
            var form = document.querySelector("#formPacoteAdicional");

            //mapea todos os inputs pelo nome e salva nas variaveis os valores
            var pacoteAdicional = form.jsPacotesAdicionais.value;
            var valorPacoteAdicional = form.jsValorPacoteAdicional.value;

            //para os values que são dropsdows e listado dinamicamente
            //cria as variavel
            var idTipoPacoteAdicional = 0;
            var descricaoPacoteAdd = "";
            var countResultado = 0;

            //recebe o id + o nome e usa a função split para separar e coloca em uma lista
            resultado = pacoteAdicional.split("+");

            //percorre essa lista
            resultado.forEach((valorAtual) => {
                countResultado++;
                //se é a primeira vez que passa na lista, pega o id e adiciona na variavel idFuncionario
                if (countResultado == 1) {
                    idTipoPacoteAdicional = valorAtual;
                } else {//se não é , pega o nome e adiciona na variavel atual
                    descricaoPacoteAdd = valorAtual;
                    countResultado = 0;
                }
            });

            //habilita a div da tabela
            document.getElementById('tabelaPacoteAdicional').style.display = 'block';

            //cria um elemento do tipo TR e salva ele em uma variavel
            var pacotesAdicionaisTr = document.createElement("tr");
            pacotesAdicionaisTr.id = "tdPacotesAdicionais" + jsCountPacotesAdicionais;

            //cria elementos do tipo TD e salva eles em uma variavel
            var pacoteAdicionaisTd = document.createElement("td");
            var valorPacoteAdicionalTd = document.createElement("td");
            var removerPacotesAdicionaisTd = document.createElement("td");

            //criando elemento button para remover
            var removerPacotesAdicionaisBotao = document.createElement("button");

            removerPacotesAdicionaisBotao.textContent = "Remover";
            removerPacotesAdicionaisBotao.type = "button";
            removerPacotesAdicionaisBotao.id = "idRemoverPacotesAdicionaisBotao";
            removerPacotesAdicionaisBotao.name = "nameRemoverPacotesAdicionaisBotao" + jsCountPacotesAdicionais;

            //criando função on clik para remover o pacote adicional adicionado
            removerPacotesAdicionaisBotao.onclick = function () {
                jsCountPacotesAdicionais2--; //toda vez que remove diminui

                //pega o id da tr e remove
                document.getElementById(pacotesAdicionaisTr.id).remove();

                //pega os controladores da despesa e remove tbm
                document.getElementById(inputIdPacoteAdicional.id).remove();
                document.getElementById(inputValorPacoteAdicional.id).remove();

                //removendo da lista de pacotes add que forma o texto de confirmação da ultima etapa
                listaPacotesAdicionais.splice(listaPacotesAdicionais.indexOf(descricaoPacoteAdd+"+"+valorPacoteAdicional), 1);
                
                //remove da lista de valores 
                listaPacoteAddValores.splice(listaPacoteAddValores.indexOf(valorPacoteAdicional), 1);
                
                //recebe o elemento html que está as inf dos pacotes e apaga tudo, pois vai ser montado novamente
                var confirmacaoInfPacoteAdd = document.querySelector("#pacoteAddInf");
                confirmacaoInfPacoteAdd.innerHTML = "";

                listaPacotesAdicionais.forEach((valorAtualLista) => { 
                    countPacotesAdicionais++;

                    //realiza um split no valor atual
                    var resultado = valorAtualLista.split("+");        
                                    
                    //variaveis utilizadas para montagem do texto
                    var textoParagrafoPacoteAdd = "";
                    var countResultadoSplit = 0;        

                    //percorre o resultado do split
                    resultado.forEach((valorAtualLista2) => {
                        if(countResultadoSplit == 0){
                            textoParagrafoPacoteAdd = "Pacote adicional : "+valorAtualLista2;
                            countResultadoSplit++;
                        }else{
                            textoParagrafoPacoteAdd = textoParagrafoPacoteAdd+"   -   Valor: R$"+valorAtualLista2;
                            countResultadoSplit = 0;
                        }

                    });

                    //cria um elento inpunt <h6>
                    var paragrafoPacoteAdd = document.createElement("h6");

                    //define os atributos desse elemento
                    paragrafoPacoteAdd.id = "h6PacoteAdd"+countPacotesAdicionais;
                    paragrafoPacoteAdd.class = "card-title";

                    //define o texto dentro do paragrafo
                    paragrafoPacoteAdd.textContent = textoParagrafoPacoteAdd;

                    //seta criado paragrafo na informação dos funcionarios na ultima etapa
                    confirmacaoInfPacoteAdd.appendChild(paragrafoPacoteAdd);                

                });
                countPacotesAdicionais = 0;
                if (jsCountPacotesAdicionais2 == 0) { //se for igual a zero
                    //desabilita a div da tabela
                    document.getElementById('tabelaPacoteAdicional').style.display = 'none';
                    document.getElementById('qtdPacoteAdicional').value = 0;
                    document.getElementById('temPacoteAdicional').value = 0;
                }
            };

            //colocando o botão de remover dentro do td
            removerPacotesAdicionaisTd.appendChild(removerPacotesAdicionaisBotao);

            //seta o texto das td com os valores das variaveis que receberam os valores dos inputs do form
            pacoteAdicionaisTd.textContent = descricaoPacoteAdd;
            valorPacoteAdicionalTd.textContent = valorPacoteAdicional;

            //coloca os TDS criados que estão com os valores do form dentro do TR
            pacotesAdicionaisTr.appendChild(pacoteAdicionaisTd);
            pacotesAdicionaisTr.appendChild(valorPacoteAdicionalTd);
            pacotesAdicionaisTr.appendChild(removerPacotesAdicionaisTd);

            //pega o elemento table do html através do id e seta nele o TR criado
            var tabelaTbodyPacoteAdicionais = document.querySelector("#tbodyPacoteAdicional");
            tabelaTbodyPacoteAdicionais.appendChild(pacotesAdicionaisTr);

            //MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA OS PACOTES ADD NA ULTIMA ETAPA
        
            //adiciona na lista o nome + valor do pacote add adicionado
            listaPacotesAdicionais.push(descricaoPacoteAdd+"+"+valorPacoteAdicional);
            
            //adiciona na lista de valores
            listaPacoteAddValores.push(+valorPacoteAdicional);

            //recebe o elemento html que está as inf dos pacotes e apaga tudo, pois vai ser montado novamente
            var confirmacaoInfPacoteAdd = document.querySelector("#pacoteAddInf");
            confirmacaoInfPacoteAdd.innerHTML = "";

            listaPacotesAdicionais.forEach((valorAtualLista) => { 
                countPacotesAdicionais++;
            
                //realiza um split no valor atual
                var resultado = valorAtualLista.split("+");        
            
                //variaveis utilizadas para montagem do texto
                var textoParagrafoPacoteAdd = "";
                var countResultadoSplit = 0;        
            
                //percorre o resultado do split
                resultado.forEach((valorAtualLista2) => {
                    if(countResultadoSplit == 0){
                        textoParagrafoPacoteAdd = "Pacote adicional : "+valorAtualLista2;
                        countResultadoSplit++;
                    }else{
                        textoParagrafoPacoteAdd = textoParagrafoPacoteAdd+"   -   Valor: R$"+valorAtualLista2;
                        countResultadoSplit = 0;
                    }
                    
                });
            
                //cria um elento inpunt <h6>
                var paragrafoPacoteAdd = document.createElement("h6");
                
                //define os atributos desse elemento
                paragrafoPacoteAdd.id = "h6PacoteAdd"+countPacotesAdicionais;
                paragrafoPacoteAdd.class = "card-title";
                
                //define o texto dentro do paragrafo
                paragrafoPacoteAdd.textContent = textoParagrafoPacoteAdd;
                
                //seta criado paragrafo na informação dos funcionarios na ultima etapa
                confirmacaoInfPacoteAdd.appendChild(paragrafoPacoteAdd);                
            
            });
            countPacotesAdicionais = 0;
            //FIM MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA OS PACOTES ADD NA ULTIMA ETAPA
            
            //COMEÇO DA CRIAÇÃO E DEFINIÇÃO DOS INPUTS
            
            //cria os inputs
            var inputIdPacoteAdicional = document.createElement("input");
            var inputValorPacoteAdicional = document.createElement("input");     
            
            //define seus atributos
            //tipo
            inputIdPacoteAdicional.type = "hidden";
            inputValorPacoteAdicional.type = "hidden";
            //valor
            inputIdPacoteAdicional.value = idTipoPacoteAdicional;
            inputValorPacoteAdicional.value = valorPacoteAdicional;
            //nome
            inputIdPacoteAdicional.name = "idPacoteAdicional" + jsCountPacotesAdicionais;
            inputValorPacoteAdicional.name = "valorPacoteAdicional" + jsCountPacotesAdicionais;
            //id
            inputIdPacoteAdicional.id = "idPacoteAdicional" + jsCountPacotesAdicionais;
            inputValorPacoteAdicional.id = "valorPacoteAdicional" + jsCountPacotesAdicionais;

            //buscando o form de cadastro e setando nele os inputs criados
            formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
            formCadastrarFesta.appendChild(inputIdPacoteAdicional);
            formCadastrarFesta.appendChild(inputValorPacoteAdicional);
            
            //FIM DA CRIAÇÃO E DEFINIÇÃO DOS INPUTS

            //define o valor do input qtdPacoteAdicional e seta como verdadeiro temPacoteAdicional
            document.getElementById('qtdPacoteAdicional').value = jsCountPacotesAdicionais;
            document.getElementById('temPacoteAdicional').value = 1;
            
            //limpa os valores do input
            form.jsPacotesAdicionais.value = "";
            form.jsValorPacoteAdicional.value = "";

    }); 
//FIM FUNÇÕES PRESENTES NA ETAPA 4

//FUNÇÕES PRESENTES NA ETAPA 5
    //quando clicar para voltar etapa 4
    function voltarEtapa4() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "4º Etapa - Selecionar Pacotes";

        document.getElementById('selecionarPacotes').style.display = ''; //habilita a etapa 4
        document.getElementById('inserirValorAdicional').style.display = 'none'; //desabilita a etapa 5
    };

    //quando clicar em etapa 6
    function etapa6() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "6º Etapa - Despesas da Festa";
    
        document.getElementById('inserirDespesas').style.display = ''; //habilita a etapa 6
        document.getElementById('inserirValorAdicional').style.display = 'none'; //desabilita a etapa 5
        
        var qtdValorAdicional = document.getElementById('qtdValorAdicional').value;
        
        if(qtdValorAdicional == 0){
            //recebe o elemento html que está as inf dos valores adicionais e apaga tudo, pois vai ser montado novamente
            var confirmacaoInfValoresAdicionais = document.querySelector("#valoresAddInf");
            confirmacaoInfValoresAdicionais.innerHTML = "";
            
            //cria um elento inpunt <h6>
            var paragrafoValorAdicional = document.createElement("h6");

            //define os atributos desse elemento
            paragrafoValorAdicional.class = "card-title";

            //define o texto dentro do paragrafo
            paragrafoValorAdicional.textContent = "Evento não possui valores adicionais.";

            //adicona o <p> criado na informação dos valores adicionais na ultima etapa
            confirmacaoInfValoresAdicionais.appendChild(paragrafoValorAdicional);
        }
    };

    //evento para adicionar valor adicional
    btnAddValorAdicional.addEventListener("click", function (event) {
        event.preventDefault();
            //toda vez que add, vai somar 1 no count para saber quantos valores adicionais foram adicionados
            jsCountValorAdicional++;
            jsCountValorAdicional2++;

            //pega o elemento form inteiro do html
            var form = document.querySelector("#formValorAdicional");

            //mapea todos os inputs pelo nome e salva nas variaveis os valores
            var valorAdicional = form.jsValorAdicional.value;
            var descricaoValorAdicional = form.jsDescricaoValorAdicional.value;

            //habilita a div da tabela
            document.getElementById('tabelaValorAdicional').style.display = 'block';

            //cria um elemento do tipo TR e salva ele em uma variavel
            var valorAdicionalTr = document.createElement("tr");
            valorAdicionalTr.id = "tdValorAdicional" + jsCountValorAdicional;

            //cria elementos do tipo TD e salva eles em uma variavel
            var valorAdicionalTd = document.createElement("td");
            var descricaoValorAdicionalTd = document.createElement("td");
            var removerValorAdicionalBotaoTd = document.createElement("td");

            //criando elemento button para remover e colocando ele no td "removerDespesaTd"
            var removerValorAdicionalBotao = document.createElement("button");

            removerValorAdicionalBotao.textContent = "Remover";
            removerValorAdicionalBotao.type = "button";
            removerValorAdicionalBotao.id = "idRemoverValorAdicionalBotao";
            removerValorAdicionalBotao.name = "nameRemoverValorAdicionalBotao" + jsCountValorAdicional;

            //criando função on clik para remover o valor adicional adicionado
            removerValorAdicionalBotao.onclick = function () {
                jsCountValorAdicional2--; //toda vez que remove diminui

                //pega o id da tr e remove
                document.getElementById(valorAdicionalTr.id).remove();

                //pega os controladores da despesa e remove tbm
                document.getElementById(inputValorAdicional.id).remove();
                document.getElementById(inputDescricaoValorAdicional.id).remove();

                //removendo da lista de valores adicionais que forma o texto de confirmação da ultima etapa
                listaValoresAdicionais.splice(listaValoresAdicionais.indexOf(valorAdicional+"+"+descricaoValorAdicional), 1);

                //remove da lista de valores
                listaValoresAddValores.splice(listaValoresAddValores.indexOf(valorAdicional), 1);

                //recebe o elemento html que está as inf dos valores adicionais e apaga tudo, pois vai ser montado novamente
                var confirmacaoInfValoresAdicionais = document.querySelector("#valoresAddInf");
                confirmacaoInfValoresAdicionais.innerHTML = "";

                //percorre a lista e monta o texto de confirmação da ultima etapa
                listaValoresAdicionais.forEach((valorAtualLista) => {
                    countValoresAdicionais++;

                    //realiza um split no valor atual e salva na variavel resultado
                    var resultado = valorAtualLista.split("+");  

                    //variaveis utilizadas para montagem do texto
                    var textoParagrafoValoresAdd = "";
                    var countResultadoSplit = 0; 

                    //percorre o resultado do split
                    resultado.forEach((valorAtualLista2) => {
                        if(countResultadoSplit == 0){
                            textoParagrafoValoresAdd = "Valor adicional: R$"+valorAtualLista2;
                            countResultadoSplit++;
                        }else{
                            textoParagrafoValoresAdd = textoParagrafoValoresAdd+"   -   Descrição: "+valorAtualLista2;
                            countResultadoSplit = 0;
                        } 
                    });

                    //cria um elento inpunt <h6>
                    var paragrafoValorAdicional = document.createElement("h6");

                    //define os atributos desse elemento
                    paragrafoValorAdicional.id = "h6ValorAdd"+countValoresAdicionais;
                    paragrafoValorAdicional.class = "card-title";

                    //define o texto dentro do paragrafo
                    paragrafoValorAdicional.textContent = textoParagrafoValoresAdd;

                    //adicona o <p> criado na informação dos valores adicionais na ultima etapa
                    confirmacaoInfValoresAdicionais.appendChild(paragrafoValorAdicional);                 

                });
                countValoresAdicionais = 0;

                if (jsCountValorAdicional2 == 0) { //se for igual a zero
                    //desabilita a div da tabela
                    document.getElementById('tabelaValorAdicional').style.display = 'none';
                    document.getElementById('qtdValorAdicional').value = 0;
                }
            };

            //colocando o botão de remover dentro do td
            removerValorAdicionalBotaoTd.appendChild(removerValorAdicionalBotao);

            //seta o texto das td com os valores das variaveis que receberam os valores dos inputs do form
            valorAdicionalTd.textContent = valorAdicional;
            descricaoValorAdicionalTd.textContent = descricaoValorAdicional;

            //coloca os TDS criados que estão com os valores do form dentro do TR
            valorAdicionalTr.appendChild(valorAdicionalTd);
            valorAdicionalTr.appendChild(descricaoValorAdicionalTd);
            valorAdicionalTr.appendChild(removerValorAdicionalBotaoTd);

            //pega o elemento table do html através do id e seta nele o TR criado
            var tabelaTbodyValorAdicional = document.querySelector("#tbodyValorAdicional");
            tabelaTbodyValorAdicional.appendChild(valorAdicionalTr);

            //MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA O VALOR ADICIONAL NA ULTIMA ETAPAS
            //adiciona na lista o valor + descrição do valor adiconal adicionado
            listaValoresAdicionais.push(valorAdicional+"+"+descricaoValorAdicional);
            
            //adiciona na lista de valores
            listaValoresAddValores.push(valorAdicional);

            //recebe o elemento html que está as inf dos valores adicionais e apaga tudo, pois vai ser montado novamente
            var confirmacaoInfValoresAdicionais = document.querySelector("#valoresAddInf");
            confirmacaoInfValoresAdicionais.innerHTML = "";
        
            //percorre a lista e monta o texto de confirmação da ultima etapa
            listaValoresAdicionais.forEach((valorAtualLista) => {
                countValoresAdicionais++;
                
                //realiza um split no valor atual e salva na variavel resultado
                var resultado = valorAtualLista.split("+");  
                
                //variaveis utilizadas para montagem do texto
                var textoParagrafoValoresAdd = "";
                var countResultadoSplit = 0; 
                
                //percorre o resultado do split
                resultado.forEach((valorAtualLista2) => {
                    if(countResultadoSplit == 0){
                        textoParagrafoValoresAdd = "Valor adicional: R$"+valorAtualLista2;
                        countResultadoSplit++;
                    }else{
                        textoParagrafoValoresAdd = textoParagrafoValoresAdd+"   -   Descrição: "+valorAtualLista2;
                        countResultadoSplit = 0;
                    } 
                });

                //cria um elento inpunt <h6>
                var paragrafoValorAdicional = document.createElement("h6");
        
                //define os atributos desse elemento
                paragrafoValorAdicional.id = "h6ValorAdd"+countValoresAdicionais;
                paragrafoValorAdicional.class = "card-title";
                
                //define o texto dentro do paragrafo
                paragrafoValorAdicional.textContent = textoParagrafoValoresAdd;
                
                //adicona o <p> criado na informação dos valores adicionais na ultima etapa
                confirmacaoInfValoresAdicionais.appendChild(paragrafoValorAdicional);                 
                
            });
            countValoresAdicionais = 0;
            // FIM MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA O VALOR ADICIONAL NA ULTIMA ETAPA
            
            //COMEÇO CRIAÇÃO DOS INPUTS
            //cria os elementos html input
            var inputValorAdicional = document.createElement("input");
            var inputDescricaoValorAdicional = document.createElement("input");
            
            //define seus atributos
            //tipo
            inputValorAdicional.type = "hidden";
            inputDescricaoValorAdicional.type = "hidden";
            
            //valor
            inputValorAdicional.value = valorAdicional;
            inputDescricaoValorAdicional.value = descricaoValorAdicional;
            
            //nome
            inputValorAdicional.name = "valorAdicional" + jsCountValorAdicional;
            inputDescricaoValorAdicional.name = "descricaoValorAdicional" + jsCountValorAdicional;
            
            //id
            inputValorAdicional.id = "valorAdicional" + jsCountValorAdicional;
            inputDescricaoValorAdicional.id = "descricaoValorAdicional" + jsCountValorAdicional;

            //buscando o form de cadastro e setando nele os inputs criados
            formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
            formCadastrarFesta.appendChild(inputValorAdicional);
            formCadastrarFesta.appendChild(inputDescricaoValorAdicional);
            //FIM DA CRIAÇÃO DOS INPUTS

            //define o valor do input qtdFuncionario
            document.getElementById('qtdValorAdicional').value = jsCountValorAdicional;        
            
            //limpa os valores do input
            form.jsValorAdicional.value = "";
            form.jsDescricaoValorAdicional.value = "";
    });
//FIM FUNÇÕES PRESENTES NA ETAPA 5

//FUNÇÕES PRESENTES NA ETAPA 6
    //quando clicar no botão tipo despesa
    function tipoDespesa() {  
        document.getElementById('jsDescricaoDespesa').style.display = 'none';  //desabilita o input com id "jsDescricaoDespesa"                 
        document.getElementById('jsTipoDespesa').style.display = '';  //habilita o input com id "jsTipoDespesa"                    

    }; 

    //quando clicar no botão descricao manual
    function descricaoManual() { 
        document.getElementById('jsDescricaoDespesa').style.display = '';  //habilita o input com id "jsDescricaoDespesa"                  
        document.getElementById('jsTipoDespesa').style.display = 'none';  //desabilita o input com id "jsTipoDespesa"           

    }; 
    
    //quando clicar para voltar etapa 5
    function voltarEtapa5() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "5º Etapa - Valores Adicionais";

        document.getElementById('inserirValorAdicional').style.display = ''; //habilita a etapa 5
        document.getElementById('inserirDespesas').style.display = 'none'; //desabilita a etapa 6
    };

    //quando clicar em etapa 7
    function etapa7() {
        //recebe a qtd de despesa em uma variavel
        var qtdDespesa = document.getElementById('qtdDespesa').value; //habilita a etapa 7
        
        //verifica se adicionou pelo menos 1 despesa
        if(qtdDespesa == 0){
            msgTratamentoEtapa6.textContent = "Não foi possível seguir para a 7º Etapa! É obrigatório adicionar no mínimo uma despesa. =)";
        }else{   
                        
            //COMEÇO DO CALCULO DOS VALORES
            //VALOR TOTAL FESTA            
            //calcula o valor total dos pacotes adicionais
            var valorPacotesAdd = 0;
            listaPacoteAddValores.forEach((valorAtual) => {
                valorPacotesAdd = parseFloat(valorPacotesAdd) + parseFloat(valorAtual);
            });
                 
            //calcula o valor total dos valores adicionais
            var valorValoresAdicionais = 0;
            listaValoresAddValores.forEach((valorAtual) => {
                valorValoresAdicionais = parseFloat(valorValoresAdicionais) + parseFloat(valorAtual);
            });            
            
            //resultado = pacotes adicionais + valores adicionais + pacote
            valorTotalFesta = parseFloat(valorPacotesAdd) + parseFloat(valorValoresAdicionais) + parseFloat(valorPacote);

            //VALOR TOTAL DESPESA          
            //calcula o valor de despesa de funcionario
            var valorTotalPagamentoFunc = 0;
            listaFuncionarioValores.forEach((valorAtual) => {
                valorTotalPagamentoFunc = parseFloat(valorTotalPagamentoFunc) + parseFloat(valorAtual);
            }); 
            
            //calcula o valor de despesa das despesas
            var valorTotalDespesa = 0;
            listaValoresDespesa.forEach((valorAtual) => {
                valorTotalDespesa = parseFloat(valorTotalDespesa) + parseFloat(valorAtual);
            });             
            
            //resultado = funcionario + despesas
            valorTotalDespesa = parseFloat(valorTotalPagamentoFunc) + parseFloat(valorTotalDespesa);
            
            //LUCRO
            //resultado = valor total - valor total despesa
            valorLucro = parseFloat(valorTotalFesta) - parseFloat(valorTotalDespesa);
            
            //arredonda os valores para 2 casas depois da virgula
            valorTotalFesta = parseFloat(valorTotalFesta.toFixed(2));
            valorTotalDespesa = parseFloat(valorTotalDespesa.toFixed(2));
            valorLucro = parseFloat(valorLucro.toFixed(2));
            
            //salva o valorTotalFesta em uma variavel auxiliar utilizada na próxima etapa
            if(countPrimeiraVezAdd == 0){
                valorTotalFestaLocal = valorTotalFesta;                
                valorTotalFestaLocalAnterior = valorTotalFesta;                
            }else{
               //subtrai do valor total anterior oque sobrou do valor total festa
               valorTotalFestaLocalAnterior = valorTotalFestaLocalAnterior - valorTotalFestaLocal;
               
               //define o novo valor total local, subtraindo o valor total festa - valor anterior
               valorTotalFestaLocal = valorTotalFesta - valorTotalFestaLocalAnterior;
               
               valorTotalFestaLocalAnterior = valorTotalFesta;
            }
            //FIM DO CALCULO DOS VALORES 
            
            //DEFINIÇÃO DO TEXTO DA PRÓXIMA ETAPA
            //valor total
            var valorTotalProximaEtapa = document.querySelector("#valorTotal");
            valorTotalProximaEtapa.textContent = "Valor Total: R$"+valorTotalFesta;  
            
            //valor total despesa
            var valorTotalDespesaProximaEtapa = document.querySelector("#totalDespesas");
            valorTotalDespesaProximaEtapa.textContent = "Total de despesas: R$"+valorTotalDespesa;  
            
            //valor lucro
            var valorLucroProximaEtapa = document.querySelector("#lucro");
            valorLucroProximaEtapa.textContent = "Lucro do Evento: R$"+valorLucro;  
            //FIM DA DEFINIÇÃO DO TEXTO DA PRÓXIMA ETAPA
            
            //DEFINIÇÃO DO TEXTO PARA A ULTIMA ETAPA (CONFIRMAÇÃO)
            //recebe o elemento html da ultima etapa (confirmação) e salva em uma variavel 
            var confirmacaoInfValoresFinais = document.querySelector("#valoresFinalInf");
            confirmacaoInfValoresFinais.innerHTML = ""; //limpa seu conteudo
            
            //zera a varivel porque vai apagar o h6
            criouPegarContratante = 0;
            
            //cria os elementos <h6> para todos os valores
            var paragrafoValorTotal = document.createElement("h6");
            var paragrafoValorTotalDespesa = document.createElement("h6");
            var paragrafoValorLucro = document.createElement("h6");

            //define o atributo
            paragrafoValorTotal.class = "card-title";     
            paragrafoValorTotalDespesa.class = "card-title"; 
            paragrafoValorLucro.class = "card-title";     
            
            //define o texto
            paragrafoValorTotal.textContent = "Valor Total: R$"+valorTotalFesta;    
            paragrafoValorTotalDespesa.textContent = "Total de despesas: R$"+valorTotalDespesa;  
            paragrafoValorLucro.textContent = "Lucro do Evento: R$"+valorLucro;  
            
            //coloca os <p> criados dentro do elemento html da etapa de confirmação
            confirmacaoInfValoresFinais.appendChild(paragrafoValorTotal);
            confirmacaoInfValoresFinais.appendChild(paragrafoValorTotalDespesa);
            confirmacaoInfValoresFinais.appendChild(paragrafoValorLucro);
            //FIM DEFINIÇÃO DO TEXTO PARA A ULTIMA ETAPA (CONFIRMAÇÃO)
            
            //DEFINIÇÃO DOS VALORES DO INPUTS DO CADASTRO DE FESTA
            document.getElementById('valorTotalFesta').value = valorTotalFesta;
            document.getElementById('valorTotalDespesa').value = valorTotalDespesa;
            document.getElementById('valorTotalLucro').value = valorLucro;
            //FIM DEFINIÇÃO DOS VALORES DO INPUTS DO CADASTRO DE FESTA
          
            //recebendo H3 e setando nela o texto com o nome do cliente
            var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
            tituloDaEtapa.textContent = "7º Etapa - Valores e Forma de Pagamento";
            
            document.getElementById('valoresEformaPagamento').style.display = ''; //habilita a etapa 7
            document.getElementById('inserirDespesas').style.display = 'none'; //desabilita a etapa 6
        }
        
    };

    //evento para adiconar despesa
    btnAddDespesa.addEventListener("click", function (event) {
        event.preventDefault();
            
            msgTratamentoEtapa6.innerHTML = "";
            
            //toda vez que add, vai somar 1 no count para saber quantos despesas foram adicionados
            jsCountDespesa++;
            jsCountDespesa2++;

            //pega o elemento form inteiro do html
            var form = document.querySelector("#formAddDespesaFesta");

            //mapea todos os inputs pelo nome e salva nas variaveis os valores
            var descricaoDespesa = form.jsDescricaoDespesa.value;
            var tipoDespesa = form.jsTipoDespesa.value;
            var valorDespesa = form.jsValorDepesa.value;
            var formaDePagamento = form.jsFormaPagamentoDespesa.value;
            var despesaPaga = form.jsDespesaPaga.value;

            if (descricaoDespesa === "") {
                //para os values que são dropsdows e listado dinamicamente
                //cria as variavel
                var idTipoDespesa = 0;
                var nomeDespesa = "";
                var countResultado = 0;

                //recebe o id + o nome e usa a função split para separar e coloca em uma lista
                resultado = tipoDespesa.split("+");

                //percorre essa lista
                resultado.forEach((valorAtual) => {
                    countResultado++;
                    //se é a primeira vez que passa na lista, pega o id e adiciona na variavel idTipoDespesa
                    if (countResultado == 1) {
                        idTipoDespesa = valorAtual;
                    } else {//se não é , pega o nome e adiciona na variavel atual
                        nomeDespesa = valorAtual;
                        countResultado = 0;
                    }
                });
            }

            //para os values que são dropsdows e listado dinamicamente
            //cria as variavel
            var idFormaDePagamento = 0;
            var nomePagamento = "";
            var countResultado2 = 0;

            //recebe o id + o nome e usa a função split para separar e coloca em uma lista
            resultado2 = formaDePagamento.split("+");

            //percorre essa lista
            resultado2.forEach((valorAtual2) => {
                countResultado2++;
                //se é a primeira vez que passa na lista, pega o id e adiciona na variavel idFormaDePagamento
                if (countResultado2 == 1) {
                    idFormaDePagamento = valorAtual2;
                } else {//se não é , pega o nome e adiciona na variavel atual
                    nomePagamento = valorAtual2;
                    countResultado2 = 0;
                }
            });

            //habilita a div da tabela
            document.getElementById('tabelaDespesas').style.display = 'block';

            //cria um elemento do tipo TR e salva ele em uma variavel
            var despesaTr = document.createElement("tr");
            despesaTr.id = "trDespesa" + jsCountDespesa;

            //cria elementos do tipo TD e salva eles em uma variavel
            var despesaTd = document.createElement("td");
            var valorDespesaTd = document.createElement("td");
            var formaPagamentoDespesaTd = document.createElement("td");
            var despesaPagaTd = document.createElement("td");
            var removerDespesaTd = document.createElement("td");

            //criando elemento button para remover
            var removerDespesaBotao = document.createElement("button");

            removerDespesaBotao.textContent = "Remover";
            removerDespesaBotao.type = "button";
            removerDespesaBotao.id = "idRemoverDespesaBotao";
            removerDespesaBotao.name = "nameRemoverDespesaBotao" + jsCountDespesa;

            //criando função on clik para remover o aniversariante adicionado
            removerDespesaBotao.onclick = function () {
                jsCountDespesa2--; //toda vez que remove diminui

                //pega o id da tr e remove
                document.getElementById(despesaTr.id).remove();

                //pega os controladores da despesa e remove tbm
                if (descricaoDespesa !== "") {
                    document.getElementById(inputDescricaoDespesa.id).remove();
                } else {
                    document.getElementById(inputIdTipoDespesa.id).remove();
                }
                document.getElementById(inputValorDespesa.id).remove();
                document.getElementById(inputFormaDePagamentoDespesa.id).remove();            
                document.getElementById(inputDespesaPaga.id).remove();
                document.getElementById(inputManualOuTipoDespesa.id).remove();

                //removendo da lista de despesa que forma o texto de confirmação da ultima etapa
                if(descricaoDespesa !== ""){
                    listaDespesas.splice(listaDespesas.indexOf(descricaoDespesa+"+"+valorDespesa+"+"+nomePagamento+"+"+despesaPaga), 1);            
                }else{
                    listaDespesas.splice(listaDespesas.indexOf(nomeDespesa+"+"+valorDespesa+"+"+nomePagamento+"+"+despesaPaga), 1);             
                }
                
                //remove da lista de valores da despesa
                listaValoresDespesa.splice(listaValoresDespesa.indexOf(valorDespesa), 1);

                //recebe o elemento html que está as inf das despesas e apaga tudo, pois vai ser montado novamente
                var confirmacaoInfDespesas = document.querySelector("#despesasInf");
                confirmacaoInfDespesas.innerHTML = "";        

                listaDespesas.forEach((valorAtualLista) => {
                countDespesas++; 

                    //realiza um split no valor atual e salva na variavel resultado
                    var resultado = valorAtualLista.split("+");

                    //variaveis utilizadas para montagem do texto
                    var textoParagrafoDespesa = "";
                    var countResultadoSplit = 0; 

                    //percorre o resultado do split
                    resultado.forEach((valorAtualLista2) => {

                        switch(countResultadoSplit) {

                        case 0:
                            if(descricaoDespesa !== ""){
                                textoParagrafoDespesa = "Descrição: "+valorAtualLista2;                        
                            }else{
                                textoParagrafoDespesa = "Descrição: "+valorAtualLista2;                        
                            }
                            countResultadoSplit++; 
                            break;

                        case 1:
                            textoParagrafoDespesa = textoParagrafoDespesa+" - Valor: R$"+valorAtualLista2;
                            countResultadoSplit++;
                            break;   

                        case 2:
                            textoParagrafoDespesa = textoParagrafoDespesa+" - Forma de Pagamento: "+valorAtualLista2;
                            countResultadoSplit++;
                            break;    

                        case 3:                      
                            textoParagrafoDespesa = textoParagrafoDespesa+" - Paga? "+valorAtualLista2;
                            countResultadoSplit++;
                            break;

                        default:
                            alert("Ops, ocorreu um erro!");
                        }                

                    });

                    //cria um elento inpunt <h6>
                    var paragrafoDespesa = document.createElement("h6");

                    //define os atributos desse elemento
                    paragrafoDespesa.id = "h6Despesa"+countDespesas;
                    paragrafoDespesa.class = "card-title";

                    //define o texto dentro do paragrafo
                    paragrafoDespesa.textContent = textoParagrafoDespesa;

                    //adicona o <p> criado na informação das despesas na ultima etapa
                    confirmacaoInfDespesas.appendChild(paragrafoDespesa);                

                });
                countDespesas = 0;

                if (jsCountDespesa2 == 0) { //se for igual a zero
                    //desabilita a div da tabela
                    document.getElementById('tabelaDespesas').style.display = 'none';
                    document.getElementById('qtdDespesa').value = jsCountDespesa2;
                }
            };

            //colocando o botão de remover dentro do td
            removerDespesaTd.appendChild(removerDespesaBotao);

            //seta o texto das td com os valores das variaveis que receberam os valores dos inputs do form
            if (descricaoDespesa !== "") {
                despesaTd.textContent = descricaoDespesa;
            } else {
                despesaTd.textContent = nomeDespesa;
            }

            valorDespesaTd.textContent = valorDespesa;
            formaPagamentoDespesaTd.textContent = nomePagamento;
            despesaPagaTd.textContent = despesaPaga;

            //coloca os TDS criados que estão com os valores do form dentro do TR
            despesaTr.appendChild(despesaTd);
            despesaTr.appendChild(valorDespesaTd);
            despesaTr.appendChild(formaPagamentoDespesaTd);
            despesaTr.appendChild(despesaPagaTd);
            despesaTr.appendChild(removerDespesaTd);

            //pega o elemento table do html através do id e seta nele o TR criado
            var tabelaTbodyDespesa = document.querySelector("#tbodyDespesas");
            tabelaTbodyDespesa.appendChild(despesaTr);

            //INICIO MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA AS DESPESAS NA ULTIMA ETAPAS
            //adiciona na lista da despesa adicionada
            if(descricaoDespesa !== ""){
                listaDespesas.push(descricaoDespesa+"+"+valorDespesa+"+"+nomePagamento+"+"+despesaPaga);             
            }else{
                listaDespesas.push(nomeDespesa+"+"+valorDespesa+"+"+nomePagamento+"+"+despesaPaga);             
            }
            
            //adiciona na lista de valores da despesa
            listaValoresDespesa.push(valorDespesa);
        
            //recebe o elemento html que está as inf das despesas e apaga tudo, pois vai ser montado novamente
            var confirmacaoInfDespesas = document.querySelector("#despesasInf");
            confirmacaoInfDespesas.innerHTML = "";        
            
            listaDespesas.forEach((valorAtualLista) => {
            countDespesas++; 
                
                //realiza um split no valor atual e salva na variavel resultado
                var resultado = valorAtualLista.split("+");

                //variaveis utilizadas para montagem do texto
                var textoParagrafoDespesa = "";
                var countResultadoSplit = 0; 

                //percorre o resultado do split
                resultado.forEach((valorAtualLista2) => {
                    
                    switch(countResultadoSplit) {
                        
                    case 0:
                        if(descricaoDespesa !== ""){
                            textoParagrafoDespesa = "Descrição: "+valorAtualLista2;                        
                        }else{
                            textoParagrafoDespesa = "Descrição: "+valorAtualLista2;                        
                        }
                        countResultadoSplit++; 
                        break;
                    
                    case 1:
                        textoParagrafoDespesa = textoParagrafoDespesa+" - Valor: R$"+valorAtualLista2;
                        countResultadoSplit++;
                        break;   
                    
                    case 2:
                        textoParagrafoDespesa = textoParagrafoDespesa+" - Forma de Pagamento: "+valorAtualLista2;
                        countResultadoSplit++;
                        break;    
                    
                    case 3:                      
                        textoParagrafoDespesa = textoParagrafoDespesa+" - Paga? "+valorAtualLista2;
                        countResultadoSplit++;
                        break;
                        
                    default:
                        alert("Ops, ocorreu um erro!");
                    }                

                });
                
                //cria um elento inpunt <h6>
                var paragrafoDespesa = document.createElement("h6");

                //define os atributos desse elemento
                paragrafoDespesa.id = "h6Despesa"+countDespesas;
                paragrafoDespesa.class = "card-title";
                
                //define o texto dentro do paragrafo
                paragrafoDespesa.textContent = textoParagrafoDespesa;
                
                //adicona o <p> criado na informação das despesas na ultima etapa
                confirmacaoInfDespesas.appendChild(paragrafoDespesa);                
                
            });
            countDespesas = 0;        
            //FIM MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA AS DESPESAS NA ULTIMA ETAPAS   

            //COMEÇO CRIAÇÃO DOS INPUTS      
            //criação do input e definição de seus atributos

            if (descricaoDespesa !== "") {

                //cria input da descricao
                var inputDescricaoDespesa = document.createElement("input");
                //seta type, valor e id
                inputDescricaoDespesa.type = "hidden";
                inputDescricaoDespesa.value = descricaoDespesa;
                inputDescricaoDespesa.id = "descricaoDespesa" + jsCountDespesa;

                //seta o nome
                var nameDescricaoDespesa = "descricaoDespesa" + jsCountDespesa;
                inputDescricaoDespesa.name = nameDescricaoDespesa;

                //criação do input controlador para ver se é manual ou por tipo de despesa
                var inputManualOuTipoDespesa = document.createElement("input");
                //seta type, valor e id
                inputManualOuTipoDespesa.type = "hidden";
                inputManualOuTipoDespesa.value = 0; //0 é manual
                inputManualOuTipoDespesa.id = "manualOuTipoDespesa" + jsCountDespesa;

                //seta o nome
                var nameManualOuTipoDespesa = "manualOuTipoDespesa" + jsCountDespesa;
                inputManualOuTipoDespesa.name = nameManualOuTipoDespesa;


            } else {
                //cria input do id tipo de despesa selecionado
                var inputIdTipoDespesa = document.createElement("input");
                //seta type, valor e id
                inputIdTipoDespesa.type = "hidden";
                inputIdTipoDespesa.value = idTipoDespesa;
                inputIdTipoDespesa.id = "idTipoDespesa" + jsCountDespesa;

                //seta o nome
                var nameIdTipoDespesa = "idTipoDespesa" + jsCountDespesa;
                inputIdTipoDespesa.name = nameIdTipoDespesa;

                //criação do input controlador para ver se é manual ou por tipo de despesa
                var inputDescricaoDespesa = document.createElement("input");
                //seta type, valor e id
                inputDescricaoDespesa.type = "hidden";
                inputDescricaoDespesa.value = descricaoDespesa;
                inputDescricaoDespesa.id = "descricaoDespesa" + jsCountDespesa;

                //seta o nome
                var nameDescricaoDespesa = "descricaoDespesa" + jsCountDespesa;
                inputDescricaoDespesa.name = nameDescricaoDespesa;

                //criação do input controlador para ver se é manual ou por tipo de despesa
                var inputManualOuTipoDespesa = document.createElement("input");

                //seta type, valor e id
                inputManualOuTipoDespesa.type = "hidden";
                inputManualOuTipoDespesa.value = 1; //id de despesa
                inputManualOuTipoDespesa.id = "manualOuTipoDespesa" + jsCountDespesa;

                //seta o nome
                var nameManualOuTipoDespesa = "manualOuTipoDespesa" + jsCountDespesa;
                inputManualOuTipoDespesa.name = nameManualOuTipoDespesa;

            }
            //cria input do valor
            var inputValorDespesa = document.createElement("input");
            //seta type, valor e id
            inputValorDespesa.type = "hidden";
            inputValorDespesa.value = valorDespesa;
            inputValorDespesa.id = "valorDespesa" + jsCountDespesa;

            //seta o nome
            var nameValorDespesa = "valorDespesa" + jsCountDespesa;
            inputValorDespesa.name = nameValorDespesa;

            //cria input do "despesa paga"
            var inputDespesaPaga = document.createElement("input");
            //seta type, valor e id        
            inputDespesaPaga.type = "hidden";
            inputDespesaPaga.value = despesaPaga;
            inputDespesaPaga.id = "despesaPaga" + jsCountDespesa;

            //seta o nome
            var nameDespesaPaga = "despesaPaga" + jsCountDespesa;
            inputDespesaPaga.name = nameDespesaPaga;

            //cria input da forma de pagamento
            var inputFormaDePagamentoDespesa = document.createElement("input");
            //seta type, valor e id
            inputFormaDePagamentoDespesa.type = "hidden";
            inputFormaDePagamentoDespesa.value = idFormaDePagamento;
            inputFormaDePagamentoDespesa.id = "formaPagamentoDespesa" + jsCountDespesa;

            //seta o nome
            var nameFormaDePagamentoDespesa = "formaPagamentoDespesa" + jsCountDespesa;
            inputFormaDePagamentoDespesa.name = nameFormaDePagamentoDespesa;        
            
            //pegando o form de cadastro de festa
            var formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
            
            if (descricaoDespesa !== "") {
                formCadastrarFesta.appendChild(inputDescricaoDespesa);
            } else {
                formCadastrarFesta.appendChild(inputIdTipoDespesa);
            }
            formCadastrarFesta.appendChild(inputManualOuTipoDespesa);
            formCadastrarFesta.appendChild(inputValorDespesa);
            formCadastrarFesta.appendChild(inputFormaDePagamentoDespesa);
            formCadastrarFesta.appendChild(inputDespesaPaga);
            //FIM CRIAÇÃO DOS INPUTS

            //seta a quantidade de despesa no input qtdDespesas
            document.getElementById('qtdDespesa').value = jsCountDespesa;  

            //limpa os valores do input
            form.jsDescricaoDespesa.value = "";
            form.jsTipoDespesa.value = "";
            form.jsFormaPagamentoDespesa.value = "";
            form.jsValorDepesa.value = "";
    });
//FIM FUNÇÕES PRESENTES NA ETAPA 6

//FUNÇÕES PRESENTES NA ETAPA 7
    //quando clicar para voltar etapa 6
    function voltarEtapa6() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "6º Etapa - Despesas da Festa";

        document.getElementById('inserirDespesas').style.display = ''; //habilita a etapa 6
        document.getElementById('valoresEformaPagamento').style.display = 'none'; //desabilita a etapa 7
    };

    //quando clicar em etapa 8
    function etapa8() {
        
        //verifica se o usuário já inseriu as formas de pagamento corretamente
        if(valorTotalFestaLocal == 0 && countPrimeiraVezAdd !== 0){
            //recebendo H3 e setando nela o texto com o nome do cliente
            var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
            tituloDaEtapa.textContent = "8º Etapa - Horários do Evento";

            document.getElementById('inserirHorarios').style.display = ''; //habilita a etapa 8
            document.getElementById('valoresEformaPagamento').style.display = 'none'; //desabilita a etapa 7
            
            msgTratamentoEtapa7.innerHTML = "";
            
            //DEFINI O TEXTO DE CONFIRMAÇÃO DO VALOR A PEGAR COM CONTRATANTE
            
            //apaga o paragrafo do valor a pegar com contratante , pois vai criar outro
            if(criouPegarContratante > 0){
                document.getElementById('pValorPegarContratante').remove();
            }
            criouPegarContratante++;
            
            //recebe o elemento html da ultima etapa (confirmação) e salva em uma variavel 
            var confirmacaoInfValoresFinais = document.querySelector("#valoresFinalInf");
            
            //cria os elementos <h6> para todos os valores
            var paragrafoValorPegarContratante = document.createElement("h6");

            //define o atributo
            paragrafoValorPegarContratante.class = "card-title";         
            paragrafoValorPegarContratante.id = "pValorPegarContratante";         
            
            //define o texto
            paragrafoValorPegarContratante.textContent = "Receber com contrante: R$"+valorPegarContratante;    
            
            //coloca os <p> criados dentro do elemento html da etapa de confirmação
            confirmacaoInfValoresFinais.appendChild(paragrafoValorPegarContratante);
            
            //DEFINI O VALOR DO INPUT DO PEGAR COM CONTRATANTE
            document.getElementById('valorReceberContratante').value = valorPegarContratante;
            
        }else{
            msgTratamentoEtapa7.textContent = "Não foi possível seguir para a 8º Etapa! Para seguir o valor total adicionado deve ser igual ao Valor Total. =)"
        }
        
    };
    
    //evento para adicionar forma de pagamento e valor
    btnFPeValor.addEventListener("click", function (event){
        event.preventDefault();
 
        countPrimeiraVezAdd++;
        
        //pega o elemento form inteiro do html
        var form = document.querySelector("#formAddValorEformaPagamento");

        //mapea todos os inputs pelo nome e salva nas variaveis os valores
        var valorFP = form.jsValorFormaPagamento.value;
        var formaPagamento = form.jsFormaPagamento.value;
        var valorPago = form.jsValorPago.value;

        //para os values que são dropsdows e listado dinamicamente 
        //cria as variavel necessarias
        var idFormaDePagamento = 0;
        var nomePagamento = "";
        var countResultado = 0;

        //recebe o id + o nome e usa a função split para separar e coloca em uma lista
        var resultado = formaPagamento.split("+");

        //percorre essa lista
        resultado.forEach((valorAtual) => {
            countResultado++;
            //se é a primeira vez que passa na lista, pega o id e adiciona na variavel idFormaDePagamento
            if (countResultado == 1) {
                idFormaDePagamento = valorAtual;
            } else {//se não é , pega o nome e adiciona na variavel atual
                nomePagamento = valorAtual;
                countResultado = 0;
            }
        });
        
        //desconta do valor total o valor pago
        valorTotalFestaLocal = parseFloat(valorTotalFestaLocal) - parseFloat(valorFP);
        
        //arredonda o valor para 2 casas depois da virgula
        valorTotalFestaLocal = valorTotalFestaLocal.toFixed(2);
        
        if (valorTotalFestaLocal >= 0){
            
            msgTratamentoEtapa7.innerHTML = "";
            
            //toda vez que add, vai somar 1 no count para saber quantas fp+valor foram adicionados
            jsCountFPeValor++;
            jsCountFPeValor2++;
            
            //habilita a div da tabela
            document.getElementById('tabelaFormaPagamentoEvalor').style.display = 'block';
            
            //cria um elemento do tipo TR e salva ele em uma variavel
            var FPeValorTr = document.createElement("tr");
            FPeValorTr.id = "trFPeValor" + jsCountFPeValor;

            //cria elementos do tipo TD e salva eles em uma variavel
            var valorFpTd = document.createElement("td");
            var formaPagamentoTd = document.createElement("td");
            var valorPagoTd = document.createElement("td");
            var removerValorEfpTd = document.createElement("td");

            //criando elemento button para remover e define seus atributos
            var removerValorBotao = document.createElement("button");
            removerValorBotao.textContent = "Remover";
            removerValorBotao.type = "button";
            removerValorBotao.id = "idRemoverValorEfp";
            removerValorBotao.name = "nameRemoverValorEfp" + jsCountFPeValor;            
            
            //colocando o botão de remover dentro do td
            removerValorEfpTd.appendChild(removerValorBotao);

            //criando função onclik para remover a forma de pagamento adicionado
            removerValorEfpTd.onclick = function () {
                jsCountFPeValor2--; //toda vez que remove diminui
                
                //pega o id da tr e remove
                document.getElementById(FPeValorTr.id).remove();

                //pega os controladores (input) da fp e remove tbm
                document.getElementById(inputValorFp.id).remove();
                document.getElementById(inputFormaPagamento.id).remove();
                document.getElementById(inputValorPago.id).remove();

                //removendo da lista de fp que forma o texto de confirmação da ultima etapa
                listaFPeValor.splice(listaFPeValor.indexOf(nomePagamento+"+"+valorFP+"+"+valorPago), 1);   
                
                //volta o valor removido para o valor total
                valorTotalFestaLocal = parseFloat(valorTotalFestaLocal) + parseFloat(valorFP);
                
                //verifica se o pagamento removido é adiantado, caso não subtrai da variavel global "valorPegarContratante"
                if(valorPago == "Não"){
                    valorPegarContratante = parseFloat(valorPegarContratante) - parseFloat(valorFP);

                    //arredonda para 2 casas depois da virgula
                    valorPegarContratante = valorPegarContratante.toFixed(2);

                }
                           
                
                //recebe o elemento html que está as inf das formas de pagamento e apaga tudo, pois vai ser montado novamente
                var confirmacaoInfFormasPagamento = document.querySelector("#formasDePagamentoInf");
                confirmacaoInfFormasPagamento.innerHTML = "";     

                //percorre a lista e monta o texto de confirmação da ultima etapa
                listaFPeValor.forEach((valorAtualLista) => {
                    countFPeValor++;

                    //realiza um split no valor atual e salva na variavel resultado
                    var resultado = valorAtualLista.split("+");  

                    //variaveis utilizadas para montagem do texto
                    var textoParagrafoFP = "";
                    var countResultadoSplit = 0; 

                    //percorre o resultado do split
                    resultado.forEach((valorAtualLista2) => {
                        if(countResultadoSplit == 0){
                            textoParagrafoFP = "Forma De Pagamento: "+valorAtualLista2;
                            countResultadoSplit++;
                        }
                        if(countResultadoSplit == 1){
                            textoParagrafoFP = textoParagrafoFP+"   -   Valor: "+valorAtualLista2;
                            countResultadoSplit++;
                        } 
                        if(countResultadoSplit == 2){
                            textoParagrafoFP = textoParagrafoFP+"   -   Pago? "+valorAtualLista2;
                        }
                    });

                    //cria um elento inpunt <h6>
                    var paragrafoFP = document.createElement("h6");

                    //define os atributos desse elemento
                    paragrafoFP.id = "h6FormaPagamento"+countFPeValor;
                    paragrafoFP.class = "card-title";

                    //define o texto dentro do paragrafo
                    paragrafoFP.textContent = textoParagrafoFP;

                    //adicona o <p> criado na informação dos horarios na ultima etapa
                    confirmacaoInfFormasPagamento.appendChild(paragrafoFP);                 

                });
                countFPeValor = 0;
                countPrimeiraVezAdd = 0;
            
                if (jsCountFPeValor2 == 0) { //se for igual a zero
                    //desabilita a div da tabela
                    document.getElementById('tabelaFormaPagamentoEvalor').style.display = 'none';
                    document.getElementById('qtdFPeValor').value = jsCountHorario2;
                }            
                
            };

            //seta o texto das td com os valores das variaveis que receberam os valores dos inputs do form
            valorFpTd.textContent = valorFP;
            formaPagamentoTd.textContent = nomePagamento;
            valorPagoTd.textContent = valorPago;

            //coloca os TDS criados que estão com os valores do form dentro do TR
            FPeValorTr.appendChild(valorFpTd);
            FPeValorTr.appendChild(formaPagamentoTd);
            FPeValorTr.appendChild(valorPagoTd);            
            FPeValorTr.appendChild(removerValorEfpTd);            
            
            //pega o elemento table do html através do id e seta nele o TR criado
            var tabelaTbodyFormaPagamentoEvalor = document.querySelector("#tbodyFormaPagamentoEvalor");
            tabelaTbodyFormaPagamentoEvalor.appendChild(FPeValorTr);    
            
            //COMEÇO CRIAÇÃO DOS INPUTS        
            //cria os inputs            
            var inputValorFp = document.createElement("input");
            var inputFormaPagamento = document.createElement("input");                  
            var inputValorPago = document.createElement("input");                  
            
            //define os atributos do inputs
            //tipo
            inputValorFp.type = "hidden";
            inputFormaPagamento.type = "hidden";
            inputValorPago.type = "hidden";
            //valor
            inputValorFp.value = valorFP;
            inputFormaPagamento.value = idFormaDePagamento;  
            inputValorPago.value = valorPago;  
            //nome
            inputValorFp.name = "valorFP" + jsCountFPeValor;
            inputFormaPagamento.name = "formaPagamento" + jsCountFPeValor;
            inputValorPago.name = "valorPago" + jsCountFPeValor;
            //id
            inputValorFp.id = "valorFP" + jsCountFPeValor;
            inputFormaPagamento.id = "formaPagamento" + jsCountFPeValor;                
            inputValorPago.id = "valorPago" + jsCountFPeValor;                
            
            //buscando o form de cadastro e setando nele os inputs criados
            formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
            formCadastrarFesta.appendChild(inputValorFp);
            formCadastrarFesta.appendChild(inputFormaPagamento);
            formCadastrarFesta.appendChild(inputValorPago);
            //FIM CRIAÇÃO DOS INPUTS              
            
            //verifica se o pagamento é adiantado, caso não soma na variavel global "valorPegarContratante"
            if(valorPago == "Não"){
                valorPegarContratante = parseFloat(valorPegarContratante) + parseFloat(valorFP);
                
                //arredonda para 2 casas depois da virgula
                valorPegarContratante = valorPegarContratante.toFixed(2);
            }
            
            //seta no controler hidden o qtd de vezes que foi add fp
            document.getElementById('qtdFPeValor').value = jsCountFPeValor;
              
            //MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA AS FORMAS DE PAGAMENTO NA ULTIMA ETAPAS
            //adiciona na lista o valor + forma pagamento + se foi pago ou nao 
            listaFPeValor.push(nomePagamento+"+"+valorFP+"+"+valorPago);
                               
            //recebe o elemento html que está as inf das formas de pagamento e apaga tudo, pois vai ser montado novamente
            var confirmacaoInfFormasPagamento = document.querySelector("#formasDePagamentoInf");
            confirmacaoInfFormasPagamento.innerHTML = "";
            
            //percorre a lista e monta o texto de confirmação da ultima etapa
            listaFPeValor.forEach((valorAtualLista) => {
                countFPeValor++;
                
                //realiza um split no valor atual e salva na variavel resultado
                var resultado = valorAtualLista.split("+");  
                
                //variaveis utilizadas para montagem do texto
                var textoParagrafoFP = "";
                var countResultadoSplit = 0; 
                
                //percorre o resultado do split
                resultado.forEach((valorAtualLista2) => {
                    if(countResultadoSplit == 0){
                        textoParagrafoFP = "Forma De Pagamento: "+valorAtualLista2;
                    }
                    if(countResultadoSplit == 1){
                        textoParagrafoFP = textoParagrafoFP+"   -   Valor: "+valorAtualLista2;
                    }
                    if(countResultadoSplit == 2){
                        textoParagrafoFP = textoParagrafoFP+"   -   Pago? "+valorAtualLista2;
                    }
                    countResultadoSplit++;                    
                });

                //cria um elento inpunt <h6>
                var paragrafoFP = document.createElement("h6");

                //define os atributos desse elemento
                paragrafoFP.id = "h6FormaPagamento"+countFPeValor;
                paragrafoFP.class = "card-title";
                
                //define o texto dentro do paragrafo
                paragrafoFP.textContent = textoParagrafoFP;
                
                //adicona o <p> criado na informação dos horarios na ultima etapa
                confirmacaoInfFormasPagamento.appendChild(paragrafoFP);                 
                
            });
            countFPeValor = 0;
            // FIM MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA OS HORARIOS NA ULTIMA ETAPA
            
        }else{
            //trata a msg de erro
            msgTratamentoEtapa7.innerHTML = "";
            
            var valorDeDiferenca = valorTotalFestaLocal * (-1);
            
            msgTratamentoEtapa7.textContent = "Não foi possível adicionar, pois o valor ultrapassa R$"+valorDeDiferenca+" o Valor Total. Por favor, revise os valores adicionados!";
            
            valorTotalFestaLocal = parseFloat(valorTotalFestaLocal) + parseFloat(valorFP);
            
        }

        //limpa os valores do input
        form.jsValorFormaPagamento.value = "";
        form.jsFormaPagamento.value = "";
        
    });
//FIM FUNÇÕES PRESENTES NA ETAPA 7

//FUNÇÕES PRESENTES NA ETAPA 8
    //quando clicar para voltar etapa 7
    function voltarEtapa7() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "7º Etapa - Valores e Forma de Pagamento";

        document.getElementById('valoresEformaPagamento').style.display = ''; //habilita a etapa 7
        document.getElementById('inserirHorarios').style.display = 'none'; //desabilita a etapa 8
    };

    //quando clicar em etapa 9
    function etapa9() {
        var qtdHorario = document.getElementById('qtdHorario').value;

        if(qtdHorario == 0){
            
            msgTratamentoEtapa8.textContent = "Não foi possível seguir para 9º Etapa! É obrigatório adicionar no mínimo um horário. =)";

        }else{
            //recebendo H3 e setando nela o texto com o nome do cliente
            var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
            tituloDaEtapa.textContent = "9º Etapa - Endereço do Evento";            
            
            document.getElementById('inserirEndereco').style.display = ''; //habilita a etapa 9
            document.getElementById('inserirHorarios').style.display = 'none'; //desabilita a etapa 8
        }
    };

    //evento para adcionar horario
    btnAddHorario.addEventListener("click", function (event) {
        event.preventDefault();
        
            msgTratamentoEtapa8.innerHTML = "";
            
            //toda vez que add, vai somar 1 no count para saber quantos horarios foram adicionados
            jsCountHorario++;
            jsCountHorario2++;

            //pega o elemento form inteiro do html
            var form = document.querySelector("#formHorario");

            //mapea todos os inputs pelo nome e salva nas variaveis os valores
            var horario = form.jsHorario.value;
            var descricaoHorario = form.jsDescricaoH.value;

            //habilita a div da tabela
            document.getElementById('tabelaHorario').style.display = 'block';

            //cria um elemento do tipo TR e salva ele em uma variavel
            var horarioTr = document.createElement("tr");
            horarioTr.id = "tdHorario" + jsCountHorario;

            //cria elementos do tipo TD e salva eles em uma variavel
            var horarioTd = document.createElement("td");
            var descricaoHorarioTd = document.createElement("td");
            var removerHorarioTd = document.createElement("td");

            //criando elemento button para remover 
            var removerHorarioBotao = document.createElement("button");

            removerHorarioBotao.textContent = "Remover";
            removerHorarioBotao.type = "button";
            removerHorarioBotao.id = "idRemoverHorarioBotao";
            removerHorarioBotao.name = "nameRemoverHorarioBotao" + jsCountHorario;

            //criando função on clik para remover o horario adicionado
            removerHorarioBotao.onclick = function () {
                jsCountHorario2--; //toda vez que remove diminui

                //pega o id da tr e remove
                document.getElementById(horarioTr.id).remove();

                //pega os controladores da despesa e remove tbm
                document.getElementById(inputHorario.id).remove();
                document.getElementById(inputHorarioDescricao.id).remove();
                
                //removendo da lista de horario que forma o texto de confirmação da ultima etapa
                listaHorarios.splice(listaHorarios.indexOf(horario+"+"+descricaoHorario), 1);
                
                //recebe o elemento html que está as inf dos valores adicionais e apaga tudo, pois vai ser montado novamente
                var confirmacaoInfHorarios = document.querySelector("#horariosInf");
                confirmacaoInfHorarios.innerHTML = "";

                //percorre a lista e monta o texto de confirmação da ultima etapa
                listaHorarios.forEach((valorAtualLista) => {
                    countHorarios++;

                    //realiza um split no valor atual e salva na variavel resultado
                    var resultado = valorAtualLista.split("+");  

                    //variaveis utilizadas para montagem do texto
                    var textoParagrafoHorarios = "";
                    var countResultadoSplit = 0; 

                    //percorre o resultado do split
                    resultado.forEach((valorAtualLista2) => {
                        if(countResultadoSplit == 0){
                            textoParagrafoHorarios = "Horário: "+valorAtualLista2;
                            countResultadoSplit++;
                        }else{
                            textoParagrafoHorarios = textoParagrafoHorarios+"   -   Descrição: "+valorAtualLista2;
                            countResultadoSplit = 0;
                        } 
                    });

                    //cria um elemento html <h6>
                    var paragrafoHorario = document.createElement("h6");

                    //define os atributos desse elemento
                    paragrafoHorario.id = "h6Horario"+countHorarios;
                    paragrafoHorario.class = "card-title";

                    //define o texto dentro do paragrafo
                    paragrafoHorario.textContent = textoParagrafoHorarios;

                    //adicona o <p> criado na informação dos horarios na ultima etapa
                    confirmacaoInfHorarios.appendChild(paragrafoHorario);                 

                });
                countHorarios = 0;    
                
                if (jsCountHorario2 == 0) { //se for igual a zero
                    //desabilita a div da tabela
                    document.getElementById('tabelaHorario').style.display = 'none';
                    document.getElementById('qtdHorario').value = jsCountHorario2;
                }
            };

            //colocando o botão de remover dentro do td
            removerHorarioTd.appendChild(removerHorarioBotao);

            //seta o texto das td com os valores das variaveis que receberam os valores dos inputs do form
            horarioTd.textContent = horario;
            descricaoHorarioTd.textContent = descricaoHorario;

            //coloca os TDS criados que estão com os valores do form dentro do TR
            horarioTr.appendChild(horarioTd);
            horarioTr.appendChild(descricaoHorarioTd);
            horarioTr.appendChild(removerHorarioTd);

            //pega o elemento table do html através do id e seta nele o TR criado
            var tabelaTbodyHorario = document.querySelector("#tbodyHorario");
            tabelaTbodyHorario.appendChild(horarioTr);

            //MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA OS HORARIOS NA ULTIMA ETAPAS
            //adiciona na lista o horario + descricao do horario adicionado
            listaHorarios.push(horario+"+"+descricaoHorario);
            
            //recebe o elemento html que está as inf dos valores adicionais e apaga tudo, pois vai ser montado novamente
            var confirmacaoInfHorarios = document.querySelector("#horariosInf");
            confirmacaoInfHorarios.innerHTML = "";
        
            //percorre a lista e monta o texto de confirmação da ultima etapa
            listaHorarios.forEach((valorAtualLista) => {
                countHorarios++;
                
                //realiza um split no valor atual e salva na variavel resultado
                var resultado = valorAtualLista.split("+");  
                
                //variaveis utilizadas para montagem do texto
                var textoParagrafoHorarios = "";
                var countResultadoSplit = 0; 
                
                //percorre o resultado do split
                resultado.forEach((valorAtualLista2) => {
                    if(countResultadoSplit == 0){
                        textoParagrafoHorarios = "Horário: "+valorAtualLista2;
                        countResultadoSplit++;
                    }else{
                        textoParagrafoHorarios = textoParagrafoHorarios+"   -   Descrição: "+valorAtualLista2;
                        countResultadoSplit = 0;
                    } 
                });

                //cria um elemento html <h6>
                var paragrafoHorario = document.createElement("h6");

                //define os atributos desse elemento
                paragrafoHorario.id = "h6Horario"+countHorarios;
                paragrafoHorario.class = "card-title";
                
                //define o texto dentro do paragrafo
                paragrafoHorario.textContent = textoParagrafoHorarios;
                
                //adicona o <p> criado na informação dos horarios na ultima etapa
                confirmacaoInfHorarios.appendChild(paragrafoHorario);                 
                
            });
            countHorarios = 0;
            // FIM MONTAGEM DE TEXTO DE CONFIRMAÇÃO PARA OS HORARIOS NA ULTIMA ETAPA

            //COMEÇO CRIAÇÃO DOS INPUTS
            //cria os inputs
            var inputHorario = document.createElement("input");
            var inputHorarioDescricao = document.createElement("input");
                    
            //define os atributos do input
            //tipo
            inputHorario.type = "hidden";
            inputHorarioDescricao.type = "hidden";
            
            //valor
            inputHorario.value = horario;
            inputHorarioDescricao.value = descricaoHorario;  
            
            //nome
            inputHorario.name = "horario" + jsCountHorario;
            inputHorarioDescricao.name = "horarioDesricao" + jsCountHorario;
            
            //id
            inputHorario.id = "horario" + jsCountHorario;
            inputHorarioDescricao.id = "horarioDesricao" + jsCountHorario;        

            //buscando o form de cadastro e setando nele os inputs criados
            formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
            formCadastrarFesta.appendChild(inputHorario);
            formCadastrarFesta.appendChild(inputHorarioDescricao);
            //FIM CRIAÇÃO DOS INPUTS

            //seta no controler hidden o valor das vezes que foi add despesa
            document.getElementById('qtdHorario').value = jsCountHorario;

            //limpa os valores do input
            form.jsHorario.value = "";
            form.jsDescricaoH.value = "";
    });

//FIM FUNÇÕES PRESENTES NA ETAPA 8

//FIM FUNÇÕES PRESENTES NA ETAPA 9
    //quando clicar para voltar etapa 8
    function voltarEtapa8() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "8º Etapa - Horários do Evento";

        document.getElementById('inserirHorarios').style.display = ''; //habilita a etapa 8
        document.getElementById('inserirEndereco').style.display = 'none'; //desabilita a etapa 9
    };

    //quando clicar em etapa etapa final
    function etapa10() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "10º Etapa - Informações finais do evento";
    
        document.getElementById('inserirInfoAdicionais').style.display = ''; //habilita a etapa 10
        document.getElementById('inserirEndereco').style.display = 'none'; //desabilita a etapa 9

        //PROCESSO DE CRIAÇÃO DO TEXTO DE CRIAÇÃO DA ULTIMA ETAPA
        //recebendo os valores os valores inseridos no input
        var cep = document.getElementById('cep').value;
        var cidade = document.getElementById('cidade').value;
        var bairro = document.getElementById('bairro').value;
        var rua = document.getElementById('rua').value;
        var numero = document.getElementById('numero').value;
        var complemento = document.getElementById('complemento').value;

        //recebe o elemento que está o atual texto e apaga o conteudo dele
        var confirmacaoInfEndereco = document.querySelector("#enderecoFestaInf");
        confirmacaoInfEndereco.innerHTML = "";
        
        //cria um novo elemento <p> para cada input inserido
        var paragrafoCep = document.createElement("h6");
        var paragrafoCidade = document.createElement("h6");
        var paragrafoBairro = document.createElement("h6");
        var paragrafoRua = document.createElement("h6");
        var paragrafoNumero = document.createElement("h6");
        var paragrafoComplemento = document.createElement("h6");

        //define os atributos dos elementos <p>
        paragrafoCep.class = "card-title";
        paragrafoCidade.class = "card-title";
        paragrafoBairro.class = "card-title";
        paragrafoRua.class = "card-title";
        paragrafoNumero.class = "card-title";
        paragrafoComplemento.class = "card-title";

        //define o texto do <p> com a variavel que tem o valor do input
        paragrafoCep.textContent = "Cep: " + cep;
        paragrafoCidade.textContent = "Cidade: " + cidade;
        paragrafoBairro.textContent = "Bairro: " + bairro;
        paragrafoRua.textContent = "Rua: " + rua;
        paragrafoNumero.textContent = "N°: " + numero;
        if(complemento !== ""){
            paragrafoComplemento.textContent = "Complemento: " + complemento;  
        }

        //adicona os <p> criados na informação do endereco na ultima etapa
        confirmacaoInfEndereco.appendChild(paragrafoCep);  
        confirmacaoInfEndereco.appendChild(paragrafoCidade);  
        confirmacaoInfEndereco.appendChild(paragrafoBairro);  
        confirmacaoInfEndereco.appendChild(paragrafoRua);  
        confirmacaoInfEndereco.appendChild(paragrafoNumero);  
        if(complemento !== ""){
            confirmacaoInfEndereco.appendChild(paragrafoComplemento);     
        }

        //FIM DO PROCESSO DE CRIAÇÃO DO TEXTO DE CRIAÇÃO DA ULTIMA ETAPA
        
        //SETANDO OS VALORES RECEBIDOS NO INPUT, NO INPUT DO FORM DE CADASTRO DE FESTA
        document.getElementById('cepF').value = cep;
        document.getElementById('cidadeF').value = cidade;   
        document.getElementById('bairroF').value = bairro;
        document.getElementById('ruaF').value = rua; 
        document.getElementById('numeroF').value = numero ;
        document.getElementById('complementoF').value = complemento;    
    };
//FIM FUNÇÕES PRESENTES NA ETAPA 9

//FUNÇÕES PRESENTES NA ETAPA 10
    //quando clicar para voltar etapa 9
    function voltarEtapa9() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "9º Etapa - Endereço do Evento";

        document.getElementById('inserirEndereco').style.display = ''; //habilita a etapa 8
        document.getElementById('inserirInfoAdicionais').style.display = 'none'; //desabilita a etapa 9
    };

    //quando clicar em etapa etapa final
    function etapaFinal() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "ETAPA FINAL - Confirmar Informações";
    
        document.getElementById('confirmarInformacoes').style.display = ''; //habilita a etapa final
        document.getElementById('inserirInfoAdicionais').style.display = 'none'; //desabilita a etapa 10
        
        //PROCESSO DE CRIAÇÃO DO TEXTO DE CRIAÇÃO DA ULTIMA ETAPA
        //recebendo os valores os valores inseridos no input
        var descricaoEvento = document.getElementById('descricaoEvento').value;
        var qtdCriancaNaFesta = document.getElementById('qtdCriancaNaFesta').value;
        var dataDaFesta = document.getElementById('dataFesta').value;
        var tipoDaFesta = document.getElementById('tipoDaFesta').value;
        var observacao = document.getElementById('obs').value;
        var festaRealizada = document.getElementById('festaRealizada').value;  
        
        //define o texto de confirmacao da ultima etapa com as variaveis que tem o valor do input
        document.getElementById('descricaoEventoInf').textContent = "Descrição do Evento: " + descricaoEvento;
        document.getElementById('qtdCriancaNaFestaInf').textContent = "Quantidade de crianças no evento: " + qtdCriancaNaFesta;
        document.getElementById('dataDaFestaInf').textContent = "Data do evento: " + dataDaFesta;
        document.getElementById('tipoDeFestaInf').textContent = "Tipo de festa: " + tipoDaFesta;
        if(observacao !== ""){
            document.getElementById('ObsInf').textContent = "Observação: " + observacao;
        }
        document.getElementById('festaRealizadaInf').textContent = "Evento realizado? " + festaRealizada;        
        //FIM DO PROCESSO DE CRIAÇÃO DO TEXTO DE CRIAÇÃO DA ULTIMA ETAPA
        
        //SETANDO OS VALORES RECEBIDOS NO INPUT, NO INPUT DO FORM DE CADASTRO DE FESTA
        document.getElementById('descricaoEventoF').value = descricaoEvento;
        document.getElementById('festaRealizadaF').value = festaRealizada;
        document.getElementById('tipoDaFestaF').value = tipoDaFesta;
        document.getElementById('observacaoF').value = observacao;
        document.getElementById('dataFestaF').value = dataDaFesta;
        document.getElementById('qtdCriancaNaFestaF').value = qtdCriancaNaFesta;
    };
//FIM FUNÇÕES PRESENTES NA ETAPA 10

//FUNÇÕES PRESENTES NA ETAPA FINAL
    //quando clicar para voltar etapa 10
    function voltarEtapa10() {
        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "10º Etapa - Informações finais do evento";

        document.getElementById('inserirInfoAdicionais').style.display = ''; //habilita a etapa 10
        document.getElementById('confirmarInformacoes').style.display = 'none'; //desabilita a etapa final
    };
    
    function editarEtapa(numeroEtapa) {
        
        document.getElementById('confirmarInformacoes').style.display = 'none'; //desabilita a etapa final
        
        switch (numeroEtapa) {
            case 1:
                //recebendo H3 e setando nela o texto com o nome do cliente
                var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
                tituloDaEtapa.textContent = "1º Etapa - Selecionar Cliente";

                document.getElementById('confirmacaoCliente').style.display = ''; //habilita a confirmação da etapa 1
                
                break;
            case 2:
                //recebendo H3 e setando nela o texto com o nome do cliente
                var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
                tituloDaEtapa.textContent = "2º Etapa - Selecionar Criança";

                document.getElementById('selecionarAniversariantes').style.display = ''; //habilita a etapa 2

                textoConfirmacaoCrianca = "";

                break;
            case 3:
                //recebendo H3 e setando nela o texto com o nome do cliente
                var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
                tituloDaEtapa.textContent = "3º Etapa - Selecionar Animadoras/Animadores";

                document.getElementById('selecionarFuncionarios').style.display = ''; //habilita a etapa 3
                
                break;
            case 4:
                //recebendo H3 e setando nela o texto com o nome do cliente
                var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
                tituloDaEtapa.textContent = "4º Etapa - Selecionar Pacotes";

                document.getElementById('selecionarPacotes').style.display = ''; //habilita a etapa 4
                
                break;
            case 5:
                //recebendo H3 e setando nela o texto com o nome do cliente
                var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
                tituloDaEtapa.textContent = "5º Etapa - Valores Adicionais";

                document.getElementById('inserirValorAdicional').style.display = ''; //habilita a etapa 5
                
                break;
            case 6:
                //recebendo H3 e setando nela o texto com o nome do cliente
                var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
                tituloDaEtapa.textContent = "6º Etapa - Despesas da Festa";

                document.getElementById('inserirDespesas').style.display = ''; //habilita a etapa 6

                break;
            case 7:
                //recebendo H3 e setando nela o texto com o nome do cliente
                var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
                tituloDaEtapa.textContent = "7º Etapa - Valores e Forma de Pagamento";

                document.getElementById('valoresEformaPagamento').style.display = ''; //habilita a etapa 7
        
                break;
            case 8:
                //recebendo H3 e setando nela o texto com o nome do cliente
                var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
                tituloDaEtapa.textContent = "8º Etapa - Horários do Evento";

                document.getElementById('inserirHorarios').style.display = ''; //habilita a etapa 8
                
                break;
            case 9:
                //recebendo H3 e setando nela o texto com o nome do cliente
                var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
                tituloDaEtapa.textContent = "9º Etapa - Endereço do Evento";

                document.getElementById('inserirEndereco').style.display = ''; //habilita a etapa 8
                
                break;
            case 10:
                //recebendo H3 e setando nela o texto com o nome do cliente
                var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
                tituloDaEtapa.textContent = "10º Etapa - Informações finais do evento";

                document.getElementById('inserirInfoAdicionais').style.display = ''; //habilita a etapa 10
                
                break;
            default:
                alert('Ops, ocorreu um erro!');
        }        
    };
//FIM FUNÇÕES PRESENTES NA ETAPA FINAL
