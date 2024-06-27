
package raven.table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

import java.awt.Color;

public class CustomHeaderRenderer extends DefaultTableCellRenderer {
    private Color headerColor;
   public CustomHeaderRenderer(Color headerColor) {
        this.headerColor = headerColor;

        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("Arial", Font.BOLD, 14));
        setBackground(headerColor);
        setForeground(Color.WHITE);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setText(value != null ? value.toString() : ""); // Set the text to the column name
        return this;
    }
}


