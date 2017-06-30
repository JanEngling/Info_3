package Aufgaben;

import java.io.File;
import java.util.Vector;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;

/**
 * Controler der gesamten Funktionalität des Programms.
 * Beinhaltet auch die Main.
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class ControlDeveloper {
	private static String name = "Control Developer";
	private static File myFile = new File(System.getProperty("user.dir") + "\\meine_datei.txt");

	/**
	 * @return Gibt den Namen des ControlDevelopers zurück
	 */
	public String getName() {
		return name;
	}

	/**
	 * Übergebener Name wird Name des ControlDevelopers.
	 * 
	 * @param name Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Hauptprogramm zeigt Funktionalität der Unterklassen
	 * 
	 * @param s Überabeparameter an main
	 */
	public static void main(String[] s) {
		ControlModel c = ControlModel.getInstance();
		MainWindow gui = new MainWindow();

		c.getControlProcess().add(new Direction(4));
		c.getControlProcess().add(new Pause(4));

		c.save(myFile);
		for (int i = 0; c.getControlProcess().get(i) != null; i++) {
			System.out.println(c.getControlProcess().get(i).toString());
		}
		c.load(myFile);
		for (int i = 0; c.getControlProcess().get(i) != null; i++) {
			System.out.println(c.getControlProcess().get(i).toString());
		}
		
		//GUI
		gui.mainWindow(c);
	}

}
