/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UsersDAO;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import raven.application.Application;
import raven.application.form.RegisterForm;
import raven.toast.Notifications;

/**
 *
 * @author acer
 */
public class RegisterController implements Action {

    public RegisterForm view;

    public RegisterController(RegisterForm regiserForm) {
        this.view = regiserForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String src = e.getActionCommand();

        String username = this.view.txtUsername.getText().trim();
        String email = this.view.txtEmail.getText().trim();
        String password = this.view.txtPassword.getText().trim();

        if (src.equals("Register")) {

            if (username.isBlank() || email.isBlank() || password.isBlank()) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Vui lòng điền đầy đủ thông tin");
                return;
            }
            
            if (this.view.checkAccountIsExist(username, email)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Tài khoản đã tồn tại");
            } else {
                UsersDAO.getInstance().registerUser(username, email, password);
                Application.navigateToMainScreen();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Đăng kí thành công");
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
