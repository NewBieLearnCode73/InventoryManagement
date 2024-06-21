/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper.print;

/**
 *
 * @author acer
 */
public class InvoiceReportField {
    private String name;
    private String qty;
    private String price;
    private String total;

    public InvoiceReportField() {
    }

    public InvoiceReportField(String name, String qty, String price, String total) {
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQty() {
        return qty;
    }

    public String getTotal() {
        return total;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
}
