package com.mycompany.registration;

import java.util.Scanner;

/**
 *
 * @author Tsheg
 */
class Login {

   //Cheeck Username
    boolean checkUserName(String username) {

        return username.contains("_")
                && username.length() <= 5;
    }

    //Check Password
    boolean checkPasswordComplexity(String password) {

        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[!@#$%^&*()].*");
    }

   //Check CellPhone Number
    boolean checkCellPhoneNumber(String cellPhoneNumber) {

        return cellPhoneNumber.startsWith("+27")
                && cellPhoneNumber.length() <= 12;
    }

   // Register User
    String registerUser(
            String username,
            String password,
            String cellPhoneNumber) {

        if (!checkUserName(username)) {

            return "Username is not correctly formatted.";
        }

        if (!checkPasswordComplexity(password)) {

            return "Password is not correctly formatted.";
        }

        if (!checkCellPhoneNumber(cellPhoneNumber)) {

            return "Cellphone number incorrectly formatted.";
        }

        return "User has been registered successfully.";
    }
//Login User
    public boolean loginUser(
            Scanner scanner,
            String username,
            String password,
            String firstName,
            String lastName) {

        String inputUsername;
        String inputPassword;

        boolean isValid = false;

        while (!isValid) {

            System.out.println("\n=== LOGIN ===");

            System.out.println("Enter username:");
            inputUsername = scanner.nextLine();

            System.out.println("Enter password:");
            inputPassword = scanner.nextLine();

            // Validate Login
            if (inputUsername.equals(username)
                    && inputPassword.equals(password)) {

                System.out.println("Welcome "
                        + firstName + " "
                        + lastName
                        + ", it is great to see you again.");

                isValid = true;
                return true;

            } else {

                System.out.println("Username or password incorrect.");
            }
        }

        return false;
    }
}