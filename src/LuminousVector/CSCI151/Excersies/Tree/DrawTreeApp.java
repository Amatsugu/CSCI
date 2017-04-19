package LuminousVector.CSCI151.Excersies.Tree;

import LuminousVector.Utils.Console;

public class DrawTreeApp
{
	public static void main(String[] args)
	{
		Square square = new Square(2, 10);
		square.drawHere();
		Console.log("Area:" + square.getArea());
		Console.log("Perimeter:" + square.getPerimeter());
		Console.log("-----------------------------------------------------");
		RightTriangle tri= new RightTriangle(2, 10);
		tri.drawHere();
		Console.log("Area:" + tri.getArea());
		Console.log("Perimeter:" + tri.getPerimeter());
	}
}
