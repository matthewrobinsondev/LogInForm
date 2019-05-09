/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MattyRobbo31
 */
public class Count {
    public static int countData(String tableName) {
        int total = 0; // start total at 0
        Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
        Statement st; // Create statment variable
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS TOTAL FROM "+tableName); // Collect the Data from the table
            while(rs.next()){
                total = rs.getInt(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Count.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return total; // Return the total after retreiving the data
    }
    
}
