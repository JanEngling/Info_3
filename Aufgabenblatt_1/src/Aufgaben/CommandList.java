package Aufgaben;

/**
 * Fügt Methoden zum Ändern der verketteten Liste inklusive root Element hinzu
 * 
 * 
 * @author Jan
 * @version 1.0
 */
public class CommandList {
	private Element root;
	private Element last;

	/**
	 * Fügt Element nach root Element ein
	 * 
	 * @param c
	 *            Command welches in die Liste eingefügt werden soll
	 * @return true wenn erfolgreich eingefügt wurde
	 */
	public boolean add(Command c) {
		Element tmp = new Element(c);

		if (root == null) {
			tmp.next = null;
			tmp.prev = root;
			root = tmp;
			last = tmp;
		} else {
			last = tmp;
			tmp.next = root;
			root.prev = tmp;
			root = tmp;
		}
		return true;
	}

	/**
	 * Sucht nach angegebenem Element in der Liste und falls vorhanden, wird es
	 * gelöscht
	 * 
	 * @param c
	 *            zu entfernendes Element
	 * @return falls Command enthalten und entfernt true ansonsten false
	 */
	public boolean remove(int pos) { // entfernt command welches übergeben
		Element tmp = last;
		int counter = 1;
		if (root == null) { // Liste leer
			System.out.println("Liste ist leer!");
			return false;
		}
		for (int i = 0; tmp.prev != null; i++) {
			tmp = tmp.prev;
			counter = (i + 1);
		}
		tmp = last;
		if (pos <= 0) {
			System.out.println("Kleiner gleich Null!");
			return false;
		} else if (root.next == null) { // ein Element
			root = null;
			last = null;
			return true;
		} else if (root.next == last && pos == 1) { // 2er Liste erstes Element
			last = root;
			root.next = null;
			return true;
		} else if (root.next == last && pos == 2) { // 2er Liste zweites Element
			root = last;
			last.prev = null;
			return true;
		} else if (pos == 1) {
			System.out.println("hier");	//hier fehler
			last = last.prev;
			last.next = null;
			return true;
		} else if (pos == counter) { // unterstes Element
			root = root.next;
			root.prev = null;
			return true;
		} else {
			for (int i = 1; i < pos; i++) {// entspricht beliebigem Element
				tmp = tmp.prev;
			}
			tmp.prev.next = tmp.next;
			tmp.next.prev = tmp.prev;
			return true;
		}
	}

	/**
	 * Gibt Command an angegebener Position zurück
	 * 
	 * @param pos
	 *            Position des Elements welches ausgegeben werden soll
	 * @return Falls Liste leer false sonst Command
	 */
	public Command get(int pos) { // ermittelt command aus liste
		Element tmp = root;

		if (root == null) {
			System.out.println("Die Liste ist leer!");
			return null;
		} else {
			for (int i = 0; tmp.next != null; i++) { // springt an Ende der
														// Liste
				tmp = tmp.next;
			}
			for (int i = 0; i < pos; i++) {
				if (tmp.prev == null) // letztes element vor root
					return null;
				else
					tmp = tmp.prev;
			}
		}
		return tmp.getElement();
	}

	/**
	 * Command an angegebener Position wird um eins nach oben verschoben
	 * 
	 * @param pos
	 *            Positio des zu verschiebenen Elements
	 * @return bei nur einem Element in der Liste oder erster Position false,
	 *         bei erfolgreichem tausch true
	 */
	public boolean moveUp(int pos) { // verschiebt um eins nach vorne erweitern
		Element tmp = root;
		pos = pos - 1;
		int counter = 0;

		for (int i = 0; tmp.next != null; i++) { // springt an Ende
			tmp = tmp.next;
			counter = (i + 1);
		}

		if (counter == 0 || pos == 0) {
			System.out.println("Liste besteht nur aus einem Element!");
			return false;
		} else if (counter == pos && counter > 1) { // entspricht
			root.prev.next = root.next;
			root.next.prev = root.prev;
			root.next = root.prev;
			root.prev.prev = root;
			root.prev = null;
			return true;
		}
		for (int i = 0; i < pos; i++) { // springt an richtige Stelle
			tmp = tmp.prev;
		}
		if (pos == 1 && counter > 1) { // Liste groß genug zweites Element
			tmp.prev.next = tmp.next;
			tmp.next.prev = tmp.prev;
			tmp.next.next = tmp;
			tmp.prev = tmp.next;
			tmp.next = null;
			return true;
		} else if (pos == 1) {// Liste zu klein zweites Element
			root.next.next = root;
			root.next.prev = null;
			root.prev = root.next;
			root.next = null;
			root = root.prev;
			return true;
		} else { // Liste passend
			tmp.next.prev = tmp.prev;
			tmp.prev.next = tmp.next;
			tmp.prev = tmp.next;
			tmp.next = tmp.next.next;
			tmp.next.prev = tmp;
		}
		return true;
	}

	/**
	 * Command an angegebener Position wird um eins nach unten verschoben
	 * 
	 * @param pos
	 *            Position des zu verschiebenden Elements
	 * @return bei nur einem Element in der Liste oder letzter Position false,
	 *         bei erfolgreichem Tausch true
	 */
	public boolean moveDown(int pos) { // verschiebt um eins nach hinten
		Element tmp = root;
		pos = pos - 1;
		int counter = 0;

		for (int i = 0; tmp.next != null; i++) { // springt an Ende
			tmp = tmp.next;
			counter = (i + 1);
		}
		if (counter == 0 && tmp.prev == null) {
			System.out.println(counter);
			System.out.println("Liste besteht nur aus einem Element (move down)!");
			return false;
		} else if (pos == 0 && counter > 1) { // erstes Element Liste größer
			moveUp(2); // gleich 3
			return true;
		} else if (pos == 0) { // erstes Element und kleiner 3
			tmp.next = root;
			root.prev = tmp;
			root.next = null;
			tmp.prev = null;
			root = tmp;
			return true;
		} else if (pos == 1 && counter > 1) { // zweites Element
			moveUp(3);
			return true;
		} else if (pos == 1) { // Liste zu klein
			System.out.println("Letztes Element kann nicht verschoben werden!");
			return false;
		} else if (counter == pos) { // letztes Element
			System.out.println("Letztes Element kann nicht verschoben werden!");
			return false;
		} else {
			moveUp(pos + 2); // mittelelement
			return true;
		}
	}
}
