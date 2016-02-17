package com.LuminousVector.CSCI151.Excersies.ContactStore;

import com.LuminousVector.Utils.Debug;

import java.io.*;

public class ContactInfoApp
{
	private static BufferedReader contactFile;
	private static String path = "ContactInfo/contacts.dat";

	public static void main(String[] args)
	{
		try
		{
			contactFile = new BufferedReader(new FileReader(path));
		}catch(Exception e)
		{
			Debug.log("Failed to load file... \n" + e.getMessage());
		}
		String data = "";
		String line = null;
		do
		{
			try
			{
				line = contactFile.readLine();
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			if (line != null)
				data += line + "\n";
		}while (line != null);
		try
		{
			ContactInfo contacts= new ContactInfo(data);
			Debug.log("Output:\n" + contacts.getData());
		}catch (InvalidContactException contactException)
		{
			contactException.printStackTrace();
		}


	}
}
