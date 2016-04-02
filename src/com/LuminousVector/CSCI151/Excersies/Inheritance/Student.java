package com.LuminousVector.CSCI151.Excersies.Inheritance;

import com.LuminousVector.Utils.Console;

public class Student extends Person
{
	public String studentID;
	
	public Student(String name, String studentID)
	{
		super(name);
		this.studentID = studentID;
	}
	
	public void writeOutput()
	{
		Console.log("Name: " + name);
		Console.log("ID: " + studentID);
	}

	public void reset(String name, String studentID)
	{
		this.name = name;
		this.studentID = studentID;
	}
}
