package Aufgaben;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * erzeugt die Taster des mittleren Fensters
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class MiddleButton extends JPanel implements ActionListener {
	private ControlModel c;

	private JButton moveUp = new JButton("Up");
	private JButton moveDown = new JButton("Down");
	private JButton remove = new JButton("Remove");
	private JButton start = new JButton("Start");
	private JButton stop = new JButton("Stop");

	private GridBagConstraints pos = new GridBagConstraints();

	/**
	 * Konstruktor der mittleren Tasterleiste
	 */
	public MiddleButton() {
		this.c = ControlModel.getInstance();

		this.setLayout(new GridBagLayout());

		moveUp.addActionListener(this);
		moveDown.addActionListener(this);
		remove.addActionListener(this);
		start.addActionListener(this);
		stop.addActionListener(this);

		pos.anchor = GridBagConstraints.LAST_LINE_START;
		pos.weightx = 40.0;
		pos.gridx = 0;
		this.add(remove, pos);

		pos.anchor = GridBagConstraints.LAST_LINE_END;
		pos.weightx = 0.5;
		pos.gridx = 1;
		this.add(moveUp, pos);

		pos.anchor = GridBagConstraints.LAST_LINE_END;
		pos.weightx = 0.5;
		pos.gridx = 2;
		this.add(moveDown, pos);

		pos.anchor = GridBagConstraints.LAST_LINE_END;
		pos.weightx = 0.5;
		pos.gridx = 3;
		this.add(stop, pos);

		pos.anchor = GridBagConstraints.LAST_LINE_END;
		pos.weightx = 0.5;
		pos.gridx = 4;
		this.add(start, pos);
	}

	/**
	 * Überwachung der Tasten die je nach gedrücktem Taster andere Funktion
	 * ausführt
	 */
	public void actionPerformed(ActionEvent ae) {
		JButton b = (JButton) ae.getSource();
		if (b == this.moveUp) {
			if (c.getControlProcess().moveUp(c.getClm().getSelectedRow()))
				c.getClm().setSelectedRow(c.getClm().getSelectedRow() - 1);
		} else if (b == this.moveDown) {
			if (c.getControlProcess().moveDown(c.getClm().getSelectedRow()))
				c.getClm().setSelectedRow(c.getClm().getSelectedRow() + 1);
		} else if (b == this.remove) {
			c.getControlProcess().remove(c.getClm().getSelectedRow());
		} else if (b == this.start) {
			c.start();
			ViewSouth.getInstance().addText("Ausgabe läuft");
		} else if (b == this.stop) {
			c.stop();
			ViewSouth.getInstance().addText("Ausgabe gestoppt");
		}

		ViewEast.getInstance().updateTableEast();

	}

}
