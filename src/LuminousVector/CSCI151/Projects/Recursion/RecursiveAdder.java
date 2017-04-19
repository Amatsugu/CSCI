package LuminousVector.CSCI151.Projects.Recursion;

import java.util.ArrayList;

public class RecursiveAdder
{
	public static int Sum(int[] nums)
	{
		if (nums.length == 0)
			return 0;
		ArrayList<Integer> arr = toList(nums);
		int tmp = nums[nums.length-1];
		arr.remove(arr.size()-1);
		return tmp + Sum(toArray(arr));
	}

	private static int[] toArray(ArrayList<Integer> list)
	{
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
		{
			arr[i] = list.get(i);
		}
		return arr;
	}

	private static ArrayList<Integer> toList(int[] arr)
	{
		ArrayList<Integer> arrL = new ArrayList<>(arr.length);
		for (int i : arr)
		{
			arrL.add((i));
		}
		return arrL;
	}

}
