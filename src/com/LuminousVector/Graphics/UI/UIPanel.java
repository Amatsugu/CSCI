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

	public UIPanel(Vector2i position, Vector2i size, int col)
	{
		this(position, size, col, true);
	}

	public UIPanel(Vector2i position, Vector2i size, int col, boolean filled)
	{
		super(position, col);
		this.position = position;
		this.size = size;
		this.filled = filled;
	}

	public UIPanel addComponent(UIComponent component)
	{
		components.add(component);
		return this;
	}

	public UIPanel SetColor(int col)
	{
		backgroundColor = new Color(col);
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
		for(UIComponent component: components)
		{
			component.setOffset(getAnchoredPosition());
			component.Render(g);
		}
	}

	protected void DrawPanel(Graphics g)
	{
		DrawPanel(g, backgroundColor);
	}

	protected void DrawPanel(Graphics g,Color col)
	{
		g.setColor(col);
		if (filled)
			g.fillRect(getAnchoredPosition().x+offset.x, getAnchoredPosition().y+offset.y, size.x, size.y);
		else
			g.drawRect(getAnchoredPosition().x+offset.x, getAnchoredPosition().y+offset.y, size.x, size.y);
	}

	public boolean Contains(Vector2i point)
	{
		if(getAnchoredPosition().x + offset.x <= point.x && getAnchoredPosition().x + offset.x + size.x >= point.x)
			if(getAnchoredPosition().y + offset.y <= point.y && getAnchoredPosition().y + offset.y + size.y >= point.y)
				return true;
			else return false;
		else return false;
	}
}
