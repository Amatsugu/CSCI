package com.LuminousVector.Excersies.Tree;

import com.LuminousVector.Utils.Debug;

public class RightTriangle extends Triangle
{
	public RightTriangle(int offset, int base)
	{
		super(offset, base);
	}
	
	public void drawHere()
	{
		drawTop();
		drawBase();
	}
	
	void drawTop()
	{
		Debug.log("");
		for(int i = 0; i < base; i++)
		{
			skipSpaces(getOffset());
			Debug.lognr('*');
			skipSpaces(i);
			Debug.log('*');
		}
	}
	
	protected void drawBase()
	{
		skipSpaces(getOffset());
		for(int i = 0; i < base; i++)
			Debug.lognr("*");
		Debug.log("*");
	}
	
	public float getPerimeter()
	{
		return (float) ((2* base) + Math.sqrt(base*base*2)); 
	}
	
	public float getArea()
	{
		return (.5f)*(base*base);
	}
}
