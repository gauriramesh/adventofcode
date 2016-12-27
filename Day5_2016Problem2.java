import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Gauri Ramesh Advent of Code 2016, Day 5, Problem 2 
 * 12/27/2016 
 * This took my poor compiler 25 minutes to run... probably needs optimization. At least it's not an infinite loop!
 */

public class Day5_2016Problem2 {

	public static void main(String args[]) {
		String input = "ugkcyxxp";
		String tempPassword = "########";
		int numChars = 0;
		StringBuilder passwordBuild = new StringBuilder(tempPassword);
		//passwordBuild.setLength(8);
		Integer number = 0;
		int numZeroes = 0;
		Loop: while (numChars!=8) {
			String numAppend = number.toString();
			String testInput = input.concat(numAppend);
			numZeroes = 0;
			try {
				// This MessageDigest takes an algorithm as a parameter.
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.reset();
				md.update(testInput.getBytes());
				// Use a BigInteger when there may be overflow.
				BigInteger integer = new BigInteger(1, md.digest());
				String hash = String.format("%1$032X", integer);
				System.out.println("Working...");
				for (int i = 0; i < 5; i++) {
					if (hash.charAt(i) == '0') {
						numZeroes++;
					}
				}
				System.out.println(numZeroes);
					if (numZeroes == 5 && Character.isDigit(hash.charAt(5)) == true) {
						char positionChar = hash.charAt(5);
						int position = Character.getNumericValue(positionChar);
						if (position < 8) {
							if (passwordBuild.charAt(position) == '#') {
								passwordBuild.setCharAt(position, hash.charAt(6));
								numChars++;
								
							}
						}

					}
				
				if(numChars==8)
				{
					System.out.println(passwordBuild.toString());
					break Loop;
					
				}

				number++;
				md.reset();

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			// MessageDigest returns a byte array.

		}
	}
}
