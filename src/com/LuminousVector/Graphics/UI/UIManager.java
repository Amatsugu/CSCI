package com.LuminousVector.Graphics.UI;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class UIManager
{
	public List<UIPanel> panels = new ArrayList<UIPanel>();

	public UIManager()
	{

	}

	public UIManager addPanel(UIPanel panel)
	{
		panels.add(panel);
		return this;
	}

	public void Update()
	{
		for(UIPanel panel : panels)
		{
			panel.Update();
		}
	}

	public void Render(Graphics g)
	{
		for(UIPanel panel : panels)
		{
			panel.Render(g);
		}
	}
}