package LuminousVector.Graphics.UI;

import LuminousVector.Graphics.UI.UITester.UITesterApp;
import LuminousVector.Utils.Console;
import LuminousVector.Utils.Mouse;
import LuminousVector.Utils.Vector2i;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UITextField extends UIButton
{

	private boolean focused = false;
	private int lastKey = -1;
	private long lastKeyTime;
	private final float keyRepeatDelay = .2f;

	public UITextField(Vector2i position, Vector2i size, int textColor, int bgColor)
	{
		super(position, size, bgColor, bgColor*2, bgColor/2, "Text", textColor, size.y/2);
	}

	public void Update()
	{
		super.Update();
		//Focus/UnFocus text field
		if(wasClicked && !focused)
		{
			Console.log("Focus");
			focused = true;
		}
		if(!Contains(Mouse.GetPos()) && Mouse.ButtonClicked(1) && focused)
		{
			Console.log("UnFocus");
			focused = false;
			lastKey = -1;
			lastKeyTime = -1l;

		}
		if(focused)
		{
			KeyEvent e = UITesterApp.getKeyBoard().curKey;
			if(e == null)
			{
				return;
			}
			Console.log("Key:" + e.getKeyLocation());
			if(lastKey == e.getExtendedKeyCode())
			{
				if(System.currentTimeMillis() - lastKeyTime < keyRepeatDelay * 1000)
				{
					return;
				}
			}
			switch (e.getExtendedKeyCode())
			{
				case KeyEvent.VK_BACK_SPACE:
					if(text.length() == 0)
					{
						break;
					}
					text = text.substring(0, text.length() - 1);
					lastKey = e.getExtendedKeyCode();
					lastKeyTime = System.currentTimeMillis();
					break;
				case KeyEvent.CHAR_UNDEFINED:
					break;
				case KeyEvent.VK_ENTER:
					focused = false;
					break;
				default:
					text += e.getKeyChar();
					lastKey = e.getExtendedKeyCode();
					lastKeyTime = System.currentTimeMillis();
					break;
			}
		}
		for(UIComponent component: components)
		{
			component.Update();
		}
	}

	public void Render(Graphics g)
	{
		hovered = focused;
		super.Render(g);
		for(UIComponent component: components)
		{
			component.setOffset(getAnchoredPosition());
			component.Render(g);
		}
	}
}
