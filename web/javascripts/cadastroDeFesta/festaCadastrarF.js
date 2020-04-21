/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//dados globais dos clientes selecionados
var idCliente;
var nomeCliente;

//variavel que verifica se já passou pela etapa 2 para não criar duplicado
var countEtapa2 = 0;

//varivel que recebe a quantidade de crianças adicionadas no form
var quantidadeCrianca = 0;
var quantidadeCriancaBotaoRemover = 0;

//variaveis que controlam o texto de confirmação da criança na ultima etapa
let listaNomeCrianca = [];
var textoConfirmacaoCrianca = "";

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
        
        //apaga os inputs criados na etapa 2 e zera a variavel global "quantidadeCrianca"
        for(var i=0; i < quantidadeCriancaBotaoRemover; i++){
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
        textoConfirmacaoCrianca = "";
        listaNomeCrianca = [];
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
                quantidadeCrianca++;

                document.getElementById('tabelaAniversariante').style.display = ''; //habilita a tabela de listagem de criança

                //condição para verificar se alguma vez já passou pela etapa 2 e criou os elementos 
                if(countEtapa2 == 1){

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
                            textoConfirmacaoCrianca = "";
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

            var subTituloEtapa2 = document.querySelector("#subTituloEtapa2");
            subTituloEtapa2.textContent = "O cliente selecionado não possui criança vinculada ao seu cadastro. Por favor pule para a próxima etapa!";        

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

    //quando clicar em etapa 3
    function etapa3() {
        countListaNomeCrianca = 0; //count de quantas vezes passou na lista de crianças

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "3º Etapa - Selecionar Animadoras/Animadores";

        document.getElementById('selecionarFuncionarios').style.display = ''; //habilita a etapa 3
        document.getElementById('selecionarAniversariantes').style.display = 'none'; //desabilita a etapa 2
        
        //seta a quantidade de criança que foi definida no input de controle "qtdCrianca"
        document.getElementById('qtdCrianca').value = quantidadeCrianca;
        
        //percorre a lista de nomes das crianças e monta o texto de confirmação para as crianças
        var tamanhoListaNomeCrianca = listaNomeCrianca.length; //recebe o tamanho da lista em uma variavel

        listaNomeCrianca.forEach((valorAtualLista) => {
            if(countListaNomeCrianca == 0){
                textoConfirmacaoCrianca = "Aniversariante/s: "
            }
            countListaNomeCrianca++;
            
            if(countListaNomeCrianca == tamanhoListaNomeCrianca){
                textoConfirmacaoCrianca = textoConfirmacaoCrianca + valorAtualLista;
            }else{
                textoConfirmacaoCrianca = textoConfirmacaoCrianca + valorAtualLista + " / ";
            }
            
        }); 
        countListaNomeCrianca = 0;
        
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

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "4º Etapa - Selecionar Pacotes";

        //recebe a quantidade de funcionario selecionado
        var qtdFuncionario = document.getElementById('qtdFuncioanrio').value;
        
        //verifica se tem pelo menos 1 funcionario
        if(qtdFuncionario == 0){
            alert("É obrigatório no mínimo 1 animador por evento !");         
        }else{
            document.getElementById('selecionarPacotes').style.display = ''; //habilita a etapa 4
            document.getElementById('selecionarFuncionarios').style.display = 'none'; //desabilita a etapa 3    
        }
        
    };
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

    };
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

    };
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

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "7º Etapa - Valores e Forma de Pagamento";
    
        document.getElementById('valoresEformaPagamento').style.display = ''; //habilita a etapa 7
        document.getElementById('inserirDespesas').style.display = 'none'; //desabilita a etapa 6

    };
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

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "8º Etapa - Horários do Evento";
    
        document.getElementById('inserirHorarios').style.display = ''; //habilita a etapa 8
        document.getElementById('valoresEformaPagamento').style.display = 'none'; //desabilita a etapa 7

    };
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

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "9º Etapa - Endereço do Evento";

        var qtdHorario = document.getElementById('qtdHorario').value;
        
        if(qtdHorario == 0){
            alert("Para ir para 9ºEtapa, é obrigatório no mínimo 1 horário!");
        }else{
            document.getElementById('inserirEndereco').style.display = ''; //habilita a etapa 9
            document.getElementById('inserirHorarios').style.display = 'none'; //desabilita a etapa 8
        }

    };
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

    };
//FIM FUNÇÕES PRESENTES NA ETAPA 10
//
//FUNÇÕES PRESENTES NA ETAPA FINAL
    //quando clicar para voltar etapa 10
    function voltarEtapa10() {

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "10º Etapa - Informações finais do evento";

        document.getElementById('inserirInfoAdicionais').style.display = ''; //habilita a etapa 10
        document.getElementById('confirmarInformacoes').style.display = 'none'; //desabilita a etapa final

    };
//FIM FUNÇÕES PRESENTES NA ETAPA FINAL