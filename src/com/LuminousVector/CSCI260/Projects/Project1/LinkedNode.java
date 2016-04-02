package com.LuminousVector.CSCI260.Projects.Project1;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class LinkedNode<T>
{
	public LinkedNode next;
	public LinkedNode previous;

	private T data;
	private Type type;

	//Construct the node
	public LinkedNode(T data)
	{
		this.data = data;
	}

	//Get the data
	public T getData()
	{
		return data;
	}
}
