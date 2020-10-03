/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//controla a div as mensagem de retorno ao usuário das senhas
var controllerMsgAlteracaoSenha = document.getElementById('controllerMsgAlteracaoSenha').value;
if(controllerMsgAlteracaoSenha !== 0 && controllerMsgAlteracaoSenha !== ""){
    
    document.getElementById('divMsgAlteracaoSenha').style.display = "";
    
    //se for msgConfirmacaoAlteracaoSenha
    if(controllerMsgAlteracaoSenha == 1){
        //desoculta a div
        document.getElementById('msgConfirmacaoAlteracaoSenha').style.display = "";
    }
    
    //se for msgErroAlteracaoSenha
    if(controllerMsgAlteracaoSenha == 2){
        //desoculta a div
        document.getElementById('msgErroAlteracaoSenha').style.display = "";
    }
    
    //se for msgErroAlteracaoSenha2
    if(controllerMsgAlteracaoSenha == 3){
        //desoculta a div
        document.getElementById('msgErroAlteracaoSenha2').style.display = "";
    }
  
}

//controla a div da listagem de agendamento
var controllerListagemAgendamento = document.getElementById('controllerListagemAgendamento').value;
if(controllerListagemAgendamento == 1){
    
    document.getElementById('divAgendamentoFesta').style.display = "";
 
}
