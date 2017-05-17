package Aufgaben;

/**
 * Listenelement
 * 
 * @author Jan
 * @version 1.0
 */
public class Element {
	/**
	 * Referenz auf nächstes Element
	 */
	public Element next = null;
	/**
	 * Referenz auf vorheriges Element
	 */
	public Element prev = null;
	private Command element;

	/**
	 * @return Gibt Command des Elements zurück
	 */
	public Command getElement() {
		return element;
	}

	/**
	 * @param command
	 *            Konstruktor, übergebener Command wird zu neuem Element
	 */
	public Element(Command command) { // Constructor
		this.element = command;
	}
}
