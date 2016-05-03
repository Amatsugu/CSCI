package com.LuminousVector.CSCI260.Excercies;

import com.LuminousVector.CSCI260.Projects.Project1.LinkedNode;

public class LinkedQueue<T>
{
	private LinkedNode<T> front;
	private int size;

	public void Enqueue(T node)
	{
		enqueue(new LinkedNode<T>(node));
	}

	public void enqueue(T data)
	{
		enqueue(new LinkedNode<T>(data));
	}

	public void enqueue(LinkedNode<T> node)
	{
		if(front == null)
			front = node;
		else
			front.next = node;
		size++;
	}

	public T dequeue() throws UnderflowException
	{
		if(size == 0)
			throw new UnderflowException("The Queue is empty.");
		T data = front.getData();
		front = front.next;
		size--;
		return data;
	}

	public int getSize()
	{
		return size;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}
}
