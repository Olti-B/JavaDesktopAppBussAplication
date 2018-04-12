/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olti.busproject.controlles;

import com.olti.busproject.Database.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Olti
 */
public class CRUDImpl extends CRUDQueries implements CRUD {

    private final DatabaseConnection databaseConn = new DatabaseConnection();
    private PreparedStatement pstmt;

    @Override
    public void createUserWithUsernameEmailPasswIdCard(String username, String password, String email, String id_card) {
        try {
            pstmt = databaseConn.getConnection().prepareStatement(getCreateQuery());
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, id_card);

            if (pstmt.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "user created succesfully");
            }
            
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Can not create user from database " + ex);
        }

    }

    @Override
    public boolean readFromDatabaseUser(String username, String password) {
        try {
            pstmt = databaseConn.getConnection().prepareStatement(getReadQuery());
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Can not read user from database " + ex);
        }
        return false;
    }

    @Override
    public void deleteUser(String email) {
        try {
            pstmt = databaseConn.getConnection().prepareStatement(getDeleteQuery());
            pstmt.setString(1, email);

            if (pstmt.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "user with email " + email + " succesfully deleted");
            }
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Can not delete user from database " + ex);
        }
    }

    @Override
    public void updateUserCredentions(String username, String password, String email, String id_card) {
        try {
            pstmt = databaseConn.getConnection().prepareStatement(getUpdateQuery());
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, id_card);

            if (pstmt.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "user with email " + email + " succesfully updated");
            }
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Can not update user from database " + ex);
        }
    }

    @Override
    public boolean isUserInDatabase(String email) {
        try {
            pstmt = databaseConn.getConnection().prepareStatement(getExistUserInDatabase());
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Can not find user from database " + ex);
        }
        
        return false;
    }

}
