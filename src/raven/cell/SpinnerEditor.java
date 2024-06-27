/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.cell;

import helper.globalVariables.CartInventory;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
import model.Inventory;
import raven.application.form.other.CartForm;

/**
 *
 * @author GXA
 */
public class SpinnerEditor extends DefaultCellEditor {
    JSpinner spinner;
    JSpinner.DefaultEditor editor;
    JTextField textField;
    JTable table;
    CartForm view;
    boolean valueSet;

    public SpinnerEditor(CartForm view) {
        super(new JTextField());
        spinner = new JSpinner();
        editor = ((JSpinner.DefaultEditor)spinner.getEditor());
        textField = editor.getTextField();
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent fe) {
                SwingUtilities.invokeLater(() -> {
                    if (valueSet) {
                        textField.setCaretPosition(1);
                    }
                });
            }
            public void focusLost(FocusEvent fe) {}
        });
        textField.addActionListener(ae -> stopCellEditing());
        this.view = view;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table =table;
        if (!valueSet) {
            spinner.setValue(value);
        }
        SwingUtilities.invokeLater(() -> textField.requestFocus());
        return spinner;
    }

    @Override
    public boolean isCellEditable(EventObject eo) {
        if (eo instanceof KeyEvent) {
            KeyEvent ke = (KeyEvent)eo;
            textField.setText(String.valueOf(ke.getKeyChar()));
            valueSet = true;
        } else {
            valueSet = false;
        }
        return true;
    }

    @Override
    public Object getCellEditorValue() {
        return spinner.getValue();
    }

    @Override
    public boolean stopCellEditing() {
        try {
            editor.commitEdit();
            spinner.commitEdit();
            
            // Lấy giá trị của spinner
            Object newValue = spinner.getValue();
            
            // Lấy mô hình dữ liệu của bảng
            TableModel model = table.getModel();
            
            // Lấy giá trị của cột đầu tiên (ID)
            Object idValue = model.getValueAt(table.getSelectedRow(), 0);
            int inventoryID = Integer.parseInt(idValue.toString()); // Đảm bảo rằng giá trị được chuyển đổi sang int
            
            // Cập nhật lại cartInventorys
            for (Inventory inventory : CartInventory.listInventorys) {
                if (inventory.getInventoryID() == inventoryID) {
                    // Cập nhật thông tin inventory
                    // Ví dụ: Cập nhật số lượng
                    int newQuantity = (int) newValue; // Đảm bảo rằng newValue là kiểu số nguyên
                    inventory.setQuantity(newQuantity);
                    break; // Đã tìm thấy và cập nhật, thoát vòng lặp
                }
            }
            this.view.Load();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid value, discarding.");
        }
        
        return super.stopCellEditing();
    }
}
