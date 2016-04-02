package com.LuminousVector.CSCI260.Projects.Project1;

import java.io.IOException;

public class InvalidDataBaseException extends IOException
{
	public InvalidDataBaseException(int line)
	{
		super("The format of the database file is not formatted correctly on line: " + line);
	}

	public InvalidDataBaseException(String message)
	{
		super(message);
	}
}
