/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var controllerMsgEvento = document.getElementById('controllerMsgEvento').value;
var controllerListagemEvento = document.getElementById('controllerListagemEvento').value;

if(controllerMsgEvento == 1){
    document.getElementById('divMsgEvento').style.display = '';
}
if(controllerListagemEvento == 1){
    document.getElementById('divListagemEvento').style.display = '';
}

$("#periodoEvento").mask("00/00/0000");
$("#periodoEvento2").mask("00/00/0000");




