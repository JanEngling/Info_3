package Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import hsrt.mec.controldeveloper.core.com.ComPort;
import hsrt.mec.controldeveloper.core.com.ComPortHandler;
import hsrt.mec.controldeveloper.io.SerialUSB;

public class MenuBar extends JMenuBar{
	private ControlModel cm;
	
	private static JMenuBar instance;
	
	private JMenu file = new JMenu("File");
	private JMenu port = new JMenu("Port");
	private JMenu info = new JMenu("Info");
	private JMenuItem load = new JMenuItem("Datei laden");
	private JMenuItem save = new JMenuItem("Datei speichern");
	private JMenuItem delete = new JMenuItem("Liste l�schen");
	ComPortHandler cph = new ComPortHandler();
	ComPort[] cp = new ComPort[10];
	//neu Jan
			/*
			
			
				//setzt usb port mit bestimmter id
			Vector<ICommand> commandlist = new Vector<ICommand>();
			commandlist.add(null);
			TextFile textFile = new TextFile(myFile, false);
			ch.start(commandlist, textFile);	//alternativ statt textFile usb
			ch.stop();
			*/
			//Ende neu Jan

	public MenuBar () {
		this.cm = ControlModel.getInstance();
		
		this.add(file);
		file.add(load);
		file.add(save);
		file.add(delete);
		
		this.add(port);
		cp = ComPortHandler.getPorts();//Liefert alle verf�gbaren ports zur�ck
		//System.out.println(cp[0].getName());
		for (int i =0; i < cp.length; i++){
			port.add(cp[i].getName());
			System.out.println("hier auch");
		}
		System.out.println("hier war ich");
		System.out.println(cp.length);
		this.add(info);
		
		//cp[1].getId();	//liefert ID des ersten USB ports
		//SerialUSB usb = new SerialUSB(cp[1]);
		
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
    					System.out.println("Liste gel�scht");
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
