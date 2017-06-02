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
import java.io.*;

//soll objecte von create instance in verkettete Liste einfügen, remove...
public class ControlModel {
<<<<<<< HEAD
	private static ControlModel instance;
	private static CommandType[] commandTypes = new CommandType[4];
	private CommandList controlProcess = new CommandList();
=======
	private  static ControlModel instance = new ControlModel();
	private  static CommandType[] commandTypes = new CommandType[4];
	private  static CommandList controlProcess = new CommandList();
>>>>>>> 19f43c29577579583e1b5a37527ead90eb38c34f

	// File file =new File("C:\Users\Jan\Desktop\Hochschule\SS17_17\Informatik
	// 3");
	// Vextor<String> v =new Vector<String>();
	// TextFile tf = new hsrt.mec.controldeveloper.io.TextFile(false);
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
	 * @return Gibt die Referenz des Obejekts ControlModel zurück.
	 */
<<<<<<< HEAD
	public ControlModel getInstance() {
		return new ControlModel();
=======
	public ControlModel getInstance() {	
		return instance;
>>>>>>> 19f43c29577579583e1b5a37527ead90eb38c34f
	}

	/**
	 * Befüllt erste Liste bzw. Array mit allen möglichen CommandType Objekten
	 * (4)
	 */

	public void createCommandTypes() {
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
	}
<<<<<<< HEAD

	// Methoden um die Liste zu verwalten weiß aber noch nicht wie das ganze mit
	// den Button zusammenhängt!
	public void addCommand() {
=======
	
	/*
	// Methoden um die Liste zu verwalten weiß aber noch nicht wie das ganze mit den Button zusammenhängt!
	public void addCommand(){
>>>>>>> 19f43c29577579583e1b5a37527ead90eb38c34f
		controlProcess.add(createInstance());
	}

	public void removeCommand(int pos) {
		controlProcess.remove(pos);
	}

	public void moveUpCommand(int pos) {
		controlProcess.moveUp(pos);
	}

	public void moveDownCommand(int pos) {
		controlProcess.moveDown(pos);
	}

	private Command createInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	/**
	 * Lädt Strings aus einer vorher erzeugten Datei
	 * @return true wenn erfolgreich, false wenn erfolglos
	 */
	public boolean load(File myFile) {
		Vector<String> v = new Vector<String>();
		TextFile loadFile = new TextFile(myFile, false);
		loadFile.read(v);

		for (int i = 0; v.get(i) != "Ende"; i++) {
			String[] parts = v.get(i).split(":");
<<<<<<< HEAD
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
=======
			switch (parts[0]){
				case "Direction":	controlProcess.add(new Direction(Integer.valueOf(parts[1])));
									break;
				case "Gear":		controlProcess.add(new Gear(Integer.valueOf(parts[1]), Double.valueOf(parts[2])));
									break;
				case "Pause":		controlProcess.add(new Pause(Double.valueOf(parts[1])));
									break;
				case "Repetition":	controlProcess.add(new Repetition(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));
									break;
				default:			System.out.println("Fehler!");
									return false;
>>>>>>> 19f43c29577579583e1b5a37527ead90eb38c34f
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
	 * @param c Bekommt ein Objekt vom Typ Command übergeben
	 */
<<<<<<< HEAD

=======
>>>>>>> 19f43c29577579583e1b5a37527ead90eb38c34f
	public void commandPerformed(Command c) {
	}

	/**
	 * Getter-Methode
	 * @return Gibt die Reference der verketteteten Liste von Typ CommandList zurück 
	 */
	public CommandList getControlProcess() {
		return controlProcess;
	}

}
