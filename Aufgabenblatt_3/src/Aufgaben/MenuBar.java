package Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import hsrt.mec.controldeveloper.core.com.ComPort;
import hsrt.mec.controldeveloper.core.com.ComPortHandler;
import hsrt.mec.controldeveloper.io.SerialUSB;

/**
 * Men�leiste des Hauptfensters
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class MenuBar extends JMenuBar {
	private ControlModel cm;

	private static JMenuBar instance;

	private JMenu file = new JMenu("File");
	private JMenu port = new JMenu("Port");
	private JMenu info = new JMenu("Info");
	private JMenuItem load = new JMenuItem("Datei laden");
	private JMenuItem save = new JMenuItem("Datei speichern");
	private JMenuItem delete = new JMenuItem("Liste l�schen");
	
    FileFilter filter = new FileNameExtensionFilter(".txt", "txt");
    JFileChooser chooser = new JFileChooser("d:/Documents/Studium/3. Semester/Informatik/SS_17_Praktikum/Info_3/Aufgabenblatt_3");
	
	
	private JMenuItem test;
	private SerialUSB usb;
	private JMenuItem about = new JMenuItem("About");
	ComPortHandler cph = new ComPortHandler();
	ComPort[] cp = new ComPort[10];

	/**
	 * Konstruktor der Men�leiste
	 */
	public MenuBar() {
		this.cm = ControlModel.getInstance();

		this.add(file);
		file.add(load);
		file.add(save);
		file.add(delete);

		this.add(port);

		info.add(about);

		this.add(info);

		// MenuItem TextDatei laden
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Load");
				chooser.addChoosableFileFilter(filter);
				chooser.showDialog(null, "Datei ausw�hlen");
				ControlModel.getInstance().load(chooser.getSelectedFile());
				ControlModel.getInstance().getClm().dataChanged();
			}
		});

		// Menu Item Text Datei speichern
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Saved");
				chooser.addChoosableFileFilter(filter);
				chooser.showDialog(null, "Datei ausw�hlen");
				ControlModel.getInstance().save(chooser.getSelectedFile());
				ControlModel.getInstance().getControlProcess().deleteList();
				ControlModel.getInstance().getClm().dataChanged();
			}
		});

		// MenuItem Liste leeren
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Liste gel�scht");
				ControlModel.getInstance().getControlProcess().deleteList();
				ControlModel.getInstance().getClm().dataChanged();
			}
		});

		ComPort[] ports = cph.getPorts();
		System.out.println("Laenge " + ports.length);
		for (ComPort wire : ports) {
			JMenuItem item = new JMenuItem(wire.getName());
			port.add(item);
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cm.setSerial(new SerialUSB(wire));
					ViewSouth.getInstance().addText("Selected Port: " + wire.getName());
					System.out.println("ActionPerformed");
				}
			});
		}

		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showOptionDialog(null,
						"� Jan Engling und Andreas Sautter\n Programm f�r einen nicht fahrt�chtigen Rovers", "Info",
						JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ports, "fefhueh");
			}
		});

	}

	/**
	 * 
	 * @return Liefert genau ein Objekt der Men�leiste zur�ck
	 */
	public static JMenuBar getInstance() {
		if (instance == null) {
			instance = new MenuBar();
			return instance;
		} else
			return instance;
	}

}
