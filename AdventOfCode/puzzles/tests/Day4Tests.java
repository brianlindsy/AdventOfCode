package AdventOfCode.puzzles.tests;
import org.junit.Assert;
import org.junit.Test;

import AdventOfCode.puzzles.Day4;

public class Day4Tests {
	
	Day4 day4 = new Day4();
	
	String[] validHeights = "150cm 151cm 174cm 193cm 59in 67in 76in".split(" ");
	String[] invalidHeights = "1in 1cm 100in 1000cm 60iy 70bg 151g 1 46 z 9".split(" ");
	
	String[] validHair = "#89a89a #1111aa #34b4ca #9a9a9a #aaeaaa".split(" ");
	String[] invalidHair = "898989 #12345 #0a012 123 zebf9 #zeg9 #89a89z".split(" ");
	
	String[] validEyeColors = "amb blu brn gry grn hzl oth".split(" ");
	String[] invalidEyeColors = "azb bl rn gy green hzle other 1 98 #sdhiuewf".split(" ");
	
	@Test
	public void testValidateHeight() {
		for(String valid : validHeights) {
			Assert.assertTrue(Day4.validateHeight(valid));
			System.out.println(valid);
		}
	}
	
	@Test
	public void testValidateInvalidHeight() {
		for(String valid : invalidHeights) {
			Assert.assertFalse(Day4.validateHeight(valid));
		}
	}
	
	@Test
	public void testValidateHair() {
		for(String valid : validHair) {
			Assert.assertTrue(Day4.validateHair(valid));
			System.out.println(valid);
		}
	}
	
	@Test
	public void testValidateInvalidHair() {
		for(String invalid : invalidHair) {
			Assert.assertFalse(Day4.validateHair(invalid));
			System.out.println(invalid);
		}
	}
	
	@Test
	public void testValidateEyeColor() {
		for(String valid : validEyeColors) {
			Assert.assertTrue(Day4.validateEyeColor(valid));
			System.out.println(valid);
		}
	}
	
	@Test
	public void testValidateInvalidEyeColor() {
		for(String invalid : invalidEyeColors) {
			Assert.assertFalse(Day4.validateEyeColor(invalid));
			System.out.println(invalid);
		}
	}

}
