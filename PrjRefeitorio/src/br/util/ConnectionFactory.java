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
           /* return DriverManager.getConnection("jdbc:mysql://"+LoadPropriedade.loadProperty("servidor")+"/"+LoadPropriedade.loadProperty("banco"),  //192.168.3.38
                    LoadPropriedade.loadProperty("user"), LoadPropriedade.loadProperty("senha"));*/
            return DriverManager.getConnection("jdbc:mysql://localhost/refeitorio",  //192.168.3.38
                    "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
