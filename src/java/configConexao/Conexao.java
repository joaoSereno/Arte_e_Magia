/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author João Pedro
 */
public class Conexao {

    public static Connection con;
    public static PreparedStatement stmt;
    public static ResultSet rs;

    private static String URL = "jdbc:mysql://localhost:3306/arteemagia?useTimezone=true&serverTimezone=UTC";
//    private String URL = "jdbc:mysql://localhost:3306/sistemabrecho?autoReconnect=true&useSSL=false";
//    private String URL = "jdbc:mysql://localhost:3306/arteemagia?useTimezone=true&serverTimezone=UTC";
    private static String USER = "root";
    private static String PASS = "advanced12#$CARE";

    public static void open() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(URL, USER, PASS);
    }

    public static void close() throws Exception {
        con.close();
    }
}
