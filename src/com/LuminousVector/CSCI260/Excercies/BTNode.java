package com.LuminousVector.CSCI260.Excercies;

public class BTNode<T>
{
	public T info;
	public BTNode<T> left, right;

	public BTNode(T info)
	{
		this.info = info;
		left = right = null;
	}
}
