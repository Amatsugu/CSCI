package com.LuminousVector.Utils;

import java.io.*;
import java.util.ArrayList;

public class FileV
{
	private String path;
	private BufferedReader reader;
	private PrintWriter writer;
	private boolean isReaderOpen = false;
	private boolean isWriterOpen = false;

	public FileV(String path, boolean open, boolean create) throws IOException
	{
		this.path = path;
		if (open)
			OpenReader().OpenWriter(create);
	}

	public FileV(String path) throws IOException
	{
		this(path, false, false);
	}

	public FileV OpenReader() throws FileNotFoundException
	{

		reader = new BufferedReader(new FileReader(path));
		isReaderOpen = true;
		return this;
	}

	public FileV OpenWriter(boolean create) throws IOException
	{
		File file = new File(path);
		if(!file.exists() && create)
			file.createNewFile();
		writer = new PrintWriter(new FileWriter(file));
		isWriterOpen = true;
		return this;
	}

	public void WriteAllIntLines(ArrayList<Integer> lines) throws IOException
	{
		for (Integer i : lines)
		{
			writer.append(i.toString()+"\n");
		}
	}

	public void WriteAllLines(String[] lines) throws IOException
	{
		for (String l : lines)
		{
			writer.append(l+"\n");
		}
	}

	public String ReadAllLines() throws IOException
	{
		if(!isReaderOpen)
			throw new FileReaderNotOpenException();
		String curLine;
		String out = "";
		do
		{
			curLine = reader.readLine();
			out += curLine + "\n";
		}while (curLine != null);
		return out;
	}

	public ArrayList<Integer> ReadAllIntLines() throws IOException
	{
		if(!isReaderOpen)
			throw new FileReaderNotOpenException();
		ArrayList<Integer> lines = new ArrayList<>();
		int curInt;
		String curLn;
		do
		{
			curLn = reader.readLine();
			try
			{
				curInt = Integer.parseInt(curLn);
			}catch (Exception e)
			{
				break;
			}
			lines.add(curInt);
		}while (curLn != null);
		return  lines;
	}

	public FileV Close(boolean flush) throws IOException
	{
		CloseWriter(flush);
		CloseReader();
		return this;
	}


	public FileV Close() throws IOException
	{
		Close(false);
		return this;
	}

	public FileV CloseWriter(boolean flush)
	{
		if (isWriterOpen)
		{
			if (flush)
				writer.flush();
			writer.close();
		}
		isWriterOpen = false;
		return this;
	}

	public FileV CloseReader() throws  IOException
	{
		reader.close();
		isReaderOpen = false;
		return this;
	}
}
