package com.LuminousVector.Labs.Lab1;

import java.util.Scanner;
import com.LuminousVector.Utils.Debug;;

public class App 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Debug.lognr("Enter Name: ");
		String input = in.next();
		Debug.lognr("Welcome " + input);
		in.close();
	}
}
