/**
 * 
 * @author Gauri Ramesh
 * Advent of Code 2015 Day 3 Problem 2
 * 12/18/2016
 */


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class Day3_2015Problem2 {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\New\\Documents\\College 2016-2017\\Advent of Code\\2015\\Day3_2015.txt");
		List<String> inputList = new ArrayList<String>();
		try {
			inputList = Files.readAllLines(f.toPath(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		StringBuilder inputsb = new StringBuilder();
		for(String direction: inputList)
		{
			inputsb.append(direction);
			
		}
		int xCoordinate = 0;
		int yCoordinate = 0;
		int roboSantaX = 0;
		int roboSantaY = 0;
		List<int[]> coordinates = new ArrayList<int[]>();
		List<int[]> roboSantaCoordinates = new ArrayList<int[]>();
		coordinates.add(new int[] {0 ,0});
		String directions = inputsb.toString();
		for(int i = 0; i < directions.length(); i++)
		{
			if(directions.charAt(i)=='^')
			{
				if(i%2==0)
				{
				xCoordinate--;
				}
				else
				{
					roboSantaX--;
				}
			}
			else if(directions.charAt(i)=='v')
			{
				if(i%2==0)
				{
				xCoordinate++;
				}
				else
				{
					roboSantaX++;
				}
			}
			else if(directions.charAt(i)=='<')
			{
				if(i%2==0)
				{
				yCoordinate--;
				}
				else
				{
					roboSantaY--;
				}
			}
			else if(directions.charAt(i)=='>')
			{
				if(i%2==0)
				{
				yCoordinate++;
				}
				else
				{
					roboSantaY++;
				}
			}
			
			coordinates.add(new int [] {xCoordinate, yCoordinate});
			coordinates.add(new int[]{roboSantaX, roboSantaY});
		} 
		List<int []> uniques = new ArrayList<int[]>();
		for(int j = 0; j < coordinates.size(); j++)
		{
			uniques.add(coordinates.get(j));
			for(int k = j+1; k < coordinates.size(); k++)
			{
				if(coordinates.get(j)[0] == coordinates.get(k)[0])
				{
					if(coordinates.get(j)[1]==coordinates.get(k)[1])
					{
					uniques.remove(coordinates.get(j));
					}
				}
			}
		}
		
		
		
		System.out.println("Santa visits " + uniques.size() + " unique house(s).");
		
		

	}

}
