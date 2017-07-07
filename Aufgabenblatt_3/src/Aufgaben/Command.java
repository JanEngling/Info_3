package Aufgaben;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * Erzeug Command und implemenetiert Interface zur besseren Handhabung
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public abstract class Command implements ICommand {
	private String name;

	/**
	 * @return Gibt Name des Commands zurück
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param s
	 *            Übernimmt eingegebenen String
	 */
	public void setName(String name) {
		this.name = name;
	}

}
