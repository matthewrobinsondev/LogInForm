/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MattyRobbo31
 */
public class reg { /* This Class is going to contain all of the SQL Querys and functions required for any Registration Page*/
    public void insertUpdateDeleteGrade(char operation, Integer Sid, Integer Rid, String Att)
    {
        Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
        PreparedStatement ps;
        
        if(operation == 'i') // i is for insert to do the database
        { try {
            
            ps = conn.prepareStatement("INSERT INTO STUDENTREGISTER(STUDENTID, REGISTERID, ATTENDED) VALUES(?,?,?)");
            ps.setInt(1, Sid);
            ps.setInt(2, Rid);
            ps.setString(3, Att);


            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Students Attendance input");
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(operation == 'u') // Update the Grades of the Student
        { try {
            
            ps = conn.prepareStatement("UPDATE STUDENTREGISTER SET ATTENDED=? WHERE STUDENTID=? AND REGISTERID=?");
            ps.setInt(1, Sid);
            ps.setInt(2, Rid);
            ps.setString(3, Att);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Student attendance Updated");
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         if(operation == 'd') // D is for the Delete option
        { try {
            
            ps = conn.prepareStatement("DELETE FROM STUDENTREGISTER WHERE STUDENTID = ? AND REGISTERID = ?");
            ps.setInt(1, Sid);
            ps.setInt(2, Rid);
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Students attendance mark has been removed");
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         
    }
    public void insertUpdateDeleteReg(char operation, Integer weekNo, Integer Noa, Integer Mid)
    {
        Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
        PreparedStatement ps;
        
        if(operation == 'i') // i is for insert to do the database
        { try {
            
            ps = conn.prepareStatement("INSERT INTO REGISTER(WEEKNO,NOOFATTENDEES, MODULEID) VALUES(?,?,?)");
            ps.setInt(1, weekNo);
            ps.setInt(2, Noa);
            ps.setInt(3, Mid);


            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Register Sent Out");
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
        }
    }
    public void addnoofatt(char operation, int modId)
    {
        Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
        PreparedStatement ps;
        
        if(operation == 'i') // i is for insert to do the database
        { try {
            
            ps = conn.prepareStatement("UPDATE REGISTER SET NOOFATTENDEES = NOOFATTENDEES + 1 WHERE ID=?");
            ps.setInt(1,modId);


            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "updated");
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
            
            Object[] row;
            
            while(rs.next()){
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);

                
                model.addRow(row);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
            public int getModuleID(String moduleName){
            int modId = 0;
            Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
            PreparedStatement ps;
            
            try {
                ps = conn.prepareStatement("SELECT * FROM REGISTER WHERE ID = ?"); //Select all of the records when ID is selected
                ps.setString(1, moduleName);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()){
                    modId = rs.getInt("Id");
                }
            } catch (SQLException ex) {
                Logger.getLogger(module.class.getName()).log(Level.SEVERE, null, ex);
            }
            return modId;
        }
    public void fillRegCombo(JComboBox combo)
    {
        Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * FROM REGISTER");       // Select al from Register
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                combo.addItem(rs.getString(1));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
}
