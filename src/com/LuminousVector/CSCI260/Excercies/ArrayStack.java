package com.LuminousVector.CSCI260.Excercies;

import java.util.ArrayList;

public class ArrayStack<T>
{
	private ArrayList<T> stack;

	public ArrayStack()
	{
		stack = new ArrayList<>();
	}

	public void popSome(int n) throws UnderflowException
	{
		if(size() < n)
			throw new UnderflowException("Attempting to pop more elements than are on the stack");
		for (int i = 1; i <= n; i++)
			pop();
	}

	public int size()
	{
		return stack.size();
	}

	public T top() throws EmptyStackException
	{
		if(!isEmpty())
			return stack.get(stack.size()-1);
		else
			throw new EmptyStackException("Stack is empty");
	}

	public void pop() throws UnderflowException
	{
		if(!isEmpty())
			stack.remove(stack.size()-1);
		else
			throw new UnderflowException("Stack is empty");
	}

	public void push(T element)
	{
		stack.add(element);
	}

	public boolean isEmpty()
	{
		return (stack.isEmpty());
	}
}
