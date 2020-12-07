package AdventOfCode.puzzles.tests;
import org.junit.Assert;
import org.junit.Test;

import AdventOfCode.puzzles.Day5;

public class Day5Tests {
	
	Day5 day5 = new Day5();
	
	String seat1 = "FBFBBFFRLR";
	int seat1Row = 44;
	int seat1Column = 5;
	
	@Test
	public void testValidatePass() {
		Assert.assertEquals(seat1Row, Day5.calculateSeatRow(seat1), 0);
		Assert.assertEquals(seat1Column, Day5.calculateSeatColumn(seat1), 0);
		Assert.assertEquals(357, Day5.calculateSeatID(seat1), 0);
	}

}
