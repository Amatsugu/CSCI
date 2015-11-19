package com.LuminousVector.Graphics.UI;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.LuminousVector.Utils.Vector2i;

public class UIPanel extends UIComponent
{
	public boolean filled = true;
	protected List<UIComponent> components = new ArrayList<UIComponent>();
	private Vector2i size;
	private Color color;

	public UIPanel(Vector2i position, Vector2i size, int col)
	{
		this(position, size, col, true);
	}

	public UIPanel(Vector2i position, Vector2i size, int col, boolean filled)
	{
		super(position);
		this.position = position;
		this.size = size;
		this.filled = filled;
		color = new Color(col);
	}

	public UIPanel addComponent(UIComponent component)
	{
		components.add(component);
		return this;
	}

	public UIPanel SetColor(int col)
	{
		color = new Color(col);
		return this;
	}

	public void Update()
	{
		for(UIComponent component: components)
		{
			component.Update();
		}
	}

	public void Render(Graphics g)
	{
		DrawPanel(g);
	}

	protected void DrawPanel(Graphics g)
	{
		DrawPanel(g, color);
	}

	protected void DrawPanel(Graphics g,Color col)
	{
		g.setColor(col);
		if (filled)
			g.fillRect(position.x+offset.x, position.y+offset.y, size.x, size.y);
		else
			g.drawRect(position.x+offset.x, position.y+offset.y, size.x, size.y);
		for(UIComponent component: components)
		{
			component.setOffset(position);
			component.Render(g);
		}
	}

	public boolean Contains(Vector2i point)
	{
		if(position.x + offset.x <= point.x && position.x + offset.x + size.x >= point.x)
			if(position.y + offset.y <= point.y && position.y + offset.y + size.y >= point.y)
				return true;
			else return false;
		else return false;
	}
}
