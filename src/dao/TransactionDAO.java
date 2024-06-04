/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Transaction;

public class TransactionDAO implements DAOInterface<Transaction> {

    public static TransactionDAO getInstance() {
        return new TransactionDAO();
    }
    
    @Override
    public void insert(Transaction t) {
        String sql = "INSERT INTO Transaction (TransactionType, TransactionDate, UserID) VALUES (?, ?, ?)";
        
        try (Connection con = JDBCUtil.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            // Chuyển đổi từ LocalDate sang java.sql.Date
            Date sqlDate = Date.valueOf(t.getTransactionDate());
            
            // Truyền dữ liệu
            pst.setString(1, t.getTransactionType());
            pst.setDate(2, sqlDate);
            pst.setInt(3, t.getUserID());
            
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Transaction t) {
        // Hóa đơn không sửa đổi được
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Transaction WHERE TransactionID=?";
        
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            // Truyền dữ liệu
            pst.setInt(1, id);
            
            // Thực thi câu lệnh
            int result = pst.executeUpdate();
            
            if (result > 0) {
                System.out.println("Delete thành công!");
            } else {
                System.out.println("Delete thất bại!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transaction getById(int id) {
        String sql = "SELECT * FROM Transaction WHERE TransactionID=?";
        
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            // Truyền dữ liệu
            pst.setInt(1, id);
            
            // Thực thi câu lệnh SQL và lấy kết quả
            ResultSet rs = pst.executeQuery();
            
            // Xử lý kết quả
            Transaction transaction = null;
            if (rs.next()) {
                transaction = new Transaction();
                transaction.setTransactionID(rs.getInt("TransactionID"));
                transaction.setTransactionType(rs.getString("TransactionType"));
                transaction.setTransactionDate(rs.getDate("TransactionDate").toLocalDate());
                transaction.setUserID(rs.getInt("UserID"));
            }
            
            return transaction;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Transaction> getAll() {
        String sql = "SELECT * FROM Transaction";
        
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            // Xử lý kết quả và lưu vào danh sách
            ArrayList<Transaction> list = new ArrayList<>();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionID(rs.getInt("TransactionID"));
                transaction.setTransactionType(rs.getString("TransactionType"));
                transaction.setTransactionDate(rs.getDate("TransactionDate").toLocalDate());
                transaction.setUserID(rs.getInt("UserID"));
                list.add(transaction);
            }
            
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Transaction> selectByCondition(String condition) {
        return null;
    }
}


