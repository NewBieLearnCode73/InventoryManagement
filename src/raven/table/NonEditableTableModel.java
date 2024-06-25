package raven.table;
import javax.swing.table.DefaultTableModel;

public class NonEditableTableModel extends DefaultTableModel {
    public NonEditableTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // Bạn có thể điều chỉnh đây để chỉ cho phép chỉnh sửa những cột cụ thể nếu cần thiết
        return false; // Không cho phép chỉnh sửa bất kỳ ô nào
    }
}
