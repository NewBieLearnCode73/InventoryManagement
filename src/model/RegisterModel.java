/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.UsersDAO;

/**
 *
 * @author acer
 */
public class RegisterModel {
    private String username;
    private String password;
    private String email;

    public RegisterModel() {
    }

    public RegisterModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public boolean checkUserIsExist() {
        UsersDAO usersDAO = new UsersDAO();
        
        return usersDAO.checkAccountIsExist(username);
    }
}
    