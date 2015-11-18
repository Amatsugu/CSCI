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

	public void addPanel(UIPanel panel)
	{
		panels.add(panel);
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