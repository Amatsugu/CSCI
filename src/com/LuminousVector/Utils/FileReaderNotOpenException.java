package com.LuminousVector.Utils;

import java.io.IOException;

public class FileReaderNotOpenException extends IOException
{
	public FileReaderNotOpenException()
	{
		super("File Reader has not been opened, or has been closed. Call OpenReader() to open.");
	}
}
