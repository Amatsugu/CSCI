package LuminousVector.CSCI151.Excersies.Tree;

public class ShapeBasics implements ShapeInterface
{
	private int offset;

	public ShapeBasics()
	{
		offset = 0;
	}

	public ShapeBasics(int theOffset)
	{
		offset = theOffset;
	}

	public void setOffset(int newOffset)
	{
		offset = newOffset;
	}

	public int getOffset()
	{
		return offset;
	}

	public void drawAt(int lineNumber)
	{
		for (int count = 0; count < lineNumber; count++)
			System.out.println();
		drawHere();
	}

	public void drawHere()
	{
		for (int count = 0; count < offset; count++)
			System.out.print(' ');
		System.out.println('*');
	}
}