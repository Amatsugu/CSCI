package com.LuminousVector.Excersies.Sudoku;

import com.LuminousVector.Graphics.UI.UILabel;
import com.LuminousVector.Graphics.UI.UIManager;
import com.LuminousVector.Graphics.UI.UIPanel;
import com.LuminousVector.Utils.Vector2i;

import java.awt.*;
import java.util.Random;

public class GameBoard
{
	private int[] tiles = new int[9*9];
	private int tileSize = 25;
	private int tileSpacing = 5;
	private int x,y;

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
		for (int x = 0; x < 9; x++)
		{

			for (int y = 0; y < 9; y++)
			{
				Vector2i pos = new Vector2i(this.x + (x*(tileSize+tileSpacing)), this.y + (y*(tileSize+tileSpacing)));
				String curTile = (tiles[x+y*9] <= 0) ? " " : tiles[x+y*9] + "";
				UIPanel panel = new UIPanel(pos, new Vector2i(tileSize, tileSize), 0xff00ff, false).addComponent(new UILabel(Vector2i.zero,curTile));
				ui.addPanel(panel);
			}
		}
	}

	public void Update()
	{

	}

	public void Render(Screen screen, Graphics g)
	{

		/*for (int x = 0; x < 9; x++)
		{
			for (int y = 0; y < 9; y++)
			{
				int xp = this.x + (x*(tileSize+tileSpacing));
				int yp = this.y + (y*(tileSize+tileSpacing));
				screen.DrawRect(xp, yp, tileSize, tileSize, 0xff00ff);
				String curTile = (tiles[x+y*9] <= 0) ? " " : tiles[x+y*9] + "";
				g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
				g.drawString(curTile, xp, yp);
			}
		}*/
	}
}
