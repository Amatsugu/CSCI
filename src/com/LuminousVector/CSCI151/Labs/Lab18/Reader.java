package com.LuminousVector.CSCI151.Labs.Lab18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.LuminousVector.Utils.Console;

public class Reader
{
	private BufferedReader reader;
	public Reader(String path)
	{
		try
		{
			reader = new BufferedReader(new FileReader(path));
		}catch(Exception e)
		{
			Console.log("Failed to load file... \n" + e.getMessage());
		}
	}
	
	public void PrintAllLines()
	{
		String line = null;
		do
		{
			try
			{
				line = reader.readLine();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			if(line != null)
				Console.log(line);
		}while(line != null);
	}
	
	public void Close()
	{
		try
		{
			reader.close();
		} catch (IOException e)
		{
			
			e.printStackTrace();
		}
	}
}
