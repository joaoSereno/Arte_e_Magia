/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var sexo = document.getElementById('sexo2').value; //pega o valor do select dos sexos
if(sexo == ""){   //se estiver vazio, deixa o outro vazio também
      document.getElementById("sexo3").value = "";
      document.getElementById("sexo3").innerHTML = "";                
}else{ //se não tiver
    if(sexo == "M"){//se o sexo for M , na outro campo vai mostra F
      document.getElementById("sexo3").value = "F";
      document.getElementById("sexo3").innerHTML = "F";
    }else{ // se não vai mostra M
      document.getElementById("sexo3").value = "M";
      document.getElementById("sexo3").innerHTML = "M";
    }  
}