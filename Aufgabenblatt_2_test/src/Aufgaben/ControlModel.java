package Aufgaben;

/**
 * Controler der beiden Listen, implementiert IOType
 * 
 * @author Andreas Sautter u. Jan Engling
 * @version 1.0
 * @since JDK 1.8
 */
import java.io.File;
import java.util.Vector;
import hsrt.mec.controldeveloper.io.IOType;
import hsrt.mec.controldeveloper.io.TextFile;


//soll objecte von create instance in verkettete Liste einf�gen, remove...
public class ControlModel {
	private  static ControlModel instance = new ControlModel();
	private  static CommandType[] commandTypes = new CommandType[4];
	private  static CommandList controlProcess;

	// File file =new File("C:\Users\Jan\Desktop\Hochschule\SS17_17\Informatik
	// 3");
	//Vextor<String> v =new Vector<String>();
	//TextFile tf = new hsrt.mec.controldeveloper.io.TextFile(false);
	/**
	 * experiment
	 * @param f
	 * @param b
	 */
	/*
	public void TextFile(File f, boolean b){
		
	}
	*/
	/**
	 * Standartkonstruktor von ControlModel
	 */
	private ControlModel() {
	}
	/**
	 * braucht man um zu definieren was der input is 
	 * @param f
	 * @param b
	 */
	public void TextFile (File f, boolean b){
		
	}
	/**
	 * gibt instance zur�ck ???
	 * 
	 * @return Gibt ControlModel zur�ck
	 */
	public ControlModel getInstance() {
		
		return instance;
	}

	/**
	 * Bef�llt erste Liste mit allen CommandType Objekten (4)
	 */
	public void createCommandTypes() {	//Andreas

	}

	/**
	 * L�d Strings aus einer vorher erzeugten Datei
	 * 
	 * @return true wenn erfolgreich, false wenn erfolglos
	 */
	public boolean load(TextFile myFile) {
		Vector<String> v = new Vector<String>();
		myFile.read(v);
		//beabreitung vector v[0] = erste zeile
		String[] parts = v.get(0).split(":");
		Double a = Double.valueOf(parts[0]);
		//v.get(i).split(9
		myFile.close();
		return true;
	}

	/**
	 * Speichert Liste als Strings in Datei
	 * 
	 * @return true wenn erfolgreich, false wenn erfolglos
	 */
	public boolean save(File myFile) {
		TextFile saveFile = new TextFile(myFile, false);
		Vector<String> v = new Vector<String>();
		v= controlProcess.readList();
		saveFile.write(v);
		saveFile.close();
		return true;
	}

	/**
	 * ???
	 * 
	 * @param c
	 *            Bekommt Command �bergeben
	 */
	public void commandPerformed(Command c) {

	}

	/**
	 * ??
	 * 
	 * @return
	 */
	public CommandList getControlProcess() {
		return null;
	}
	

	
	
}
