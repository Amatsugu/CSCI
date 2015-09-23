package com.LuminousVector.Labs.Lab14;

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
		MathV.Clamp(spots, 1, 10);
		MathV.Clamp(numberOfPlays, 1, 20);
		MathV.Clamp(value, 1, 3);
		this.spots = spots;
		this.value = value;
		this.numberOfPlays = numberOfPlays;
	}
	
	public void SetNumbers(int[] numbers)
	{
		this.numbers = numbers;
		plays = new int[numbers.length];
	}
	
	public void SetNumbers()
	{
		numbers = new int[spots];
		plays = new int[spots];
		for(int i = 0; i < spots; i++)
			numbers[i] = rand.nextInt(80)+1;
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
}
