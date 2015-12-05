package com.LuminousVector.Projects.Recursion;

import com.LuminousVector.Utils.MathV;

import java.util.Random;

public class AdderApp
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++)
		{
			nums[i] = rand.nextInt();
		}
		RecursiveAdder.Sum(nums);
	}
}
