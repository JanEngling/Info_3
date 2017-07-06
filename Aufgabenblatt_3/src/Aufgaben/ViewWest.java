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

public class ViewWest extends JPanel {
	private static ViewWest instance = null;
	private JList<String> l = new JList<String>();
	private JTable table;
	ControlModel cm = ControlModel.getInstance();
	String[] st = cm.getCommandTypes();
	JTextArea txt = ViewSouth.getText();
	/*
	 * public void setSelectedItem( int index ){//Ausgabe der Listenwerte if (
	 * index<0 || index>items.length ) return;
	 * 
	 * this.index= index; System.out.println( items[this.index] ); }
	 */
	// Konstruktor
	private ViewWest() {
		this.setLayout(new BorderLayout());
		JButton b = new JButton("Add");
		JButton test = new JButton ("Test");
		
		Vector<Vector> rowdata = new Vector<Vector>();
		for(int i=0; i<cm.getCommandTypes().length; i++){
			Vector<String> tmp = new Vector<String>();
			tmp.addElement(cm.getCommandTypes()[i]);
			rowdata.addElement(tmp);
		}
		/*
		eisns.addElement(cm.getCommandTypes()[0]);
		Vector<String> zwei = new Vector<String>();
		zwei.addElement(cm.getCommandTypes()[1]);
		eisns.addElement(cm.getCommandTypes()[2]);
		rowdata.addElement(eisns);
		rowdata.addElement(zwei);*/
		//System.out.println("Daten" + rowdata.size());
		Vector<String> namen = new Vector<String>();
		namen.add("Types");
		this.table=new JTable(rowdata, namen);
		
		//String[][] str = new String[][]{{"Direction"},{"Gear"}};
		//str[1][1] = {{"hi"},{"d"}};
		//String[][0] str1 = cm.getCommandTypes();
		//String[] str2 = new String[]{"Types"};
		//this.table=new JTable(str, str2);
		 ;
		this.add(new JScrollPane(table),BorderLayout.NORTH);
		
		/*
		l.setListData(cm.getCommandTypes());
		l.setSelectionForeground(Color.GRAY);
		l.setSelectionBackground(Color.orange);
		l.setSelectedIndex(2);

		this.add(l, BorderLayout.CENTER);*/
		this.add(b, BorderLayout.SOUTH);/*
		//this.add(test, BorderLayout.NORTH);	//Add Button
		test.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				System.out.println(cm.getControlProcess().readList());
				System.out.println("funktioniert");
			}
		});*/
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				//System.out.println("Tada");
				System.out.println(table.getSelectedRow());
				txt.setText(st[table.getSelectedRow()].toString());
				cm.getControlProcess().add(new CommandType(st[l.getSelectedIndex()].toString()).createInstance());
			}
		});
		
		/*
		l.addListSelectionListener(new ListSelectionListener() {// ActionListener
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					System.out.println(l.getSelectedIndex()); // Hier kann neues
																// Command
																// angelegt
																// werden
					System.out.println(st[l.getSelectedIndex()].toString());
					txt.setText(st[l.getSelectedIndex()].toString());
					cm.getControlProcess().add(new CommandType(st[l.getSelectedIndex()].toString()).createInstance());
				}
			}
		});*/
	}

	/**
	 * Erzeugt ein Objekt von ConrolModel, wenn noch keins vorhanden ist.
	 * 
	 * @return Gibt genau eine Instanz von ControlModel zurück.
	 */
	
	public static ViewWest getInstance() {
		if (instance == null) {
			instance = new ViewWest();
			return instance;
		} else
			return instance;
	}

}

