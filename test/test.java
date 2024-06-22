
import dao.InventoryDAO;
import dao.TransactionDAO;
import java.util.ArrayList;
import model.Inventory;
import model.Transaction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class test {
    public static void main(String[] args) {
//        Transaction list = TransactionDAO.getInstance().getById(1);
//        System.out.println(list.toString());
        System.out.println(TransactionDAO.getInstance().getProfitByMonth(3, 2024));
    }
}