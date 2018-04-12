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
public interface CRUD {
    
    public void createUserWithUsernameEmailPasswIdCard(String username, String password, String email, String id_card);
    
    public boolean readFromDatabaseUser(String username, String password);
    
    public void deleteUser(String email);
    
     public boolean isUserInDatabase(String email);
    
    public void updateUserCredentions(String username, String password, String email, String id_card);
    
    
}
