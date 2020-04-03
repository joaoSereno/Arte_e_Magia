/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import entidades.Email;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class EmailSQL extends Conexao {

    public void createEmail(Email email) throws Exception { //recebe email vindo do controller

        open(); //abre conexão com o banco de dados

        //define comando para o banco de dados
        stmt = con.prepareStatement("INSERT INTO email(email, idCliente) VALUES (?,?)");

        //atribui os valores das marcações do comando acima 
        stmt.setString(1, email.getEmail());
        stmt.setInt(2, email.getIdCliente());

        stmt.execute();//executa  insert no banco de dados

        close();//fecha conexão com o banco de dados
    }

    public ArrayList<Email> getEmailCliente(int idCliente) throws Exception { //método de retorno arrayList de Email

        try {
            open(); //abre conexão com o banco
            ArrayList<Email> listaEmail = new ArrayList(); //instancia uma arrayList de Email

            stmt = con.prepareStatement("SELECT idEmail, email FROM email WHERE idCliente = ?"); //executa query na base               
            stmt.setInt(1, idCliente);

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                Email email = new Email(); //toda vez que passar no while vai criar uma variavel do Email

                email.setIdEmail(resultadoConsulta.getInt("idEmail"));
                email.setEmail(resultadoConsulta.getString("email"));

                listaEmail.add(email);// add na lista de Email
            }
            close(); // fecha conexão com o banco
            return listaEmail;//retorna a lista de telefone para onde foi chamado

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                close();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
    }
    
    public void editarEmailCliente(int idEmail, String email) throws Exception {

        open(); // abre a conexão com o banco de dados

        stmt = con.prepareStatement("UPDATE email SET email = ? WHERE idEmail = ?");

        //seta valores para comando sql
        stmt.setString(1, email);
        stmt.setInt(2, idEmail);

        stmt.execute();//executa comando sql

        close();// fecha a conexão 

    }
}
