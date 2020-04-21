/* 
 * Arquivo JS utilizado para cadastro de festa, cujo sua função é a criação e remoção de inputs dinamicos
 */

//var dos funcionarios
    //count
    var jsCountFuncionario = 0;
    var jsCountFuncionario2 = 0;
    
    //variaveis que controlam o texto de confirmação dos funcionario na ultima etapa
    let listaFuncionarios = [];
    var countListaFuncionario = 0;

//var das pacotes adicionais
    //count
    var jsCountPacotesAdicionais = 0;
    var jsCountPacotesAdicionais2 = 0;

    //variaveis que controlam o texto de confirmação dos pacotes adicionais na ultima etapa
    let listaPacotesAdicionais = [];
    var countPacotesAdicionais = 0;
    
//var do valor adicional
    //count
    var jsCountValorAdicional = 0;
    var jsCountValorAdicional2 = 0;

    //variaveis que controlam o texto de confirmação dos valores adicionais na ultima etapa
    let listaValoresAdicionais = [];
    var countValoresAdicionais = 0;

//var das despesas
var jsCountDespesa = 0;
var jsCountDespesa2 = 0;

//var dos horarios
    //count
    var jsCountHorario = 0;
    var jsCountHorario2 = 0;

    //variaveis que controlam o texto de confirmação dos valores adicionais na ultima etapa
    let listaHorarios = [];
    var controleTextoConfirmacaoHorarios = "";
    var countHorarios = 0;

//recebendo em uma variavel o botão de + 
var btnAddFuncionario = document.querySelector("#add-funcionario");
var btnAddPacotesAdicionais = document.querySelector("#add-pacoteAdicional");
var btnAddValorAdicional = document.querySelector("#add-valorAdicional");
var btnAddDespesa = document.querySelector("#add-despesaFesta");
var btnAddHorario = document.querySelector("#add-horario");

//evento do funcionario
btnAddFuncionario.addEventListener("click", function (event) {
    event.preventDefault();

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
                        textoParagrafoFuncionario = "Animador/a: "+valorAtualLista2;
                        countResultadoSplit++;
                    }else{
                        textoParagrafoFuncionario = textoParagrafoFuncionario+"   -   Cache: R$"+valorAtualLista2;
                        countResultadoSplit = 0;
                    }

                });

                //cria um elento inpunt <p>
                var paragrafoFuncionario = document.createElement("p");

                //define os atributos desse elemento
                paragrafoFuncionario.id = "pFuncionario"+countListaFuncionario;

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
                    textoParagrafoFuncionario = "Animador/a: "+valorAtualLista2;
                    countResultadoSplit++;
                }else{
                    textoParagrafoFuncionario = textoParagrafoFuncionario+"   -   Cache: R$"+valorAtualLista2;
                    countResultadoSplit = 0;
                }
                
            });
            
            //cria um elento inpunt <p>
            var paragrafoFuncionario = document.createElement("p");
            
            //define os atributos desse elemento
            paragrafoFuncionario.id = "pFuncionario"+countListaFuncionario;
            
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

//evento pacote adicional
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

                //cria um elento inpunt <p>
                var paragrafoPacoteAdd = document.createElement("p");

                //define os atributos desse elemento
                paragrafoPacoteAdd.id = "pPacoteAdd"+countPacotesAdicionais;

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
        
            //cria um elento inpunt <p>
            var paragrafoPacoteAdd = document.createElement("p");
            
            //define os atributos desse elemento
            paragrafoPacoteAdd.id = "pPacoteAdd"+countPacotesAdicionais;
            
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

//evento do valor adicional
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

                //cria um elento inpunt <p>
                var paragrafoValorAdicional = document.createElement("p");

                //define os atributos desse elemento
                paragrafoValorAdicional.id = "pValorAdd"+countValoresAdicionais;

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

            //cria um elento inpunt <p>
            var paragrafoValorAdicional = document.createElement("p");
    
            //define os atributos desse elemento
            paragrafoValorAdicional.id = "pValorAdd"+countValoresAdicionais;
            
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

