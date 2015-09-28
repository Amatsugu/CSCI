package com.LuminousVector.Excersies.Inheritance;

import com.LuminousVector.Utils.Debug;

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
		Debug.logln("Name: " + name);
		Debug.logln("ID: " + studentID);
	}

	public void reset(String name, String studentID)
	{
		this.name = name;
		this.studentID = studentID;
	}
}