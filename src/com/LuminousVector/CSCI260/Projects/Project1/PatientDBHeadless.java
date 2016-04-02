package com.LuminousVector.CSCI260.Projects.Project1;

import com.LuminousVector.Utils.Console;
import com.LuminousVector.Utils.MathV;

import java.io.IOException;
import java.util.Scanner;

public class PatientDBHeadless
{
	private static PatientDatabase database;
	public static void Start()
	{
		database = new PatientDatabase();
		
		boolean quit = false;
		Scanner in = new Scanner(System.in);
		in.useDelimiter("\n");
		boolean filedLoaded = false;
		String file;
		while (!filedLoaded)
		{
			Console.log("Patient List File: ");
			file = in.next();
			try
			{
				database.LoadFile(file);
				filedLoaded = true;
				while(!quit)
				{
					quit = PrintMenu(in);
				}
				Console.log("Do you want to save the file? Y/N");
				String save = in.next();
				if(save.contains("y") || save.contains("Y"))
				{
					Console.log("Enter an output filename:");
					file = in.next();
					try
					{
						Console.log("Saving...");
						database.SaveFile(file);
						Console.log("Saved");
					} catch (IOException e)
					{
						Console.log("Failed to save file, aborting...");
					}
				}
				in.close();
			} catch (Exception e)
			{
				Console.log("Unable to load file, try again!");
			}
		}
	}

	//Print the main menu and read input
	private static boolean PrintMenu(Scanner in)
	{
		Console.log("1. List Patients");
		Console.log("2. Add a Patient");
		Console.log("3. Show Patient Info");
		Console.log("4. Delete a Patient");
		Console.log("5. Show Average Patient Age");
		Console.log("6. Show Youngest Patient");
		Console.log("7. Show Overdue Patients");
		Console.log("8. Quit");

		int choice = 0;
		try
		{
			choice = in.nextInt();
		} catch (Exception e)
		{
			Console.log("Invalid Input Try Again!");
			return false;
		}
		//choice = (choice <= 0) ? 1 : (choice > 8) ? 8 : choice;
		switch (choice)
		{
			case 1:
				PrintPatients();
				break;
			case 2:
				AddPatient(in);
				break;
			case 3:
				PrintPatientInfo(in);
				break;
			case 4:
				DeletePatient(in);
				break;
			case 5:
				PrintAveragePatientAge();
				break;
			case 6:
				PrintYoungestPatientInfo();
				break;
			case 7:
				PrintOverduePatients();
				break;
			case 8:
				Console.log("Quiting...");
				return true;
			default:
				Console.log("Invalid Choice, try again!");
				break;
		}
		return false;
	}

	//Print the names and id of all patients
	private static void PrintPatients()
	{
		Console.log("Patient List: ");
		LinkedNode<Patient> node, first;
		node = first =  database.patientList.first;
		do
		{
			Console.log(node.getData().getName() + ", " + node.getData().getId());
			node = node.next;
		}while (node != first);
		Console.log("---END---");
	}

	//Print all Patient data
	private static void PrintPatient(Patient data)
	{
		Console.log("Name: " + data.getName());
		Console.log("ID: " + data.getId());
		Console.log("Address: " + data.getAddress());
		Console.log("Height: " + data.getHeight());
		Console.log("Weight: " + data.getWeight());
		Console.log("Date of Birth: " + data.getDateOfBirth());
		Console.log("Initial Visit: " + data.getDateOfInitialVisit());
		Console.log("Last Visit: " + data.getDateOfLastVisit());
		if(data.getTimeSinceLastVisit() < 3)
			return;
		int overdue = (data.getTimeSinceLastVisit() - 2);
		Console.log("Overdue for Visit: " + ((overdue >= 1) ? "YES" : "NO") + ", " + overdue + " year" + ((overdue > 1) ? "s" : "") + " overdue");
		Console.log("---END---");
	}

	//Add a patient to the database
	private static void AddPatient(Scanner in)
	{
		Console.log("Enter patient information: ");
		Console.log("ID: ");
		String id = in.next();
		if(database.Contains(id)) //Prevent the addition of duplicate IDs
		{
			Console.log("A patient with that ID already exists:");
			PrintPatient(database.GetPatient(id));
			return;
		}
		Console.log("Name: ");
		String name = in.next();
		Console.log("Address: ");
		String address = in.next();
		Console.log("Height: ");
		int height = in.nextInt();
		Console.log("Weight: ");
		double weight = in.nextDouble();
		try
		{
			Console.log("Date of Birth: ");
			Date dateOfBirth = new Date(in.next());
			Console.log("Initial Visit: ");
			Date initialVisit = new Date(in.next());
			Console.log("Last Visit: ");
			Date lastVisit = new Date(in.next());
			Patient patient = new Patient(name, id, address, height, weight, dateOfBirth, initialVisit, lastVisit);
			database.AddPatient(patient);
			Console.log("Patient Added Successfully");
		} catch (InvalidDateFormatException e)
		{
			e.printStackTrace();
		}
	}

	//Print the info of a specified patient
	private static void PrintPatientInfo(Scanner in)
	{
		Console.log("Enter Patient ID: ");
		String id = in.next();
		if(database.Contains(id))
			PrintPatient(database.GetPatient(id));
		else
			Console.log("A patient with that ID does not exist.");
	}

	//Delete a specified patient
	private static void DeletePatient(Scanner in)
	{
		Console.log("Enter Patient ID: ");
		String id = in.next();
		if(database.Contains(id))
		{
			database.RemovePatient(id);
			Console.log("Patient Removed Successfully");
		}else
			Console.log("A patient with that ID does not exist.");
	}

	//Calculate the average age of all patients
	private static void PrintAveragePatientAge()
	{
		float totalAge = 0;
		LinkedNode<Patient> node, first;
		node = first = database.patientList.first;
		do
		{
			totalAge += node.getData().getAge();
			node = node.next;
		}while (node != first);
		Console.log("Average Patient Age: " + MathV.Round(totalAge/database.patientList.size(), 10));
		Console.log("---END---");
	}

	//Find and print the info of the youngest patient
	private static void PrintYoungestPatientInfo()
	{
		Patient youngest;
		LinkedNode<Patient> node, first;
		node = first = database.patientList.first;
		youngest = node.getData();
		do
		{
			if(node.getData().getAge() < youngest.getAge())
			{
				youngest = node.getData();
			}
			node = node.next;
		}while (node != first);
		Console.log("The Youngest Patient is: ");
		PrintPatient(youngest);
	}

	//Find and print a list of all patients overdue for a visit
	private static void PrintOverduePatients()
	{
		Console.log("Overdue Patients:");
		LinkedNode<Patient> node, first;
		node = first =  database.patientList.first;
		do
		{
			int overdue = (node.getData().getTimeSinceLastVisit() - 2);
			if(overdue >= 1)
			{
				Console.log(node.getData().getName() + ", " + node.getData().getId() + ", " + overdue +" year" + ((overdue > 1) ? "s" : "") + " overdue.");
			}
			node = node.next;
		}while (node != first);
		Console.log("---END---");
	}
}
