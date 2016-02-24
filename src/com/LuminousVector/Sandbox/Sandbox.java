package com.LuminousVector.Sandbox;

import com.LuminousVector.Utils.Debug;

public class Sandbox
{
	public static void main(String[] args)
	{
		Debug.log(TriPower(3));
	}
	static int TriPower(int n)
	{
		if(n == 0)
			return 1;
		if(n == 1)
			return 3;
		return 3 * TriPower(n-1);
	}

	private static String indent = "";

	static int factorial(int n)
	{
		Debug.log(indent + "Sandbox: " + n);
		indent += "\t";
		int val = (n == 0) ? 1 : n * factorial(n-1);
		indent = indent.substring(1);
		Debug.log(indent + "Return " + val);
		return val;
	}
}
