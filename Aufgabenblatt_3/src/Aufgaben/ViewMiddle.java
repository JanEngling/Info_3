package Aufgaben;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelListener;

public class ViewMiddle extends JPanel{
	private ControlModel c;
	
	private JTable table;
	//private CommandListModel model;
	
	public ViewMiddle(){
		this.c = ControlModel.getInstance();
		
		this.setLayout( new BorderLayout());

		//Border border = this.getBorder();
		//Border margin = new LineBorder(Color.gray,4);
		//this.setBorder(new CompoundBorder(border, margin));
	

        
        this.add(new MiddleButton(), BorderLayout.SOUTH);
        
        this.table = new JTable(c.getClm());
        this.add(new JScrollPane(table),BorderLayout.CENTER);
        
        c.getClm().setTable(table);
        
        //c.getControlProcess().remove(0);
		//c.getClm().dataChanged();
       
        JButton b = new JButton("test");
        this.add(b, BorderLayout.NORTH);
        b.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent a){
        		System.out.println("Zeile: " + table.getSelectedRow());
        	}
        });

	}

}
