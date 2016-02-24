package com.LuminousVector.CSCI260.Excercies;


import com.LuminousVector.Utils.Debug;

import java.util.Scanner;

public class RecursiveMath
{
	public static void main(String[] args)
	{
		//Assumes n is non-negative
		Scanner in = new Scanner(System.in);
		Debug.lognr("Enter a non-negative integer: ");
		int n = in.nextInt();
		Debug.log(String.format("Sum(%d): %d", n, Sum(n)));
		Debug.log(String.format("BiPower(%d): %d", n, BiPower(n)));
		Debug.log(String.format("TimesFive(%d): %d", n, TimesFive(n)));
	}

	static int Sum(int n)
	{
		return (n == 0) ? 0 : (n == 1) ? 1 : n + Sum(n-1);
	}

	static int BiPower(int n)
	{
		return (n == 0) ? 1 : (n == 1) ? 2 : 2 * BiPower(n-1);
	}

	static int TimesFive(int n)
	{
		return (n == 0) ? 0 : (n == 1) ? 5 : 5 * TimesFive(n-1);
	}
}
