package controller;

import dao.InventoryDAO;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static helper.processImage.processImage.deleteImage;
import static helper.processImage.processImage.getImage;
import static helper.processImage.processImage.getImageNameExtension;
import static helper.processImage.processImage.moveImage;
import static helper.processImage.processImage.resizeImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;

import model.Inventory;
import raven.application.form.other.FormGoodReceipt;
import raven.toast.Notifications;

public class GoodReciptController implements Action, MouseListener, KeyListener {

    public FormGoodReceipt view;
    public Inventory inventory = new Inventory(); // Đối tượng lưu tạm thời
    public String rootImagePath = ""; // Thư mục gốc của ảnh trong ổ đĩa

    public GoodReciptController(FormGoodReceipt view) {
        this.view = view;
    }

    // Xử lí nhấn nút
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();

        JFileChooser fc = new JFileChooser();

        if (src.equals("Browse")) {
            // Hiện dialog
            int returnVal = fc.showOpenDialog(this.view);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // Lấy được file
                File file = fc.getSelectedFile();

                // Lấy tên file
                String fileName = file.getName();

                // Kiểm tra đuôi
                if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".gif")) {
                    try {
                        // Đọc ảnh từ file
                        BufferedImage originalImage = ImageIO.read(file);

                        // Thay đổi kích thước ảnh
                        BufferedImage resizedImage = resizeImage(originalImage, 284, 177);

                        // Tạo ImageIcon từ ảnh đã thay đổi kích thước
                        ImageIcon imageIcon = new ImageIcon(resizedImage);
                        this.view.inventoryImage.setIcon(imageIcon);

                        // Lưu đường dẫn ảnh gốc
                        rootImagePath = file.getAbsolutePath();

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this.view, "Không thể đọc file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this.view, "Chỉ chấp nhận các file ảnh (.jpg, .png, .gif)", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (src.equals("Reset Form")) {
            this.view.DeleteAllForm();
            this.view.btnInventoryAdd.setEnabled(true);
            this.view.btnInventoryUpdate.setEnabled(false);
        }

        if (src.equals("Add")) {
            if (this.view.inventoryComboBoxType.getSelectedIndex() != -1
                    && !this.view.inventoryName.getText().isEmpty()
                    && !this.view.inventoryQuantity.getText().isEmpty()
                    && this.view.inventoryPurchasingPrice.getText() != null
                    && this.view.inventorySellingPrice.getText() != null
                    && this.view.inventoryBarcode.getText() != null
                    && this.view.inventoryComboBoxStatus.getSelectedIndex() != -1) {

                String Type = this.view.inventoryComboBoxType.getSelectedItem().toString();
                String Name = this.view.inventoryName.getText();
                int Quantity = Integer.parseInt(this.view.inventoryQuantity.getText());
                String Description = this.view.inventoryDescription.getText();
                Double PurchasingPrice = Double.valueOf(this.view.inventoryPurchasingPrice.getText());
                Double SellingPrice = Double.valueOf(this.view.inventorySellingPrice.getText());
                int Barcode = Integer.parseInt(this.view.inventoryBarcode.getText());
                String Status = this.view.inventoryComboBoxStatus.getSelectedItem().toString();

                Inventory temptInventory = new Inventory();
                temptInventory.setType(Type);
                temptInventory.setName(Name);
                temptInventory.setQuantity(Quantity);
                temptInventory.setDescription(Description);
                temptInventory.setPurchasingPrice(PurchasingPrice);
                temptInventory.setSellingPrice(SellingPrice);
                temptInventory.setBarcode(Barcode);
                temptInventory.setStatus(Status);

                String fileName = moveImage(rootImagePath);

                temptInventory.setImage(getImageNameExtension(fileName));

                InventoryDAO.getInstance().insert(temptInventory);

                this.view.SupperLoadingData();

            } else {
                JOptionPane.showMessageDialog(this.view, "Please fill in the fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (src.equals("Find")) {
            DefaultTableModel obj = (DefaultTableModel) this.view.inventoryTable.getModel();
            TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
            this.view.inventoryTable.setRowSorter(obj1);
            obj1.setRowFilter(RowFilter.regexFilter(this.view.jTextFieldFind.getText()));
        }

        if (src.equals("Load")) {
            this.view.jTextFieldFind.setText("");
            this.view.SupperLoadingData();
        }

        if (src.equals("Delete")) {
            int row = this.view.inventoryTable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) this.view.inventoryTable.getModel();

            // Lấy được id 
            InventoryDAO.getInstance().delete(Integer.parseInt(model.getValueAt(row, 0).toString()));
            
            if ((model.getValueAt(row, 7) != null && !"".equals(model.getValueAt(row, 7).toString())) && !"place_holder_image.png".equals(model.getValueAt(row, 7).toString())) {
                deleteImage(model.getValueAt(row, 7).toString());
            }

            this.view.SupperLoadingData();
        }

        if (src.equals("Update")) {
            // Nút add bị khóa thì cho update
            if (!this.view.btnInventoryAdd.isEnabled()) {
                // Gán giá trị cho đối tượng
                inventory.setInventoryID(Integer.parseInt(this.view.inventoryID.getText()));
                inventory.setName(this.view.inventoryName.getText());
                inventory.setType(this.view.inventoryComboBoxType.getSelectedItem().toString());
                inventory.setQuantity(Integer.parseInt(this.view.inventoryQuantity.getText()));
                inventory.setPurchasingPrice(Double.parseDouble(this.view.inventoryPurchasingPrice.getText()));
                inventory.setSellingPrice(Double.parseDouble(this.view.inventorySellingPrice.getText()));
                inventory.setDescription(this.view.inventoryDescription.getText());
                inventory.setBarcode(Integer.valueOf(this.view.inventoryBarcode.getText()));
                inventory.setStatus(this.view.inventoryComboBoxStatus.getSelectedItem().toString());

                if (rootImagePath != null && !"".equals(rootImagePath)) {
                    if (this.view.inventoryImageName.getText().toString().equals("place_holder_image.png")) {
                        String fileName = moveImage(rootImagePath);
                        inventory.setImage(fileName);
                    } else {
                        deleteImage(this.view.inventoryImageName.getText());
                        String fileName = moveImage(rootImagePath);
                        inventory.setImage(fileName);
                    }
                } else {
                    inventory.setImage(this.view.inventoryImageName.getText());
                }

                InventoryDAO.getInstance().update(inventory); // Update thông tin
                System.out.println(inventory.toString());

                this.view.SupperLoadingData();

            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Please choose one row in table!");
            }
        }

    }

    // Xử lí click chuột
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (e.getSource() == this.view.inventoryTable) {
            this.view.btnInventoryUpdate.setEnabled(true);
            int row = this.view.inventoryTable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) this.view.inventoryTable.getModel();

            this.view.inventoryID.setText(model.getValueAt(row, 0).toString());
            this.view.inventoryName.setText(model.getValueAt(row, 1).toString());
            this.view.inventoryComboBoxType.setSelectedItem(model.getValueAt(row, 2));
            this.view.inventoryQuantity.setText(model.getValueAt(row, 3).toString());
            this.view.inventoryPurchasingPrice.setText(model.getValueAt(row, 4).toString());
            this.view.inventorySellingPrice.setText(model.getValueAt(row, 5).toString());

            if (model.getValueAt(row, 6) != null) {
                this.view.inventoryDescription.setText(model.getValueAt(row, 6).toString());
            } else {
                this.view.inventoryDescription.setText("");
            }

            if (model.getValueAt(row, 7) != null && model.getValueAt(row, 7) != "") {
                this.view.inventoryImageName.setText(model.getValueAt(row, 7).toString());
                this.view.inventoryImage.setIcon(getImage(model.getValueAt(row, 7).toString()));
            } else {
                this.view.inventoryImageName.setText("place_holder_image.png");
                this.view.inventoryImage.setIcon(getImage(this.view.inventoryImageName.getText()));
            }

            if (model.getValueAt(row, 8) != null) {
                this.view.inventoryBarcode.setText(model.getValueAt(row, 8).toString());
            } else {
                this.view.inventoryBarcode.setText("");
            }

            this.view.inventoryComboBoxStatus.setSelectedItem(model.getValueAt(row, 9));

            this.view.btnInventoryAdd.setEnabled(false);
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
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
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
