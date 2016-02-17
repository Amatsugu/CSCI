package com.LuminousVector.CSCI151.Homework.HW7;

import com.LuminousVector.Utils.Debug;

import java.util.Scanner;

public class FibonacciApp
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		while (true)
		{
			Debug.lognr("Enter the fibonacci number to find:");
			int index = Math.abs(in.nextInt());
			Debug.log("The #" + index + " Fibonacci number is: " + Fibonacci.getNumber(index));
		}
	}
}
