package LuminousVector.Utils;

import java.io.IOException;

public class FileWriterNotOpenException extends IOException
{
	public FileWriterNotOpenException()
	{
		super("File Writer has not been opened, or has been closed. Call OpenWriter() to open.");
	}
}
