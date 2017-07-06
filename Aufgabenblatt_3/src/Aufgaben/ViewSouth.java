package Aufgaben;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewSouth extends JPanel {

	private ControlModel c;
	private static JTextArea txtara = new JTextArea(10,20);
	private JScrollPane scroll = new JScrollPane(txtara);
	private static ViewSouth instance = null;

	public ViewSouth() {
		this.c = ControlModel.getInstance();

		//this.txtara = new JTextArea(10, 20);
		this.add(txtara);
		this.setBackground(Color.WHITE);

	}
	
	public void addText(String ausgabe){
		this.txtara.append(ausgabe + "\n");
		this.scroll.getVerticalScrollBar().setValue(this.scroll.getVerticalScrollBar().getMaximum());
	}
	/**
	 * Erzeugt ein Objekt von ConrolModel, wenn noch keins vorhanden ist.
	 * 
	 * @return Gibt genau eine Instanz von ControlModel zur�ck.
	 */

	public static ViewSouth getInstance() {
		if (instance == null) {
			instance = new ViewSouth();
			return instance;
		} else
			return instance;
	}
	public static JTextArea getText() {
		if (txtara == null) {
			txtara = new JTextArea(10, 20);
			return txtara;
		} else
			return txtara;
	}
}
