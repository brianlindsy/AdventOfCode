package AdventOfCode.puzzles.tests;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;

import AdventOfCode.puzzles.Day7;
import AdventOfCode.puzzles.Day8;

public class Day8Test {

	Day8 day8 = new Day8();

	@Test
	public void testInfLoop() {
		ArrayList<String> entries = Day8.populateArrayList("Day8InputTest");
		
		int actual = Day8.accumulatorValueAtInfLoop(entries);
		
		Assert.assertEquals(5, actual);
	}
	
	@Test
	public void testProgramTerminates() {
		ArrayList<String> entries = Day8.populateArrayList("Day8InputTest");
		
		int actual = Day8.fixCorrupted(entries);
		
		Assert.assertEquals(8, actual);
	}

}
