package com.LuminousVector.Excersies.Arrays;

import com.LuminousVector.Utils.Debug;
import com.LuminousVector.Utils.MathV;

import java.util.Scanner;

public class NumberArrayStatsApp
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Debug.log("How many temperatures?");
		int tempCount = in.nextInt();
		double[] temps = new double[tempCount];
		Debug.log("Enter " + tempCount + " temperatures:");
		for (int i = 0; i < tempCount; i++)
		{
			temps[i] = in.nextDouble();
		}
		double average = MathV.ArrayAverage(temps);
		Debug.log("The average temperature is " + average);
		Debug.log("The temperatures are:");
		for (double t: temps)
		{
			double delta = t - average;
			String deltaStr = (delta >= 0) ? " degrees above average." : " degrees below average.";
			if(t == 0)
				Debug.log("\t" + t + " Degrees");
			else
				Debug.log("\t" + t + " Degrees, " + Math.abs(delta) + deltaStr);
		}
	}
}
