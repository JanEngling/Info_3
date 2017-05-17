package Aufgaben;

import hsrt.mec.controldeveloper.core.com.command.IPause;

/**
 * Handled Funktionalitäten der Pause des Fahrzeugs und implementiert Interface
 *
 * @author Jan
 * @version 1.0
 */
public class Pause extends Command implements IPause {
	private double duration;

	/**
	 * Konstruktor Übergebene pause wird übernommen
	 * 
	 * @param duration
	 *            Dauer der pause
	 */
	public Pause(double duration) {
		this.setName("Pause");
		this.duration = duration;
	}

	/**
	 * Standartkonstruktor, Pause wird auf 1000 takte gesetzt
	 */
	public Pause() {
		this.setName("Pause");
		this.duration = 1000;
	}

	/**
	 * @param duration
	 *            Dauer der Pause
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return gibt Dauer der Pause zurück
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @return Gibt Dauer der Pause als String zurück
	 */
	public String toString() {
		return "Pause [duration=" + duration + "]";
	}

}
