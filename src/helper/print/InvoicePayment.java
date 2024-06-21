/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper.print;

import java.util.List;
import model.InvoiceDetail;

/**
 *
 * @author acer
 */
public class InvoicePayment {
    private String staffName;
    private String date;
    private List<InvoiceReportField> list;
    private Integer totalPrice;

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setList(List<InvoiceReportField> list) {
        this.list = list;
    }

    public List<InvoiceReportField> getList() {
        return list;
    }

    public InvoicePayment() {
    }

    public InvoicePayment(String staffName, String date, List<InvoiceReportField> list, Integer totalPrice) {
        this.staffName = staffName;
        this.date = date;
        this.list = list;
        this.totalPrice = totalPrice;
    }
}
