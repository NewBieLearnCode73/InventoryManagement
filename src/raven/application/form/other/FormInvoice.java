package raven.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import controller.InvoiceController;
import dao.TransactionDAO;
import dao.TransactionDetailsDAO;
import dao.UsersDAO;
import database.SessionRole;
import helper.print.InvoicePayment;
import helper.print.InvoiceReportField;
import helper.print.PaymentManager;
import helper.util.Constant;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.InvoiceDetail;
import model.Transaction;
import model.Users;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import raven.table.CustomTableCellRenderer;
import raven.table.TableRenderer;
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
        
        
        // 
        CustomTableCellRenderer renderer = new CustomTableCellRenderer("#3a4045", "#53575b");
        this.transactionTable.setDefaultRenderer(Object.class, renderer);
        this.invoiceDetailsTable.setDefaultRenderer(Object.class, renderer);
        
        TableRenderer transactionTableRenderer = new TableRenderer(transactionTable);        
        TableRenderer invoiceDetailsTableRenderer = new TableRenderer(invoiceDetailsTable);
        transactionTableRenderer.setAll();
        invoiceDetailsTableRenderer.setAll();
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
        invoiceJPanel = new javax.swing.JPanel();
        btnExportInvoice = new javax.swing.JButton();

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Invoice");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Invoice Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        invoiceDetailsTable.setModel(new raven.table.NonEditableTableModel(
            new Object [][] {
            },
            new String [] {
                "Barcode", "Quantity", "PriceAtTransaction", "TotalPrice", "ProductName", "ProductDescription"
            }
        ));
        invoiceDetailsTable.setRowHeight(40);
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transactions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        transactionTable.setModel(new raven.table.NonEditableTableModel(
            new Object [][] {
            },
            new String [] {
                "TransactionID", "UserID", "TransactionDate", "TotalAmount"
            }
        ));
        transactionTable.setRowHeight(40);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        invoiceJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Invoice", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        javax.swing.GroupLayout invoiceJPanelLayout = new javax.swing.GroupLayout(invoiceJPanel);
        invoiceJPanel.setLayout(invoiceJPanelLayout);
        invoiceJPanelLayout.setHorizontalGroup(
            invoiceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        invoiceJPanelLayout.setVerticalGroup(
            invoiceJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(invoiceJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(invoiceJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExportInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportInvoiceActionPerformed
        try {
            InvoicePayment dataPrint = getInvoice();

            PaymentManager.getInstance().printInvoicePayment(dataPrint);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, Constant.CHOOSE_SPECIFIC_INVOICE, "Error", JOptionPane.ERROR_MESSAGE);
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
                    t.getUserID(),
                    t.getTransactionDate(),
                    t.getTotalAmount()
                };

                transactionTableModel.addRow(row);
            }
            this.transactionTable.setModel(transactionTableModel);

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, Constant.LOAD_DATABSE_SUCCESS);
        } catch (Exception e) {
            System.out.println(e.toString());
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, Constant.LOAD_DATABASE_ERROR);
        }
    }

    public void showInvoicePayment() {
        try {
            InvoicePayment data = getInvoice();
            JasperPrint jasperPrint = PaymentManager.getInstance().showInvoicePayment(data);

            if (jasperPrint != null) {
                JRViewer jRViewer = new JRViewer(jasperPrint);

                // Lấy kích thước của JasperPrint
                int reportWidth = jasperPrint.getPageWidth();
                int reportHeight = jasperPrint.getPageHeight();

                // Thiết lập kích thước cho JRViewer
                jRViewer.setPreferredSize(new Dimension(reportWidth, reportHeight));
                jRViewer.setMinimumSize(new Dimension(reportWidth, reportHeight));
                jRViewer.setMaximumSize(new Dimension(reportWidth, reportHeight));

                // Kiểm tra xem invoiceJPanel có null không
                if (this.invoiceJPanel != null) {
                    this.invoiceJPanel.setLayout(new BorderLayout());

                    // Xóa tất cả các thành phần hiện có trong invoiceJPanel
                    this.invoiceJPanel.removeAll();

                    // Cập nhật kích thước cho invoiceJPanel dựa trên kích thước của JasperPrint
                    this.invoiceJPanel.setPreferredSize(new Dimension(reportWidth, reportHeight));
                    this.invoiceJPanel.setMinimumSize(new Dimension(reportWidth, reportHeight));
                    this.invoiceJPanel.setMaximumSize(new Dimension(reportWidth, reportHeight));

                    // Thêm JRViewer vào invoiceJPanel
                    this.invoiceJPanel.add(jRViewer, BorderLayout.CENTER);

                    // Cập nhật lại kích thước và hiển thị cho invoiceJPanel
                    this.invoiceJPanel.revalidate();
                    this.invoiceJPanel.repaint();
                } else {
                    System.err.println("invoiceJPanel is null!");
                }
            } else {
                System.err.println("jasperPrint is null!");
            }
        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private InvoicePayment getInvoice() {
        DefaultTableModel transactionTable = (DefaultTableModel) this.transactionTable.getModel();

        int row = this.transactionTable.getSelectedRow();
        Integer transactionID = (Integer) transactionTable.getValueAt(row, 0);
        Integer userID = (Integer) transactionTable.getValueAt(row, 1);
        LocalDateTime date = (LocalDateTime) transactionTable.getValueAt(row, 2);
        Double totalPrice = (Double) transactionTable.getValueAt(row, 3);

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
        
        //Get username
        Users user = UsersDAO.getInstance().getById(userID);

        InvoicePayment dataPrint = new InvoicePayment(user.getUsername(), date.toString(), fields, totalPrice.intValue());

        return dataPrint;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExportInvoice;
    public javax.swing.JTable invoiceDetailsTable;
    private javax.swing.JPanel invoiceJPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb;
    public javax.swing.JTable transactionTable;
    // End of variables declaration//GEN-END:variables
}
