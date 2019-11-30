/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    public Connection getConnection() {
        
        try {
            System.out.println("Conectando ao Banco de Dados...");
            return DriverManager.getConnection("jdbc:mysql://mysql.ifce.edu.br/rucedro",  
                    "rucedro", "yah)Vahyu9ethu9i");
            /*return DriverManager.getConnection("jdbc:mysql://localhost/refeitorio",  //192.168.3.38
                    "root", "");*/
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }
}
