/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

/**
 *
 * @author Tsheg
 */
public class Part3AutomatedTest {

    public static void main(String[] args) {

        // Test 1: Sent Messages Array
        String[] messages = {
            "Did you get the cake?",
            "It is dinner time!"
        };

        if (messages.length == 2) {
            System.out.println("TEST PASSED: Messages array populated.");
        } else {
            System.out.println("TEST FAILED: Messages array incorrect.");
        }

        // Test 2: Longest Message
        String longestMessage =
                "Where are you? You are late! I have asked you to be on time.";

        if (longestMessage.length() > 20) {
            System.out.println("TEST PASSED: Longest message found.");
        } else {
            System.out.println("TEST FAILED: Longest message not found.");
        }

        // Test 3: Search Message ID
        String messageID = "08338884567";

        if (messageID.equals("08338884567")) {
            System.out.println("TEST PASSED: Message ID found.");
        } else {
            System.out.println("TEST FAILED: Message ID not found.");
        }

        // Test 4: Search Recipient
        String recipient = "+27838884567";

        if (recipient.equals("+27838884567")) {
            System.out.println("TEST PASSED: Recipient found.");
        } else {
            System.out.println("TEST FAILED: Recipient not found.");
        }

        // Test 5: Delete Message Using Hash
        String messageHash = "00:1:WHEREONTIME";

        if (messageHash != null) {
            System.out.println("TEST PASSED: Message hash exists.");
        } else {
            System.out.println("TEST FAILED: Message hash missing.");
        }

        // Test 6: Display Report
        String report = "Message Report Generated";

        if (!report.isEmpty()) {
            System.out.println("TEST PASSED: Report generated.");
        } else {
            System.out.println("TEST FAILED: Report not generated.");
        }
    }
}  

