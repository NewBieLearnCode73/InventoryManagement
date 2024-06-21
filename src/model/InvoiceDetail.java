/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class InvoiceDetail {

    private String date;
    private Integer quantityl;
    private Integer price;
    private Integer totalPrice;
    private String producName;
    private String productDesciption;

    public InvoiceDetail(String date, Integer quantityl, Integer price, Integer totalPrice, String producName, String productDesciption) {
        this.date = date;
        this.quantityl = quantityl;
        this.price = price;
        this.totalPrice = totalPrice;
        this.producName = producName;
        this.productDesciption = productDesciption;
    }

    public InvoiceDetail() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProducName() {
        return producName;
    }

    public void setProducName(String producName) {
        this.producName = producName;
    }

    public Integer getQuantityl() {
        return quantityl;
    }

    public void setQuantityl(Integer quantityl) {
        this.quantityl = quantityl;
    }

    public String getProductDesciption() {
        return productDesciption;
    }

    public void setProductDesciption(String productDesciption) {
        this.productDesciption = productDesciption;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
