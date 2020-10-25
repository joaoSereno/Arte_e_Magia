/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var controllerMsgEvento = document.getElementById('controllerMsgEvento').value;
var controllerListagemEvento = document.getElementById('controllerListagemEvento').value;
var controllerCadastroEvento = document.getElementById('controllerCadastroEvento').value;
var controllerExclusaoEvento = document.getElementById('controllerExclusaoEvento').value;
var controllerEdicaoEvento = document.getElementById('controllerEdicaoEvento').value;

if(controllerMsgEvento == 1){
    document.getElementById('divMsgEvento').style.display = '';
}
if(controllerListagemEvento == 1){
    document.getElementById('divListagemEvento').style.display = '';
}

if(controllerCadastroEvento == 1){
    document.getElementById('divMsgConfirmacaoDeFesta').style.display = '';
}

if(controllerExclusaoEvento == 1){
    document.getElementById('divMsgConfirmacaoDeExclusaoFesta').style.display = '';
}

if(controllerEdicaoEvento == 1){
    document.getElementById('divMsgConfirmacaoEdicaoFesta').style.display = '';
}

//função que joga o idEvento que será excluido para o modal
function excluirEvento(idEventoExcluir) {
    
    var idEvento = idEventoExcluir;//recebe o id como parametro e salva na variavel o valor
    
    document.getElementById('idEventoExcluir').value = idEvento; //coloca o idEvento no input de submit da exclusão

};

$("#periodoEvento").mask("00/00/0000");
$("#periodoEvento2").mask("00/00/0000");