//evento do despesa
btnAddDespesa.addEventListener("click", function (event) {
    event.preventDefault();

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
//            jsCountDespesa2--; //toda vez que remove diminui
//
//            //pega o id da tr e remove
//            document.getElementById(despesaTr.id).remove();
//
//            //pega os controladores do anversariante e remove tbm
//            if (descricaoDespesa !== "") {
//                document.getElementById(inputDescricaoDespesa.id).remove();
//            } else {
//                document.getElementById(inputIdTipoDespesa.id).remove();
//            }
//            document.getElementById(inputValorDespesa.id).remove();
//            document.getElementById(inputFormaDePagamentoDespesa.id).remove();            
//            document.getElementById(inputDespesaPaga.id).remove();
//            document.getElementById(inputManualOuTipoDespesa.id).remove();
//
//
//            if (jsCountDespesa2 == 0) { //se for igual a zero
//                //desabilita a div da tabela
//                document.getElementById('tabelaDespesas').style.display = 'none';
//                document.getElementById('countDespesaFesta').value = jsCountDespesa2;
//            }
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
        var tabelaTbodyAniversariante = document.querySelector("#tbodyDespesas");
        tabelaTbodyAniversariante.appendChild(despesaTr);

//        //COMEÇO DA CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DOS ANIVERSARIANTE ADD
//        //cria um controlador(input) para os aniversariantes toda vez que adiciona um aniversariante
//        if (descricaoDespesa !== "") {
//
//            //cria input da descricao
//            var inputDescricaoDespesa = document.createElement("input");
//            //seta type, valor e id
//            inputDescricaoDespesa.type = "hidden";
//            inputDescricaoDespesa.value = descricaoDespesa;
//            inputDescricaoDespesa.id = "descricaoDespesa" + jsCountDespesa;
//
//            //seta o nome
//            var nameDescricaoDespesa = "descricaoDespesa" + jsCountDespesa;
//            inputDescricaoDespesa.name = nameDescricaoDespesa;
//
//            //criação do input controlador para ver se é manual ou por tipo de despesa
//            var inputManualOuTipoDespesa = document.createElement("input");
//            //seta type, valor e id
//            inputManualOuTipoDespesa.type = "hidden";
//            inputManualOuTipoDespesa.value = 0; //0 é manual
//            inputManualOuTipoDespesa.id = "manualOuTipoDespesa" + jsCountDespesa;
//
//            //seta o nome
//            var nameManualOuTipoDespesa = "manualOuTipoDespesa" + jsCountDespesa;
//            inputManualOuTipoDespesa.name = nameManualOuTipoDespesa;
//
//
//        } else {
//            //cria input do id tipo de despesa selecionado
//            var inputIdTipoDespesa = document.createElement("input");
//            //seta type, valor e id
//            inputIdTipoDespesa.type = "hidden";
//            inputIdTipoDespesa.value = idTipoDespesa;
//            inputIdTipoDespesa.id = "idTipoDespesa" + jsCountDespesa;
//
//            //seta o nome
//            var nameIdTipoDespesa = "idTipoDespesa" + jsCountDespesa;
//            inputIdTipoDespesa.name = nameIdTipoDespesa;
//
//            //criação do input controlador para ver se é manual ou por tipo de despesa
//            var inputDescricaoDespesa = document.createElement("input");
//            //seta type, valor e id
//            inputDescricaoDespesa.type = "hidden";
//            inputDescricaoDespesa.value = descricaoDespesa;
//            inputDescricaoDespesa.id = "descricaoDespesa" + jsCountDespesa;
//
//            //seta o nome
//            var nameDescricaoDespesa = "descricaoDespesa" + jsCountDespesa;
//            inputDescricaoDespesa.name = nameDescricaoDespesa;
//
//            //criação do input controlador para ver se é manual ou por tipo de despesa
//            var inputManualOuTipoDespesa = document.createElement("input");
//
//            //seta type, valor e id
//            inputManualOuTipoDespesa.type = "hidden";
//            inputManualOuTipoDespesa.value = 1; //id de despesa
//            inputManualOuTipoDespesa.id = "manualOuTipoDespesa" + jsCountDespesa;
//
//            //seta o nome
//            var nameManualOuTipoDespesa = "manualOuTipoDespesa" + jsCountDespesa;
//            inputManualOuTipoDespesa.name = nameManualOuTipoDespesa;
//
//        }
//        //cria input do valor
//        var inputValorDespesa = document.createElement("input");
//        //seta type, valor e id
//        inputValorDespesa.type = "hidden";
//        inputValorDespesa.value = valorDespesa;
//        inputValorDespesa.id = "valorDespesa" + jsCountDespesa;
//
//        //seta o nome
//        var nameValorDespesa = "valorDespesa" + jsCountDespesa;
//        inputValorDespesa.name = nameValorDespesa;
//
//        //cria input do valor
//        var inputDespesaPaga = document.createElement("input");
//        //seta type, valor e id        
//        inputDespesaPaga.type = "hidden";
//        inputDespesaPaga.value = despesaPaga;
//        inputDespesaPaga.id = "despesaPaga" + jsCountDespesa;
//
//        //seta o nome
//        var nameDespesaPaga = "despesaPaga" + jsCountDespesa;
//        inputDespesaPaga.name = nameDespesaPaga;
//
//        //cria input da forma de pagamento
//        var inputFormaDePagamentoDespesa = document.createElement("input");
//        //seta type, valor e id
//        inputFormaDePagamentoDespesa.type = "hidden";
//        inputFormaDePagamentoDespesa.value = idFormaDePagamento;
//        inputFormaDePagamentoDespesa.id = "formaPagamentoDespesa" + jsCountDespesa;
//
//        //seta o nome
//        var nameFormaDePagamentoDespesa = "formaPagamentoDespesa" + jsCountDespesa;
//        inputFormaDePagamentoDespesa.name = nameFormaDePagamentoDespesa;        
//        
//        //pegando o form de comunição com o back-end e setando nele controladores(inputs) criados
//        formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
//        formSelecionarCliente = document.querySelector('#listarOpcoes');
//        
//        if (descricaoDespesa !== "") {
//            formCadastrarFesta.appendChild(inputDescricaoDespesa);
//            formSelecionarCliente.appendChild(inputDescricaoDespesa);
//        } else {
//            formCadastrarFesta.appendChild(inputIdTipoDespesa);
//            formSelecionarCliente.appendChild(inputIdTipoDespesa);
//        }
//        formCadastrarFesta.appendChild(inputManualOuTipoDespesa);
//        formCadastrarFesta.appendChild(inputValorDespesa);
//        formCadastrarFesta.appendChild(inputFormaDePagamentoDespesa);
//        formCadastrarFesta.appendChild(inputDespesaPaga);
//        
//        formSelecionarCliente.appendChild(inputManualOuTipoDespesa);
//        formSelecionarCliente.appendChild(inputValorDespesa);
//        formSelecionarCliente.appendChild(inputFormaDePagamentoDespesa);
//        formSelecionarCliente.appendChild(inputDespesaPaga);
//               
//        //FIM CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS ANIVERSARIANTES ADD
//
//        //seta no controler hidden o valor das vezes que foi add aniversariante
//        document.getElementById('countDespesaFesta').value = jsCountDespesa;

        //limpa os valores do input
        form.jsDescricaoDespesa.value = "";
        form.jsTipoDespesa.value = "";
        form.jsFormaPagamentoDespesa.value = "";
        form.jsValorDepesa.value = "";


});

//evento do horario
btnAddHorario.addEventListener("click", function (event) {
    event.preventDefault();

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

                //cria um elento inpunt <p>
                var paragrafoHorario = document.createElement("p");

                //define os atributos desse elemento
                paragrafoHorario.id = "pHorario"+countHorarios;

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

            //cria um elento inpunt <p>
            var paragrafoHorario = document.createElement("p");
    
            //define os atributos desse elemento
            paragrafoHorario.id = "pHorario"+countHorarios;
            
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