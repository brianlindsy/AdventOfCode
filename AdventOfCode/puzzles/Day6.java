package AdventOfCode.puzzles;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Day6 {
	
	public static class Group {
		int size;
		String totalYes;
		
		public Group(int size, String totalYes) {
			this.size = size;
			this.totalYes = totalYes;
		}
	}

	public static ArrayList<Set<String>> populateEntriesPartOne(String fileName) {
		ArrayList<Set<String>> entries = new ArrayList<Set<String>>();
		try {
			List<String> allLines = Files.readAllLines(Paths.get(fileName));
			int i=0;
			while(i < allLines.size()) {
				TreeSet<String> set = new TreeSet<String>();
				while(i < allLines.size() && !allLines.get(i).isEmpty()) {
					for(int j=0;j<allLines.get(i).length();j++) {
						set.add(String.valueOf(allLines.get(i).charAt(j)));
					}
					i++;
				}
				entries.add(set);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ArrayList was populated.");

		return entries;
	}
	
	public static ArrayList<Group> populateEntriesPartTwo(String fileName) {
		ArrayList<Group> groups = new ArrayList<Group>();
		try {
			List<String> allLines = Files.readAllLines(Paths.get(fileName));
			int i=0;
			while(i < allLines.size()) {
				String allAnswers = "";
				int numOfPeople = 0;
				while(i < allLines.size() && !allLines.get(i).isEmpty()) {
					allAnswers += allLines.get(i);
					numOfPeople++;
					i++;
				}
				groups.add(new Group(numOfPeople, allAnswers));
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ArrayList was populated.");

		return groups;
	}
	
	public static int calculateTotalYes(ArrayList<Set<String>> yesPerGroup) {
		int totalYes = 0;
		
		for(Set<String> set : yesPerGroup) {
			totalYes += set.size();
		}
		return totalYes;
	}
	
	public static int calculateEveryoneYes(int numOfPeople, String totalYes) {
		int everyoneYes = 0;;
		for(char c : totalYes.toCharArray()) {
			int numCharsPresent = 0;
			for(char d : totalYes.toCharArray()) {
				if(d == c) {
					numCharsPresent++;
				}
			}
			if(numCharsPresent == numOfPeople) {
				everyoneYes++;
			}
			totalYes = totalYes.replaceAll("" + String.valueOf(c), "");
		}
		
		return everyoneYes;
	}
	
	public static int calculateTotalEveryoneYes(ArrayList<Group> groups) {
		int total = 0;
		for(Group g : groups) {
			total += calculateEveryoneYes(g.size, g.totalYes);
		}
		
		return total;
	}

	public static void main(String[] args) {
		ArrayList<Set<String>> yesPerGroup = populateEntriesPartOne("Day6Input.txt");
		
		int totalYes = calculateTotalYes(yesPerGroup);
		
		System.out.println("Total Yes part one: " + totalYes);
		
		ArrayList<Group> yesEveryonePerGroup = populateEntriesPartTwo("Day6Input.txt");

		int total = calculateTotalEveryoneYes(yesEveryonePerGroup);
		
		System.out.println("Total part two: " + total);
	}

}
