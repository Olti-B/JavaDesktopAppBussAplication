/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestValidators;

import com.olti.busproject.validators.ValidateLogin;
import com.olti.busproject.validators.ValidateRegister;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Olti
 */
public class LoginAndRegisterValidatorTest {

    ValidateLogin login = new ValidateLogin();
    ValidateRegister reg = new ValidateRegister();

    @Test
    public void isLogValidatorCorrect() {
        assertEquals("invalid password", login.cheekPassword("olti"));
    }

    @Test
    public void isRegEmailValidatorCorrect() {
        assertEquals("invalid email", reg.validateEmail("olti"));
        assertEquals("valid email", reg.validateEmail("olti@olti.com"));
    }

    @Test
    public void isRegPasswValidatorCorrect() {
        assertEquals("invalid password", reg.validatePassword("olti"));
    }
    
    @Test
    public void isRegIDCardValidatorCorrect() {
        assertEquals("invalid id card", reg.validateIdCardNumber("olti"));
    }
}
