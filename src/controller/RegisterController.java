/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UsersDAO;
import helper.util.Constant;
import helper.util.Validate;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
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
        String password = new String(this.view.txtPassword.getPassword());
        String role = this.view.roleComboBox.getSelectedItem().toString();

        if (src.equals("Register")) {

            if (username.isBlank() || email.isBlank() || password.isBlank()) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, Constant.FORM_NOT_FILL);
                return;
            }

            if (!Validate.getInstance().isEmailValid(email)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, Constant.VALIDATE_EMAIL_ERROR);
                return;
            }
            
            if (!Validate.getInstance().isPasswordValid(password)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, Constant.VALIDATE_PASSWORD_ERROR);
                return;
            }
            
            
            if (this.view.checkAccountIsExist(username, email)) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, Constant.ACCOUNT_EXIST);
                return;
            }
            
            UsersDAO.getInstance().registerUser(username, email, password, role);
            this.view.resetForm();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, Constant.SUCCESS_REGISTER);

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
