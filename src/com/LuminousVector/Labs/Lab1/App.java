package com.LuminousVector.Labs.Lab1;

import java.util.Scanner;
import com.LuminousVector.Utils.Debug;;

public class App 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Debug.log("Enter Name: ");
		String input = in.next();
		Debug.log("Welcome " + input);
	}
}
