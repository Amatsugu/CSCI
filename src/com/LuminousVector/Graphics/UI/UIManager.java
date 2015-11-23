package com.LuminousVector.Graphics.UI;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class UIManager
{
	public List<UIComponent> panels = new ArrayList<>();

	public UIManager()
	{

	}

	public UIManager addComponent(UIComponent panel)
	{
		panels.add(panel);
		return this;
	}

	public void Update()
	{
		for(UIComponent panel : panels)
		{
			panel.Update();
		}
	}

	public void Render(Graphics g)
	{
		for(UIComponent panel : panels)
		{
			panel.Render(g);
		}
	}
}