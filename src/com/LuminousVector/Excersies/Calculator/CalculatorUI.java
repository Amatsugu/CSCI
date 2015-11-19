package com.LuminousVector.Excersies.Calculator;

import com.LuminousVector.Excersies.Sudoku.Keyboard;
import com.LuminousVector.Graphics.UI.UIButton;
import com.LuminousVector.Graphics.UI.UILabel;
import com.LuminousVector.Graphics.UI.UIManager;
import com.LuminousVector.Graphics.UI.UIPanel;
import com.LuminousVector.Utils.IKeyEvent;
import com.LuminousVector.Utils.Vector2i;

import java.awt.*;
import java.util.ArrayList;

public class CalculatorUI
{
	private final int buttonSize = 100;
	private final int buttonPadding = 5;
	private UIManager _ui;
	private ArrayList<UIButton> buttons = new ArrayList<UIButton>();
	public CalculatorUI()
	{
		_ui = CalculatorApp.getUIManager();
		_ui.addPanel(new UIPanel(new Vector2i(0,0), new Vector2i(CalculatorApp.GetWidth(), CalculatorApp.GetHeight()), 0x100010));
		int buttonPanelSize = ((buttonPadding + buttonSize)*4) + buttonPadding;
		UIPanel buttonPanel = new UIPanel(new Vector2i(50,150), new Vector2i(buttonPanelSize), 0x555555);
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				Vector2i pos = new Vector2i(buttonPadding + (buttonSize+buttonPadding) * x, buttonPadding + (buttonSize+buttonPadding) * y);
				UIButton button = new UIButton(pos, new Vector2i(buttonSize), 0xbbbbbb, 0xeeeeee,0x555555, (x*y) + "");
				buttons.add(button);
				buttonPanel.addComponent(button);
			}
		}
		_ui.addPanel(buttonPanel);
	}

	public void Update(Keyboard key)
	{
		for (UIButton b : buttons)
		{
			if (b.wasClicked)
			{

			}
		}

	}
}
