package com.LuminousVector.Utils;

public class MathV
{
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
}
