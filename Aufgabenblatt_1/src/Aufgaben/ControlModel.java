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
//import java.io.*;

//soll objecte von create instance in verkettete Liste einf�gen, remove...
public class ControlModel {

	private static ControlModel instance = new ControlModel();
	private static CommandType[] commandTypes = new CommandType[4];
	private static CommandList controlProcess = new CommandList();

	/**
	 * experiment
	 * 
	 * @param f
	 * @param b
	 */
	/*
	 * public void TextFile(File f, boolean b){ }
	 */

	/**
	 * Standartkonstruktor von ControlModel
	 */
	// Hiernoch fehler
	public ControlModel() {
	}

	/**
	 * braucht man um zu definieren was der input is
	 * 
	 * @param f
	 * @param b
	 */

	/**
	 * Getter-Methode
	 * 
	 * @return Gibt die Referenz des Obejekts ControlModel zur�ck.
	 */

	public ControlModel getInstance() {
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

	// Methoden um die Liste zu verwalten wei� aber noch nicht wie das ganze mit
	// den Button zusammenh�ngt!
	public void addCommand() {
	}

	/*
	 * // Methoden um die Liste zu verwalten wei� aber noch nicht wie das ganze
	 * mit den Button zusammenh�ngt! public void addCommand(){ >>>>>>>
	 * 19f43c29577579583e1b5a37527ead90eb38c34f
	 * controlProcess.add(createInstance()); }
	 * 
	 * public void removeCommand(int pos) { controlProcess.remove(pos); }
	 * 
	 * public void moveUpCommand(int pos) { controlProcess.moveUp(pos); }
	 * 
	 * public void moveDownCommand(int pos) { controlProcess.moveDown(pos); }
	 * 
	 * private Command createInstance() { // TODO Auto-generated method stub
	 * return null; }
	 */

	/**
	 * L�dt Strings aus einer vorher erzeugten Datei
	 * 
	 * @return true wenn erfolgreich, false wenn erfolglos
	 */
	public boolean load(File myFile) {
		Vector<String> v = new Vector<String>();
		TextFile loadFile = new TextFile(myFile, false);
		if (myFile.length()==0){
			System.out.println("leer");
			return false;
		}
		loadFile.read(v);

		for (int i = 0; v.get(i) != "Ende"; i++) {
			String[] parts = v.get(i).split(":");
			switch (parts[0]) {
			case "Direction":
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
		System.out.println("Saved");
		v = controlProcess.readList();
		v.add("Ende");
		saveFile.write(v);
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
