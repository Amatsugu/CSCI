package LuminousVector.Graphics.UI;

import LuminousVector.Utils.Mouse;
import LuminousVector.Utils.Vector2i;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class UIButton extends UIPanel
{
	private Color textColor;
	private Color hoverColor;
	private Color pressedColor;
	protected String text;
	private boolean isActive;
	public boolean isToggle = false;
	public boolean wasClicked;
	public boolean hovered;
	private Font font;
	private int fontSize;


	public UIButton(Vector2i position, Vector2i size,int col1, int col2, int col3, String text)
	{
		this(position, size, col1, col2, col3, text, 0xff00ff, size.y/2);
	}

	public UIButton(Vector2i position, Vector2i size,int col1, int col2, int col3, String text, int textCol, int fontSize)
	{
		super(position, size, col1);
		hoverColor = new Color(col2);
		pressedColor = new Color(col3);
		textColor = new Color(textCol);
		filled = true;
		this.text = text;
		this.fontSize = fontSize;
		font = new Font("Oxygen Mono", Font.TRUETYPE_FONT, fontSize);
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
			wasClicked = Mouse.ButtonClicked(1);
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
		g.setFont(font);
		g.setColor(textColor);
		Rectangle2D rect = font.getStringBounds(text, ((Graphics2D)g).getFontRenderContext());
		g.drawString(text, getAnchoredPosition().x +offset.x + (int)(size.x/2f - rect.getWidth()/2f), getAnchoredPosition().y+offset.y + (int)(size.y/2f + rect.getHeight()/2f));
	}

}
