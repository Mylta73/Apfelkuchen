package GUI.Two;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Yury Kalinin Start of window with 1194, 550 size
 *
 */
public class Run {
	private static Vector nameOfValue;
	public static ArrayList Si;
	private static int numberOfComp=0;

	private static int numExp;

	public static void main(String args[]) {

		numExp = 0;
		nameOfValue = new Vector();

System.out.println(nameOfValue.size());

		Window window = new Window();
	}

	public static void remove() {
		System.out.println(numberOfComp+"run comp");
		nameOfValue.remove(numberOfComp-1);
		
		numberOfComp--;
		

	}

	public static int getNumExp() {
		return numExp;
	}

	public static void changeNumExp() {
		numExp++;
	}

	public static void changeNumExp(int value) {
		numExp = value;
	}


	
	public static void changeNumComp(){
		System.out.println(numberOfComp);
		numberOfComp++;
	}
	
	public static int getNumComp(){
		return nameOfValue.size();
	}
	
	public static Vector getNameOfValue(){
		return nameOfValue;
		
	}

	public static void AddNameValue(String nameValue) {
		System.out.println(nameValue + " Run");
		nameOfValue.add(nameValue);
		for (int i = 1; i < nameOfValue.size(); i++) {
			System.out.println(nameOfValue.get(i).toString());
		}

	}


	public static int getnameOfValueSize() {
		return nameOfValue.size();
	}
}