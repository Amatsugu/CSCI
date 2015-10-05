package com.LuminousVector.Excersies.Tree;

public class Triangle extends ShapeBasics implements TriangleInterface
{
	protected int base;

	public Triangle()
	{
		super();
		base = 0;
	}

	public Triangle(int theOffset, int theBase)
	{
		super(theOffset);
		base = theBase;
	}

	/** Precondition: newBase is odd. */
	public void set(int newBase)
	{
		base = newBase;
	}

	public void drawHere()
	{
		drawTop();
		drawBase();
	}
	
	void drawTop()
	{
		for(int i = 0; i < base; i+=2)
		{
			skipSpaces(getOffset() + (base/2 - i/2));
			System.out.print('*');
			skipSpaces(i);
			System.out.println('*');
		}
	}

	protected void drawBase()
	{
		skipSpaces(getOffset());
		for (int count = 0; count < base; count++)
			System.out.print('*');
		System.out.println();
	}

	{
		// startOfLine == number of spaces to the
		// first '*' on a line. Initially set to the
		// number of spaces before the topmost '*'.
		int startOfLine = getOffset() + base / 2;
		skipSpaces(startOfLine);
		//System.out.println('*'); // top '*'
		int lineCount = base / 2 - 1; // height above base
		// insideWidth == number of spaces between the
		// two '*'s on a line.
		int insideWidth = 1;
		for (int count = 0; count < lineCount; count++)
		{
			// Down one line, so the first '*' is one more
			// space to the left.
			startOfLine--;
			skipSpaces(startOfLine);
			System.out.print('*');
			skipSpaces(insideWidth);
			System.out.println('*');
			// Down one line, so the inside is 2 spaces wider.
			insideWidth = insideWidth + 2;
		}
	}

	protected static void skipSpaces(int number)
	{
		for (int count = 0; count < number; count++)
			System.out.print(' ');
	}
}