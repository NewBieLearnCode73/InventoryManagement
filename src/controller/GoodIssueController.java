package controller;

import dao.InventoryDAO;
import helper.globalVariables.CartInventory;
import static helper.processImage.processImage.getImage;
import helper.util.Constant;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Inventory;
import raven.application.form.other.FormGoodIssue;
import raven.toast.Notifications;

public class GoodIssueController implements Action, MouseListener, KeyListener {

    public FormGoodIssue view;
    // Lưu số lượng đơn hàng
//    public ArrayList<Inventory> listInventorys = new ArrayList<>();

    public GoodIssueController(FormGoodIssue view) {
        this.view = view;
    }

    // Load cart
    public void LoadCart() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) this.view.inventoryCart.getModel();

            tableModel.setRowCount(0);

            //         "ID", "Barcode", "Type", "Name", "Price", "Quantity", "Image"
            for (Inventory inventory : CartInventory.listInventorys) {
                Object[] row = new Object[]{
                    inventory.getInventoryID(),
                    inventory.getBarcode(),
                    inventory.getType(),
                    inventory.getName(),
                    inventory.getSellingPrice(),
                    inventory.getQuantity(),
                    inventory.getImage()
                };
                tableModel.addRow(row);
            }

            this.view.inventoryCart.setModel(tableModel);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, Constant.LOAD_CART);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, Constant.LOAD_CART_ERROR);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

        // Xử lý khi ấn "Add to cart"
        if (src.equals("Add to cart")) {
            // Kiểm tra các trường không rỗng
            if (!"".equals(this.view.inventoryId.getText())
                    && !"".equals(this.view.inventoryBarcode.getText())
                    && !"".equals(this.view.inventoryType.getText())
                    && !"".equals(this.view.inventoryName.getText())
                    && !"".equals(this.view.inventorySellingPrice.getText())) {

                // Kiểm tra giá trị của JSpinner inventoryQuantity
                int quantity = (int) this.view.inventoryQuantity.getValue();
                if (quantity != 0) {

                    Inventory freeTempInventory = InventoryDAO.getInstance().getById(Integer.parseInt(this.view.inventoryId.getText()));

                    // Kiểm tra giá trị của quantity
                    int availableQuantity = freeTempInventory.getQuantity();
                    if (quantity > 0 && quantity <= availableQuantity) {
                        // Tạo một đối tượng Inventory mới
                        Inventory tempInventory = new Inventory();
                        tempInventory.setInventoryID(Integer.parseInt(this.view.inventoryId.getText()));
                        tempInventory.setBarcode(Integer.valueOf(this.view.inventoryBarcode.getText()));
                        tempInventory.setType(this.view.inventoryType.getText());
                        tempInventory.setName(this.view.inventoryName.getText());
                        tempInventory.setSellingPrice(Double.parseDouble(this.view.inventorySellingPrice.getText()));
                        tempInventory.setQuantity(quantity);

                        if (this.view.inventoryImageName.getText() == null || "".equals(this.view.inventoryImageName.getText())) {
                            tempInventory.setImage("place_holder_image.png");
                        } else {
                            tempInventory.setImage(this.view.inventoryImageName.getText());
                        }

                        // Kiểm tra xem bên trong list có tồn tại Inventory có trùng ID với inventory vừa thêm vào hay không
                        boolean found = false;
                        for (Inventory listInventory : CartInventory.listInventorys) {
                            if (listInventory.getInventoryID() == tempInventory.getInventoryID()) {
                                listInventory.setQuantity(tempInventory.getQuantity() + listInventory.getQuantity());
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            CartInventory.listInventorys.add(tempInventory);
                        }

                        // In danh sách Inventory
                        for (Inventory listInventory : CartInventory.listInventorys) {
                            System.out.println(listInventory.toString());
                        }

                        // Đổ dữ liệu vào table cart
                        this.LoadCart();

                    } else {
                        JOptionPane.showMessageDialog(this.view, "Please select a product quantity greater than 0 and less than the quantity currently in stock", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(this.view, "Please select product quantity", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this.view, "Please choose item in Inventory table", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        // Xóa toàn bộ giỏ hàng hiện tại
        if (src.equals("Reset cart")){
            CartInventory.listInventorys.clear();
            this.LoadCart();
        }
        // Xóa 1 phần tử khỏi cart
        if (src.equals("Delete from cart")) {
        int selectedRow = this.view.inventoryCart.getSelectedRow();
        if (selectedRow != -1) { 
            DefaultTableModel model = (DefaultTableModel) this.view.inventoryCart.getModel();
            int inventoryIDToDelete = (int) model.getValueAt(selectedRow, 0); 

            for (int i = 0; i < CartInventory.listInventorys.size(); i++) {
                if (CartInventory.listInventorys.get(i).getInventoryID() == inventoryIDToDelete) {
                   CartInventory.listInventorys.remove(i);
                    break; 
                }

                this.LoadCart();
            }
        }

        // Sự kiện tìm kiếm trong bảng inventory
        if (src.equals("Find")) {
            DefaultTableModel obj = (DefaultTableModel) this.view.inventoryTable.getModel();
            TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
            this.view.inventoryTable.setRowSorter(obj1);
            obj1.setRowFilter(RowFilter.regexFilter(this.view.jTextFieldFind.getText()));
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
    }}

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

        if (e.getSource() == this.view.inventoryTable) {
            int row = this.view.inventoryTable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) this.view.inventoryTable.getModel();

            Object idValue = model.getValueAt(row, 0);
            Object barcodeValue = model.getValueAt(row, 1);
            Object typeValue = model.getValueAt(row, 2);
            Object nameValue = model.getValueAt(row, 3);
            Object sellingPriceValue = model.getValueAt(row, 4);
            Object quantityAvailableValue = model.getValueAt(row, 5);
            Object imageNameValue = model.getValueAt(row, 6);

            this.view.inventoryId.setText(idValue != null ? idValue.toString() : "");
            this.view.inventoryBarcode.setText(barcodeValue != null ? barcodeValue.toString() : "");
            this.view.inventoryType.setText(typeValue != null ? typeValue.toString() : "");
            this.view.inventoryName.setText(nameValue != null ? nameValue.toString() : "");
            this.view.inventorySellingPrice.setText(sellingPriceValue != null ? sellingPriceValue.toString() : "");
            this.view.inventoryQuantityAvailable.setText(quantityAvailableValue != null ? quantityAvailableValue.toString() : "");

            if (imageNameValue == null || "".equals(imageNameValue.toString())) {
                this.view.inventoryImageName.setText("");
                this.view.inventoryImage.setIcon(getImage("place_holder_image.png"));
            } else {
                this.view.inventoryImageName.setText(imageNameValue.toString());
                this.view.inventoryImage.setIcon(getImage(imageNameValue.toString()));
            }
        }

        if (e.getSource() == this.view.inventoryCart) {
            int row = this.view.inventoryCart.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) this.view.inventoryCart.getModel();

            Object idValue = model.getValueAt(row, 0);
            Object barcodeValue = model.getValueAt(row, 1);
            Object typeValue = model.getValueAt(row, 2);
            Object nameValue = model.getValueAt(row, 3);
            Object sellingPriceValue = model.getValueAt(row, 4);
            Object quantityAvailableValue = model.getValueAt(row, 5);
            Object imageNameValue = model.getValueAt(row, 6);

            this.view.inventoryId.setText(idValue != null ? idValue.toString() : "");
            this.view.inventoryBarcode.setText(barcodeValue != null ? barcodeValue.toString() : "");
            this.view.inventoryType.setText(typeValue != null ? typeValue.toString() : "");
            this.view.inventoryName.setText(nameValue != null ? nameValue.toString() : "");
            this.view.inventorySellingPrice.setText(sellingPriceValue != null ? sellingPriceValue.toString() : "");
            this.view.inventoryQuantityAvailable.setText(quantityAvailableValue != null ? quantityAvailableValue.toString() : "");

            if (imageNameValue == null || "".equals(imageNameValue.toString())) {
                this.view.inventoryImageName.setText("");
                this.view.inventoryImage.setIcon(getImage("place_holder_image.png"));
            } else {
                this.view.inventoryImageName.setText(imageNameValue.toString());
                this.view.inventoryImage.setIcon(getImage(imageNameValue.toString()));
            }
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
            DefaultTableModel obj = (DefaultTableModel) this.view.inventoryTable.getModel();
            TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
            this.view.inventoryTable.setRowSorter(obj1);
            obj1.setRowFilter(RowFilter.regexFilter(this.view.jTextFieldFind.getText()));
        }
    }
}
