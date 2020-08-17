/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//variaveis globais

//variavel global para contar a quantidade de despesas cadastradas
var jsCountDespesa = 0;
var jsCountDespesa2 = 0;


var controllerTipoCadastroDespesa = document.getElementById('controllerTipoCadastroDespesa').value;
if (controllerTipoCadastroDespesa == 1) {

    var valorOptionTipoDespesa = document.getElementById('valorOptionTipoDespesa').value;

    //separa o id e o nome da despesa
    //cria as variavel necessaria
    var idTipoDeDespesa = 0;
    var nomeDespesa = "";
    var countResultado = 0;

    //recebe o id + o nome e usa a função split para separar e coloca em uma lista
    resultado = valorOptionTipoDespesa.split("+");

    //percorre essa lista
    resultado.forEach((valorAtual) => {
        countResultado++;
        //se é a primeira vez que passa na lista, pega o id e adiciona na variavel idTipoDeDespesa
        if (countResultado == 1) {
            idTipoDeDespesa = valorAtual;
        } else {//se não é , pega o nome e adiciona na variavel atual
            nomeDespesa = valorAtual;
            countResultado = 0;
        }
    });

    document.getElementById('optionTipoDespesa').value = idTipoDeDespesa;
    document.getElementById('optionTipoDespesa').innerHTML = nomeDespesa;

    document.getElementById('tipoDespesa').style.display = '';  //habilita tipo de despesa               
    document.getElementById('descricaoDespesa').style.display = 'none';  //desabilita descrição manual   

    //chama função que monta a table pela primeira vez e que calcula valor final
    montaInputEaddTableStringValores(document.getElementById('listaPagamentoDespesasDetalheString').value);
    calculaValoresFinaisDespesa(0, 0, 0);


} else {

    document.getElementById('descricaoDespesa').style.display = '';  // habilita descrição manual            
    document.getElementById('tipoDespesa').style.display = 'none';  //desabilita tipo de despesa     

    //chama função que monta a table pela primeira vez e que calcula valor final
    montaInputEaddTableStringValores(document.getElementById('listaPagamentoDespesasDetalheString').value);
    calculaValoresFinaisDespesa(0, 0, 0);

}

