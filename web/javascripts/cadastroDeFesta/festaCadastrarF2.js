/* 
 * Arquivo JS utilizado para cadastro de festa, cujo sua função é a criação e remoção de inputs dinamicos
 */

//var dos funcionarios
var jsCountFuncionario = 0;
var jsCountFuncionario2 = 0;

//var das pacotes adicionais
var jsCountPacotesAdicionais = 0;
var jsCountPacotesAdicionais2 = 0;

//var do valor adicional
var jsCountValorAdicional = 0;
var jsCountValorAdicional2 = 0;

//var das despesas
var jsCountDespesa = 0;
var jsCountDespesa2 = 0;

//var dos horarios
var jsCountHorario = 0;
var jsCountHorario2 = 0;

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
//            jsCountValorAdicional2--; //toda vez que remove diminui
//
//            //pega o id da tr e remove
//            document.getElementById(valorAdicionalTr.id).remove();
//
//            //pega os controladores da despesa e remove tbm
//            document.getElementById(inputValorAdicional.id).remove();
//            document.getElementById(inputDescricaoValorAdicional.id).remove();
//
//            if (jsCountValorAdicional2 == 0) { //se for igual a zero
//                //desabilita a div da tabela
//                document.getElementById('tabelaValorAdicional').style.display = 'none';
//                document.getElementById('countValorAdicional').value = 0;
//                document.getElementById('temValorAdicional').value = 0;
//            }
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

//        //COMEÇO DA CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS VALOR ADICIONAL ADD
//        //cria um controlador(input) para as valor adicional toda vez que adiciona um valor adicional
//        var inputValorAdicional = document.createElement("input");
//        var inputDescricaoValorAdicional = document.createElement("input");
//
//        //seta como tipo hidden os controladores(inputs) criados para valor adicional
//        inputValorAdicional.type = "hidden";
//        inputDescricaoValorAdicional.type = "hidden";
//
//        //setando os valores digitos pelo usuário, nos values dos controladores
//        inputValorAdicional.value = valorAdicional;
//        inputDescricaoValorAdicional.value = descricaoValorAdicional;
//
//        //variavel que vai ser o nome dos controladores(inputs) , recebe uma string + o valor da variavel jsCountValorAdicional
//        var nameValorAdicional = "valorAdicional" + jsCountValorAdicional;
//        var nameDescricaoValorAdicional = "descricaoValorAdicional" + jsCountValorAdicional;
//
//        //seta no name dos controladores(input) o valor das variaveis
//        inputValorAdicional.name = nameValorAdicional;
//        inputDescricaoValorAdicional.name = nameDescricaoValorAdicional;
//
//        //setando id para os controladores(inputs)
//        inputValorAdicional.id = "valorAdicional" + jsCountValorAdicional;
//        inputDescricaoValorAdicional.id = "descricaoValorAdicional" + jsCountValorAdicional;
//
//        //pegando o form de comunição com o back-end e setando nele controladores(inputs) criados
//        formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
//        formCadastrarFesta.appendChild(inputValorAdicional);
//        formCadastrarFesta.appendChild(inputDescricaoValorAdicional);
//        //FIM CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS DESPESAS ADD
//
//        //seta no controler hidden o valor das vezes que foi add despesa
//        document.getElementById('countValorAdicional').value = jsCountValorAdicional;

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
//            jsCountHorario2--; //toda vez que remove diminui
//
//            //pega o id da tr e remove
//            document.getElementById(horarioTr.id).remove();
//
//            //pega os controladores da despesa e remove tbm
//            document.getElementById(inputHorario.id).remove();
//            document.getElementById(inputHorarioDescricao.id).remove();
//
//            if (jsCountHorario2 == 0) { //se for igual a zero
//                //desabilita a div da tabela
//                document.getElementById('tabelaHorario').style.display = 'none';
//                document.getElementById('countHorario').value = jsCountHorario2;
//            }
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

//        //COMEÇO DA CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS HORARIOS ADD
//        //cria um controlador(input) para as despesa toda vez que adiciona um horario
//        var inputHorario = document.createElement("input");
//        var inputHorarioDescricao = document.createElement("input");
//
//        //seta como tipo hidden os controladores(inputs) criados para horario
//        inputHorario.type = "hidden";
//        inputHorarioDescricao.type = "hidden";
//
//        //setando os valores digitos pelo usuário, nos values dos controladores
//        inputHorario.value = horario;
//        inputHorarioDescricao.value = descricaoHorario;
//
//        //variavel que vai ser o nome dos controladores(inputs) , recebe uma string + o valor da variavel jsCountHorario
//        var nameHorario = "horario" + jsCountHorario;
//        var nameHorarioDescricao = "horarioDesricao" + jsCountHorario;
//
//        //seta no name dos controladores(input) o valor das variaveis
//        inputHorario.name = nameHorario;
//        inputHorarioDescricao.name = nameHorarioDescricao;
//
//        //setando id para os controladores(inputs)
//        inputHorario.id = "horario" + jsCountHorario;
//        inputHorarioDescricao.id = "horarioDesricao" + jsCountHorario;
//
//        //pegando o form de comunição com o back-end e setando nele controladores(inputs) criados
//        formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
//        formCadastrarFesta.appendChild(inputHorario);
//        formCadastrarFesta.appendChild(inputHorarioDescricao);
//        //FIM CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS DESPESAS ADD
//
//        //seta no controler hidden o valor das vezes que foi add despesa
//        document.getElementById('countHorario').value = jsCountHorario;

        //limpa os valores do input
        form.jsHorario.value = "";
        form.jsDescricaoH.value = "";

});