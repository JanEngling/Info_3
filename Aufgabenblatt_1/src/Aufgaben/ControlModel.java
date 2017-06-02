package Aufgaben;

/**
 * Controler der beiden Listen, implementiert IOType
 * 
 * @author Andreas Sautter u. Jan Engling
 * @version 1.0
 * @since JDK 1.8
 */
import java.io.File;
import java.util.Vector;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;

public class ControlModel {

	private static ControlModel instance = null;
	private CommandType[] commandTypes = new CommandType[4];
	private CommandList controlProcess = new CommandList();

	/**
	 * Standartkonstruktor von ControlModel
	 */
	private ControlModel() {
	}

	/**
	 * Gibt ControlModel zur�ck
	 * 
	 * @return Gibt genau eine Instanz von ControlModel zur�ck
	 */

	public static ControlModel getInstance() {
		if (instance == null) {
			instance = new ControlModel();
			return instance;
		} else
			return instance;
	}

	/**
	 * Bef�llt erste Liste bzw. Array mit allen m�glichen CommandType Objekten
	 * (4)
	 */

	public void createCommandTypes() {
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
	}

	/**
	 * L�dt Strings aus einer vorher erzeugten Datei
	 * 
	 * @return true wenn erfolgreich, false wenn erfolglos
	 */
	public boolean load(File myFile) {
		Vector<String> v = new Vector<String>();
		TextFile loadFile = new TextFile(myFile, false);
		if (myFile.length() == 0) {
			System.out.println("leer");
			loadFile.close();
			return false;
		} else {
			loadFile.read(v);
			for (int i = 0; v.get(i) != "Ende"; i++) {
				String[] parts = v.get(i).split(":");
				switch (parts[0]) {
				case "Direction":	///0 zeilenende !!!!
					controlProcess.add(new Direction(Integer.valueOf(parts[1])));
					break;
				case "Gear":
					controlProcess.add(new Gear(Integer.valueOf(parts[1]), Double.valueOf(parts[2])));
					break;
				case "Pause":
					controlProcess.add(new Pause(Double.valueOf(parts[1])));
					break;
				case "Repetition":
					controlProcess.add(new Repetition(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));
					break;
				case "Ende":
					loadFile.close();
					return true;
				default:
					System.out.println("Fehler");
					loadFile.close();
					return false;
				}
			}
		}
		loadFile.close();
		return true;
	}

	/**
	 * Speichert Liste als Strings in Datei
	 * 
	 * @return true wenn erfolgreich, false wenn erfolglos.
	 */
	public boolean save(File myFile) {
		TextFile saveFile = new TextFile(myFile, false);
		Vector<String> v = new Vector<String>();
		v = controlProcess.readList();
		v.add("Ende");
		saveFile.write(v);
		System.out.println("Saved");
		saveFile.close();
		return true;
	}

	/**
	 * 
	 * @param c
	 *            Bekommt ein Objekt vom Typ Command �bergeben
	 */

	public void commandPerformed(Command c) {
	}

	/**
	 * Getter-Methode
	 * 
	 * @return Gibt die Reference der verketteteten Liste von Typ CommandList
	 *         zur�ck
	 */
	public CommandList getControlProcess() {
		return controlProcess;
	}

}
