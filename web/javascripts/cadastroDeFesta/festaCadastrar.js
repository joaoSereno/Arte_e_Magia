/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//se não existir crinça vinculado ao cliente oculta o campo criança
var countCrianca = document.getElementById('countCrianca').value;
if (countCrianca > 0) { 
    document.getElementById('divAniversariante').style.display = 'block';  //habilita a div com id "Aniversariante"                 
}

//se clicar no botão Sim do valor adicional 
function habilitaValorAdicional() {
    var countCliente = document.getElementById('countCliente').value;
    if(countCliente > 0){
        document.getElementById('divValorAdicional').style.display = 'block';  //habilita a div com id "divValorAdicional" 
        document.getElementById('temValorAdicional').value = 1;
    }
}; 
//se clicar no botão Não do valor adicional 
function desabilitaValorAdicional() {          
    document.getElementById('divValorAdicional').style.display = 'none';  //desabilita a div com id "divValorAdicional"                 
    document.getElementById('temValorAdicional').value = 0;
    document.getElementById('countValorAdicional').value = 0;
}; 


////se clicar no botão Sim do pagamento adiantado
//function habilitaPagamentoAdiantado() {
//    var countCliente = document.getElementById('countCliente').value;
//    if(countCliente > 0){
//        document.getElementById('divPagamentoAdiantado').style.display = 'block';  //habilita a div com id "divPagamentoAdiantado"         
//        document.getElementById('temPagamentoAdiantado').value = 1;
//    }   
//}; 
////se clicar no botão Não do pagamento adiantado
//function desabilitaPagamentoAdiantado() {             
//    document.getElementById('divPagamentoAdiantado').style.display = 'none';  //desabilita a div com id "divPagamentoAdiantado"                 
//    document.getElementById('temPagamentoAdiantado').value = 0;
//    document.getElementById('countPagamentoAdiantado').value = 0;
//}; 
//
//
//se clicar no botão Sim do pacote adicional
function habilitaPacoteAdicional() {
    var countCliente = document.getElementById('countCliente').value;
    if(countCliente > 0){
        document.getElementById('divPacoteAdicional').style.display = 'block';  //habilita a div com id "divPacoteAdicional"
        document.getElementById('temPacotesAdicionais').value = 1;
    }                
}; 
//se clicar no botão Não do pacote adicional
function desabilitaPacoteAdicional() {             
    document.getElementById('divPacoteAdicional').style.display = 'none';  //desabilita a div com id "divPacoteAdicional"                 
    document.getElementById('temPacotesAdicionais').value = 0;
    document.getElementById('countPacotesAdicionais').value = 0;
}; 


function tipoDespesa() {  
    
    var countCliente = document.getElementById('countCliente').value;
    if(countCliente > 0){
        document.getElementById('jsDescricaoDespesa').style.display = 'none';  //desabilita o input com id "jsDescricaoDespesa"                 
        document.getElementById('jsTipoDespesa').style.display = '';  //habilita o input com id "jsTipoDespesa"                    
    }
    
}; 

function descricaoManual() { 
    
    var countCliente = document.getElementById('countCliente').value;
    if(countCliente > 0){
        document.getElementById('jsDescricaoDespesa').style.display = '';  //habilita o input com id "jsDescricaoDespesa"                  
        document.getElementById('jsTipoDespesa').style.display = 'none';  //desabilita o input com id "jsTipoDespesa"           
    }
    
}; 