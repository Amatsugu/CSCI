package LuminousVector.CSCI151.Projects.FileIO;

import java.util.ArrayList;

public class NumberManager
{
	public static ArrayList<Integer> RemoveDuplicates(ArrayList<Integer> numbers)
	{
		ArrayList<Integer> newNumbers = new ArrayList<>();
		for (Integer i : numbers)
		{
			if (!newNumbers.contains(i))
				newNumbers.add(i);
		}
		return newNumbers;
	}
}