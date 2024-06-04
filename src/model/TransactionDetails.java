/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;


public class TransactionDetails {
    private int transactionDetailID;
    private int transactionID;
    private int inventoryID;
    private int quantity;

    public TransactionDetails() {}

    public TransactionDetails(int transactionDetailID, int transactionID, int inventoryID, int quantity) {
        this.transactionDetailID = transactionDetailID;
        this.transactionID = transactionID;
        this.inventoryID = inventoryID;
        this.quantity = quantity;
    }

    public int getTransactionDetailID() {
        return transactionDetailID;
    }

    public void setTransactionDetailID(int transactionDetailID) {
        this.transactionDetailID = transactionDetailID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "TransactionDetails{" +
                "transactionDetailID=" + transactionDetailID +
                ", transactionID=" + transactionID +
                ", inventoryID=" + inventoryID +
                ", quantity=" + quantity +
                '}';
    }
}

