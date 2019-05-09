/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author MattyRobbo31
 */
public class MySqlConnect {
    Connection conn = null; // Create Connection
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // Enable drivers for the JDBC
            Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/CIS4005","cis4005", "cis4005"); // Locate the database
            return conn;
            
    } catch(HeadlessException | ClassNotFoundException | SQLException e){
        e.printStackTrace(); // Print stack trace when testing
        JOptionPane.showMessageDialog(null, e); // Alert the user of the error in a dialog box
        return null;
    }
}
}
