package com.LuminousVector.Projects.DoctorClass;

import com.LuminousVector.Excersies.Inheritance.Person;
import com.LuminousVector.Utils.Debug;

public class Doctor extends Person
{
	public String specialty;

	public Doctor(String name)
	{
		this(name, 0, null, null);
	}

	public Doctor(String name, String specialty)
	{
		this(name, 0, null, specialty);
	}

	public Doctor(String name, int age, String specialty)
	{
		this(name, age, null, specialty);
	}

	public Doctor(String name, int age, String gender, String specialty)
	{
		super(name, age, gender);
		this.specialty = specialty;
	}

	public Doctor Print()
	{
		super.Print();
		Debug.log("Specialty: " + specialty);
		return this;
	}
}
