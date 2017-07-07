package Aufgaben;

import hsrt.mec.controldeveloper.core.com.command.IGear;

/**
 * Geschwindigkeit und Dauer der Bewegung, implementiert Interface
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class Gear extends Command implements IGear {
	private int speed;
	private double duration;

	/**
	 * Konstruktor, �bergebene Geschwindigkeit und Dauer wird �bernommen
	 * 
	 * @param speed
	 *            Geschwindigkeit des Fahrzeugs
	 * @param duration
	 *            Dauer der Bewegung
	 */
	public Gear(int speed, double duration) {
		this.setName("Gear");
		this.speed = speed;
		this.duration = duration;
	}

	/**
	 * Standartkonstruktor, Dauer und Geschwindigkeit werden beide mit Null
	 * initialisiert
	 */
	public Gear() {
		this.setName("Gear");
		this.speed = 0;
		this.duration = 0;
	}

	/**
	 * @return Gibt Geschwindigkeit zur�ck
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @return Gibt Dauer der Bewegung zur�ck
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param speed
	 *            �bergebene Geschwindigkeit wird �bernommen
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @param duration
	 *            �bergebene Dauer wird �bernommen
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return Gibt Geschwindigkeit und Dauer als String zur�ck
	 */
	public String toString() {
		return "Gear:" + speed + ":" + duration;
	}
	
}
