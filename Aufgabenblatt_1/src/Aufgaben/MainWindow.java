package Aufgaben;

import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class MainWindow extends JFrame {
	private ControlModel c;
	
	
	public void mainWindow(ControlModel c) {
		this.c = c;
		
		// Fenster erzeugen
		JFrame gui = new JFrame("Control-Developer");
		gui.setSize(1920,1080);
		gui.setLayout(new GridBagLayout());

		// Menü Leiste hinzufügen
		MenuBar menu = new MenuBar();
		gui.setJMenuBar(menu.getJMenuBar(c));
		
		ViewMiddle viewMiddle = new ViewMiddle();
		gui.add(viewMiddle.getPanel());

		// Fenster sichtbar machen
		gui.setVisible(true);
		
		
	}
}
