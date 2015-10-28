package com.LuminousVector.Labs.Lab18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.LuminousVector.Utils.Debug;

public class Writer
{
	private PrintWriter writer;

	public Writer(String path)
	{
		try
		{
			writer = new PrintWriter(new FileOutputStream(path));
		} catch (FileNotFoundException e)
		{
			Debug.log("File not found, creating...");
			try
			{
				writer = new PrintWriter(path, "UTF-8");
			} catch (FileNotFoundException | UnsupportedEncodingException e1)
			{
				Debug.log("Unable to Create File... " + e1.getMessage());
				e1.printStackTrace();
				writer.close();
			}
		}
	}

	public Writer(PrintWriter writer)
	{
		this.writer = writer;
	}

	public void AppendNumberRange(float start, float end, float increment)
	{
		increment = (start > end) ? -increment : increment;
		for(float i = start; i <= end; i+= increment)
		{
			writer.println(i);
		}
	}
	
	public void AppendObject(Object obj)
	{
		writer.println(obj.toString());
	}
	
	public void flush()
	{
		writer.flush();
	}
	
	public void Close()
	{
		writer.flush();
		writer.close();
	}
}
