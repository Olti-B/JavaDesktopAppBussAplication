/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olti.busproject.validators;

/**
 *
 * @author Olti
 */
public class ValidateLogin {

    public String cheekPassword(String password) {
        if (password.length() < 7) {
            return "invalid password";
        } else {
            return charTheArray(password);
        }
    }

    public String charTheArray(String password) {
        char arr[] = password.toCharArray();
        int strength = 0;
        for (char c : arr) {
            if (Character.isUpperCase(c)) {
                strength += 3;
            } else if (Character.isLowerCase(c)) {
                strength++;
            } else if (Character.isDigit(c)) {
                strength += 2;
            } else if (c >= 33 && c <= 46 || c == 64) {
                strength += 4;
            }
        }
        if (strength > 8 && strength <= 12) {
            return "week password";
        } else if (strength > 12 && strength < 16) {
            return "good password";
        } else {
            return "strong password";
        }

    }

}
