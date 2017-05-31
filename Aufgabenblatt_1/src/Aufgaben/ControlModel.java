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

//soll objecte von create instance in verkettete Liste einf�gen, remove...
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
	 * gibt instance zur�ck ???
	 * 
	 * @return Gibt ControlModel zur�ck
	 */
	public ControlModel getInstance() {
		return instance;
	}

	/**
	 * Bef�llt erste Liste bzw. Array mit allen m�glichen CommandType Objekten (4)
	 */
	public void createCommandTypes() {
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Repetition");
		commandTypes[3] = new CommandType("Pause");
	}

	/**
	 * L�d Strings aus einer vorher erzeugten Datei
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
	 *            Bekommt Command �bergeben
	 */
	public void commandPerformed(Command c) {

	}

	/**
	 * ??
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
