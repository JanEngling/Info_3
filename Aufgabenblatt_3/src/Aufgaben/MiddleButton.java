package Aufgaben;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MiddleButton extends JPanel implements ActionListener {
	private ControlModel c;

	private JButton moveUp = new JButton("Up");
	private JButton moveDown = new JButton("Down");
	private JButton remove = new JButton("Remove");
	private JButton start = new JButton("Start");
	private JButton stop = new JButton("Stop");

	private GridBagConstraints pos = new GridBagConstraints();

	public MiddleButton() {
		this.c = ControlModel.getInstance();

		this.setLayout(new GridBagLayout());

		moveUp.addActionListener(this);
		moveDown.addActionListener(this);
		remove.addActionListener(this);
		start.addActionListener(this);
		stop.addActionListener(this);

		/*
		 * remove.addActionListener(new ActionListener(){ public void
		 * actionPerformed (ActionEvent ae){ c.getControlProcess().remove(0);
		 * System.out.println("Schleife Action Listener");
		 * c.getClm().fireTableDataChanged(); System.out.println("Größe2: " +
		 * ControlModel.getInstance().getControlProcessGroesse()); } });
		 */

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

	public void actionPerformed(ActionEvent ae) {
		JTable table = new JTable();
		JButton b = (JButton) ae.getSource();
		//JScrollPane jcp = ViewEast.getInstance().getTableEast();
		if (b == this.moveUp) {
			if (c.getControlProcess().moveUp(c.getClm().getSelectedRow()))
				c.getClm().setSelectedRow(c.getClm().getSelectedRow() - 1);
		} else if (b == this.moveDown) {
			if (c.getControlProcess().moveDown(c.getClm().getSelectedRow()))
				c.getClm().setSelectedRow(c.getClm().getSelectedRow() + 1);
		} else if (b == this.remove) {
			c.getControlProcess().remove(c.getClm().getSelectedRow());
		} else if(b == this.start){
			c.start();
			ViewSouth.getInstance().addText("Ausgabe läuft");
		} else if (b == this.stop){
			c.stop();
			ViewSouth.getInstance().addText("Ausgabe gestoppt");
		}
		
		ViewEast.getInstance().updateTableEast();
		/*
			Command com = c.getControlProcess().get(c.getClm().getSelectedRow());
			System.out.println("bin ich hier");
			//ViewEast.getInstance().getTableEast();
			switch (com.getName()) {
			case "Direction":
				ViewEast.getInstance().reset();
				System.out.println("bla");
				String[][] str = new String[][] { { "Winkel:", String.valueOf(((Direction) com).getDegree()) } };
				String[] tmp = new String[] { "", "" };
				table = new JTable(str, tmp);
				//ViewEast.getInstance().getTableEast();
				ViewEast.getInstance().add(jcp);
				ViewEast.getInstance().setVisible();
				table.updateUI();
				//System.out.println("bin ich hier");
				break;
			case "Gear":
				ViewEast.getInstance().reset();
				String[][] str1 = new String[][] { { "Geschwindigkeit:", String.valueOf(((Gear) com).getSpeed()) },
						{ "Dauer:", String.valueOf(((Gear) com).getDuration()) } };
				String[] tmp1 = new String[] { "", "" };
				table = new JTable(str1, tmp1);
				jcp = new JScrollPane(table);
				ViewEast.getInstance().add(jcp);
				ViewEast.getInstance().setVisible();
				table.updateUI();
				break;
			case "Pause":
				ViewEast.getInstance().reset();
				String[][] str2 = new String[][] { { "Dauer:", String.valueOf(((Pause) com).getDuration()) } };
				String[] tmp2 = new String[] { "", "" };
				table = new JTable(str2, tmp2);
				jcp = new JScrollPane(table);
				ViewEast.getInstance().add(jcp);
				ViewEast.getInstance().setVisible();
				table.updateUI();
				break;
			case "Repetition":
				ViewEast.getInstance().reset();
				String[][] str3 = new String[][] {
						{ "Anzahl Schritte", String.valueOf(((Repetition) com).getNrSteps()) },
						{ "Wiederholungen", String.valueOf(((Repetition) com).getNrRepetitions()) } };
				String[] tmp3 = new String[] { "", "" };
				table = new JTable(str3, tmp3);
				jcp = new JScrollPane(table);
				ViewEast.getInstance().add(jcp);
				ViewEast.getInstance().setVisible();
				table.updateUI();
				break;
			default:
				System.out.println("Fehler");
				break;
			}
			*/

		}
		
	
}
