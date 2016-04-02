package com.LuminousVector.CSCI151.Homework.HW8;

import com.LuminousVector.Utils.Console;
import com.LuminousVector.Utils.FileV;

import java.io.IOException;
import java.util.Scanner;

public class SentenceReaderApp
{
	public static void main(String[] args)
	{
		FileV file;
		try
		{
			String path = "paragraph.txt";
			Console.log("Opening File... " + path);
			file = new FileV(path, false, false).OpenReader();
			String lines;
			Console.log("Reading File...");
			lines = file.ReadAllLines();
			//Console.log(lines);
			file.Close(false);
			Console.log("Reading sentences and words...");
			SentenceReader paragraph = new SentenceReader(lines);
			Console.log("Success!");
			Scanner in = new Scanner(System.in);
			int p,w;
			Console.lognr("Enter a sentence Index: ");
			p = in.nextInt();
			Console.lognr("Enter a word Index: ");
			w = in.nextInt();
			try
			{
				Console.log("The word at ("+p+","+w+") is: " + paragraph.GetWord(p,w));
			}catch (Exception e)
			{
				Console.log(e.getMessage());
			}

		}catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}
