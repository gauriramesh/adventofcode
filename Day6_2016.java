/**
 * Gauri Ramesh
 * 12/30/2016
 * Advent of Code, Day 6, Problem 1, 2016
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Day6_2016 {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\New\\Documents\\College 2016-2017\\Advent of Code\\2016\\Day6_2016.txt");
		List<String> inputList = new ArrayList<String>();
		try {
			inputList = Files.readAllLines(f.toPath(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuilder messageBuild = new StringBuilder();
		StringBuilder positionBuild = new StringBuilder();
		
		for(int i = 0; i < inputList.get(1).length(); i++)
		{
			positionBuild.setLength(0);
			for(int j = 0; j < inputList.size(); j++)
			{
				positionBuild.append(inputList.get(j).charAt(i));
			}
			String position = positionBuild.toString();
			//System.out.println(position);
			TreeMap<Character, Integer> counts = new TreeMap<>(Collections.reverseOrder());
			for(char c : position.toCharArray())
			{
				Integer count = counts.get(c);
				if (count == null) {
					count = 0;
				}
				counts.put(c, ++count);
			}
			
			
	//counts.entrySet() returns a set view of all elements in the map
	//.stream() turns it into an aggregate operation
			//an aggregate operation uses internal iteration, processes from 
			//a stream instead of a collection
			//can specify behavior (lambda expressions) as parameters.
	//.sorted()takes a comparator, Entry.comparingByValue() returns a comparator
			//that sorts by natural value
	//collect(Collectors.toMap()) returns a Collector that puts elements in a
			//map whose keys and values are specified.
	//Entry::getKey, Entry::getValue, function specified (using a method reference)
	//LinkedHashMap::new, creates a new instance.
			LinkedHashMap<Character, Integer> sortedMap = 
				    counts.entrySet().stream().
				    sorted(Entry.comparingByValue()).
				    collect(Collectors.toMap(Entry::getKey, Entry::getValue,
				                             (e1, e2) -> e1, LinkedHashMap::new));
			
			List array = new ArrayList(sortedMap.keySet());
			messageBuild.append(array.get(0));
			
			
			
		}
		System.out.println(messageBuild.toString());

	}

}
