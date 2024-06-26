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
        // Hóa đơn tự sinh từ trigger của Database
    }

    @Override
    public void update(Transaction t) {
        // Hóa đơn không sửa đổi được
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Transactions WHERE TransactionID=?";
        
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
        String sql = "SELECT * FROM Transactions WHERE TransactionID=?";
        
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
                transaction.setTransactionDate(rs.getTimestamp("TransactionDate").toLocalDateTime());
                transaction.setTotalAmount(rs.getDouble("TotalAmount"));
            }
            
            return transaction;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Transaction> getAll() {
        String sql = "SELECT * FROM Transactions";
        
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            
            // Xử lý kết quả và lưu vào danh sách
            ArrayList<Transaction> list = new ArrayList<>();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionID(rs.getInt("TransactionID"));
                transaction.setUserID(rs.getInt("UserID"));
                transaction.setTransactionDate(rs.getTimestamp("TransactionDate").toLocalDateTime());
                transaction.setTotalAmount(rs.getDouble("TotalAmount"));
                list.add(transaction);
            }
            
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Double getTotalAmount(){
        Double totalAmount = 0.0;
        try {
            // Bước 1: Tạo kết nối
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Thực thi câu lệnh SQL
            String sql = "SELECT Sum(TotalAmount) as TotalAmount From Transactions";
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 3: Thực thi câu lệnh SQL và lấy kết quả
            ResultSet rs = pst.executeQuery();

            // Bước 4: Xử lý kết quả
            if (rs.next()) {
                totalAmount = rs.getDouble("TotalAmount");
            }

            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return totalAmount;
    }
    
    
    // Lấy tổng doanh thu theo tháng
    public Double getTotalAmountByMount(int month, int year) {
    Double totalAmount = 0.0;
    try {
        // Bước 1: Tạo kết nối
        Connection con = JDBCUtil.getConnection();

        // Bước 2: Thực thi câu lệnh SQL
        String sql = "SELECT GetTotalAmountForMonthYear(?, ?) AS Profit";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, month);
        pst.setInt(2, year);

        // Bước 3: Thực thi câu lệnh SQL và lấy kết quả
        ResultSet rs = pst.executeQuery();

        // Bước 4: Xử lý kết quả
        if (rs.next()) {
            totalAmount = rs.getDouble("Profit");
        }

        // Bước 5: Ngắt kết nối
        JDBCUtil.closeConnection(con);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return totalAmount;
}
    
    // Lấy lợi nhuận theo tháng
    public Double getProfitByMonth(int month, int year) {
        Double profit = 0.0;
        try {
            // Bước 1: Tạo kết nối
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Thực thi câu lệnh SQL
            String sql = "SELECT GetProfitByMonth(?, ?) AS Profit";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, month);
            pst.setInt(2, year);

            // Bước 3: Thực thi câu lệnh SQL và lấy kết quả
            ResultSet rs = pst.executeQuery();

            // Bước 4: Xử lý kết quả
            if (rs.next()) {
                profit = rs.getDouble("Profit");
            }

            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return profit;
    }
    


    @Override
    public ArrayList<Transaction> selectByCondition(String condition) {
        return null;
    }
}


