package AdventOfCode.puzzles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day9 {
	
	public static ArrayList<Double> populateArrayList(String fileName) {

		ArrayList<Double> entries = new ArrayList<Double>();

		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				entries.add(Double.valueOf(data));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("ArrayList was populated.");

		return entries;
	}
	
	public static boolean verifyNumber(List<Double> preamble, Double number) {
		for(int i=0;i<preamble.size(); i++) {
			for(int j=0;j<preamble.size();j++) {
				if(i != j && (preamble.get(i) + preamble.get(j) == number)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static Double verifyList(int preamble, ArrayList<Double> listToVerify) {
		
		for(int i=preamble;i<listToVerify.size();i++) {
			if(!verifyNumber(listToVerify.subList(i-preamble, i), listToVerify.get(i))) {
				return listToVerify.get(i);
			}
		}
		
		return 0.0;
	}
	
	public static ArrayList<Double> findContiguousSetEqualTo(Double target, ArrayList<Double> entries){
		int i=0;
		int j=1;
		
		ArrayList<Double> toReturn = new ArrayList<Double>();
		while(i < entries.size()) {
			while(j < entries.size()) {
				int sum = 0;

				for(int k=i;k<=j;k++) {
					sum += entries.get(k);
					toReturn.add(entries.get(k));
				}
				if(sum == target) {
					return toReturn;
				}
				toReturn.clear();
				j++;
			}
			toReturn.clear();
			i++;
			j=i+1;
		}
		return toReturn;
	}

	public static void main(String[] args) {
		
		ArrayList<Double> entries = populateArrayList("Day9Input");
		
		System.out.println("Answer 1: " + verifyList(25, entries));
		
		ArrayList<Double> set = findContiguousSetEqualTo(90433990.0, entries);
		
		Double[] toSort = new Double[set.size()];
		
		toSort = set.toArray(toSort);
		
		Arrays.sort(toSort);
		
		Double answer = toSort[0] + toSort[(set.size()-1)];
		
		System.out.println("Answer 2: " + answer);
	}

}
