/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//verifica se foi cadastro e se for desoculta a div da msg de confirmação
var msgConfirmacao = document.getElementById('msgConfirmacaoCadastro').value;
if(msgConfirmacao == 1){
    //desoculta a div
    document.getElementById('divMsgConfirmacaoCadastro').style.display = "";
}

//variavel global para contar a quantidade de despesas cadastradas
var jsCountDespesa = 0;
var jsCountDespesa2 = 0; 

//variavel global que controla os valores da despesa
var valorTotalDespesa = 0;
var valorPagoDespesa = 0;
var valorApagarDespesa = 0;

//função para adicionar despesas dinamicamentes
var botaoAdicionar = document.querySelector("#add-despesa");
botaoAdicionar.addEventListener("click", function (event) {
    event.preventDefault();

    //pega os inputs para adicionar
    var valorDaDespesa = document.querySelector("#jsValorDepesa").value;
    var formaDePagamento = document.querySelector("#jsFormaPagamento").value;
    var dataDePagamento = document.querySelector("#jsDataPagamento").value;
    var despesaPaga = document.querySelector("#jsDespesaPaga").value;
    
    if(valorDaDespesa !== "" && formaDePagamento !== "" && dataDePagamento !== ""){
        
        //toda vez que add, vai somar 1 no count para saber quantas despesas foram adicionadas
        jsCountDespesa++;
        jsCountDespesa2++;
        
        //calcula os valores totais de exibição
        valorTotalDespesa = parseFloat(valorTotalDespesa) + parseFloat(valorDaDespesa);
        
        if(despesaPaga == "Sim"){
            valorPagoDespesa = parseFloat(valorPagoDespesa) + parseFloat(valorDaDespesa);
        }else{
            valorApagarDespesa = parseFloat(valorApagarDespesa) + parseFloat(valorDaDespesa);
        }
        
        //atribuindo os valores calculados no campo de exibção
        document.getElementById('valorTotalDespesa').innerHTML = "Total da Despesa: R$ " + valorTotalDespesa;
        document.getElementById('valorPagoDespesa').innerHTML = "Valor Pago: R$ " + valorPagoDespesa;
        document.getElementById('valorApagarDespesa').innerHTML = "Valor a Pagar: R$ " + valorApagarDespesa;

        //separa o id e o nome do pagamento selecionado
        //cria as variavel necessaria
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
        document.getElementById('divTabelaDespesa').style.display = '';
        
        //desabilita a div da msg de validação
        document.getElementById('divMsgValidacao').style.display = 'none';
        
        //cria um elemento do tipo TR e salva ele em uma variavel
        var despesasTr = document.createElement("tr");
        despesasTr.id = "tdDespesas" + jsCountDespesa;

        //cria elementos do tipo TD e salva eles em uma variavel
        var valorTd = document.createElement("td");
        var formaDePagamentoTd = document.createElement("td");
        var dataTd = document.createElement("td");
        var isPagoTd = document.createElement("td");
        var removerDespesaTd = document.createElement("td");

        //criando elemento button para remover 
        var removerDespesaBotao = document.createElement("button");

        removerDespesaBotao.textContent = "Remover";
        removerDespesaBotao.type = "button";
        removerDespesaBotao.id = "idRemoverDespesaBotao";
        removerDespesaBotao.classList.add("btn", "btn-info");
        removerDespesaBotao.name = "nameRemoverDespesaBotao" + jsCountDespesa;

        //criando função on clik para remover a despesa adicionada
        removerDespesaBotao.onclick = function () {
            jsCountDespesa2--; //toda vez que remove diminui
            
            //calcula os valores totais de exibição
            valorTotalDespesa = parseFloat(valorTotalDespesa) - parseFloat(valorDaDespesa);

            if(despesaPaga == "Sim"){
                valorPagoDespesa = parseFloat(valorPagoDespesa) - parseFloat(valorDaDespesa);
            }else{
                valorApagarDespesa = parseFloat(valorApagarDespesa) - parseFloat(valorDaDespesa);
            }

            //atribuindo os valores calculados no campo de exibção
            document.getElementById('valorTotalDespesa').innerHTML = "Total da Despesa: R$ " + valorTotalDespesa;
            document.getElementById('valorPagoDespesa').innerHTML = "Valor Pago: R$ " + valorPagoDespesa;
            document.getElementById('valorApagarDespesa').innerHTML = "Valor a Pagar: R$ " + valorApagarDespesa;

            //pega o id da tr e remove
            document.getElementById(despesasTr.id).remove();
            
            //pega os controladores da despesa e remove tbm
            document.getElementById(inputDespesaValor.id).remove();
            document.getElementById(inputDespesaFP.id).remove();
            document.getElementById(inputDespesaData.id).remove();
            document.getElementById(inputDespesaIsPago.id).remove();

            if(jsCountDespesa2 == 0){ //se for igual a zero
                //desabilita a div da tabela
                document.getElementById('divTabelaDespesa').style.display = 'none';  
                
                document.getElementById('countDespesa').value = 0;
            }
            
        };

        //colocando o botão de remover dentro do td
        removerDespesaTd.appendChild(removerDespesaBotao);

        //seta o texto das td com os valores das variaveis que receberam os valores dos inputs do form
        valorTd.textContent = "R$ " + valorDaDespesa;
        formaDePagamentoTd.textContent = nomePagamento;
        dataTd.textContent = dataDePagamento;
        isPagoTd.textContent = despesaPaga;

        //coloca os TDS criados que estão com os valores do form dentro do TR
        despesasTr.appendChild(valorTd);
        despesasTr.appendChild(formaDePagamentoTd);
        despesasTr.appendChild(dataTd);
        despesasTr.appendChild(isPagoTd);
        despesasTr.appendChild(removerDespesaTd);

        //pega o elemento table do html através do id e seta nele o TR criado
        var tabelaDespesa = document.querySelector("#tbodyDespesas");
        tabelaDespesa.appendChild(despesasTr);

        //COMEÇO DA CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS DESPESAS ADD
        //cria um controlador(input) para as despesa toda vez que adiciona uma despesa
        var inputDespesaValor = document.createElement("input");
        var inputDespesaFP = document.createElement("input");
        var inputDespesaData = document.createElement("input");
        var inputDespesaIsPago = document.createElement("input");

        //seta como tipo hidden os controladores(inputs) criados para despesas
        inputDespesaValor.type = "hidden";
        inputDespesaFP.type = "hidden";
        inputDespesaData.type = "hidden";
        inputDespesaIsPago.type = "hidden";

        //setando os valores digitos pelo usuário, nos values dos controladores
        inputDespesaValor.value = valorDaDespesa;
        inputDespesaFP.value = idFormaDePagamento;
        inputDespesaData.value = dataDePagamento;
        inputDespesaIsPago.value = despesaPaga;

        //seta no name dos controladores(input)
        inputDespesaValor.name = "valorDespesa" + jsCountDespesa;
        inputDespesaFP.name = "idFormaPagamento" + jsCountDespesa;
        inputDespesaData.name = "dataDespesa" + jsCountDespesa;
        inputDespesaIsPago.name = "despesaIsPago" + jsCountDespesa;

        //setando id para os controladores(inputs)
        inputDespesaValor.id = "idDespesaValor" + jsCountDespesa;
        inputDespesaFP.id = "idFormaPagamento" + jsCountDespesa;
        inputDespesaData.id = "idDespesaData" + jsCountDespesa;
        inputDespesaIsPago.id = "idDespesaIsPago" + jsCountDespesa;

        //pegando o form de comunição com o back-end e setando nele controladores(inputs) criados
        formCadastrarDespesa = document.querySelector('#cadastrarDespesaForm');
        formCadastrarDespesa.appendChild(inputDespesaValor);
        formCadastrarDespesa.appendChild(inputDespesaFP);
        formCadastrarDespesa.appendChild(inputDespesaData);
        formCadastrarDespesa.appendChild(inputDespesaIsPago);
        //FIM CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS DESPESAS ADD

        //seta no controler hidden o valor das vezes que foi add despesa
        document.getElementById('countDespesa').value = jsCountDespesa;

        //limpa os valores do input
        document.getElementById('jsValorDepesa').value = "";
        document.getElementById('jsFormaPagamento').value = "";
        document.getElementById('jsDataPagamento').value = "";

    }else{
            
        //desabilita a div da msg de validação
        document.getElementById('divMsgValidacao').style.display = '';
        
        var stringValidacaoAddDespesa =  "";

        if(valorDaDespesa == ""){

            stringValidacaoAddDespesa = stringValidacaoAddDespesa + "Campo \"Valor da Despesa\" é obrigatório! <br>";

        }

        if(formaDePagamento == ""){

            stringValidacaoAddDespesa = stringValidacaoAddDespesa + "Campo \"Forma de Pagamento\" é obrigatório! <br>";

        }

        if(dataDePagamento == ""){

            stringValidacaoAddDespesa = stringValidacaoAddDespesa + "Campo \"Data de pagamento\" é obrigatório! <br>";

        }

        document.getElementById('msgTratamentoAddDespesa').innerHTML = stringValidacaoAddDespesa;
    }

});

//função para definir opção de cadastro
function tipoDespesaManual() {
    document.getElementById('descricaoDespesa').style.display = '';  // habilita descrição manual            
    document.getElementById('tipoDespesa').style.display = 'none';  //desabilita tipo de despesa                
};

//função para definir opção de cadastro
function tipoDespesa() {
    document.getElementById('tipoDespesa').style.display = '';  //habilita tipo de despesa               
    document.getElementById('descricaoDespesa').style.display = 'none';  //desabilita descrição manual
};
