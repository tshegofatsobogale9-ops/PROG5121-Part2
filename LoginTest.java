package com.mycompany.registration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
/**
 *
 * @author Tshego
 */
class LoginTest {

 
    // USERNAME TESTS

    @Test
    void testValidUsername() {
        Login login = new Login();
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    void testInvalidUsername_NoUnderscore() {
        Login login = new Login();
        assertFalse(login.checkUserName("kyl1"));
    }

    @Test
    void testInvalidUsername_TooLong() {
        Login login = new Login();
        assertFalse(login.checkUserName("kyle_bogale_longname"));
    }

  
    // PASSWORD TESTS
    
    @Test
    void testValidPassword() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Pass123!"));
    }

    @Test
    void testInvalidPassword_NoCapital() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("pass123!"));
    }

    @Test
    void testInvalidPassword_NoNumber() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("Password!"));
    }

    @Test
    void testInvalidPassword_NoSpecialChar() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("Password123"));
    }

   
    // CELLPHONE TESTS
  
    @Test
    void testValidCellPhone() {
        Login login = new Login();
        assertTrue(login.checkCellPhoneNumber("+27831234567"));
    }

    @Test
    void testInvalidCellPhone() {
        Login login = new Login();
        assertFalse(login.checkCellPhoneNumber("0831234567"));
    }

    
    // REGISTER USER TESTS
   
    @Test
    void testRegisterUserSuccess() {
        Login login = new Login();

        String result = login.registerUser(
                "kyl_1",
                "Pass123!",
                "+27831234567"
        );

        assertEquals("User has been registered successfully.", result);
    }

    @Test
    void testRegisterUserFailUsername() {
        Login login = new Login();

        String result = login.registerUser(
                "kyl1",
                "Pass123!",
                "+27831234567"
        );

        assertEquals("Username is not correctly formatted.", result);
    }

    @Test
    void testRegisterUserFailPassword() {
        Login login = new Login();

        String result = login.registerUser(
                "kyl_1",
                "pass",
                "+27831234567"
        );

        assertEquals("Password is not correctly formatted.", result);
    }

    @Test
    void testRegisterUserFailCell() {
        Login login = new Login();

        String result = login.registerUser(
                "kyl_1",
                "Pass123!",
                "0831234567"
        );

        assertEquals("Cellphone number incorrectly formatted.", result);
    }

    
    // LOGIN TEST (SIMULATED INPUT)
   
    @Test
    void testLoginUserSuccess() {

        Login login = new Login();

        String input = "kyl_1\nPass123!\n";

        Scanner scanner = new Scanner(
                new ByteArrayInputStream(input.getBytes())
        );

        boolean result = login.loginUser(
                scanner,
                "kyl_1",
                "Pass123!",
                "Kyle",
                "Smith"
        );

        assertTrue(result);
    }
}