package Aufgaben;

/**
 * Beschreibt alle m�glichen Commands in einer Liste.
 * CommandType Objekte enthalten die Namen der m�glichen Command-Klassen.
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
	 * @return Gibt Namen des CommandTypes zur�ck.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Konstruktor: �bergebener String wird als Name �bernommen.
	 * 
	 * @param name Name 
	 */
	public CommandType(String name) {
		this.name = name;
	}

	/**
	 * Erstellt anhand des Namens Objekte und gibt diese zur�ck.  
	 * 
	 * @return Liefert ein Objekt von Typ Command zur�ck.
	 * 		   Null wenn keiner der 4 vorgegebenen Nameen passt.
	 */
	public Command createInstance() { // holt namen �ber getString und erzeugt
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
