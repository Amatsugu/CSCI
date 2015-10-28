package com.LuminousVector.Labs.Lab18;

public class App2
{
	public static void main(String[] args)
	{
		Reader reader = new Reader("output.txt");
		reader.PrintAllLines();
		reader.Close();
	}
}
