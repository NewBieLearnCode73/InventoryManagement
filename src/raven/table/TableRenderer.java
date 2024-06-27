/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.table;

import java.awt.Color;
import javax.swing.JTable;

/**
 *
 * @author GXA
 */
public class TableRenderer {
    JTable table; 
    public TableRenderer(JTable table) {
        this.table = table;
    }
    
    public void setTableCellRenderer() {
        CustomTableCellRenderer renderer = new CustomTableCellRenderer("#3a4045", "#53575b");
        table.setDefaultRenderer(Object.class, renderer);
    }
    
    // Hàm chạy khi không có tham số
    public void setTableHeaderRenderer() {
        setTableHeaderRenderer("#606b71");
    }

    // Hàm chạy khi có tham số
    public void setTableHeaderRenderer(String color) {
        CustomHeaderRenderer headerRenderer = new CustomHeaderRenderer(Color.decode(color));
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    
    public void setNoBorder() {
        
    }
    
    public void setAll() {
        setTableCellRenderer();
         setTableHeaderRenderer();
    }
    
}
