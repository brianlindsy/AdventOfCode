package AdventOfCode.puzzles;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day5 {
	
	public static int rows = 127;
	public static int columns = 7;

	public static ArrayList<String> populateArrayList() {

		ArrayList<String> entries = new ArrayList<String>();

		try {
			File myObj = new File("Day5Input.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				entries.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("ArrayList was populated.");
		
		return entries;
	}
	
	public static double calculateSeatRow(String seat) {
		double calculatedRowUpper = rows;
		double calculatedRowLower = 0;
		for(int i=0;i<7;i++) {
			if(seat.charAt(i) == 'F') {
				calculatedRowUpper -= (calculatedRowUpper-calculatedRowLower) / 2;
			}
			if(seat.charAt(i) == 'B') {
				calculatedRowLower += (calculatedRowUpper-calculatedRowLower) / 2;
			}
		}
		
		return Math.floor(calculatedRowUpper);
	}
	
	public static double calculateSeatColumn(String seat) {
		double calculatedColumnUpper = columns;
		double calculatedColumnLower = 0;
		for(int i=7;i<10;i++) {
			if(seat.charAt(i) == 'L') {
				calculatedColumnUpper -= (calculatedColumnUpper-calculatedColumnLower) / 2;
			}
			if(seat.charAt(i) == 'R') {
				calculatedColumnLower += (calculatedColumnUpper-calculatedColumnLower) / 2;
			}
		}
		
		return Math.floor(calculatedColumnUpper);
	}
	
	public static double calculateSeatID(String seat) {
		double row = calculateSeatRow(seat);
		
		double column = calculateSeatColumn(seat);
		
		double seatID = (row * 8) + column;
		
		return seatID;
	}

	public static void main(String[] args) {
		ArrayList<String> entries = populateArrayList();
		
		HashMap<Double, String> seatIDs = new HashMap<Double, String>();
		
		double largest = 0;
		
		for(String entry : entries) {
			double seatID = calculateSeatID(entry);
			if(seatID > largest) {
				largest = seatID;
			}
			seatIDs.put(calculateSeatID(entry), entry);
		}
		
		System.out.println("Largest: " + largest);
		
		for(double i=1;i<1024;i++) {
			if(seatIDs.get(i) == null && seatIDs.get(i+1) != null && seatIDs.get(i-1) != null) {
				System.out.println(i);
			}
		}
		
	}

}
