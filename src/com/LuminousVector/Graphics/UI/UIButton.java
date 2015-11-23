package com.LuminousVector.Graphics.UI;

import com.LuminousVector.Excersies.Sudoku.Mouse;
import com.LuminousVector.Utils.Vector2i;

import java.awt.*;

public class UIButton extends UIPanel
{
	private Color textColor;
	private Color hoverColor;
	private Color pressedColor;
	private String text;
	private boolean isActive;
	public boolean isToggle = false;
	public boolean wasClicked;
	public boolean hovered;


	public UIButton(Vector2i position, Vector2i size,int col1, int col2, int col3, String text)
	{
		this(position, size, col1, col2, col3, text, 0xff00ff);
	}

	public UIButton(Vector2i position, Vector2i size,int col1, int col2, int col3, String text, int textCol)
	{
		super(position, size, col1);
		hoverColor = new Color(col2);
		pressedColor = new Color(col3);
		textColor = new Color(textCol);
		filled = true;
		this.text = text;
	}

	public UIButton addComponent(UIComponent component)
	{
		components.add(component);
		return this;
	}

	public void SetText(String text)
	{
		this.text = text;
	}


	public void Update()
	{
		if(Contains(Mouse.GetPos()))
		{
			hovered = true;
			if(Mouse.ButtonClicked(1))
			{
				wasClicked = true;
			}else
				wasClicked = false;
		}else
			hovered = false;
	}

	public void Render(Graphics g)
	{
		if (hovered)
			if (wasClicked)
				DrawPanel(g, pressedColor);
			else
				DrawPanel(g, hoverColor);
		else
			DrawPanel(g);
	}

}
