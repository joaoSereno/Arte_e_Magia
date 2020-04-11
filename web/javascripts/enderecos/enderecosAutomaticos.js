/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#cep").focusout(function(){
        var cep = $("#cep").val();
        cep = cep.replace("-", "");

        var urlStr = "https://viacep.com.br/ws/"+ cep +"/json/";

        $.ajax({
            url : urlStr,
            type : "get",
            dataType : "json",
            success : function(data){
                console.log(data);
                $("#cidade").val(data.localidade);
                $("#bairro").val(data.bairro);
                $("#rua").val(data.logradouro);
            },
            error : function(erro){
                console.log(erro);
            }
        });
    });
});

