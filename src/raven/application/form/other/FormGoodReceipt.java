package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import controller.GoodReciptController;
import dao.InventoryDAO;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.Inventory;
import model.InventoryType;
import raven.toast.Notifications;
import model.GoodReceiptModel;

/**
 *
 * @author Raven
 */
public class FormGoodReceipt extends javax.swing.JPanel {

    public FormGoodReceipt() {
        initComponents();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");

        inventoryImage.setBorder(BorderFactory.createLineBorder(Color.lightGray, 2));

        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) inventoryTable.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // ẩn ô ID
        this.inventoryID.setVisible(true);

        // ẩn ô tên ảnh
        this.inventoryImageName.setVisible(true);

        String[] listType = InventoryType.getAllType();
        for (String string : listType) {
            inventoryComboBoxType.addItem(string);
        }

        inventoryComboBoxType.setSelectedIndex(-1);

        // Gắn sự kiện
        Action action = new GoodReciptController(this);
        btnImageBrowse.addActionListener(action);
        btnInventoryAdd.addActionListener(action);
        btnInventoryUpdate.addActionListener(action);
        btnInventoryDelete.addActionListener(action);
        btnInventoryLoad.addActionListener(action);
        btnFormReset.addActionListener(action);
        btnFind.addActionListener(action);

        // Xử lí click vào table
        MouseListener mouseAction = new GoodReciptController(this);
        inventoryTable.addMouseListener(mouseAction);
        
        // Xử lí nhập 
        KeyListener keyAction;
        keyAction = new GoodReciptController(this);
        jTextFieldFind.addKeyListener(keyAction);
        

        btnInventoryUpdate.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inventoryName = new javax.swing.JTextField();
        inventoryQuantity = new javax.swing.JTextField();
        inventoryPurchasingPrice = new javax.swing.JTextField();
        inventorySellingPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryDescription = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        btnImageBrowse = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnInventoryAdd = new javax.swing.JButton();
        btnInventoryUpdate = new javax.swing.JButton();
        btnInventoryDelete = new javax.swing.JButton();
        btnInventoryLoad = new javax.swing.JButton();
        btnFormReset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        inventoryComboBoxType = new javax.swing.JComboBox<>();
        inventoryImage = new javax.swing.JLabel();
        inventoryID = new javax.swing.JLabel();
        inventoryImageName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        inventoryBarcode = new javax.swing.JTextField();
        inventoryComboBoxStatus = new javax.swing.JComboBox<>();
        jTextFieldFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();

