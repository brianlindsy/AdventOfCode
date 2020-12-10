package AdventOfCode.puzzles.tests;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;

import AdventOfCode.puzzles.Day7;

public class Day7Test {

	Day7 day7 = new Day7();
	
	String notSanitized = "5 faded teal bags, 1 light gray bag, 4 bright turquoise bags, 5 posh crimson bags.";
	String[] sanitizedExpected = {"5 faded teal", "1 light gray", "4 bright turquoise", "5 posh crimson"};

	@Test
	public void testPopulateHashMap() {
		HashMap<String, Integer> hashMap = Day7.populateHashMap("Day7Input.txt");
		Assert.assertEquals(594, hashMap.size());
		Assert.assertEquals(541, hashMap.get("clear lavender").longValue());
		Assert.assertEquals(323, hashMap.get("mirrored brown").longValue());
		Assert.assertEquals(0, hashMap.get("clear purple").longValue());
	}
	
	@Test
	public void testPopulateAdjMatrix() {
		HashMap<String, Integer> hashMap = Day7.populateHashMap("Day7Input.txt");
		int[][] matrix = Day7.populateAdjacencyMatrix("Day7Input.txt", hashMap);
		Assert.assertEquals(594, matrix.length);
		Assert.assertEquals(5, matrix[hashMap.get("light violet")][hashMap.get("posh crimson")]);
		Assert.assertEquals(4, matrix[hashMap.get("light violet")][hashMap.get("bright turquoise")]);
	}
	
	@Test
	public void testCalcBags() {
		HashMap<String, Integer> hashMap = Day7.populateHashMap("Day7InputTest2");
		int[][] matrix = Day7.populateAdjacencyMatrix("Day7InputTest2", hashMap);
		Assert.assertEquals(9, matrix.length);
		
		int answer = Day7.calculateNumberOfBagsCanContain("shiny gold", matrix, hashMap);
		Assert.assertEquals(4, answer);
		//int answer2 = Day7.calculateNumberOfBagsCanContain("bright white", matrix, hashMap);
		//Assert.assertEquals(1, answer2);
		
	}
	
	@Test
	public void testPopulateAdjMatrixContainsNoBags() {
		HashMap<String, Integer> hashMap = Day7.populateHashMap("Day7Input.txt");
		int[][] matrix = Day7.populateAdjacencyMatrix("Day7Input.txt", hashMap);
		Assert.assertEquals(594, matrix.length);
		for(int i=0;i<matrix.length;i++) {
			Assert.assertEquals(0, matrix[hashMap.get("muted crimson")][i]);
		}
	}
	
	@Test
	public void testPopulateSanitizeBagString() {
		ArrayList<String> notSanitizedTokens = new ArrayList<String>(Arrays.asList(notSanitized.split("bag")));
		String[] santizedActual = Day7.sanitizeBagString(notSanitizedTokens);
		Assert.assertEquals(4, santizedActual.length);
		
		for(int i=0;i<sanitizedExpected.length;i++) {
			Assert.assertEquals(sanitizedExpected[i], santizedActual[i]);
		}
	}

}
