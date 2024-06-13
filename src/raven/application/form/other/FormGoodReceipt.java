package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import controller.GoodReciptController;
import dao.InventoryDAO;
import java.awt.Color;
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

        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer)
        inventoryTable.getDefaultRenderer(String.class);
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
       
        // Xử lí click vào table
        MouseListener mouseAction = new GoodReciptController(this);
        inventoryTable.addMouseListener(mouseAction);
        
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

        inventoryPurchasingPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        inventorySellingPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        inventoryDescription.setColumns(20);
        inventoryDescription.setRows(5);
        jScrollPane1.setViewportView(inventoryDescription);

        inventoryTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID" ,"Name", "Type" ,"Quantity", "Purchasing Price", "Selling Price", "Description", "Image"
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
                .addContainerGap(21, Short.MAX_VALUE)
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
        inventoryComboBoxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryComboBoxTypeActionPerformed(evt);
            }
        });

        inventoryImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventoryImage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        inventoryID.setText("InventoryID");

        inventoryImageName.setText("InventoryImageName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inventoryID, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inventoryImageName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inventoryName)
                                    .addComponent(inventoryComboBoxType, 0, 132, Short.MAX_VALUE)
                                    .addComponent(inventoryQuantity))
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inventorySellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inventoryPurchasingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnImageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inventoryImage, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inventoryID)
                            .addComponent(inventoryImageName)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inventoryImage, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnImageBrowse))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(inventorySellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
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
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inventoryComboBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryComboBoxTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inventoryComboBoxTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnFormReset;
    public javax.swing.JButton btnImageBrowse;
    public javax.swing.JButton btnInventoryAdd;
    public javax.swing.JButton btnInventoryDelete;
    public javax.swing.JButton btnInventoryLoad;
    public javax.swing.JButton btnInventoryUpdate;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
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
    }

    public void Load() {
        try{
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
                    inventory.getImage()
                };
                tableModel.addRow(row);
            }

            this.inventoryTable.setModel(tableModel);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Loading Success From Database");
        }
        catch(Exception ex){

            // Thả lỗi ra ngoài
            System.out.println(ex.toString());
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error Load From Database");
        }
    }
    
    
    public void SupperLoadingData(){
        this.Load();
        this.DeleteAllForm();
        this.btnInventoryAdd.setEnabled(true);
        this.btnInventoryUpdate.setEnabled(false);
    }
    
}
