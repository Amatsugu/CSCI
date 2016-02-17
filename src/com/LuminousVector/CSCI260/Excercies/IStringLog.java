package com.LuminousVector.CSCI260.Excercies;

public interface IStringLog
{
	boolean insert(String string);

	boolean contains(String string);

	int size();

	String toString();

	String getName();

	IStringLog clear();
}
