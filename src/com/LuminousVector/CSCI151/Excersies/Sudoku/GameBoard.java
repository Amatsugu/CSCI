package com.LuminousVector.CSCI151.Excersies.Sudoku;

import com.LuminousVector.Graphics.UI.UIButton;
import com.LuminousVector.Graphics.UI.UILabel;
import com.LuminousVector.Graphics.UI.UIManager;
import com.LuminousVector.Graphics.UI.UIPanel;
import com.LuminousVector.Utils.Keyboard;
import com.LuminousVector.Utils.Mouse;
import com.LuminousVector.Utils.Vector2i;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameBoard
{
	private int[] tiles = new int[9*9];
	private int tileSize = 25;
	private int tileSpacing = 5;
	private int x,y;
	private ArrayList<UIButton> gameTiles = new ArrayList<>();
	private int selectedTile = -1;

	private final int selectedColor = 0xff00ff;
	private final int defaultColor = 0x555555;

	public GameBoard(int x, int y, int tileSize, int tileSpacing)
	{
		x = (x < 0) ? SudokuApp.GetWidth()/2 - (((tileSize+tileSpacing)*9)/2) : x;
		y = (y < 0) ? SudokuApp.GetHeight()/2 - (((tileSize+tileSpacing)*9)/2) : y;
		this.x = x;
		this.y = y;
		this.tileSize = tileSize;
		this.tileSpacing = tileSpacing;
		GenerateBoard();
	}

	private void GenerateBoard()
	{
		Random rand = new Random();
		for (int x = 0; x < 9; x++)
			for(int y = 0; y < 9; y++)
				tiles[x+y * 9] = rand.nextInt(10);
		SetupBoard();
	}

	public void SetBoard(int[] tiles)
	{
		this.tiles = tiles;
	}

	private void SetupBoard()
	{
		UIManager ui = SudokuApp.getUIManager();
		ui.addComponent(new UIPanel(new Vector2i(5,5), new Vector2i(SudokuApp.GetWidth()-10, 55), 0x110011).addComponent(new UILabel(Vector2i.zero, "Sudoku", 50, 0xff00ff)));
		for (int x = 0; x < 9; x++)
		{
			//Border
			if(x % 3 == 0 && x != 0)
			{
				Vector2i pos = new Vector2i(this.x + (x*(tileSize+tileSpacing))-1, this.y - tileSpacing);
				pos.x -= tileSpacing/2;
				UIPanel yLine = new UIPanel(pos, new Vector2i(1,((tileSize+tileSpacing)*9)+(2*tileSpacing)), 0xffffff);
				ui.addComponent(yLine);
			}
			for (int y = 0; y < 9; y++)
			{
				//Border
				if(y % 3 == 0 && y != 0)
				{
					Vector2i pos = new Vector2i(this.x - tileSpacing, this.y + (y*(tileSize+tileSpacing))-1);
					pos.y -= tileSpacing/2;
					UIPanel xLine = new UIPanel(pos, new Vector2i(((tileSize+tileSpacing)*9)+(2*tileSpacing), 1), 0xffffff);
					ui.addComponent(xLine);
				}
				//tile
				Vector2i pos = new Vector2i(this.x + (x*(tileSize+tileSpacing)), this.y + (y*(tileSize+tileSpacing)));
				String curTile = (tiles[x+y*9] <= 0) ? " " : tiles[x+y*9] + "";
				UIButton button = new UIButton(pos, new Vector2i(tileSize, tileSize), defaultColor, defaultColor*2, selectedColor,tiles[x*y]+"").addComponent(new UILabel(Vector2i.zero.SetX(5),curTile));
				ui.addComponent(button);
				gameTiles.add(button);
			}
		}
	}

	public void Update(Keyboard keyboard)
	{
		Vector2i mousePos = new Vector2i(Mouse.GetX(), Mouse.GetY());
		if(selectedTile != -1)
		{
			if(keyboard.GetKey(KeyEvent.VK_0) || keyboard.GetKey(KeyEvent.VK_NUMPAD0))
			{
				tiles[selectedTile] = 0;
				gameTiles.get(selectedTile).SetText("0");
			}else if(keyboard.GetKey(KeyEvent.VK_1) || keyboard.GetKey(KeyEvent.VK_NUMPAD1))
				tiles[selectedTile] = 1;
			else if(keyboard.GetKey(KeyEvent.VK_2) || keyboard.GetKey(KeyEvent.VK_NUMPAD2))
				tiles[selectedTile] = 2;
			else if(keyboard.GetKey(KeyEvent.VK_3) || keyboard.GetKey(KeyEvent.VK_NUMPAD3))
				tiles[selectedTile] = 3;
			else if(keyboard.GetKey(KeyEvent.VK_4) || keyboard.GetKey(KeyEvent.VK_NUMPAD4))
				tiles[selectedTile] = 4;
			else if(keyboard.GetKey(KeyEvent.VK_5) || keyboard.GetKey(KeyEvent.VK_NUMPAD5))
				tiles[selectedTile] = 5;
			else if(keyboard.GetKey(KeyEvent.VK_6) || keyboard.GetKey(KeyEvent.VK_NUMPAD6))
				tiles[selectedTile] = 6;
			else if(keyboard.GetKey(KeyEvent.VK_7) || keyboard.GetKey(KeyEvent.VK_NUMPAD7))
				tiles[selectedTile] = 7;
			else if(keyboard.GetKey(KeyEvent.VK_8) || keyboard.GetKey(KeyEvent.VK_NUMPAD8))
				tiles[selectedTile] = 8;
			else if(keyboard.GetKey(KeyEvent.VK_9) || keyboard.GetKey(KeyEvent.VK_NUMPAD9))
				tiles[selectedTile] = 9;
		}
	}

	public void Render(Graphics g)
	{

	}
}
