package com.LuminousVector.Labs.Lab18;

public class ReaderApp
{
	public static void main(String[] args)
	{
		Reader reader = new Reader("output.txt");
		reader.PrintAllLines();
		reader.Close();
	}
}