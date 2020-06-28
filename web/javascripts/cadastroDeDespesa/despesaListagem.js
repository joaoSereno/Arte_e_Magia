/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var origemDespesa = document.getElementById('origemDespesa').value;
if(origemDespesa == 1){
    //desoculta a div
    document.getElementById('divOrigemDespesa').style.display = "";
}

var origemEvento = document.getElementById('origemEvento').value;
if(origemEvento == 1){
    //desoculta a div
    document.getElementById('divOrigemEvento').style.display = "";
}

var origemEventoSemConteudo = document.getElementById('origemEventoSemConteudo').value;
if(origemEventoSemConteudo == 1){
    //desoculta a div
    document.getElementById('divOrigemEventoSemConteudo').style.display = "";
}

var origemDespesaSemConteudo = document.getElementById('origemDespesaSemConteudo').value;
if(origemDespesaSemConteudo == 1){
    //desoculta a div
    document.getElementById('divOrigemDespesaSemConteudo').style.display = "";
}
