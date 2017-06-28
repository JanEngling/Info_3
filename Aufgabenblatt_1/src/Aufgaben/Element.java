package Aufgaben;

/**
 * Element ist ein Element einer Liste. 
 * Hier sind die Methoden implementiert um auf die Variablen zu zugreifen.  
 * 
 * @author Andreas Sautter u. Jan Engling
 * @version 1.0
 * @since JDK 1.8
 * 
 */
public class Element {
	private Element next = null;
	private Element prev = null;
	private Command element;

	/**
	 * Wei�t dem Element ein Objekt von Typ Command zu.
	 * 
	 * @param command Objekt von Typ Command
	 */
	public Element(Command command) {
		this.element = command;
	}

	/**
	 * @return Gibt das Element bzw. Inhalt von Typ Command zur�ck.
	 */
	public Command getElement() {
		return element;
	}

	/**
	 * @param element
	 *            Setzt �bergebenes Element
	 */
	public void setElement(Command element) {
		this.element = element;
	}

	/**
	 * @return Liefert die Referenz f�r das n�chste ListenElement.
	 */
	public Element getNext() {
		return next;
	}

	/**
	 * Setzt �bergebenes Element als next
	 * 
	 * @param next
	 */
	public void setNext(Element next) {
		this.next = next;
	}

	/**
	 * @return Liefert die Reference vom vorderen ListenElement.
	 */
	public Element getPrev() {
		return prev;
	}

	/**
	 * Setzt �bergebenes Element als next
	 * 
	 * @param prev
	 */
	public void setPrev(Element prev) {
		this.prev = prev;
	}
}