        lb.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Nhập kho");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Quantity");
        jLabel2.setPreferredSize(new java.awt.Dimension(32, 16));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Selling Price");
        jLabel3.setPreferredSize(new java.awt.Dimension(32, 16));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Purchasing Price");
        jLabel4.setPreferredSize(new java.awt.Dimension(32, 16));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Description");
        jLabel5.setPreferredSize(new java.awt.Dimension(32, 16));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Image");

        inventoryName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        inventoryQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inventoryQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inventoryQuantityKeyTyped(evt);
            }
        });

        inventoryPurchasingPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inventoryPurchasingPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inventoryPurchasingPriceKeyTyped(evt);
            }
        });

        inventorySellingPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inventorySellingPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inventorySellingPriceKeyTyped(evt);
            }
        });

        inventoryDescription.setColumns(20);
        inventoryDescription.setRows(5);
        jScrollPane1.setViewportView(inventoryDescription);

        inventoryTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID" ,"Name", "Type" ,"Quantity", "Purchasing Price", "Selling Price", "Description", "Image", "Barcode", "Status"
            }
        ));
        inventoryTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(inventoryTable);

        btnImageBrowse.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnImageBrowse.setText("Browse");

        btnInventoryAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInventoryAdd.setText("Add");

        btnInventoryUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInventoryUpdate.setText("Update");

        btnInventoryDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInventoryDelete.setText("Delete");

        btnInventoryLoad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInventoryLoad.setText("Load");

        btnFormReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFormReset.setText("Reset Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnInventoryAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(72, 72, 72)
                .addComponent(btnInventoryUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76)
                .addComponent(btnInventoryDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(72, 72, 72)
                .addComponent(btnInventoryLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(65, 65, 65)
                .addComponent(btnFormReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInventoryAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventoryLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFormReset, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Type");
        jLabel7.setPreferredSize(new java.awt.Dimension(32, 16));

        inventoryComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        inventoryImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventoryImage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        inventoryID.setText("InventoryID");

        inventoryImageName.setText("InventoryImageName");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Barcode");
        jLabel8.setPreferredSize(new java.awt.Dimension(32, 16));

        inventoryBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inventoryBarcodeKeyTyped(evt);
            }
        });

        inventoryComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive"}));

        btnFind.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFind.setText("Find");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldFind, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnFind)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(inventoryImageName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(inventoryID, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(93, 335, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(inventoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(inventoryQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(inventoryComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(inventoryBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(105, 105, 105)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inventorySellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inventoryPurchasingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(115, 115, 115)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnImageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inventoryImage, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(inventoryComboBoxStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventoryPurchasingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inventoryComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inventoryQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inventoryBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inventoryImageName)
                            .addComponent(inventoryID)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(inventoryImage, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnImageBrowse)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inventoryComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(inventorySellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFind, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inventoryQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inventoryQuantityKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_inventoryQuantityKeyTyped

    private void inventoryBarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inventoryBarcodeKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_inventoryBarcodeKeyTyped

    private void inventoryPurchasingPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inventoryPurchasingPriceKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_inventoryPurchasingPriceKeyTyped

    private void inventorySellingPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inventorySellingPriceKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_inventorySellingPriceKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnFind;
    public javax.swing.JButton btnFormReset;
    public javax.swing.JButton btnImageBrowse;
    public javax.swing.JButton btnInventoryAdd;
    public javax.swing.JButton btnInventoryDelete;
    public javax.swing.JButton btnInventoryLoad;
    public javax.swing.JButton btnInventoryUpdate;
    public javax.swing.JTextField inventoryBarcode;
    public javax.swing.JComboBox<String> inventoryComboBoxStatus;
    public javax.swing.JComboBox<String> inventoryComboBoxType;
    public javax.swing.JTextArea inventoryDescription;
    public javax.swing.JLabel inventoryID;
    public javax.swing.JLabel inventoryImage;
    public javax.swing.JLabel inventoryImageName;
    public javax.swing.JTextField inventoryName;
    public javax.swing.JTextField inventoryPurchasingPrice;
    public javax.swing.JTextField inventoryQuantity;
    public javax.swing.JTextField inventorySellingPrice;
    public javax.swing.JTable inventoryTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextField jTextFieldFind;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables

    public void DeleteAllForm() {
        inventoryID.setText("");
        inventoryName.setText("");
        inventoryComboBoxType.setSelectedIndex(-1);
        inventoryQuantity.setText("");
        inventoryPurchasingPrice.setText("");
        inventorySellingPrice.setText("");
        inventoryDescription.setText("");
        inventoryImage.setIcon(null);
        inventoryImage.setText("");
        inventoryImageName.setText("");
        inventoryBarcode.setText("");
        inventoryComboBoxStatus.setSelectedIndex(-1);
    }

    public void Load() {
        try {
            ArrayList<Inventory> listInventorys = InventoryDAO.getInstance().getAll();
            DefaultTableModel tableModel = (DefaultTableModel) this.inventoryTable.getModel();

            tableModel.setRowCount(0);

            for (Inventory inventory : listInventorys) {
                Object[] row = new Object[]{
                    inventory.getInventoryID(),
                    inventory.getName(),
                    inventory.getType(),
                    inventory.getQuantity(),
                    inventory.getPurchasingPrice(),
                    inventory.getSellingPrice(),
                    inventory.getDescription(),
                    inventory.getImage(),
                    inventory.getBarcode(),
                    inventory.getStatus()
                };
                tableModel.addRow(row);
            }

            this.inventoryTable.setModel(tableModel);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Loading Success From Database");
        } catch (Exception ex) {

            // Thả lỗi ra ngoài
            System.out.println(ex.toString());
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error Load From Database");
        }
    }

    public void SupperLoadingData() {
        this.Load();
        this.DeleteAllForm();
        this.btnInventoryAdd.setEnabled(true);
        this.btnInventoryUpdate.setEnabled(false);
    }

}
