/* 
 * Arquivo JS utilizado para cadastro de festa, cujo sua função é a criação e remoção de inputs dinamicos
 */

//var dos funcionarios
var jsCountFuncionario = 0;
var jsCountFuncionario2 = 0;

//var das pacotes adicionais
var jsCountPacotesAdicionais = 0;
var jsCountPacotesAdicionais2 = 0;

//recebendo em uma variavel o botão de + 
var btnAddFuncionario = document.querySelector("#add-funcionario");
var btnAddPacotesAdicionais = document.querySelector("#add-pacoteAdicional");

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
//            jsCountFuncionario2--; //toda vez que remove diminui
//
//            //pega o id da tr e remove
//            document.getElementById(funcionarioTr.id).remove();
//
//            //pega os controladores da despesa e remove tbm
//            document.getElementById(inputIdFuncionario.id).remove();
//            document.getElementById(inputCacheFuncionario.id).remove();
//            document.getElementById(inputIdFormaDePagamentoFuncionario.id).remove();
//
//            if (jsCountFuncionario2 == 0) { //se for igual a zero
//                //desabilita a div da tabela
//                document.getElementById('tabelaFuncionario').style.display = 'none';
//                document.getElementById('countFuncionario').value = jsCountFuncionario2;
//            }
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

//        //COMEÇO DA CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS DOS FUNCIONAIROS ADD
//        //cria um controlador(input) para as funcionario toda vez que adiciona uma funcionario
//        var inputIdFuncionario = document.createElement("input");
//        var inputCacheFuncionario = document.createElement("input");
//        var inputIdFormaDePagamentoFuncionario = document.createElement("input");
//
//        //seta como tipo hidden os controladores(inputs) criados para funcionario
//        inputIdFuncionario.type = "hidden";
//        inputCacheFuncionario.type = "hidden";
//        inputIdFormaDePagamentoFuncionario.type = "hidden";
//
//        //setando os valores digitos pelo usuário, nos values dos controladores
//        inputIdFuncionario.value = idFuncionario;
//        inputCacheFuncionario.value = cache;
//        inputIdFormaDePagamentoFuncionario.value = idFormaDePagamento;
//
//        //variavel que vai ser o nome dos controladores(inputs) , recebe uma string + o valor da variavel jsCountFuncionario
//        var nameIdFuncionario = "idFuncionario" + jsCountFuncionario;
//        var nameCacheFuncionario = "cacheFuncionario" + jsCountFuncionario;
//        var nameIdFormaDePagamentoFuncionario = "idFormaDePagamentoFuncionario" + jsCountFuncionario;
//
//        //seta no name dos controladores(input) o valor das variaveis
//        inputIdFuncionario.name = nameIdFuncionario;
//        inputCacheFuncionario.name = nameCacheFuncionario;
//        inputIdFormaDePagamentoFuncionario.name = nameIdFormaDePagamentoFuncionario;
//
//        //setando id para os controladores(inputs)
//        inputIdFuncionario.id = "idFuncionario" + jsCountFuncionario;
//        inputCacheFuncionario.id = "cacheFuncionario" + jsCountFuncionario;
//        inputIdFormaDePagamentoFuncionario.id = "idFormaDePagamentoFuncionario" + jsCountFuncionario;
//
//        //pegando o form de comunição com o back-end e setando nele controladores(inputs) criados
//        formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
//        formCadastrarFesta.appendChild(inputIdFuncionario);
//        formCadastrarFesta.appendChild(inputCacheFuncionario);
//        formCadastrarFesta.appendChild(inputIdFormaDePagamentoFuncionario);
//        //FIM CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS DESPESAS ADD
//
//        //seta no controler hidden o valor das vezes que foi add despesa
//        document.getElementById('countFuncionario').value = jsCountFuncionario;

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
//            jsCountPacotesAdicionais2--; //toda vez que remove diminui
//
//            //pega o id da tr e remove
//            document.getElementById(pacotesAdicionaisTr.id).remove();
//
//            //pega os controladores da despesa e remove tbm
//            document.getElementById(inputIdPacoteAdicional.id).remove();
//            document.getElementById(inputValorPacoteAdicional.id).remove();
//
//            if (jsCountPacotesAdicionais2 == 0) { //se for igual a zero
//                //desabilita a div da tabela
//                document.getElementById('tabelaPacoteAdicional').style.display = 'none';
//                document.getElementById('countPacotesAdicionais').value = 0;
//                document.getElementById('temPacotesAdicionais').value = 0;
//            }
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

//        //COMEÇO DA CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DOS PACOTES ADICIONAIS ADD
//        //cria um controlador(input) para as pacotes adicionais toda vez que adiciona uma pacotes adicionais
//        var inputIdPacoteAdicional = document.createElement("input");
//        var inputValorPacoteAdicional = document.createElement("input");
//
//        //seta como tipo hidden os controladores(inputs) criados para pacotes adicionais
//        inputIdPacoteAdicional.type = "hidden";
//        inputValorPacoteAdicional.type = "hidden";
//
//        //setando os valores digitos pelo usuário, nos values dos controladores
//        inputIdPacoteAdicional.value = idTipoPacoteAdicional;
//        inputValorPacoteAdicional.value = valorPacoteAdicional;
//
//        //variavel que vai ser o nome dos controladores(inputs) , recebe uma string + o valor da variavel jsCountPacotesAdicionais
//        var nameIdPacoteAdicional = "idPacoteAdicional" + jsCountPacotesAdicionais;
//        var nameValorPacoteAdicional = "valorPacoteAdicional" + jsCountPacotesAdicionais;
//
//        //seta no name dos controladores(input) o valor das variaveis
//        inputIdPacoteAdicional.name = nameIdPacoteAdicional;
//        inputValorPacoteAdicional.name = nameValorPacoteAdicional;
//
//        //setando id para os controladores(inputs)
//        inputIdPacoteAdicional.id = "idPacoteAdicional" + jsCountPacotesAdicionais;
//        inputValorPacoteAdicional.id = "valorPacoteAdicional" + jsCountPacotesAdicionais;
//
//        //pegando o form de comunição com o back-end e setando nele controladores(inputs) criados
//        formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
//        formCadastrarFesta.appendChild(inputIdPacoteAdicional);
//        formCadastrarFesta.appendChild(inputValorPacoteAdicional);
//        //FIM CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS DESPESAS ADD
//
//        //seta no controler hidden o valor das vezes que foi add despesa
//        document.getElementById('countPacotesAdicionais').value = jsCountPacotesAdicionais;

        //limpa os valores do input
        form.jsPacotesAdicionais.value = "";
        form.jsValorPacoteAdicional.value = "";

});