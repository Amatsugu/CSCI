package com.LuminousVector.Excersies.Tree;

import com.LuminousVector.Utils.Debug;

public class DrawTreeApp
{
	public static void main(String[] args)
	{
		Square square = new Square(2, 10);
		square.drawHere();
		Debug.log("Area:" + square.getArea());
		Debug.log("Perimeter:" + square.getPerimeter());
		Debug.log("-----------------------------------------------------");
		RightTriangle tri= new RightTriangle(2, 10);
		tri.drawHere();
		Debug.log("Area:" + tri.getArea());
		Debug.log("Perimeter:" + tri.getPerimeter());
	}
}
