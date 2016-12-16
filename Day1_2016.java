/**
 * Gauri Ramesh
 * Advent of Code 2016 Day 1 Problem 1
 * 12/15/2016
 * This contains code for Advent of Code Day 1 without using regular expressions.
 */


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day1_2016 {

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
		for(int i = 0; i < directions.size(); i++)
		{
			if(directions.get(i).contains("L"))
			{
				if(direction == 'N')
				{
					direction = 'W';
				}
				else if(direction == 'S')
				{
					direction = 'E';
				}
				else if(direction=='E')
				{
					direction = 'N';
				}
				else if(direction == 'W')
				{
					direction = 'S';
				}
			}
			else if(directions.get(i).contains("R"))
			{
				if(direction == 'N')
				{
					direction  = 'E';
				}
				else if(direction=='S')
				{
					direction = 'W';
				}
				else if(direction=='E')
				{
					direction = 'S';
				}
				else if(direction == 'W')
				{
					direction = 'N';
				}
			}
			
			String intString = directions.get(i).substring(1, directions.get(i).length());
			intString = intString.trim();
			integer = Integer.parseInt(intString);
			System.out.println(integer);
			
			if(direction=='N')
			{
				yCurrentPosition += integer;
			}
			else if(direction=='S')
			{
				yCurrentPosition -= integer;
			}
			else if(direction=='E')
			{
				xCurrentPosition += integer;
			}
			else if(direction=='W')
			{
				xCurrentPosition -= integer;
			}
		}
		
		int totalBlocks = Math.abs(xCurrentPosition)+Math.abs(yCurrentPosition);
		System.out.println("The destination is " + totalBlocks + " blocks away");

	}
	

}
