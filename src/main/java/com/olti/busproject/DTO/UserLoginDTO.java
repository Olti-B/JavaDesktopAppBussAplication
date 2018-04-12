/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olti.busproject.DTO;

import com.olti.busproject.validators.ValidateLogin;
import com.olti.busproject.validators.ValidateRegister;

/**
 *
 * @author Olti
 */
public class UserLoginDTO {

    private final ValidateRegister loginvalidate = new ValidateRegister();

    private String email;
    private String password;

    public UserLoginDTO(String username, String password) {
        this.email = username;
        this.password = password;
    }

    public UserLoginDTO() {
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        if (!loginvalidate.validateEmail(email).equals("invalid email")) {
            this.email = email;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        if (!loginvalidate.validatePassword(password).equals("invalid password")) {
            this.password = password;
        }
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" + "email=" + email + ", password=" + password + '}';
    }

}
