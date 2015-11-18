package com.LuminousVector.Utils;

public class Vector2i
{
	public int x, y;

	public Vector2i()
	{
		Set(x, y);
	}

	public Vector2i(int x, int y)
	{
		Set(x, y);
	}

	public Vector2i(Vector2i vector)
	{
		Set(vector.x, vector.y);
	}

	public int GetX()
	{
		return x;
	}

	public int GetY()
	{
		return y;
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
		int dx = a.GetX() - b.GetX();
		int dy = a.GetY() - b.GetY();
		return Math.sqrt((dx * dx) + (dy * dy));
	}

	public boolean equals(Object object)
	{
		if(!(object instanceof Vector2i))
			return false;
		Vector2i vec = (Vector2i) object;
		if(vec.GetX() == this.GetX() && vec.GetY() == this.GetY())
			return true;
		return false;
	}
}
