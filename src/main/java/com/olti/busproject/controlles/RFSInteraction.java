/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olti.busproject.controlles;

import javax.swing.JTable;

/**
 *
 * @author Olti
 */
public interface RFSInteraction {
    
    public void fillTabel(JTable tabel, String start, String end );
    
    public void reantASeaat(String user, String BusId  , String freeSeats, String reservedSeat);
    
}
