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

    }; 

    //quando clicar para trocar cliente
    function trocarCliente() {

        //seta como vazio os atributos do cliente seleciado
        idCliente = 0;
        nomeCliente = "";

        document.getElementById('listagemDeCliente').style.display = ''; //habilita a tabela de listagem do cliente
        document.getElementById('confirmacaoCliente').style.display = 'none'; //desabilita a confirmação da etapa 1
        document.getElementById('confirmacaoCliente').style.display = 'none'; //desabilita a confirmação da etapa 1

        //como está trocando de cliente , as crianças serão outras , então limpa tudo que é relacionado as crianças (etapa2)
        if(countEtapa2 !== 0){
            document.getElementById("tbodyAniversariantes").innerHTML="";
            document.getElementById('tabelaAniversariante').style.display = 'none'; //desabilita a tabela de listagem de criança
            countEtapa2 = 0;
        }


    };

    //quando clicar em etapa 2
    function etapa2() {
        countEtapa2++;
        var quantidadeCrianca = 0; //varivel que verifica se o cliente seleciona possui criança

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

                    console.log(idCrianca);
                    console.log(nomeCrianca);
                    console.log(idClienteCrianca);                  
                }

            }


    //        //COMEÇO DA CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS DOS ANIVERSARIANTE ADD
    //        //cria um controlador(input) para os aniversariantes toda vez que adiciona um aniversariante
    //        var inputIdAniversariante = document.createElement("input");
    //        var inputNomeAniversariante = document.createElement("input");
    //
    //        //seta como tipo hidden os controladores(inputs) criados para aniversariante
    //        inputIdAniversariante.type = "hidden";
    //        inputNomeAniversariante.type = "hidden";
    //
    //        //setando os valores digitos pelo usuário, nos values dos controladores
    //        inputIdAniversariante.value = idAniversariante;
    //        inputNomeAniversariante.value = nomeAniversariante;
    //
    //        //variavel que vai ser o nome dos controladores(inputs) , recebe uma string + o valor da variavel jsAniversariante
    //        var nameIdAniversariante = "idAniversariante" + controladorDeInputsCriado;
    //        var nameAniversariante = "nomeAniversariante" + controladorDeInputsCriado;
    //
    //        //seta no name dos controladores(input) o valor das variaveis
    //        inputIdAniversariante.name = nameIdAniversariante;
    //        inputNomeAniversariante.name = nameAniversariante;
    //
    //        //setando id para os controladores(inputs)
    //        inputIdAniversariante.id = "idAniversariante" + controladorDeInputsCriado;
    //        inputNomeAniversariante.id = "nomeAniversariante" + controladorDeInputsCriado;
    //
    //        //pegando o form de comunição com o back-end e setando nele controladores(inputs) criados
    //        formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
    //        formCadastrarFesta.appendChild(inputIdAniversariante);
    //        formCadastrarFesta.appendChild(inputNomeAniversariante);
    //
    //        formSelecionarCliente = document.querySelector('#listarOpcoes');
    //        formSelecionarCliente.appendChild(inputIdAniversariante);
    //        formSelecionarCliente.appendChild(inputNomeAniversariante);
    //        //FIM CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS ANIVERSARIANTES ADD

        });

        //se o cliente não tiver criança
        if(quantidadeCrianca < 1){

            var subTituloEtapa2 = document.querySelector("#subTituloEtapa2");
            subTituloEtapa2.textContent = "O cliente selecionado não possui criança vinculada ao seu cadastro. Por favor pule para a próxima etapa!";        

        }
        console.log(quantidadeCrianca);

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

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "3º Etapa - Selecionar Animadoras/Animadores";

        document.getElementById('selecionarFuncionarios').style.display = ''; //habilita a etapa 3
        document.getElementById('selecionarAniversariantes').style.display = 'none'; //desabilita a etapa 2

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

    };

    //quando clicar em etapa 4
    function etapa4() {

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "4º Etapa - Selecionar Pacotes";

        document.getElementById('selecionarPacotes').style.display = ''; //habilita a etapa 4
        document.getElementById('selecionarFuncionarios').style.display = 'none'; //desabilita a etapa 3

    };
//FIM FUNÇÕES PRESENTES NA ETAPA 3

//FUNÇÕES PRESENTES NA ETAPA 4

    //se clicar no botão Sim do pacote adicional
    function habilitaPacoteAdicional() {
        document.getElementById('divPacoteAdicional').style.display = 'block';  //habilita a div com id "divPacoteAdicional"
        //document.getElementById('temPacotesAdicionais').value = 1;         
    }; 

    //se clicar no botão Não do pacote adicional
    function desabilitaPacoteAdicional() {             
        document.getElementById('divPacoteAdicional').style.display = 'none';  //desabilita a div com id "divPacoteAdicional"                 
//        document.getElementById('temPacotesAdicionais').value = 0;
//        document.getElementById('countPacotesAdicionais').value = 0;
    }; 
    
    //quando clicar para voltar etapa 3
    function voltarEtapa3() {

        //recebendo H3 e setando nela o texto com o nome do cliente
        var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
        tituloDaEtapa.textContent = "3º Etapa - Selecionar Animadoras/Animadores";

        document.getElementById('selecionarPacotes').style.display = 'none'; //desabilita a etapa 4
        document.getElementById('selecionarFuncionarios').style.display = ''; //habilita a etapa ,3

    };

    //quando clicar em etapa 4
    function etapa5() {

    //    //recebendo H3 e setando nela o texto com o nome do cliente
    //    var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
    //    tituloDaEtapa.textContent = "4º Etapa - Selecionar Pacotes";
    //
    //    document.getElementById('selecionarPacotes').style.display = ''; //habilita a etapa 4
    //    document.getElementById('selecionarFuncionarios').style.display = 'none'; //desabilita a etapa 3

    };
//FIM FUNÇÕES PRESENTES NA ETAPA 4