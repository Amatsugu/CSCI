package LuminousVector.Tutoring.invest;

public class Cash implements Investment
{
	private double ammount;

	public Cash(double ammount)
	{
		this.ammount = ammount;
	}

	public double value()
	{
		return ammount;
	}

	public String toString()
	{
		return "Cash: $" + value();
	}
}
