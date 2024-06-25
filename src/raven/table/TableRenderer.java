/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.table;

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
    
    public void setTableHeaderRenderer() {
        CustomHeaderRenderer headerRenderer = new CustomHeaderRenderer();
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    
    public void setAll() {
        setTableCellRenderer();
         setTableHeaderRenderer();
         
    }
    
}
