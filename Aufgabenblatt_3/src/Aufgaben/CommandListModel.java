package Aufgaben;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class CommandListModel extends AbstractTableModel {
	
	private String[] titles = new String[]{ "No.", "Command", "Configuration" };
	private JTable table;

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub		
	}	

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex){
		case 0: return Integer.class;
		case 1: return String.class;
		case 2: return String.class;
		default: return null;
		}
	}

	// Spalten festlegen
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titles.length;
	}
	
	//‹berschriften generieren 
	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return titles[columnIndex];
	}
	

	// Anzahl zeilen 
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ControlModel.getInstance().getControlProcess().groeﬂe();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		// Temp Variable das man nicht immer alles Ausschreiben muss
		Command temp = ControlModel.getInstance().getControlProcess().get(rowIndex);
		
		switch (columnIndex){
			case 0: return rowIndex + 1;
			case 1: return temp.getName();
			case 2: switch(temp.getName() ){
            			case "Gear": return "Speed: " + ((Gear)temp).getSpeed() + "   Duration: " + ((Gear)temp).getDuration();
            			case "Repetition": return "NrRepetions: " +((Repetition)temp).getNrRepetitions() + "   NrSteps: " +((Repetition)temp).getNrSteps();
            			case "Pause": return "Duration: " + ((Pause)temp).getDuration();
            			case "Direction": return "Direction: " + ((Direction)temp).getDegree();
					}
			default: return "Fehler";
		}	
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	
	public void dataChanged (){
		System.out.println("Aufruf Data Changed");
		fireTableDataChanged();
	}
	
	public void setTable(JTable table){
		this.table = table;
	}
	
	public void setSelectedRow(int row){
		table.setRowSelectionInterval(row, row);
		//table.repaint();
	}
	
	public int getSelectedRow(){
		return table.getSelectedRow();
	}
	/*
	public int getSelectedRowCount(){
		int selectedRowCount = ControlModel.getInstance().getClm().getSelectedRowCount();
		return selectedRowCount; 
	}
	*/

}
