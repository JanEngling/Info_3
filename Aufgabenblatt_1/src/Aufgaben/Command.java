package Aufgaben;

import hsrt.mec.controldeveloper.core.com.command.ICommand;

/**
 * Erzeug Command und implmenetiert Interface zur besseren Handhabung
 * 
 * @author Jan
 * @version 1.0
 */
public abstract class Command implements ICommand {
	private String name;

	/**
	 * @return gibt Name des Commands zurück
	 */
	public String getName() {
		System.out.println("Penis");
		return name;
	}

	/**
	 * @param s
	 *            übernimmt einegegebenen String
	 */
	public void setName(String s) {
		this.name = s;
	}
	
	System.out.println("efnevnfejjf");

}
