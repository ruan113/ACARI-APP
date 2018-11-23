package BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.jboss.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bento
 */
public class DatabaseConnection {

    Connection connection;

    String url = "jdbc:postgresql://localhost:5432/DBAcari";
    String user = "postgres";
    String password = "patruan7";

    public Connection dbConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            DriverManager.getConnection(url, user, password);
            System.out.println("Connected");//Teste
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Logger.Level.FATAL, null, ex);
            System.out.println("Falha ao connectar no banco de dados!");//Teste
        }

        return connection;
    }
}
