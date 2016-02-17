package com.LuminousVector.CSCI260.Excercies;

public class StringLogArray implements IStringLog
{
	protected String name;
	protected String[] log;
	protected int lastIndex = -1;

	public  StringLogArray(String name, int maxSize)
	{
		log = new String[maxSize];
		this.name = name;
	}

	public IStringLog insert(String string)
	{
		log[++lastIndex] = string;
		return this;
	}

	public boolean contains(String string)
	{
		for (String s : log)
		{
			if(s.equals(string))
				return true;
		}
		return false;
	}

	public int size()
	{
		return lastIndex+1;
	}

	public int howMany(String element)
	{
		int count = 0;
		for (String s : log)
		{
			if(s.equals(element))
				count++;
		}
		return count;
	}

	public String toString()
	{
		String out = "";


		return out;
	}

	public String getName()
	{
		return name;
	}

	public IStringLog clear()
	{
		lastIndex = -1;
		return this;
	}
}
