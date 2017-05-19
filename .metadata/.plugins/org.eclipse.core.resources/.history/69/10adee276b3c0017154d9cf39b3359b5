package Aufgaben;

import hsrt.mec.controldeveloper.core.com.command.IGear;

/**
 * Geschwindigkeit und Dauer der Bewegung, implementiert Interface
 * 
 * @author Jan
 * @version 1.0
 */
public class Gear extends Command implements IGear {
	private int speed;
	private double duration;

	/**
	 * Konstruktor, übergebene geschwindigkeit und Dauer wird übernommen
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
	 * Standartkonstruktor, Dauer und geschwindigkeit werden beide mit Null
	 * initialisiert
	 */
	public Gear() {
		this.setName("Gear");
		this.speed = 0;
		this.duration = 0;
	}

	/**
	 * @return gibt Geschwindigkeit zurück
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @return gibt Dauer der Bewegung zurück
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param speed
	 *            Übergebene Geschwindigkeit wird übernommen
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @param duration
	 *            Übergebene dauer wird übernommen
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return gibt Geschwindigkeit und Dauer als String zurück
	 */
	public String toString() {
		return "Gear [speed=" + speed + ", duration=" + duration + "]";
	}

}
