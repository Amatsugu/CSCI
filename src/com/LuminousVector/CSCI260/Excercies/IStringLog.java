package com.LuminousVector.CSCI260.Excercies;

public interface IStringLog
{
	IStringLog insert(String string);

	boolean contains(String string);

	int size();

	String toString();

	String getName();

	IStringLog clear();
}
