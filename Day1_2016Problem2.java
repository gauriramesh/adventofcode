/**
 * Gauri Ramesh
 * Advent of Code 2016 Day 1 Problem 2
 * 12/15/2016
 * This contains code for Advent of Code Day 1 Problem 2.
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day1_2016Problem2 {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\New\\Documents\\College 2016-2017\\Advent of Code\\2016\\Day1_2016.txt");
		List<String> directions = new ArrayList<String>();
		try {
			directions = Files.readAllLines(f.toPath(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}

		char direction = 'N';
		int xCurrentPosition = 0;
		int yCurrentPosition = 0;
		int integer = 0;
		int temp = 0;
		List<int[]> coordinates = new ArrayList<int[]>();
		for (int i = 0; i < directions.size(); i++) {
			if (directions.get(i).contains("L")) {
				if (direction == 'N') {
					direction = 'W';
				} else if (direction == 'S') {
					direction = 'E';
				} else if (direction == 'E') {
					direction = 'N';
				} else if (direction == 'W') {
					direction = 'S';
				}
			} else if (directions.get(i).contains("R")) {
				if (direction == 'N') {
					direction = 'E';
				} else if (direction == 'S') {
					direction = 'W';
				} else if (direction == 'E') {
					direction = 'S';
				} else if (direction == 'W') {
					direction = 'N';
				}
			}

			String intString = directions.get(i).substring(1, directions.get(i).length());
			intString = intString.trim();
			integer = Integer.parseInt(intString);

			if (direction == 'N') {
				temp = yCurrentPosition;
				yCurrentPosition += integer;
				for (int h = temp; h < yCurrentPosition; h++) {
					coordinates.add(new int[] { xCurrentPosition, h });
				}
			} else if (direction == 'S') {
				temp = yCurrentPosition;
				yCurrentPosition -= integer;
				for (int h = temp; h > yCurrentPosition; h--) {
					coordinates.add(new int[] { xCurrentPosition, h });
				}
			} else if (direction == 'E') {
				temp = xCurrentPosition;
				xCurrentPosition += integer;
				for (int h = temp; h < xCurrentPosition; h++) {
					coordinates.add(new int[] { h, yCurrentPosition });
				}
			} else if (direction == 'W') {
				temp = xCurrentPosition;
				xCurrentPosition -= integer;
				for (int h = temp; h > xCurrentPosition; h--) {
					coordinates.add(new int[] { h, yCurrentPosition });
				}
			}
		}
		Outerloop: for (int m = 0; m < coordinates.size(); m++) {
			for (int k = m + 1; k < coordinates.size(); k++) {
				if (coordinates.get(m)[0] == coordinates.get(k)[0]) {
					if (coordinates.get(m)[1] == coordinates.get(k)[1]) {
						int totalBlocks = Math.abs(coordinates.get(m)[0]) + Math.abs(coordinates.get(m)[1]);
						System.out.println("Easter Bunny HQ is " + totalBlocks + " blocks away");
						break Outerloop;
					}
				}
			}
		}

	}

}
