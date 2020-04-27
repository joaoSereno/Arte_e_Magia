/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.festas;

import entidades.Cliente;
import entidades.Crianca;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ClienteSQL;

/**
 *
 * @author João Pedro
 */
@WebServlet("/paginasDeCadastro/cadastroDeFesta/listarOpcoes")
public class ControllerListaOpcoesFesta extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int countCliente2 = 0;
        List<Cliente> listaClientes;

        String countCliente = request.getParameter("countCliente");
        if (countCliente != null) {

            if (!countCliente.equals("")) {

                countCliente2 = Integer.parseInt(countCliente);

                request.setAttribute("countCliente", countCliente2);

            }

        }

        if (countCliente2 == 0) { //se é a primeira vez que vai selecionar cliente

            ClienteSQL clienteBanco = new ClienteSQL();

            try {
                listaClientes = clienteBanco.getClientes();

                request.setAttribute("listaClientes", listaClientes);
                request.setAttribute("countCliente", countCliente2);

                request.getRequestDispatcher("paginaSelecionarClienteFesta.jsp").forward(request, response); // dispara para essa página

            } catch (Exception ex) {
                Logger.getLogger(ControllerListaOpcoesFesta.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else { //se não é

            int countAniversariante2 = 0;
            int countValorAdicional2 = 0;
            int countPacotesAdicionais2 = 0;
            int countFuncionario2 = 0;
            int countHorario2 = 0;
            int countDespesaFesta2 = 0;
            int temValorAdicional2 = 0;
            int temPacotesAdicionais2 = 0;
            int idAniversariante2 = 0;

            String countAniversariante = request.getParameter("countAniversariante");
            if (countAniversariante != null) {

                if (!countAniversariante.equals("")) {

                    countAniversariante2 = Integer.parseInt(countAniversariante);

                }
            }

            if (countAniversariante2 != 0) { //se existir aniversariante
                ArrayList<Crianca> listaCrianca = new ArrayList(); //lista que vai receber os dados dos aniversariantes

                for (int i = 0; i < countAniversariante2; i++) { //loop enquanto tiver aniversariante
                    Crianca crianca = new Crianca();

                    //pegando a lista de despesas do front
                    String idAniversariante = request.getParameter("idAniversariante" + (i + 1));
                    if (idAniversariante != null) {
                        if (!idAniversariante.equals("")) {
                            idAniversariante2 = Integer.parseInt(idAniversariante);
                        }
                    }

                    String nomeAniversariante = request.getParameter("nomeAniversariante" + (i + 1));

                    //setando os valores pegos na variavel
                    if (idAniversariante2 != 0) {
                        crianca.setIdCrianca(idAniversariante2);
                    }

                    if (nomeAniversariante != null) {
                        if (!nomeAniversariante.equals("")) {
                            crianca.setNomeCrianca(nomeAniversariante);
                        }
                    }

                    //add variavel na lista de criancas do back-end
                    if (idAniversariante != null && nomeAniversariante != null) {
                        listaCrianca.add(crianca);
                    }

                }
                //criando lista em forma de String com os valores que foram selecionado anteriormente
                if(!listaCrianca.isEmpty()){
                    String listaCriancaString = "";
                    int countlistaCrianca = 0;
                    
                    for(int i = 0; i < listaCrianca.size(); i++){
                        if(countlistaCrianca > 0){
                            listaCriancaString = listaCriancaString + "-";
                        }
                        
                        String idCrianca = Integer.toString(listaCrianca.get(i).getIdCrianca());
                        
                        String nomeCrianca = listaCrianca.get(i).getNomeCrianca();
                        
                        listaCriancaString = listaCriancaString + idCrianca + "+" + nomeCrianca;
                        countlistaCrianca++;
                    }
                    
                    request.setAttribute("listaCriancaString", listaCriancaString);
                }
                
              
            }

            ClienteSQL clienteBanco = new ClienteSQL();

            try {
                listaClientes = clienteBanco.getClientes();

                request.setAttribute("listaClientes", listaClientes);
                request.setAttribute("countCliente", countCliente2);

                request.getRequestDispatcher("paginaSelecionarClienteFesta.jsp").forward(request, response); // dispara para essa página

            } catch (Exception ex) {
                Logger.getLogger(ControllerListaOpcoesFesta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//            String temValorAdicional = request.getParameter("temValorAdicional");
//            String countValorAdicional = request.getParameter("countValorAdicional");
//
//            String temPacotesAdicionais = request.getParameter("temPacotesAdicionais");
//            String countPacotesAdicionais = request.getParameter("countPacotesAdicionais");
//
//            String countFuncionario = request.getParameter("countFuncionario");
//            String countHorario = request.getParameter("countHorario");
//
//            String countDespesaFesta = request.getParameter("countDespesaFesta");

        }

    }

}
