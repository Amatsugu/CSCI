package LuminousVector.CSCI260.Excercies;

public class ArrayQueue<T>
{

	private T[] queue;
	private int startCapacity;
	private int front, back;
	private boolean unbounded = false;
	public ArrayQueue(int capacity)
	{
		startCapacity = capacity;
		queue = (T[])new Object[capacity];
		front = 0;
		back = capacity - 1;
	}

	public ArrayQueue()
	{
		this(1);
		unbounded = true;
		back = -1;
	}

	public void enqueue(T item)
	{

	}

	public T dequeue() throws UnderflowException
	{
		return null;
	}

	public boolean isEmpty()
	{
		return false;
	}
}
