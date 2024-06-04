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
import model.Inventory;


public class InventoryDAO implements DAOInterface<Inventory>{
	
	public static InventoryDAO getInstance() {
		return new InventoryDAO();
	}

	@Override
	public void insert(Inventory t) {
		  int check = 0;
	        try {
	            // Bước 1: Tạo kết nối
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Thực thi câu lệnh SQL
	            String sql = "INSERT INTO Inventory (Type, Name, Quantity, Image, Description, PurchasingPrice, SellingPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";

	            // Bước 3: Tạo ra đối tượng PreparedStatement và truyền câu lệnh SQL
	            PreparedStatement pst = con.prepareStatement(sql);

	            // Truyền dữ liệu (set[Kiểu dữ liệu] sao cho phù hợp)
	            pst.setString(1, t.getType());
	            pst.setString(2, t.getName());
	            pst.setInt(3, t.getQuantity());
	            pst.setString(4, t.getImage());
	            pst.setString(5, t.getDescription());
	            pst.setDouble(6, t.getPurchasingPrice());
	            pst.setDouble(7, t.getSellingPrice());

	            // Bước 4: Thực thi câu lệnh SQL
	            check = pst.executeUpdate(); // Trả về số lượng dòng bị thay đổi

	            // Bước 5: Xử lý kết quả
	            System.out.println("Bạn đã thực thi: " + sql);
	            System.out.println("Có " + check + " dòng bị thay đổi!");

	            // Bước 6: Ngắt kết nối
	            JDBCUtil.closeConnection(con);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}

	@Override
	public void update(Inventory t) {
	    try {
	        // Bước 1: Tạo kết nối
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: Thực thi câu lệnh SQL
	        String sql = "UPDATE Inventory SET Type=?, Name=?, Quantity=?, Image=?, Description=?, PurchasingPrice=?, SellingPrice=? WHERE InventoryID=?";
	        PreparedStatement pst = con.prepareStatement(sql);

	        // Truyền dữ liệu
	        pst.setString(1, t.getType());
	        pst.setString(2, t.getName());
	        pst.setInt(3, t.getQuantity());
	        pst.setString(4, t.getImage());
	        pst.setString(5, t.getDescription());
	        pst.setDouble(6, t.getPurchasingPrice());
	        pst.setDouble(7, t.getSellingPrice());
	        pst.setInt(8, t.getInventoryID()); // Giả sử có trường id trong Inventory để xác định bản ghi cần cập nhật

	        // Bước 3: Thực thi câu lệnh SQL
	        pst.executeUpdate();

	        // Bước 4: Xử lý kết quả
	        System.out.println("Bạn đã thực thi: " + sql);
	        System.out.println("Dữ liệu được cập nhật thành công!");

	        // Bước 5: Ngắt kết nối
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public void updateQuantity(int quantity, int inventoryID) {
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "UPDATE Inventory SET Quantity=? WHERE InventoryID=?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setInt(1, quantity);
	        pst.setInt(2, inventoryID);
	        pst.executeUpdate();

	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	@Override
	public void delete(int id) {
	    try {
	        // Bước 1: Tạo kết nối
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: Thực thi câu lệnh SQL
	        String sql = "DELETE FROM Inventory WHERE InventoryID=?";
	        PreparedStatement pst = con.prepareStatement(sql);

	        // Truyền dữ liệu
	        pst.setInt(1, id);

	        // Bước 3: Thực thi câu lệnh SQL
	        pst.executeUpdate();

	        // Bước 4: Xử lý kết quả
	        System.out.println("Bạn đã thực thi: " + sql);
	        System.out.println("Dữ liệu được xóa thành công!");

	        // Bước 5: Ngắt kết nối
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	@Override
	public Inventory getById(int id) {
	    try {
	        // Bước 1: Tạo kết nối
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: Thực thi câu lệnh SQL
	        String sql = "SELECT * FROM Inventory WHERE InventoryID=?";
	        PreparedStatement pst = con.prepareStatement(sql);

	        // Truyền dữ liệu
	        pst.setInt(1, id);

	        // Bước 3: Thực thi câu lệnh SQL và lấy kết quả
	        ResultSet rs = pst.executeQuery();

	        // Bước 4: Xử lý kết quả
	        Inventory inventory = null;
	        if (rs.next()) {
	            inventory = new Inventory();
	            inventory.setInventoryID((rs.getInt("InventoryID")));
	            inventory.setType(rs.getString("Type"));
	            inventory.setName(rs.getString("Name"));
	            inventory.setQuantity(rs.getInt("Quantity"));
	            inventory.setImage(rs.getString("Image"));
	            inventory.setDescription(rs.getString("Description"));
	            inventory.setPurchasingPrice(rs.getDouble("PurchasingPrice"));
	            inventory.setSellingPrice(rs.getDouble("SellingPrice"));
	        }

	        // Bước 5: Ngắt kết nối và trả về kết quả
	        JDBCUtil.closeConnection(con);
	        return inventory;
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	@Override
	public ArrayList<Inventory> getAll() {
	    try {
	        // Bước 1: Tạo kết nối
	        Connection con = JDBCUtil.getConnection();

	        // Bước 2: Thực thi câu lệnh SQL
	        String sql = "SELECT * FROM Inventory";
	        PreparedStatement pst = con.prepareStatement(sql);

	        // Bước 3: Thực thi câu lệnh SQL và lấy kết quả
	        ResultSet rs = pst.executeQuery();

	        // Bước 4: Xử lý kết quả và lưu vào danh sách
	        ArrayList<Inventory> list = new ArrayList<>();
	        while (rs.next()) {
	            Inventory inventory = new Inventory();
	            inventory.setInventoryID(rs.getInt("InventoryID"));
	            inventory.setType(rs.getString("Type"));
	            inventory.setName(rs.getString("Name"));
	            inventory.setQuantity(rs.getInt("Quantity"));
	            inventory.setImage(rs.getString("Image"));
	            inventory.setDescription(rs.getString("Description"));
	            inventory.setPurchasingPrice(rs.getDouble("PurchasingPrice"));
	            inventory.setSellingPrice(rs.getDouble("SellingPrice"));
	            list.add(inventory);
	        }

	        // Bước 5: Ngắt kết nối và trả về danh sách
	        JDBCUtil.closeConnection(con);
	        return list;
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	@Override
	public ArrayList<Inventory> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
}

