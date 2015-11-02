package com.LuminousVector.Excersies.Recursion;

import com.LuminousVector.Utils.Debug;

public class RecursionApp
{

	public static void main(String[] args)
	{
		countdown(10);
	}

	public static void countdown(int num)
	{
		if (num == 0)
			Debug.log("GOOO!");
		else
		{
			Debug.log(num);
			countdown(num - 1);
		}
	}
}