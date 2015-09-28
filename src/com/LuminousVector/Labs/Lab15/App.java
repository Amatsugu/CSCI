package com.LuminousVector.Labs.Lab15;

import com.LuminousVector.Utils.Debug;

public class App
{
	public static void main(String args[])
	{
		Clock c = new Clock(10, 56, 1);
		Debug.log(c.toString());
		
		c.setHour(16);
		Debug.log(c.toString());
		
		Clock c2 = new Clock();
		
		Debug.log("The clocks " + (c.equals(c2) ? "are" : "are not") +  " equal.");
	}
}
