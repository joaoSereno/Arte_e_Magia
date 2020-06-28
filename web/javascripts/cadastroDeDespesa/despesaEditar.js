/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var controllerTipoCadastroDespesa = document.getElementById('controllerTipoCadastroDespesa').value;
if(controllerTipoCadastroDespesa == 1){
    
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
}
if(controllerTipoCadastroDespesa == 2){
    document.getElementById('descricaoDespesa').style.display = '';  // habilita descrição manual            
    document.getElementById('tipoDespesa').style.display = 'none';  //desabilita tipo de despesa       
}

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
