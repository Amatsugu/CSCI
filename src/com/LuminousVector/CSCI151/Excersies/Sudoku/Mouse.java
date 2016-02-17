package com.LuminousVector.CSCI151.Excersies.Sudoku;

import com.LuminousVector.Utils.Vector2i;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener
{
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	private static boolean mouseClicked = false;

	public static int GetX()
	{
		return mouseX;
	}

	public static int GetY()
	{
		return mouseY;
	}

	public static Vector2i GetPos() { return new Vector2i(mouseX, mouseY);}

	public static int GetButton()
	{
		return mouseB;
	}

	public static boolean ButtonClicked(int button)
	{
		if (mouseB == button)
			return mouseClicked;
		else return false;
	}

	public void mouseDragged(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mousePressed(MouseEvent e)
	{
		mouseB = e.getButton();
		mouseClicked = true;
	}

	public void mouseReleased(MouseEvent e)
	{
		mouseB = -1;
		mouseClicked = false;
	}

	public void mouseClicked(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e)
	{

	}

	public void mouseExited(MouseEvent e)
	{

	}
}
