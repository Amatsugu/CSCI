package com.LuminousVector.Graphics.UI;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.LuminousVector.Utils.Vector2i;

public class UIPanel
{
	private List<UIComponent> components = new ArrayList<UIComponent>();
	private Vector2i position, size;

	private Color color;

	public UIPanel(Vector2i position, Vector2i size)
	{
		this.position = position;
		this.size = size;
		color = new Color(0xaaaaaa);
	}

	public void addComponent(UIComponent component)
	{
		components.add(component);
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
		//screen.RenderSprite(position.x, position.y, sprite, false);
		g.setColor(color);
		g.fillRect(position.x, position.y, size.x, size.y);
		for(UIComponent component: components)
		{
			component.setOffset(position);
			component.Render(g);
		}
	}
}
