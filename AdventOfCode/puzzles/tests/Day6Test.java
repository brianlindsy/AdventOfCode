package AdventOfCode.puzzles.tests;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import AdventOfCode.puzzles.Day6;

public class Day6Test {

	Day6 day6 = new Day6();

	@Test
	public void testEveryoneYes() {
		ArrayList<Day6.Group> entries = Day6.populateEntriesPartTwo("Day6InputTest.txt");
		Assert.assertEquals(1, entries.size());
		Assert.assertEquals(0, Day6.calculateTotalEveryoneYes(entries));
	}
	
	@Test
	public void testEveryoneYes2() {
		ArrayList<Day6.Group> entries = Day6.populateEntriesPartTwo("Day6InputTest2.txt");
		Assert.assertEquals(2, entries.size());
		Assert.assertEquals(6, Day6.calculateTotalEveryoneYes(entries));
	}
	
	@Test
	public void testEveryoneYes3() {
		ArrayList<Day6.Group> entries = Day6.populateEntriesPartTwo("Day6InputTest3.txt");
		Assert.assertEquals(5, entries.size());
		Assert.assertEquals(14, Day6.calculateTotalEveryoneYes(entries));
	}

}
