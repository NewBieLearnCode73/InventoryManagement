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
import model.Inventory;

public class InventoryDAO implements DAOInterface<Inventory> {

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
            String sql = "INSERT INTO Inventory (Type, Name, Quantity, Image, Description, PurchasingPrice, SellingPrice, Barcode, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            pst.setInt(8, t.getBarcode());
            pst.setString(9, t.getStatus());

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
            String sql = "UPDATE Inventory SET Type=?, Name=?, Quantity=?, Image=?, Description=?, PurchasingPrice=?, SellingPrice=?, Barcode=? , Status=? WHERE InventoryID=?";
            PreparedStatement pst = con.prepareStatement(sql);

            // Truyền dữ liệu
            pst.setString(1, t.getType());
            pst.setString(2, t.getName());
            pst.setInt(3, t.getQuantity());
            pst.setString(4, t.getImage());
            pst.setString(5, t.getDescription());
            pst.setDouble(6, t.getPurchasingPrice());
            pst.setDouble(7, t.getSellingPrice());
            pst.setInt(8, t.getBarcode());
            pst.setString(9, t.getStatus());
            pst.setInt(10, t.getInventoryID()); // Giả sử có trường id trong Inventory để xác định bản ghi cần cập nhật

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
                inventory.setBarcode(rs.getInt("Barcode"));
                inventory.setStatus(rs.getString("Status"));
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
                inventory.setBarcode(rs.getInt("Barcode"));
                inventory.setStatus(rs.getString("Status"));
                list.add(inventory);
            }

            // Bước 5: Ngắt kết nối và trả về danh sách
            JDBCUtil.closeConnection(con);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean exportInvoice(ArrayList<Inventory> list) {

        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = JDBCUtil.getConnection();

            String firstSql = "SET @current_transaction_id = NULL;"; // Assuming MySQL syntax

            stmt = con.prepareStatement(firstSql);
            stmt.executeUpdate();

            String insertSql = "INSERT INTO TransactionDetails (InventoryID, Quantity) VALUES (?, ?)";
            stmt = con.prepareStatement(insertSql);

            for (Inventory inventory : list) {
                stmt.setInt(1, inventory.getInventoryID());
                stmt.setInt(2, inventory.getQuantity());
                stmt.addBatch();
            }

            stmt.executeBatch();

            JDBCUtil.closeConnection(con);

            return true;

        } catch (SQLException ex) {
            // Handle any SQL exceptions
            System.err.println("SQL Exception: " + ex.getMessage());
            ex.printStackTrace(); // Print stack trace for debugging

            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException rollbackEx) {
                System.err.println("Rollback Exception: " + rollbackEx.getMessage());
                rollbackEx.printStackTrace();
            }

            return false;

        } finally {
            JDBCUtil.closeConnection(con);
        }
    }

    // Lấy tổng số lượng sản phẩm hiện có
    public int getTotalOfInventory() {
        int totalQuantity = 0;
        try {
            // Bước 1: Tạo kết nối
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Thực thi câu lệnh SQL
            String sql = "SELECT SUM(Quantity) AS total FROM Inventory;";
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 3: Thực thi câu lệnh SQL và lấy kết quả
            ResultSet rs = pst.executeQuery();

            // Bước 4: Xử lý kết quả
            if (rs.next()) {
                totalQuantity = rs.getInt("total");
            }

            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return totalQuantity;
    }

    // Lấy lợi nhuận thu được
    public Double getProfit() {
        Double totalProfit = 0.0;
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "{CALL CalculateProfit(?)}";
            CallableStatement cst = con.prepareCall(sql);

            cst.registerOutParameter(1, java.sql.Types.DOUBLE);

            cst.execute();

            totalProfit = cst.getDouble(1);

            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return totalProfit;
    }
    
    // Tính tổng giá tiền đã mua vào các sản phẩm trong kho
    public Double getPurchasing(){
        Double totalPurchasing = 0.0;
        try {
            // Bước 1: Tạo kết nối
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Thực thi câu lệnh SQL
            String sql = "SELECT SUM(Inventory.PurchasingPrice * Inventory.Quantity) as TotalPurchasing From Inventory";
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 3: Thực thi câu lệnh SQL và lấy kết quả
            ResultSet rs = pst.executeQuery();

            // Bước 4: Xử lý kết quả
            if (rs.next()) {
                totalPurchasing = rs.getDouble("TotalPurchasing");
            }

            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return totalPurchasing;
    }

    @Override
    public ArrayList<Inventory> selectByCondition(String condition) {
        // TODO Auto-generated method stub
        return null;
    }
}
