/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.registration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tshego
 */
public class RegistrationTest {

    public RegistrationTest() {
    }

    
    @Test
    public void testValidUsername() {

        Login login = new Login();

        boolean result = login.checkUserName("kyl_1");

        assertTrue(result);
    }

   
    @Test
    public void testInvalidUsername() {

        Login login = new Login();

        boolean result = login.checkUserName("kyle123");

        assertFalse(result);
    }

    
    @Test
    public void testValidPassword() {

        Login login = new Login();

        boolean result = login.checkPasswordComplexity("Password@1");

        assertTrue(result);
    }

    //Test Valid Cellphone
    @Test
    public void testValidCellPhone() {

        Login login = new Login();

        boolean result = login.checkCellPhoneNumber("+27831234567");

        assertTrue(result);
    }

    //Test Register User
    @Test
    public void testRegisterUser() {

        Login login = new Login();

        String result = login.registerUser(
                "kyl_1",
                "Password@1",
                "+27831234567");

        assertEquals(
                "User has been registered successfully.",
                result);
    }
}