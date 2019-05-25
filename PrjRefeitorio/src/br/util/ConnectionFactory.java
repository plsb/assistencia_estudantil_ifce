/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        System.out.println("Conectando ao Banco de Dados...");
        try {
            return DriverManager.getConnection("jdbc:mysql://"+LoadPropriedade.loadProperty("server")+"/"+LoadPropriedade.loadProperty("bd_name"),  
                    LoadPropriedade.loadProperty("user"), "040908");
            /*return DriverManager.getConnection("jdbc:mysql://localhost/refeitorio",  //192.168.3.38
                    "root", "");*/
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
