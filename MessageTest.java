/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

/**
 *
 * @author Tsheg
 */
public class MessageTest {
     public static void main(String[] args) {

        String message = "Hello, how are you?";

        // Automated Test for Message Length
        if (message.length() <= 250) {

            System.out.println("TEST PASSED: Message length is valid.");

        } else {

            System.out.println("TEST FAILED: Message exceeds 250 characters.");
        }
    }
}



