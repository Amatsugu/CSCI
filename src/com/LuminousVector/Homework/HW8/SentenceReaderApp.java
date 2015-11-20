package com.LuminousVector.Homework.HW8;

import com.LuminousVector.Utils.Debug;
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
			Debug.log("Opening File... " + path);
			file = new FileV(path, false, false).OpenReader();
			String lines;
			Debug.log("Reading File...");
			lines = file.ReadAllLines();
			//Debug.log(lines);
			file.Close(false);
			Debug.log("Reading sentences and words...");
			SentenceReader paragraph = new SentenceReader(lines);
			Debug.log("Success!");
			Scanner in = new Scanner(System.in);
			int p,w;
			Debug.lognr("Enter a sentence Index: ");
			p = in.nextInt();
			Debug.lognr("Enter a word Index: ");
			w = in.nextInt();
			try
			{
				Debug.log("The word at ("+p+","+w+") is: " + paragraph.GetWord(p,w));
			}catch (Exception e)
			{
				Debug.log(e.getMessage());
			}

		}catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}
