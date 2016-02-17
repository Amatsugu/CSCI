package com.LuminousVector.CSCI151.Projects.Sorting;

import com.LuminousVector.Utils.Debug;

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
		Debug.log("UnSorted:");
		for (String s: strings)
		{
			Debug.log(s);
		}
		strings = ArraySorter.SortArray(strings);
		Debug.log("Sorted:");
		for (String s: strings)
		{
			Debug.log(s);
		}
	}
}
