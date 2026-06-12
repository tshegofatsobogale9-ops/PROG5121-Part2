/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Message {

    static int totalMessagesSent = 0;

    static ArrayList<String> sentMessages = new ArrayList<>();
    static ArrayList<String> storedMessages = new ArrayList<>();
    static ArrayList<String> disregardedMessages = new ArrayList<>();
    static ArrayList<String> messageIDs = new ArrayList<>();
    static ArrayList<String> messageHashes = new ArrayList<>();
    static ArrayList<String> recipients = new ArrayList<>();

    public static void quickChat(Scanner scanner) {

        System.out.println("\nWelcome to QuickChat");

        boolean running = true;

        while (running) {

            System.out.println("\n===== QUICKCHAT MENU =====");
            System.out.println("1. Send Messages");
            System.out.println("2. Show Recently Sent Messages");
            System.out.println("3. Stored Messages Report");
            System.out.println("4. Show Longest Stored Message");
            System.out.println("5. Quit");

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

                            System.out.println("Enter recipient number:");
                            recipient = scanner.nextLine();

                            if (recipient.startsWith("+27")
                                    && recipient.length() == 12) {
                                break;
                            }

                            System.out.println(
                                    "Cell phone number incorrectly formatted.");
                        }

                        String messageText;

                        while (true) {

                            System.out.println("Enter your message:");
                            messageText = scanner.nextLine();

                            if (messageText.length() <= 250) {
                                System.out.println("Message ready to send.");
                                break;
                            }

                            int extra =
                                    messageText.length() - 250;

                            System.out.println(
                                    "Message exceeds 250 characters by "
                                    + extra
                                    + ", please reduce size.");
                        }

                        Random random = new Random();

                        long number =
                                1000000000L
                                + (long) (random.nextDouble()
                                * 9000000000L);

                        String messageID =
                                String.valueOf(number);

                        String[] words =
                                messageText.split(" ");

                        String firstWord =
                                words[0].toUpperCase();

                        String lastWord =
                                words[words.length - 1]
                                        .toUpperCase();

                        String messageHash =
                                "00:"
                                + (i + 1)
                                + ":"
                                + firstWord
                                + lastWord;

                        System.out.println("\n1. Send Message");
                        System.out.println("2. Disregard Message");
                        System.out.println("3. Store Message");

                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {

                            case 1:

                                sentMessages.add(messageText);
                                messageIDs.add(messageID);
                                messageHashes.add(messageHash);
                                recipients.add(recipient);

                                totalMessagesSent++;

                                System.out.println(
                                        "Message successfully sent.");
                                break;

                            case 2:

                                disregardedMessages.add(messageText);

                                System.out.println(
                                        "Message disregarded.");
                                break;

                            case 3:

                                storedMessages.add(messageText);
                                messageIDs.add(messageID);
                                messageHashes.add(messageHash);
                                recipients.add(recipient);

                                storeMessage(
                                        messageID,
                                        messageHash,
                                        recipient,
                                        messageText);

                                System.out.println(
                                        "Message successfully stored.");

                                break;

                            default:

                                System.out.println(
                                        "Invalid option.");
                        }

                        System.out.println(
                                "\n===== MESSAGE DETAILS =====");

                        System.out.println(
                                "Message ID: "
                                + messageID);

                        System.out.println(
                                "Message Hash: "
                                + messageHash);

                        System.out.println(
                                "Recipient: "
                                + recipient);

                        System.out.println(
                                "Message: "
                                + messageText);
                    }

                    System.out.println(
                            "\nTotal Messages Sent: "
                            + totalMessagesSent);

                    break;

                case 2:

                    System.out.println(
                            "\n===== SENT MESSAGES =====");

                    if (sentMessages.isEmpty()) {

                        System.out.println(
                                "No sent messages.");

                    } else {

                        for (String msg : sentMessages) {

                            System.out.println(msg);
                        }
                    }

                    break;

                case 3:

                    System.out.println(
                            "\n===== STORED MESSAGE REPORT =====");

                    if (storedMessages.isEmpty()) {

                        System.out.println(
                                "No stored messages.");

                    } else {

                        for (int x = 0;
                                x < storedMessages.size();
                                x++) {

                            System.out.println(
                                    "Recipient: "
                                    + recipients.get(x));

                            System.out.println(
                                    "Message ID: "
                                    + messageIDs.get(x));

                            System.out.println(
                                    "Message Hash: "
                                    + messageHashes.get(x));

                            System.out.println(
                                    "Message: "
                                    + storedMessages.get(x));

                            System.out.println(
                                    "----------------------");
                        }
                    }

                    break;

                case 4:

                    displayLongestStoredMessage();
                    break;

                case 5:

                    running = false;

                    System.out.println(
                            "Application Closed.");

                    break;

                default:

                    System.out.println(
                            "Invalid option.");
            }
        }
    }

    public static void displayLongestStoredMessage() {

        if (storedMessages.isEmpty()) {

            System.out.println(
                    "No stored messages.");

            return;
        }

        String longest = storedMessages.get(0);

        for (String msg : storedMessages) {

            if (msg.length() > longest.length()) {

                longest = msg;
            }
        }

        System.out.println(
                "\nLongest Stored Message:");

        System.out.println(longest);
    }

    public static void storeMessage(
            String messageID,
            String messageHash,
            String recipient,
            String messageText) {

        try {

            FileWriter file =
                    new FileWriter(
                            "messages.txt",
                            true);

            file.write(
                    "Message ID: "
                    + messageID + "\n");

            file.write(
                    "Message Hash: "
                    + messageHash + "\n");

            file.write(
                    "Recipient: "
                    + recipient + "\n");

            file.write(
                    "Message: "
                    + messageText + "\n");

            file.write(
                    "----------------------------\n");

            file.close();

        } catch (IOException e) {

            System.out.println(
                    "Error storing message.");
        }
    }
}