package com.mycompany.jdbc_demo;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Driver class.
 * @author wozller
 */
public class Main {

    public static void main(String[] args) {
        
        Connection connection = ContactsProgram.getServerConnection();
        
        // Demo for inserting a row.
        //ContactsProgram.demo_addNewRow(connection);
        
        // Insertion demo with PreparedStatement.
        //ContactsProgram.demo_insertionWithPreparedStatement(connection);
        
        // Query demo.
        ContactsProgram.demo_query(connection);
        
        try {
            connection.close();
            System.out.println("Connection closed!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    } // End of main method.
    
} // End of Main class.