package com.LuminousVector.Graphics.UI;

import java.awt.Color;
import java.awt.Graphics;

import com.LuminousVector.Utils.Vector2f;
import com.LuminousVector.Utils.Vector2i;

public class UIComponent
{
	private int backgroundcolor;
	protected Vector2i position, offset = Vector2i.zero;
	protected Color color;
	protected Vector2f anchor = Vector2f.zero;
	protected Vector2i size;



	public UIComponent(Vector2i position)
	{
		this.position = position;
	}

	void setOffset(Vector2i offset)
	{
		this.offset = offset;
	}

	public void setAnchor(Vector2f anchor) { this.anchor = anchor; }

	public void Update()
	{

	}

	public Vector2i getSize()
	{
		return size;
	}

	public void Render(Graphics g)
	{

	}

	protected Vector2i getAnchoredPosition()
	{
		Vector2i pos = new Vector2i(position.GetX(), position.GetY());
		pos.x -= size.x * anchor.x;
		pos.y -= size.y * anchor.y;
		return pos;
	}
}
