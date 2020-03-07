/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import configConexao.Conexao;
import static configConexao.Conexao.close;
import static configConexao.Conexao.con;
import static configConexao.Conexao.open;
import static configConexao.Conexao.stmt;
import entidades.Telefone;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class TelefoneSQL extends Conexao {

    /**
     * Método que realiza insert na tabela "telefone" no banco de dados
     *
     * @param telefone
     * @throws Exception
     */
    public void create(Telefone telefone) throws Exception { //recebe telefone vindo do controller

        open(); //abre conexão com o banco de dados

        //define comando para o banco de dados
        if (telefone.getIdCliente() == null) { //se idCliente for null (ou seja telefone de funcionario) 
            stmt = con.prepareStatement("INSERT INTO telefone(numero, isCelular, isFixo, idFuncionario, isPrincipal) VALUES(?,?,?,?,?)");
        } else { // se não ( ou seja idFuncionario == null (idFuncionario for null)
            stmt = con.prepareStatement("INSERT INTO telefone(numero, isCelular, isFixo, idCliente, isPrincipal) VALUES(?,?,?,?,?)");
        }

        //atribui os valores das marcações do comando acima
        if (telefone.getIdCliente() == null) { // se for cadastro de funcionario
            stmt.setString(1, telefone.getNumero());
            stmt.setInt(2, telefone.getIsCelular());
            stmt.setInt(3, telefone.getIsFixo());;
            stmt.setInt(4, telefone.getIdFuncionario());
            stmt.setInt(5, telefone.getIsPrincipal());
        } else { // se for cadastro de cliente
            stmt.setString(1, telefone.getNumero());
            stmt.setInt(2, telefone.getIsCelular());
            stmt.setInt(3, telefone.getIsFixo());
            stmt.setInt(4, telefone.getIdCliente());
            stmt.setInt(5, telefone.getIsPrincipal());
        }

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados
    }

    /**
     * Método que realiza insert na tabela "telefone" do banco de dados e caso
     * venha com o atributo isPrincipal = true, realiza o update no ultimo
     * registro que esteja como isPrincipal = true
     *
     * @param telefone
     * @throws Exception
     */
    public void createNovo(Telefone telefone) throws Exception { //recebe telefone vindo do controller

        open(); //abre conexão com o banco de dados

        //valida se é de funcionario ou cliente e depois seta como 0 os telefones deles caso o novo seja principal
        if (telefone.getIsPrincipal() == 1 && telefone.getIdFuncionario() != null) {
            this.atualizaTelefePrincipal(telefone.getIdFuncionario(), 0); //chama método que atualiza o telefone pricipal do funcionario para 0            
        } else {
            if (telefone.getIsPrincipal() == 1 && telefone.getIdCliente() != null) {
                this.atualizaTelefePrincipal(0, telefone.getIdCliente()); //chama método que atualiza o telefone pricipal do cliente para 0            
            }
        }

        open();//abrindo conexão novamente , por que quando o "this.atualizaTelefePrincipal" executa , fecha a conexão.

        //define comando para o banco de dados
        if (telefone.getIdCliente() == null) { //se idCliente for null (ou seja telefone de funcionario) 
            stmt = con.prepareStatement("INSERT INTO telefone(numero, isCelular, isFixo, idFuncionario, isPrincipal) VALUES(?,?,?,?,?)");
        } else { // se não ( ou seja idFuncionario == null (idFuncionario for null)
            stmt = con.prepareStatement("INSERT INTO telefone(numero, isCelular, isFixo, idCliente, isPrincipal) VALUES(?,?,?,?,?)");
        }

        //atribui os valores das marcações do comando acima
        if (telefone.getIdCliente() == null) { // se for cadastro de funcionario
            stmt.setString(1, telefone.getNumero());
            stmt.setInt(2, telefone.getIsCelular());
            stmt.setInt(3, telefone.getIsFixo());;
            stmt.setInt(4, telefone.getIdFuncionario());
            stmt.setInt(5, telefone.getIsPrincipal());
        } else { // se for cadastro de cliente
            stmt.setString(1, telefone.getNumero());
            stmt.setInt(2, telefone.getIsCelular());
            stmt.setInt(3, telefone.getIsFixo());
            stmt.setInt(4, telefone.getIdCliente());
            stmt.setInt(5, telefone.getIsPrincipal());
        }

        stmt.execute();//executa  insert no banco de dados
        close();//fecha conexão com o banco de dados
    }

    /**
     * Método atualiza como false os registro da tabela "telefone" que esteja
     * como isPrincipal=true
     *
     * @param idFuncionario
     * @param idCliente
     * @throws Exception
     */
    public void atualizaTelefePrincipal(int idFuncionario, int idCliente) throws Exception {

        open(); //abre conexão com o banco de dados

        if (idFuncionario != 0) {
            stmt = con.prepareStatement("UPDATE telefone SET isPrincipal = 0 WHERE idFuncionario = ?");
            stmt.setInt(1, idFuncionario); //seta idFuncionario no ?
        } else {
            stmt = con.prepareStatement("UPDATE telefone SET isPrincipal = 0 WHERE idCliente = ?");
            stmt.setInt(1, idCliente); //seta idFuncionario no ?
        }

        stmt.execute(); // executa update no banco de dados
        close(); // fecha conexão com o banco de dados
    }

    /**
     * Método retorna todos os registro da tabela "telefone" do banco de dados.
     *
     * @param idFuncionario2
     * @param idCliente2
     * @return
     * @throws Exception
     */
    public ArrayList<Telefone> getTelefone(int idFuncionario2, int idCliente2) throws Exception { //método de retorno arrayList de telefone

        try {
            open(); //abre conexão com o banco
            ArrayList<Telefone> listaTelefone = new ArrayList(); //instancia uma arrayList de telefone

            if (idFuncionario2 != 0) { //se for de funcionario
                stmt = con.prepareStatement("SELECT idTelefone, numero, isCelular, isFixo, idCliente, idFuncionario, isPrincipal FROM telefone WHERE idFuncionario = ? ORDER BY isPrincipal DESC"); //executa query na base               
                stmt.setInt(1, idFuncionario2);
            } else { // se for de cliente
                stmt = con.prepareStatement("SELECT idTelefone, numero, isCelular, isFixo, idCliente, idFuncionario, isPrincipal FROM telefone WHERE idCliente = ? ORDER BY isPrincipal DESC"); //executa query na base                                
                stmt.setInt(1, idCliente2);
            }

            ResultSet resultadoConsulta = stmt.executeQuery(); //salvando resultado na query do banco em uma variavel

            while (resultadoConsulta.next()) { //loop até passar por todos os resultados
                Telefone telefone = new Telefone(); //toda vez que passar no while vai criar uma variavel do tipo funcionario

                telefone.setIdTelefone(resultadoConsulta.getInt("idTelefone"));
                telefone.setNumero(resultadoConsulta.getString("numero"));
                telefone.setIsCelular(resultadoConsulta.getInt("isCelular"));
                if (telefone.getIsCelular() == 1) {
                    telefone.setTipoTelefone("Celular");
                }
                telefone.setIsFixo(resultadoConsulta.getInt("isFixo"));
                if (telefone.getIsFixo() == 1) {
                    telefone.setTipoTelefone("Fixo");
                }
                telefone.setIsPrincipal(resultadoConsulta.getInt("isPrincipal"));
                telefone.setIdCliente(resultadoConsulta.getInt("idCliente"));
                telefone.setIdFuncionario(resultadoConsulta.getInt("idFuncionario"));

                listaTelefone.add(telefone);// add na lista de telefone
            }
            close(); // fecha conexão com o banco
            return listaTelefone;//retorna a lista de telefone para onde foi chamado

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

    /**
     * Método que realiza o delete do registro na tabela "telefone" do banco de
     * dados. Caso o telefone seja principal será realizado o delete e depois
     * update para isPrincipal = true para o próximo telefone.
     *
     * @param telefone
     * @throws Exception
     */
    public void excluirTelefone(Telefone telefone) throws Exception {

        open(); //abre conexão com o banco de dados

        //se for funcionario
        if (telefone.getIdFuncionario() != 0) {
            if (telefone.getIsPrincipal() == 1) { // se for telefone principal
                stmt = con.prepareStatement("DELETE FROM telefone WHERE idTelefone = ?"); // query para executar no banco
                stmt.setInt(1, telefone.getIdTelefone()); //seta idTelefone no ?

                stmt.execute(); // executa query

                //deixa o ultimo telefone do funcionario como principal
                stmt = con.prepareStatement("UPDATE telefone SET isPrincipal = 1  WHERE idFuncionario = ? ORDER BY idTelefone DESC LIMIT 1");// query para executar no banco
                stmt.setInt(1, telefone.getIdFuncionario()); //seta idFuncionario no ?
                stmt.execute(); // executa query

            } else { //se não principal , só executa o delete no idTelefone
                stmt = con.prepareStatement("DELETE FROM telefone WHERE idTelefone = ?"); // query para executar no banco
                stmt.setInt(1, telefone.getIdTelefone()); //seta idTelefone no ?

                stmt.execute(); // executa query                
            }

        } else { //se for cliente
            if (telefone.getIsPrincipal() == 1) { // se for telefone principal
                stmt = con.prepareStatement("DELETE FROM telefone WHERE idTelefone = ?"); // query para executar no banco
                stmt.setInt(1, telefone.getIdTelefone()); //seta idTelefone no ?

                stmt.execute(); // executa query

                //deixa o ultimo telefone do funcionario como principal
                stmt = con.prepareStatement("UPDATE telefone SET isPrincipal = 1  WHERE idCliente = ? ORDER BY idTelefone DESC LIMIT 1");// query para executar no banco
                stmt.setInt(1, telefone.getIdCliente()); //seta idCliente no ?
                stmt.execute(); // executa query

            } else { //se não principal , só executa o delete no idTelefone
                stmt = con.prepareStatement("DELETE FROM telefone WHERE idTelefone = ?"); // query para executar no banco
                stmt.setInt(1, telefone.getIdTelefone()); //seta idTelefone no ?

                stmt.execute(); // executa query                
            }
        }

        close(); // fecha conexão com o banco de dados
    }

    public void excluirTelCliente(int idCliente) throws Exception {
        
        open(); //abre conexão com o banco de dados  

        stmt = con.prepareStatement("DELETE FROM telefone WHERE idCliente = ?"); // query para executar no banco

        stmt.setInt(1, idCliente); //seta getIdCliente no ?

        stmt.execute(); // executa query

        close(); // fecha conexão com o banco de dados     
        
    }
    
    public void excluirTelFuncionario(int idFuncionario) throws Exception {
        
        open(); //abre conexão com o banco de dados  

        stmt = con.prepareStatement("DELETE FROM telefone WHERE idFuncionario = ?"); // query para executar no banco

        stmt.setInt(1, idFuncionario); //seta getIdCliente no ?

        stmt.execute(); // executa query

        close(); // fecha conexão com o banco de dados     
        
    }
}
