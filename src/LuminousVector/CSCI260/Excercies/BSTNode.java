package LuminousVector.CSCI260.Excercies;

public class BSTNode<T extends Comparable<T>>
{
	public BSTNode<T> left,right;

	protected T info;

	public BSTNode(T info)
	{
		this.info = info;
		left = right = null;
	}
}
