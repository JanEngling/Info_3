package Aufgaben;

/**
 * Beschreibt alle m�glichen Commands in einer Liste
 * 
 * @author Andreas Sautter u. Jan Engling
 * @version 1.0
 * @since JDK 1.8
 */
public class CommandType {	//erstell aus geholtem namen eine instance des objects er classe command
	private String name;

	/**
	 * @return Gibt Namen des CommandTypes zur�ck
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            �bernimmt den �bergebenen String als Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Konstruktor: �bergebener String wird als Name �bernommen
	 * 
	 * @param �bergebener
	 *            String wird als Name �bernommen
	 */
	public CommandType(String name) {
		this.name = name;
	}

	/**
	 * Erstellt die Instanc eines Commands gem�� des Aufgerufenen Namen
	 * 
	 * @return Gibt Element Command gem�� des geholten Namen zur�ck, null wenn
	 *         String verschieden der 4 Vorgegebenen
	 */
	public Command createInstance() { // holt namen �ber getString und erzeugt
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
