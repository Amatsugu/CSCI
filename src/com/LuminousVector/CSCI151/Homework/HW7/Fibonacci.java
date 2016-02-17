package com.LuminousVector.CSCI151.Homework.HW7;

import com.LuminousVector.Utils.Debug;

public class Fibonacci
{
	private static long[] _lastSequence;

	private Fibonacci(){}

	public static long getNumber(int index)
	{
		if(_lastSequence != null)
		{
			if (_lastSequence.length >= index)
				return _lastSequence[index - 1];
		}
		_lastSequence = new long[index];
		_lastSequence[0] = 0;
		_lastSequence[1] = 1;
		Debug.log("Calculating...");
		iterate(2);
		return _lastSequence[index-1];
	}

	private static void iterate(int curIndex)
	{
		_lastSequence[curIndex] = _lastSequence[curIndex-1] + _lastSequence[curIndex-2];
		curIndex++;
		if(curIndex < _lastSequence.length)
			iterate(curIndex);
	}
}
