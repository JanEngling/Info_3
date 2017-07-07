package Aufgaben;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Unteres Fenster
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class ViewSouth extends JPanel {

	private ControlModel c;
	private static JTextArea txtara = new JTextArea(10, 20);
	private JScrollPane scroll = new JScrollPane(txtara);
	private static ViewSouth instance = null;
	
	/**
	 * KOnstruktor des unteren Fensters
	 */
	public ViewSouth() {
		this.c = ControlModel.getInstance();
		this.setLayout(new BorderLayout());
		// this.txtara = new JTextArea(10, 20);
		
		this.add(txtara, BorderLayout.WEST);
		this.setBackground(Color.WHITE);
		
		this.scroll.getVerticalScrollBar().setValue(this.scroll.getVerticalScrollBar().getMaximum());
		
		
	}

	/**
	 * 
	 * @param Schreibt
	 *            den übergenene String in das Ausgabefenster
	 */
	public void addText(String ausgabe) {
		this.txtara.append(ausgabe + "\n");
		this.scroll.getVerticalScrollBar().setValue(this.scroll.getVerticalScrollBar().getMaximum());
	}

	/**
	 * @return Gibt genau eine Instanz von ViewSouth zurück.
	 */

	public static ViewSouth getInstance() {
		if (instance == null) {
			instance = new ViewSouth();
			return instance;
		} else
			return instance;
	}

	/**
	 * 
	 * @return Gibt genau ein Objekt des Textfeldes zurück
	 */
	public static JTextArea getText() {
		if (txtara == null) {
			txtara = new JTextArea(10, 20);
			return txtara;
		} else
			return txtara;
	}
}