//função para adicionar despesas dinamicamentes
var botaoAdicionar = document.querySelector("#add-despesa");
botaoAdicionar.addEventListener("click", function (event) {
    event.preventDefault();

    //pega os inputs para adicionar
    var valorDaDespesa = document.querySelector("#jsValorDepesa").value;
    var formaDePagamento = document.querySelector("#jsFormaPagamento").value;
    var dataDePagamento = document.querySelector("#jsDataPagamento").value;
    var despesaPaga = document.querySelector("#jsDespesaPaga").value;
    if(despesaPaga == "Sim"){
        despesaPaga = 1;
    }else{
        despesaPaga = 0;
    }
    
    if(valorDaDespesa !== "" && formaDePagamento !== "" && dataDePagamento !== ""){
        
        document.getElementById('divTabelaDespesa').style.display = '';
        
        var stringConcatenaDespesaAdd = valorDaDespesa + "," + formaDePagamento + "," +  dataDePagamento + "," +  despesaPaga;
        
        //chama a função que add na table e cria os inputs
        montaInputEaddTableStringValores(stringConcatenaDespesaAdd);
        calculaValoresFinaisDespesa(valorDaDespesa, despesaPaga, 0);
        
        //desabilita a div da msg de validação
        document.getElementById('divMsgValidacao').style.display = 'none';
        document.getElementById('msgTratamentoAddDespesa').innerHTML = "";
                
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

//aqui recebo uma string concatenada e transformo ela nos inputs
function montaInputEaddTableStringValores(string) {

    resultado = string.split("|");

    //percorre essa lista
    resultado.forEach((valorAtual) => {


        if (valorAtual !== "") {

            resultado2 = valorAtual.split(",");

            //toda vez que add, vai somar 1 no count para saber quantas despesas foram adicionadas
            jsCountDespesa++;
            
            document.getElementById('countDespesa').value = jsCountDespesa; 
            
            jsCountDespesa2++;

            var despesasTr = document.createElement("tr");
            despesasTr.id = "tdDespesas" + jsCountDespesa;
            
            var inputDespesaValor = "";
            var inputDespesaFP = "";
            var inputDespesaData = "";
            var inputDespesaIsPago = "";

            var count = 0;
            resultado2.forEach((valorAtual2) => {

                //pegando o form de comunição com o back-end e setando nele controladores(inputs) criados
                formCadastrarDespesa = document.querySelector('#cadastrarDespesaForm');
                
                
                switch (count) {
                    
                    case 0: //valor

                        var valorTd = document.createElement("td");
                        valorTd.classList.add("valorTd");
                        valorTd.textContent = "R$ " + valorAtual2;
                        despesasTr.appendChild(valorTd);

                        inputDespesaValor = document.createElement("input");
                        inputDespesaValor.type = "hidden";
                        inputDespesaValor.value = valorAtual2;
                        inputDespesaValor.name = "valorDespesa" + jsCountDespesa;
                        inputDespesaValor.id = "idDespesaValor" + jsCountDespesa;
                        formCadastrarDespesa.appendChild(inputDespesaValor);

                        count++;
                        break;

                    case 1: //forma pagamento

                        resultado3 = valorAtual2.split("+");

                        countFP = 0;
                        resultado3.forEach((valorAtual3) => {
                            countFP++;
                            if(countFP == 1){
                                inputDespesaFP = document.createElement("input");
                                inputDespesaFP.type = "hidden";
                                inputDespesaFP.value = valorAtual3;
                                inputDespesaFP.name = "idFormaPagamento" + jsCountDespesa;
                                inputDespesaFP.id = "idFormaPagamento" + jsCountDespesa;
                                formCadastrarDespesa.appendChild(inputDespesaFP);                                
                            }
                            
                            if (countFP == 2) {
                                var formaDePagamentoTd = document.createElement("td");
                                formaDePagamentoTd.textContent = valorAtual3;
                                despesasTr.appendChild(formaDePagamentoTd);
                            }
                        });

                        count++;
                        break;

                    case 2: //data pagamento

                        var dataTd = document.createElement("td");
                        dataTd.textContent = valorAtual2;
                        despesasTr.appendChild(dataTd);
                        
                        inputDespesaData = document.createElement("input");
                        inputDespesaData.type = "hidden";        
                        inputDespesaData.value = valorAtual2;        
                        inputDespesaData.name = "dataDespesa" + jsCountDespesa;        
                        inputDespesaData.id = "idDespesaData" + jsCountDespesa;
                        formCadastrarDespesa.appendChild(inputDespesaData);

                        count++;
                        break;

                    case 3: //pago?

                        inputDespesaIsPago = document.createElement("input");
                        inputDespesaIsPago.type = "hidden";
                        inputDespesaIsPago.name = "despesaIsPago" + jsCountDespesa;
                        inputDespesaIsPago.id = "idDespesaIsPago" + jsCountDespesa;
                        formCadastrarDespesa.appendChild(inputDespesaIsPago);                            
                        
                        var isPagoTd = document.createElement("td");

                        if (valorAtual2 == 1) {

                            isPagoTd.textContent = "Sim";
                            inputDespesaIsPago.value = "Sim";

                        } else {

                            isPagoTd.textContent = "Não";
                            inputDespesaIsPago.value = "Não";

                        }

                        despesasTr.appendChild(isPagoTd);

                        //aqui monta a despesa
                        var removerDespesaTd = document.createElement("td");

                        //criando elemento button para remover 
                        var removerDespesaBotao = document.createElement("button");
                        removerDespesaBotao.textContent = "Remover";
                        removerDespesaBotao.type = "button";
                        removerDespesaBotao.id = "idRemoverDespesaBotao";
                        removerDespesaBotao.classList.add("btn", "btn-info");
                        removerDespesaBotao.name = "nameRemoverDespesaBotao" + jsCountDespesa;

                        //criando função onclik para remover a despesa adicionada
                        removerDespesaBotao.onclick = function () {
                            jsCountDespesa2--; //toda vez que remove diminui
                            
                            //COMEÇO PARTE QUE PEGA O VALOR E RECALCULA
                            //pega a tr inteira da despesa deletada
                            var trDespesaDeletada = document.getElementById(despesasTr.id);
                            //pega a td do valor e dps pega o valor
                            var tdValor = trDespesaDeletada.querySelector('.valorTd');
                            var valorDeletado = tdValor.textContent;
                            
                            valorDeletado = valorDeletado.substring(3);
                            //chama função que recalcula o valor
                            calculaValoresFinaisDespesa(parseFloat(valorDeletado),valorAtual2, 1);
                            //FIM PARTE QUE PEGA O VALOR E RECALCULA
                            
                            //pega o id da tr e remove
                            document.getElementById(despesasTr.id).remove();

                            //pega os controladores da despesa e remove tbm
                            document.getElementById(inputDespesaValor.id).remove();
                            document.getElementById(inputDespesaFP.id).remove();
                            document.getElementById(inputDespesaData.id).remove();
                            document.getElementById(inputDespesaIsPago.id).remove();

                            if (jsCountDespesa2 == 0) { //se for igual a zero
                                //desabilita a div da tabela
                                document.getElementById('divTabelaDespesa').style.display = 'none';

                                document.getElementById('countDespesa').value = 0;
                            }

                        };

                        //colocando o botão de remover dentro do td
                        removerDespesaTd.appendChild(removerDespesaBotao);

                        despesasTr.appendChild(removerDespesaTd);

                        count = 0;
                        
                        //pega o elemento table do html através do id e seta nele o TR criado
                        var tabelaDespesa = document.querySelector("#tbodyDespesas");
                        tabelaDespesa.appendChild(despesasTr);

                        break;

                    default:
                        break;
                        
                }

            });
        }

    });

};

//aqui calculo os valores finais da despesa e exibo correto em tela
function calculaValoresFinaisDespesa(valor, pago, operacao) {
    
    //0 é add
    //1 é sub
    
    totalDespesaAtual = document.getElementById('totalDespesa').value;
    valorPagoAtual = document.getElementById('valorPago').value;
    valorApagarAtual = document.getElementById('valorApagar').value;
    
    
    if(operacao == 0){ //adição
        totalDespesaAtual = parseFloat(totalDespesaAtual) + parseFloat(valor);
        totalDespesaAtual = totalDespesaAtual.toFixed(2);
        
        if (pago == 0) {

            valorApagarAtual = parseFloat(valorApagarAtual) + parseFloat(valor);
            valorApagarAtual = valorApagarAtual.toFixed(2);

        } else {

            valorPagoAtual = parseFloat(valorPagoAtual) + parseFloat(valor);
            valorPagoAtual = valorPagoAtual.toFixed(2);

        }        
    }
    
    if(operacao == 1){ //subtração
        totalDespesaAtual = parseFloat(totalDespesaAtual) - parseFloat(valor);
        totalDespesaAtual = totalDespesaAtual.toFixed(2);   
        
        if (pago == 0) {

            valorApagarAtual = parseFloat(valorApagarAtual) - parseFloat(valor);
            valorApagarAtual = valorApagarAtual.toFixed(2);

        } else {

            valorPagoAtual = parseFloat(valorPagoAtual) - parseFloat(valor);
            valorPagoAtual = valorPagoAtual.toFixed(2);
            
        }           
    }

    //define valor atual do input controller
    document.getElementById('totalDespesa').value = totalDespesaAtual;
    document.getElementById('valorPago').value = valorPagoAtual;
    document.getElementById('valorApagar').value = valorApagarAtual;

    //coloca em tela os valores
    document.getElementById('valorTotalDespesa').innerHTML = "Total da Despesa: R$ " + totalDespesaAtual;
    document.getElementById('valorPagoDespesa').innerHTML = "Valor Pago: R$ " + valorPagoAtual;
    document.getElementById('valorApagarDespesa').innerHTML = "Valor a Pagar: R$ " + valorApagarAtual;

};

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
