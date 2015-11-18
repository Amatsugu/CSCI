package com.LuminousVector.Excersies.Sudoku;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener
{
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;

	public static int GetX()
	{
		return mouseX;
	}

	public static int GetY()
	{
		return mouseY;
	}

	public static int GetButton()
	{
		return mouseB;
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
	}

	public void mouseReleased(MouseEvent e)
	{
		mouseB = -1;
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
