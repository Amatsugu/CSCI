package LuminousVector.CSCI151.Excersies.Tree;

import LuminousVector.Utils.Console;

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
		Console.log("");
		for(int i = 0; i < base; i++)
		{
			skipSpaces(getOffset());
			Console.lognr('*');
			skipSpaces(i);
			Console.log('*');
		}
	}
	
	protected void drawBase()
	{
		skipSpaces(getOffset());
		for(int i = 0; i < base; i++)
			Console.lognr("*");
		Console.log("*");
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
