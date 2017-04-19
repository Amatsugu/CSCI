package LuminousVector.Graphics.UI;

import java.awt.Color;
import java.awt.Graphics;

import LuminousVector.Utils.Vector2f;
import LuminousVector.Utils.Vector2i;

public class UIComponent
{
	protected Vector2i position, offset = Vector2i.zero;
	protected Color color;
	protected Color backgroundColor;
	protected Vector2f anchor = Vector2f.zero;
	protected Vector2i size;



	public UIComponent(Vector2i position)
	{
		this(position, 0x0, 0x0);
	}
	public UIComponent(Vector2i position, int bgCol)
	{
		this(position, bgCol, 0x0);
	}
	public UIComponent(Vector2i position, int bgCol, int col)
	{
		this.position = position;
		this.backgroundColor = new Color(bgCol);
		this.color = new Color(col);
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
		Vector2i pos = new Vector2i(position.x, position.y);
		pos.x -= size.x * anchor.x;
		pos.y -= size.y * anchor.y;
		return pos;
	}
}
