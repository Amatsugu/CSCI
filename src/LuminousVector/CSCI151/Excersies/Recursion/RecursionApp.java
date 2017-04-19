package LuminousVector.CSCI151.Excersies.Recursion;

import LuminousVector.Utils.Console;

public class RecursionApp
{

	public static void main(String[] args)
	{
		countdown(10);
	}

	public static void countdown(int num)
	{
		if (num == 0)
			Console.log("GOOO!");
		else
		{
			Console.log(num);
			countdown(num - 1);
		}
	}
}