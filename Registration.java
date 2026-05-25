/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration;
import java.util.Scanner;
/**
 *
 * @author Tsheg
 */
public class Registration {

    public static void main(String[] args) {
   

       Scanner scanner = new Scanner(System.in);

        Login login = new Login();

        // Variables
        String username = "";
        String password = "";
        String cellPhoneNumber;
        String firstName;
        String lastName;

        boolean isValid = false;

        //Registration 
        System.out.println("Enter first name:");
        firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        lastName = scanner.nextLine();

        // Username Validation
        while (!isValid) {

            System.out.println("Enter username:");
            System.out.println("Username must contain an underscore and be no more than 5 characters long.");

            username = scanner.nextLine();

            if (username.contains("_")
                    && username.length() <= 5) {

                System.out.println("Username successfully captured.");
                isValid = true;

            } else {

                System.out.println("Username is not correctly formatted.");
            }
        }

        // Password Validation
        isValid = false;

        while (!isValid) {

            System.out.println("Enter password:");
            System.out.println("Password must be at least 8 characters long, contain a capital letter, number and special character.");

            password = scanner.nextLine();

            if (password.length() >= 8
                    && password.matches(".*[0-9].*")
                    && password.matches(".*[A-Z].*")
                    && password.matches(".*[!@#$%^&*()].*")) {

                System.out.println("Password successfully captured.");
                isValid = true;

            } else {

                System.out.println("Password is not correctly formatted.");
            }
        }

        // Cellphone Validation
        isValid = false;

        while (!isValid) {

            System.out.println("Enter cellphone number:");
            System.out.println("Cellphone number must contain +27");

            cellPhoneNumber = scanner.nextLine();

            if (cellPhoneNumber.startsWith("+27")
                    && cellPhoneNumber.length() <= 12) {

                System.out.println("Cellphone number successfully added.");
                System.out.println("Registration successful!");

                isValid = true;

            } else {

                System.out.println("Cellphone number incorrectly formatted.");
            }
        }

        //Login

        boolean loginSuccess = login.loginUser(
                scanner,
                username,
                password,
                firstName,
                lastName);

        //Quick Chart

        if (loginSuccess) {

            Message.quickChat(scanner);
        }

        scanner.close();
    }
}
    

