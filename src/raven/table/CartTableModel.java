/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.table;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author GXA
 */
public class CartTableModel extends DefaultTableModel {
    public CartTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        // Bạn có thể điều chỉnh đây để chỉ cho phép chỉnh sửa những cột cụ thể nếu cần thiết
        return column == 4; // Không cho phép chỉnh sửa bất kỳ ô nào
    }
}
