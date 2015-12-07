package com.LuminousVector.Projects.Recursion;

import com.LuminousVector.Utils.Debug;
import com.LuminousVector.Utils.MathV;

import java.util.Random;

public class AdderApp
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		int[] nums = new int[10];
		Debug.log("Generating numbers:");
		for (int i = 0; i < 10; i++)
		{
			if(i != 0)
				Debug.lognr(", ");
			nums[i] = Math.abs(rand.nextInt()/1000);
			Debug.lognr(nums[i]);
		}
		Debug.log("\nThe Sum is: ");
		Debug.log(RecursiveAdder.Sum(nums));
	}
}
