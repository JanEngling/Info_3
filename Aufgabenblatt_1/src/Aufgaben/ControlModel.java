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

public class ControlModel implements IOType {
	private static ControlModel instance;
	private static CommandType[] commandTypes = new CommandType[4];
	private static CommandList controlProcess;

	// File file =new File("C:\Users\Jan\Desktop\Hochschule\SS17_17\Informatik
	// 3");
	/**
	 * Standartkonstruktor von ControlModel
	 */
	private ControlModel() {
	}

	/**
	 * Holt Instance ???
	 * 
	 * @return Gibt ControlModel zur�ck
	 */
	public ControlModel getInstance() {
		return null;
	}

	/**
	 * Bef�llt erste Liste mit allen CommandType Objekten
	 */
	public void createCommandTypes() {

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

	/**
	 * ???
	 */
	public boolean close() {
		return false;
	}

	/**
	 * Liest aus einer Datei ???
	 */
	public boolean read(Vector<String> arg0) {
		return false;
	}

	/**
	 * Schreibt in eine Datei???
	 */
	public boolean write(Vector<String> arg0) {
		return false;
	}
}
