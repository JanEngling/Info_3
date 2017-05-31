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

//soll objecte von create instance in verkettete Liste einfügen, remove...
public class ControlModel implements IOType {
	private  static ControlModel instance = new ControlModel();
	private  static CommandType[] commandTypes = new CommandType[4];
	private  static CommandList controlProcess;

	// File file =new File("C:\Users\Jan\Desktop\Hochschule\SS17_17\Informatik
	// 3");
	
	/**
	 * experiment
	 * @param f
	 * @param b
	 */
	/*
	public void TextFile(File f, boolean b){	
	}
	*/
	
	/**
	 * Standartkonstruktor von ControlModel
	 */
	private ControlModel() {
	}
	
	/**
	 * braucht man um zu definieren was der input is 
	 * @param f
	 * @param b
	 */
	public void TextFile (File f, boolean b){
	}
	
	/**
	 * Getter-Methode
	 * @return Gibt die Referenz des Obejekts ControlModel zurück.
	 */
	public ControlModel getInstance() {
		return instance;
	}

	/**
	 * Befüllt erste Liste bzw. Array mit allen möglichen CommandType Objekten (4)
	 */
	public void createCommandTypes() {
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
	}
	
	
	// Methoden um die Liste zu verwalten weiß aber noch nicht wie das ganze mit den Button zusammenhängt!
	public void addCommand(){
		controlProcess.add(createInstance());
	}
	
	public void removeCommand(int pos){
		controlProcess.remove(pos);
	}
	
	public void moveUpCommand(int pos){
		controlProcess.moveUp(pos);
	}
	
	public void moveDownCommand(int pos){
		controlProcess.moveDown(pos);
	}
	
	

	private Command createInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Lädt Strings aus einer vorher erzeugten Datei
	 * 
	 * @return true wenn erfolgreich, false wenn erfolglos
	 */
	public boolean load(/* File */) {
		return true;
	}

	/**
	 * Speichert Liste als Strings in Datei
	 * 
	 * @return true wenn erfolgreich, false wenn erfolglos
	 */
	public boolean save() {
		return true;
	}

	/**
	 * ???
	 * 
	 * @param c
	 *            Bekommt Command übergeben
	 */
	
	public void commandPerformed(Command c) {
	}

	/**
	 * Methode um dem prozess zu starten bzw. stoppen?
	 * 
	 * @return
	 */
	public CommandList getControlProcess() {
		return null;
	}
	
	@Override
	public boolean close() {
		return false;
	}
	
	/**
	 * Daten in der Datei werden in den Vector geschrieben
	 */
	public boolean read(Vector<String> arg0) {
		return false;
	}
	
	/**
	 * Alle Daten in vector (Strings werden in die datei geschriben)
	 */
	public boolean write(Vector<String> arg0) {
		return false;
	}

	
	
}
