/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestValidators;

import com.olti.busproject.controlles.CRUD;
import com.olti.busproject.controlles.CRUDImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Olti
 */
public class TestCRUD {

    CRUD cr = new CRUDImpl();
    
    @Test
    public void isUserInDataBase(){
        Assert.assertTrue(cr.readFromDatabaseUser("o@o.com","oltiolti"));
    }
    
}

