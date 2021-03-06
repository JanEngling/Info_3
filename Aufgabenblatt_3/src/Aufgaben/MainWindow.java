package Aufgaben;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Container des Hauptfensters
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class MainWindow extends JFrame {
	private ControlModel c;
	private JFrame gui = new JFrame("Control-Developer");
	private JPanel panel = new JPanel();
	private GridBagConstraints middle = new GridBagConstraints();
	private GridBagConstraints east = new GridBagConstraints();
	private GridBagConstraints west = new GridBagConstraints();
	private GridBagConstraints south = new GridBagConstraints();

	ViewMiddle vm = ViewMiddle.getInstance();
	ViewEast ve = ViewEast.getInstance();
	ViewSouth vs = ViewSouth.getInstance();
	ViewWest vw = ViewWest.getInstance();
	ControlModel cm = ControlModel.getInstance();

	JMenuBar mb = MenuBar.getInstance();

	/**
	 * F�gt Panels an richtiger Position in das Fenster ein
	 */
	public void mainWindow() {
		this.c = cm;

		// Fenstergr��e festlegen
		gui.setSize(1980, 1080);
		gui.setMinimumSize(new Dimension(1600, 1200));

		// Aufteilung Fenster
		panel.setLayout(new GridBagLayout());

		// Panel Fenster hinzuf�gen
		gui.add(panel);

		// Men� Leiste hinzuf�gen
		gui.setJMenuBar(mb);

		// Mitte Commandlist
		middle.anchor = GridBagConstraints.PAGE_START;
		middle.ipadx = 3000;
		middle.ipady = 4000;
		middle.weightx = 1.0;
		middle.weighty = 0.5;
		middle.gridx = 1;
		middle.gridy = 0;
		panel.add(vm, middle);
		vm.setVisible(true);
		vm.setBackground(Color.BLUE);

		// Westen CommandTypes
		west.anchor = GridBagConstraints.PAGE_START;
		west.ipadx = 300;
		west.ipady = 4000;
		west.weightx = 0.0;
		west.weighty = 0.5;
		west.gridx = 0;
		west.gridy = 0;
		panel.add(vw, west);
		vw.setVisible(true);

		// Osten Bedienfeld
		east.anchor = GridBagConstraints.PAGE_START;
		east.ipadx = 300;
		east.ipady = 4000;
		east.weightx = 0.0;
		east.weighty = 0.5;
		east.gridx = 2;
		east.gridy = 0;
		panel.add(ve, east);
		ve.setVisible(true);

		// S�den Anzeigefeld
		south.anchor = GridBagConstraints.PAGE_END;
		south.fill = GridBagConstraints.HORIZONTAL;
		south.ipadx = 300;
		south.ipady = 4000;
		south.gridwidth = 3;
		south.weightx = 1.0;
		south.weighty = 0.5;
		south.gridx = 0;
		south.gridy = 1;
		panel.add(vs, south);
		vs.setVisible(true);

		
		//gui.pack();
		gui.setVisible(true);

	}
}
