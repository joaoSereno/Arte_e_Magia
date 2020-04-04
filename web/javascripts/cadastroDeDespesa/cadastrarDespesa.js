/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var jsCountDespesa = 0; //variavel para contar a quantidade de despesas inseridas e vai ser puxado no back-end
var jsCountDespesa2 = 0; //variavel que controla a ocultação da div da tabela de despesas inseridas

var botaoAdicionar = document.querySelector("#add-despesa");
botaoAdicionar.addEventListener("click", function (event) {
    event.preventDefault();

    //toda vez que add, vai somar 1 no count para saber quantas despesas foram adicionadas
    jsCountDespesa++;
    jsCountDespesa2++;

    //pega o elemento form inteiro do html
    var form = document.querySelector("#formAddDespesa");

    //mapea todos os inputs pelo nome e salva nas variaveis os valores
    var valor = form.jsValorDepesa.value;
    var data = form.jsDataPagamento.value;
    var isPago = form.jsDespesaPpaga.value;
    
    //habilita a div da tabela
    document.getElementById('divTabelaDespesa').style.display = 'block';
    
    //cria um elemento do tipo TR e salva ele em uma variavel
    var despesasTr = document.createElement("tr");
    despesasTr.id = "tdDespesas" + jsCountDespesa;

    //cria elementos do tipo TD e salva eles em uma variavel
    var valorTd = document.createElement("td");
    var dataTd = document.createElement("td");
    var isPagoTd = document.createElement("td");
    var removerDespesaTd = document.createElement("td");

    //criando elemento button para remover e colocando ele no td "removerDespesaTd"
    var removerDespesaBotao = document.createElement("button");

    removerDespesaBotao.textContent = "Remover";
    removerDespesaBotao.type = "button";
    removerDespesaBotao.id = "idRemoverDespesaBotao";
    removerDespesaBotao.name = "nameRemoverDespesaBotao" + jsCountDespesa;

    //criando função on clik para remover a despesa adicionada
    removerDespesaBotao.onclick = function () {
        jsCountDespesa2--; //toda vez que remove diminui
        
        //pega o id da tr e remove
        document.getElementById(despesasTr.id).remove();
        //pega os controladores da despesa e remove tbm
        document.getElementById(inputDespesaValor.id).remove();
        document.getElementById(inputDespesaData.id).remove();
        document.getElementById(inputDespesaIsPago.id).remove();
        
        if(jsCountDespesa2 == 0){ //se for igual a zero
            //desabilita a div da tabela
            document.getElementById('divTabelaDespesa').style.display = 'none';            
        }
    };

    //colocando o botão de remover dentro do td
    removerDespesaTd.appendChild(removerDespesaBotao);

    //seta o texto das td com os valores das variaveis que receberam os valores dos inputs do form
    valorTd.textContent = valor;
    dataTd.textContent = data;
    isPagoTd.textContent = isPago;

    //coloca os TDS criados que estão com os valores do form dentro do TR
    despesasTr.appendChild(valorTd);
    despesasTr.appendChild(dataTd);
    despesasTr.appendChild(isPagoTd);
    despesasTr.appendChild(removerDespesaTd);

    //pega o elemento table do html através do id e seta nele o TR criado
    var tabelaDespesa = document.querySelector("#tbodyDespesas");
    tabelaDespesa.appendChild(despesasTr);

    //COMEÇO DA CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS DESPESAS ADD
    //cria um controlador(input) para as despesa toda vez que adiciona uma despesa
    var inputDespesaValor = document.createElement("input");
    var inputDespesaData = document.createElement("input");
    var inputDespesaIsPago = document.createElement("input");

    //seta como tipo hidden os controladores(inputs) criados para despesas
    inputDespesaValor.type = "hidden";
    inputDespesaData.type = "hidden";
    inputDespesaIsPago.type = "hidden";

    //setando os valores digitos pelo usuário, nos values dos controladores
    inputDespesaValor.value = valor;
    inputDespesaData.value = data;
    inputDespesaIsPago.value = isPago;

    //variavel que vai ser o nome dos controladores(inputs) , recebe uma string + o valor da variavel jsCountDespesa
    var nameValorDespesa = "valorDespesa" + jsCountDespesa;
    var nameDataDespesa = "dataDespesa" + jsCountDespesa;
    var nameIsPago = "despesaIsPago" + jsCountDespesa;

    //seta no name dos controladores(input) o valor das variaveis
    inputDespesaValor.name = nameValorDespesa;
    inputDespesaData.name = nameDataDespesa;
    inputDespesaIsPago.name = nameIsPago;

    //setando id para os controladores(inputs)
    inputDespesaValor.id = "idDespesaValor" + jsCountDespesa;
    inputDespesaData.id = "idDespesaData" + jsCountDespesa;
    inputDespesaIsPago.id = "idDespesaIsPago" + jsCountDespesa;

    //pegando o form de comunição com o back-end e setando nele controladores(inputs) criados
    formCadastrarDespesa = document.querySelector('#cadastrarDespesaForm');
    formCadastrarDespesa.appendChild(inputDespesaValor);
    formCadastrarDespesa.appendChild(inputDespesaData);
    formCadastrarDespesa.appendChild(inputDespesaIsPago);
    //FIM CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS DESPESAS ADD

    //seta no controler hidden o valor das vezes que foi add despesa
    document.getElementById('countDespesa').value = jsCountDespesa;

    //limpa os valores do input
    form.jsValorDepesa.value = "";
    form.jsDataPagamento.value = "";
});

