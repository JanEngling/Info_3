package Aufgaben;

/**
 * Controler der gesamten Funktionalit�t des Programms
 * 
 * @author Jan
 * @version 1.0
 */
public class ControlDeveloper {
	private static String name = "Control Developer";
	private static CommandList commandList = new CommandList();
	private static Command[] commands = new Command[10];

	/**
	 * @return gibt den Namen des ControlDevelopers zur�ck
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            �bergebener name wird Name des ControlDevelopers
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Hauptprogramm zeigt Funktionalit�t der Unterclassen
	 * 
	 * @param s
	 *            �berabeparameter an main
	 */
	public static void main(String[] s) {
		ControlDeveloper cd1 = new ControlDeveloper();

		System.out.println("Aufgabe 1:");
		System.out.println(cd1.getName());
		System.out.println(name);

		System.out.println("Aufgabe 3:");
		testCommands(commands);
		printCommands(commands);

		System.out.println("Aufgabe 4:");
		commandList.add(commands[0]);
		commandList.add(commands[1]);
		commandList.add(commands[2]);
		//commandList.add(commands[3]);

		 commandList.remove(1);
		// commandList.moveUp(3);
		//commandList.moveDown(3);

		for (int i = 0; commandList.get(i) != null; i++) {
			System.out.println(commandList.get(i).toString());
		}

	}

	/**
	 * F�gt hardcoded Beispiel Commands in die Liste ein
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
	 * gibt alle in Array enthaltenne Commands aus
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
