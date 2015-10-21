package com.LuminousVector.Exmaple;

import java.util.Scanner;

import com.LuminousVector.Utils.Debug;

public class App
{
	public static void main(String[] args)
	{
		AverageCalculator calc = new AverageCalculator();
		Scanner in = new Scanner(System.in);
		do
		{
			Debug.log("Enter Grades:");
			for(int i = 0; i < 10; i++)
			{
				calc.SetGrade(in.nextFloat());
			}
		}while(!calc.Calculate());
	}
}
