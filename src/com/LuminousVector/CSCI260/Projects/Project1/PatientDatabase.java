package com.LuminousVector.CSCI260.Projects.Project1;

import com.LuminousVector.Utils.Console;
import com.LuminousVector.Utils.FileV;

import java.io.IOException;

public class PatientDatabase
{
	public LinkedList<Patient> patientList;

	//Construct the database with a new linked list
	public PatientDatabase()
	{
		patientList = new LinkedList<>();
	}

	//Get a patient based on id
	public Patient GetPatient(String id)
	{
		return patientList.find(id.hashCode()).getData();
	}

	//Remove a patient based on id
	public PatientDatabase RemovePatient(String id)
	{
		patientList.remove(id.hashCode());
		return this;
	}

	//Add a patient based on id
	public PatientDatabase AddPatient(Patient patient)
	{
		patientList.add(new LinkedNode<Patient>(patient));
		return this;
	}

	//Check if a patient exists based on id
	public boolean Contains(String id)
	{
		return patientList.contains(id.hashCode());
	}

	//Load a file into the database
	public void LoadFile(String path) throws IOException, InvalidDateFormatException
	{
		FileV file = new FileV(path); //Create an instance of the file handler
		String[] lines = file.OpenReader().ReadAllLines().split("\n"); //Open the file, read all lines and split on line breaks
		if(lines.length == 0)
			throw new InvalidDataBaseException("File is empty");
		int lineNumber = 1;
		for (String line : lines) //Iterate through each line and copy the patient data onto the database
		{
			if(line == lines[lines.length -1])
				break;
			String[] parts = line.split(":");
			if(parts.length != 8)
				throw new InvalidDataBaseException(lineNumber);
			Patient patient = new Patient(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), new Date(parts[5]), new Date(parts[6]), new Date(parts[7]));
			patientList.add(new LinkedNode<Patient>(patient));
			lineNumber++;
		}
		file.CloseReader(); //Close the file
	}


	//Save a file from the database
	public void SaveFile(String path) throws IOException
	{
		FileV file = new FileV(path); //Create an instance of the file handler
		file.OpenWriter(true); //Open the file, create if it doesn't exist
		LinkedNode<Patient> node = patientList.first;
		String[] lines = new String[patientList.size()];
		int curLine = 0;
		do //Traverse through all patients converting them to strings
		{
			Patient patient = node.getData();
			lines[curLine++] = patient.toString();
			node = node.next;
		}while (node != patientList.first);
		file.WriteAllLines(lines); //Write the lines containing the patient data to the file
		file.CloseWriter(true); //Close and flush the changes on the file
	}
}
