/**
 * Gauri Ramesh
 * Advent of Code 2015, Day 4, Problem 1
 * 12/23/2016
 */


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4_2015 {

	public static void main(String args[]) {
		String input = "iwrupvqb";
		Integer number = 0;
		int numZeroes = 0;
		Loop: while (numZeroes != 5) {
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
						System.out.println(numAppend);
						break Loop;
					}
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
