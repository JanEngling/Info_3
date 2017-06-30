package Aufgaben;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class ViewMiddle extends JPanel{
	private ControlModel c;
	
	private JTable table;
	private CommandListModel model;
	
	public ViewMiddle(ControlModel c){
		this.c = c;
		
		setLayout( new BorderLayout());
		
		//JScrollPane sP = new JScrollPane();
		//JLabel label = new JLabel ("No.","Commands", JLabel.CENTER);

		//JViewport header = new JViewport();
		//header.setView(label);
		//sP.setColumnHeaderView(header);
		
		this.model = new CommandListModel(c);
		this.table = new JTable((TableModel) this.model);
		
		this.add(new JScrollPane(table), BorderLayout.CENTER);
		

		
		//setBackground(Color.red);
	}
}
