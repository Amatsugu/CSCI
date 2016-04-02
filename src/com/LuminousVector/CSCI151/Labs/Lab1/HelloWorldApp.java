package com.LuminousVector.CSCI151.Labs.Lab1;

import java.util.Scanner;

import com.LuminousVector.Utils.Console;

public class HelloWorldApp
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Console.lognr("Enter Name: ");
		String input = in.next();
		Console.lognr("Welcome " + input);
		in.close();
	}
}
