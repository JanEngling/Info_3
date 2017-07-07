package Aufgaben;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Mittleres Fenster
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class ViewMiddle extends JPanel {
	private ControlModel c;
	private static ViewMiddle instance = null;
	private JTable table;

	/**
	 * Konstruktor des mittleren Fensters
	 */
	public ViewMiddle() {
		this.c = ControlModel.getInstance();

		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLUE);
		this.add(new MiddleButton(), BorderLayout.SOUTH);

		// Tabelle wird erstellte und das CommandListModel wird übergeben
		// Danach an das Panel addden
		this.table = new JTable(c.getClm());
		this.add(new JScrollPane(table), BorderLayout.CENTER);

		table.setRowHeight(30);

		c.getClm().setTable(table);

	}

	/**
	 * 
	 * 
	 * @return Gibt genau eine Instanz von ViewMiddle zurück.
	 */

	public static ViewMiddle getInstance() {
		if (instance == null) {
			instance = new ViewMiddle();
			return instance;
		} else
			return instance;
	}

	/**
	 * resetet die Anzeige des mittleren Fensters
	 */
	public void setVisible() {
		ViewMiddle.getInstance().setVisible(false);
		ViewMiddle.getInstance().setVisible(true);
	}

	/**
	 * Gibt die Tabelle zurück
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * resetet die Anzeige der Tabelle
	 */
	public void resetTableview() {
		table.setVisible(false);
		table.setVisible(true);
	}
}
