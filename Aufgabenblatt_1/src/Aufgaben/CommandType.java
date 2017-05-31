package Aufgaben;

/**
 * Beschreibt alle möglichen Commands in einer Liste.
 * CommandType Objekte enthalten die Namen der möglichen Command-Klassen.
 * 
 * @author Andreas Sautter u. Jan Engling
 * @version 1.0
 * @since JDK 1.8
 */
public class CommandType {										//erstell aus geholtem namen eine Instance des Objects der class command
	private String name;

	/**
	 * Getter-Methode
	 * @return Gibt Namen des CommandTypes zurück.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Übernimmt den übergebenen String als Name.
	 * @param name Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Konstruktor: Übergebener String wird als Name übernommen.
	 * @param name Name 
	 */
	public CommandType(String name) {
		this.name = name;
	}

	/**
	 * Erstellt anhand des Namens Objekte und gibt diese zurück.  
	 * @return Liefert ein Objekt von Typ Command zurück.
	 * 		   Null wenn keiner der 4 vorgegebenen Nameen passt.
	 */
	public Command createInstance() { 							// holt namen über getString und erzeugt
		if (getName() == "Direction") {							// statt getName() kann auch dirket name verwendet werden
			Command c = new Direction();						// wenn die Objekte erzeugt werden bekommt das Command den entsprechende Nammen
			c.setName("Direction");
			return c;
		} else if (getName() == "Gear") {
			Command c = new Gear();
			c.setName("Gear");
			return c;
		} else if (getName() == "Pause") {
			Command c = new Pause();
			c.setName("Pause");
			return c;
		} else if (getName() == "Repetition") {
			Command c = new Repetition();
			c.setName("Repetition");
			return c;
		} else
			return null;
	}
}
