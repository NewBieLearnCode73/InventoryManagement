/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper.print;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author acer
 */
public class PaymentManager {

    public static PaymentManager instance;

    private JasperReport invoiceReport;

    public static PaymentManager getInstance() {
        if (instance == null) {
            instance = new PaymentManager();
        }
        return instance;
    }

    public void compileReport() throws JRException {
        invoiceReport = JasperCompileManager.compileReport(getClass().getResourceAsStream("/helper/print/invoice.jrxml"));
    }

    //show invoice payment by JasperViewer
    public void printInvoicePayment(InvoicePayment data) throws JRException {
        JasperPrint print = showInvoicePayment(data);

        view(print);
    }

    public JasperPrint showInvoicePayment(InvoicePayment data) throws JRException {
        //Parameters
        Map para = new HashMap();
        para.put("staff", data.getStaffName());
        para.put("total", data.getTotalPrice());
        para.put("date", data.getDate());

        //Fields
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getList());

        JasperPrint print = JasperFillManager.fillReport(invoiceReport, para, dataSource);

        return print;
    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }
}
