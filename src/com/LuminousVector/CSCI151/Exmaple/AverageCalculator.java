package com.LuminousVector.CSCI151.Exmaple;

import com.LuminousVector.Utils.Debug;

public class AverageCalculator
{
	private float[] scores = new float[10];
	private int curIndex = 0;
	private float average;
	private int totalAboveAverage;

	public void SetGrade(float grade)
	{
		if (curIndex > scores.length)
			return;
		scores[curIndex] = grade;
		curIndex++;
	}

	public boolean Calculate()
	{
		float total,min,max;
		total = max = 0;
		min = Float.MAX_VALUE;
		for(float score : scores)
		{
			try{
				if(score < 0)
					throw new Exception("Negative Grade!");				
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				scores = new float[10];
				curIndex = 0;
				return false;
			}
			total += score;
			if(score > max)
				max = score;
			if(score < min)
				min = score;
		}
		average =  total / scores.length;
		for(float score : scores)
		{
			if(score > average)
				totalAboveAverage++;
		}
		Debug.log("Average:" + average);
		Debug.log("Min:" + min + " Max: " + max);
		Debug.log(totalAboveAverage + " scores above the average.");
		
		return true;
	}
}
