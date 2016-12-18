import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Gauri Ramesh
 * Advent of Code 2015 Day 2
 * 12/16/2016
 * 
 */
public class Day2_2015 {
	public static void main(String args[]) {
		File f = new File("C:\\Users\\New\\Documents\\College 2016-2017\\Advent of Code\\2015\\Day2_2015.txt");
		List<String> dimensions = new ArrayList<String>();
		try {
			dimensions = Files.readAllLines(f.toPath(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int totalWrappingPaper = 0;
		for (int i = 0; i < dimensions.size(); i++) {
			String[] splitDimension = dimensions.get(i).split("x");
			int length = Integer.parseInt(splitDimension[0]);
			int width = Integer.parseInt(splitDimension[1]);
			int height = Integer.parseInt(splitDimension[2]);
			int area1 = (2 * length * width);
			int area2 = (2 * width * height);
			int area3 = (2 * length * height);
			int surfaceArea = area1 + area2 + area3;
			int[] slack = { area1, area2, area3 };
			Arrays.sort(slack);
			totalWrappingPaper += surfaceArea + ((slack[0])/2);

		}
		System.out.println("The elves need: " + totalWrappingPaper + " total square feet of wrapping paper.");
	}

}
