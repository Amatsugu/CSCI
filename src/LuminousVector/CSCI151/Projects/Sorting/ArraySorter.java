package LuminousVector.CSCI151.Projects.Sorting;

import java.util.ArrayList;

public class ArraySorter
{
	public static ArrayList<String> SortArray(ArrayList<String> strings)
	{
		int i, minIndex, j;
		String tmp;
		int n = strings.size();
		for (i = 0; i < n - 1; i++) {
			minIndex = i;
			for (j = i + 1; j < n; j++)
				if (strings.get(j).compareTo(strings.get(minIndex)) < 0)
					minIndex = j;
			if (minIndex != i) {
				tmp = strings.get(i);
				strings.set(i, strings.get(minIndex));
				strings.set(minIndex, tmp);
			}
		}
		return strings;
	}
}
