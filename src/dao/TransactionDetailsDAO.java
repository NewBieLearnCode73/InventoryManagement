/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TransactionDetails;


public class TransactionDetailsDAO implements DAOInterface<TransactionDetails>{
	
	public static TransactionDetailsDAO getInstance() {
		return new TransactionDetailsDAO();
	}

	@Override
	public void insert(TransactionDetails t) {
		try {
			// Bước 1: Tạo kết nối
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: Thực thi câu lệnh
			String sql = "INSERT INTO TransactionDetails (TransactionID, InventoryID, Quantity) VALUES (?, ?, ?)";
			
			// Bước 3:  Tạo ra đối tượng PreparedStatement và truyền câu lệnh SQL
			PreparedStatement pst = con.prepareStatement(sql);
			
			
			// Truyền dữ liệu
			pst.setInt(1, t.getTransactionID());
			pst.setInt(2, t.getInventoryID());
			pst.setInt(3, t.getQuantity());
			
			
			pst.executeUpdate();
		}
		catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public void update(TransactionDetails t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE TransactionDetails SET InventoryID = ?, Quantity = ? WHERE TransactionID = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, t.getInventoryID());
			pst.setInt(2, t.getQuantity());
			pst.setInt(3, t.getTransactionID());
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
    public void updateInventoryID(int transactionID, int newInventoryID) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE TransactionDetails SET InventoryID = ? WHERE TransactionID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, newInventoryID);
            pst.setInt(2, transactionID);
            pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Update Quantity
    public void updateQuantity(int transactionID, int newQuantity) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE TransactionDetails SET Quantity = ? WHERE TransactionID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, newQuantity);
            pst.setInt(2, transactionID);
            pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

}

