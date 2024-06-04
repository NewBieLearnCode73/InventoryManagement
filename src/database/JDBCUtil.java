/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtil {
public static Connection getConnection() {
        Connection c = null;

        // Dùng để đăng ký cơ sở dữ liệu
        try {
            // Đăng ký MySQL Driver với DriverManager
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3308/inventory_management";
            String username = "root";
            String password = "root";

            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null && !c.isClosed()) {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println("Database Product Name: " + mtdt.getDatabaseProductName());
                System.out.println("Database Product Version: " + mtdt.getDatabaseProductVersion());
                System.out.println("Driver Name: " + mtdt.getDriverName());
                System.out.println("Driver Version: " + mtdt.getDriverVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

