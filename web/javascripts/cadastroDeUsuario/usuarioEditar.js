/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//sempre que carregar a página vai verificar se o valorDisplay é == 1 
var valorDisplay = document.getElementById('valorDisplay').value;
if(valorDisplay == 1){
    document.getElementById('func').style.display = 'block';  //habilita a div com id "func"              
    document.getElementById('nomeUsuario').style.display = 'none'; //desabilita a div com id "nomeUsuario"       
}   
