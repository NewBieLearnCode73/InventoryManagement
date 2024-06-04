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

    public Inventory() {}

    public Inventory(int inventoryID, String type, String name, int quantity, String image, String description, double purchasingPrice, double sellingPrice) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
        this.purchasingPrice = purchasingPrice;
        this.sellingPrice = sellingPrice;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(double purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID=" + inventoryID +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", purchasingPrice=" + purchasingPrice +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}

