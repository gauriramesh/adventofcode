/**
 ** Gauri Ramesh *Advent of Code 2016 Day 2 Problem 1 
 ** 12/17/2016
 **/

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day2_2016 {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\New\\Documents\\College 2016-2017\\Advent of Code\\2016\\Day2_2016.txt");
		List<String> instructions = new ArrayList<String>();
		try {
			instructions = Files.readAllLines(f.toPath(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int[][] keypad = new int[3][3];
		keypad[0][0] = 1;
		keypad[0][1] = 2;
		keypad[0][2] = 3;
		keypad[1][0] = 4;
		keypad[1][1] = 5;
		keypad[1][2] = 6;
		keypad[2][0] = 7;
		keypad[2][1] = 8;
		keypad[2][2] = 9;

		int xCoordinate = 1;
		int yCoordinate = 1;

		StringBuilder codesb = new StringBuilder();
		for (int i = 0; i < instructions.size(); i++) {
			for (int j = 0; j < instructions.get(i).length(); j++) {
				if (instructions.get(i).charAt(j) == 'R') {
					yCoordinate++;
					if (yCoordinate > 2) {
						yCoordinate--;
					}
				}
				if (instructions.get(i).charAt(j) == 'L') {
					yCoordinate--;
					if (yCoordinate < 0) {
						yCoordinate++;
					}
				}
				if (instructions.get(i).charAt(j) == 'D') {
					xCoordinate++;
					if (xCoordinate > 2) {
						xCoordinate--;
					}
				}
				if (instructions.get(i).charAt(j) == 'U') {
					xCoordinate--;
					if (xCoordinate < 0) {
						xCoordinate++;
					}
				}
			}
			codesb.append(keypad[xCoordinate][yCoordinate]);
		}
		String code = codesb.toString();
		System.out.println(code);
	}

}
