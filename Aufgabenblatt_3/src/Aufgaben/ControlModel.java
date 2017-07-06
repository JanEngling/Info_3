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

import hsrt.mec.controldeveloper.core.com.ComHandler;
import hsrt.mec.controldeveloper.core.com.IComListener;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;

public class ControlModel implements IComListener {

	private static ControlModel instance = null;
	private String[] commandTypes = new String[4];
	private CommandListModel clm = new CommandListModel();

	// private CommandType [] commandTypes;
	private CommandList controlProcess = new CommandList(clm);

	private ComHandler comHandler = ComHandler.getInstance();
	private IOType serial;

	/**
	 * Standartkonstruktor von ControlModel
	 */
	private ControlModel() {
		comHandler.register(this);
	}

	public void start() {
		Vector<ICommand> commandlist = new Vector<ICommand>();
		// commandlist.add(null);
		for (int i = 0; controlProcess.get(i) != null; i++) {
			commandlist.addElement(controlProcess.get(i));
		}

		File myFile = new File("Ausgabe.txt");
		TextFile textFile = new TextFile(myFile, false);
		comHandler.start(commandlist, textFile); // alternativ statt textFile
													// usb
		// comHandler.start(commandlist, serial);
	}

	public void stop() {
		comHandler.stop();
	}

	/**
	 * @return the serial
	 */
	public IOType getSerial() {
		return serial;
	}

	/**
	 * @param serial
	 *            the serial to set
	 */
	public void setSerial(IOType serial) {
		this.serial = serial;
	}

	/**
	 * Erzeugt ein Objekt von ConrolModel, wenn noch keins vorhanden ist.
	 * 
	 * @return Gibt genau eine Instanz von ControlModel zurück.
	 */

	public static ControlModel getInstance() {
		if (instance == null) {
			instance = new ControlModel();
			return instance;
		} else
			return instance;
	}

	/*
	 * 
	 * public CommandType[] getCommandTypes() { commandTypes[0] = new
	 * CommandType("Direction"); commandTypes[1] = new CommandType("Gear");
	 * commandTypes[2] = new CommandType("Repetition"); commandTypes[3] = new
	 * CommandType("Pause"); return commandTypes; }
	 * 
	 * /** Befüllt erste Liste bzw. Array mit allen möglichen CommandType
	 * Objekten (4)
	 */
	/*
	 * public void createCommandTypes() { commandTypes[0] = new
	 * CommandType("Direction"); commandTypes[1] = new CommandType("Gear");
	 * commandTypes[2] = new CommandType("Repetition"); commandTypes[3] = new
	 * CommandType("Pause"); }
	 */

	public String[] getCommandTypes() {
		commandTypes[0] = new String("Direction");
		commandTypes[1] = new String("Gear");
		commandTypes[2] = new String("Repetition");
		commandTypes[3] = new String("Pause");
		return commandTypes;
	}

	/**
	 * Befüllt erste Liste bzw. Array mit allen möglichen CommandType Objekten
	 * (4)
	 */

	public void createCommandTypes() {
		commandTypes[0] = new String("Direction");
		commandTypes[1] = new String("Gear");
		commandTypes[2] = new String("Repetition");
		commandTypes[3] = new String("Pause");
	}

	/**
	 * Lädt Strings aus einer vorher erzeugten Datei.
	 * 
	 * @return true wenn erfolgreich, false wenn erfolglos.
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
				case "Direction": /// 0 zeilenende !!!!
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
	 * Speichert Liste als Strings in Datei.
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
	 * Getter-Methode
	 * 
	 * @return Gibt die Reference der verketteteten Liste von Typ CommandList
	 *         zurück.
	 */
	public CommandList getControlProcess() {
		return controlProcess;
	}

	/**
	 * Bekommt ein Objekt vom Typ Command übergeben.
	 * 
	 * @param c
	 *            Command
	 * 
	 */
	public void commandPerformed(ICommand c) {
		ViewSouth.getInstance().addText(c.toString());
	}

	// Grooesse der Liste bestimmen
	public int getControlProcessGroesse() {
		return controlProcess.groeße();
	}

	// Zugriff auf CommandListModel
	public CommandListModel getClm() {
		return clm;
	}
}
