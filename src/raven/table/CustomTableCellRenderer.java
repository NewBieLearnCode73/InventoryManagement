package raven.table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    private Color evenRowColor;
    private Color oddRowColor;

    public CustomTableCellRenderer(String evenRowHex, String oddRowHex) {
        this.evenRowColor = Color.decode(evenRowHex);
        this.oddRowColor = Color.decode(oddRowHex);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (!isSelected) {
            c.setBackground(row % 2 == 0 ? evenRowColor : oddRowColor);
        }
        return c;
    }
}
