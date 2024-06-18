/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.time.LocalDateTime;



public class Transaction {
    private int transactionID;
    private LocalDateTime transactionDate;
    private double totalAmount;

    public Transaction() {}

    public Transaction(int transactionID, LocalDateTime transactionDate, double totalAmount) {
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.totalAmount = totalAmount;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }   

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionID=" + transactionID + ", transactionDate=" + transactionDate + ", totalAmount=" + totalAmount + '}';
    }
    
}

