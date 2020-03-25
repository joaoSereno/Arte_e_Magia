/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//sempre que carregar a página vai verificar se o valorDisplay é == 1 
var valorDisplay = document.getElementById('valorDisplay').value;
if (valorDisplay == 1) { 
    document.getElementById('divTipoDespesa').style.display = 'block';  //habilita a div com id "divTipoDespesa"              
    document.getElementById('divDescricao').style.display = 'none'; //desabilita a div com id "divDescricao"       
}

//se clicar no botão DESCRIÇÃO MANUAL 
function tipoDespesa() {
    document.getElementById('divDescricao').style.display = 'block';  //habilita a div com id "divDescricao"               
    document.getElementById('divTipoDespesa').style.display = 'none';  //desabilita a div com id "divTipoDespesa"                 
}; 

