/**
 * Gauri Ramesh
 * Advent of Code 2016 Day 4 Problem 2
 * 12/20/2016
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Comparator;



public class Day4_2016Problem2 {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\New\\Documents\\College 2016-2017\\Advent of Code\\2016\\Day4_2016.txt");
		List<String> roomList = new ArrayList<String>();
		try {
			roomList = Files.readAllLines(f.toPath(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		List<Integer> realRooms = new ArrayList<Integer>();

		for (int i = 0; i < roomList.size(); i++) {
			String checksum = roomList.get(i).substring(roomList.get(i).length() - 6, roomList.get(i).length() - 1);
			String sectorID = roomList.get(i).substring(roomList.get(i).lastIndexOf('-') + 1,
					roomList.get(i).length() - 7);
			String encrypted = roomList.get(i).substring(0, roomList.get(i).lastIndexOf('-'));
			
			HashMap<Character, Integer> counts = new HashMap<>();
			for (char c : encrypted.toCharArray()) {
				Integer count = counts.get(c);
				if (count == null) {
					count = 0;
				}
				if (c == '-' || c == '[' || c == ']') {
					continue;
				}
				counts.put(c, ++count);
			}

			// Converts into an array of entries
			List<Entry<Character, Integer>> list = new ArrayList<>(counts.entrySet());
			// This is called an anonymous class.
			Collections.sort(list, new Comparator<Entry<Character, Integer>>() {
				@Override
				public int compare(Entry<Character, Integer> x, Entry<Character, Integer> y) {
					int result = y.getValue() - x.getValue();
					if (result == 0) {
						result = x.getKey().compareTo(y.getKey());
					}
					return result;
				}
			});

			int iterations = 0;
			for (int j = 0; j < checksum.length(); j++) {
				if (checksum.charAt(j) == list.get(j).getKey()) {
					iterations++;
				}
			}
			if (iterations == 5) {
				realRooms.add(Integer.parseInt(sectorID));
				StringBuilder decryptsb = new StringBuilder();
				int index = 0;
				for(int h =0; h < encrypted.length(); h++)
				{
					if(encrypted.charAt(h)=='-')
					{
						decryptsb.append(' ');
					}
					else
					{
					index = alphabet.indexOf(encrypted.charAt(h));
					index += Integer.parseInt(sectorID);
					if(index > 26)
					{
						index %= 26;
					}
					decryptsb.append(alphabet.charAt(index));
					}
					
				}
				
				String decrypt = decryptsb.toString();
				System.out.println("DECRYPT: " + decrypt + Integer.parseInt(sectorID));
				
			}

		}
		int sum = realRooms.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		
	}

}
