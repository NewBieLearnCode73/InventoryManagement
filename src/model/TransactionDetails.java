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
    private double purchasingPriceAtTransaction;
    private double priceAtTransaction;

    public TransactionDetails() {}

    public TransactionDetails(int transactionDetailID, int transactionID, int inventoryID, int quantity, double purchasingPriceAtTransaction, double priceAtTransaction) {
        this.transactionDetailID = transactionDetailID;
        this.transactionID = transactionID;
        this.inventoryID = inventoryID;
        this.quantity = quantity;
        this.purchasingPriceAtTransaction = purchasingPriceAtTransaction;
        this.priceAtTransaction = priceAtTransaction;
    }

    public int getTransactionDetailID() {
        return transactionDetailID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPurchasingPriceAtTransaction() {
        return purchasingPriceAtTransaction;
    }

    public double getPriceAtTransaction() {
        return priceAtTransaction;
    }

    public void setTransactionDetailID(int transactionDetailID) {
        this.transactionDetailID = transactionDetailID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPurchasingPriceAtTransaction(double purchasingPriceAtTransaction) {
        this.purchasingPriceAtTransaction = purchasingPriceAtTransaction;
    }

    public void setPriceAtTransaction(double priceAtTransaction) {
        this.priceAtTransaction = priceAtTransaction;
    }

    @Override
    public String toString() {
        return "TransactionDetails{" + "transactionDetailID=" + transactionDetailID + ", transactionID=" + transactionID + ", inventoryID=" + inventoryID + ", quantity=" + quantity + ", purchasingPriceAtTransaction=" + purchasingPriceAtTransaction + ", priceAtTransaction=" + priceAtTransaction + '}';
    }

}

