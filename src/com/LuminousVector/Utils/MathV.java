package com.LuminousVector.Utils;

public class MathV
{
	public static double Round(double value, double d)
	{
		return Math.round(value * d)/d;
	}

	public static int Clamp(int value, int min, int max)
	{
		if(value < min)
			value = min;
		if(value > max)
			value = max;
		return value;
	}
	
	public static double Clamp(double value, double min, double max)
	{
		if(value < min)
			value = min;
		if(value > max)
			value = max;
		return value;
	}
	
	public static String FormatZeros(int num, int zeros)
	{
		String out = num + "";
		if(out.length() < zeros)
		{
			for(int i = out.length(); i < zeros; i++)
			{
				out = "0" + out;
			}
		}
		return out;
	}

	public static double ArrayAverage(double[] array)
	{
		return  ArraySum(array)/array.length;
	}

	public static double ArraySum(double[] array)
	{
		double sum = 0;
		for (double f: array)
		{
			sum += f;
		}
		return  sum;
	}
}
