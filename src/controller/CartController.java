/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.InventoryDAO;
import helper.barcodeScaner.BarcodeScannerTask;
import helper.globalVariables.CartInventory;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Inventory;
import raven.application.form.other.CartForm;
import raven.toast.Notifications;

/**
 *
 * @author GXA
 */
public class CartController implements Action {
    
    public CartForm view;
    public CartController(CartForm view) {
        this.view = view;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Scan")) {
               Thread scannerThread = new Thread(new BarcodeScannerTask(this.view.barcodeField));
               scannerThread.start();
            try {
                scannerThread.join();
                Inventory freeTempInventory = InventoryDAO.getInstance().getByBarcode(this.view.barcodeField.getText());
                    // Kiểm tra giá trị của quantity\
                    if (freeTempInventory != null) {
                        freeTempInventory.setQuantity(1);
                        boolean found = false;
                        for (Inventory listInventory : CartInventory.listInventorys) {
                            if (listInventory.getInventoryID() == freeTempInventory.getInventoryID()) {
                                listInventory.setQuantity(1 + listInventory.getQuantity());
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            CartInventory.listInventorys.add(freeTempInventory);
                        }

                        // In danh sách Inventory
                        for (Inventory listInventory : CartInventory.listInventorys) {
                            System.out.println(listInventory.toString());
                        }

                        // Đổ dữ liệu vào table cart
                        this.LoadCart();

                    } else {
                        JOptionPane.showMessageDialog(this.view, "Something Wrong, Maybe your inventory is not exist.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, "sai cái scan chỗ tìm", ex);
            }
        }
        
                // Xuất hóa đơn
        if (src.equals("Export invoice")) {
            if (!CartInventory.listInventorys.isEmpty()) {
                // Prompt confirmation before exporting
                int dialogResult = JOptionPane.showConfirmDialog(this.view, "Are you sure you want to export the invoice?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (dialogResult == JOptionPane.YES_OPTION) {
                    boolean exportInvoice = InventoryDAO.getInstance().exportInvoice(CartInventory.listInventorys);
                    
                    if (exportInvoice) {
                        this.view.Load();
                        CartInventory.listInventorys.clear();
                        this.LoadCart();
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Export Invoice Successfully!");
                    } else {
                        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Export Invoice Error!");
                    }
                } else {
                    System.out.println("Export invoice canceled by user.");
                }

            } else {
                JOptionPane.showMessageDialog(this.view, "Please select at least one product", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
     public void LoadCart() {
         // load vô cái cart
          DefaultTableModel cartTableModel = (DefaultTableModel) this.view.inventoryCart.getModel();

            cartTableModel.setRowCount(0);
            int quantity =0;            
            int totalCost =0;

            for (Inventory inventory : CartInventory.listInventorys) {
                Object[] row = new Object[]{
                    inventory.getInventoryID(),
                    inventory.getBarcode(),
                    inventory.getName(),
                    inventory.getSellingPrice(),
                    inventory.getQuantity(),
                    inventory.getSellingPrice()*inventory.getQuantity(),
                };
                cartTableModel.addRow(row);
                quantity += inventory.getQuantity();
                totalCost += inventory.getSellingPrice()*inventory.getQuantity();
            }
            this.view.inventoryCart.setModel(cartTableModel);
            this.view.quantityJLabel.setText(String.valueOf(quantity));            
            this.view.totalCostJLabel.setText(String.valueOf(totalCost));            
            this.view.finalCostJLabel.setText(String.valueOf(totalCost));


            
    }
}
