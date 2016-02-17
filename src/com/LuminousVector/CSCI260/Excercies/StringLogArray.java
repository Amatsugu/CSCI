package com.LuminousVector.CSCI260.Excercies;

public class StringLogArray implements IStringLog
{
	protected String name;
	protected String[] log;
	protected int lastIndex = -1;

	public StringLogArray(String name, int maxSize)
	{
		log = new String[maxSize];
		this.name = name;
	}

	public boolean insert(String string)
	{
		if(lastIndex+1 == log.length)
			return false;
		log[++lastIndex] = string;
		return true;
	}

	public boolean uniqInsert(String element)
	{
		return !contains(element) && insert(element);
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
		if(lastIndex == -1)
			return 0;
		int count = 0;
		for (String s : log)
		{
			if(s.equals(element))
				count++;
		}
		return count;
	}

	public String smallest()
	{
		if(lastIndex == -1)
			return null;
		String smallest = log[1];
		for (String s : log)
		{
			if(s.compareTo(s) < 0)
				smallest = s;
		}
		return smallest;
	}

	public String toString()
	{
		String out = name + ": [";
		for (int i = 0; i <= lastIndex; i++)
		{
			out+=log[i];
			if(i != lastIndex)
				out+=", ";
		}
		out+="]";
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
