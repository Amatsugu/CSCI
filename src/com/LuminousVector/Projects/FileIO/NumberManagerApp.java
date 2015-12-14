package com.LuminousVector.Projects.FileIO;


import com.LuminousVector.Utils.Debug;
import com.LuminousVector.Utils.FileV;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberManagerApp
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Debug.log("Enter input file: ");
		String input = in.next();
		Debug.log("Enter output fie: ");
		String output = in.next();
		try
		{
			FileV inputFile = new FileV(input);
			inputFile.OpenReader();
			ArrayList<Integer> newNumbers = NumberManager.RemoveDuplicates(inputFile.ReadAllIntLines());
			inputFile.CloseReader();

			FileV outputFile = new FileV(output);
			outputFile.OpenWriter(true);
			outputFile.WriteAllLines(newNumbers);
			outputFile.CloseWriter(true);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
