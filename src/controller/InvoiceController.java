/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TransactionDetailsDAO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.InvoiceDetail;
import model.TransactionDetails;
import raven.application.form.other.FormInvoice;

/**
 *
 * @author acer
 */
public class InvoiceController implements MouseListener {

    public FormInvoice view;

    public InvoiceController(FormInvoice view) {
        this.view = view;
    }

    public ArrayList<InvoiceDetail> loadTransactionDetail(Integer transactionID) {
        ArrayList<InvoiceDetail> list = new ArrayList<>();
        try {
            list = TransactionDetailsDAO.getInstance().getListTransactionDetail(transactionID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    
    public void resetTable() {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.transactionTable) {
            int row = this.view.transactionTable.getSelectedRow();
            DefaultTableModel transactionTable = (DefaultTableModel) this.view.transactionTable.getModel();
            DefaultTableModel invoiceDetailsTable = (DefaultTableModel) this.view.invoiceDetailsTable.getModel();
            
            invoiceDetailsTable.setRowCount(0);

            
            Integer transactionId = (Integer) transactionTable.getValueAt(row, 0);

            ArrayList<InvoiceDetail> list = loadTransactionDetail(transactionId);

            for (InvoiceDetail td : list) {
                Object[] rowtd = new Object[]{
                    td.getDate(),
                    td.getQuantityl(),
                    td.getPrice(),
                    td.getTotalPrice(),
                    td.getProducName(),
                    td.getProductDesciption()
                };
                
                invoiceDetailsTable.addRow(rowtd);
            }
            this.view.invoiceDetailsTable.setModel(invoiceDetailsTable);
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

}
