package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import controller.GoodIssueController;
import dao.InventoryDAO;
import helper.barcodeScaner.BarcodeScannerTask;
import helper.globalVariables.CartInventory;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import model.Inventory;
import raven.table.TableRenderer;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class FormGoodIssue extends javax.swing.JPanel {

    public FormGoodIssue() {
        initComponents();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");

        this.Load();

        inventoryImage.setBorder(BorderFactory.createLineBorder(Color.lightGray, 2));

        // Ẩn
        this.inventoryImageName.setVisible(false);
        this.inventoryQuantityAvailable.setVisible(false);

        // Khóa ô
        this.inventoryId.setEnabled(false);
        this.inventoryBarcode.setEnabled(false);
        this.inventoryType.setEnabled(false);
        this.inventoryName.setEnabled(false);
        this.inventorySellingPrice.setEnabled(false);

        // Gắn sự kiện
        Action action = new GoodIssueController(this);
        this.btnAddToCart.addActionListener(action);
        this.btnBarcode.addActionListener(action);
        this.btnDeleteFromCart.addActionListener(action);
        this.btnExportInvoce.addActionListener(action);
        this.btnFind.addActionListener(action);
        this.btnResetCart.addActionListener(action);

        // Gắn sự kiện key
        KeyListener keyAcion = new GoodIssueController(this);
        this.jTextFieldFind.addKeyListener(keyAcion);

        // Xử lí click vào table inventory
        MouseListener mouseAction = new GoodIssueController(this);
        this.inventoryTable.addMouseListener(mouseAction);

        // Xử lí click vào table cart
        this.inventoryCart.addMouseListener(mouseAction);

        // Căn giữa chữ ở bản
        TableRenderer inventoryTableRenderer = new TableRenderer(inventoryTable);
        TableRenderer inventoryCartRenderer = new TableRenderer(inventoryCart);
        inventoryTableRenderer.setAll();
        inventoryCartRenderer.setAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        jTextFieldFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        btnBarcode = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inventoryCart = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inventoryId = new javax.swing.JTextField();
        inventoryBarcode = new javax.swing.JTextField();
        inventoryType = new javax.swing.JTextField();
        inventoryName = new javax.swing.JTextField();
        inventorySellingPrice = new javax.swing.JTextField();
        inventoryQuantity = new javax.swing.JSpinner();
        inventoryImage = new javax.swing.JLabel();
        btnDeleteFromCart = new javax.swing.JButton();
        btnAddToCart = new javax.swing.JButton();
        btnExportInvoce = new javax.swing.JButton();
        btnResetCart = new javax.swing.JButton();
        inventoryImageName = new javax.swing.JLabel();
        inventoryQuantityAvailable = new javax.swing.JLabel();

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Good Issue");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventory", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N

        inventoryTable.setModel(new raven.table.NonEditableTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Barcode", "Type", "Name", "Selling Price", "Quantity", "Image"
            }
        ));
        inventoryTable.setRowHeight(40);
        inventoryTable.setShowGrid(false);
        jScrollPane1.setViewportView(inventoryTable);

        jTextFieldFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFindActionPerformed(evt);
            }
        });

        btnFind.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFind.setText("Find");

        btnBarcode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBarcode.setText("Scan Barcode");
        btnBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarcodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldFind, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBarcode)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jTextFieldFind))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N

        inventoryCart.setModel(new raven.table.NonEditableTableModel(
            new Object [][] { },
            new String [] {
                "ID", "Barcode", "Type", "Name", "Selling Price", "Quantity", "Image"
            }
        ));
        inventoryCart.setRowHeight(40);
        jScrollPane2.setViewportView(inventoryCart);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventory details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 15))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Barcode");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Type");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Selling Price");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quantity");

        inventoryId.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        inventoryBarcode.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        inventoryBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryBarcodeActionPerformed(evt);
            }
        });

        inventoryType.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        inventoryName.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        inventoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryNameActionPerformed(evt);
            }
        });

        inventorySellingPrice.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        inventorySellingPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventorySellingPriceActionPerformed(evt);
            }
        });

        inventoryQuantity.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        inventoryImage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnDeleteFromCart.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDeleteFromCart.setText("Delete from cart");
        btnDeleteFromCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFromCartActionPerformed(evt);
            }
        });

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAddToCart.setText("Add to cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        btnExportInvoce.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnExportInvoce.setText("Export invoice");

        btnResetCart.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnResetCart.setText("Reset cart");
        btnResetCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetCartActionPerformed(evt);
            }
        });

        inventoryImageName.setText("InventoryImageName");

        inventoryQuantityAvailable.setText("InventoryQuantiryAvailable");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(inventoryImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddToCart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDeleteFromCart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnResetCart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(inventoryQuantityAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(inventoryId, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inventoryBarcode, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inventoryType, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inventoryName, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inventorySellingPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inventoryQuantity, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inventoryImageName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(btnExportInvoce, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventoryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventoryBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventoryType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventorySellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventoryQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(inventoryImageName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventoryQuantityAvailable)
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteFromCart, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetCart, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inventoryImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addComponent(btnExportInvoce, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
            .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 1376, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFindActionPerformed

    private void inventoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inventoryNameActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void inventoryBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryBarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inventoryBarcodeActionPerformed

    private void inventorySellingPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventorySellingPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inventorySellingPriceActionPerformed

    private void btnDeleteFromCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFromCartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteFromCartActionPerformed

    private void btnResetCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetCartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetCartActionPerformed

    private void btnBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarcodeActionPerformed
        Thread scannerThread = new Thread(new BarcodeScannerTask(this.jTextFieldFind));
        scannerThread.start();
    }//GEN-LAST:event_btnBarcodeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddToCart;
    public javax.swing.JButton btnBarcode;
    public javax.swing.JButton btnDeleteFromCart;
    public javax.swing.JButton btnExportInvoce;
    public javax.swing.JButton btnFind;
    public javax.swing.JButton btnResetCart;
    public javax.swing.JTextField inventoryBarcode;
    public javax.swing.JTable inventoryCart;
    public javax.swing.JTextField inventoryId;
    public javax.swing.JLabel inventoryImage;
    public javax.swing.JLabel inventoryImageName;
    public javax.swing.JTextField inventoryName;
    public javax.swing.JSpinner inventoryQuantity;
    public javax.swing.JLabel inventoryQuantityAvailable;
    public javax.swing.JTextField inventorySellingPrice;
    public javax.swing.JTable inventoryTable;
    public javax.swing.JTextField inventoryType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jTextFieldFind;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables

    public void Load() {
        try {
            ArrayList<Inventory> listInventorys = InventoryDAO.getInstance().getAll();
            DefaultTableModel tableModel = (DefaultTableModel) this.inventoryTable.getModel();

            tableModel.setRowCount(0);

            //"ID", "Barcode", "Type", "Name", "Price", "Quantity", "Image"
            for (Inventory inventory : listInventorys) {
                if (inventory.getStatus().equals("Active")) {
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
            }

            this.inventoryTable.setModel(tableModel);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Loading Success From Database");
            
            
            
            // load vô cái cart
          DefaultTableModel cartTableModel = (DefaultTableModel) this.inventoryCart.getModel();

            cartTableModel.setRowCount(0);

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
                cartTableModel.addRow(row);
            }

            this.inventoryCart.setModel(cartTableModel);
        } catch (Exception ex) {

            // Thả lỗi ra ngoài
            System.out.println(ex.toString());
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error Load From Database");
        }
    }

}
