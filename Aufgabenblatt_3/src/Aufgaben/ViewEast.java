package Aufgaben;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * östliches Fenster mit Eingabe der änderbaren Command Parameter
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class ViewEast extends JPanel {
	private ControlModel c;
	private static ViewEast instance = null;
	private JTable table;
	private JScrollPane jcp;
	private String[] tmp = new String[] { "Paramteter", "Wert" };

	/**
	 * Konstruktor der rechten Tabelle
	 */
	public ViewEast() {
		this.setLayout(new BorderLayout());
		JButton save = new JButton("Save");
		this.add(save, BorderLayout.SOUTH);
		this.c = ControlModel.getInstance();

		String[][] str = new String[][] {};
		this.table = new JTable(str, tmp) {
			public boolean isCellEditable(int row, int col) {
				if (col == 0)
					return false;
				else
					return true;
			}

		};
		this.jcp = new JScrollPane(table);
		this.add(jcp);

		// KeyLsitener um Pfeiltastenbewegung zu registrieren
		ViewMiddle.getInstance().getTable().addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {
				ViewEast.getInstance().changed();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyTyped(KeyEvent e) {
			}

		});
		// MouseListener um markierte Reihe zu bekommen
		ViewMiddle.getInstance().getTable().addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent a) {
				ViewEast.getInstance().changed();
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
		// übergibt die geänderten Werte an das command Objekt der Liste
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command com = c.getControlProcess().get(c.getClm().getSelectedRow());
				if (com == null) {
					System.out.println("kein Commando gewählt");
					return;
				}
				
				switch (com.getName()) {
				case "Direction":
					try {
						Integer.parseInt(table.getValueAt(0, 1).toString());
					} catch (NumberFormatException es) {
						System.out.println("Nicht cheaten!");
						return;
					}
					if (Integer.valueOf((String) table.getValueAt(0, 1))<0){
						System.out.println("keine werte kleiner null");
						return;
					}
					((Direction) com).setDegree(Integer.valueOf((String) table.getValueAt(0, 1)));
					table.setRowHeight(25);
					ViewMiddle.getInstance().setVisible();
					break;
				case "Gear":
					try {
						Integer.parseInt(table.getValueAt(0, 1).toString());
						Double.parseDouble(table.getValueAt(1, 1).toString());
					} catch (NumberFormatException es) {
						System.out.println("Nicht cheaten!");
						return;
					}if (Integer.valueOf((String) table.getValueAt(0, 1))<0||Double.valueOf((String) table.getValueAt(1, 1))<0){
						System.out.println("keine werte kleiner null");
						return;
					}
					((Gear) com).setSpeed(Integer.valueOf((String) table.getValueAt(0, 1)));
					((Gear) com).setDuration(Double.valueOf((String) table.getValueAt(1, 1)));
					table.setRowHeight(25);
					ViewMiddle.getInstance().setVisible();
					break;
				case "Pause":
					try {
						Double.parseDouble(table.getValueAt(0, 1).toString());
					} catch (NumberFormatException es) {
						System.out.println("Nicht cheaten!");
						return;
					}
					if (Double.valueOf((String) table.getValueAt(0, 1))<0){
						System.out.println("keine werte kleiner null");
						return;
					}
					((Pause) com).setDuration(Double.valueOf((String) table.getValueAt(0, 1)));
					table.setRowHeight(25);
					ViewMiddle.getInstance().setVisible();
					break;
				case "Repetition":
					try {
						Integer.parseInt(table.getValueAt(0, 1).toString());
						Integer.parseInt(table.getValueAt(1, 1).toString());
					} catch (NumberFormatException es) {
						System.out.println("Nicht cheaten!");
						return;
					}
					if (Integer.valueOf((String) table.getValueAt(0, 1))<0||Integer.valueOf((String) table.getValueAt(1, 1))<0){
						System.out.println("keine werte kleiner null");
						return;
					}
					((Repetition) com).setNrSteps(Integer.valueOf((String) table.getValueAt(0, 1)));
					((Repetition) com).setNrRepetitions(Integer.valueOf((String) table.getValueAt(1, 1)));
					table.setRowHeight(25);
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
	 * 
	 * @return Gibt genau eine Instanz von ViewEast zurück.
	 */

	public static ViewEast getInstance() {
		if (instance == null) {
			instance = new ViewEast();
			return instance;
		} else
			return instance;
	}

	/**
	 * resetet das rechte Fenster
	 */
	public void setVisible() {
		ViewEast.getInstance().setVisible(false);
		ViewEast.getInstance().setVisible(true);
	}

	/**
	 * löscht die alte Tabelle
	 */
	public void reset() {
		this.remove(jcp);
	}

	/**
	 * zeichnet die rechte Tabelle neu
	 */
	public void updateTableEast() {
		table.updateUI();
	}

	/**
	 * Holt das markierte Objekt und zeigt es in der rechten Tabelle an
	 */
	public void changed() {
		Command com = c.getControlProcess().get(c.getClm().getSelectedRow());
		if (com == null) {
			ViewEast.getInstance().reset();

			String[][] str = new String[][] {};
			table = new JTable(str, tmp) {
				public boolean isCellEditable(int row, int col) {
					if (col == 0)
						return false;
					else
						return true;
				}

			};
			jcp = new JScrollPane(table);
			ViewEast.getInstance().add(jcp);
			table.setRowHeight(25);
			ViewEast.getInstance().setVisible();
		} else {
			switch (com.getName()) {
			case "Direction":
				ViewEast.getInstance().reset();
				String[][] str = new String[][] { { "Winkel:", String.valueOf(((Direction) com).getDegree()) } };
				table = new JTable(str, tmp) {
					public boolean isCellEditable(int row, int col) {
						if (col == 0)
							return false;
						else
							return true;
					}

				};
				jcp = new JScrollPane(table);
				ViewEast.getInstance().add(jcp);
				table.setRowHeight(25);
				ViewEast.getInstance().setVisible();
				System.out.println("bin ich hier");
				break;
			case "Gear":
				ViewEast.getInstance().reset();
				String[][] str1 = new String[][] { { "Geschwindigkeit:", String.valueOf(((Gear) com).getSpeed()) },
						{ "Dauer:", String.valueOf(((Gear) com).getDuration()) } };
				table = new JTable(str1, tmp) {
					public boolean isCellEditable(int row, int col) {
						if (col == 0)
							return false;
						else
							return true;
					}

				};
				jcp = new JScrollPane(table);
				ViewEast.getInstance().add(jcp);
				table.setRowHeight(25);
				ViewEast.getInstance().setVisible();
				break;
			case "Pause":
				ViewEast.getInstance().reset();
				String[][] str2 = new String[][] { { "Dauer:", String.valueOf(((Pause) com).getDuration()) } };
				table = new JTable(str2, tmp) {
					public boolean isCellEditable(int row, int col) {
						if (col == 0)
							return false;
						else
							return true;
					}

				};
				jcp = new JScrollPane(table);
				ViewEast.getInstance().add(jcp);
				table.setRowHeight(25);
				ViewEast.getInstance().setVisible();
				break;
			case "Repetition":
				ViewEast.getInstance().reset();
				String[][] str3 = new String[][] {
						{ "Anzahl Schritte", String.valueOf(((Repetition) com).getNrSteps()) },
						{ "Wiederholungen", String.valueOf(((Repetition) com).getNrRepetitions()) } };
				table = new JTable(str3, tmp) {
					public boolean isCellEditable(int row, int col) {
						if (col == 0)
							return false;
						else
							return true;
					}

				};
				jcp = new JScrollPane(table);
				ViewEast.getInstance().add(jcp);
				table.setRowHeight(25);
				ViewEast.getInstance().setVisible();
				break;
			default:
				System.out.println("Fehler");
				break;
			}
		}
	}
}
