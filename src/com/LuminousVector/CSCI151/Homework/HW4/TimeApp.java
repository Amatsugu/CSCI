package com.LuminousVector.CSCI151.Homework.HW4;

import java.util.Scanner;

import com.LuminousVector.Utils.Debug;

public class TimeApp
{
	public static void main(String[] args)
	{
		boolean go = true;
		Scanner in = new Scanner(System.in);
		while (go)
		{
			Debug.log("Enter a time in 24h format:");
			Time12 time = new Time12(in.next());
			Debug.log("That is " + time.getTime() + " in 12h format.");
			Debug.log("Again? (y/n)");
			String response = in.next();
			go = (response.equals("y"));
			Debug.log(" ");
		}
		in.close();
	}
}
