/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olti.busproject.controlles;

/**
 *
 * @author Olti
 */
public class RFSQuerys {

    protected final String getFillTabelQuery() {
        return "SELECT * FROM busdestinations WHERE start_place=? AND end_place=?";
    }

    protected final String getRentQuery() {
        return "INSERT INTO rented_seats (user_email, bus_id) VALUES (?,?)";
    }

    protected final String getUpdateQuery() {
        return "UPDATE busdestinations  SET free_seats=?, rentet_seats=? WHERE bus_id=?";
    }
}
