/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import raven.application.form.other.FormAdminControl;

public class AdminControlController implements Action, MouseListener, KeyListener {

    public FormAdminControl view;

    public AdminControlController(FormAdminControl view) {
        this.view = view;
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
    public void actionPerformed(ActionEvent e) {
    }

    // Xử lí click chuột
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.jTableUsers) {
            int row = this.view.jTableUsers.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) this.view.jTableUsers.getModel();

            this.view.IDtempt.setText(model.getValueAt(row, 0).toString());
        }
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
        if (e.getSource() == this.view.jTextFieldFind) {
            System.out.println("sssss");
            DefaultTableModel obj = (DefaultTableModel) this.view.jTableUsers.getModel();
            TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
            this.view.jTableUsers.setRowSorter(obj1);
            obj1.setRowFilter(RowFilter.regexFilter(this.view.jTextFieldFind.getText()));
        }
    }

}
