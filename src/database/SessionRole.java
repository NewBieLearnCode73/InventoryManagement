/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package database;


public class SessionRole {
    private static int id = 0;
    private static String role = null;
    private static String status = null;
    
    public static void setId(int id) {
        SessionRole.id = id;
    }

    public static void setRole(String role) {
        SessionRole.role = role;
    }

    public static int getId() {
        return id;
    }

    public static String getRole() {
        return role;
    }

    public static void setStatus(String status) {
        SessionRole.status = status;
    }

    public static String getStatus() {
        return status;
    }
    
    public static void resetSession(){
        id = 0;
        role = null;
        status = null;
    }
}

