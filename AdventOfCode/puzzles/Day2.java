package AdventOfCode.puzzles;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day2 {
	
	static ArrayList<String[]> entries = new ArrayList<String[]>(); 

	public static void populateArrayList() {
		try {
			File myObj = new File("entries2.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] firstSplit = data.split("-");
				String[] secondSplit = firstSplit[1].split(" ");
				String[] finalSplit = new String[4];
				finalSplit[0] = firstSplit[0];
				finalSplit[1] = secondSplit[0];
				finalSplit[2] = secondSplit[1].replace(":", "");
				finalSplit[3] = secondSplit[2];
				entries.add(finalSplit);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("ArrayList was populated.");
	}
	
	public static int countValidPasswordsOne() {
		int passwordValidCount = 0;

		for(String[] entry : entries) {
			int low = Integer.valueOf(entry[0]);
			int high = Integer.valueOf(entry[1]);
			char letter = entry[2].charAt(0);
			String password = entry[3];

			int letterCounter = 0;

			for(char c : password.toCharArray()) {
				if(c == letter) {
					letterCounter++;
				}
			}

			if(letterCounter <= high && letterCounter >= low) {
				passwordValidCount++;
			}
		}
		
		return passwordValidCount;
	}
	
	public static int countValidPasswordsTwo() {
		int passwordValidCount = 0;

		for(String[] entry : entries) {
			int lowIndex = Integer.valueOf(entry[0]);
			int highIndex = Integer.valueOf(entry[1]);
			char letter = entry[2].charAt(0);
			String password = entry[3];

			if(password.charAt(lowIndex-1) == letter && password.charAt(highIndex-1) != letter
					|| password.charAt(lowIndex-1) != letter && password.charAt(highIndex-1) == letter) {
				passwordValidCount++;
			}
		}
		
		return passwordValidCount;
	}

	public static void main(String[] args) {
		
		populateArrayList();
		
		int validOne = countValidPasswordsOne();

		System.out.println("Valid passwords part one: " + validOne);
		
		int validTwo = countValidPasswordsTwo();

		System.out.println("Valid passwords part one: " + validTwo);
	}

}
