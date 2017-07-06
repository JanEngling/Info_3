package Aufgaben;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewEast extends JPanel {
	private ControlModel c;
	private static ViewEast instance = null;
	private JTable table;
	private JTable table1;
	private JScrollPane jcp;

	public ViewEast() {
		this.setLayout(new BorderLayout());
		JButton save = new JButton("Save");
		this.add(save, BorderLayout.SOUTH);
		this.c = ControlModel.getInstance();

		String[][] str = new String[][] { { "", "" } };
		String[] tmp = new String[] {  };
		this.table1 = new JTable(str, tmp);
		this.jcp = new JScrollPane(table1);
		this.add(jcp);

		ViewMiddle.getInstance().getTable().addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent a) {
				Command com = c.getControlProcess().get(c.getClm().getSelectedRow());

				switch (com.getName()) {
				case "Direction": 
					ViewEast.getInstance().reset();
					String[][] str = new String[][] { { "Winkel:", String.valueOf(((Direction) com).getDegree()) } }; 
					String[] tmp = new String[] { "", "" };
					table = new JTable(str, tmp);
					jcp = new JScrollPane(table);
					ViewEast.getInstance().add(jcp);
					ViewEast.getInstance().setVisible();
					System.out.println("bin ich hier");
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
					break;
				case "Pause":
					ViewEast.getInstance().reset();
					String[][] str2 = new String[][] { { "Dauer:", String.valueOf(((Pause) com).getDuration()) } };
					String[] tmp2 = new String[] { "", "" };
					table = new JTable(str2, tmp2);
					jcp = new JScrollPane(table);
					ViewEast.getInstance().add(jcp);
					ViewEast.getInstance().setVisible();
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
					break;
				default:
					System.out.println("Fehler");
					break;
				}

			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}

		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command com = c.getControlProcess().get(c.getClm().getSelectedRow());

				switch (com.getName()) {
				case "Direction": 
					((Direction) com).setDegree(Integer.valueOf((String) table.getValueAt(0, 1)));
					ViewMiddle.getInstance().setVisible();
					break;
				case "Gear":
					((Gear) com).setSpeed(Integer.valueOf((String) table.getValueAt(0, 1)));
					((Gear) com).setDuration(Double.valueOf((String) table.getValueAt(1, 1)));
					ViewMiddle.getInstance().setVisible();
					break;
				case "Pause":
					((Pause) com).setDuration(Double.valueOf((String) table.getValueAt(0, 1)));
					ViewMiddle.getInstance().setVisible();
					break;
				case "Repetition":
					((Repetition) com).setNrSteps(Integer.valueOf((String) table.getValueAt(0, 1)));
					((Repetition) com).setNrRepetitions(Integer.valueOf((String) table.getValueAt(1, 1)));
					ViewMiddle.getInstance().setVisible();
					break;
				default:
					System.out.println("Fehler");
					break;
				}
			}
		});
	}

	/**
	 * Erzeugt ein Objekt von ConrolModel, wenn noch keins vorhanden ist.
	 * 
	 * @return Gibt genau eine Instanz von ControlModel zurück.
	 */

	public static ViewEast getInstance() {
		if (instance == null) {
			instance = new ViewEast();
			return instance;
		} else
			return instance;
	}

	public void setVisible() {
		ViewEast.getInstance().setVisible(false);
		ViewEast.getInstance().setVisible(true);
	}

	public void reset() {
		this.remove(jcp);
	}
	
	public void updateTableEast(){
		table.updateUI();
	}
}
