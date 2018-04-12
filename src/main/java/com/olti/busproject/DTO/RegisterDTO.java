/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.olti.busproject.DTO;

import com.olti.busproject.validators.ValidateRegister;

public class RegisterDTO {

    private final ValidateRegister reg = new ValidateRegister();

    private String username;
    private String password;
    private String email;
    private String id_card_number;

    public RegisterDTO() {
    }

    public RegisterDTO(String username, String password, String email, String id_card_number) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.id_card_number = id_card_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!reg.validateEmail(password).equals("invalid password")) {
            this.password = password;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!reg.validateEmail(email).equals("invalid email")) {
            this.email = email;
        }
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public void setId_card_number(String id_card_number) {
        if (!reg.validateEmail(id_card_number).equals("invalid id card")) {
            this.id_card_number = id_card_number;
        }
    }

}
