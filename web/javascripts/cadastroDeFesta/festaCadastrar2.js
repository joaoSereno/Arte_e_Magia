/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var dos aniversariantes
var jsAniversariante = 0;
var jsAniversariante2 = 0;

//var dos funcionarios
var jsCountFuncionario = 0;
var jsCountFuncionario2 = 0;

//var dos horarios
var jsCountHorario = 0;
var jsCountHorario2 = 0;

//var do forma de pagamento
var jsCountFormaDePagamento = 0;
var jsCountFormaDePagamento2 = 0;

//var do valor adicional
var jsCountValorAdicional = 0;
var jsCountValorAdicional2 = 0;

//var das pagamento adiantado
var jsCountPagamentoAdiantado = 0;
var jsCountPagamentoAdiantado2 = 0;

//var das pacotes adicionais
var jsCountPacotesAdicionais = 0;
var jsCountPacotesAdicionais2 = 0;

//recebendo em uma variavel o botão de + 
var btnAddAniversariante = document.querySelector("#add-aniversariante");
var btnAddFuncionario = document.querySelector("#add-funcionario");
var btnAddHorario = document.querySelector("#add-horario");
var btnAddFormaDePagamento = document.querySelector("#add-formaPagamento");
var btnAddValorAdicional = document.querySelector("#add-valorAdicional");
var btnAddPagamentoAdiantado = document.querySelector("#add-pagamentoAdiantado");
var btnAddPacotesAdicionais = document.querySelector("#add-pacoteAdicional");

//aqui é os eventos (funções quando clicar no botão + 
//
//evento do aniversariante
btnAddAniversariante.addEventListener("click", function (event) {
    event.preventDefault();

    //pega o controlador para ver se já foi inserido o cliente , caso foi , ai executa a função
    var countCliente = document.getElementById('countCliente').value;
    if (countCliente > 0) {

        //toda vez que add, vai somar 1 no count para saber quantos aniversariante foram adicionados
        jsAniversariante++;
        jsAniversariante2++;

        //pega o elemento form inteiro do html
        var form = document.querySelector("#formAniversariante");

        //mapea todos os inputs pelo nome e salva nas variaveis os valores
        var aniversariante = form.jsAniversariante.value;

        //para os values que são dropsdows e listado dinamicamente
        //cria as variavel
        var idAniversariante = 0;
        var nomeAniversariante = "";
        var countResultado = 0;
        
        //recebe o id + o nome e usa a função split para separar e coloca em uma lista
        resultado = aniversariante.split("+");
        
        //percorre essa lista
        resultado.forEach((valorAtual) => {
            countResultado++;
            //se é a primeira vez que passa na lista, pega o id e adiciona na variavel idAniversariante
            if(countResultado == 1){
                idAniversariante = valorAtual;
            }else{//se não é , pega o nome e adiciona na variavel atual
                nomeAniversariante = valorAtual;
                countResultado = 0;
            }
        });
        
        console.log(idAniversariante);
        console.log(nomeAniversariante);        
    }

});

//evento do funcionario
btnAddFuncionario.addEventListener("click", function (event) {
    event.preventDefault();

    //pega o controlador para ver se já foi inserido o cliente , caso foi , ai executa a função
    var countCliente = document.getElementById('countCliente').value;
    if (countCliente > 0) {

        //toda vez que add, vai somar 1 no count para saber quantos funcionario foram adicionados
        jsCountFuncionario++;
        jsCountFuncionario2++;

        //pega o elemento form inteiro do html
        var form = document.querySelector("#formFuncionario");

        //mapea todos os inputs pelo nome e salva nas variaveis os valores
        var funcionario = form.jsFuncionarios.value;
        var cache = form.jsCache.value;
        
        //para os values que são dropsdows e listado dinamicamente
        //cria as variavel
        var idFuncionario = 0;
        var nomeFuncionario = "";
        var countResultado = 0;
        
        //recebe o id + o nome e usa a função split para separar e coloca em uma lista
        resultado = funcionario.split("+");
        
        //percorre essa lista
        resultado.forEach((valorAtual) => {
            countResultado++;
            //se é a primeira vez que passa na lista, pega o id e adiciona na variavel idFuncionario
            if(countResultado == 1){
                idFuncionario = valorAtual;
            }else{//se não é , pega o nome e adiciona na variavel atual
                nomeFuncionario = valorAtual;
                countResultado = 0;
            }
        });        
        
        console.log(idFuncionario);
        console.log(nomeFuncionario);
        console.log(cache);
    }

});

//evento do horario
btnAddHorario.addEventListener("click", function (event) {
    event.preventDefault();

    //pega o controlador para ver se já foi inserido o cliente , caso foi , ai executa a função
    var countCliente = document.getElementById('countCliente').value;
    if (countCliente > 0) {

        //toda vez que add, vai somar 1 no count para saber quantos horarios foram adicionados
        jsCountHorario++;
        jsCountHorario2++;

        //pega o elemento form inteiro do html
        var form = document.querySelector("#formHorario");

        //mapea todos os inputs pelo nome e salva nas variaveis os valores
        var horario = form.jsHorario.value;
        var descricaoHorario = form.jsDescricaoH.value;;
        
        console.log(horario);
        console.log(descricaoHorario);

    }

});

//evento da fp
btnAddFormaDePagamento.addEventListener("click", function (event) {
    event.preventDefault();

    //pega o controlador para ver se já foi inserido o cliente , caso foi , ai executa a função
    var countCliente = document.getElementById('countCliente').value;
    if (countCliente > 0) {

        //toda vez que add, vai somar 1 no count para saber quantas formas de pagamento foram adicionados
        jsCountFormaDePagamento++;
        jsCountFormaDePagamento2++;

        console.log("MAOE4");
    }

});

//evento do valor adicional
btnAddValorAdicional.addEventListener("click", function (event) {
    event.preventDefault();

    //pega o controlador para ver se já foi inserido o cliente , caso foi , ai executa a função
    var countCliente = document.getElementById('countCliente').value;
    if (countCliente > 0) {

        //toda vez que add, vai somar 1 no count para saber quantos valores adicionais foram adicionados
        jsCountValorAdicional++;
        jsCountValorAdicional2++;

        console.log("MAOE5");
    }

});

//evento do pagamento adiantado
btnAddPagamentoAdiantado.addEventListener("click", function (event) {
    event.preventDefault();

    //pega o controlador para ver se já foi inserido o cliente , caso foi , ai executa a função
    var countCliente = document.getElementById('countCliente').value;
    if (countCliente > 0) {

        //toda vez que add, vai somar 1 no count para saber quantos pagamento adiantados foram adicionados
        jsCountPagamentoAdiantado++;
        jsCountPagamentoAdiantado2++;

        console.log("MAOE6");
    }

});

//evento do pacote adicional
btnAddPacotesAdicionais.addEventListener("click", function (event) {
    event.preventDefault();

    //pega o controlador para ver se já foi inserido o cliente , caso foi , ai executa a função
    var countCliente = document.getElementById('countCliente').value;
    if (countCliente > 0) {

        //toda vez que add, vai somar 1 no count para saber quantos pacotes adicionais foram adicionados
        jsCountPacotesAdicionais++;
        jsCountPacotesAdicionais2++;

        console.log("MAOE7");
    }

});