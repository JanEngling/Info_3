package Aufgaben;

import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class MainWindow extends JFrame {
	private ControlModel c;
	
	private JFrame gui = new JFrame("Control-Developer");
	private JPanel panel = new JPanel();
	
	
	public void mainWindow(ControlModel c) {
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
		

		// Fenster sichtbar machen
		gui.setVisible(true);
		
		
	}
}
