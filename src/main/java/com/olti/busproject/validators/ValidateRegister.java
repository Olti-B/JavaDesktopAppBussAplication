/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olti.busproject.validators;

public class ValidateRegister {

    private final ValidateLogin validate = new ValidateLogin();

    public String validatePassword(String password) {
        return validate.cheekPassword(password);
    }

    public String validateEmail(String email) {
        if (email.contains("@") && email.contains(".com")) {
            return "valid email";
        } else {
            return "invalid email";
        }
    }
   

    public String validateIdCardNumber(String id_card){
       char arr[] = id_card.toCharArray();
       int count = 0;
       if(id_card.length() == 8) {
           for (char c : arr) {
               if (Character.isLetter(c)) {
                   count ++;
               } 
           }
        } 
       if(count == 2){
           return "valid id card";
       }else {
           return "invalid id card";
       }
             
    }
 
   
}
