/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MattyRobbo31
 */
public class student {
    public void insertUpdateDeleteStudent(char operation, Integer id, String fname, String lname, String stuno, 
                                         String time, String bdate)
    {
        Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
        PreparedStatement ps;
        
        if(operation == 'i') // i is for insert to do the database
        { try {
            
            ps = conn.prepareStatement("INSERT INTO STUDENT(FORENAME, SURNAME, STUDENTNO, FULLPARTTIME, BIRTHDATE) VALUES(?,?,?,?,?)");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, stuno);
            ps.setString(4, time);
            ps.setString(5, bdate);


            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "New Student Added");
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(operation == 'u') // U is for update to do the database
        { try {
            
            ps = conn.prepareStatement("UPDATE STUDENT SET FORENAME= ?,SURNAME= ?,STUDENTNO= ?, FULLPARTTIME= ? ,BIRTHDATE= ? WHERE ID = ?");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, stuno);
            ps.setString(4, time);
            ps.setString(5, bdate);
            ps.setInt(6, id);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Student details updated");
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
        
        if(operation == 'd') // D is for the Delete option
        { try {
            
            ps = conn.prepareStatement("DELETE FROM STUDENT WHERE ID = ?");
            ps.setInt(1, id);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Students records deleted");
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public void fillStudentJtable(JTable table, String valueToSearch)
    {
        Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
        PreparedStatement ps;
        try {
            
            ps = conn.prepareStatement("SELECT * FROM STUDENT");
            ResultSet rs= ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
//            ps.setString(1, "%"+valueToSearch+"%");
            Object[] row;
            
            while(rs.next()){
                row = new Object[6];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                
                model.addRow(row);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    public void fillStuNoCombo(JComboBox combo)
    {
        Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT STUDENTNO FROM STUDENT");       
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                combo.addItem(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
