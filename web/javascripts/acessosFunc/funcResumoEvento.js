/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$("#periodoEvento").mask("00/00/0000");
$("#periodoEvento2").mask("00/00/0000");

//controla a divResumoEventoFunc
var controllerResumoEventoResultado = document.getElementById('controllerResumoEventoResultado').value;
if(controllerResumoEventoResultado == 1){
    
    document.getElementById('divResumoEventoFunc').style.display = "";
 
}
