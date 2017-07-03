package Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	private ControlModel cm;
	
	private static JMenuBar instance;
	
	private JMenu file = new JMenu("File");
	private JMenu port = new JMenu("Port");
	private JMenu info = new JMenu("Info");
	private JMenuItem load = new JMenuItem("Datei laden");
	private JMenuItem save = new JMenuItem("Datei speichern");
	private JMenuItem delete = new JMenuItem("Liste löschen");
	

	public MenuBar () {
		this.cm = ControlModel.getInstance();
		
		this.add(file);
		file.add(load);
		file.add(save);
		file.add(delete);
		
		this.add(port);
		
		this.add(info);
		

		// MenuItem TextDatei laden
		load.addActionListener(new ActionListener(){
	                public void actionPerformed(ActionEvent e){
	                    System.out.println("Load");
	                    ControlModel.getInstance().load(ControlDeveloper.myFile);
	                    ControlModel.getInstance().getClm().dataChanged();
	                }
	            }
	        );
		
		//  Menu Item Text Datei speichern
		save.addActionListener(new ActionListener(){
            		public void actionPerformed(ActionEvent e){
            			System.out.println("Saved");
            			ControlModel.getInstance().save(ControlDeveloper.myFile);
            			ControlModel.getInstance().getControlProcess().deleteList();
            			ControlModel.getInstance().getClm().dataChanged();
            		}
        		}
			);	
		
		// MenuItem Liste leeren
		delete.addActionListener(new ActionListener(){
    				public void actionPerformed(ActionEvent e){
    					System.out.println("Liste gelöscht");
    					ControlModel.getInstance().getControlProcess().deleteList();
	                    ControlModel.getInstance().getClm().dataChanged();
    				}
				}
			);
		
	}
	
	public static JMenuBar getInstance() {
		if (instance == null) {
			instance = new MenuBar();
			return instance;
		} else
			return instance;
	}

}
