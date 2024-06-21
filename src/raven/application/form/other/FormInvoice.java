package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import controller.InvoiceController;
import dao.TransactionDAO;
import dao.TransactionDetailsDAO;
import helper.print.InvoicePayment;
import helper.print.InvoiceReportField;
import helper.print.PaymentManager;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import model.InvoiceDetail;
import model.Transaction;
import model.TransactionDetails;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class FormInvoice extends javax.swing.JPanel {

    public FormInvoice() {
        initComponents();
        loadTransaction();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        
        MouseListener mouseListener = new InvoiceController(this);
        this.transactionTable.addMouseListener(mouseListener);
        
        try {
            PaymentManager.getInstance().compileReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoiceDetailsTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        labelInvoiceFile = new javax.swing.JLabel();
        btnExportInvoice = new javax.swing.JButton();

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Invoice");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Invoice Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        invoiceDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "TransactionDate", "Quantity", "PriceAtTransaction", "TotalPrice", "ProductName", "ProductDescription"
            }
        ));
        jScrollPane2.setViewportView(invoiceDetailsTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transactions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "TransactionID", "TransactionDate", "TotalAmount"
            }
        ));
        jScrollPane1.setViewportView(transactionTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Invoice", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        labelInvoiceFile.setText("Tạo hóa đơn trong thẻ jlabel này");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(labelInvoiceFile, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(labelInvoiceFile, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnExportInvoice.setText("Export Invoice To File");
        btnExportInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportInvoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(72, 72, 72))
            .addComponent(lb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnExportInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportInvoiceActionPerformed
        try {
            DefaultTableModel transactionTable = (DefaultTableModel) this.transactionTable.getModel();
            
            int row = this.transactionTable.getSelectedRow();
            Integer transactionID = (Integer) transactionTable.getValueAt(row, 0);
            LocalDateTime date = (LocalDateTime) transactionTable.getValueAt(row, 1);
            Double totalPrice = (Double) transactionTable.getValueAt(row, 2);
            
            ArrayList<InvoiceDetail> list = TransactionDetailsDAO.getInstance().getListTransactionDetail(transactionID);
            
           ArrayList<InvoiceReportField> fields = new ArrayList<>();
           for (InvoiceDetail i : list) {
              InvoiceReportField tmp = new InvoiceReportField();
              tmp.setName(i.getProducName());
              tmp.setPrice(i.getPrice().toString());
              tmp.setTotal(i.getTotalPrice().toString());
              tmp.setQty(i.getQuantityl().toString());
              
              fields.add(tmp);
           }
            
            InvoicePayment dataPrint = new InvoicePayment("Con cac", date.toString(), fields, totalPrice.intValue());
            
            PaymentManager.getInstance().printInvoicePayment(dataPrint);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnExportInvoiceActionPerformed

    public final void loadTransaction() {
        try {
            ArrayList<Transaction> listTransaction = TransactionDAO.getInstance().getAll();
            DefaultTableModel transactionTableModel = (DefaultTableModel) this.transactionTable.getModel();

            transactionTableModel.setRowCount(0);
            
            for (Transaction t : listTransaction) {
                Object[] row = new Object[]{
                    t.getTransactionID(),
                    t.getTransactionDate(),
                    t.getTotalAmount()
                };
                
                transactionTableModel.addRow(row);
            }
            this.transactionTable.setModel(transactionTableModel);
            
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, "Loading Success From Database");
        } catch (Exception e) {
            System.out.println(e.toString());
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, "Error Load From Database");
        }
    }
    
    public void deleteInvoiceForm() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExportInvoice;
    public javax.swing.JTable invoiceDetailsTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel labelInvoiceFile;
    private javax.swing.JLabel lb;
    public javax.swing.JTable transactionTable;
    // End of variables declaration//GEN-END:variables
}
