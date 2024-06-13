/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import dao.UsersDAO;


public class LoginModel {
        private String loginUsername;
	private String loginPassword;
	
	public LoginModel() {
		super();
	}
	
	public LoginModel(String loginUsername, String loginPassword) {
		super();
		this.loginUsername = loginUsername;
		this.loginPassword = loginPassword;
	}
	
	public String getLoginUsername() {
		return loginUsername;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	@Override
	public String toString() {
		return "LoginModel [loginUsername=" + loginUsername + ", loginPassword=" + loginPassword + "]";
	}
	
	public boolean authenticateUserModel() {
		UsersDAO auth = new UsersDAO();
		Boolean check = auth.authenticateUser(loginUsername, loginPassword);
		
            return check == true;
	}
}

