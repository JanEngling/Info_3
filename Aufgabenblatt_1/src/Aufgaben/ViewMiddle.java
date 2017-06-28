package Aufgaben;

import java.awt.Color;

import javax.swing.JPanel;

public class ViewMiddle extends JPanel{
	private JPanel viewMiddle = new JPanel();

	public JPanel getPanel() {
		viewMiddle.setBackground(Color.red);
		viewMiddle.setSize(500, 500);
		return viewMiddle;
	}
	
	

}
