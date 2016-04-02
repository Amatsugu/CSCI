package com.LuminousVector.CSCI151.Projects.Sorting;

import com.LuminousVector.Utils.Console;

import java.util.ArrayList;

public class SortingApp
{
	public static void main(String[] args)
	{
		ArrayList<String> strings = new ArrayList<>();
		strings.add("asfghmdrthgfd");
		strings.add("AedASFDafAsfd");
		strings.add("BDSFBGdrthgfd");
		strings.add("asdfdsf2345rt");
		strings.add("bfFDSDFSDFesd");
		Console.log("UnSorted:");
		for (String s: strings)
		{
			Console.log(s);
		}
		strings = ArraySorter.SortArray(strings);
		Console.log("Sorted:");
		for (String s: strings)
		{
			Console.log(s);
		}
	}
}
