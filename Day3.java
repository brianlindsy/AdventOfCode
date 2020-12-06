import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
	
	static char[][] map;

	public static char[][] populateMap(String fileName) {
		
		char[][] map = null; 
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			String first = myReader.nextLine();
			map = new char[323][first.toCharArray().length];
			map[0] = first.toCharArray();
			int i = 1;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				char[] dataLine = data.toCharArray();
				map[i] = dataLine;
				i++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("ArrayList was populated.");
		
		return map;
	}
	
	public static int countTreesHit(char[][] map, int over, int down) {
		int treesHit = 0;
		
		int i = 0, j = 0;
		while(i < map.length) {
			while(j < map[0].length && i < map.length) {
				if(map[i][j] == '#') {
					treesHit++;
				}
				i+=down;
				j+=over;
			}
			j = j % map[0].length;
		}
		
		return treesHit;
	}

	public static void main(String[] args) {
		
		char[][] map = populateMap("Day3PuzzleInput.txt");
		
		System.out.println(map.length + " " + map[0].length);
		
		int trees1 = countTreesHit(map, 1, 1);
		int trees2 = countTreesHit(map, 3, 1);
		int trees3 = countTreesHit(map, 5, 1);
		int trees4 = countTreesHit(map, 7, 1);
		int trees5 = countTreesHit(map, 1, 2);

		System.out.println("Trees hit 1: " + trees1);
		System.out.println("Trees hit 2: " + trees2);
		System.out.println("Trees hit 3: " + trees3);
		System.out.println("Trees hit 4: " + trees4);
		System.out.println("Trees hit 5: " + trees5);
		
		System.out.println(trees1 * trees2 * trees3 * trees4 * trees5);
	}

}
