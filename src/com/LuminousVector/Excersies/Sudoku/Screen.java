package com.LuminousVector.Excersies.Sudoku;

public class Screen
{
	public int[] pixels;

	public int width, height;

	public Screen(int width, int height)
	{
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void Clear()
	{
		for(int i = 0; i < pixels.length; i++)
		{
			pixels[i] = 0x100010;
		}
	}

	public void DrawRect(int xp, int yp, int w, int h, int col)
	{
		for(int x = xp; x < xp + w; x++)
		{
			if(x < 0 || x >= this.width || yp >= this.height)
				continue;
			if(yp > 0)
				pixels[x + yp * this.width] = col;
			if(yp + h >= this.height)
				continue;
			if(yp + h > 0)
				pixels[x + (yp + h) * this.width] = col;
		}
		for(int y = yp; y <= yp + h; y++)
		{
			if(xp >= this.width || y < 0 || y >= this.height)
				continue;
			if(xp > 0)
				pixels[xp + y * this.width] = col;
			if(xp + w >= this.width)
				continue;
			if(xp + w > 0)
				pixels[(xp + w) + y * this.width] = col;
		}
	}

	public void DrawFilledRect(int xp, int yp, int w, int h, int col)
	{
		for(int x = xp; x <= xp + w; x++)
			for(int y = xp; y <= yp + h; y++)
				pixels[x+y * this.width] = col;
	}
}
