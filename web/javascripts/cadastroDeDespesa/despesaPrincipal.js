/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$("#periodoDespesa").mask("00/00/0000");
$("#periodoDespesa2").mask("00/00/0000");

var msgValidacaoController = document.getElementById('msgValidacaoController').value;
if(msgValidacaoController == 1){
    //desoculta a div
    document.getElementById('msgValidacao').style.display = "";
}

var msgValidacaoExclusaoController = document.getElementById('msgValidacaoExclusaoController').value;
if(msgValidacaoExclusaoController == 1){
    //desoculta a div
    document.getElementById('divMsgValidacaoExclusao').style.display = "";
}
