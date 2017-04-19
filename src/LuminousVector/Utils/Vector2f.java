package LuminousVector.Utils;

public class Vector2f
{
	public static final Vector2f zero = new Vector2f(0,0);
	public float x, y;

	public Vector2f()
	{
		Set(x, y);
	}

	public Vector2f(float size)
	{
		this(size,size);
	}

	public Vector2f(float x, float y)
	{
		Set(x, y);
	}


	public Vector2f(Vector2f vector)
	{
		Set(vector.x, vector.y);
	}

	public float GetX()
	{
		return x;
	}

	public float GetY()
	{
		return y;
	}

	public Vector2f Add(Vector2f vector)
	{
		this.x += vector.x;
		this.y += vector.y;
		return this;
	}

	public Vector2f Subtract(Vector2f vector)
	{
		this.x -= vector.x;
		this.y -= vector.y;
		return this;
	}

	public Vector2f Set(float x, float y)
	{
		this.x = x;
		this.y = y;
		return this;
	}

	public static double Distance(Vector2f a, Vector2f b)
	{
		float dx = a.GetX() - b.GetX();
		float dy = a.GetY() - b.GetY();
		return Math.sqrt((dx * dx) + (dy * dy));
	}

	public boolean equals(Object object)
	{
		if(!(object instanceof Vector2i))
			return false;
		Vector2i vec = (Vector2i) object;
		if(vec.x == this.GetX() && vec.y == this.GetY())
			return true;
		return false;
	}
}
