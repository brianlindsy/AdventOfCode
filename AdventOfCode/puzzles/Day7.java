package AdventOfCode.puzzles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Day7 {
	
	public static HashMap<String, Integer> populateHashMap(String fileName) {

		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			int i=0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] containSplit = data.split(" bags contain ");
				String bagColor = containSplit[0];
				hashMap.put(bagColor, i);
				i++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("HashMap was populated.");
		
		return hashMap;
	}
	
	public static int[][] populateAdjacencyMatrix(String fileName, 
			HashMap<String, Integer> hashMap) {
		int matrixSize = hashMap.size();
		int [][] adjMatrix = new int[matrixSize][matrixSize];

		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] containSplit = data.split(" bags contain ");
				String bagContains = containSplit[1];
				String bagColor = containSplit[0];
				if(bagContains.startsWith("no")) {
					for(int j=0;j<matrixSize;j++) {
						adjMatrix[hashMap.get(bagColor)][j] = 0;
					}
				} else {
					String[] bagsSplit = bagContains.split("bag");
					ArrayList<String> bagArray = new ArrayList<String>(Arrays.asList(bagsSplit));
					bagsSplit = sanitizeBagString(bagArray);
					for(String bagAndCount : bagsSplit) {
						String[] bagAndCountSplit = bagAndCount.split(" ");
						int count = 0;
						if(!bagAndCountSplit[0].isEmpty()) {
							count = Integer.valueOf(bagAndCountSplit[0]);
							String bag = bagAndCountSplit[1] + " " + bagAndCountSplit[2];
							adjMatrix[hashMap.get(bagColor)][hashMap.get(bag)] = count;
						}
					}
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("Matrix was populated.");
		
		return adjMatrix;
	}
	
	public static String[] sanitizeBagString(ArrayList<String> bagsSplit) {
		bagsSplit.remove("s.");
		
		ArrayList<String> toReturnArrayList = new ArrayList<String>();
		for(String bag : bagsSplit) {
			String newString = bag.replace("s,", "").replace(",", "").replace(".", "").strip();
			toReturnArrayList.add(newString);
		}
		
		String[] toReturn = toReturnArrayList.toArray(new String[toReturnArrayList.size()]);
		return toReturn;
	}
	
	public static int calculateNumberOfBagsCanContain(String bagColor, int[][] matrix, HashMap<String, Integer> hash) {
		int answer = 0;
		
		ArrayList<Integer> listOfIndexes = new ArrayList<Integer>();
		Integer initialIndex = hash.get(bagColor);
		listOfIndexes.add(hash.get(bagColor));
		
		while(listOfIndexes.size() > 0) {
			Integer indexToLook = listOfIndexes.get(0);
			for(int i=0;i<matrix.length;i++) {
				if(matrix[i][indexToLook] > 0 && indexToLook != initialIndex) {
					answer++;
					System.out.println(i + " " + indexToLook);
					listOfIndexes.add(i);
				} 
				if(matrix[i][indexToLook] > 0 && indexToLook == initialIndex) {
					listOfIndexes.add(i);
				}
				
			}
			listOfIndexes.remove(indexToLook);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		
		HashMap<String, Integer> hashMap = populateHashMap("Day7Input.txt");
		
		int[][] matrix = populateAdjacencyMatrix("Day7Input.txt", hashMap);
		
		int answer = calculateNumberOfBagsCanContain("shiny gold", matrix, hashMap);
		
		System.out.println("Answer: " + answer);

	}

}
