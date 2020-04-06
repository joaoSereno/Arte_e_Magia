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
        var form = document.querySelector("#tabelaAniversariantes");

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
            if (countResultado == 1) {
                idAniversariante = valorAtual;
            } else {//se não é , pega o nome e adiciona na variavel atual
                nomeAniversariante = valorAtual;
                countResultado = 0;
            }
        });

        //habilita a div da tabela
        document.getElementById('divTabelaDespesa').style.display = 'block';

        //cria um elemento do tipo TR e salva ele em uma variavel
        var aniversariantesTr = document.createElement("tr");
        aniversariantesTr.id = "tdAniversariante" + jsAniversariante;

        //cria elementos do tipo TD e salva eles em uma variavel
        var aniversarianteTd = document.createElement("td");
        var removerAniversarianteTd = document.createElement("td");

        //criando elemento button para remover
        var removerAniversarianteBotao = document.createElement("button");

        removerAniversarianteBotao.textContent = "Remover";
        removerAniversarianteBotao.type = "button";
        removerAniversarianteBotao.id = "idRemoverAniversarianteBotao";
        removerAniversarianteBotao.name = "nameRemoverAniversarianteBotao" + jsAniversariante;

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
            if (countResultado == 1) {
                idFuncionario = valorAtual;
            } else {//se não é , pega o nome e adiciona na variavel atual
                nomeFuncionario = valorAtual;
                countResultado = 0;
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
        var removerfuncionarioTd = document.createElement("td");

        //criando elemento button para remover 
        var removerFuncionarioBotao = document.createElement("button");

        removerFuncionarioBotao.textContent = "Remover";
        removerFuncionarioBotao.type = "button";
        removerFuncionarioBotao.id = "idRemoverFuncionarioBotao";
        removerFuncionarioBotao.name = "nameRemoverFuncionarioBotao" + jsCountFuncionario;

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

        //pega o elemento form inteiro do html
        var form = document.querySelector("#formFormaPagamento");

        //mapea todos os inputs pelo nome e salva nas variaveis os valores
        var formaDePagamento = form.jsFormaPagamento.value;

        //para os values que são dropsdows e listado dinamicamente
        //cria as variavel
        var idFormaDePagamento = 0;
        var nomePagamento = "";
        var countResultado = 0;

        //recebe o id + o nome e usa a função split para separar e coloca em uma lista
        resultado = formaDePagamento.split("+");

        //percorre essa lista
        resultado.forEach((valorAtual) => {
            countResultado++;
            //se é a primeira vez que passa na lista, pega o id e adiciona na variavel idFuncionario
            if (countResultado == 1) {
                idFormaDePagamento = valorAtual;
            } else {//se não é , pega o nome e adiciona na variavel atual
                nomePagamento = valorAtual;
                countResultado = 0;
            }
        });
        //habilita a div da tabela
        document.getElementById('tabelaFP').style.display = 'block';

        //cria um elemento do tipo TR e salva ele em uma variavel
        var formaPagamentoTr = document.createElement("tr");
        formaPagamentoTr.id = "tdFormaPagamento" + jsCountFormaDePagamento;

        //cria elementos do tipo TD e salva eles em uma variavel
        var formaPagamentoTd = document.createElement("td");;
        var removerFormaPagamentoTd = document.createElement("td");

        //criando elemento button para remover 
        var removerFormaPagamentoBotao = document.createElement("button");

        removerFormaPagamentoBotao.textContent = "Remover";
        removerFormaPagamentoBotao.type = "button";
        removerFormaPagamentoBotao.id = "idRemoverFormaPagamentoBotao";
        removerFormaPagamentoBotao.name = "nameRemoverFormaPagamentoBotao" + jsCountFormaDePagamento;

        console.log(idFormaDePagamento);
        console.log(nomePagamento);
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
        var valorTd = document.createElement("td");
        var descricaoValorAdicionalTd = document.createElement("td");
        var valorAdicionalTd = document.createElement("td");

        //criando elemento button para remover e colocando ele no td "removerDespesaTd"
        var removerValorAdicionalBotao = document.createElement("button");

        removerValorAdicionalBotao.textContent = "Remover";
        removerValorAdicionalBotao.type = "button";
        removerValorAdicionalBotao.id = "idRemoverValorAdicionalBotao";
        removerValorAdicionalBotao.name = "nameRemoverValorAdicionalBotao" + jsCountValorAdicional;

        console.log(valorAdicional);
        console.log(descricaoValorAdicional);
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

        //pega o elemento form inteiro do html
        var form = document.querySelector("#formPagamentoAdiantado");

        //mapea todos os inputs pelo nome e salva nas variaveis os valores
        var valorPagamentoAdiantado = form.jsValorPagamentoAdiantado.value;
        var formaPagamentoAdiantado = form.jsFormaPagamentoAdiantado.value;

        //para os values que são dropsdows e listado dinamicamente
        //cria as variavel
        var idFormaDePagamento = 0;
        var nomePagamento = "";
        var countResultado = 0;

        //recebe o id + o nome e usa a função split para separar e coloca em uma lista
        resultado = formaPagamentoAdiantado.split("+");

        //percorre essa lista
        resultado.forEach((valorAtual) => {
            countResultado++;
            //se é a primeira vez que passa na lista, pega o id e adiciona na variavel idFuncionario
            if (countResultado == 1) {
                idFormaDePagamento = valorAtual;
            } else {//se não é , pega o nome e adiciona na variavel atual
                nomePagamento = valorAtual;
                countResultado = 0;
            }
        });

        //habilita a div da tabela
        document.getElementById('tabelaPagamentoAdiantado').style.display = 'block';

        //cria um elemento do tipo TR e salva ele em uma variavel
        var pagamentoAdiantadoTr = document.createElement("tr");
        pagamentoAdiantadoTr.id = "tdPagamentoAdiantado" + jsCountPagamentoAdiantado;

        //cria elementos do tipo TD e salva eles em uma variavel
        var valorTd = document.createElement("td");
        var formaPagamentoTd = document.createElement("td");
        var removerPagamentoAdiantadoTd = document.createElement("td");

        //criando elemento button para remover e colocando ele no td "removerDespesaTd"
        var removerPagamentoAdiantadoBotao = document.createElement("button");

        removerPagamentoAdiantadoBotao.textContent = "Remover";
        removerPagamentoAdiantadoBotao.type = "button";
        removerPagamentoAdiantadoBotao.id = "idRemoverPagamentoAdiantadoBotao";
        removerPagamentoAdiantadoBotao.name = "nameRemoverPagamentoAdiantadoBotao" + jsCountPagamentoAdiantado;

        console.log(valorPagamentoAdiantado);
        console.log(idFormaDePagamento);
        console.log(nomePagamento);

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

        console.log(idTipoPacoteAdicional);
        console.log(descricaoPacoteAdd);
        console.log(valorPacoteAdicional);
    }

});