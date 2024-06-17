/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;


public class Inventory {
    private int inventoryID;
    private String type;
    private String name;
    private int quantity;
    private String image;
    private String description;
    private double purchasingPrice;
    private double sellingPrice;
    private Integer barcode;
    private String status;

    public Inventory() {}

    public Inventory(int inventoryID, String type, String name, int quantity, String image, String description, double purchasingPrice, double sellingPrice, Integer barcode, String status) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
        this.purchasingPrice = purchasingPrice;
        this.sellingPrice = sellingPrice;
        this.barcode = barcode;
        this.status = status;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public double getPurchasingPrice() {
        return purchasingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public String getStatus() {
        return status;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPurchasingPrice(double purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Inventory{" + "inventoryID=" + inventoryID + ", type=" + type + ", name=" + name + ", quantity=" + quantity + ", image=" + image + ", description=" + description + ", purchasingPrice=" + purchasingPrice + ", sellingPrice=" + sellingPrice + ", barcode=" + barcode + ", status=" + status + '}';
    }

    
}

