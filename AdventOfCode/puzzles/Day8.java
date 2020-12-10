package AdventOfCode.puzzles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Day8 {

	public static ArrayList<String> populateArrayList(String fileName) {

		ArrayList<String> entries = new ArrayList<String>();

		try {
			File myObj = new File(fileName);
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

	public static int updateAccumulatorByAmount(String entry) {
		String[] split = entry.split(" ");
		String instruction = split[0];
		int amount = Integer.valueOf(split[1]);

		if(instruction.equals("nop") || instruction.equals("jmp")) {
			return 0;
		} else {
			return amount;
		}
	}

	public static int updateIndex(String entry) {
		String[] split = entry.split(" ");
		String instruction = split[0];
		int amount = Integer.valueOf(split[1]);

		if(instruction.equals("nop") || instruction.equals("acc")) {
			return 1;
		} else {
			return amount;
		}
	}

	public static int accumulatorValueAtInfLoop(ArrayList<String> entries) {

		int accumulator = 0;
		int index = 0;

		TreeSet<Integer> set = new TreeSet<Integer>();

		while(index < entries.size()) {
			if(!set.contains(index)) {
				String entry = entries.get(index);
				set.add(index);
				accumulator += updateAccumulatorByAmount(entry);
				index += updateIndex(entry);
			} else {
				break;
			}
		}

		return accumulator;
	}

	public static boolean isInfLoop(ArrayList<String> entries) {
		int index = 0;

		TreeSet<Integer> set = new TreeSet<Integer>();

		while(index < entries.size()) {
			if(!set.contains(index)) {
				String entry = entries.get(index);
				set.add(index);
				index += updateIndex(entry);
			} else {
				return true;
			}
		}

		return false;
	}
	
	public static ArrayList<String> switchInstructionAtIndex(ArrayList<String> entries, int i){
		if(entries.get(i).split(" ")[0].equals("jmp")) {
			String entry = "nop 0";
			entries.set(i, entry); 
		}
		
		if(entries.get(i).split(" ")[0].equals("nop") && Integer.valueOf(entries.get(i).split(" ")[1]) != 0) {
			String entry = "jmp " + entries.get(i).split(" ")[1];
			entries.set(i, entry); 
		}
		
		return entries;
	}
	
	public static int fixCorrupted(ArrayList<String> entries) {
		
		ArrayList<String> orig = new ArrayList<String>(entries);
		ArrayList<String> toUpdate = new ArrayList<String>(entries);
		int index = 0;
		int accumulator = 0;

		while(index < entries.size()) {
			toUpdate = switchInstructionAtIndex(entries, index);
			System.out.println(entries.toString());
			if(!isInfLoop(entries)) {
				return accumulatorValueAtInfLoop(entries);
			}
			toUpdate.clear();
			toUpdate.addAll(orig);
			index++;
		}

		return accumulator;
	}

	public static void main(String[] args) {
		ArrayList<String> entries = populateArrayList("Day8Input.txt");

		System.out.println("Answer1: " + accumulatorValueAtInfLoop(entries));
		
		System.out.println("Answer2: " + fixCorrupted(entries));
	}

}
