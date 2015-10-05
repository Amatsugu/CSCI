package com.LuminousVector.Excersies.Tree;

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
		for(int i = 0; i < base; i++)
		{
			skipSpaces(getOffset());
			System.out.print('*');
			skipSpaces(i);
			System.out.println('*');
		}
	}
}
