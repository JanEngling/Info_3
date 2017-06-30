package Aufgaben;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ViewWest extends JPanel {
	private static ViewWest instance = null;
	private JList<String> l = new JList<String>();
	ControlModel cm = ControlModel.getInstance();
	String[] st = cm.getCommandTypes();
	
	/*
	 * public void setSelectedItem( int index ){//Ausgabe der Listenwerte if (
	 * index<0 || index>items.length ) return;
	 * 
	 * this.index= index; System.out.println( items[this.index] ); }
	 */
	// Konstruktor
	private ViewWest() {
		l.setListData(cm.getCommandTypes());
		l.setSelectionForeground(Color.GRAY);
		l.setSelectionBackground(Color.orange);
		l.setSelectedIndex(2);
		add(l);
		l.addListSelectionListener(new ListSelectionListener() {// ActionListener
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()){
					System.out.println(l.getSelectedIndex());	//Hier kann neues Command angelegt werden
					System.out.println(st[l.getSelectedIndex()].toString());
					
				}
			}
		});
	}

	/**
	 * Erzeugt ein Objekt von ConrolModel, wenn noch keins vorhanden ist.
	 * 
	 * @return Gibt genau eine Instanz von ControlModel zur�ck.
	 */

	public static ViewWest getInstance() {
		if (instance == null) {
			instance = new ViewWest();
			return instance;
		} else
			return instance;
	}

}

/*
 * package hsrt.mec.mvc;
 * 
 * import javax.swing.JFrame; import javax.swing.JButton; import
 * javax.swing.JTextField; import java.awt.BorderLayout;
 * 
 * class LottoView extends JFrame{ private JTextField in = new JTextField(20);
 * private JButton b = new JButton("Save"); private JTextField out= new
 * JTextField(30); private LottoModel lM;
 * 
 * public LottoView (LottoModel lM){ super("Lottotipp");
 * 
 * this.lM= lM; out.setEditable(false); b.addActionListener(new
 * LottoController(this, lM));
 * 
 * add(in, BorderLayout.WEST); add(b, BorderLayout.CENTER); add(out,
 * BorderLayout.SOUTH); }
 * 
 * public void update(){ // 4. update mit neuen daten out.setText(lM.getTipp());
 * in.setText(""); }
 * 
 * public String getText(){ return in.getText(); }
 * 
 * 
 * }
 */