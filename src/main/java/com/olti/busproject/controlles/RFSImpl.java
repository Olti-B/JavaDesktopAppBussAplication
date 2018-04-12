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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Olti
 */
public class RFSImpl extends RFSQuerys implements RFSInteraction {

    private final DatabaseConnection databaseConn = new DatabaseConnection();
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public void fillTabel(JTable tabel, String start, String end) {
        
        try {
            pstmt = databaseConn.getConnection().prepareStatement(getFillTabelQuery());
            pstmt.setString(1, start);
            pstmt.setString(2, end);
            rs = pstmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tabel.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[7];
                row[0] = rs.getString(2);
                row[1] = rs.getString(3);
                row[2] = rs.getInt(4);
                row[3] = rs.getInt(5);
                row[4] = rs.getString(6);
                row[5] = rs.getString(7);
                row[6] = rs.getString(8);
                model.addRow(row);
            }
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(RFSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void reantASeaat(String user, String BusId, String freeSeats, String reservedSeat) {
        try {
            pstmt = databaseConn.getConnection().prepareStatement(getRentQuery());
            pstmt.setString(1, user);
            pstmt.setString(2, BusId);

            if (pstmt.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "You Reserved a seat");
                changeSeatsInDataBase(BusId, freeSeats, reservedSeat);
            }
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Can not reserve seat " + ex);
        }
    }

    private void changeSeatsInDataBase(String BusId, String freeSeats, String reservedSeat) {
        try {
            pstmt = databaseConn.getConnection().prepareStatement(getUpdateQuery());

            int fS = Integer.parseInt(freeSeats) - 1;
            int rS = Integer.parseInt(reservedSeat) + 1;
            if (fS <= 0) {
                JOptionPane.showMessageDialog(null,"You can not reserve more in this buss");
            } else {
                pstmt.setInt(1, fS);
                pstmt.setInt(2, rS);
                pstmt.setString(3, BusId);

                if (pstmt.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "You Reserved a seat");
                }
            }
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Can not reserve seat " + ex);
        }
    }

}
