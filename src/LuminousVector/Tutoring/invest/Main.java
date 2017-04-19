package LuminousVector.Tutoring.invest;

import LuminousVector.Utils.Console;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Console.lognr("Enter Filename:");
		String filename = in.nextLine();

		try
		{
			TotalInvestment totalInvestment = new TotalInvestment(filename);
		} catch (Exception e)
		{
			Console.log("Unable to read file: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
