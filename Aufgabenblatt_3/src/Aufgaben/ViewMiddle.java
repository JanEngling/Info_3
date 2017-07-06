package Aufgaben;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ViewMiddle extends JPanel{
	private ControlModel c;
	private static ViewMiddle instance = null;

	private JTable table;
	//private CommandListModel model;
	
	public ViewMiddle(){
		this.c = ControlModel.getInstance();
		
		this.setLayout( new BorderLayout());
        this.setBackground(Color.BLUE);
        this.add(new MiddleButton(), BorderLayout.SOUTH);
        
        
        // Tabelle wird erstellte und das CommandListModel wird �bergeben 
        // Danach an das Panel addden
        this.table = new JTable(c.getClm());
        this.add(new JScrollPane(table),BorderLayout.CENTER);
        
        //table.setDefaultRenderer(Object.class, new MyTableCellRenderer( ));
        
        table.setRowHeight(30);
        
        c.getClm().setTable(table);
        
        //c.getControlProcess().remove(0);
		//c.getClm().dataChanged();
       
        /*
        JButton b = new JButton("test");
        this.add(b, BorderLayout.NORTH);
        b.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent a){
        		System.out.println("Zeile: " + table.getSelectedRow());
        	}
        });
        */
	}
	/**
	 * Erzeugt ein Objekt von ConrolModel, wenn noch keins vorhanden ist.
	 * 
	 * @return Gibt genau eine Instanz von ControlModel zur�ck.
	 */

	public static ViewMiddle getInstance() {
		if (instance == null) {
			instance = new ViewMiddle();
			return instance;
		} else
			return instance;
	}
	public void setVisible(){
		ViewMiddle.getInstance().setVisible(false);
		ViewMiddle.getInstance().setVisible(true);
	}
	public JTable getTable(){
		return table;
	}
	public void resetTableview(){
		table.setVisible(false);
		table.setVisible(true);
	}
}
