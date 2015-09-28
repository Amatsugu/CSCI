package com.LuminousVector.Excersies.Inheritance;

import com.LuminousVector.Utils.Debug;

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
		Debug.log("Name: " + name);
		Debug.log("ID: " + studentID);
		Debug.log("Level " + level);
	}
}
