package com.mycompany.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * This class will contain the methods used to connect to and interact with the
 * local PostgreSQL server on pgAdmin 4.
 * 
 * @author wozller
 */
public class ContactsProgram {
    
    /**
     * Establishes a connection with the local PostgreSQL server, return a type
     * Connection object which we can then interact with elsewhere.
     * @return 
     */
    public static Connection getServerConnection() {
        
        Connection connection = null;
        
        String url = "jdbc:postgresql://localhost:5432/jdbc_demo";
        String username = "postgres";
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter pw for PostgreSQL server: ");
        
        String password = input.nextLine();
        
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return connection;
        
    } // End of getServerConnection method.
    
} // End of ContactsProgram.