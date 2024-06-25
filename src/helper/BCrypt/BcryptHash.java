/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package helper.BCrypt;

import org.mindrot.jbcrypt.BCrypt;


public class BcryptHash {
// Method to hash a password using BCrypt
    public static String hashPassword(String password) {
        // Generate a salt and hash the password
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    public static boolean checkPassword(String enteredPassword, String hashedPassword) {
        return BCrypt.checkpw(enteredPassword, hashedPassword);
    }

//    public static void main(String[] args) {
//        String password = "admin";
//        String hashedPassword = hashPassword(password);
//
//        System.out.println("Original Password: " + password);
//        System.out.println("Hashed Password: " + hashedPassword);
//
//        // Test the password verification
//        boolean isPasswordCorrect = checkPassword(password, hashedPassword);
//        System.out.println("Password verification: " + (isPasswordCorrect ? "Success" : "Failure"));
//    }
}

