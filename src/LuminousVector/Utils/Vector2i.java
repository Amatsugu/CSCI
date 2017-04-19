package LuminousVector.Utils;

public class Vector2i
{
	public static final Vector2i zero = new Vector2i(0,0);
	public int x, y;

	public Vector2i()
	{
		Set(x, y);
	}

	public Vector2i(int size)
	{
		this(size,size);
	}

	public Vector2i(int x, int y)
	{
		Set(x, y);
	}


	public Vector2i(Vector2i vector)
	{
		Set(vector.x, vector.y);
	}

	public Vector2i Add(Vector2i vector)
	{
		this.x += vector.x;
		this.y += vector.y;
		return this;
	}

	public Vector2i Subtract(Vector2i vector)
	{
		this.x -= vector.x;
		this.y -= vector.y;
		return this;
	}

	public Vector2i SetX(int x)
	{
		this.x = x;
		return this;
	}

	public Vector2i SetY(int y)
	{
		this.y = y;
		return this;
	}

	public Vector2i Set(int x, int y)
	{
		this.x = x;
		this.y = y;
		return this;
	}

	public static double Distance(Vector2i a, Vector2i b)
	{
		int dx = a.x - b.x;
		int dy = a.y - b.y;
		return Math.sqrt((dx * dx) + (dy * dy));
	}

	public boolean equals(Object object)
	{
		if(!(object instanceof Vector2i))
			return false;
		Vector2i vec = (Vector2i) object;
		if(vec.x == this.x && vec.x == this.x)
			return true;
		return false;
	}
}
