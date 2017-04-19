package LuminousVector.CSCI260.Projects.Project1;

public class Date
{
	public int day;
	public int month;
	public int year;

	//Construct a data based on the string format dd/mm/yyyy
	public Date(String date) throws InvalidDateFormatException
	{
		String[] parts = date.split("/");
		if(parts.length != 3)
		{
			throw new InvalidDateFormatException();
		}else
		{
			day = Integer.parseInt(parts[0]);
			month = Integer.parseInt(parts[1]);
			year = Integer.parseInt(parts[2]);
		}
	}

	//Construct the date
	public Date(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}

	//Subtract the year based on another date
	public int subtractYear(Date date)
	{
		return subtractYear(date.year);
	}

	//Subtract a year based on another year
	public int subtractYear(int year)
	{
		return this.year - year;
	}

	//Convert the date to a string in format dd/mm/yyyy
	public String toString()
	{
		return day + "/" + month + "/" + year;
	}

}
