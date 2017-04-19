package LuminousVector.CSCI151.Projects.Recursion;

import LuminousVector.Utils.Console;

import java.util.Random;

public class AdderApp
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		int[] nums = new int[10];
		Console.log("Generating numbers:");
		for (int i = 0; i < 10; i++)
		{
			if(i != 0)
				Console.lognr(", ");
			nums[i] = Math.abs(rand.nextInt()/1000);
			Console.lognr(nums[i]);
		}
		Console.log("\nThe Sum is: ");
		Console.log(RecursiveAdder.Sum(nums));
	}
}
