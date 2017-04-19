package LuminousVector.CSCI151.Homework.HW4;

import java.util.Scanner;

import LuminousVector.Utils.Console;

public class TimeApp
{
	public static void main(String[] args)
	{
		boolean go = true;
		Scanner in = new Scanner(System.in);
		while (go)
		{
			Console.log("Enter a time in 24h format:");
			Time12 time = new Time12(in.next());
			Console.log("That is " + time.getTime() + " in 12h format.");
			Console.log("Again? (y/n)");
			String response = in.next();
			go = (response.equals("y"));
			Console.log(" ");
		}
		in.close();
	}
}
