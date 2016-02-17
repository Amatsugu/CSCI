package com.LuminousVector.CSCI151.Labs.Lab14;

import java.util.Random;

import com.LuminousVector.Utils.MathV;

public class Keno
{
	private int spots;
	private int value;
	private int numberOfPlays;
	private int curPlay = 0;
	private int[] numbers;
	private int[] plays;
	private Random rand = new Random();
	
	public Keno(int spots, int value, int numberOfPlays)
	{
		spots = Math.abs(spots);
		value = Math.abs(value);
		numberOfPlays = Math.abs(numberOfPlays);
		spots = MathV.Clamp(spots, 1, 10);
		numberOfPlays = MathV.Clamp(numberOfPlays, 1, 20);
		value = MathV.Clamp(value, 1, 3);
		this.spots = spots;
		this.value = value;
		this.numberOfPlays = numberOfPlays;
	}
	
	public void SetNumbers(int[] numbers)
	{
		this.numbers = numbers;
		plays = new int[numberOfPlays];
	}
	
	public void SetNumbers()
	{
		numbers = new int[spots];
		plays = new int[numberOfPlays];
		for(int i = 0; i < numberOfPlays; i++)
			numbers[i] = rand.nextInt(80)+1;
	}
	
	public String getNumbers()
	{
		String out = "[";
		for(int n : numbers)
			out += n + ",";
		out = out.substring(0, out.length()-1);
		out+= "]";
		return out;
	}
	
	public String getPlays()
	{
		String out = "[";
		for(int n : plays)
			out += n + ",";
		out = out.substring(0, out.length()-1);
		out+= "]";
		return out;
	}
	
	public float CalculateWinnings()
	{
		float winnings = 0;
		for(int p : plays)
		{
			if(contains(p, numbers))
				winnings += value;
		}
		return winnings;
	}
	
	public int MakePlay()
	{
		if(curPlay >= numberOfPlays)
			return -1;
		int play = rand.nextInt(80)+1;
		plays[curPlay] = play;
		curPlay++;
		return play;
	}
	
	boolean contains(int value, int[] array)
	{
		for(int i : array)
		{
			if(i == value)
				return true;
		}
		return false;
	}
}
