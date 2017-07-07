package Aufgaben;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
/**
 * Model um Funktionalitäten der Liste zu verwalten
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class CommandListModel extends AbstractTableModel {

	private String[] titles = new String[] { "No.", "Command", "Configuration" };
	private JTable table;

	public void addTableModelListener(TableModelListener l) {
	}

	/**
	 * Gibt Klasse der Zeile zurück
	 */
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		default:
			return null;
		}
	}

	// Spalten festlegen
	/**
	 * Setzt Anazhl der Spalten
	 */
	public int getColumnCount() {
		return titles.length;
	}

	// Überschriften generieren
	/**
	 * Setzt Überschriften der Spalten
	 */
	public String getColumnName(int columnIndex) {
		return titles[columnIndex];
	}

	// Anzahl zeilen
	/**
	 * Setzt Größe der Liste als Anzahl der Reihen
	 */
	public int getRowCount() {
		return ControlModel.getInstance().getControlProcess().groeße();
	}

	/**
	 * Gibt String aus Inhalt des Feldes zurück
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		// Temp Variable das man nicht immer alles Ausschreiben muss
		Command temp = ControlModel.getInstance().getControlProcess().get(rowIndex);

		switch (columnIndex) {
		case 0:
			return rowIndex + 1;
		case 1:
			return temp.getName();
		case 2:
			switch (temp.getName()) {
			case "Gear":
				return "Speed: " + ((Gear) temp).getSpeed() + "   Duration: " + ((Gear) temp).getDuration();
			case "Repetition":
				return "NrRepetions: " + ((Repetition) temp).getNrRepetitions() + "   NrSteps: "
						+ ((Repetition) temp).getNrSteps();
			case "Pause":
				return "Duration: " + ((Pause) temp).getDuration();
			case "Direction":
				return "Direction: " + ((Direction) temp).getDegree();
			}
		default:
			return "Fehler";
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void removeTableModelListener(TableModelListener l) {
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

	/**
	 * Repainted die mittlere Tabelle bei geänderten Daten
	 */
	public void dataChanged() { // hier repaint
		System.out.println("Aufruf Data Changed");
		ViewMiddle.getInstance().setVisible();
		ViewMiddle.getInstance().resetTableview();
		ViewEast.getInstance().changed();
		fireTableDataChanged();
	}

	/**
	 * 
	 * @param Setzt
	 *            die übergebene Tabelle als Tabelle
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * 
	 * @param Setzt
	 *            die Selectierte Reihe
	 */
	public void setSelectedRow(int row) {
		table.setRowSelectionInterval(row, row);
	}

	/**
	 * Gibt die ausgewählte Reihe zurück
	 */
	public int getSelectedRow() {
		return table.getSelectedRow();
	}

}
