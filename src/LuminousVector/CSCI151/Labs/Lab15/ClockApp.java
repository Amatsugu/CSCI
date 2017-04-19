package LuminousVector.CSCI151.Labs.Lab15;

import LuminousVector.Utils.Console;

public class ClockApp
{
	public static void main(String[] args)
	{
		Clock c = new Clock(10, 56, 1);
		Console.log(c.toString());
		
		c.setHour(16);
		Console.log(c.toString());
		
		Clock c2 = new Clock();
		
		Console.log("The clocks " + (c.equals(c2) ? "are" : "are not") +  " equal.");
	}
}
