package LuminousVector.CSCI151.Labs.Lab14;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import LuminousVector.Utils.Console;

public class KenoApp
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Console.log("Welcome to Keno");
		Console.lognr("How many spots would you like? (1-10): ");
		int spots = in.nextInt();
		Console.lognr("How many games would you like to play? (1-20): ");
		int plays = in.nextInt();
		Console.lognr("How much will you bet? (1-3): ");
		int bet = in.nextInt();
		Keno kenoSlip = new Keno(spots, bet, plays);
		Console.log("Enter your numbers seperated by commas (1-80):");
		Console.log("Enter QUIK PIK to generate random numbers");
		String numbers = in.next();
		if(numbers.toUpperCase().equals("QUIKPIK"))
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
					Console.log("Value \'"+ s +"\' failed to pharse, ignoring...");
				}
				
				try
				{
					intNums[pos] = n;
					pos++;
				}catch(ArrayIndexOutOfBoundsException e)
				{
					Console.log("Extra number \'"+ n +"\', ignoring...");
				}
			}
			if(pos < plays)
			{
				Console.log("Not enough numbers provided, generating...");
				for(int i = pos; i < spots; i++)
				{
					intNums[i] = r.nextInt(80)+1;
					pos++;
				}
			}
			kenoSlip.SetNumbers(intNums);
		}
		Console.log("Your numbers are: " + kenoSlip.getNumbers());
		Console.log("Making " + plays + " plays...");
		int lastPlay = 0;
		while(lastPlay != -1)
		{
			lastPlay = kenoSlip.MakePlay();
		}
		Console.log("The plays are: " + kenoSlip.getPlays());
		Console.log("Your winnings are: $" + kenoSlip.CalculateWinnings());
		in.close();
	}
}
