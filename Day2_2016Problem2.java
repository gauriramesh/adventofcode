/**
 ** Gauri Ramesh *Advent of Code 2016 Day 2 Problem 2 
 ** 12/18/2016
 **/

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day2_2016Problem2 {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\New\\Documents\\College 2016-2017\\Advent of Code\\2016\\Day2_2016.txt");
		List<String> instructions = new ArrayList<String>();
		try {
			instructions = Files.readAllLines(f.toPath(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		char [][] keypad = new char[5][5];
		keypad[0][0] = '0';
		keypad[0][1] = '0';
		keypad[0][2] = '1';
		keypad[0][3] = '0';
		keypad[0][4] = '0';
		keypad[1][0] = '0';
		keypad[1][1] = '2';
		keypad[1][2] = '3';
		keypad[1][3] = '4';
		keypad[1][4] = '0';
		keypad[2][0] = '5';
		keypad[2][1] = '6';
		keypad[2][2] = '7';
		keypad[2][3] = '8';
		keypad[2][4] = '9';
		keypad[3][0] = '0';
		keypad[3][1] = 'A';
		keypad[3][2] = 'B';
		keypad[3][3] = 'C';
		keypad[3][4] = '0';
		keypad[4][0] = '0';
		keypad[4][1] = '0';
		keypad[4][2] = 'D';
		keypad[4][3] = '0';
		keypad[4][4] = '0';
				
		int xCoordinate = 2;
		int yCoordinate = 0;

		StringBuilder codesb = new StringBuilder();
		for (int i = 0; i < instructions.size(); i++) {
			for (int j = 0; j < instructions.get(i).length(); j++) {
				if (instructions.get(i).charAt(j) == 'R') {
					yCoordinate++;
					if (yCoordinate > 4 || keypad[xCoordinate][yCoordinate] == '0') {
						yCoordinate--;
					}
				}
				if (instructions.get(i).charAt(j) == 'L') {
					yCoordinate--;
					if (yCoordinate < 0 || keypad[xCoordinate][yCoordinate]=='0') {
						yCoordinate++;
					}
				}
				if (instructions.get(i).charAt(j) == 'D') {
					xCoordinate++;
					if (xCoordinate > 4 || keypad[xCoordinate][yCoordinate]=='0') {
						xCoordinate--;
					}
				}
				if (instructions.get(i).charAt(j) == 'U') {
					xCoordinate--;
					if (xCoordinate < 0 || keypad[xCoordinate][yCoordinate]=='0') {
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
