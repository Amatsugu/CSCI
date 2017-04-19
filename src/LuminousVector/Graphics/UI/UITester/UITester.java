package LuminousVector.Graphics.UI.UITester;

import LuminousVector.Utils.Keyboard;
import LuminousVector.Graphics.UI.*;
import LuminousVector.Utils.Vector2f;
import LuminousVector.Utils.Vector2i;

import java.util.ArrayList;

class UITester
{
	private ArrayList<UIButton> buttons = new ArrayList<>();
	UITester()
	{
		int buttonSize = 100;
		int buttonPadding = 5;
		UIManager _ui;
		_ui = UITesterApp.getUIManager();
		UIPanel main = new UIPanel(Vector2i.zero, new Vector2i(UITesterApp.GetWidth(), UITesterApp.GetHeight()), 0x100010);
		UIPanel outputPanel = new UIPanel(new Vector2i(UITesterApp.GetWidth()/2, 50), new Vector2i(UITesterApp.GetWidth() - 100, 100), 0xaaaaaa);
		outputPanel.setAnchor(new Vector2f(.5f,0));
		main.addComponent(outputPanel);
		_ui.addComponent(main);
		_ui.addComponent(new UITextField(new Vector2i(0,0), new Vector2i(200, 30), 0xaaaaaa, 0xffffff));
		UIPanel buttonPanel = new UIPanel(new Vector2i(UITesterApp.GetWidth()/2 ,150), new Vector2i(UITesterApp.GetWidth()-100, UITesterApp.GetHeight()-200), 0x555555);
		buttonPanel.setAnchor(new Vector2f(0.5f,0));
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				Vector2i pos = new Vector2i(-buttonPadding - (buttonSize+buttonPadding) * (x+1) + buttonPanel.getSize().x, buttonPadding + (buttonSize+buttonPadding) * y);
				UIButton button = new UIButton(pos, new Vector2i(buttonSize), 0xbbbbbb, 0xeeeeee,0x555555, (x*y) + "", 0x0, buttonSize/2);
				button.setAnchor(new Vector2f(1f,0f));
				buttons.add(button);
				buttonPanel.addComponent(button);
			}
		}
		_ui.addComponent(buttonPanel);
		_ui.addComponent(new UITextField(new Vector2i(100,100), new Vector2i(200, 50), 0xff00ff, 0xffff));

	}

	public void Update(Keyboard key)
	{
		for (UIButton b : buttons)
		{
			if (b.wasClicked)
			{
				//TODO: make click event
			}
		}

	}
}
