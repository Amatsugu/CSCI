package LuminousVector.CSCI151.Excersies.Tree;

public interface ShapeInterface
{
	/**
	 * Sets the offset for the shape.
	 */
	void setOffset(int newOffset);

	/**
	 * Returns the offset for the shape.
	 */
	int getOffset();

	/**
	 * Draws the shape at lineNumber lines down from the current line.
	 */
	void drawAt(int lineNumber);

	/**
	 * Draws the shape at the current line.
	 */
	void drawHere();
}