/**
 * Gauri Ramesh
 * Advent of Code 2016, Day 5, Problem 1
 * 12/25/2016 (Merry Christmas!)
 */

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day5_2016 {

	public static void main(String args[])
	{
		String input = "ugkcyxxp";
		StringBuilder password = new StringBuilder();
		Integer number = 0;
		int numZeroes = 0;
		int charNumber = 0;
		while(charNumber != 8)
		{
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
				for (int i = 0; i < 5; i++) {
					if (hash.charAt(i) == '0') {
						numZeroes++;
					}
					if (numZeroes == 5) {
						password.append(hash.charAt(5));
						charNumber++;
						System.out.println(charNumber);
					}
					
				}
				if(charNumber==8)
				{
					password.toString();
					System.out.println(password);
					break;
				}
				number++;
				md.reset();
				//System.out.println(hash);

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			// MessageDigest returns a byte array.

		}
		
	}
}
