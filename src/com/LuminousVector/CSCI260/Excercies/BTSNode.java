package com.LuminousVector.CSCI260.Excercies;

public class BTSNode<T extends Comparable<T>>
{
	public BTSNode<T> left;
	public BTSNode<T> right;

	protected T info;

	public  BTSNode(T info)
	{
		this.info = info;
		left = right = null;
	}
}
