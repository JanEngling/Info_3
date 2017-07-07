package Aufgaben;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * Controler der gesamten Funktionalität des Programms.
 * Beinhaltet auch die Main.
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class MyTableCellRenderer extends DefaultTableCellRenderer{
	

	
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        if (row == 0) {
            JLabel label = new JLabel((String) value);
            label.setFont(new java.awt.Font("Arial", 5, 18));
            return label;

        }
        return super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);
    }

}
