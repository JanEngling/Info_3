package Aufgaben;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ViewMiddle extends JPanel{
	private ControlModel c;
	
	private JTable table;
	//private CommandListModel model;
	
	public ViewMiddle(){
		this.c = ControlModel.getInstance();
		
		this.setLayout( new BorderLayout());
        
        this.add(new MiddleButton(), BorderLayout.SOUTH);
        
        
        // Tabelle wird erstellte und das CommandListModel wird übergeben 
        // Danach an das Panel addden
        this.table = new JTable(c.getClm());
        this.add(new JScrollPane(table),BorderLayout.CENTER);
        
        //table.setDefaultRenderer(Object.class, new MyTableCellRenderer( ));
        
        table.setRowHeight(30);
        
        c.getClm().setTable(table);
        
        //c.getControlProcess().remove(0);
		//c.getClm().dataChanged();
       
        /*
        JButton b = new JButton("test");
        this.add(b, BorderLayout.NORTH);
        b.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent a){
        		System.out.println("Zeile: " + table.getSelectedRow());
        	}
        });
        */
	}
}
