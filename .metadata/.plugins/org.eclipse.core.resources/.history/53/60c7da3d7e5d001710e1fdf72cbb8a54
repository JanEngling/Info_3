package Aufgaben;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow extends JFrame {
	private ControlModel c;
	
	private JFrame gui = new JFrame("Control-Developer");
	private JPanel panel = new JPanel();
	
	private GridBagConstraints middle = new GridBagConstraints(); 
	private GridBagConstraints east = new GridBagConstraints(); 
	private GridBagConstraints west = new GridBagConstraints(); 
	private GridBagConstraints south = new GridBagConstraints();
	
	private ViewMiddle vm = new ViewMiddle(c); 
	private ViewWest vw = new ViewWest(c); 
	private ViewEast ve = new ViewEast(c);
	private ViewSouth vs = new ViewSouth(c);
	
	
	public MainWindow(ControlModel c) {
		this.c = c;
		
		// Fenstergröße festlegen 
		gui.setSize(1920,1080);
		
		// Aufteilung Fenster 
		panel.setLayout(new GridBagLayout());
		
		// Panel Fenster hinzufügen 
		gui.add(panel);
		

		// Menü Leiste hinzufügen
		MenuBar menu = new MenuBar();
		gui.setJMenuBar(menu.getJMenuBar(c));
		
		// Mitte Commandlist
		//middle.gridheight = 500;
		//middle.gridwidth = 1000;
		middle.ipadx = 1000; //
		middle.ipady = 1000;
		middle.weightx = 1.0;
		middle.weighty = 1.0;
		middle.gridx = 1;
		middle.gridy = 0;
		panel.add(vm, middle);
		
		
		// Westen Bedienfeld
		west.ipadx = 1000; //
		west.ipady = 1000;
		west.gridx = 2;
		west.gridy = 0;
		panel.add(vw, west);
		
		
		// Osten Commandtypes
		east.ipadx = 1000; //
		east.ipady = 1000;
		east.gridx = 0;
		east.gridy = 0;
		panel.add(ve, east);
		
		//Süden Anzeigefeld 
		//south.anchor = GridBagConstraints.PAGE_END;
		south.fill = GridBagConstraints.HORIZONTAL;
	//	south.gridx = 0;
		south.gridy = 1;
		panel.add(vs, south);
		


		// Fenster sichtbar machen
		gui.setVisible(true);
		
		
	}
}
