package com.mycompany.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
     * @return Connection object.
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
            System.out.println("Connected to server!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return connection;
        
    } // End of getServerConnection method.
    
    public static void demo_addNewRow(Connection connection) {
        
        // Note: Don't need to specify 'id' as it is recognized automatically by
        // the database.
        String sql = "INSERT INTO contacts (first_name, last_name, email)"
                   + "VALUES ('Ravi', 'Kumar', 'ravi.kumar2020@gmail.com')";
        
        Integer rowCount = null; // The row count (will be used to see if the
                                 // row count went up from 0, indicating that we
                                 // successfully added the row.
        
        try {
            Statement statement = connection.createStatement();
            rowCount = statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        if (rowCount > 0)
            System.out.println("A new contact has been inserted.");
        
    } // End of demo_addNewRow method.
    
} // End of ContactsProgram.