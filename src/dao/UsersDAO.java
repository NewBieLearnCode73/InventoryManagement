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
import model.Users;


public class UsersDAO implements DAOInterface<Users>{
	
	public static UsersDAO getInstance() {
		return new UsersDAO();
	}
	
	@Override
	public void insert(Users t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Users t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Users getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Users> getAll() {
		// TODO Auto-generated method stub
		return null;
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
	            if (password.equals(dbPassword)) {
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

	
}
