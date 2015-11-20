package com.LuminousVector.Utils;

import java.io.*;

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
		this(path, true, true);
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

	public FileV Close(boolean flush) throws IOException
	{
		if(flush)
			writer.flush();
		if (isWriterOpen)
			writer.close();
		if (isReaderOpen)
			reader.close();
		isReaderOpen = false;
		isWriterOpen = false;
		return this;
	}

	public FileV Close() throws IOException
	{
		Close(false);
		return this;
	}

	public FileV CloseReader() throws  IOException
	{
		reader.close();
		isReaderOpen = false;
		return this;
	}
}
