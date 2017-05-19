package Aufgaben;

public class CommandType {
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Konstruktor
	 * 
	 * @param name
	 */
	public CommandType(String name) {
		this.name = name;
	}

	public Command createInstance() { // holt namen über getString und erzeugt
		if (getName() == "Direction") {
			return new Direction();
		} else if (getName() == "Gear") {
			return new Gear();
		} else if (getName() == "Pause") {
			return new Pause();
		} else if (getName() == "Repetition") {
			return new Repetition();
		} else
			return null;
	}
}
