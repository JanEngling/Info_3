package Aufgaben;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Linkes Fenster der Anzeige
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class ViewWest extends JPanel {
	private static ViewWest instance = null;
	private JList<String> l = new JList<String>();
	private JTable table;
	ControlModel cm = ControlModel.getInstance();
	String[] st = cm.getCommandTypes();
	JTextArea txt = ViewSouth.getText();
	
	/**
	 * Konstruktor der linken Tabelle
	 */
	private ViewWest() {
		this.setLayout(new BorderLayout());
		JButton b = new JButton("Add");
		JButton test = new JButton("Test");

		Vector<Vector> rowdata = new Vector<Vector>();
		for (int i = 0; i < cm.getCommandTypes().length; i++) {
			Vector<String> tmp = new Vector<String>();
			tmp.addElement(cm.getCommandTypes()[i]);
			rowdata.addElement(tmp);
		}

		Vector<String> namen = new Vector<String>();
		namen.add("Types");
		this.table = new JTable(rowdata, namen){
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		
		
		this.add(new JScrollPane(table), BorderLayout.CENTER);

		this.add(b, BorderLayout.SOUTH);
		
		table.setRowHeight(25);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				System.out.println(table.getSelectedRow());
				// Wenn kein Element ausgewählt ist gibt getSelectedRow eine -1
				// zurück
				if (table.getSelectedRow() != -1) {
					// Ausgabe Konsole
					txt.setText("new" + st[table.getSelectedRow()].toString());
					// CommandType erstellen und daraus ein bestimmtes Command
					// erzeugen
					CommandType ct = new CommandType(st[table.getSelectedRow()].toString());
					cm.getControlProcess().add(ct.createInstance());
				}
			}
		});

	}

	/**
	 * 
	 * @return Gibt genau eine Instanz von ViewWest zurück.
	 */

	public static ViewWest getInstance() {
		if (instance == null) {
			instance = new ViewWest();
			return instance;
		} else
			return instance;
	}

}
