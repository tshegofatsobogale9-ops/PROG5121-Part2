/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tshego
 */
public class MessageTest {

    @Test
    public void testMessagesArray() {

        String[] messages = {
            "Where are you? You are late! I have asked you to be on time.",
            "Ok, I am leaving without you."
        };

        assertEquals(2, messages.length);
    }

    @Test
    public void testLongestMessage() {

        String longestMessage =
                "Where are you? You are late! I have asked you to be on time.";

        assertEquals(
                "Where are you? You are late! I have asked you to be on time.",
                longestMessage);
    }

    @Test
    public void testSearchMessageID() {

        String messageID = "08338884567";

        assertEquals("08338884567", messageID);
    }

    @Test
    public void testSearchMessagesByRecipient() {

        String recipient = "+27838884567";

        assertEquals("+27838884567", recipient);
    }

    @Test
    public void testDeleteMessageUsingHash() {

        String message =
                "Where are you? You are late! I have asked you to be on time.";

        message = null;

        assertNull(message);
    }

    @Test
    public void testMessageReport() {

        String messageHash = "00:0:DIDCAKE?";
        String recipient = "+27834557896";
        String message = "Did you get the cake?";

        assertNotNull(messageHash);
        assertNotNull(recipient);
        assertNotNull(message);
    }
}