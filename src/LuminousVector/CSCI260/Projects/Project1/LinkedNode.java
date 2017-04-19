package LuminousVector.CSCI260.Projects.Project1;

import java.lang.reflect.Type;

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
