package Aufgaben;

import hsrt.mec.controldeveloper.core.com.command.IDirection;

/**
 * Gibt Richtung der fahrzeugbewegung an, implementiert Interface und
 * Funktionalitäten
 * 
 * @author Jan
 * @version 1.0
 */
public class Direction extends Command implements IDirection {
	private int degree;

	/**
	 * Konstruktor mit selbst gewählter Richtung
	 * 
	 * @param degree
	 *            gibt Winkle der Bewegung an
	 */
	public Direction(int degree) {
		this.setName("Direction");
		this.degree = degree;
	}

	/**
	 * Standartkonstructor mit vorgegebener Richtung
	 */
	public Direction() {
		this.setName("Direction");
		this.degree = 0;
	}

	/**
	 * @return gibt Richtung zurück
	 */
	public int getDegree() {
		return degree;
	}

	/**
	 * @param degree
	 *            Übergebene Richtung wird Richtung des Commands
	 */
	public void setDegree(int degree) {
		this.degree = degree;
	}

	/**
	 * @return gibt Richtung als String zurück
	 */
	public String toString() {
		return "Direction [degree=" + degree + "]";
	}

}
