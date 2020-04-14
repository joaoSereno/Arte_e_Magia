///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//var countCliente = document.getElementById('countCliente').value;
//
//if (countCliente > 0) {
//
//    //recebe o String os aniversariantes selecionados anteriormente
//    var listaAnivesarianteString = document.getElementById('listaCriancaString').value;
//    if (listaAnivesarianteString !== "") {
//
//        var controladorDeInputsCriado = 0;
//
//        //habilita a div da tabela
//        document.getElementById('tabelaAniversariantes').style.display = 'block';
//
//        //cria as variavel
//        var idAniversariante = 0;
//        var nomeAniversariante = "";
//        var countResultado = 0;
//
//        //recebe o id + o nome e usa a função split para separar e coloca em uma lista
//        resultado = listaAnivesarianteString.split("-");
//
//        //percorre essa lista
//        resultado.forEach((valorAtual) => {
//            //faz o split de cada resultado da lista e salva em uma nova lista
//            resultado2 = valorAtual.split("+");
//
//            //percorre essa nova lista e para cada resultado faz o processo
//            resultado2.forEach((valorAtual2) => {
//                countResultado++;
//                //se é a primeira vez que passa na lista, salva o id
//                if (countResultado == 1) {
//                    idAniversariante = valorAtual2;
//                } else {//se não é , pega o nome e adiciona na variavel atual
//                    nomeAniversariante = valorAtual2;
//                    countResultado = 0;
//                }
//            });
//            controladorDeInputsCriado++;
//
//            //cria um elemento do tipo TR e salva ele em uma variavel
//            var aniversariantesTr = document.createElement("tr");
//            aniversariantesTr.id = "tdAniversariante" + controladorDeInputsCriado;
//
//            //cria elementos do tipo TD e salva eles em uma variavel
//            var aniversarianteTd = document.createElement("td");
//            var removerAniversarianteTd = document.createElement("td");
//
//            //criando elemento button para remover
//            var removerAniversarianteBotao = document.createElement("button");
//            removerAniversarianteBotao.textContent = "Remover";
//            removerAniversarianteBotao.type = "button";
//            removerAniversarianteBotao.id = "idRemoverAniversarianteBotao";
//            removerAniversarianteBotao.name = "nameRemoverAniversarianteBotao" + controladorDeInputsCriado;
//
//
//            //colocando o botão de remover dentro do td
//            removerAniversarianteTd.appendChild(removerAniversarianteBotao);
//
//            //seta o texto das td com os valores das variaveis que receberam os valores dos inputs do form
//            aniversarianteTd.textContent = nomeAniversariante;
//
//            //coloca os TDS criados que estão com os valores do form dentro do TR
//            aniversariantesTr.appendChild(aniversarianteTd);
//            aniversariantesTr.appendChild(removerAniversarianteTd);
//
//            //pega o elemento table do html através do id e seta nele o TR criado
//            var tabelaTbodyAniversariante = document.querySelector("#tbodyAniversariantes");
//            tabelaTbodyAniversariante.appendChild(aniversariantesTr);
//
//            //COMEÇO DA CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS DOS ANIVERSARIANTE ADD
//            //cria um controlador(input) para os aniversariantes toda vez que adiciona um aniversariante
//            var inputIdAniversariante = document.createElement("input");
//            var inputNomeAniversariante = document.createElement("input");
//
//            //seta como tipo hidden os controladores(inputs) criados para aniversariante
//            inputIdAniversariante.type = "hidden";
//            inputNomeAniversariante.type = "hidden";
//
//            //setando os valores digitos pelo usuário, nos values dos controladores
//            inputIdAniversariante.value = idAniversariante;
//            inputNomeAniversariante.value = nomeAniversariante;
//
//            //variavel que vai ser o nome dos controladores(inputs) , recebe uma string + o valor da variavel jsAniversariante
//            var nameIdAniversariante = "idAniversariante" + controladorDeInputsCriado;
//            var nameAniversariante = "nomeAniversariante" + controladorDeInputsCriado;
//
//            //seta no name dos controladores(input) o valor das variaveis
//            inputIdAniversariante.name = nameIdAniversariante;
//            inputNomeAniversariante.name = nameAniversariante;
//
//            //setando id para os controladores(inputs)
//            inputIdAniversariante.id = "idAniversariante" + controladorDeInputsCriado;
//            inputNomeAniversariante.id = "nomeAniversariante" + controladorDeInputsCriado;
//
//            //pegando o form de comunição com o back-end e setando nele controladores(inputs) criados
//            formCadastrarFesta = document.querySelector('#cadastrarFestaForm');
//            formCadastrarFesta.appendChild(inputIdAniversariante);
//            formCadastrarFesta.appendChild(inputNomeAniversariante);
//
//            formSelecionarCliente = document.querySelector('#listarOpcoes');
//            formSelecionarCliente.appendChild(inputIdAniversariante);
//            formSelecionarCliente.appendChild(inputNomeAniversariante);
//            //FIM CRIAÇÃO E SETAMENTO DOS VALORES DOS INPUTS  DAS ANIVERSARIANTES ADD
//            
//        });
//
//
//
//    }
//
//
//}
//
