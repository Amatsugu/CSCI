package com.LuminousVector.CSCI151.Excersies.Calculator;

import com.LuminousVector.CSCI151.Excersies.Sudoku.Keyboard;
import com.LuminousVector.Graphics.UI.UIButton;
import com.LuminousVector.Graphics.UI.UIManager;
import com.LuminousVector.Graphics.UI.UIPanel;
import com.LuminousVector.Utils.Vector2f;
import com.LuminousVector.Utils.Vector2i;

import java.util.ArrayList;

public class CalculatorUI
{
	private final int buttonSize = 100;
	private final int buttonPadding = 5;
	private UIManager _ui;
	private ArrayList<UIButton> buttons = new ArrayList<>();
	private ArrayList<CalcEntry> entries = new ArrayList<>();
	public CalculatorUI()
	{
		_ui = CalculatorApp.getUIManager();
		UIPanel main = new UIPanel(Vector2i.zero, new Vector2i(CalculatorApp.GetWidth(), CalculatorApp.GetHeight()), 0x100010);
		UIPanel outputPanel = new UIPanel(new Vector2i(CalculatorApp.GetWidth()/2, 50), new Vector2i(CalculatorApp.GetWidth() - 100, 100), 0xaaaaaa);
		outputPanel.setAnchor(new Vector2f(.5f,0));
		main.addComponent(outputPanel);
		_ui.addComponent(main);
		UIPanel buttonPanel = new UIPanel(new Vector2i(CalculatorApp.GetWidth()/2 ,150), new Vector2i(CalculatorApp.GetWidth()-100, CalculatorApp.GetHeight()-200), 0x555555);
		buttonPanel.setAnchor(new Vector2f(0.5f,0));
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				Vector2i pos = new Vector2i(-buttonPadding - (buttonSize+buttonPadding) * (x+1) + buttonPanel.getSize().x, buttonPadding + (buttonSize+buttonPadding) * y);
				UIButton button = new UIButton(pos, new Vector2i(buttonSize), 0xbbbbbb, 0xeeeeee,0x555555, (x*y) + "");
				button.setAnchor(new Vector2f(1f,0f));
				buttons.add(button);
				buttonPanel.addComponent(button);
			}
		}
		_ui.addComponent(buttonPanel);

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
