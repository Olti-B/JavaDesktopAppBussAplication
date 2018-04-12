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
public class CRUDQueries {

    protected final String getCreateQuery() {
        return "INSERT INTO login(username, password, email, id_card_number) VALUES (?,?,?,?)";
    }

    protected final String getReadQuery() {
        return "SELECT * FROM login WHERE email=? AND password=?";
    }

    protected final String getUpdateQuery() {
        return "UPDATE login SET username=?, password=?,email=? WHERE id_card_number=?";
    }

    protected final String getDeleteQuery() {
        return "DELETE FROM login WHERE email=?";
    }
    
    protected final String getExistUserInDatabase() {
        return "SELECT * FROM login WHERE email=?";
    }

}
