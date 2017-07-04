package Aufgaben;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ViewWest extends JPanel {
	private static ViewWest instance = null;
	private JList<String> l = new JList<String>();
	private JButton add = new JButton("Add");
	
	private CommandType ct;
	private String auswahl;
	
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
	
		this.setLayout( new BorderLayout());
	/*	
		String [] 
		
		for(CommandType temp : st)
			l.setListData(temp.getName());
			//l.add(temp.getName());
		
		*/
		
		l.setListData(cm.getCommandTypes());
		l.setSelectionForeground(Color.GRAY);
		l.setSelectionBackground(Color.orange);
		//l.setSelectedIndex(2);
		add(l, BorderLayout.CENTER);
		l.addListSelectionListener(new ListSelectionListener() {// ActionListener
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()){
					//System.out.println(l.getSelectedIndex());	//Hier kann neues Command angelegt werden
					//System.out.println(st[l.getSelectedIndex()].toString());
					
					// CommandType wird erstellt um später mit der Methode createInstance ein Command zu erzeugen 
					auswahl = st[l.getSelectedIndex()].toString();
					ct = new CommandType(auswahl);
				}
			}
		});
		
		add(add, BorderLayout.SOUTH);
		
		add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	// ct überprüfen oben es vom List Selection Listener erstellt wurde 
            	if(ct != null){
            		cm.getControlProcess().add(ct.createInstance());
                	System.out.println("Groese Liste: "+ cm.getControlProcessGroesse());
                	System.out.println("Command erstellt: " + ct.getName());
                   // cm.getClm().dataChanged();	
            	}
            }
        }
    );
    
		
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