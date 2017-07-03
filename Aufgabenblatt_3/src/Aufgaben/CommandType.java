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
	 * 
	 * @return Gibt Namen des CommandTypes zurück.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Konstruktor: Übergebener String wird als Name übernommen.
	 * 
	 * @param name Name 
	 */
	public CommandType(String name) {
		this.name = name;
	}

	/**
	 * Erstellt anhand des Namens Objekte und gibt diese zurück.  
	 * 
	 * @return Liefert ein Objekt von Typ Command zurück.
	 * 		   Null wenn keiner der 4 vorgegebenen Nameen passt.
	 */
	public Command createInstance() { // holt namen über getString und erzeugt
		if (name.equals("Direction")) {							// statt getName() kann auch dirket name verwendet werden
			return new Direction();
		} else if (name.equals("Gear")) {
			return new Gear();
		} else if (name.equals("Pause")) {
			return new Pause();
		} else if (name.equals("Repetition")) {
			return new Repetition();
		} else
			return null;
	}
}
