package LuminousVector.CSCI260.Projects.Project1;

import java.util.Calendar;

public class Patient
{
	private String _name;
	private String _id;
	private String _address;
	private int _height;
	private double _weight;
	private Date _dateOfBirth;
	private Date _dateOfInitialVisit;
	private Date _dateOfLastVisit;

	//Construct the patient
	public Patient(String name, String id, String address, int height, double weight, Date dateOfBirth, Date dateOfInitialVisit, Date dateOfLatVisit)
	{
		_name = name;
		_address = address;
		_height = height;
		_weight = weight;
		_dateOfBirth = dateOfBirth;
		_id = id;
		_dateOfInitialVisit = dateOfInitialVisit;
		_dateOfLastVisit = dateOfLatVisit;
	}

	public String getName()
	{
		return _name;
	}

	public String getId()
	{
		return _id;
	}

	public String getAddress()
	{
		return _address;
	}

	public int getHeight()
	{
		return _height;
	}

	public double getWeight()
	{
		return _weight;
	}

	public Date getDateOfBirth()
	{
		return _dateOfBirth;
	}

	public Date getDateOfInitialVisit()
	{
		return _dateOfInitialVisit;
	}

	public Date getDateOfLastVisit()
	{
		return _dateOfLastVisit;
	}

	public int getAge()
	{
		return Math.abs(_dateOfBirth.subtractYear(Calendar.getInstance().get(Calendar.YEAR)));
	}

	public int getTimeAsPatient()
	{
		return _dateOfLastVisit.subtractYear(_dateOfInitialVisit);
	}

	public int getTimeSinceLastVisit()
	{
		return Math.abs(_dateOfLastVisit.subtractYear(Calendar.getInstance().get(Calendar.YEAR)));
	}

	public String toString()
	{
		return _name + ":" + _id + ":" + _address + ":" + _height + ":" + _weight + ":" + _dateOfBirth + ":" + _dateOfInitialVisit + ":" + _dateOfLastVisit;
	}

	//Override the equals method to only test for the id
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Patient patient = (Patient) o;

		return _id.equals(patient._id);

	}

	//Override the hashcode to be based on the id
	@Override
	public int hashCode()
	{
		return _id.hashCode();
	}
}
