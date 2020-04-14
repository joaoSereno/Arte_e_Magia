/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//dados globais dos clientes selecionados
var idCliente;
var nomeCliente;

//quando clicar no selecionar cliente
function selecionarCliente(idClienteP) { //recebe por parametro o idCliente

    //salva o valor do parametro na varialvel global "idCliente"
    idCliente = idClienteP;
    //salva na variavel global "nomeCliente"
    nomeCliente = document.getElementById('nomeCliente'+idCliente).value;
    
    //recebendo H3 e setando nela o texto com o nome do cliente
    var h3ClienteSelecionado = document.querySelector("#clienteSelecionado");
    h3ClienteSelecionado.textContent = "Cliente: " + nomeCliente;
    
    document.getElementById('listagemDeCliente').style.display = 'none'; //desabilita a tabela de listagem dos clientes
    document.getElementById('confirmacaoCliente').style.display = ''; //habilita a confirmação da etapa 1
    
}; 

//quando clicar para trocar cliente
function trocarCliente() { 
    
    //seta como vazio os atributos do cliente seleciado
    idCliente = 0;
    nomeCliente = "";
       
    document.getElementById('listagemDeCliente').style.display = ''; //habilita a tabela de listagem do cliente
    document.getElementById('confirmacaoCliente').style.display = 'none'; //desabilita a confirmação da etapa 1
    document.getElementById('confirmacaoCliente').style.display = 'none'; //desabilita a confirmação da etapa 1
    
        
};

//quando clicar em etapa 2
function etapa2() {   
    
    //recebendo H3 e setando nela o texto com o nome do cliente
    var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
    tituloDaEtapa.textContent = "2º Etapa - Selecionar Criança";
    
    document.getElementById('confirmacaoCliente').style.display = 'none'; //desabilita a confirmação da etapa 1
    document.getElementById('selecionarAniversariantes').style.display = ''; //habilita a etapa 2
        
};

//quando clicar em etapa 2
function voltarEtapa1() {   
    
    //recebendo H3 e setando nela o texto com o nome do cliente
    var tituloDaEtapa = document.querySelector("#tituloDaEtapa");
    tituloDaEtapa.textContent = "1º Etapa - Selecionar Cliente";
    
    document.getElementById('confirmacaoCliente').style.display = ''; //habilita a confirmação da etapa 1
    document.getElementById('selecionarAniversariantes').style.display = 'none'; //desabilita a etapa 2
        
};
