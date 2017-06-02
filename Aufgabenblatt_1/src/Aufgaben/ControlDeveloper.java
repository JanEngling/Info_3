package Aufgaben;

import java.io.File;
import java.util.Vector;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;

/**
 * Controler der gesamten Funktionalität des Programms
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class ControlDeveloper {
	private static String name = "Control Developer";
	private static File myFile =new File(System.getProperty("user.dir")+"\\meine_datei.txt");
	
	/**
	 * @return Gibt den Namen des ControlDevelopers zurück
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Übergebener Name wird Name des ControlDevelopers
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Hauptprogramm zeigt Funktionalität der Unterklassen
	 * 
	 * @param s
	 *            Überabeparameter an main
	 */
	public static void main(String[] s) {
		ControlModel c = ControlModel.getInstance();
		c.load(myFile);
		c.getControlProcess().add(new Direction(4));
		c.getControlProcess().add(new Pause(4));
		for (int i = 0; c.getControlProcess().get(i) != null;i++){
			System.out.println(c.getControlProcess().get(i).toString());
		}
		c.save(myFile);
	}

}
