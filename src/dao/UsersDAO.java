/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import helper.BCrypt.BcryptHash;
import static helper.BCrypt.BcryptHash.checkPassword;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Inventory;
import model.Users;

public class UsersDAO implements DAOInterface<Users> {

    public static UsersDAO getInstance() {
        return new UsersDAO();
    }

    @Override
    public void insert(Users t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Users user) {
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE Users SET Username = ?, Password = ?, Email = ?, Role = ?, Status = ? WHERE UserID = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getRole());
            pst.setString(5, user.getStatus());
            pst.setInt(6, user.getUserID());

            int affectedRows = pst.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("User updated successfully!");
            } else {
                System.out.println("User update failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
    }

    @Override
    public Users getById(int id) {
        try {
            // Bước 1: Tạo kết nối
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM Users WHERE UserID = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 3: Truyền dữ liệu vào câu lệnh SQL
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            // Bước 4: Xử lý kết quả và tạo đối tượng Users
            if (rs.next()) {
                Users user = new Users();
                user.setUserID(rs.getInt("UserID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                user.setRole(rs.getString("Role"));
                user.setStatus(rs.getString("Status"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu không tìm thấy người dùng
    }

    @Override
    public ArrayList<Users> getAll() {
        try {
            // Bước 1: Tạo kết nối
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM Users";
            PreparedStatement pst = con.prepareStatement(sql);

            // Bước 3: Thực thi câu lệnh SQL và lấy kết quả
            ResultSet rs = pst.executeQuery();

            // Bước 4: Xử lý kết quả và lưu vào danh sách
            ArrayList<Users> list = new ArrayList<>();
            while (rs.next()) {
                Users user = new Users();

                user.setUserID(rs.getInt("UserID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));

                user.setEmail(rs.getString("Email"));

                user.setRole(rs.getString("Role"));

                user.setStatus(rs.getString("Status"));

                list.add(user);
            }

            // Bước 5: Ngắt kết nối và trả về danh sách
            JDBCUtil.closeConnection(con);
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Users> selectByCondition(String condition) {
        // TODO Auto-generated method stub
        return null;
    }

    // Xác thực người dùng
    public boolean authenticateUser(String username, String password) {
        try {
            // Bước 1: Tạo kết nối
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Thực thi câu lệnh
            String sql = "SELECT * FROM Users WHERE Username=?";

            // Bước 3: Tạo đối tượng PreparedStatement và truyền câu lệnh SQL
            PreparedStatement pst = con.prepareStatement(sql);

            // Truyền dữ liệu
            pst.setString(1, username);

            ResultSet rs = pst.executeQuery();

            // Bước 4: Xử lý kết quả
            if (rs.next()) {
                // Lấy mật khẩu từ cơ sở dữ liệu
                String dbPassword = rs.getString("Password");

                // So sánh mật khẩu nhập vào với mật khẩu từ cơ sở dữ liệu
                if (checkPassword(password, dbPassword)) {
                    // Mật khẩu khớp, trả về true
                    return true;
                }
            }

            // Nếu không tìm thấy tài khoản hoặc mật khẩu không khớp, trả về false
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Trả về true nếu tài khoản đã tồn tại trong db
    public boolean checkAccountIsExist(String username) {
        try {
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Thực thi câu lệnh
            String sql = "SELECT * FROM Users WHERE Username=?";

            // Bước 3: Tạo đối tượng PreparedStatement và truyền câu lệnh SQL
            PreparedStatement pst = con.prepareStatement(sql);

            // Truyền dữ liệu
            pst.setString(1, username);

            ResultSet rs = pst.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void registerUser(String username, String email, String password, String role) {
        Connection conn = null;
        PreparedStatement pst = null;
        
        String status = "Active";
        
        String hashpw = BcryptHash.hashPassword(password);

        try {
            // Bước 1: Kết nối tới cơ sở dữ liệu
            conn = JDBCUtil.getConnection();

            // Bước 2: Chuẩn bị câu lệnh SQL
            String sql = "INSERT INTO Users(username, email, password, role, status) VALUES (?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);

            // Bước 3: Thiết lập các tham số
            pst.setString(1, username);
            pst.setString(2, email);
            pst.setString(3, hashpw);
            pst.setString(4, role);
            pst.setString(5, status);

            // Bước 4: Thực thi câu lệnh
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("User registration failed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean changeRole(int id, String newRole) {
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE Users SET role = ? WHERE UserID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, newRole);
            pst.setInt(2, id);

            int affectedRows = pst.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changeStatus(int id, String newStatus) {
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE Users SET Status = ? WHERE UserID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, newStatus);
            pst.setInt(2, id);

            int affectedRows = pst.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changePassword(int id, String newPassword) {
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE Users SET Password = ? WHERE UserID = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, newPassword);
            pst.setInt(2, id);

            int affectedRows = pst.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getIdByUsername(String username) {
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT UserID FROM Users WHERE Username = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("UserID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public String getStatusByUsername(String username) {
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT Status FROM Users WHERE Username = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString("Status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getRoleByUsername(String username) {
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT Role FROM Users WHERE Username = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString("Role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
