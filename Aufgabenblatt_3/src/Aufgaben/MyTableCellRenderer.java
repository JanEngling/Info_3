package Aufgaben;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyTableCellRenderer extends DefaultTableCellRenderer{
	
	/*
	public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
       
                       
                JLabel c = (JLabel)super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
        c.setFont(new Font("Arial", Font.BOLD, 30));
        c.setBackground(Color.LIGHT_GRAY);
        c.setVerticalAlignment(JLabel.CENTER);
        c.setHorizontalAlignment(JLabel.CENTER);
 
        return c;
    }
    */
	
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        // TODO Auto-generated method stub
        if (row == 0) {
            JLabel label = new JLabel((String) value);
            label.setFont(new java.awt.Font("Arial", 5, 18));
            return label;

        }
        return super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);
    }

}
