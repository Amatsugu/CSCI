package com.LuminousVector.CSCI151.Exmaple;

import java.util.Scanner;

import com.LuminousVector.Utils.Console;

public class AverageCalculatorApp
{
	public static void main(String[] args)
	{
		AverageCalculator calc = new AverageCalculator();
		Scanner in = new Scanner(System.in);
		do
		{
			Console.log("Enter Grades:");
			for(int i = 0; i < 10; i++)
			{
				calc.SetGrade(in.nextFloat());
			}
		}while(!calc.Calculate());
		in.close();
	}
}
