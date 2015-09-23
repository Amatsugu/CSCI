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
		Debug.logln("Name: " + name);
		Debug.logln("ID: " + studentID);
		Debug.logln("Level " + level);
	}
}
