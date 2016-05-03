package com.LuminousVector.CSCI260.Excercies;

public interface IBinarySearchTree<T extends Comparable<T>>
{
	public static final int IN_ORDER = 1, PRE_ORDER = 2, POST_ORDER = 3;

	public int size();

	public boolean isEmpty();
}
