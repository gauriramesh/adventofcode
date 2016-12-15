import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day1_2015 {
	
	public static void main(String args[])
	{
		File f = new File("C:\\Users\\New\\Documents\\College 2016-2017\\Advent of Code\\2015\\Day1.txt");
		List<String> inputList = new ArrayList<String>();
		try {
			inputList = Files.readAllLines(f.toPath(), Charset.defaultCharset());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		StringBuilder inputsb = new StringBuilder();
		for(String inputString:inputList)
		{
			inputsb.append(inputString);
		}
		String floorString = inputsb.toString();
		int floorNum = 0;
		for(int i = 0; i < floorString.length(); i++)
		{
			if(floorString.charAt(i) == '(')
			{
				floorNum++;
			}
			else if(floorString.charAt(i)== ')')
			{
				floorNum--;
			}
		
			if(floorNum== -1)
			{
				System.out.println("Santa first enters the basement at position : " + (i+1));
				break;
			}
		}
		System.out.println("Santa ends up on floor: " + floorNum);
		
	}

}
