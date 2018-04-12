/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olti.busproject.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Olti
 */
public class DatabaseConnection {
    
    private static Connection instanceConnection = null;
    
    protected static final String URL_Conn="jdbc:mysql://localhost:3306/transport?autoReconnect=true&useSSL=false";
    protected static final String USER="root";
    protected static final String PASSWORD="";
    
    public synchronized Connection getConnection(){
        if(instanceConnection == null){
            try {
                instanceConnection = DriverManager.getConnection(URL_Conn, USER, PASSWORD);
            } catch (SQLException ex) {
                System.out.println("Unable to get the connection with database "+ex);
            }
        }
        return instanceConnection;
    }
    
}
