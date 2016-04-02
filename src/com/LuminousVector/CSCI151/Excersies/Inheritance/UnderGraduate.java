package com.LuminousVector.CSCI151.Excersies.Inheritance;

import com.LuminousVector.Utils.Console;

public class UnderGraduate extends Student
{
	public enum Level {
		freshman,
		sophmore,
		junior,
		senior
				
	}
	public Level level; 
	
	public UnderGraduate(String name, String studentID, Level level)
	{
		super(name, studentID);
		this.level = level;
	}
	
	public void reset(String name, String studentID, Level level)
	{
		this.name = name;
		this.studentID = studentID;
		this.level = level;
	}
	
	public void writeOutput()
	{
		Console.log("Name: " + name);
		Console.log("ID: " + studentID);
		Console.log("Level " + level);
	}
}
