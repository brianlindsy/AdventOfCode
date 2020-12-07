package AdventOfCode.puzzles;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day1 {
	
	static ArrayList<Integer> entries = new ArrayList<Integer>();
	
	public static void populateArrayList() {
		
		try {
			File myObj = new File("entries1.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				entries.add(Integer.valueOf(data));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("ArrayList was populated.");
	}
	
	public static int[] calculateTwoSum() {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		int i=0;
		for(Integer entry : entries) {
			int comp = 2020 - entry;
			hashMap.put(comp, i);
			i++;
		}
		
		int[] solutionIndexes = new int[2];
				
		i=0;
		for(Integer entry : entries) {
			if(hashMap.get(entry) != null && hashMap.get(entry) != i) {
				solutionIndexes[0] = hashMap.get(entry);
				solutionIndexes[1] = i;
			}
			i++;
		}
		
		return solutionIndexes;
	}
	
	public static int[] calculateThreeSum() {
		HashMap<Integer, int[]> hashMap = new HashMap<Integer, int[]>();
		
		int i=0;
		for(Integer entry1 : entries) {
			int j=0;
			for(Integer entry2 : entries) {
				if(i != j) {
					int[] indexes = new int[2];
					indexes[0] = i;
					indexes[1] = j;
					int comp = 2020 - (entry1 + entry2);
					hashMap.put(comp, indexes);
				}
				j++;
			}
			i++;
		}
		
		int[] solutionIndexes = new int[3];
				
		i=0;
		for(Integer entry : entries) {
			if(hashMap.get(entry) != null && hashMap.get(entry)[0] != i && hashMap.get(entry)[1] != i) {
				solutionIndexes[0] = hashMap.get(entry)[0];
				solutionIndexes[1] = hashMap.get(entry)[1];
				solutionIndexes[2] = i;
			}
			i++;
		}
		
		return solutionIndexes;
	}
	
	public static void part1Solution() {
		int[] solutionIndexes = calculateTwoSum();
		
		System.out.println("Indexes 0: " + solutionIndexes[0] + " 1: " + solutionIndexes[1]);
		
		System.out.println("Two Sum Solution: " + entries.get(solutionIndexes[0]) * entries.get(solutionIndexes[1]));
	}
	
	public static void part2Solution() {
		int[] solutionIndexes = calculateThreeSum();
		
		System.out.println("Indexes 0: " + solutionIndexes[0] + " 1: " + solutionIndexes[1] + " 2: " + solutionIndexes[2]);
				
		System.out.println("Three Sum Solution: " + entries.get(solutionIndexes[0]) * entries.get(solutionIndexes[1]) * entries.get(solutionIndexes[2]));
	}
	
	public static void main(String[] args) {
		
		populateArrayList();
		
		part1Solution();
		
		part2Solution();
	}

}
