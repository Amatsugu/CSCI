package com.LuminousVector.Labs.Lab14;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.LuminousVector.Utils.Debug;

public class App
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Debug.log("Welcome to Keno");
		Debug.lognr("How many spots would you like? (1-10): ");
		int spots = in.nextInt();
		Debug.lognr("How many games would you like to play? (1-20): ");
		int plays = in.nextInt();
		Debug.lognr("How much will you bet? (1-3): ");
		int bet = in.nextInt();
		Keno kenoSlip = new Keno(spots, bet, plays);
		Debug.log("Enter your numbers seperated by commas (1-80):");
		Debug.log("Enter QUIK PIK to generate random numbers");
		String numbers = in.next();
		if(numbers.toUpperCase().equals("QUIK PIK"))
			kenoSlip.SetNumbers();
		else
		{
			String[] nums = numbers.split(Pattern.quote(","));
			Random r = new Random();
			int pos = 0;
			int[] intNums = new int[spots];
			for(String s : nums)
			{
				int n = r.nextInt(80)+1;
				try
				{
					n = Integer.parseInt(s);
				}catch(NumberFormatException e)
				{
					Debug.log("Value \'"+ s +"\' failed to pharse, ignoring...");
				}
				
				try
				{
					intNums[pos] = n;
					pos++;
				}catch(ArrayIndexOutOfBoundsException e)
				{
					Debug.log("Extra number \'"+ n +"\', ignoring...");
				}
			}
			if(pos < plays)
			{
				Debug.log("Not enough numbers provided, generating...");
				for(int i = pos; i < spots; i++)
				{
					intNums[i] = r.nextInt(80)+1;
					pos++;
				}
			}
			kenoSlip.SetNumbers(intNums);
		}
		Debug.log("Your numbers are: " + kenoSlip.getNumbers());
		Debug.log("Making " + plays + " plays...");
		int lastPlay = 0;
		while(lastPlay != -1)
		{
			lastPlay = kenoSlip.MakePlay();
		}
		Debug.log("The plays are: " + kenoSlip.getPlays());
		Debug.log("Your winnings are: $" + kenoSlip.CalculateWinnings());
		in.close();
	}
}
