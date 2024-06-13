/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;


    public class GoodReceiptModel {
    private String name;
    private String type;
    private int quantity;
    private double purchasingPrice;
    private double sellingPrice;
    private String description;
    private String image;

    public GoodReceiptModel() {
    }

    public GoodReceiptModel(String name, String type, int quantity, double purchasingPrice, double sellingPrice, String description, String image) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.purchasingPrice = purchasingPrice;
        this.sellingPrice = sellingPrice;
        this.description = description;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPurchasingPrice(double purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPurchasingPrice() {
        return purchasingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "GoodReceiptModel{" + "name=" + name + ", type=" + type + ", quantity=" + quantity + ", purchasingPrice=" + purchasingPrice + ", sellingPrice=" + sellingPrice + ", description=" + description + ", image=" + image + '}';
    }
    
    
}

