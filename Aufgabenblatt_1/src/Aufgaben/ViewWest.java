package Aufgaben;

import java.awt.Color;

import javax.swing.JPanel;

public class ViewWest extends JPanel{
	
	private ControlModel c;
	
	public ViewWest() {
		this.c = ControlModel.getInstance();
		
		setBackground(Color.green);
	}
	

}
