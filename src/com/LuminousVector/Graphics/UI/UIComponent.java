package com.LuminousVector.Graphics.UI;

import java.awt.Color;
import java.awt.Graphics;

import com.LuminousVector.Utils.Vector2i;

public class UIComponent
{
	private int backgroundcolor;
	protected Vector2i position, offset = Vector2i.zero;
	protected Color color;


	public UIComponent(Vector2i position)
	{
		this.position = position;
	}

	void setOffset(Vector2i offset)
	{
		this.offset = offset;
	}

	public void Update()
	{

	}

	public void Render(Graphics g)
	{

	}
}
