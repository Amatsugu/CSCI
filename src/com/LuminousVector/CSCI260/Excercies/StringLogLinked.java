package com.LuminousVector.CSCI260.Excercies;

public class StringLogLinked implements IStringLog
{
	protected String name;
	protected StringLogLinkedNode startNode;

	public StringLogLinked(String name)
	{
		this.name = name;
	}

	public boolean insert(String string)
	{
		if(startNode == null)
			startNode = new StringLogLinkedNode(string);
		StringLogLinkedNode node = startNode;
		while(node.link != null)
			node = node.link;
		node.link = new StringLogLinkedNode(string);
		return true;
	}

	public boolean uniqInsert(String element)
	{
		return !contains(element) && insert(element);
	}

	public boolean contains(String string)
	{
		if(startNode == null)
			return false;
		StringLogLinkedNode node = startNode;
		while (node.link != null)
			if(node.value.equals(string))
				return true;
			else
				node = node.link;
		return false;
	}

	public int size()
	{
		if(startNode == null)
			return 0;
		int count = 0;
		StringLogLinkedNode node = startNode;
		while (node.link != null)
		{
			node = node.link;
			count++;
		}
		return count;
	}

	public int howMany(String element)
	{
		if(startNode == null)
			return 0;
		int count = 0;
		StringLogLinkedNode node = startNode;
		while (node.link != null)
		{
			if(node.value.equals(element))
				count++;
			node = node.link;
		}
		return count;
	}

	public String smallest()
	{
		if(startNode == null)
			return null;
		StringLogLinkedNode smallest = startNode,node = startNode;
		while (node.link != null)
		{
			if(node.value.compareTo(smallest.value) < 0)
				smallest = node;
			node = node.link;
		}
		return smallest.value;
	}

	public String toString()
	{
		String out = name + ": [";
		StringLogLinkedNode node = startNode;
		do
		{
			out+=node.value;
			if(node.link != null)
				out+=", ";
			node = node.link;
		}while (node.link != null);
		name+="]";
		return out;
	}

	public String getName()
	{
		return name;
	}

	public IStringLog clear()
	{
		startNode = null;
		return this;
	}
}
