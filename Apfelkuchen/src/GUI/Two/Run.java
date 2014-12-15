package GUI.Two;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main used to Start Window1 + ReadCSV
 * @author Yuri Kalinin, Dominik Hofmann
 * @version 2.0.10
 */
public class Run {
	private static String[] role = new String[] { "controlled", "constant", "scale-up", "dependent" };
	private static ArrayList<String> dateFromWindowOne = new ArrayList<String>();
	protected static int rows = 0;
	protected static String csvName = "spezifikation.csv";
	protected static final int DEFAULT_WIDTH = 1100; //1194
	protected static final int DEFAULT_HEIGHT = 500; //550
	protected static final int CURRENT_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	protected static final int CURRENT_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	protected static final int HIGHRES_FONT_SIZE = 18;
	protected static final int DEFAULT_FONT_SIZE = 16;
	protected static final int LOWRES_FONT_SIZE = 15;
	protected static int currentFontSize = DEFAULT_FONT_SIZE;
	protected static final int DEFAULT_GRID_SIZE_HIGH = 80;
	protected static final int DEFAULT_GRID_SIZE_LOW = 40;
	protected static int currentGridSizeHigh = DEFAULT_GRID_SIZE_HIGH;
	protected static int currentGridSizeLow = DEFAULT_GRID_SIZE_LOW;
	public static List<RawUnits> unitsArray = new ArrayList<RawUnits>();
	
	public static void main(String args[]) {
		//FIXME FONT size will not get changed yet
		Run.currentGridSizeHigh *= (double)Run.CURRENT_WIDTH / (double)1366;
		Run.currentGridSizeLow *= (double)Run.CURRENT_WIDTH / (double)1366;
		//Run.currentGridSizeLow += 10;
		
		new Window();
		new Thread(new ReadCSVRunnable()).start();
	}
	
	public static void addRow() {
		rows++;
	}
	
	public static void removeRow() {
		rows--;
	}
	
	public static String[] getRole() {
		return role;
	}
	
	public static String[] getUnits() {
		String[] tmp = new String[Run.unitsArray.size()];
		for (int i = 0; i < Run.unitsArray.size(); i++) {
			tmp[i] = Run.unitsArray.get(i).getUnit();
		}
		tmp = removeDuplicates(tmp);
		return tmp;
	}
	
	public static String[] getDimensions() {
		String[] tmp = new String[Run.unitsArray.size()];
		for (int i = 0; i < Run.unitsArray.size(); i++) {
			tmp[i] = Run.unitsArray.get(i).getDimension();
		}
		tmp = removeDuplicates(tmp);
		return tmp;
	}
	
	public static String[] removeDuplicates(String[] containsDuplicates) {
		List<String> containsDuplicatesTmp = Arrays.asList(containsDuplicates);
		List<String> tmp0 = new ArrayList<String>();
		boolean duplicate = false;
		if (containsDuplicatesTmp.size() > 0) {
			for (int i = 0; i < containsDuplicatesTmp.size(); i++) {
				if (tmp0.size() < 1) {
					tmp0.add(containsDuplicatesTmp.get(i));
				} else if (tmp0.size() > 0) {
					for (int n = 0; n < tmp0.size(); n++) {
						if (tmp0.get(n).equals(containsDuplicatesTmp.get(i))) {
							duplicate = true;
						}
					}
					if (duplicate == false) {
						tmp0.add(containsDuplicatesTmp.get(i));
					}
					duplicate = false;
				}
			}
		}
		String[] tmp = new String[tmp0.size()];
		return tmp0.toArray(tmp);
	}
	
	// Save date from Window one for using in R functions. All elements of array
	// are string
	public static void savaDateFromFields() {
		// copy array with date from field of window one into array in the run
		// funk.
		dateFromWindowOne = Window.dateFromFieldString;
		// print out the array for testing
		for (int i = 0; i < 16 * Run.rows; i++) {
			System.out.println(dateFromWindowOne.get(i).toString() + " Ausgabe");
			System.out.println(dateFromWindowOne.size() + " size");
		}
	}
	
	public static class ReadCSVRunnable implements Runnable {		
		@Override
		public void run() {
			CSV.readCSV(csvName);
		}
	}
	
}