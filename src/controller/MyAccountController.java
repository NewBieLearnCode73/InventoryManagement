/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UsersDAO;
import helper.BCrypt.BcryptHash;
import helper.util.Validate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import model.Users;
import raven.application.Application;
import raven.application.form.other.FormMyAccount;
import raven.toast.Notifications;

public class MyAccountController implements Action, MouseListener, KeyListener {

    public FormMyAccount view;
    private Users tempUser = new Users();

    public MyAccountController(FormMyAccount view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        String password = new String(this.view.jPasswordField.getPassword());
        if (source.equals("Change Information")) {
            if (Validate.getInstance().isEmailValid(this.view.jTextFieldEmail.getText())) {
                if (Validate.getInstance().isPasswordValid(password)) {

                    this.tempUser.setEmail(this.view.jTextFieldEmail.getText());
                    this.tempUser.setPassword(BcryptHash.hashPassword(password));
                    this.tempUser.setRole(this.view.jTextFieldRole.getText());
                    this.tempUser.setStatus(this.view.jTextFieldStatus.getText());
                    this.tempUser.setUsername(this.view.jTextFieldUsername.getText());
                    this.tempUser.setUserID(Integer.parseInt(this.view.tempUserID.getText()));

                    UsersDAO.getInstance().update(tempUser);
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Changing Information Successfully!");
                    Application.showForm(new FormMyAccount());
                } else {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Password must contain at least 1 special character, 1 number, 1 capital letter and must be 6 characters or more.");
                }

            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.BOTTOM_RIGHT, "Email not valid please try again!");

            }
        }
    }

    @Override
    public Object getValue(String key) {
        return null;
    }

    @Override
    public void putValue(String key, Object value) {
    }

    @Override
    public void setEnabled(boolean b) {
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean accept(Object sender) {
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
