package com.LuminousVector.Excersies.Inheritance;

import com.LuminousVector.Projects.DoctorClass.Doctor;
import com.LuminousVector.Utils.Debug;

public class DoctorApp
{
	public static void main(String[] args)
	{
		Doctor karen = new Doctor("Karen", 28, "Female", "Dentist");
		Doctor renji = new Doctor("Renji", 32, "Male", "Pediatrician");
		Doctor karuta = new Doctor("Karuta", 21, "Female", "Obstetrician");
		karen.Print();
		Debug.log("");
		renji.Print();
		Debug.log("");
		karuta.Print();
	}
}
