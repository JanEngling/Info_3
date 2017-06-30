package Aufgaben;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar {
	
	private JMenuBar bar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu info = new JMenu("Info");
	private JMenuItem load = new JMenuItem("Datei laden");
	private JMenuItem save = new JMenuItem("Datei speichern");
	

	public JMenuBar getJMenuBar(ControlModel c) {
		bar.add(file);
		file.add(load);
		file.add(save);
		bar.add(info);
		
		return bar;
	}

}
