/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tsheg
 */
class Message {

   
  static int totalMessagesSent = 0;

    public static void quickChat(Scanner scanner) {

        System.out.println("\nWelcome to QuickChat.");

        boolean running = true;

        while (running) {

            System.out.println("\n1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");

            System.out.print("Choose option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:

                    System.out.println("How many messages would you like to send?");
                    int totalMessages = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < totalMessages; i++) {

                       String recipient;

                        while (true) {

                        System.out.println("\nEnter recipient number:");
                        recipient = scanner.nextLine();

                        // Validate Recipient
                        if (recipient.startsWith("+27")
                        && recipient.length() == 12) {

                        break;

                        } else {

                        System.out.println(
                        "Cell phone number incorrectly formatted. "
                        + "Must start with +27 and be 12 characters long.");
                        }
                        }
                       String messageText;

                       while (true) {

                        System.out.println("Enter your message:");
                        messageText = scanner.nextLine();

                        int length = messageText.length();

                        if (length <= 250) {

                        System.out.println("Message accepted.");
                        break;

                        } else {

                        System.out.println("Message rejected. Message must be 250 characters or less. Current: " + length);
                        }
                        }
                        
                        // Generate Message ID
                        Random random = new Random();

                        long number = 1000000000L
                                + (long) (random.nextDouble() * 9000000000L);

                        String messageID = String.valueOf(number);

                        // Create Message Hash
                        String[] words = messageText.split(" ");

                        String firstWord = words[0].toUpperCase();
                        String lastWord = words[words.length - 1].toUpperCase();

                        String messageHash = "00:"
                        + i
                        + ":"
                        + firstWord
                        + lastWord;

                        // Options
                        System.out.println("\n1. Send Message");
                        System.out.println("2. Disregard Message");
                        System.out.println("3. Store Message to send later");

                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {

                            case 1:

                                System.out.println("Message successfully sent.");
                                break;

                            case 2:

                                System.out.println("Press 0 to delete message");
                                break;

                            case 3:

                                storeMessage(
                                        messageID,
                                        messageHash,
                                        recipient,
                                        messageText);

                                break;

                            default:

                                System.out.println("Invalid option.");
                        }

                        // Display Message Details
                        System.out.println("\n===== MESSAGE DETAILS =====");

                        System.out.println("Message ID: " + messageID);
                        System.out.println("Message Hash: " + messageHash);
                        System.out.println("Recipient: " + recipient);
                        System.out.println("Message: " + messageText);

                        totalMessagesSent++;
                    }

                    System.out.println("\nTotal messages sent: "
                            + totalMessagesSent);

                    break;

                case 2:

                    System.out.println("Coming Soon.");
                    break;

                case 3:

                    running = false;

                    System.out.println("Application Closed.");
                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }
    }

    // Store Message Method
    public static void storeMessage(
            String messageID,
            String messageHash,
            String recipient,
            String messageText) {

        try {

            FileWriter file = new FileWriter(
                    "messages.txt", true);

            file.write("Message ID: "
                    + messageID + "\n");

            file.write("Message Hash: "
                    + messageHash + "\n");

            file.write("Recipient: "
                    + recipient + "\n");

            file.write("Message: "
                    + messageText + "\n");

            file.write("----------------------------------\n");

            file.close();

            System.out.println("Message successfully stored.");

        } catch (IOException e) {

            System.out.println("Error storing message.");
        }
    }
} 

