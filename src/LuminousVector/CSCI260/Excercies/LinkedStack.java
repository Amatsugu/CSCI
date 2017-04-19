package LuminousVector.CSCI260.Excercies;

import LuminousVector.CSCI260.Projects.Project1.LinkedNode;

public class LinkedStack<T>
{
	private LinkedNode<T> top;

	public void push(T data)
	{
		push(new LinkedNode<T>(data));
	}

	public void push(LinkedNode<T> node)
	{
		if(top == null)
			top = node;
		else
		{
			node.next = top;
			top = node;
		}
	}

	public void pop()
	{
		if(top == null)
			throw new UnderflowException("The Stack is empty");
		else
			top = top.next;
	}

	public T top()
	{
		if(top == null)
			throw new UnderflowException("The stack is empty");
		return top.getData();
	}

	public boolean isEmpty()
	{
		return top == null;
	}
}
