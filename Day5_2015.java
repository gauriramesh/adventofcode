import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5_2015 {
	public static void main(String args[])
	{
		File f = new File("C:\\Users\\New\\Documents\\College 2016-2017\\Advent of Code\\2015\\Day5_2015.txt");
		List<String> inputList = new ArrayList<String>();
		try {
			inputList = Files.readAllLines(f.toPath(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		int vowelCount = 0;
		boolean passVowel=false;
		boolean passRepeat = false;
		boolean disallow = false;
		int niceStrings = 0;
		for(int i = 0; i < inputList.size(); i++)
		{
			passVowel = false;
			passRepeat = false;
			disallow = false;
			vowelCount =0;
			String test = inputList.get(i);
			Pattern vowelPattern = Pattern.compile("[aeiou]");
			Matcher vowelMatcher = vowelPattern.matcher(test);
			while(vowelMatcher.find())
			{
				vowelCount++;
				System.out.println(vowelCount);
			}
			if(vowelCount >= 3)
			{
				passVowel = true;
			}
			
			Pattern repeatPattern = Pattern.compile("(\\w)\\1");
			Matcher repeatMatcher = repeatPattern.matcher(test);
			if(repeatMatcher.find())
			{
				passRepeat = true;
			}
			
			if(!test.contains("ab") && !test.contains("cd") && !test.contains("pq") && !test.contains("xy"))
			{
				disallow = true;
				
			}
			
			if(passVowel == true && passRepeat == true && disallow == true)
			{
				niceStrings++;
				System.out.println("increment nice strings");
			}
			
			
			
			
		}
		System.out.println("There are " + niceStrings + " nice strings.");
		
	}

}
