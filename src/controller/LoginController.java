/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import helper.preferencesManager.UserPreferences;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import raven.application.Application;
import raven.application.form.LoginForm;
import raven.toast.Notifications;


public class LoginController implements Action{
    public LoginForm view;

    public LoginController(LoginForm view) {
		super();
		this.view = view;
	}

    
     @Override
    public void actionPerformed(ActionEvent e) {

         // Lấy tên nút
        String source = e.getActionCommand();
        String username = this.view.txtUser.getText().trim();        
        String password = new String(this.view.txtPass.getPassword());

        if(source.equals("Login")){
            if (this.view.authenticateUser(username, password)) {
                // lưu vào preference
                try {
                    this.view.userPreferences.saveLogin(username, password);
                } catch (GeneralSecurityException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               Application.login();
               Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Đăng nhập thành công");
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Đăng nhập thất bại");
            }
        }
    }
    
    

    @Override
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEnabled(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}

