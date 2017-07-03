package Aufgaben;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MiddleButton extends JPanel implements ActionListener{
	private ControlModel c;
	
	private JButton moveUp = new JButton("Up");
	private JButton moveDown = new JButton("Down");
	private JButton remove = new JButton("Remove");
	private JButton start = new JButton("Start");
	private JButton stop = new JButton("Stop");
	
	private GridBagConstraints pos = new GridBagConstraints();
	
	public MiddleButton(){
		this.c = ControlModel.getInstance();
		
		this.setLayout(new GridBagLayout());
		
		moveUp.addActionListener(this);
		moveDown.addActionListener(this);
		remove.addActionListener(this);
		
		/*
		remove.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent ae){
				c.getControlProcess().remove(0);
	            System.out.println("Schleife Action Listener");
	            c.getClm().fireTableDataChanged();
	            System.out.println("Größe2: " + ControlModel.getInstance().getControlProcessGroesse());
			}
		});
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
	
	 public void actionPerformed (ActionEvent ae){
          
          JButton b = (JButton)ae.getSource();
		 
	        if(b == this.moveUp){
	            if (c.getControlProcess().moveUp(c.getClm().getSelectedRow()))
	            	c.getClm().setSelectedRow(c.getClm().getSelectedRow()-1);
	        }
	        else if(b == this.moveDown){
	            if	(c.getControlProcess().moveDown(c.getClm().getSelectedRow()))
	            	 c.getClm().setSelectedRow(c.getClm().getSelectedRow()+1);
	        }
	        else if(b == this.remove){
	            c.getControlProcess().remove(c.getClm().getSelectedRow());
	        }  
	    }
}
