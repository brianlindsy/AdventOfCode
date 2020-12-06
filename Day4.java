import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

	public static ArrayList<HashMap<String, String>> populateEntriesPartTwo(String fileName) {

		ArrayList<HashMap<String, String>> entries = new ArrayList<HashMap<String, String>>();
		try {
			List<String> allLines = Files.readAllLines(Paths.get(fileName));
			int i=0;
			while(i < allLines.size()) {
				HashMap<String, String> keyValues = new HashMap<String, String>();
				while(i < allLines.size() && !allLines.get(i).isEmpty()) {
					String[] split = allLines.get(i).split(" ");
					for(String splitEntry : split) {
						String[] keyValue = splitEntry.split(":");
						keyValues.put(keyValue[0], keyValue[1]);
					}
					i++;
				}
				entries.add(keyValues);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ArrayList was populated.");

		return entries;
	}

	public static boolean validateBirthYear(String birthYear) {
		Pattern birthYearPattern = Pattern.compile("([0-9]{4})");
		Matcher m = birthYearPattern.matcher(birthYear);
		if(!m.matches()) {
			return false;
		}
		int birthYearInt = Integer.valueOf(m.group(1));
		if(birthYearInt > 2002 || birthYearInt < 1920) {
			return false;
		}
		return true;
	}

	public static boolean validateIssueYear(String issueYear) {
		Pattern issueYearPattern = Pattern.compile("([0-9]{4})");
		Matcher m = issueYearPattern.matcher(issueYear);
		if(!m.matches()) {
			return false;
		}
		int issueYearInt = Integer.valueOf(m.group(1));
		if(issueYearInt < 2010 || issueYearInt > 2020) {
			return false;
		}
		return true;
	}

	public static boolean validateExpirationYear(String expYear) {
		Pattern expYearPattern = Pattern.compile("([0-9]{4})");
		Matcher m = expYearPattern.matcher(expYear);
		if(!m.matches()) {
			return false;
		}
		int expYearInt = Integer.valueOf(m.group(1));
		if(expYearInt < 2020 || expYearInt > 2030) {
			return false;
		}
		return true;
	}

	public static boolean validateHeight(String height) {
		Pattern heightPattern = Pattern.compile("([0-9]{2,3})(cm|in)");
		Matcher m = heightPattern.matcher(height);
		if(!m.matches()) {
			return false;
		}
		int heightInt = Integer.valueOf(m.group(1));
		String heightType = m.group(2);
		if(!heightType.equals("in") && !heightType.equals("cm")) {
			return false;
		}
		if(heightType.equals("cm") && heightInt < 150 || heightInt > 193) {
			return false;
		} else if(heightType.equals("in") && (heightInt < 59 || heightInt > 76)) {
			return false;
		}
		return true;
	}

	public static boolean validateHair(String hair) {
		Pattern hairPattern = Pattern.compile("#([0-9a-f]{6})");
		Matcher m = hairPattern.matcher(hair);
		if(!m.matches()) {
			return false;
		}
		return true;
	}

	public static boolean validateEyeColor(String theEyeColor) {
		boolean eyeColorValid = false;
		String[] validEyeColors = "amb blu brn gry grn hzl oth".split(" ");
		for(String eyeColor : validEyeColors) {
			if(eyeColor.equals(theEyeColor)) {
				eyeColorValid = true;
			}
		}
		return eyeColorValid;
	}

	public static boolean validatePid(String id) {
		Pattern idPattern = Pattern.compile("([0-9]{9})");
		Matcher m = idPattern.matcher(id);
		if(!m.matches()) {
			return false;
		}
		return true;
	}

	public static boolean validateContent(HashMap<String, String> content) {

		if(content.get("byr") != null && content.get("iyr") != null && content.get("eyr") != null
				&& content.get("hgt") != null && content.get("hcl") != null && content.get("ecl") != null
				&& content.get("pid") != null) {
			String birthYear = content.get("byr");
			String issueYear = content.get("iyr");
			String expirationYear = content.get("eyr");
			String height = content.get("hgt");
			String hair = content.get("hcl");
			String eyeColor = content.get("ecl");
			String id = content.get("pid");

			if(validatePid(id) && validateEyeColor(eyeColor) && validateBirthYear(birthYear) && validateIssueYear(issueYear)
					&& validateExpirationYear(expirationYear) && validateHeight(height) && validateHair(hair)){
				return true;
			}
		} else {
			return false;
		}

		return false;
	}

	public static int calculateValidPassports(ArrayList<HashMap<String, String>> passports) {
		int validPassports = 0;
		for(HashMap<String, String> hash : passports) {
			boolean valid = validateContent(hash);
			if(valid) {
				validPassports++;
			}
		}

		return validPassports;
	}

	public static void main(String[] args) {

		ArrayList<HashMap<String, String>> entries = populateEntriesPartTwo("Day4Input.txt");
		
		for(HashMap<String, String> hash : entries) {
			for(Map.Entry<String, String> entry : hash.entrySet()) {
				System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
			}
			System.out.println();
		}
		System.out.println(entries.size());

		int answer = calculateValidPassports(entries);

		System.out.println("Answer two: " + answer);

	}

}
