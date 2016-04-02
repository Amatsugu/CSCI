package com.LuminousVector.CSCI260.Projects.Project1;

import com.LuminousVector.Utils.Console;

import java.util.Collection;

public class LinkedList<T>
{
	public LinkedNode<T> first;

	//Count all the elements in the list
	public int size()
	{
		int count = 0;
		LinkedNode<T> node = first;
		do
		{
			count++;
			node = node.next;
		}while (node != first);
		return count;
	}

	//Find an element based on it's data's hashcode
	public LinkedNode<T> find(int hashcode)
	{
		LinkedNode<T> node = first;
		do
		{
			if(node.getData().hashCode() == hashcode)
				return node;
			else
				node = node.next;
		}while (node != first);
		return null;
	}

	//Find an element based on it's data
	public LinkedNode<T> find(T data)
	{
		LinkedNode<T> node = first;
		do
		{
			if(node.getData().equals(data))
				return node;
			else
				node = node.next;
		}while (node != first);
		return null;
	}

	//Check if an element exists based on it's data's hashcode
	public boolean contains(int hashcode)
	{
		LinkedNode<T> node = first;
		do
		{
			if(node.getData().hashCode() == hashcode)
				return true;
			else
				node = node.next;
		}while (node != first);
		return false;
	}

	//Check if an element exists based on it's data
	public boolean contains(T data)
	{
		LinkedNode<T> node = first;
		do
		{
			if(node.getData().equals(data))
				return true;
			else
				node = node.next;
		}while (node != first);
		return false;
	}

	//Remove an element based on it's data's hashcode
	public LinkedList<T> remove(int hashcode)
	{
		LinkedNode<T> node = first;
		do
		{
			if(node.getData().hashCode() == hashcode)
			{
				remove(node);
				break;
			}
			node = node.next;
		}while (node != first);
		return this;
	}

	//Remove an element based on it's data
	public LinkedList<T> remove(T data)
	{
		LinkedNode<T> node = first;
		do
		{
			if(node.getData().equals(data))
			{
				remove(node);
				break;
			}
			node = node.next;
		}while (node != first);
		return this;
	}

	//Remove an element based on the element
	public LinkedList<T> remove(LinkedNode<T> node)
	{
		LinkedNode<T> prev, next;
		prev = node.previous;
		next = node.next;
		if(node == first)
			first = node.next;
		prev.next = node.next;
		next.previous = node.previous;

		return this;
	}

	//Add a new node to the list
	public LinkedList<T> add(LinkedNode<T> node)
	{
		if(first == null)
		{
			node.next = node;
			node.previous = node;
			first = node;
		}else
		{
			node.previous = first.previous;
			node.next = first;
			first.previous.next = node;
			first.previous = node;
		}
		return this;
	}

	//Add a new node to the list via it's data
	public LinkedList<T> add(T data)
	{
		return add(new LinkedNode<T>(data));
	}


	//Reset the list
	public LinkedList<T> reset()
	{
		first = null;
		return this;
	}
}
