package Aufgaben;

import java.io.File;
import java.util.Vector;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;

/**
 * Controler der gesamten Funktionalität des Programms
 * 
 * @author Andreas & Jan
 * @version 1.0
 */
public class ControlDeveloper {
	private static String name = "Control Developer";
	private static CommandList commandList = new CommandList();
	private static Command[] commands = new Command[10];
	private static ControlDeveloper cd1 = new ControlDeveloper();
	private static ControlModel cm;
	//private static File myFile =new File(System.getProperty("user.dir")+"\\meine_datei.txt");
	/**
	 * @return Gibt den Namen des ControlDevelopers zurück
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Übergebener Name wird Name des ControlDevelopers
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Hauptprogramm zeigt Funktionalität der Unterklassen
	 * 
	 * @param s
	 *            Überabeparameter an main
	 */
	public static void main(String[] s) {
		//Test
		//ControlModel cm=new ControlModel();
		//Vector<String> v=new Vector();
		//String test =new String ("Hallo");
		//v.add(test);
		//File f=new File("zeug");
		//cm.getInstance();
		//cm1.TextFile(f, true);
		//IOType textFile =new TextFile(cd1.myfile ,false);
		//cm.save(textFile);
		File myFile =new File(System.getProperty("user.dir")+"\\meine_datei.txt");
		ControlModel c= new ControlModel();
		c.load(myFile);
		c.getControlProcess().add(new Direction(4));
		c.getControlProcess().add(new Pause(4));
		for (int i = 0; c.getControlProcess().get(i) != null;i++){
			System.out.println(c.getControlProcess().get(i).toString());
		}
			
		//System.out.println(c.getControlProcess().get(0).toString());
		c.save(myFile);
		//CommandList cList = new CommandList();
		//cList.add(new Direction(5));
		//cm.save(myFile);
		
	}

	/**
	 * Fügt hardcoded Beispiel Commands in Array ein
	 * 
	 * @param commands
	 *            Array aus Beispiel Commands
	 */
	public static void testCommands(Command[] commands) {
		commands[0] = new Direction();
		commands[1] = new Gear();
		commands[2] = new Repetition();
		commands[3] = new Pause();
	}

	/**
	 * Gibt alle in Array enthaltenne Commands aus
	 * 
	 * @param commands
	 *            Array aus Beispiel Commands
	 */
	public static void printCommands(Command[] commands) {
		for (int i = 0; commands[i] != null; i++) {
			System.out.println(commands[i].toString());
		}
	}
}
