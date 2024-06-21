/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.InvoiceDetail;
import model.TransactionDetails;

public class TransactionDetailsDAO implements DAOInterface<TransactionDetails> {

    public static TransactionDetailsDAO getInstance() {
        return new TransactionDetailsDAO();
    }

    @Override
    public void insert(TransactionDetails t) {
        try {
            // Bước 1: Tạo kết nối
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Thực thi câu lệnh
            String sql = "INSERT INTO TransactionDetails (InventoryID, Quantity) VALUES (?, ?)";

            // Bước 3:  Tạo ra đối tượng PreparedStatement và truyền câu lệnh SQL
            PreparedStatement pst = con.prepareStatement(sql);

            // Truyền dữ liệu
            pst.setInt(1, t.getInventoryID());
            pst.setInt(2, t.getQuantity());

            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(TransactionDetails t) {

    }

    @Override
    public void delete(int id) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM TransactionDetails WHERE TransactionID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TransactionDetails getById(int id) {
        TransactionDetails result = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM TransactionDetails WHERE TransactionID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = new TransactionDetails();
                result.setTransactionID(rs.getInt("TransactionID"));
                result.setInventoryID(rs.getInt("InventoryID"));
                result.setQuantity(rs.getInt("Quantity"));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public ArrayList<TransactionDetails> getAll() {
        ArrayList<TransactionDetails> results = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM TransactionDetails";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                TransactionDetails t = new TransactionDetails();
                t.setTransactionDetailID(rs.getInt("TransactionDetailID"));
                t.setTransactionID(rs.getInt("TransactionID"));
                t.setInventoryID(rs.getInt("InventoryID"));
                t.setQuantity(rs.getInt("Quantity"));
                results.add(t);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    @Override
    public ArrayList<TransactionDetails> selectByCondition(String condition) {
        return null;
    }

    public ArrayList<InvoiceDetail> getListTransactionDetail(Integer transactionID) {
        ArrayList<InvoiceDetail> list = new ArrayList();
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "{call GetTransactionDetails(?)}"; // Call the stored procedure
            CallableStatement cst = con.prepareCall(sql);
            cst.setInt(1, transactionID);

            ResultSet rs = cst.executeQuery();

            while (rs.next()) {
                InvoiceDetail invoiceDetail = new InvoiceDetail();
                invoiceDetail.setDate(rs.getString("TransactionDate"));
                invoiceDetail.setQuantityl(rs.getInt("Quantity"));
                invoiceDetail.setPrice(rs.getInt("PriceAtTransaction"));
                invoiceDetail.setTotalPrice(rs.getInt("TotalPrice"));
                invoiceDetail.setProductDesciption(rs.getString("ProductDescription"));
                invoiceDetail.setProducName(rs.getString("ProductName"));
                
                list.add(invoiceDetail);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
