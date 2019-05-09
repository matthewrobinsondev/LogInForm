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
public class module { /* This Class is going to contain all of the SQL Querys and functions required for any Module related Page*/
        public void insertUpdateDeleteModule(char operation, Integer id, String title, String crd, String code,String lvl, 
                                         String semester)
    {
        Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
        PreparedStatement ps;
        
        if(operation == 'i') // i is for insert to do the database
        { try {
            
            ps = conn.prepareStatement("INSERT INTO MODULE(MODULETITLE, CREDITS, MODULECODE, LEVEL, SEMESTER) VALUES(?,?,?,?,?)");
            ps.setString(1, title);
            ps.setString(2, crd);
            ps.setString(3, code);
            ps.setString(4, lvl);
            ps.setString(5, semester);


            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "New Module Added");
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(operation == 'u') // U is for update to do the database
        { try {
            
            ps = conn.prepareStatement("UPDATE MODULE SET MODULETITLE= ?,CREDITS= ?,MODULECODE= ?, LEVEL= ? ,SEMESTER= ? WHERE ID = ?");
            ps.setString(1, title);
            ps.setString(2, crd);
            ps.setString(3, code);
            ps.setString(4, lvl);
            ps.setString(5, semester);
            ps.setInt(6, id);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Module details updated");
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(module.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(operation == 'd') // D is for the Delete option
        { try {
            
            ps = conn.prepareStatement("DELETE FROM MODULE WHERE ID = ?");
            ps.setInt(1, id);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Module Removed");
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
        public boolean moduleAlreadyEntered(String moduleName){
            boolean modExist = false;
            Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
            PreparedStatement ps;
            
            try {
                ps = conn.prepareStatement("SELECT * FROM MODULE WHERE MODULETITLE = ?");
                ps.setString(1, moduleName);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()){
                    modExist = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(module.class.getName()).log(Level.SEVERE, null, ex);
            }
            return modExist;
        }
       
        
        public int getModuleID(String moduleName){
            int modId = 0;
            Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
            PreparedStatement ps;
            
            try {
                ps = conn.prepareStatement("SELECT * FROM MODULE WHERE MODULETITLE = ?");
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
        public void fillModuleJtable(JTable table, String valueToSearch)
    {
        Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * FROM MODULE");
            
            ResultSet rs= ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
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
        
        public void fillGradeCombo(JComboBox combo)
    {
        Connection conn = MySqlConnect.ConnectDB(); // Connect to the database
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * FROM MODULE");       
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                combo.addItem(rs.getString(2));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
