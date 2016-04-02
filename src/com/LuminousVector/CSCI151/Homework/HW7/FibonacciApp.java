package com.LuminousVector.CSCI151.Homework.HW7;

import com.LuminousVector.Utils.Console;

import java.util.Scanner;

public class FibonacciApp
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		while (true)
		{
			Console.lognr("Enter the fibonacci number to find:");
			int index = Math.abs(in.nextInt());
			Console.log("The #" + index + " Fibonacci number is: " + Fibonacci.getNumber(index));
		}
	}
}
