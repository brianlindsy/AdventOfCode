package AdventOfCode.puzzles.tests;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import AdventOfCode.puzzles.Day3;


public class Day3Test {
	
	@Test
	public void testTreeCount1x1() {
		
		int expected = 4;
		
		char[][] map = Day3.populateMap("Day3TestInput.txt");
		
		int actual = Day3.countTreesHit(map, 1, 1);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testTreeCount1x1v2() {
		
		int expected = 6;
		
		char[][] map = Day3.populateMap("Day3TestInput2.txt");
		
		int actual = Day3.countTreesHit(map, 1, 1);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testTreeCount1x2() {
		
		int expected = 0;
		
		char[][] map = Day3.populateMap("Day3TestInput.txt");
		
		int actual = Day3.countTreesHit(map, 1, 2);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testTreeCount7x1() {
		
		int expected = 4;
		
		char[][] map = Day3.populateMap("Day3TestInput.txt");
		
		int actual = Day3.countTreesHit(map, 7, 1);
		
		Assert.assertEquals(expected, actual);
	}

}
