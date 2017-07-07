package Aufgaben;

import java.awt.Font;
import java.io.File;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import hsrt.mec.controldeveloper.core.com.ComHandler;
import hsrt.mec.controldeveloper.core.com.ComPort;
import hsrt.mec.controldeveloper.core.com.ComPortHandler;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.SerialUSB;
import hsrt.mec.controldeveloper.io.TextFile;

/**
 * Controler der gesamten Funktionalit�t des Programms.
 * Beinhaltet auch die Main.
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class ControlDeveloper {
	private static String name = "Control Developer";
	public static File myFile = new File(System.getProperty("user.dir") + "\\meine_datei.txt");

	/**
	 * @return Gibt den Namen des ControlDevelopers zur�ck
	 */
	public String getName() {
		return name;
	}

	/**
	 * �bergebener Name wird Name des ControlDevelopers.
	 * 
	 * @param name Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Hauptprogramm zeigt Funktionalit�t der Unterklassen
	 * 
	 * @param s �berabeparameter an main
	 */
	public static void main(String[] s) {
		ControlModel c = ControlModel.getInstance();
		ComHandler ch = ComHandler.getInstance();
		setFontSize(25);
		MainWindow gui = new MainWindow();
	
		c.getControlProcess().add(new Direction(4));
		c.getControlProcess().add(new Pause(4));
		c.getControlProcess().add(new Gear(4,5));
		c.getControlProcess().add(new Repetition(3,5));
		
		//GUI
		gui.mainWindow();
		
	}
	  public static void setFontSize(int size){
		    Enumeration<Object> keys = UIManager.getDefaults().keys();
		    
		    while (keys.hasMoreElements()) {
		      Object key   = keys.nextElement();
		      Object value = UIManager.get(key);
		      
		      if (value!=null && value instanceof FontUIResource){
		        Font font = UIManager.getLookAndFeelDefaults().getFont(key);
		        font = new Font(font.getName(), font.getStyle(), size);
		        
		        UIManager.getLookAndFeelDefaults().put(key, font);
		      }
		    }
		  }
}
