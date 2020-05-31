/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var totalResultadoRelPacote = document.getElementById('totalResultadoRelPacote').value;
//recebe o controlador com total e resultado do relatorio e salva em uma variavel 
var listaConcatenadaRelPacote = document.getElementById('listaConcatenadaRelPacote').value;  

//variaveis para construção do grafico
var listaNomePacote = [];
var listaQtdVendidaPacote = [];
var countResultado = 0;

//pega a lista concatenada das crianças e faz um split e salva o resultado na lista resultado
var resultado = listaConcatenadaRelPacote.split("/");

resultado.forEach((valorAtual) => {

    //variaveis 
    var nomePacote = "";
    var qtdVendida = 0;

    //faz novamente um split em cada objeto da lista 
    var resultado2 = valorAtual.split(",");     
    
    
    resultado2.forEach((valorAtual2) => {
        
        countResultado++;
        //se é a primeira vez que passa na lista, salva o id
        if (countResultado == 1) {
            
            if(valorAtual2 !== ""){
                
                nomePacote = valorAtual2;

                listaNomePacote.push(nomePacote);  
            
            }

        } 
        if (countResultado == 2){
            
            if(valorAtual2 !== ""){
                
                qtdVendida = valorAtual2;

                listaQtdVendidaPacote.push(qtdVendida);
                
            }
            
            countResultado = 0;
        }
        
    });

});

var ctx = document.getElementById('myChart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: listaNomePacote,
        datasets: [{
            label: 'Qtd vendida',
            data: listaQtdVendidaPacote,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});

var ctx2 = document.getElementById('myChart2').getContext('2d');
var myChart2 = new Chart(ctx2, {
    type: 'pie',
    data: {
        labels: listaNomePacote,
        datasets: [{
            label: '# de Pacote',
            data: listaQtdVendidaPacote,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
